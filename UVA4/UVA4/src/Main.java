import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Ateneo");
        Libro l1 = new Libro("Horus Rising", "Dan Abnett", 2006, "9781849707435");
        Libro l2 = new Libro("Imperio Final", "Brandon Sanderson", 2016, "9781473216815");
        Libro l3 = new Libro("Homo Deus", "Yuval Noah Harari", 2017, "9780062464316");
        Libro l4 = new Libro("El Bosque Oscuro", "Cixin Liu", 2008, "978846660921");
        Libro l5 = new Libro("DUNE", "Frank Herbert", 2020, "9789877254112");

        biblioteca.agregarLibro(l1);
        biblioteca.agregarLibro(l2);
        biblioteca.agregarLibro(l3);
        biblioteca.agregarLibro(l4);
        biblioteca.agregarLibro(l5);

        mostrarLibros(biblioteca);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú de la Biblioteca ---");
            System.out.println("1. Agregar libro");
            System.out.println("2. Eliminar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarLibro(biblioteca, scanner);
                    break;
                case 2:
                    eliminarLibro(biblioteca, scanner);
                    break;
                case 3:
                    buscarLibro(biblioteca, scanner);
                    break;
                case 4:
                    mostrarLibros(biblioteca);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 5);

        scanner.close();
    }

    public static void agregarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el título del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Introduce el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Introduce el año de publicación: ");
        int publicacion = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Introduce el ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = new Libro(titulo, autor, publicacion, isbn);
        biblioteca.agregarLibro(libro);
        System.out.println("Libro agregado con éxito.");
    }

    public static void eliminarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el ISBN del libro a eliminar: ");
        String isbn = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(isbn);

        if (libro != null) {
            biblioteca.eliminarLibro(libro);
            System.out.println("Libro eliminado con éxito.");
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    public static void buscarLibro(Biblioteca biblioteca, Scanner scanner) {
        System.out.print("Introduce el ISBN del libro a buscar: ");
        String isbn = scanner.nextLine();
        Libro libro = biblioteca.buscarLibro(isbn);

        if (libro != null) {
            System.out.println("Libro encontrado: " + libro);
        } else {
            System.out.println("El libro no fue encontrado.");
        }
    }

    public static void mostrarLibros(Biblioteca biblioteca) {
        if (biblioteca.getLibrosAlmacenados().isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            System.out.println("\n--- Libros en la Biblioteca ---");
            for (Libro libro : biblioteca.getLibrosAlmacenados()) {
                System.out.println(libro);
            }
        }
    }
}
