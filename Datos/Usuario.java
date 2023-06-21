package Datos;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public abstract class Usuario {
    private int idUsuario;
    private String nombre;
    private String apellido;
    private Date fecNacimiento;


    private String contrasena;
    private boolean logueado;

    private String direccion;
    private String correoElectronico;

    public Usuario() {
		
	}

    public Usuario(int idUsuario, String nombre, String apellido, Date fecNacimiento,
                   String contrasena, String direccion,String correoElectronico) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNacimiento = fecNacimiento;
        this.contrasena = contrasena;
        this.logueado = false;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }




    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void mostrarError(String mensaje) {
        JFrame errorFrame = new JFrame("Error");
        errorFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        errorFrame.setSize(300, 100);
        errorFrame.setLayout(new FlowLayout());

        JLabel labelError = new JLabel(mensaje);
        errorFrame.add(labelError);

        errorFrame.setVisible(true);
    }


  /**
   *    CREO QUE ESTE CODIGO YA NO ES NECESARIO
   *
   * public void login(String password) {
        if (password.equals(this.contrasena)) {
            this.logueado = true;
            System.out.println("Inicio de sesión exitoso para el usuario " + this.idUsuario);
        } else {
            System.out.println("Contraseña incorrecta para el usuario " + this.idUsuario);
        }
    }

    public void logout() {
        this.logueado = false;
        System.out.println("El usuario " + this.idUsuario + " ha cerrado sesión");
    }
**/


}
