
public class Caja {

    private int idCaja;
    private double saldoActual;
    private EmpleadoCaja empleadoCaja;

    public Caja(int idCaja, double saldoActual, EmpleadoCaja empleadoCaja) {
        this.idCaja = idCaja;
        this.saldoActual = saldoActual;
        this.empleadoCaja = empleadoCaja;
    }

    public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }

    public double getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(double saldoActual) {
        this.saldoActual = saldoActual;
    }

    public EmpleadoCaja getEmpleadoCaja() {
        return empleadoCaja;
    }

    public void setEmpleadoCaja(EmpleadoCaja empleadoCaja) {
        this.empleadoCaja = empleadoCaja;
    }

    public boolean hayDinero() {
        return saldoActual > 0;
    }
}
