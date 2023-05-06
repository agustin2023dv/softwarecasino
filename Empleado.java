import java.util.Date;

public class Empleado extends Usuario{

    private String idEmpleado;

    private String puesto;


    public Empleado(String idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena,
                    String correoElectronico, String idEmpleado, String puesto) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico);
        this.idEmpleado = idEmpleado;
        this.puesto = puesto;
    }


    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
