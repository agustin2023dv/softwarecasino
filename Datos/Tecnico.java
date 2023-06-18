package Datos;

import Interface.Menu;
import Logica.Validacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class Tecnico extends Empleado implements Menu {
	
	private int idTecnico;

	public Tecnico(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idEmpleado, String puesto) {
		super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico, idEmpleado, puesto);
	}

	public Tecnico(){
		
	}
	
	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	//metodos
	
	public boolean repararMaquina(int id) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();

			String sql = "UPDATE maquina SET daniada = false WHERE id_maquina = ?;";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);



		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un error: " + e.getMessage());
			return false;
		}
		return true;
	}


	public boolean encenderMaquina(int id) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();

			String sql = "UPDATE maquina SET habilitada = true WHERE id_maquina = ?;";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);



		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un error: " + e.getMessage());
			return false;
		}
		return true;
	}


	public boolean apagarMaquina(int id) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();

			String sql = "UPDATE maquina SET habilitada = false WHERE id_maquina = ?;";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);



		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un error: " + e.getMessage());
			return false;
		}
		return true;
	}

    //MENU

	public boolean login(int id, String contrasena){

		Conexion con = new Conexion();

		try (Connection conexion = con.conectar()) {
			String sql = "SELECT COUNT(*) FROM usuario u " +
					"LEFT JOIN empleado e ON u.id_usuario = e.id_usuario " +
					"WHERE u.id_usuario = ? AND u.contrasena = ? " +
					"AND e.tipo_empleado = 2";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);
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
    
	public void mostrarMenu(int id) {
		String[] opcionesTecnico = {"Reparar Maquina", "Encender Maquina", "Apagar Maquina", "Salir"};
		String opcion;
		
		JOptionPane.showMessageDialog(null, "Ingresó como Tecnico");
		Validacion validacion = new Validacion();
		do {
			
			opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado Tecnico", "Opcion",
					JOptionPane.DEFAULT_OPTION, null, opcionesTecnico, opcionesTecnico);
			switch (opcion) {
			
			case "Reparar Maquina":
				int idmaquina;
				JOptionPane.showMessageDialog(null, "Eligió Reparar Máquina");
				idmaquina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Maquina"));

				if(validacion.validarExistenciaMaquina(idmaquina)){
					this.repararMaquina(idmaquina);
					JOptionPane.showMessageDialog(null,"La maquina numero "+idmaquina+ " ha sido reparada exitosamente",
							"Reparacion exitosa",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Encender Maquina":
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina a encender"));

				if(validacion.validarExistenciaMaquina(idmaquina)){
					this.encenderMaquina(idmaquina);
					JOptionPane.showMessageDialog(null,"La maquina numero "+idmaquina+" ha sido encendida exitosamente",
							"Encendido exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				break;
				
			case "Apagar Maquina":
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina a apagar"));

				if(validacion.validarExistenciaMaquina(idmaquina)){
					this.apagarMaquina(idmaquina);
					JOptionPane.showMessageDialog(null,"La maquina numero "+idmaquina+" ha sido apagada exitosamente",
							"Apagado exitoso",JOptionPane.INFORMATION_MESSAGE);
				}
				break;	
				
			case "Salir":
				
				break;
			default:
				break;
			}
		} while(!opcion.equals("Salir"));

	}
	
}
