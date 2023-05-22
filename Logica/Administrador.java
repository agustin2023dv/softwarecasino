package Logica;

import java.util.ArrayList;
import java.util.Date;

public class Administrador extends Usuario {

	private int idAdministrador;

	public Administrador(int idUsuario, String nombre, String apellido, Date fecNacimiento, String contraseña,
						 String correoElectronico,
			int idAdministrador) {
		super(idUsuario, nombre, apellido, fecNacimiento, contraseña, correoElectronico);
		this.idAdministrador = idAdministrador;
	}

	// visualizar CAJA
	public void visualizarCaja(Caja caja) {
		System.out.println("Saldo Inicial: " + caja.getSaldoInicial());
		System.out.println("Saldo Actual: " + caja.getSaldoActual());
	}

	// visualizar maquina
	
	public void visualizarMaquina(Maquina maquina) {
		System.out.println("ID Maquina: " + maquina.getIdMaquina());
		System.out.println("Saldo Tickets: " + maquina.getSaldoTickets());
		System.out.println("ID Maquina: " + maquina.getDaniada());
		System.out.println("ID Maquina: " + maquina.getHabilitada());
	}
	// editar y eliminar Juego

	public void editarJuego(Juego juego, String nombre, String descripcion, int jugadoresMinimos,
			int jugadoresMaximos) {
		juego.setNombre(nombre);
		juego.setDescripcion(descripcion);
		juego.setJugadoresMinimos(jugadoresMinimos);
		juego.setJugadoresMaximos(jugadoresMaximos);
	}

	public void eliminarJuego(Juego juego, ArrayList<Juego> juegoEjemplo) {
		if (juegoEjemplo.contains(juego)) {
			juegoEjemplo.remove(juego);
			System.out.println("El juego " + juego.getNombre() + " fue eliminado con éxito.");
		} else {
			System.out.println("El juego " + juego.getNombre() + " no existe.");
		}

	}

	// Visualizar Cliente

	public void revisarCuentaCliente(Cliente cliente) {
		System.out.println("Nombre : " + cliente.getNombre());
		System.out.println("Apellido: " + cliente.getApellido());
		System.out.println("Fecha de nacimiento: " + cliente.getFecNacimiento());
		System.out.println("Correo Electronico: " + cliente.getCorreoElectronico());

	}

	// Eliminar Usuario

	public void eliminarUsuario(Usuario usuario, ArrayList<Usuario> usuarioEjemplo) {
		if (usuarioEjemplo.contains(usuario)) {
			usuarioEjemplo.remove(usuario);
			System.out.println("El usuario " + usuario + " fue eliminado con éxito.");
		} else {
			System.out.println("El usuario " + usuario + " no existe.");
		}

	}

	// getters y setters

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

}
