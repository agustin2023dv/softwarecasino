
package Logica;

import Datos.Administrador;
import Datos.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validacion {
    
//VALIDACIONES LOGIN

		public static boolean validacionLogin(int idUsuario, String contrasena) {
			// Validar el ID de usuario
			if (idUsuario < 0 || idUsuario > 99) {
				return false; // El ID de usuario debe estar entre 0 y 99
			}

			// Validar la contraseña
			int longitudContrasena = contrasena.length();
			if (longitudContrasena < 6 || longitudContrasena > 15) {
				return false; // La contraseña debe tener entre 6 y 15 caracteres
			}

			// Realizar la consulta a la base de datos
			Conexion con = new Conexion();
			Connection conexion = null;

			try {
				conexion = con.conectar();
				String sql = "SELECT COUNT(*) FROM usuario WHERE id_usuario = ? AND contrasena = ?";

				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, idUsuario);
				stmt.setString(2, contrasena);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					int count = rs.getInt(1);

					if (count > 0) {
						return true; // Existe un usuario con el ID y contraseña proporcionados
					}
				}
			} catch (SQLException e) {
				System.out.println("Hubo un error al validar el login: " + e.getMessage());
			} finally {
				// Cerrar la conexión y liberar recursos
				if (conexion != null) {
					try {
						conexion.close();
					} catch (SQLException e) {
						System.out.println("Error al cerrar la conexión: " + e.getMessage());
					}
				}
			}

			return false; // No se encontró un usuario con el ID y contraseña proporcionados
		}






   
//VALIDACIONES CLIENTE

	public String validarCargarDinero (int monto) {
		
		if(monto > 0) {
            return "Todo bien";
		}else {
            return "El monto a cargar no puede ser menor a 0";
		}	
	}
	
	public String validarRetirarDinero (double dineroDisponible, int monto) {
		
		if(dineroDisponible >= monto) {
            return "Todo bien";
		}else {
            return "El monto a retirar debe ser mayor al dinero disponible";
		}	
	}
	
//VALIDACIONES ADMINISTRADOR
	
	public String validarEditarJuego (String descripcion, int jugadoresMinimos, int jugadoresMaximos, int idJuego) {
    	int tamanioDescripcion=descripcion.length();
		if(tamanioDescripcion < 10 || tamanioDescripcion > 100) {
            return "La descripcion debe tener entre 10 y 100 caracteres";
		}else if (jugadoresMinimos < 1 && jugadoresMaximos > 6){
            return "La cantidad de jugadores mínimos debe ser mayor o igual a 1 y menor o igual a 6";
		}else {
            return "Todo bien";	
		}	
	}
	
//VALIDACIONES EMPLEADO CAJA 
	
	public String validarAgregarDinero (double montoAAgregar) {
		
		if(montoAAgregar >= 1) {
            return "Todo bien";
		}else {
            return "El monto a agregar debe ser igual o mayor a 1";
		}	
	}
	
	public String validarEntregarDinero (double montoAEntregar, double saldoActual) {
		
		if(montoAEntregar < 1 || montoAEntregar > saldoActual) {
            return "El monto a entregar debe ser mayor a 1 y menor al saldo actual de la caja";
		}else {
            return "Todo bien";
		}	
	}
    
}
