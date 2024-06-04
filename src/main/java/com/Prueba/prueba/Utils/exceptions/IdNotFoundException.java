package com.Prueba.prueba.Utils.exceptions;

public class IdNotFoundException extends RuntimeException{

    private static final String ERROR_MESSGE = "No hay registros en la entidad %s con el id suministrado";

    //Utilizamos el constructor de RuntimeException y enviamos el mensaje
    //
    public  IdNotFoundException(String nameEntity){
        super(String.format(ERROR_MESSGE,nameEntity));
    }
    
}
