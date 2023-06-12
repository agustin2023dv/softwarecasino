package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Administrador extends Usuario implements Menu {

	private int idAdministrador;
	
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

			String nombre = rs.getString("nombre");
			String apellido = rs.getString("apellido");
			String direccion = rs.getString("direccion");
			String email = rs.getString("email");
			String fecNacimiento = rs.getString("fec_nacimiento");


			resultado += "Nombre: " + nombre + "\n";
			resultado += "Apellido: " + apellido + "\n";
			resultado += "Dirección: " + direccion + "\n";
			resultado += "Email: " + email + "\n";
			resultado += "Fecha de Nacimiento: " + fecNacimiento + "\n";
		} catch (Exception e) {
			System.out.println("Hubo un error: " + e.getMessage());
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

	public void mostrarMenu(int idAdm) {
		String[] opcionesAdminsitrador = { "Ver cliente", "Eliminar cliente", "Ver caja", "Eliminar juego",
				"Editar juego", "Editar datos cliente", "Salir" };
		String opcion;

		Validacion validacion = new Validacion();
		do {
			opcion = (String) JOptionPane.showInputDialog(null, "Eliga la accion que desea realizar", "Menu Administrador",
					JOptionPane.DEFAULT_OPTION, null, opcionesAdminsitrador, opcionesAdminsitrador);

			int id;

			switch (opcion) {
				case "Ver cliente":
					JOptionPane.showMessageDialog(null, "Eligió Visualizar Cliente");
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));

					if(validacion.validarExistenciaCliente(id)){
						JOptionPane.showMessageDialog(null, this.revisarCuentaCliente(id));}
					break;
				case "Eliminar cliente":
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
					if(validacion.validarExistenciaCliente(id)){
						this.eliminarUsuario(id);
						JOptionPane.showMessageDialog(null, "Se eliminó con éxito el cliente con ID: " + id);
					}

					break;
				case "Ver caja":
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Caja"));
					if(validacion.validarVerCaja(id)){
						JOptionPane.showMessageDialog(null, this.verCaja(id));}
					break;
				case "Eliminar juego":
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Juego"));

					JOptionPane.showMessageDialog(null, this.eliminarJuego(id));
					break;
				case "Editar juego":
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Juego"));
					String descripcion = JOptionPane.showInputDialog("Ingrese la descripción del Juego");
					int jugadoresMinimos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los jugadores mínimos del Juego"));
					int jugadoresMaximos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los jugadores máximos del Juego"));
					if (validacion.validarEditarJuego(descripcion, jugadoresMinimos, jugadoresMaximos, id)) {
						this.editarJuego(descripcion, jugadoresMaximos, id);
					}
					break;
				case "Editar datos cliente":
					id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del Cliente"));
					String email = JOptionPane.showInputDialog("Ingrese el correo del Cliente");
					String direccion = JOptionPane.showInputDialog("Ingrese la dirección del Cliente");
					if (validacion.validarActualizarCliente(email, direccion, id)) {
						this.actualizarCliente(email, direccion, id);
					}
					break;
				case "Salir":
					break;

				default:
					break;
			}

		} while (!opcion.equals("Salir"));
	}

}
