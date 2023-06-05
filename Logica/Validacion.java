
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
	
    
}
