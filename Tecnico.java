
public class Tecnico {
	
	private int idTecnico;

	public Tecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	public int getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(int idTecnico) {
		this.idTecnico = idTecnico;
	}
	
	public void repararMaquina (Maquina maquina) {
		if (maquina.daniada) {
			maquina.daniada = false;	
		}
	}
	
	public void habilitarMaquina(Maquina maquina) {
		if (!maquina.habilitada) {
			maquina.habilitada = true;
		}
	}
	
	public void deshabilitarMaquina(Maquina maquina) {
		if (maquina.daniada) {
			maquina.habilitada = false;
		}
	}
	
}
