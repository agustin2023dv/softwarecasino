package Datos;

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
    
    public void agregarDinero (double montoAAgregar, Caja caja) {
        this.getCaja().setSaldoActual(this.getCaja().getSaldoActual() + montoAAgregar);
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
