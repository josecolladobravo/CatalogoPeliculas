package mx.xom.gm.peliculas.presentacion;

import java.util.Scanner;
import mx.com.gm.pelicula.negocio.CatalogoPeliculasImpl;
import mx.com.gm.pelicula.negocio.ICatalogoPeliculas;

public class CatalogoPeliculasPresentacion {
    public static void main(String[] args) {
        int opcion = -1;
        Scanner scanner = new Scanner(System.in);
        ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl(); 
        
        while(opcion!=0){
            System.out.println("Elije una opcion: \n"
                + "1. Iniciar catalogo de peliculas \n"
                + "2. Agregar pelicula \n"
                + "3. Listar peliculas \n"
                + "4. Buscar peliculas \n"
                + "0. Salir");
            opcion = Integer.parseInt(scanner.nextLine());
            
            switch(opcion){
                case 1:
                    catalogo.iniciarCatalogoPeliculas();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelicula");
                    String nombrePelicula = scanner.nextLine();
                    catalogo.agregarPelicula(nombrePelicula);;
                    break;
                case 3:
                    catalogo.listarPeliculas();
                    break;
                case 4:
                    System.out.println("¿Que pelicula deseas buscar?");
                    String nombre = scanner.nextLine();
                    catalogo.buscarPelicula(nombre);
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Opcion no reconocida");
            }
        }
    }
}
