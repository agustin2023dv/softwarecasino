import java.util.Date;

public abstract class Usuario {
    private String idUsuario;
    private String nombre;
    private String apellido;
    private Date fecNacimiento;
    private String contrasena;
    private boolean logueado;

    private String correoElectronico;


    public Usuario(String idUsuario, String nombre, String apellido, Date fecNacimiento,
                   String contrasena, String correoElectronico) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecNacimiento = fecNacimiento;
        this.contrasena = contrasena;
        this.logueado = false;
        this.correoElectronico = correoElectronico;
    }




    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
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

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }


    public void login(String password) {
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


}
