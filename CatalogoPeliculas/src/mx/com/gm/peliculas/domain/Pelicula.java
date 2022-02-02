package mx.com.gm.peliculas.domain;

//tambien se le conocen como clases de entidad, corresponde a una tabla en una base de datos y los atributos son columnas de la tabla
public class Pelicula { //si la vamos a conectar a un servidor deberia implementar la interface Serializable

    private String nombre; //necesario metodos getters and setters para java beans

    public Pelicula() { //necesario para java beans

    }

    public Pelicula(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    
}
