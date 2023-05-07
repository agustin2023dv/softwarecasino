import java.util.Date;

public class EmpleadoMaquina extends Empleado{

    private int idEmpleadoMaquina;


    public EmpleadoMaquina(String idUsuario, String nombre, String apellido, Date fecNacimiento,
                           String contrasena, String correoElectronico, String idEmpleado, String puesto, int idEmpleadoMaquina) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, idEmpleado, puesto);
        this.idEmpleadoMaquina = idEmpleadoMaquina;
    }


    public String getIdEmpleadoMaquina() {
        return idEmpleadoMaquina;
    }

    public void setIdEmpleadoMaquina(String idEmpleadoMaquina) {
        this.idEmpleadoMaquina = idEmpleadoMaquina;
    }

    public void encenderMaquina(Maquina maquina){
        if(maquina.getHabilitada() || maquina.getDaniada()){
        maquina.encender();}
        else{
            System.out.print("La maquina no está en condiciones de ser utilizada.");
        }
    }


    public void apagarMaquina(Maquina maquina){
        maquina.apagar();
    }


    public void retirarTickets(Maquina maquina, int cantidadTickets){
        // FALTA DEFINIR SI LO RETIRADO VA A CAJA O A DONDE
    }

    public void recargarTickets(Maquina maquina, int cantidadTickets){

        maquina.setSaldoTickets((maquina.getSaldoTickets() + cantidadTickets));
    }
}
