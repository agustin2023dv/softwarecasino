package UI;
import Logica.*;
import Datos.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main {

	private static Validacion validacion;
	private static Administrador adm;
	private static Cliente cliente;
	private static EmpleadoCaja empCaja;
	private static Tecnico tecnico;
	private static EmpleadoMaquina empMaquina;

	public static void main(String[] args) {
		validacion = new Validacion();
		adm = new Administrador();
		cliente = new Cliente();
		empCaja = new EmpleadoCaja();
		tecnico = new Tecnico();
		empMaquina = new EmpleadoMaquina();

		mostrarPantallaBienvenida();

				mostrarVentanaLogin();

	}



	private static void mostrarPantallaBienvenida() {
		JFrame ventana = new JFrame("Casino Jocker");
		ventana.setSize(400, 300);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLocationRelativeTo(null);

		JPanel panel = new JPanel();

		String rutaImagenInicio = "img/casinoInicio.jpg";
		ImageIcon iconoInicio = new ImageIcon(rutaImagenInicio);
		JLabel labelImagen = new JLabel(iconoInicio);
		JLabel labelMensaje = new JLabel("Bienvenido al casino Jocker");
		labelMensaje.setFont(new Font("Arial", Font.PLAIN, 24));

		panel.add(labelImagen);
		panel.add(labelMensaje);

		ventana.add(panel);
		ventana.setVisible(true);

		// FALTA AGREGARLE ALGO PARA QUE DESPUES DE UNOS SEGUNDOS SE CIERRE SOLO ANTES Q LO DEMAS SE ABRA
		ventana.dispose();
	}

	private static void mostrarVentanaLogin() {
		JPanel panelLogin = new JPanel();
		JFrame ventanaLogin = new JFrame("Log in");
		ventanaLogin.setSize(500, 300);
		ventanaLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaLogin.setLocationRelativeTo(null);

		JLabel labelNombreUsuario = new JLabel("Nombre usuario");
		JTextField textNombreUsuario = new JTextField(10);

		JLabel labelContrasena = new JLabel("Contraseña");
		JPasswordField textContrasena = new JPasswordField(10);

		panelLogin.add(labelNombreUsuario);
		panelLogin.add(textNombreUsuario);
		panelLogin.add(labelContrasena);
		panelLogin.add(textContrasena);

		JButton btnLogin = new JButton("Iniciar sesión");
		Font fontBtnLogin = new Font("Arial", Font.BOLD, 14);
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
	}




















		// Pantalla pre login . Seleccion de tipo de usuario

		String rutaImagenPreLogin = "img/userPreLogin.png";

	}
