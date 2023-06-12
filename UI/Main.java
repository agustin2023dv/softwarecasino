package UI;

import Datos.Administrador;
import Datos.Cliente;
import Datos.EmpleadoCaja;
import Datos.EmpleadoMaquina;
import Datos.Tecnico;
import Logica.*;

import javax.swing.*;

class Main {

	public static void main(String[] args) {

		//CONEXION BD
		Validacion validacion = new Validacion();


		Administrador adm = new Administrador();
		Cliente cliente = new Cliente();
		EmpleadoCaja empCaja = new EmpleadoCaja();
		Tecnico tecnico = new Tecnico();
		EmpleadoMaquina empMaquina = new EmpleadoMaquina();



		// Pantalla de Bienvenida


		String rutaImagenInicio = "img/casinoInicio.jpg";

		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);

		JOptionPane.showMessageDialog(null, "Bienvenido al casino Jocker",
				"Casino Jocker", JOptionPane.PLAIN_MESSAGE, iconoInicio);



		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);


		// LOGIN
		int intentosLogin = 0;
		int idUsuario;


		do {
			idUsuario = Integer.parseInt(JOptionPane.showInputDialog(null, "ID de usuario:",
					"Ingrese su usuario", JOptionPane.PLAIN_MESSAGE));

			String contrasena = JOptionPane.showInputDialog(null, "Contraseña:",
					"Ingrese su contraseña", JOptionPane.PLAIN_MESSAGE);
			if (validacion.validacionLogin(idUsuario, contrasena)) {

				if (validacion.verificarCliente(idUsuario)) {
					cliente.mostrarMenu(idUsuario);
				} else if (validacion.verificarAdmin(idUsuario)) {
					adm.mostrarMenu(idUsuario);
				} else if (validacion.verificarECaja(idUsuario)) {
					empCaja.mostrarMenu(idUsuario);
				} else if (validacion.verificarTecnico(idUsuario)) {
					tecnico.mostrarMenu(idUsuario);
				} else if (validacion.verificarEMaquina(idUsuario)) {
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
