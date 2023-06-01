package Datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;


public class Cliente extends Usuario {
    private int idCliente;
    private int cantPartidasJugadas;

    private double dineroDisponible;




    public Cliente(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion,
                   String correoElectronico, int idCliente, double dineroDisponible) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = dineroDisponible;
    }

    public Cliente(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion,
                   String correoElectronico, int idCliente) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico);
        this.idCliente = idCliente;
        this.dineroDisponible = 0;
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


    // Metodos del cliente

    public void solicitarAsistencia(){

        System.out.print("En unos instantes un asistente lo auxiliará. Gracias.");
    }

    public boolean jugar(Juego juego, double apuesta) {
        boolean jugo = true;
        Conexion con = new Conexion();

        if (apuesta > this.dineroDisponible) {
            jugo = false;
            return jugo;
        } else {
            boolean resultado = juego.generarResultado();

            if (resultado) {
                this.dineroDisponible += apuesta * 4;
            } else {
                juego.getMaquina().setSaldoTickets((int) (juego.getMaquina().getSaldoTickets() + apuesta));
            }

            // Registrar la partida en la base de datos

            try {
                Connection conexion = con.conectar();
                String sql = "INSERT INTO partida (id_juego, id_usuario, apuesta, resultado) VALUES (?, ?, ?, ?)";

                PreparedStatement stmt = conexion.prepareStatement(sql);
                stmt.setInt(1, juego.getIdJuego());
                stmt.setInt(2, this.getIdUsuario());
                stmt.setDouble(3, apuesta);
                stmt.setBoolean(4, resultado);
                stmt.executeUpdate();
            } catch (Exception e) {
                System.out.println("Hubo un error al registrar la partida: " + e.getMessage());
            }

            return jugo;
        }
    }



}
