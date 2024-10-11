import java.util.Comparator;

public class ComparadorPorAutor implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return l1.getAutor().compareTo(l2.getAutor());
    }
}
