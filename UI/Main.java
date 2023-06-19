package UI;

import Datos.*;
import Logica.*;

import javax.swing.*;
import java.awt.*;

class Main {

	public static void main(String[] args) {

		 JFrame ventana;
		 JLabel labelMensaje;
		Validacion validacion = new Validacion();


		Administrador adm = new Administrador();
		Cliente cliente = new Cliente();
		EmpleadoCaja empCaja = new EmpleadoCaja();
		Tecnico tecnico = new Tecnico();
		EmpleadoMaquina empMaquina = new EmpleadoMaquina();



		// Pantalla de Bienvenida


		String rutaImagenInicio = "img/casinoInicio.jpg";

		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);

		ventana = new JFrame("Casino Jocker");
		ventana.setSize(400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		JLabel labelImagen = new JLabel(iconoInicio);
		labelMensaje = new JLabel("Bienvenido al casino Jocker");
		labelMensaje.setFont(new Font("Arial", Font.PLAIN, 24));

		panel.add(labelImagen);
		panel.add(labelMensaje);

		ventana.add(panel);
		ventana.setVisible(true);




		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);


		// LOGIN
		int intentosLogin = 0;



		do {

			String	idUsuario = JOptionPane.showInputDialog(null, "Nombre de usuario:",
					"Ingrese su usuario", JOptionPane.PLAIN_MESSAGE);

			String contrasena = JOptionPane.showInputDialog(null, "Contraseña:",
					"Ingrese su contraseña", JOptionPane.PLAIN_MESSAGE);

			if (validacion.verificarUsuario(idUsuario, contrasena)) {

				if (cliente.login(idUsuario,contrasena)) {
					cliente.mostrarMenu(idUsuario);

				} else if (adm.login(idUsuario,contrasena)) {

					adm.mostrarMenu(idUsuario);
				} else if (empCaja.login(idUsuario,contrasena)) {

					empCaja.mostrarMenu(idUsuario);
				} else if (tecnico.login(idUsuario,contrasena)) {

					tecnico.mostrarMenu(idUsuario);
				} else if (empMaquina.login(idUsuario,contrasena)) {

					empMaquina.mostrarMenu(idUsuario);
				}

			} else {
				// Usuario o contraseña incorrectos
				JOptionPane.showMessageDialog(null,
						"Credenciales incorrectas. Por favor, inténtelo de nuevo. Le quedan "
								+(2-intentosLogin)+" intentos", "Error", JOptionPane.ERROR_MESSAGE);
				intentosLogin++;
			}
		} while (intentosLogin < 3);





	}}
