package Datos;

import java.util.Date;

public class Tecnico extends Empleado{
	
	private int idTecnico;

	public Tecnico(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String direccion, String correoElectronico, int idEmpleado, String puesto) {
		super(idUsuario, nombre, apellido, fecNacimiento, contrasena, direccion, correoElectronico, idEmpleado, puesto);
	}


	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	public void repararMaquina (Maquina maquina) {
		if (maquina.getDaniada()) {
			maquina.setDaniada(false);
		}
	}
	
	public void habilitarMaquina(Maquina maquina) {
		if (!maquina.getHabilitada()) {
			maquina.setHabilitada(true);
		}
	}
	
	public void deshabilitarMaquina(Maquina maquina) {
		if (maquina.getHabilitada()) {
			maquina.setHabilitada(false);
		}
	}
	
}
