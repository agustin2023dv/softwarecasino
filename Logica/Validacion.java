
package Logica;

import Datos.Administrador;

public class Validacion {


    public String validarIngreso(int id){

        if(id<0){
            return "El id no puede ser menor a 0";
        }
        else{

           return "Todo bien";
        }

    }
}
