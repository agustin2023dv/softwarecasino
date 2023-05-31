package Logica;

import java.util.Date;

public class EmpleadoMaquina extends Empleado{

    private int idEmpleadoMaquina;

    public EmpleadoMaquina(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idEmpleado, String puesto) {
        super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico, idEmpleado, puesto);
    }


    public int getIdEmpleadoMaquina() {
        return idEmpleadoMaquina;
    }

    public void setIdEmpleadoMaquina(int idEmpleadoMaquina) {
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
        //lu: mientras no se defina, utilizamos esta funcion para darle funcionalidad a la app 
       maquina.setSaldoTickets((maquina.getSaldoTickets() - cantidadTickets));
    }

    public void recargarTickets(Maquina maquina, int cantidadTickets){

        maquina.setSaldoTickets((maquina.getSaldoTickets() + cantidadTickets));
    }
}
