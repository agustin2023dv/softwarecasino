package Datos;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Date;


public class Cliente extends Usuario {
    private int idCliente;
    private int cantPartidasJugadas;

    private double dineroDisponible;
   
	public Cliente() {
			
	}
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


    public void setDineroDisponible(double dineroDisponible) {
        this.dineroDisponible = dineroDisponible;
    }



    // Metodos del cliente

    public String getHistorialPartidas(int idCliente) {

        Conexion con = new Conexion();
        StringBuilder historial = new StringBuilder();

        try  {
            Connection conexion = con.conectar();

            String sql = "SELECT p.fecha, j.nombre, p.monto_apostado, p.resultado " +
                    "FROM partida AS p " +
                    "INNER JOIN juego AS j ON p.juego = j.id_juego " +
                    "WHERE p.cliente = ? " +
                    "ORDER BY p.fecha DESC";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idCliente);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String fecha = rs.getString("fecha");
                String nombreJuego = rs.getString("nombre");
                double montoApostado = rs.getDouble("monto_apostado");
                int resultado = rs.getInt("resultado");

                historial.append("Fecha: ").append(fecha).append("\n");
                historial.append("Juego: ").append(nombreJuego).append("\n");
                historial.append("Monto Apostado: ").append(montoApostado).append("\n");
                historial.append("Resultado: ").append(resultado).append("\n");
                historial.append("------------------------\n");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
            return "Hubo un error al obtener el historial de partidas.";
        }

        return historial.toString();
    }





    public double getDineroDisponible() {
        Conexion con = new Conexion();
        double dineroDisponible = 0;

        try {
            Connection conexion = con.conectar();

            String sql = "SELECT SUM(tcc.monto) + SUM(p.monto_apostado) AS total_monto\n" +
                    "FROM transaccion_caja_cliente tcc\n" +
                    "INNER JOIN cliente c ON tcc.cliente = c.id_cliente\n" +
                    "INNER JOIN partida p ON p.cliente = c.id_cliente\n" +
                    "INNER JOIN movimiento_caja_apuesta mca ON mca.partida = p.id_partida\n" +
                    "WHERE c.id_cliente = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, this.getIdCliente());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dineroDisponible = rs.getDouble("total_monto");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        }

        return dineroDisponible;
    }


    public void cargarSaldoOnline(double monto){
        Conexion con = new Conexion();

        int caja = (int) (Math.random() * 4);
        int tipoTransaccion = 1;
        Date fecha = new Date();

        try {
            Connection conexion = con.conectar();
            String sql = "INSERT INTO transaccion_caja_cliente(monto, tipo_transaccion, cliente, fecha, caja) VALUES (?, ?, ?, ?,?)";

            PreparedStatement stmt = conexion.prepareStatement(sql);

            stmt.setDouble(1, monto);
            stmt.setInt(2, tipoTransaccion);
            stmt.setInt(3, this.getIdCliente());
            stmt.setDate(4, (java.sql.Date) fecha);
            stmt.setInt(5, caja);

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transaccion: " + e.getMessage());
        }
    }

    public void retirarDinero(double monto) {
        Conexion con = new Conexion();

        int cajaAleatoria = (int) (Math.random() * 4);
        int tipoTransaccion = 0;
        Date fecha = new Date();
        monto = monto * (-1);

        try {
            Connection conexion = con.conectar();
            String sql = "INSERT INTO transaccion_caja_cliente (monto, tipo_transaccion, cliente, fecha, caja) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement stmt = conexion.prepareStatement(sql);

            stmt.setDouble(1, monto);
            stmt.setInt(2, tipoTransaccion);
            stmt.setInt(3, this.getIdCliente());
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));
            stmt.setInt(5, cajaAleatoria);

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al registrar la transacción: " + e.getMessage());
            // Puedes considerar registrar el error en un archivo de registro
        }
    }

    public String verCuenta(int idUsuario) {
        String infoCuenta = "";
        Conexion con = new Conexion();

        try {
            Connection conexion = con.conectar();
            String sql = "SELECT u.nombre, u.apellido, u.direccion, u.email, u.fec_nacimiento " +
                    "FROM usuario AS u INNER JOIN cliente AS c " +
                    "ON u.id_usuario = c.id_usuario " +
                    "WHERE u.id_usuario = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, idUsuario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String direccion = rs.getString("direccion");
                String email = rs.getString("email");
                String fecNacimiento = rs.getString("fec_nacimiento");

                infoCuenta += "Nombre: " + nombre + "\n";
                infoCuenta += "Apellido: " + apellido + "\n";
                infoCuenta += "Dirección: " + direccion + "\n";
                infoCuenta += "Email: " + email + "\n";
                infoCuenta += "Fecha de Nacimiento: " + fecNacimiento + "\n";
            } else {
                infoCuenta = "El cliente no fue encontrado.";
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
            infoCuenta = "Hubo un error al consultar la cuenta del cliente.";
        }

        return infoCuenta;
    }

    public void solicitarAsistencia(){

        System.out.print("En unos instantes un asistente lo auxiliará. Gracias.");
    }

    public boolean jugar(Juego juego, double apuesta) {

        boolean jugo = true;
        Conexion con = new Conexion();

        Date fecha = new Date();
        boolean resultado;

        if (apuesta > this.getDineroDisponible()) {
            jugo = false;
            System.out.print("No tiene suficiente dinero disponible");
            return jugo;
        } else {

            resultado = juego.generarResultado();

            if (resultado) {
                this.dineroDisponible += apuesta * 4;
            } else {
                juego.getMaquina().setSaldoTickets((int) (juego.getMaquina().getSaldoTickets() + apuesta));
            }

            // Registrar la partida en la base de datos

            try {
                Connection conexion = con.conectar();
                String sql = "INSERT INTO partida (juego, cliente, monto_apostado, fecha, resultado) " +
                        "VALUES (?, ?, ?, ?, ?)";

                PreparedStatement stmt = conexion.prepareStatement(sql);

                stmt.setInt(1, juego.getIdJuego());
                stmt.setInt(2, this.getIdCliente());
                stmt.setDouble(3, apuesta);
                stmt.setDate(4, new java.sql.Date(fecha.getTime()));
                stmt.setBoolean(5, resultado);

                stmt.executeUpdate();

            } catch (Exception e) {
                System.out.println("Hubo un error al registrar la partida: " + e.getMessage());
            }

            this.setCantPartidasJugadas(this.getCantPartidasJugadas()+1);
            return jugo;
        }
    }



}
