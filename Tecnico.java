import java.util.Date;

public class Tecnico extends Empleado{
	
	private int idTecnico;

	public Tecnico(String idUsuario, String nombre, String apellido, Date fecNacimiento, String contrasena, String correoElectronico, String idEmpleado, String puesto, int idTecnico) {
		super(idUsuario, nombre, apellido, fecNacimiento, contrasena, correoElectronico, idEmpleado, puesto);
		this.idTecnico = idTecnico;
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
		if (maquina.getDaniada()) {
			maquina.setDaniada(false); 
		}
	}
	
}
