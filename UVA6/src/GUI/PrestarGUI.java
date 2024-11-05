package GUI;

import modelo.Biblioteca;
import modelo.Libro;

import javax.swing.*;
import java.awt.*;

public class PrestarGUI extends JFrame {
    private Biblioteca biblioteca;

    public PrestarGUI() {
        this.biblioteca = new Biblioteca();
        setTitle("Prestar libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);

        JPanel panelInput = new JPanel(new FlowLayout());

        JLabel inputText = new JLabel("Nombre: ");
        JTextField inputTitulo = new JTextField("", 20);

        JButton prestarButton = new JButton("Prestar");

        panelInput.add(inputText);
        panelInput.add(inputTitulo);
        panelInput.add(prestarButton);

        JPanel panelPrincipal = new JPanel(new GridLayout(2, 1));
        panelPrincipal.add(panelInput);

        add(panelPrincipal);

        prestarButton.addActionListener(e -> {
            String titulo = inputTitulo.getText();
            Libro libro = biblioteca.buscarLibro(titulo);

            if (libro == null) {
                JOptionPane.showMessageDialog(this, "El libro no fue encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (libro.isPrestado()) {
                JOptionPane.showMessageDialog(this, "El libro ya está prestado.", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else {
                biblioteca.prestarLibro(titulo);
                JOptionPane.showMessageDialog(this, "Libro prestado: " + titulo);
            }
        });
    }
}
