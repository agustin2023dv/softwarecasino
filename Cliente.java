import java.util.Date;



public class Cliente extends Usuario {
    private String idCliente;
    private int cantPartidasJugadas;

    private double dineroDisponible;




    public Cliente(String idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                   String correoElectronico, String idCliente, double dineroDisponible) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = dineroDisponible;
    }





    public void solicitarAsistencia(){

        System.out.print("En unos instantes un asistente lo auxiliará. Gracias.");
    }


  public void jugar(Juego juego, double apuesta){
        boolean resultado;

        resultado = juego.generarResultado();

        if(resultado){
            this.dineroDisponible += apuesta*4;
        }
        else{
            juego.getMaquina().setSaldoTickets((int) (juego.getMaquina().getSaldoTickets() + apuesta));

        }
  }



   public void cargarDineroOnline(double monto){

        this.dineroDisponible += monto;
   }


    public Cliente(String idUsuario, String nombre, String apellido, Date fecNacimiento,
                   String contrasena, String correoElectronico) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico);

        this.idCliente = idCliente;
        this.cantPartidasJugadas = cantPartidasJugadas;
        this.dineroDisponible = dineroDisponible;

    }


    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }


    public int getCantPartidasJugadas() {
        return cantPartidasJugadas;
    }

    public void setCantPartidasJugadas(int cantPartidasJugadas) {
        this.cantPartidasJugadas = cantPartidasJugadas;
    }


    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }



    public void cargarSaldoOnline(double monto){


        this.dineroDisponible += monto;


    }

    public void solicitarCargarDinero(EmpleadoCaja empleado, double monto){

        empleado.agregarDinero(monto);
        this.dineroDisponible += monto;
    }



}
