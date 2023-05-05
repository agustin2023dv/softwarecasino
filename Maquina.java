package casino;

import java.util.ArrayList;

public class Maquina {
	
	private int idMaquina;
	private ArrayList<Maquina> Juego = new ArrayList<Maquina>();
	private double apuestasRecibidas;
	private int saldoTickets;
	private boolean estado;
	
	//constructor
	
	public Maquina(int idMaquina, double apuestasRecibidas, int saldoTickets, boolean estado) {
        this.idMaquina = idMaquina;
        this.apuestasRecibidas = apuestasRecibidas;
        this.saldoTickets = saldoTickets;
        this.estado = estado;
    }

	
	
	
	
	//setters y getters
	
	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public double getApuestasRecibidas() {
		return apuestasRecibidas;
	}

	public void setApuestasRecibidas(double apuestasRecibidas) {
		this.apuestasRecibidas = apuestasRecibidas;
	}

	public int getSaldoTickets() {
		return saldoTickets;
	}

	public void setSaldoTickets(int saldoTickets) {
		this.saldoTickets = saldoTickets;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
