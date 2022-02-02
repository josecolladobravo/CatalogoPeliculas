package mx.com.gm.peliculas.excepciones;

public class AccesoDatosEx extends Exception{ //extiende de la clase Exception 
    public AccesoDatosEx(String mensaje){
        super(mensaje); //llama al constructor de la clase padre
    }
     
}
