package Datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

        Conexion con = new Conexion();
        double dineroDisponible = 0;

        try {
            Connection conexion = con.conectar();

            String sql = "SELECT SUM(mca.monto) + SUM(monto) AS total_saldo" +
                    "FROM movimiento_caja_apuesta mca INNER JOIN caja c ON mca.caja = c.id_caja" +
                    "INNER JOIN transaccion_caja_cliente tcc ON tcc.caja = c.id_caja" +
                    "WHERE c.id_caja = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);


            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                dineroDisponible = rs.getDouble("total_monto");
            }
        } catch (Exception e) {
            System.out.println("Hubo un error: " + e.getMessage());
        }

        return dineroDisponible;
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
