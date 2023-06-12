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
    
    
    public String recargarTicketsMaquina(int id, int saldoTickets) {
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
				
				int nuevoSaldoTickets= rs.getInt("saldoTickets") + saldoTickets;
				maquina.setSaldoTickets(nuevoSaldoTickets);
				maquina.actualizarSaldoTickets();
                
				return "Se han agregado " + saldoTickets + "." + "\nEl total ahora es de " + nuevoSaldoTickets + ".";
          	
			} else {
				return "No se encontró la máquina con ID: " + id;
			}
    		
    		
    	} catch (Exception e) {
    		return "Hubo un error: " + e.getMessage();
    	}
    }
    
    
    public String retirarTicketsMaquina(int id, int saldoTickets) {
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
				
				if (rs.getInt("saldoTickets") > saldoTickets) {
					
				
					int nuevoSaldoTickets= rs.getInt("saldoTickets") - saldoTickets;
					maquina.setSaldoTickets(nuevoSaldoTickets);
					maquina.actualizarSaldoTickets();
		            
					return "Se han agregado " + saldoTickets + "." + "\nEl total ahora es de " + nuevoSaldoTickets + ".";
				} else { 
					return "No se pueden retirar " + saldoTickets + " tickets." + "\nHay " + rs.getInt("saldoTickets") + "tickets.";
				}
				
			} else {
				return "No se encontró la máquina con ID: " + id;
			}
    		
    		
    	} catch (Exception e) {
    		return "Hubo un error: " + e.getMessage();
    	}
    }

    
    
    
    
    
    
    // Menu
    
    public void mostrarMenu(int id){
        String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Retirar Tickets", "Recargar Tickets", "Salir"};

        String opcion;

        JOptionPane.showMessageDialog(null, "Ingreso como Empleado Máquina");
        Validacion validacion = new Validacion();
		do {
			
			opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado Maquina", "Opcion",
					JOptionPane.DEFAULT_OPTION, null, opcionesEMaquina, opcionesEMaquina);
			int idmaquina;
			switch (opcion) {
			
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
			
			case "Retirar Tickets": 
				int retirarSaldoTickets;
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina"));
				retirarSaldoTickets = Integer.parseInt( JOptionPane.showInputDialog("Ingrese la cantidad de tickets a retirar."));
				if (validacion.validarTickets(retirarSaldoTickets)) {
					String retirarTickets = this.retirarTicketsMaquina(idmaquina, retirarSaldoTickets);
					JOptionPane.showMessageDialog(null, retirarTickets);
				}	
				break;
			
			case "Recargar Tickets":
				int agregarSaldoTickets;
				idmaquina = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el ID de la Maquina"));
				agregarSaldoTickets = Integer.parseInt( JOptionPane.showInputDialog("Ingrese la cantidad de tickets a agregar."));
				if (validacion.validarTickets(agregarSaldoTickets)) {
					String agregarTickets = this.recargarTicketsMaquina(idmaquina, agregarSaldoTickets);
					JOptionPane.showMessageDialog(null, agregarTickets);
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
