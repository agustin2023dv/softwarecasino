package UI;

import Datos.*;
import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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


		// FALTA AGREGARLE ALGO PARA QUE DESPUES DE UNOS SEGUNDOS SE CIERRE SOLO ANTES Q LO DEMAS SE ABRA
		ventana.dispose();


		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";
		ImageIcon iconoPreLogin = new ImageIcon(rutaImagenPreLogin);


		// LOGIN

		JPanel panelLogin = new JPanel();
		JFrame ventanaLogin;
		ventanaLogin = new JFrame("Log in");
		ventanaLogin.setSize(500, 300);
		ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaLogin.setLocationRelativeTo(null);

		JLabel labelNombreUsuario;
		JTextField textNombreUsuario;

		labelNombreUsuario = new JLabel("Nombre usuario");
		textNombreUsuario = new JTextField(10);


		ventanaLogin.setResizable(false);


		JLabel labelContrasena;
		JPasswordField textContrasena;
		labelContrasena = new JLabel("Contraseña");
		textContrasena = new JPasswordField(10);


		panelLogin.add(labelNombreUsuario);
		panelLogin.add(textNombreUsuario);
		panelLogin.add(labelContrasena);
		panelLogin.add(textContrasena);


		JButton btnLogin;
		Font fontBtnLogin = new Font("Arial", Font.BOLD, 14);

		btnLogin = new JButton("Iniciar sesion");
		btnLogin.setPreferredSize(new Dimension(150, 30));
		btnLogin.setFont(fontBtnLogin);
		btnLogin.setBackground(Color.orange);

		JPanel panelBoton = new JPanel();
		panelBoton.add(btnLogin);
		panelBoton.setSize(30, 30);
		panelLogin.add(panelBoton, BorderLayout.SOUTH);


		btnLogin.addActionListener(new ActionListener() {
			int intentosLogin = 0;


			@Override
			public void actionPerformed(ActionEvent e) {
				String nombre_usuario = textNombreUsuario.getText();
				String contrasena = new String(textContrasena.getPassword());

				if (validacion.verificarUsuario(nombre_usuario, contrasena)) {
					if (cliente.login(nombre_usuario, contrasena)) {
						cliente.mostrarMenu(nombre_usuario);
						ventanaLogin.dispose();
					} else if (adm.login(nombre_usuario, contrasena)) {
						adm.mostrarMenu(nombre_usuario);
						ventanaLogin.dispose();
					} else if (empCaja.login(nombre_usuario, contrasena)) {
						empCaja.mostrarMenu(nombre_usuario);
						ventanaLogin.dispose();
					} else if (tecnico.login(nombre_usuario, contrasena)) {
						tecnico.mostrarMenu(nombre_usuario);
						ventanaLogin.dispose();
					} else if (empMaquina.login(nombre_usuario, contrasena)) {
						empMaquina.mostrarMenu(nombre_usuario);
						ventanaLogin.dispose();
					}
				} else {
					// Usuario o contraseña incorrectos
					intentosLogin++;
					if (intentosLogin == 3) {
						JOptionPane.showMessageDialog(null, "Ha excedido el número máximo de intentos. Saliendo del programa.", "Error", JOptionPane.ERROR_MESSAGE);
						System.exit(0);
						ventanaLogin.dispose();
					}
				}
			}
		});


		ventanaLogin.add(panelLogin);

		ventanaLogin.setVisible(true);





	}}
