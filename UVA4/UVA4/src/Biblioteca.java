import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> librosAlmacenados;
    private String nombre;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.librosAlmacenados = new ArrayList<>();
    }

    public ArrayList<Libro> getLibrosAlmacenados() {
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

    public Libro buscarLibro(String isbn) {
        for (Libro libro : librosAlmacenados) {
            if (libro.getIsbn().equalsIgnoreCase(isbn)) {
                return libro;
            }
        }
        return null;
    }
}
