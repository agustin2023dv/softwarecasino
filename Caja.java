
public class Caja {

    private int idCaja;
    private double saldoInicial;
    private double saldoActual;
    private EmpleadoCaja empleadoCaja;

    public Caja(int idCaja,double saldoInicial, double saldoActual, EmpleadoCaja empleadoCaja) {
        this.idCaja = idCaja;
        this.saldoInicial = saldoInicial;
        this.saldoActual = saldoActual;
        this.empleadoCaja = empleadoCaja;
    }
    
	public int getIdCaja() {
        return idCaja;
    }

    public void setIdCaja(int idCaja) {
        this.idCaja = idCaja;
    }
    
    public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
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
