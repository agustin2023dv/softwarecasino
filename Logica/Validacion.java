
package Logica;

import Datos.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Validacion {
    
//VALIDACIONES LOGIN


	public boolean verificarUsuario(int idUsuario, String contrasena) {

		int longitudContrasena = contrasena.length();

		if (idUsuario < 0 || idUsuario > 99) {
			JOptionPane.showMessageDialog(null,"El usuario debe ser un numero entre 1 y 99","Error",
					JOptionPane.ERROR_MESSAGE);
			return false; // El ID de usuario debe estar entre 0 y 99
		}
		else if(longitudContrasena < 6 || longitudContrasena > 15){
			JOptionPane.showMessageDialog(null,"La contraseña debe tener entre 6 y 15 caracteres","Error",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else {
			return true;
		}
	}



//VALIDACIONES CLIENTE

	public boolean validarCargaDinero(int idCliente, double monto){

			if(idCliente>0 && idCliente<100 && monto>0){
				return true;
			}
			else{
				return false;
			}

	}

	public boolean validarRetiroDinero(int idCliente, double monto) {
			Cliente cliente = new Cliente();

			double dineroDisponible = cliente.getDineroDisponible(idCliente);

		if (monto > dineroDisponible) {
			return false; // El cliente no tiene suficiente dinero disponible para realizar el retiro
		}

		return true; // El cliente tiene suficiente dinero disponible
	}

	public boolean validarJugar(double monto, int idCliente){
		Cliente cliente = new Cliente();

		double dineroDisponible = cliente.getDineroDisponible(idCliente);

			if(monto<=0 || dineroDisponible<monto){
				return false;}
			else{
				return true;
			}
	}


	
//VALIDACIONES ADMINISTRADOR

	public boolean validarVerCaja(int idCaja){

			if(idCaja<=0 || idCaja>4){
				JOptionPane.showMessageDialog(null,
						"La caja " + idCaja + " no existe o no tiene transacciones.",
						"Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			else{

				return true;
			}
	}

	public boolean validarEditarJuego (String descripcion, int jugadoresMinimos, int jugadoresMaximos) {


		if(jugadoresMinimos < 1 || jugadoresMaximos > 6) {
			JOptionPane.showMessageDialog(null,"La cantidad de jugadores mínimos debe ser mayor o igual a 1 y menor o igual a 6"
					,"Error",JOptionPane.ERROR_MESSAGE);
            return false;
		}else if (descripcion.length() < 10 || descripcion.length() > 100){
			JOptionPane.showMessageDialog(null,"La descripcion debe tener entre 10 y 100 caracteres",
					"Error",JOptionPane.ERROR_MESSAGE);
			 return false;
		}else {
			return true;
		}

	}



	public boolean validarEliminarJuego(int idJuego){

			if(idJuego<0 || idJuego>50){
				return false;
			}
			else {
				return true;
			}

	}

	public boolean validarActualizarCliente (String email, String direccion, int idCliente) {

		if(idCliente<= 0 || idCliente >99 || email.equals("") || direccion.equals("")
			||	email.length() < 10 || email.length() > 30 || direccion.length() < 10 || direccion.length() > 30){

			return false;
		}
		else{
			return true;
		}

		}



	public boolean validarExistenciaCliente(int idUsuario) {

		if(idUsuario <= 0 || idUsuario >99 ){
			JOptionPane.showMessageDialog(null,
					"El ID del Usuario debe ser un numero entre 1 y 99", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else{
			return true;
	}
		}



//VALIDACIONES EMPLEADO CAJA 

// FALTA CORREGIR NOMBRE DE VARIABLES EN EL METODO

	public boolean validarAgregarDinero (double montoAAgregar, int idCaja) {

		if(montoAAgregar > 0 && idCaja >0 && idCaja<4) {
            return true;
		}else {
            return false;
		}	
	}
	

// Validaciones Tecnico

	
	
// Validaciones Empleado Maquina


	public boolean validarExistenciaMaquina(int idMaquina){
		Conexion con = new Conexion();

		try {
			Connection conexion = con.conectar();
			String sql = "SELECT  count(*) as count " +
					"FROM maquina WHERE id_maquina = ?";

			PreparedStatement stmt = conexion.prepareStatement(sql);
			stmt.setInt(1, idMaquina);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				int count = rs.getInt("count");
				return count > 0; //
			}
			else{
				JOptionPane.showMessageDialog(null,
						"No se encontro la maquina con ID "+idMaquina, "Error", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Hubo un error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

		}
		return false;
	}
    
}
