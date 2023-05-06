import java.util.Random;
public class Juego {


    private int idJuego;
    private String nombre;
    private String descripcion;

    private  int jugadoresMinimos;
    private int jugadoresMaximos;



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



}
