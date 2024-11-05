package modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    ArrayList<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        cargarDatos();
    }

    public Libro buscarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public List<Libro> buscarLibro(String criterio, String valor) {
        ArrayList<Libro> resultados = new ArrayList<>();


        switch (criterio.toLowerCase()) {
            case "título":
                for (Libro libro : libros) {
                    if (libro.getTitulo().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                }
                break;
            case "autor":
                for (Libro libro : libros) {
                    if (libro.getAutor().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                }
                break;
            case "isbn":
                for (Libro libro : libros) {
                    if (libro.getIsbn().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                }
                break;
        }
        return resultados;
    }

    public void prestarLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && !libro.isPrestado()) {
            libro.setPrestado(true);
            guardarDatos();
        }
    }

    public void devolverLibro(String titulo) {
        Libro libro = buscarLibro(titulo);
        if (libro != null && libro.isPrestado()) {
            libro.setPrestado(false);
            guardarDatos();
        }
    }

    public void admintracionLibros() {
        //TODO
    }

    private void cargarDatos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/libros.dat"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String titulo = parts[0];
                    String autor = parts[1];
                    String isbn = parts[2];
                    boolean prestado = Boolean.parseBoolean(parts[3]);
                    libros.add(new Libro(titulo, autor, isbn, prestado));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void guardarDatos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/libros.dat"))) {
            for (Libro libro : libros) {
                writer.write(libro.getTitulo() + "," + libro.getAutor() + "," + libro.getIsbn() + "," + libro.isPrestado());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
