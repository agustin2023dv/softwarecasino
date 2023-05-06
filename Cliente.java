import java.util.Date;

public class Cliente extends Usuario{

    private String idCliente;
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


  public void jugar(Maquina maquina, double apuesta){
        boolean resultado;

        resultado = maquina.getJuego().generarResultado();

        if(resultado){
            this.dineroDisponible += apuesta*4;
        }
        else{
            maquina.setSaldoTickets((int) (maquina.getSaldoTickets() + Math.round(apuesta)));
        }
  }



   public void cargarDineroOnline(double monto){

        this.dineroDisponible += monto;
   }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getDineroDisponible() {
        return dineroDisponible;
    }

    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }
}
