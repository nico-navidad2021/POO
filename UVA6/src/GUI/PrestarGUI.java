package GUI;

import modelo.Biblioteca;

import javax.swing.*;
import java.awt.*;

public class PrestarGUI extends JFrame {
    private Biblioteca biblioteca;

    public PrestarGUI() {
        this.biblioteca = new Biblioteca();
        setTitle("Prestar libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);


        JPanel panelInput = new JPanel(new FlowLayout());

        JLabel inputText = new JLabel("Nombre: ");

        JTextField inputTitulo = new JTextField("",20);
        inputTitulo.setMinimumSize(new Dimension(150, 30));
        inputTitulo.setSize(new Dimension(150, 30));

        JButton prestarButton = new JButton();
        prestarButton.setText("Prestar");

        panelInput.add(inputText);
        panelInput.add(inputTitulo);
        panelInput.add(prestarButton);


        JPanel panelResultado = new JPanel(new FlowLayout());

        JPanel panelPrincipal = new JPanel(new GridLayout(2, 1));
        panelPrincipal.add(panelInput);
        panelPrincipal.add(panelResultado);

        add(panelPrincipal);

        prestarButton.addActionListener(e -> {
            String titulo = inputTitulo.getText();
            biblioteca.prestarLibro(titulo);
            JOptionPane.showMessageDialog(this, "Libro prestado: " + titulo);
        });
    }
}
