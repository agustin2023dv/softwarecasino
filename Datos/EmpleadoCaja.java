package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
             PreparedStatement stmt = conexion.prepareStatement("INSERT INTO transaccion_caja_empleado (empleado, caja, monto, fecha) "
                     +
                     "VALUES (?, ?, ?, ?)")) {

            stmt.setInt(1, id);
            stmt.setInt(2, idCaja);
            stmt.setDouble(3, monto);
            stmt.setDate(4, new java.sql.Date(fecha.getTime()));

            stmt.executeUpdate();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al agregar dinero: " + e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }


    public boolean login(int id, String contrasena){

        // Realizar la consulta a la base de datos
        Conexion con = new Conexion();
        Connection conexion = null;

        try {
            conexion = con.conectar();
            String sql = "SELECT COUNT(*) FROM usuario WHERE id_usuario = ? AND contrasena = ?";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                if (count > 0) {
                    return true; // Existe un usuario con el ID y contraseña proporcionados
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Hubo un error al validar el login: " + e.getMessage(),"Error",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            // Cerrar la conexión y liberar recursos
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null,"Error al cerrar la conexión: " + e.getMessage(),"Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        // Consulta para verificar si es un empleado caja
        String consultaEmpleado = "SELECT * FROM empleado WHERE tipo_empleado = 1 AND id_usuario = ?";

        try {

            PreparedStatement statementEmpleado = conexion.prepareStatement(consultaEmpleado);

            // Establecer el parámetro en la consulta
            statementEmpleado.setInt(1, id);

            // Ejecutar la consulta y obtener el resultado
            ResultSet resultSetAdmin = statementEmpleado.executeQuery();

            // Verificar si hay algún resultado
            boolean esAdmin = resultSetAdmin.next();

            // Cerrar la conexión y liberar recursos
            resultSetAdmin.close();
            statementEmpleado.close();
            conexion.close();

            // Devolver el resultado de la verificación
            return esAdmin;
        } catch (SQLException e) {
            // Manejar cualquier error de SQL aquí
            e.printStackTrace();
            return false;
        }


    }


    public void mostrarMenu(int id) {
        String opcion;
        String []opcionesECaja = {"Agregar dinero", "Salir"};

        Validacion validacion = new Validacion();



        do {
            opcion = (String) JOptionPane.showInputDialog(null, "Opciones Empleado CAJA", "Menu Empleado caja",
                    JOptionPane.DEFAULT_OPTION, null, opcionesECaja, opcionesECaja);


            switch (opcion) {
                case "Agregar dinero":

                    int idCaja;
                    double monto;
                    monto = Double.parseDouble(JOptionPane.showInputDialog(null, "Monto a agregar",
                            "Deposito de dinero"));
                    idCaja = Integer.parseInt(JOptionPane.showInputDialog(null, "ID caja a depositar",
                            "Deposito de dinero"));


                    if(validacion.validarAgregarDinero(monto, idCaja)){
                        this.agregarDinero(monto, id,idCaja);
                        JOptionPane.showMessageDialog(null, "Ha depositado $"+monto+" correctamente " +
                                "en la caja numero "+idCaja, "Deposito exitoso",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
            }

        } while (!opcion.equals("Salir"));
    }
}
