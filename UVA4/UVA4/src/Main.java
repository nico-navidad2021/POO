import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Biblioteca biblioteca = new Biblioteca("Ateneo");

        Libro l1 = new Libro("Horus Rising", "Dan Abnett", 2006, "9781849707435");
        Libro l2 = new Libro("Imperio Final", "Brandon Sanderson", 2016, "9781473216815");
        Libro l3 = new Libro("Homo Deus", "Yuval Noah Harari", 2017, "9780062464316");
        Libro l4 = new Libro("El Bosque Oscuro", "Cixin Liu", 2008, "978846660921");
        Libro l5 = new Libro("DUNE", "Frank Herbert", 2020, "9789877254112");

        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        
        System.out.println("Biblioteca luego de haber agregado los libros....");
        List<Libro> librosAlmacenados = biblioteca.getLibrosAlmacenados();
        for (Iterator<Libro> i=librosAlmacenados.iterator(); i.hasNext();) System.out.println(i.next());




    }
}
