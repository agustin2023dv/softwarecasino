package UI;

import Datos.Administrador;
import Datos.Cliente;
import Datos.Conexion;
import Datos.EmpleadoCaja;
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


		Administrador adm = new Administrador();
		Cliente cliente = new Cliente();
		EmpleadoCaja empCaja = new EmpleadoCaja();

		// INICIO


		String []opcionesAdminsitrador = {"Ver cliente","Eliminar cliente",
				"Ver caja", "Eliminar juego",
				"Editar juego","Editar datos cliente", "Salir"};
		
		String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Retirar Tickets", "Recargar Tickets", "Logout"};
		
		String[] opcionesTecnico = {"Reparar Maquina", "Habilitar Maquina", "Deshabilitar Maquina", "Logout"};
		
		String opcion;

		// Pantalla de Bienvenida


		String rutaImagenInicio = "img/casinoInicio.jpg";

		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);

		JOptionPane.showMessageDialog(null, "Bienvenido al casino Jocker",
				"Casino Jocker", JOptionPane.PLAIN_MESSAGE, iconoInicio);


		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);


		// LOGIN
		int idUsuario;

		idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "ID de usuario:"));

		String contrasena = JOptionPane.showInputDialog(null,"Contraseña:");


		// Verificamos el tipo de usuario que es
		String consultaEmpleado = "SELECT * FROM empleado as e INNER JOIN usuario as u WHERE e.id_usuario = ?";

		if(validacion.validacionLogin(idUsuario,contrasena)){

			if(validacion.verificarCliente(idUsuario)){
				cliente.mostrarMenu(idUsuario);
			}
			else if(validacion.verificarAdmin(idUsuario)){
				adm.mostrarMenu(idUsuario);}
			else if(validacion.verificarECaja(idUsuario)){
				empCaja.mostrarMenu(idUsuario);
			}

		} else {
			// Usuario o contraseña incorrectos
			JOptionPane.showMessageDialog(null,
					"Credenciales incorrectas. Por favor, inténtelo de nuevo.", "Error", JOptionPane.ERROR_MESSAGE);

		}



		// Iconos: Pulgar arriba , Pulgar abajo, Gracias por jugar

			String rutaImagenGano= "img/thumbs-up.png";
			ImageIcon iconoGano = new ImageIcon(rutaImagenGano);

			String rutaImagenPerdio= "img/thumbs-down.png";
			ImageIcon iconoPerdio = new ImageIcon(rutaImagenPerdio);


			String rutaGracias= "img/graciasPorJugar.png";
			ImageIcon iconoGracias = new ImageIcon(rutaGracias);


	}}
