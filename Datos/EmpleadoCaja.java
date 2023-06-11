package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class EmpleadoCaja extends Empleado implements Menu {

    private int idEmpleadoCaja;

    private Caja caja;

    public EmpleadoCaja(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                        String correoElectronico, String direccion, int idEmpleado, String puesto, int idEmpleadoCaja) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, direccion,idEmpleado, puesto);
        this.idEmpleadoCaja = idEmpleadoCaja;
    }

    public EmpleadoCaja(){};
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

    public void agregarDinero(double monto, int id) {
        Conexion con = new Conexion();
        int caja = this.getCaja().getIdCaja();
        Date fecha = new Date();

        try {
            Connection conexion = con.conectar();
            String sql = "INSERT INTO transaccion_caja_empleado (empleado, caja, monto, fecha) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setInt(2, caja);
            stmt.setDouble(3, monto);
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al agregar dinero: " + e.getMessage());
        }
    }




    public void mostrarMenu(int id) {
        String opcion;
        String []opcionesECaja = {"Agregar dinero", "Ver algo", "Salir"};

        Validacion validacion = new Validacion();
        do {
            opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado CAJA", "Opcion",
                    JOptionPane.DEFAULT_OPTION, null, opcionesECaja, opcionesECaja);


            switch (opcion) {
                case "Agregar dinero":

                    double monto;
                    monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto a agregar"));
                    if(validacion.validarAgregarDinero(monto)){
                        this.agregarDinero(monto, id);
                    }


                    break;
                case "Ver algo":




                    break;
            }

        } while (!opcion.equals("Salir"));
    }
}
