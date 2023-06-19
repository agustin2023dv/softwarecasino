package Datos;

import Interface.Menu;
import Logica.Validacion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EmpleadoCaja extends Empleado implements Menu {

    private int idEmpleadoCaja;

    private JFrame ventana;

    private JLabel labelMonto;
    private JTextField textFieldMonto;
    private JLabel labelIdCaja;
    private JTextField textFieldIdCaja;
    private JButton botonAgregarDinero;
    private JPanel panel;





    public EmpleadoCaja(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                        String correoElectronico, String direccion, int idEmpleado, String puesto, int idEmpleadoCaja) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, direccion,idEmpleado, puesto);
        this.idEmpleadoCaja = idEmpleadoCaja;
    }

    public EmpleadoCaja(){};
    public int getIdEmpleadoCaja(String nombre_usuario) {
        Conexion con = new Conexion();
        int idEmpleadoCaja = 0; // Valor por defecto en caso de que no se encuentre el usuario

        try (Connection conexion = con.conectar();
             PreparedStatement stmt = conexion.prepareStatement("SELECT id_usuario FROM usuario WHERE nombre_usuario = ?");
        ) {
            stmt.setString(1, nombre_usuario);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                idEmpleadoCaja = rs.getInt("id_usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al obtener el ID del usuario: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return idEmpleadoCaja;
    }

    public void setIdEmpleadoCaja(int idEmpleadoCaja) {
        this.idEmpleadoCaja = idEmpleadoCaja;
}


   public void agregarDinero(double monto, String nombre_usuario, int idCaja) {
        int id;
        id = this.getIdEmpleadoCaja(nombre_usuario);
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


    public boolean login(String nombreUsuario, String contrasena) {
        // Realizar la consulta a la base de datos
        Conexion con = new Conexion();

        try (Connection conexion = con.conectar()) {
            String sql = "SELECT COUNT(*) FROM usuario u " +
                    "LEFT JOIN empleado e ON u.id_usuario = e.id_usuario " +
                    "WHERE u.nombre_usuario = ? AND u.contrasena = ? " +
                    "AND e.tipo_empleado = 1";

            PreparedStatement stmt = conexion.prepareStatement(sql);
            stmt.setString(1, nombreUsuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);

                if (count > 0) {
                    return true; // Existe un usuario con el ID y contraseña proporcionados
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al validar el login: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        return false;
    }


    public void mostrarMenu(String id) {
        Validacion validacion = new Validacion();

        ventana = new JFrame("Empleado Caja");
        ventana.setSize(500, 300);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);

        labelMonto = new JLabel("Monto a agregar:");
        textFieldMonto = new JTextField(10);
        labelIdCaja = new JLabel("ID caja a depositar:");
        textFieldIdCaja = new JTextField(10);
        botonAgregarDinero = new JButton("Agregar dinero");
        botonAgregarDinero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double monto = Double.parseDouble(textFieldMonto.getText());
                int idCaja = Integer.parseInt(textFieldIdCaja.getText());
                if (validacion.validarAgregarDinero(monto, idCaja)) {
                    agregarDinero(monto, id, idCaja);
                    JOptionPane.showMessageDialog(null, "Ha depositado $" + monto + " correctamente " +
                            "en la caja numero " + idCaja, "Deposito exitoso", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        panel = new JPanel();
        panel.add(labelMonto);
        panel.add(textFieldMonto);
        panel.add(labelIdCaja);
        panel.add(textFieldIdCaja);
        panel.add(botonAgregarDinero);

        ventana.add(panel);
        ventana.setVisible(true);
    }
}
