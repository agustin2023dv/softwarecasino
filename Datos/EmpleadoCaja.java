package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Date;

public class EmpleadoCaja extends Empleado implements Menu {

    private int idEmpleadoCaja;


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


   public void agregarDinero(double monto, int id, int idCaja) {
        Conexion con = new Conexion();
        Date fecha = new Date();

        try (Connection conexion = con.conectar();
             PreparedStatement stmt = conexion.prepareStatement("INSERT INTO transaccion_caja_empleado (empleado, caja, monto, fecha) " +
                     "VALUES (?, ?, ?, ?)")) {

            stmt.setInt(1, id);
            stmt.setInt(2, idCaja);
            stmt.setDouble(3, monto);
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));

            stmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Hubo un error al agregar dinero: " + e.getMessage());
        }
    }


    public void mostrarMenu(int id) {
        String opcion;
        String []opcionesECaja = {"Agregar dinero", "Salir"};

        JOptionPane.showMessageDialog(null, "Ingresó como Empleado Caja");
        Validacion validacion = new Validacion();
        do {
            opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado CAJA", "Opcion",
                    JOptionPane.DEFAULT_OPTION, null, opcionesECaja, opcionesECaja);


            switch (opcion) {
                case "Agregar dinero":
int idCaja;
                    double monto;
                    monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto a agregar"));
                    idCaja = Integer.parseInt(JOptionPane.showInputDialog(null, "ID caja a depositar"));


                    if(validacion.validarAgregarDinero(monto)){
                        this.agregarDinero(monto, id,idCaja);
                    }
                    break;
            }

        } while (!opcion.equals("Salir"));
    }
}
