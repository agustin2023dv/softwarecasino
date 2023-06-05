
package Logica;

import Datos.Administrador;

public class Validacion {
    
//VALIDACIONES LOGIN
	
    public String validarIngreso(int id, String contrasena){

        if(id<0){
            return "El id no puede ser menor a 0";
            
        }else {
        	int tamanioContrasena=contrasena.length();
        	if (tamanioContrasena >= 4 && tamanioContrasena <= 10){
        		return "Todo bien";
            } else {
                	return "La contraseña debe tener entre 4 y 10 caracteres";
            }
       }
    }

   
//VALIDACIONES CLIENTE

	public String validarCargarDinero (int monto) {
		
		if(monto > 0) {
            return "Todo bien";
		}else {
            return "El monto a cargar no puede ser menor a 0";
		}	
	}
	
	public String validarRetirarDinero (double dineroDisponible, int monto) {
		
		if(dineroDisponible >= monto) {
            return "Todo bien";
		}else {
            return "El monto a retirar debe ser mayor al dinero disponible";
		}	
	}
	
//VALIDACIONES ADMINISTRADOR
	
	public String validarEditarJuego (String descripcion, int jugadoresMinimos, int jugadoresMaximos, int idJuego) {
    	int tamanioDescripcion=descripcion.length();
		if(tamanioDescripcion < 10 || tamanioDescripcion > 100) {
            return "La descripcion debe tener entre 10 y 100 caracteres";
		}else if (jugadoresMinimos < 1 && jugadoresMaximos > 6){
            return "La cantidad de jugadores mínimos debe ser mayor o igual a 1 y menor o igual a 6";
		}else {
            return "Todo bien";	
		}	
	}
	
//VALIDACIONES EMPLEADO CAJA 
	
	public String validarAgregarDinero (double montoAAgregar) {
		
		if(montoAAgregar >= 1) {
            return "Todo bien";
		}else {
            return "El monto a agregar debe ser igual o mayor a 1";
		}	
	}
	
	public String validarEntregarDinero (double montoAEntregar, double saldoActual) {
		
		if(montoAEntregar < 1 || montoAEntregar > saldoActual) {
            return "El monto a entregar debe ser mayor a 1 y menor al saldo actual de la caja";
		}else {
            return "Todo bien";
		}	
	}
    
}
