package casino;

public class Maquina {
	
	private int idMaquina;
	private Juego juego;
	private double apuestasRecibidas;
	private int saldoTickets;
	private boolean daniada;
	private boolean habilitada;
		
	//constructor
	
	public Maquina(int idMaquina, double apuestasRecibidas, int saldoTickets) {
        this.idMaquina = idMaquina;
        this.apuestasRecibidas = apuestasRecibidas;
        this.saldoTickets = saldoTickets;
        this.habilitada = true;
        this.daniada = false;
    }
	
	// Verificar Saldo
	
	public int verificarSaldo() {
		return saldoTickets;
	}
	
	// Encender
	
	public void encender() {
		this.habilitada = true;
	}
	
	// Apagar
	
	public void apagar() {
		this.habilitada = false;
	}

	
		
	//setters y getters
	
	public int getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(int idMaquina) {
		this.idMaquina = idMaquina;
	}

	public Juego getJuego() {
		return juego;
	}

	public void setJuego(Juego juego) {
		this.juego = juego;
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

	public boolean isDaniada() {
		return daniada;
	}

	public void setDaniada(boolean daniada) {
		this.daniada = daniada;
	}

	public boolean isHabilitada() {
		return habilitada;
	}

	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}


	
	
}