import java.util.Date;

public class EmpleadoCaja extends Empleado{

    private int idEmpleadoCaja;
    private Caja caja;

    public EmpleadoCaja(String idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String correoElectronico, String idEmpleado, String rol) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, idEmpleado, rol);
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

    public void agregarDinero (double montoAAgregar, Caja caja) {
        caja.saldoActual = caja.saldoActual + montoAAgregar;
    }

    public void entregarDinero(double montoAEntregar, Cliente cliente, Caja caja) {

        if (caja.saldoActual >= montoAEntregar) {
            caja.saldoActual = caja.saldoActual - montoAEntregar;
            cliente.dineroDisponible = cliente.dineroDisponible + montoAEntregar;
        }
        else
        {
            System.out.println("No hay dinero disponible en la caja");
        }
    }
}