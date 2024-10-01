public class Libro implements Comparable<Libro>{
    private String titulo;
    private String autor;
    private Integer publicacion;
    private String isbn;
    
    public Libro(String titulo, String autor, Integer publicacion, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.publicacion = publicacion;
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getPublicacion() {
        return publicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString(){
        return "Libro: [Titulo= "+titulo+" Autor= "+autor+" Fecha publicacion= "+publicacion+" ISBN= "+isbn+"]";
    } 

    @Override
    public int compareTo(Libro o) {
        return this.titulo.compareTo(o.getTitulo());
    }

}
