
public class Maquina {
	
	private int idMaquina;
	private Juego juego;
	private int saldoTickets;
	private boolean daniada;
	private boolean habilitada;
		
	//constructor
	
	public Maquina(int idMaquina, int saldoTickets, Juego juego) {
        this.idMaquina = idMaquina;
        this.saldoTickets = saldoTickets;
        this.habilitada = true;
        this.daniada = false;
		this.juego = juego;
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


	public int getSaldoTickets() {
		return saldoTickets;
	}

	public void setSaldoTickets(int saldoTickets) {
		this.saldoTickets = saldoTickets;
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