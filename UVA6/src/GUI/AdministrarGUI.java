package GUI;

import modelo.Biblioteca;
import modelo.Libro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministrarGUI extends JFrame {
    private Biblioteca biblioteca;
    private JTextField inputTitulo;
    private JTextField inputAutor;
    private JTextField inputIsbn;
    private JCheckBox checkPrestado;
    private JTable tablaLibros;
    private DefaultTableModel modeloTabla;

    public AdministrarGUI() {
        this.biblioteca = new Biblioteca();
        setTitle("Administración de libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);

        JPanel panelInput = new JPanel(new GridLayout(6, 2, 5, 5));

        JLabel labelTitulo = new JLabel("Título:");
        inputTitulo = new JTextField(20);
        JLabel labelAutor = new JLabel("Autor:");
        inputAutor = new JTextField(20);
        JLabel labelIsbn = new JLabel("ISBN:");
        inputIsbn = new JTextField(20);
        JLabel labelPrestado = new JLabel("Prestado:");
        checkPrestado = new JCheckBox();

        panelInput.add(labelTitulo);
        panelInput.add(inputTitulo);
        panelInput.add(labelAutor);
        panelInput.add(inputAutor);
        panelInput.add(labelIsbn);
        panelInput.add(inputIsbn);
        panelInput.add(labelPrestado);
        panelInput.add(checkPrestado);

        JButton agregarButton = new JButton("Agregar");
        JButton modificarButton = new JButton("Modificar");
        JButton eliminarButton = new JButton("Eliminar");

        panelInput.add(agregarButton);
        panelInput.add(modificarButton);
        panelInput.add(eliminarButton);

        modeloTabla = new DefaultTableModel(new String[]{"Título", "Autor", "ISBN", "Prestado"}, 0);
        tablaLibros = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tablaLibros);

        cargarLibrosEnTabla();

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.add(panelInput, BorderLayout.NORTH);
        panelPrincipal.add(scrollPane, BorderLayout.CENTER);

        add(panelPrincipal);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarLibro();
            }
        });

        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarLibro();
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }

    private void agregarLibro() {
        String titulo = inputTitulo.getText();
        String autor = inputAutor.getText();
        String isbn = inputIsbn.getText();
        boolean prestado = checkPrestado.isSelected();

        if (!titulo.isEmpty() && !autor.isEmpty() && !isbn.isEmpty()) {
            Libro libro = new Libro(titulo, autor, isbn, prestado);
            biblioteca.agregarLibro(libro);
            modeloTabla.addRow(new Object[]{titulo, autor, isbn, prestado ? "Sí" : "No"});
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarLibro() {
        int selectedRow = tablaLibros.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para modificar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String tituloOriginal = (String) modeloTabla.getValueAt(selectedRow, 0);
        String titulo = inputTitulo.getText();
        String autor = inputAutor.getText();
        String isbn = inputIsbn.getText();
        boolean prestado = checkPrestado.isSelected();

        if (!titulo.isEmpty() && !autor.isEmpty() && !isbn.isEmpty()) {
            biblioteca.modificarLibro(tituloOriginal, titulo, autor, isbn, prestado);

            modeloTabla.setValueAt(titulo, selectedRow, 0);
            modeloTabla.setValueAt(autor, selectedRow, 1);
            modeloTabla.setValueAt(isbn, selectedRow, 2);
            modeloTabla.setValueAt(prestado ? "Sí" : "No", selectedRow, 3);

            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void eliminarLibro() {
        int selectedRow = tablaLibros.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro para eliminar.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String titulo = (String) modeloTabla.getValueAt(selectedRow, 0);
        biblioteca.eliminarLibro(biblioteca.buscarLibro(titulo));
        modeloTabla.removeRow(selectedRow);
        limpiarCampos();
    }

    private void cargarLibrosEnTabla() {
        modeloTabla.setRowCount(0);
        for (Libro libro : biblioteca.getLibrosAlmacenados()) {
            modeloTabla.addRow(new Object[]{libro.getTitulo(), libro.getAutor(), libro.getIsbn(), libro.isPrestado() ? "Sí" : "No"});
        }
    }

    private void limpiarCampos() {
        inputTitulo.setText("");
        inputAutor.setText("");
        inputIsbn.setText("");
        checkPrestado.setSelected(false);
    }
}
