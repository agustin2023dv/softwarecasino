package casino;

import java.util.ArrayList;
import java.util.Date;

public class Administrador extends Usuario{

	private int idAdministrador;
	
	
	public Administrador(String usuarioId, String nombre, String apellido, Date fec_nacimiento, String contraseña, int idAdministrador, String correoElectronico) {
		super(usuarioId, nombre, apellido, fec_nacimiento, contraseña, correoElectronico);
		this.idAdministrador = idAdministrador;
	}
		
	// visualizar CAJA 
	public void visualizarCaja(Caja caja) {
		System.out.println("Saldo Inicial: " + caja.getSaldoInicial());
		System.out.println("Saldo Actual: " + caja.getSaldoActual());
	}
	
	
	// eliminar y agregar JUEGO en maquina
	public void agregarJuegoaMaquina(Juego juego, Maquina maquina) {
		 maquina.setJuego(juego);
	}
	
	public void eliminarJuegoaMaquina(Maquina maquina) {
		maquina.setJuego(null);
	}
	
	// editar y eliminar Juego
	
	public void editarJuego(Juego juego, String nombre, String descripcion, int jugadoresMinimos, int jugadoresMaximos) {
		juego.setNombre(nombre);
		juego.setDescripcion(descripcion);
		juego.setJugadoresMinimos(jugadoresMinimos);
		juego.setJugadoresMaximos(jugadoresMaximos);
	}
	
	public void eliminarJuego(Juego juego, boolean estadoJuego) {
		juego.setEstadoJuego(estadoJuego);
		System.out.println("El juego fue eliminado con éxito");
	}
	
	
	// Visualizar Cliente
	
	public void revisarCuentaCliente(Cliente cliente) {
		System.out.println("Nombre : " + cliente.getNombre());
		System.out.println("Apellido: " + cliente.getApellido());
        System.out.println("Fecha de nacimiento: " + cliente.getFec_nacimiento());
        System.out.println("Correo Electronico: " + cliente.getCorreoElectronico());
		
	}
	
	
	// Eliminar Usuario
	
	public void eliminarUsuario(Usuario usuario, ArrayList<Usuario> usuarioEjemplo ) {
		usuarioEjemplo.remove(usuario);
	}
	
	
	//getters y setters
	
	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	
	 

}
