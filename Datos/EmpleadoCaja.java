package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class EmpleadoCaja extends Empleado{

    private int idEmpleadoCaja;

    private Caja caja;

    public EmpleadoCaja(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                        String correoElectronico, String direccion, int idEmpleado, String puesto, int idEmpleadoCaja) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, direccion,idEmpleado, puesto);
        this.idEmpleadoCaja = idEmpleadoCaja;
    }

    public int getIdEmpleadoCaja() {
        return idEmpleadoCaja;
    }
    public void setIdEmpleadoCaja(int idEmpleadoCaja) {
        this.idEmpleadoCaja = idEmpleadoCaja;
    }
    public Caja getCaja() {
        return caja;
    }
    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public void agregarDinero(double monto) {
        Conexion con = new Conexion();
        int caja = this.getCaja().getIdCaja();
        Date fecha = new Date();

        try {
            Connection conexion = con.conectar();
            String sql = "INSERT INTO transaccion_caja_empleado (empleado, caja, monto, fecha) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, this.getIdEmpleado());
            stmt.setInt(2, caja);
            stmt.setDouble(3, monto);
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al agregar dinero: " + e.getMessage());
        }
    }


    public void entregarDinero(double montoAEntregar, Cliente cliente) {

        if (this.getCaja().getSaldoActual() >= montoAEntregar) {
            this.getCaja().setSaldoActual(this.getCaja().getSaldoActual() - montoAEntregar);
            cliente.setDineroDisponible(cliente.getDineroDisponible() + montoAEntregar);
        }
        else
        {
            System.out.println("No hay dinero disponible en la caja");
        }
    }
}
