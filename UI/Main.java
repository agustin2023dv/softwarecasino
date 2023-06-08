package UI;

import Datos.Conexion;
import Logica.*;

import Logica.Validacion.*;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.SQLException;

class Main {

	public static void main(String[] args) {

		//CONEXION BD
		Connection conexion = Conexion.conectar();
		Validacion validacion = new Validacion();


		// INICIO



		// MENUES
		String []opcionesCliente = {"Ver perfil","Jugar","Agregar dinero",
				"Retirar dinero","Salir"};

		String []opcionesAdminsitrador = {"Ver cliente","Eliminar cliente",
				"Ver caja", "Eliminar juego",
				"Editar juego","Editar datos cliente", "Salir"};
		
		String []opcionesECaja = {"Agregar dinero", "Entregar dinero", "Logout"};
		
		String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Retirar Tickets", "Recargar Tickets", "Logout"};
		
		String[] opcionesTecnico = {"Reparar Maquina", "Habilitar Maquina", "Deshabilitar Maquina", "Logout"};


		// Pantalla de Bienvenida


		String rutaImagenInicio = "img/casinoInicio.jpg";

		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);

		JOptionPane.showMessageDialog(null, "Bienvenido al casino Jocker",
				"Casino Jocker", JOptionPane.PLAIN_MESSAGE, iconoInicio);


		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);


		// LOGIN
		String idUsuario = JOptionPane.showInputDialog(null,"Id usuario:");
		String contrasena = JOptionPane.showInputDialog(null,"Contraseña:");



		// Verificamos si existe
		String consultaUsuario = "SELECT * FROM usuario WHERE id_usuario = ? AND contrasena = ?";

		// Verificamos el tipo de usuario que es

		String consultaCliente = "SELECT * FROM cliente as c INNER JOIN usuario as u WHERE c.id_usuario = ?";
		String consultaAdministrador = "SELECT * FROM administrador as a INNER JOIN usuario as u WHERE a.id_usuario = ?";
		String consultaEmpleado = "SELECT * FROM empleado as e INNER JOIN usuario as u WHERE e.id_usuario = ?";



		try {


			PreparedStatement statementUsuario = conexion.prepareStatement(consultaUsuario);
			statementUsuario.setString(1,idUsuario);
			statementUsuario.setString(2, contrasena);

			ResultSet resultSetUsuario = statementUsuario.executeQuery();

			if (resultSetUsuario.next()) {
				// Usuario y contraseña válidos, redireccionar al menú correspondiente

				// Verificar si es un cliente
				PreparedStatement statementCliente = conexion.prepareStatement(consultaCliente);
				statementCliente.setString(1, idUsuario);
				ResultSet resultSetCliente = statementCliente.executeQuery();

				if (resultSetCliente.next()) {
					// Es un cliente, mostrar el menú de cliente

				}

				// Verificar si es un administrador
				PreparedStatement statementAdministrador = conexion.prepareStatement(consultaAdministrador);
				statementAdministrador.setString(1, idUsuario);
				ResultSet resultSetAdministrador = statementAdministrador.executeQuery();


				if (resultSetAdministrador.next()) {
					// Es un administrador, mostrar el menú de administrador

				}

				// Verificar si es un empleado
				PreparedStatement statementEmpleado = conexion.prepareStatement(consultaEmpleado);
				statementEmpleado.setString(1, idUsuario);
				ResultSet resultSetEmpleado = statementEmpleado.executeQuery();


				if (resultSetEmpleado.next()) {
					// Es un empleado, mostrar el menú de empleado

				}

				// Cerrar los resultados y declaraciones
				resultSetCliente.close();
				resultSetAdministrador.close();
				resultSetEmpleado.close();

				statementCliente.close();
				statementAdministrador.close();
				statementEmpleado.close();


			} else {
				// Usuario o contraseña incorrectos
				JOptionPane.showMessageDialog(null,
						"Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);

			}

			// Cerrar los resultados y declaraciones
			resultSetUsuario.close();
			statementUsuario.close();
		} catch (SQLException e) {
			// Manejo de la excepción SQLException
			System.out.println("Error al ejecutar la consulta: " + e.getMessage());
		}



		// Iconos: Pulgar arriba , Pulgar abajo, Gracias por jugar

			String rutaImagenGano= "img/thumbs-up.png";
			ImageIcon iconoGano = new ImageIcon(rutaImagenGano);

			String rutaImagenPerdio= "img/thumbs-down.png";
			ImageIcon iconoPerdio = new ImageIcon(rutaImagenPerdio);


			String rutaGracias= "img/graciasPorJugar.png";
			ImageIcon iconoGracias = new ImageIcon(rutaGracias);


	}}
