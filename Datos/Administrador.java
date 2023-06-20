package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Administrador extends Usuario implements Menu {

	private int idAdministrador;
	private JFrame ventana;
    private JButton botonVerCliente;
    private JButton botonEliminarCliente;
    private JButton botonVerCaja;
    private JButton botonEliminarJuego;
    private JButton botonEditarJuego;
    private JButton botonEditarDatosCliente;
    private JPanel panel;
	
	public Administrador() {
		
	}
	
	public Administrador(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idAdministrador) {
		super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico);
		this.idAdministrador = idAdministrador;
	}

	// getters y setters

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	/* Metodos de usuario */

	public void editarJuego(String descripcion, int jugadoresMaximos, int idJuego) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();
			String sql = "UPDATE juego " +
					"SET descripcion = ?, jugadores_max = ? " +
					"WHERE id_juego = ?";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, descripcion);
			stmt.setInt(2, jugadoresMaximos);
			stmt.setInt(3, idJuego);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hubo un error: " + e.getMessage());
		}
	}

	// ACA DEBERIAMOS HACER UN COMBOBOX CON LOS CLIENTES Y LISTO

	public String revisarCuentaCliente(int idUsuario) {
	    String resultado = "";
	    Conexion con = new Conexion();

	    try {
	        Connection conexion = con.conectar();
	        String sql = "SELECT u.nombre, u.apellido, u.direccion, u.email, u.fec_nacimiento " +
	                "FROM usuario AS u INNER JOIN cliente AS c " +
	                "ON u.id_usuario = c.id_usuario " +
	                "WHERE u.id_usuario = ?";

	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idUsuario);

	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            String nombre = rs.getString("nombre");
	            String apellido = rs.getString("apellido");
	            String direccion = rs.getString("direccion");
	            String email = rs.getString("email");
	            String fecNacimiento = rs.getString("fec_nacimiento");

	            JFrame frame = new JFrame("Información cuenta cliente");
	            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	            frame.setSize(300, 200);
	            frame.setLocationRelativeTo(null);

	            JPanel panel = new JPanel();
	            panel.setLayout(new GridLayout(5, 2));

	            JLabel labelNombre = new JLabel("Nombre:");
	            JTextField textFieldNombre = new JTextField(nombre);
	            textFieldNombre.setEditable(false);

	            JLabel labelApellido = new JLabel("Apellido:");
	            JTextField textFieldApellido = new JTextField(apellido);
	            textFieldApellido.setEditable(false);

	            JLabel labelDireccion = new JLabel("Dirección:");
	            JTextField textFieldDireccion = new JTextField(direccion);
	            textFieldDireccion.setEditable(false);

	            JLabel labelEmail = new JLabel("Email:");
	            JTextField textFieldEmail = new JTextField(email);
	            textFieldEmail.setEditable(false);

	            JLabel labelFecNacimiento = new JLabel("Fecha de Nacimiento:");
	            JTextField textFieldFecNacimiento = new JTextField(fecNacimiento);
	            textFieldFecNacimiento.setEditable(false);

	            panel.add(labelNombre);
	            panel.add(textFieldNombre);
	            panel.add(labelApellido);
	            panel.add(textFieldApellido);
	            panel.add(labelDireccion);
	            panel.add(textFieldDireccion);
	            panel.add(labelEmail);
	            panel.add(textFieldEmail);
	            panel.add(labelFecNacimiento);
	            panel.add(textFieldFecNacimiento);

	            frame.add(panel);
	            frame.setVisible(true);
	        } else {
	            resultado = "No se encontró información de la cuenta del cliente.";
	        }

	        rs.close();
	        stmt.close();
	        conexion.close();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "Hubo un error: " + e.getMessage());
	        resultado = "Hubo un error al consultar la cuenta del cliente.";
	    }

	    return resultado;
	}

	public void eliminarUsuario(int idUsuario) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();
			String sql = "DELETE FROM usuario WHERE id_usuario = ?";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setLong(1, idUsuario);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Hubo un error: " + e.getMessage());
		}
	}

	public boolean eliminarJuego(int idJuego) {

		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();
			String sql = "DELETE FROM juego WHERE id_juego = ?";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setLong(1, idJuego);

			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Hubo un error: " + e.getMessage());
			return false;
		}
	}

	public boolean actualizarCliente(String email, String direccion, int idCliente) {
	    Conexion con = new Conexion();
	    try {
	        Connection conexion = con.conectar();
	        String sql = "UPDATE usuario AS u INNER JOIN cliente AS c " +
	                     "ON u.id_usuario = c.id_usuario " +
	                     "SET u.email = ?, u.direccion = ? " +
	                     "WHERE c.id_cliente = ?";

	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setString(1, email);
	        stmt.setString(2, direccion);
	        stmt.setInt(3, idCliente);
	        stmt.executeUpdate();
	        return true;
	    } catch (Exception e) {
	        System.out.println("Hubo un error: " + e.getMessage());
	        return false;
	    }
	}
	public String verCaja(int idCaja) {
	    double sumaMontos = 0.0;
	    Conexion con = new Conexion();

	    try {
	        Connection conexion = con.conectar();
	        String sql = "SELECT c.id_caja, SUM(tcc.monto) AS suma_montos " +
	                     "FROM caja AS c " +
	                     "LEFT JOIN transaccion_caja_cliente AS tcc ON c.id_caja = tcc.caja " +
	                     "LEFT JOIN transaccion_caja_empleado AS tce ON c.id_caja = tce.caja " +
	                     "WHERE c.id_caja = ? " +
	                     "GROUP BY c.id_caja";

	        PreparedStatement stmt = conexion.prepareStatement(sql);
	        stmt.setInt(1, idCaja);

	        ResultSet rs = stmt.executeQuery();

	    } catch (Exception e) {
	        System.out.println("Hubo un error: " + e.getMessage());
	    }
	    return "La caja " + idCaja + " tiene un saldo de " + sumaMontos;
	}

	public boolean login(String nombreUsuario, String contrasena){

		Conexion con = new Conexion();

		try (Connection conexion = con.conectar()) {
			String sql = "SELECT COUNT(*) FROM usuario u " +
					"LEFT JOIN empleado e ON u.id_usuario = e.id_usuario " +
					"WHERE u.nombre_usuario = ? AND u.contrasena = ? " +
					"AND e.tipo_empleado = 4";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, nombreUsuario);
			stmt.setString(2, contrasena);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);

				if (count > 0) {
					return true; // Existe un usuario con el ID y contraseña proporcionados y es EMaquina
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Hubo un error al validar el login: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return false;


	}


	public void mostrarMenu(String idAdm) {
		String[] opcionesAdministrador = {"Ver cliente", "Eliminar cliente", "Ver caja", "Eliminar juego",
                "Editar juego", "Editar datos cliente", "Salir"};

        ventana = new JFrame("Administrador");
        ventana.setSize(400, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        botonVerCliente = new JButton("Ver cliente");
        botonEliminarCliente = new JButton("Eliminar cliente");
        botonVerCaja = new JButton("Ver caja");
        botonEliminarJuego = new JButton("Eliminar juego");
        botonEditarJuego = new JButton("Editar juego");
        botonEditarDatosCliente = new JButton("Editar datos cliente");

        panel = new JPanel();
        panel.add(botonVerCliente);
        panel.add(botonEliminarCliente);
        panel.add(botonVerCaja);
        panel.add(botonEliminarJuego);
        panel.add(botonEditarJuego);
        panel.add(botonEditarDatosCliente);

        ventana.add(panel);
        ventana.setVisible(true);

        Validacion validacion = new Validacion();

        botonVerCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
                if (validacion.validarExistenciaCliente(idCliente)) {
                    JOptionPane.showMessageDialog(null, revisarCuentaCliente(idCliente));
                }
            }
        });

        botonEliminarCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
                if (validacion.validarExistenciaCliente(idCliente)) {
                    eliminarUsuario(idCliente);
                    JOptionPane.showMessageDialog(null, "Se eliminó con éxito el cliente con ID: " + idCliente);
                }
            }
        });

        botonVerCaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idCaja = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Caja"));
                if (validacion.validarVerCaja(idCaja)) {
                    JOptionPane.showMessageDialog(null, verCaja(idCaja));
                }
            }
        });

        botonEliminarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idJuego = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Juego"));
                if (validacion.validarEliminarJuego(idJuego)) {
                    eliminarJuego(idJuego);
                    JOptionPane.showMessageDialog(null, "El juego ha sido eliminado con éxito");
                }
            }
        });

        botonEditarJuego.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idJuego = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Juego"));
                String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del Juego");
                int jugadoresMinimos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los jugadores mínimos del Juego"));
                int jugadoresMaximos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los jugadores máximos del Juego"));

                if (validacion.validarEditarJuego(descripcion, jugadoresMinimos, jugadoresMaximos)) {
                    editarJuego(descripcion, jugadoresMaximos, idJuego);
                }
            }
        });

        botonEditarDatosCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idCliente = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
                String email = JOptionPane.showInputDialog("Ingrese el correo del Cliente");
                String direccion = JOptionPane.showInputDialog("Ingrese la dirección del Cliente");
            	System.out.println(idCliente + direccion + email);
               // if (validacion.validarActualizarCliente(email, direccion, idCliente)) {

                    actualizarCliente(email, direccion, idCliente);
                //}
            }
        }); 
	}

}
