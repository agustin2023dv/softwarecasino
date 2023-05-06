import java.util.List;


public class Maquina {
    private int idMaquina;
    private Juego juego;
    private int saldoTickets;
    private boolean prendido;

    private boolean habilitada;

    private boolean daniada;

    public Maquina(int idMaquina, Juego juego, int saldoTickets, boolean prendido) {
        this.idMaquina = idMaquina;
        this.juego = juego;
        this.saldoTickets = saldoTickets;
        this.prendido = prendido;
        this.habilitada = true;
        this.daniada = false;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public Juego getJuego() {
        return juego;
    }

    public void setJuegos(Juego juego) {
        this.juego = juego;
    }

    public double getSaldoTickets() {
        return saldoTickets;
    }

    public void setSaldo(int saldoTickets) {
        this.saldoTickets = saldoTickets;
    }

    public boolean getPrendido() {
        return prendido;
    }

    public void setPrendido(boolean prendido) {
        this.prendido = prendido;
    }



    public void apagar(){
        this.prendido = false;
    }

    public void prender(){
        this.prendido = true;
    }

    public boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public boolean getDaniada() {
        return daniada;
    }

    public void setDaniada(boolean daniada) {
        this.daniada = daniada;
    }
}
