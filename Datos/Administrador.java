package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Administrador extends Usuario{

	private int idAdministrador;

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

			if (rs.next()) {
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
			} else {
				resultado = "No se encontró ningún cliente con el ID de usuario proporcionado.";
			}
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
			String sql = "SELECT c.id_caja, SUM(tcc.monto) AS suma_montos FROM caja AS c INNER JOIN transaccion_caja_cliente AS tcc ON " +
					"c.id_caja = tcc.caja WHERE c.id_caja = ? " +
					"GROUP BY c.id_caja";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idCaja);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				sumaMontos = rs.getDouble("suma_montos");
			}
		} catch (Exception e) {
			System.out.println("Hubo un error: " + e.getMessage());
		}

		return "La caja " + idCaja + " tiene un saldo de " + sumaMontos;
	}

}