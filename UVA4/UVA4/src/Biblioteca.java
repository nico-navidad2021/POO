import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> librosAlmacenados;
    private String nombre;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.librosAlmacenados = new ArrayList<>();
    }

    public List<Libro> getLibrosAlmacenados() {
        return librosAlmacenados;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(Libro libro){
        librosAlmacenados.add(libro);
    }

    public void eliminarLibro(Libro libro){
        librosAlmacenados.remove(libro);
    }

    public Libro buscarLibro(){
        //TODO
        Libro a = new Libro(nombre, nombre, 1232, nombre);
        return a;
    }
    

    

}
