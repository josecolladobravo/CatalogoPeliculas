package mx.com.gm.pelicula.negocio;

public interface ICatalogoPeliculas {
    
    String NOMBRE_RECURSO = "peliculas.txt"; //nombre del archivo
    
    void agregarPelicula(String nombrePelicula);
    void listarPeliculas();
    void buscarPelicula(String buscar);
    void iniciarCatalogoPeliculas();
}
