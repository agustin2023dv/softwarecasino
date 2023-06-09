
package Logica;

import Datos.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validacion {
    
//VALIDACIONES LOGIN

		public  boolean validacionLogin(int idUsuario, String contrasena) {
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
	
	public static boolean validarCargaDinero(double monto) {

		if (monto <= 0) {
			return false; // El monto debe ser mayor que cero
		}

		return true; // Si el monto es mayor a 0 retorna true
	}

	public static boolean validarRetiroDinero(Cliente cliente, double monto) {
		double dineroDisponible = cliente.getDineroDisponible();

		if (monto > dineroDisponible) {
			return false; // El cliente no tiene suficiente dinero disponible para realizar el retiro
		}

		return true; // El cliente tiene suficiente dinero disponible
	}

	public boolean validarJugar(int idJuego, double monto){

			double dineroDisponible ;


			if(monto<=0){
				return false;}
			else{
				return true;
			}
	}
	
//VALIDACIONES ADMINISTRADOR

	public boolean validarVerCaja(int idCaja){

			if(idCaja<=0 || idCaja>4){
				return false;
			}
			else{
				return true;
			}
	}

	public boolean validarEditarJuego (String descripcion, int jugadoresMinimos, int jugadoresMaximos, int idJuego) {

		if(jugadoresMinimos < 1 || jugadoresMaximos > 6) {
            System.out.println("La cantidad de jugadores mínimos debe ser mayor o igual a 1 y menor o igual a 6"); 
            return false;
		}else if (descripcion.length() < 10 || descripcion.length() > 100){
            System.out.println("La descripcion debe tener entre 10 y 100 caracteres"); 
			 return false;
		}else {
			return true;
		}
		
	}
	public boolean validarActualizarCliente (String email, String direccion, int idCliente) {
			Conexion con = new Conexion();


		if(idCliente<= 0 || idCliente >99 || email.equals("") || direccion.equals("")
			||	email.length() < 10 || email.length() > 30 || direccion.length() < 10 || direccion.length() > 30){

			return false;
		}
		else{
			try {
				Connection conexion = con.conectar();
				String sql = "SELECT count(*) " +
						"FROM usuario u INNER JOIN cliente c" +
						"ON u.id_usuario=c.id_usuario  WHERE c.id_usuario = ?";

				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, idCliente);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					int count = rs.getInt("count");
					return count > 0; // Devuelve true si el ID de usuario existe en la base de datos
				}
			} catch (Exception e) {
				System.out.println("Hubo un error: " + e.getMessage());
			}
			return true; // Devuelve false si ocurrió algún error o el ID de usuario no existe en la base de datos
		}
		}





	public boolean validarRevisarCtaCliente(int idUsuario) {

		Conexion con = new Conexion();

		if(idUsuario <= 0 || idUsuario >99 ){
			return false;
		}
		else{
			try {
				Connection conexion = con.conectar();
				String sql = "SELECT count(*) " +
						"FROM usuario u INNER JOIN cliente c" +
						"ON u.id_usuario=c.id_usuario  WHERE c.id_usuario = ?";

				PreparedStatement stmt = conexion.prepareStatement(sql);
				stmt.setInt(1, idUsuario);

				ResultSet rs = stmt.executeQuery();

				if (rs.next()) {
					int count = rs.getInt("count");
					return count > 0; // Devuelve true si el ID de usuario existe en la base de datos
				}
			} catch (Exception e) {
				System.out.println("Hubo un error: " + e.getMessage());
			}
			return true; // Devuelve false si ocurrió algún error o el ID de usuario no existe en la base de datos
	}
		}
	
//VALIDACIONES EMPLEADO CAJA 
	
	public boolean validarAgregarDinero (double montoAAgregar) {
		
		if(montoAAgregar >= 1) {
            return true;
		}else {
            return false;
		}	
	}
	
	public boolean validarEntregarDinero (double montoAEntregar, Cliente cliente) {

			double saldoDisponible = cliente.getDineroDisponible();

		if(montoAEntregar < 1 || montoAEntregar > saldoDisponible) {
            return true;
		}else {
            return false;
		}	
	}
    
}
