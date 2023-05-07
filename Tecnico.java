
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
