
package Logica;

import Datos.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validacion {
    
//VALIDACIONES LOGIN

		public  boolean validacionLogin(int idUsuario, String contrasena) {
			// Validar el ID de usuario


			if (idUsuario < 0 || idUsuario > 99) {
				JOptionPane.showMessageDialog(null,"El usuario debe ser un numero entre 1 y 99","Error",
						JOptionPane.ERROR_MESSAGE);
				return false; // El ID de usuario debe estar entre 0 y 99
			}

			// Validar la contraseña
			int longitudContrasena = contrasena.length();
			if (longitudContrasena < 6 || longitudContrasena > 15) {
				JOptionPane.showMessageDialog(null,"La contraseña debe tener entre 6 y 15 caracteres","Error",
						JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"Hubo un error al validar el login: " + e.getMessage(),"Error",
						JOptionPane.ERROR_MESSAGE);
			} finally {
				// Cerrar la conexión y liberar recursos
				if (conexion != null) {
					try {
						conexion.close();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: " + e.getMessage(),"Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

			return false; // No se encontró un usuario con el ID y contraseña proporcionados
		}



	public boolean verificarCliente(int idUsuario) {
		// Consulta para verificar si es un cliente
		String consultaCliente = "SELECT * FROM cliente WHERE id_usuario = ?";

		try {
			// Crear la conexión y preparar la consulta
			Connection conexion = Conexion.conectar();
			PreparedStatement statementCliente = conexion.prepareStatement(consultaCliente);

			// Establecer el parámetro en la consulta
			statementCliente.setInt(1, idUsuario);

			// Ejecutar la consulta y obtener el resultado
			ResultSet resultSetCliente = statementCliente.executeQuery();

			// Verificar si hay algún resultado
			boolean esCliente = resultSetCliente.next();

			// Cerrar la conexión y liberar recursos
			resultSetCliente.close();
			statementCliente.close();
			conexion.close();

			// Devolver el resultado de la verificación
			return esCliente;
		} catch (SQLException e) {
			// Manejar cualquier error de SQL aquí
			e.printStackTrace();
			return false;
		}
	}


	public boolean verificarAdmin(int idUsuario) {
		// Consulta para verificar si es un cliente
		String consultaAdmin = "SELECT * FROM empleado WHERE id_usuario = ? and tipo_empleado = 4";


		try {
			// Crear la conexión y preparar la consulta
			Connection conexion = Conexion.conectar();
			PreparedStatement statementAdmin = conexion.prepareStatement(consultaAdmin);

			// Establecer el parámetro en la consulta
			statementAdmin.setInt(1, idUsuario);

			// Ejecutar la consulta y obtener el resultado
			ResultSet resultSetAdmin = statementAdmin.executeQuery();

			// Verificar si hay algún resultado
			boolean esAdmin = resultSetAdmin.next();

			// Cerrar la conexión y liberar recursos
			resultSetAdmin.close();
			statementAdmin.close();
			conexion.close();

			// Devolver el resultado de la verificación
			return esAdmin;
		} catch (SQLException e) {
			// Manejar cualquier error de SQL aquí
			e.printStackTrace();
			return false;
		}
	}


//VALIDACIONES CLIENTE

	public boolean validarCargaDinero(int idCliente, double monto){

			if(idCliente>0 && idCliente<100 && monto>0){
				return true;
			}
			else{
				return false;
			}

	}

	public boolean validarRetiroDinero(int idCliente, double monto) {
			Cliente cliente = new Cliente();

			double dineroDisponible = cliente.getDineroDisponible(idCliente);

		if (monto > dineroDisponible) {
			return false; // El cliente no tiene suficiente dinero disponible para realizar el retiro
		}

		return true; // El cliente tiene suficiente dinero disponible
	}

	public boolean validarJugar(double monto, int idCliente){
		Cliente cliente = new Cliente();

		double dineroDisponible = cliente.getDineroDisponible(idCliente);

			if(monto<=0 || dineroDisponible<monto){
				return false;}
			else{
				return true;
			}
	}


	
//VALIDACIONES ADMINISTRADOR

	public boolean validarVerCaja(int idCaja){

			if(idCaja<=0 || idCaja>4){
				JOptionPane.showMessageDialog(null,
						"La caja " + idCaja + " no existe o no tiene transacciones.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else{

				return true;
			}
	}

	public boolean validarEditarJuego (String descripcion, int jugadoresMinimos, int jugadoresMaximos) {


		if(jugadoresMinimos < 1 || jugadoresMaximos > 6) {
			JOptionPane.showMessageDialog(null,"La cantidad de jugadores mínimos debe ser mayor o igual a 1 y menor o igual a 6"
					,"Error",JOptionPane.ERROR_MESSAGE);
            return false;
		}else if (descripcion.length() < 10 || descripcion.length() > 100){
			JOptionPane.showMessageDialog(null,"La descripcion debe tener entre 10 y 100 caracteres",
					"Error",JOptionPane.ERROR_MESSAGE);
			 return false;
		}else {
			return true;
		}

	}



	public boolean validarEliminarJuego(int idJuego){

			if(idJuego<0 || idJuego>50){
				return false;
			}
			else {
				return true;
			}

	}

	public boolean validarActualizarCliente (String email, String direccion, int idCliente) {

		if(idCliente<= 0 || idCliente >99 || email.equals("") || direccion.equals("")
			||	email.length() < 10 || email.length() > 30 || direccion.length() < 10 || direccion.length() > 30){

			return false;
		}
		else{
			return true;
		}

		}



	public boolean validarExistenciaCliente(int idUsuario) {

		if(idUsuario <= 0 || idUsuario >99 ){
			JOptionPane.showMessageDialog(null,
					"El ID del Usuario debe ser un numero entre 1 y 99", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else{
			return true;
	}
		}



//VALIDACIONES EMPLEADO CAJA 

// FALTA CORREGIR NOMBRE DE VARIABLES EN EL METODO
	public boolean verificarECaja(int idUsuario){

		// Consulta para verificar si es un empleado caja
		String consultaEmpleado = "SELECT * FROM empleado WHERE tipo_empleado = 1 AND id_usuario = ?";

		try {
			// Crear la conexión y preparar la consulta
			Connection conexion = Conexion.conectar();
			PreparedStatement statementEmpleado = conexion.prepareStatement(consultaEmpleado);

			// Establecer el parámetro en la consulta
			statementEmpleado.setInt(1, idUsuario);

			// Ejecutar la consulta y obtener el resultado
			ResultSet resultSetAdmin = statementEmpleado.executeQuery();

			// Verificar si hay algún resultado
			boolean esAdmin = resultSetAdmin.next();

			// Cerrar la conexión y liberar recursos
			resultSetAdmin.close();
			statementEmpleado.close();
			conexion.close();

			// Devolver el resultado de la verificación
			return esAdmin;
		} catch (SQLException e) {
			// Manejar cualquier error de SQL aquí
			e.printStackTrace();
			return false;
		}

	}
	public boolean validarAgregarDinero (double montoAAgregar, int idCaja) {

		if(montoAAgregar > 0 && idCaja >0 && idCaja<4) {
            return true;
		}else {
            return false;
		}	
	}
	

// Validaciones Tecnico
	
	public boolean verificarTecnico(int idUsuario){

		// Consulta para verificar si es un Tecnico
		String consultaTecnico = "SELECT * FROM empleado WHERE tipo_empleado = 2 AND id_usuario = ?";

		try {
			// Crear la conexión y preparar la consulta
			Connection conexion = Conexion.conectar();
			PreparedStatement statementTecnico = conexion.prepareStatement(consultaTecnico);

			// Establecer el parámetro en la consulta
			statementTecnico.setInt(1, idUsuario);

			// Ejecutar la consulta y obtener el resultado
			ResultSet resultSetTecnico = statementTecnico.executeQuery();

			// Verificar si hay algún resultado
			boolean esTecnico = resultSetTecnico.next();

			// Cerrar la conexión y liberar recursos
			resultSetTecnico.close();
			statementTecnico.close();
			conexion.close();

			// Devolver el resultado de la verificación
			return esTecnico;
		} catch (SQLException e) {
			// Manejar cualquier error de SQL aquí
			e.printStackTrace();
			return false;
		}

	}
	
	
// Validaciones Empleado Maquina

	public boolean verificarEMaquina(int idUsuario){

		// Consulta para verificar si es un empleado maquina
		String consultaEMaquina = "SELECT * FROM empleado WHERE tipo_empleado = 3 AND id_usuario = ?";

		try {
			// Crear la conexión y preparar la consulta
			Connection conexion = Conexion.conectar();
			PreparedStatement statementEMaquina = conexion.prepareStatement(consultaEMaquina);

			// Establecer el parámetro en la consulta
			statementEMaquina.setInt(1, idUsuario);

			// Ejecutar la consulta y obtener el resultado
			ResultSet resultSetEMaquina = statementEMaquina.executeQuery();

			// Verificar si hay algún resultado
			boolean esEMaquina = resultSetEMaquina.next();

			// Cerrar la conexión y liberar recursos
			resultSetEMaquina.close();
			statementEMaquina.close();
			conexion.close();

			// Devolver el resultado de la verificación
			return esEMaquina;
		} catch (SQLException e) {
			// Manejar cualquier error de SQL aquí
			e.printStackTrace();
			return false;
		}

	}

	public boolean validarExistenciaMaquina(int idMaquina){
		Conexion con = new Conexion();

		try {
			Connection conexion = con.conectar();
			String sql = "SELECT  count(*) as count " +
					"FROM maquina WHERE id_maquina = ?";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idMaquina);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0; //
			}
			else{
				JOptionPane.showMessageDialog(null,
						"No se encontro la maquina con ID "+idMaquina, "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Hubo un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		return false;
	}
    
}
