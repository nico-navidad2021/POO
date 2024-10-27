package GUI;

import javax.swing.*;
import java.awt.*;

public class BuscarGUI extends JFrame {
    public BuscarGUI() {

        setTitle("Busqueda libros");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);



        JPanel panelInput = new JPanel(new FlowLayout());

        JLabel inputText = new JLabel("Nombre: ");

        JTextArea inputTitulo = new JTextArea();
        inputTitulo.setSize(150,50);
        inputTitulo.setMinimumSize(new Dimension(150,50));

        JButton buscarButton = new JButton();
        buscarButton.setText("Buscar");

        panelInput.add(inputText);
        panelInput.add(inputTitulo);
        panelInput.add(buscarButton);


        JPanel panelResultado = new JPanel(new FlowLayout());

        JPanel panelPrincipal = new JPanel(new GridLayout(2, 1));
        panelPrincipal.add(panelInput);
        panelPrincipal.add(panelResultado);

        add(panelPrincipal);


    }
}
