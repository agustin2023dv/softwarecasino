package Datos;

import Interface.Menu;
import Logica.Validacion;

import java.sql.SQLException;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmpleadoMaquina extends Empleado implements Menu{

    private int idEmpleadoMaquina;
    private JFrame ventana;
    private JButton botonEncender;
    private JButton botonApagar;
    private JPanel panel;

    public EmpleadoMaquina(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idEmpleado, String puesto) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico, idEmpleado, puesto);
    }


    public EmpleadoMaquina() {
		
	}


	public int getIdEmpleadoMaquina() {
        return idEmpleadoMaquina;
    }

    public void setIdEmpleadoMaquina(int idEmpleadoMaquina) {
        this.idEmpleadoMaquina = idEmpleadoMaquina;
    }

    
    // Metodos
    
    public boolean encenderMaquina(int id) {
		Conexion con = new Conexion();
		try {
			Connection conexion = con.conectar();

			String sql = "UPDATE maquina SET habilitada = true WHERE id_maquina = ?;";
			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, id);



		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un error: " + e.getMessage());
			return false;
		}
		return true;
    }
    
    
    public boolean apagarMaquina(int id) {
        Conexion con = new Conexion();
        try {
            Connection conexion = con.conectar();

	            String sql = "UPDATE maquina SET habilitada = false WHERE id_maquina = ?;";
	            PreparedStatement stmt = conexion.prepareStatement(sql);
	            stmt.setInt(1, id);
	            

            
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null,"Hubo un error: " + e.getMessage());
			return false;
        }
		return true;
    }
    
    
    // Menu

	public boolean login(String nombreUsuario, String contrasena) {
		Conexion con = new Conexion();

		try (Connection conexion = con.conectar()) {
			String sql = "SELECT COUNT(*) FROM usuario u " +
					"LEFT JOIN empleado e ON u.id_usuario = e.id_usuario " +
					"WHERE u.nombre_usuario = ? AND u.contrasena = ? " +
					"AND e.tipo_empleado = 3";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setString(1, nombreUsuario);
			stmt.setString(2, contrasena);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt(1);

				if (count > 0) {
					return true; // Existe un usuario con el ID y contraseña proporcionados y es EMaquina
				}
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Hubo un error al validar el login: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}

		return false;
	}


    public void mostrarMenu(String id){
    	  String[] opcionesEMaquina = {"Encender Maquina", "Apagar Maquina", "Salir"};

          ventana = new JFrame("Empleado Maquina");
          ventana.setSize(300, 200);
          ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          ventana.setLocationRelativeTo(null);

          botonEncender = new JButton("Encender Maquina");
          botonApagar = new JButton("Apagar Maquina");

          panel = new JPanel();
          panel.add(botonEncender);
          panel.add(botonApagar);

          ventana.add(panel);
          ventana.setVisible(true);

          Validacion validacion = new Validacion();

          botonEncender.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  int idMaquina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Maquina a encender"));
                  if (validacion.validarExistenciaMaquina(idMaquina)) {
                      encenderMaquina(idMaquina);
                      JOptionPane.showMessageDialog(null, "La maquina numero " + idMaquina +
                              " ha sido encendida exitosamente", "Encendido exitoso", JOptionPane.INFORMATION_MESSAGE);
                  }
              }
          });

          botonApagar.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent e) {
                  int idMaquina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la Maquina a apagar"));
                  if (validacion.validarExistenciaMaquina(idMaquina)) {
                      apagarMaquina(idMaquina);
                      JOptionPane.showMessageDialog(null, "La maquina numero " + idMaquina +
                              " ha sido apagada exitosamente", "Apagado exitoso", JOptionPane.INFORMATION_MESSAGE);
                  }
              }
          });
    }
}
