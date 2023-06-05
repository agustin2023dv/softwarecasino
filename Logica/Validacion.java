
package Logica;

import Datos.Administrador;

public class Validacion {
    
//VALIDACIONES LOGIN

    public String validarIngreso(int id, String contrasena){

        if(id<0){
            return "El id no puede ser menor a 0";
            
        }else {
        	int tamanioContrasena=contrasena.length();
        	if (tamanioContrasena >= 5 && tamanioContrasena <= 15){
        		return "Todo bien";
            } else {
                	return "La contraseña debe tener entre 5 y 15 caracteres";
            }
       }
    }
}
