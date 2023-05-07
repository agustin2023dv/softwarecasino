

import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

class Main {

	public static void main(String[] args) {

		
		
		// Clientes

		Cliente cliente1 = new Cliente("1", "nombre1", "apellido1", new Date(06 - 05 - 2023), "12341",
				"mail1@gmail.com", "1", 1000.00);
		Cliente cliente2 = new Cliente("2", "nombre2", "apellido2", new Date(06 - 05 - 2023), "12342",
				"mail2@gmail.com", "2", 1000.00);
		Cliente cliente3 = new Cliente("3", "nombre3", "apellido3", new Date(06 - 05 - 2023), "12343",
				"mail3@gmail.com", "3", 1000.00);
		Cliente cliente4 = new Cliente("4", "nombre4", "apellido4", new Date(06 - 05 - 2023), "12344",
				"mail4@gmail.com", "4", 1000.00);
		Cliente cliente5 = new Cliente("5", "nombre5", "apellido5", new Date(06 - 05 - 2023), "12345",
				"mail5@gmail.com", "5", 1000.00);

		// Administrador

		Administrador admin1 = new Administrador("6", "nombre6", "apellido6", new Date(06 - 05 - 2023), "12346",
				"mail6@gmail.com", 1);
		Administrador admin2 = new Administrador("7", "nombre7", "apellido7", new Date(06 - 05 - 2023), "12347",
				"mail7@gmail.com", 2);
		Administrador admin3 = new Administrador("8", "nombre8", "apellido8", new Date(06 - 05 - 2023), "12348",
				"mail8@gmail.com", 3);

		// Empleado caja

		EmpleadoCaja empleadoCaja1 = new EmpleadoCaja("9", "nombre9", "apellido9", new Date(06 - 05 - 2023), "12349",
				"mail9@gmail.com", "1", "Caja", 1);
		EmpleadoCaja empleadoCaja2 = new EmpleadoCaja("10", "nombre10", "apellido10", new Date(06 - 05 - 2023),
				"123410", "mail10@gmail.com", "2", "Caja", 2);
		EmpleadoCaja empleadoCaja3 = new EmpleadoCaja("11", "nombre11", "apellido11", new Date(06 - 05 - 2023),
				"123411", "mail11@gmail.com", "3", "Caja", 3);

		// Empleado tecnico

		Tecnico tecnico1 = new Tecnico("12", "nombre12", "apellido12", new Date(06 - 05 - 2023), "123412",
				"mail12@gmail.com", "4", "Tecnico", 1);
		Tecnico tecnico2 = new Tecnico("13", "nombre13", "apellido13", new Date(06 - 05 - 2023), "123413",
				"mail13@gmail.com", "5", "Tecnico", 2);
		Tecnico tecnico3 = new Tecnico("14", "nombre14", "apellido14", new Date(06 - 05 - 2023), "123414",
				"mail14@gmail.com", "6", "Tecnico", 3);

		// Empleado maquina

		EmpleadoMaquina empleadoMaquina1 = new EmpleadoMaquina("15", "nombre15", "apellido15", new Date(06 - 05 - 2023),
				"123415", "mail15@gmail.com", "7", "Maquina", "1");
		EmpleadoMaquina empleadoMaquina2 = new EmpleadoMaquina("16", "nombre16", "apellido16", new Date(06 - 05 - 2023),
				"123416", "mail16@gmail.com", "8", "Maquina", "2");
		EmpleadoMaquina empleadoMaquina3 = new EmpleadoMaquina("17", "nombre17", "apellido17", new Date(06 - 05 - 2023),
				"123417", "mail17@gmail.com", "9", "Maquina", "3");

		// Array de todos los usuarios

		ArrayList<Usuario> usuarioEjemplo = new ArrayList<Usuario>();

		usuarioEjemplo.add(cliente1);
		usuarioEjemplo.add(cliente2);
		usuarioEjemplo.add(cliente3);
		usuarioEjemplo.add(cliente4);
		usuarioEjemplo.add(cliente5);
		usuarioEjemplo.add(admin1);
		usuarioEjemplo.add(admin2);
		usuarioEjemplo.add(admin3);
		usuarioEjemplo.add(empleadoCaja1);
		usuarioEjemplo.add(empleadoCaja2);
		usuarioEjemplo.add(empleadoCaja3);
		usuarioEjemplo.add(tecnico1);
		usuarioEjemplo.add(tecnico2);
		usuarioEjemplo.add(tecnico3);
		usuarioEjemplo.add(empleadoMaquina1);
		usuarioEjemplo.add(empleadoMaquina2);
		usuarioEjemplo.add(empleadoMaquina3);
		
		//Juegos
		
		//Juego juego1 = new Juego(1, "juego1", "descripcion1", 1, 6);
		
		//-------------------------------------------------------------------------------------------------------------
		

		// PROYECTO

		JOptionPane.showMessageDialog(null, "Bienvenido a Proyecto Jocker");

		String[] opciones = { "Cliente", "Empleado", "Administrador" };
		int choice = JOptionPane.showOptionDialog(null, "Seleccione su Usuario", "Selección de Usuario",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[2]);

		// botones de usuario
		if (choice == 0) { // cliente
			
			JOptionPane.showMessageDialog(null, "Eligio Cliente");
			
			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Cliente) {
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los Clientes pueden iniciar sesión por este sistema.");

			}
			
		} else if (choice == 1) { // empleado
		
			JOptionPane.showMessageDialog(null, "Eligio Empleado");
			
			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Empleado) {
				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");
			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los Empleados pueden iniciar sesión por este sistema.");

			}
			
			
			
			
		} else if (choice == 2) { // admin


			String nombreIngresado = JOptionPane.showInputDialog("Ingrese su nombre:");
			String contrasena = JOptionPane.showInputDialog("Ingrese su contraseña:");
			Usuario actual = null;

			for (Usuario usuario : usuarioEjemplo) {

				if (usuario.getNombre().equalsIgnoreCase(nombreIngresado)
						&& usuario.getContrasena().equalsIgnoreCase(contrasena)) {
					actual = usuario;
				}

			}

			if (actual == null) {

				JOptionPane.showMessageDialog(null, "El usuario o la password ingresado es incorrecto.");

			} else if (actual instanceof Administrador) { 

				JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso.");

				// CHOICE ADMIN
				boolean continuar = true;

					while (continuar) {

					String[] opcionesAdministrador = { "Caja", "Juego", "Maquina", "Usuario", "Visualizar Cliente",
							"Logout" };
					int choiceAdministrador = JOptionPane.showOptionDialog(null, "Seleccione su Usuario",
							"Selección de Usuario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
							null, opcionesAdministrador, opcionesAdministrador[5]);

					if (choiceAdministrador == 0) {
						JOptionPane.showMessageDialog(null, "Eligio Caja");

					} else if (choiceAdministrador == 1) {
						

						JOptionPane.showMessageDialog(null, "Eligio Juego");

						String[] opcionesAdministradorJuego = { "Eliminar Juego", "Editar Juego",
								"Regresar" };
						int choiceAdministradorJuego = JOptionPane.showOptionDialog(null, "Seleccione su Usuario",
								"Selección de Usuario", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
								null, opcionesAdministradorJuego, opcionesAdministradorJuego[2]);
						
						// CHOICE ADMIN JUEGO
						if (choiceAdministradorJuego == 0) {
							JOptionPane.showMessageDialog(null, "Eligio Eliminar Juego");
						} else if (choiceAdministradorJuego == 1) {
							JOptionPane.showMessageDialog(null, "Eligio Editar Juego");
						} else if (choiceAdministradorJuego == 2) {
							JOptionPane.showMessageDialog(null, "Eligio Regresar");

						} else {
							JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
						}

						if (choiceAdministradorJuego == 3) {
							continuar = true;
						}
						
						
					} else if (choiceAdministrador == 2) {
						JOptionPane.showMessageDialog(null, "Eligio Maquina");
						
						
					} else if (choiceAdministrador == 3) {
						JOptionPane.showMessageDialog(null, "Eligio Usuario");
					} else if (choiceAdministrador == 4) {
						JOptionPane.showMessageDialog(null, "Eligio Visualizar Cliente");
					} else if (choiceAdministrador == 5) {
						JOptionPane.showMessageDialog(null, "Eligio Logout");
						continuar = false;
					} else {
						JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
						continuar = false;
					}

					}
					

			} else {

				JOptionPane.showMessageDialog(null,
						"Lo siento, solo los administradores pueden iniciar sesión por este sistema.");

			}

			// aca termina admin
		} else { // cerro la app
			JOptionPane.showMessageDialog(null, "Acaba de cerrar la app");
		}

	}
}