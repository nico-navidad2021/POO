package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Libro;
import modelo.Biblioteca;

public class BuscarGUI extends JFrame {
    private Biblioteca biblioteca;
    private JTextField inputTitulo;
    private JComboBox<String> criterioBusqueda;
    private JTable tablaResultados;
    private DefaultTableModel modeloTabla;

    public BuscarGUI() {
        this.biblioteca = new Biblioteca();
        setTitle("Búsqueda de libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        // Parte de los inputs
        JPanel panelInput = new JPanel(new FlowLayout());

        criterioBusqueda = new JComboBox<>(new String[]{"Título", "Autor", "Categoría"});

        JButton buscarButton = new JButton("Buscar");

        inputTitulo = new JTextField(20);
        panelInput.add(criterioBusqueda);
        panelInput.add(inputTitulo);
        panelInput.add(buscarButton);

        modeloTabla = new DefaultTableModel(new String[]{"Título", "Autor", "ISBN", "Año", "Prestado"}, 0);
        tablaResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaResultados);

        // Panel de resultados
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.add(scrollPane, BorderLayout.CENTER);

        // La pantalla general como un todo
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelInput, BorderLayout.NORTH);
        panelPrincipal.add(panelResultado, BorderLayout.CENTER);

        add(panelPrincipal);

        // Cargar todos los libros al abrir la ventana
        cargarTodosLosLibros();

        // Acción del botón Buscar para filtrar los resultados
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });
    }

    private void cargarTodosLosLibros() {
        // Limpiar la tabla antes de cargar los libros
        modeloTabla.setRowCount(0);

        // Cargar todos los libros almacenados en la biblioteca
        List<Libro> libros = biblioteca.getLibrosAlmacenados();
        for (Libro libro : libros) {
            String prestadoText = libro.isPrestado() ? "Sí" : "No";
            modeloTabla.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn(), 2002, prestadoText});
        }
    }

    private void buscarLibro() {
        String inputBusqueda = inputTitulo.getText();
        String criterioBus = criterioBusqueda.getSelectedItem().toString();

        // Filtrar libros según el criterio seleccionado y el texto de búsqueda
        List<Libro> resultados = biblioteca.buscarLibro(criterioBus, inputBusqueda);

        // Limpiar la tabla para mostrar solo los resultados filtrados
        modeloTabla.setRowCount(0);

        // Añadir los resultados filtrados a la tabla
        if (resultados != null) {
            for (Libro libro : resultados) {
                String prestadoText = libro.isPrestado() ? "Sí" : "No";
                this.modeloTabla.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn(), 2002, prestadoText});
            }
        }
    }
}
