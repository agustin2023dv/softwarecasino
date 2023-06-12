package Datos;

import Interface.Menu;
import Logica.Validacion;

import java.util.Date;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoMaquina extends Empleado implements Menu{

    private int idEmpleadoMaquina;

    public EmpleadoMaquina(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idEmpleado, String puesto) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico, idEmpleado, puesto);
    }


    public EmpleadoMaquina() {
		
	}


	public int getIdEmpleadoMaquina() {
        return idEmpleadoMaquina;
    }

    public void setIdEmpleadoMaquina(int idEmpleadoMaquina) {
        this.idEmpleadoMaquina = idEmpleadoMaquina;
    }

    
    // Metodos
    
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
    
    
    // Menu
    
    public void mostrarMenu(int id){
        String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Salir"};

        String opcion;

        Validacion validacion = new Validacion();
		do {
			
			opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado Maquina", "Menu empleado maquina",
					JOptionPane.DEFAULT_OPTION, null, opcionesEMaquina, opcionesEMaquina);
			int idmaquina;
			switch (opcion) {
			
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
