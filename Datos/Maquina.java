package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Maquina {
	
	private int idMaquina;

	private boolean daniada;
	private boolean habilitada;


		
	//constructor
	
	public Maquina() {
		
	}
	
	
	public Maquina(int idMaquina, boolean daniada, boolean habilitada) {
        this.idMaquina = idMaquina;
        this.daniada = daniada;
        this.habilitada = habilitada;
    }
	
	// Metodos
	
	public void reparar() {
		Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();
            String sql = "UPDATE maquina SET daniada = ? WHERE id_maquina = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, this.idMaquina);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
        }
	}
	
	public void encender() {
        Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();
            String sql = "UPDATE maquina SET habilitada = ? WHERE id_maquina = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setBoolean(1, true);
            stmt.setInt(2, this.idMaquina);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
        }
	}
	
	public void apagar() {
		Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();
            String sql = "UPDATE maquina SET habilitada = ? WHERE id_maquina = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setBoolean(1, false);
            stmt.setInt(2, this.idMaquina);
            stmt.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
        }
	}

	
	
	//setters y getters
	
	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}





	public boolean getDaniada() {
		return daniada;
	}

	public void setDaniada(boolean daniada) {
		this.daniada = daniada;
	}

	public boolean getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}





}
