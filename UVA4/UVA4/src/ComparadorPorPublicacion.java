import java.util.Comparator;

public class ComparadorPorPublicacion implements Comparator<Libro> {
    @Override
    public int compare(Libro l1, Libro l2) {
        return Integer.compare(l1.getPublicacion(), l2.getPublicacion());
    }
}
