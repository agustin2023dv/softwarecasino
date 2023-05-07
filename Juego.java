import java.util.Random;
public class Juego {


    private int idJuego;
    private String nombre;
    private String descripcion;

    private Maquina maquina;
    private  int jugadoresMinimos;
    private int jugadoresMaximos;


    public Juego(int idJuego, String nombre, String descripcion, int jugadoresMinimos, int jugadoresMaximos, Maquina maquina) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.jugadoresMinimos = jugadoresMinimos;
        this.jugadoresMaximos = jugadoresMaximos;
        this.maquina = maquina;
    }


    public Juego(int idJuego, String nombre, String descripcion, int jugadoresMinimos, int jugadoresMaximos) {
        this.idJuego = idJuego;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.jugadoresMinimos = jugadoresMinimos;
        this.jugadoresMaximos = jugadoresMaximos;

    }

    public int getIdJuego() {
        return idJuego;
    }

    public void setIdJuego(int idJuego) {
        this.idJuego = idJuego;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getJugadoresMinimos() {
        return jugadoresMinimos;
    }

    public void setJugadoresMinimos(int jugadoresMinimos) {
        this.jugadoresMinimos = jugadoresMinimos;
    }

    public int getJugadoresMaximos() {
        return jugadoresMaximos;
    }

    public void setJugadoresMaximos(int jugadoresMaximos) {
        this.jugadoresMaximos = jugadoresMaximos;
    }



    public boolean generarResultado(){
            Random random  = new Random();

            boolean resultado = random.nextBoolean();

            return resultado;

    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }

    public Maquina getMaquina() {
        return maquina;
    }


}
