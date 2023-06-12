package Datos;

import Interface.Menu;
import Logica.Validacion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
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
	
	public String repararMaquina(int id) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();
			String sql = "SELECT * FROM maquina WHERE id_maquina = ?";
            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
			
            if (rs.next()) {  
				Maquina maquina = new Maquina(id, rs.getInt("saldoTickets"),
						rs.getBoolean("daniada"), rs.getBoolean("habilitada"));
                
            	if (rs.getBoolean("daniada")) {
            		maquina.reparar();
            		return "La maquina se encuentra dañada. Reparación exitosa.";
            	} else{
            		return "La maquina no se encuentra dañada.";							
				} 
          	
			} else {
				return "No se encontró la máquina con ID: " + id;
			}
            
            
		} catch (Exception e) {
        	return "Hubo un error: " + e.getMessage();
        }
	}
	

    public String encenderMaquina(int id) {
        Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();

	            String sql = "SELECT * FROM maquina WHERE id_maquina = ?";
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {  
					Maquina maquina = new Maquina(id, rs.getInt("saldoTickets"),
							rs.getBoolean("daniada"), rs.getBoolean("habilitada"));
	                
	            	if (rs.getBoolean("daniada")) {
	            		return "La maquina se encuentra dañada, no se puede encender.";
	            	} else if (rs.getBoolean("habilitada")){
	            		return "La maquina ya se encuentra encendida.";							
					} else {
						maquina.encender();
						return "Encendiendo Maquina.";
					}
	          	
				} else {
					return "No se encontró la máquina con ID: " + id;
				}
            
        } catch (Exception e) {
        	return "Hubo un error: " + e.getMessage();
        }
    }
    
    
    public String apagarMaquina(int id) {
        Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();

	            String sql = "SELECT * FROM maquina WHERE id_maquina = ?";
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            ResultSet rs = stmt.executeQuery();
	            
	            if (rs.next()) {  
					Maquina maquina = new Maquina(id, rs.getInt("saldoTickets"),
							rs.getBoolean("daniada"), rs.getBoolean("habilitada"));
	                
	            	if (rs.getBoolean("habilitada")) {
	            		maquina.apagar();
	            		return "La maquina se encuentra encendida. Apagado exitoso.";
	            	} else{
	            		return "La maquina ya se encuentra apagada.";							
					} 
	          	
				} else {
					return "No se encontró la máquina con ID: " + id;
				}
            
        } catch (Exception e) {
        	return "Hubo un error: " + e.getMessage();
        }
    }

    //menu
    
	public void mostrarMenu(int id) {
		String[] opcionesTecnico = {"Reparar Maquina", "Encender Maquina", "Apagar Maquina", "Salir"};
		String opcion;
		
		JOptionPane.showMessageDialog(null, "Ingreso como Tecnico");
		Validacion validacion = new Validacion();
		do {
			
			opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado Tecnico", "Opcion",
					JOptionPane.DEFAULT_OPTION, null, opcionesTecnico, opcionesTecnico);
			switch (opcion) {
			
			case "Reparar Maquina":
				int idmaquina;
				JOptionPane.showMessageDialog(null, "Eligió Reparar Máquina");
				idmaquina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Maquina"));
				String reparar = this.repararMaquina(idmaquina);
				JOptionPane.showMessageDialog(null, reparar);	
				break;
				
			case "Encender Maquina":
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina a encender"));
				String encender = this.encenderMaquina(idmaquina);
				JOptionPane.showMessageDialog(null, encender);
				break;
				
			case "Apagar Maquina":
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina a apagar"));
				String apagar = this.apagarMaquina(idmaquina);
				JOptionPane.showMessageDialog(null, apagar);
				break;	
				
			case "Salir":
				
				break;
			default:
				break;
			}
		} while(!opcion.equals("Salir"));

	}
	
}
