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
        setTitle("Busqueda libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);


        //Parte de los inputs
        JPanel panelInput = new JPanel(new FlowLayout());

        criterioBusqueda = new JComboBox<>(new String[]{"Título", "Autor", "Categoría"});

        JButton buscarButton = new JButton();
        buscarButton.setText("Buscar");

        inputTitulo = new JTextField("",20);
        inputTitulo.setMinimumSize(new Dimension(150, 30));
        inputTitulo.setSize(new Dimension(150, 30));

        panelInput.add(criterioBusqueda);
        panelInput.add(inputTitulo);
        panelInput.add(buscarButton);

        modeloTabla = new DefaultTableModel(new String[]{"Título", "Autor", "ISBN", "Año", "Prestado"}, 0);
        tablaResultados = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaResultados);

        // Panel de resultados
        JPanel panelResultado = new JPanel(new BorderLayout());
        panelResultado.add(scrollPane, BorderLayout.CENTER);


        //La pantalla general como un todo
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelInput, BorderLayout.NORTH);
        panelPrincipal.add(panelResultado, BorderLayout.CENTER);

        add(panelPrincipal);

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarLibro();
            }
        });

    }

    private void buscarLibro() {

        System.out.println("Buscando libros...");

        String inputBusqueda = inputTitulo.getText();
        String criterioBus = criterioBusqueda.getSelectedItem().toString();

        System.out.println("inputBusqueda: "+inputBusqueda);
        System.out.println("criterioBus: "+criterioBus);

        List<Libro> resultados = biblioteca.buscarLibro(criterioBus,inputBusqueda);

        for (Libro libro : resultados) {
            System.out.println("resultados: "+libro.getAutor());
            System.out.println("resultados: "+libro.getTitulo());
        }


        // Limpiar la tabla
        this.modeloTabla.setRowCount(0);
        System.out.println("Limpie la tabla...");


        // Añadir resultados a la tabla
        if (resultados != null) {
            for (Libro libro : resultados) {
                String prestadoText = libro.isPrestado() ? "Sí" : "No";
                this.modeloTabla.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn(), 2002, prestadoText});
            }
        }
    }
}
