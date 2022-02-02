package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import mx.com.gm.peliculas.domain.Pelicula;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombreRecurso) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo)); //lee cada una de las lineas del archivo
            String linea = null; //Variable que almacena cada una de las lineas
            linea = entrada.readLine(); //leemos una linea
            while (linea != null) {
                Pelicula pelicula = new Pelicula(linea); //crea un objeto de pelicula sacada de la linea del txt
                peliculas.add(pelicula); // y la aniade a la List
                linea = entrada.readLine(); //para que se vuelva a hacer el while hasta que la ultima linea sea null
            }
            entrada.close(); //cierra el flujo
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage()); //en caso de probrema lanzamos una excepcion
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al listar peliculas: " + ex.getMessage());
        }
        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreRecurso, boolean anexar) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString()); //imprime una nueva linea. toSString porque lo que queremos es escribir esa pelicula
            salida.close();
            System.out.println("Se ha escrito informacion al archivo: " + pelicula);
        } catch (IOException ex) {
            ex.printStackTrace();
            System.out.println("Error al escribir peliculas");
        }
    }

    @Override
    public String buscar(String nombreRecurso, String buscar) throws LecturaDatosEx {
        File archivo = new File(nombreRecurso);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1; //nos dice en que linea esta esa pelicula
            while (linea != null) {
                if (buscar != null && buscar.equalsIgnoreCase(linea)) {
                    resultado = "Pelicula " + linea + " encontrada en el indice " + indice;
                    break;
                }
                linea = entrada.readLine();
                indice++;
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEx("Excepcion al buscar peliculas: " + ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEx("Excepcion al crear peliculas: " + ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreRecurso) throws AccesoDatosEx {
        File archivo = new File(nombreRecurso);
        if(archivo.exists())
        archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }

}
