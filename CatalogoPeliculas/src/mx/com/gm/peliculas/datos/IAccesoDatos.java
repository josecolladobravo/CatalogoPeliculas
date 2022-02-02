package mx.com.gm.peliculas.datos;

import java.util.List;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;


public interface IAccesoDatos { //se definen los metodos 
    
    boolean existe(String nombreRecurso) throws AccesoDatosEx; //para saber si existe un archivo. puede arrojar una excepcion
    List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx;
    void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws LecturaDatosEx;
    String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx; 
    void crear(String nombreRecurso) throws AccesoDatosEx;
    void borrar(String nombreRecurso) throws AccesoDatosEx;
}
