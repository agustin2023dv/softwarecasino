package Logica;

import java.util.Date;



public class Cliente extends Usuario {
    private int idCliente;
    private int cantPartidasJugadas;

    private double dineroDisponible;




    public Cliente(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                   String correoElectronico, int idCliente, double dineroDisponible) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = dineroDisponible;
    }





    public void solicitarAsistencia(){

        System.out.print("En unos instantes un asistente lo auxiliará. Gracias.");
    }


  public boolean jugar(Juego juego, double apuesta){

        boolean jugo = true;

        if(apuesta>this.dineroDisponible){
            jugo = false;
           return jugo;
        }
        else{

        boolean resultado;

        resultado = juego.generarResultado();

            if(resultado){
                this.dineroDisponible += apuesta*4;
                return jugo;
            }
            else{
                juego.getMaquina().setSaldoTickets((int) (juego.getMaquina().getSaldoTickets() + apuesta));
                return  jugo;
            }
        }
  }



   public void cargarDineroOnline(double monto){

        this.dineroDisponible += monto;
   }


    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
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
    
    public void retirarDinero(double monto){
        this.dineroDisponible -= monto;
    }

}
