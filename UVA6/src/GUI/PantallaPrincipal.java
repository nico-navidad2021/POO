package GUI;

import javax.swing.*;
import java.awt.*;


public class PantallaPrincipal extends JFrame {
    public PantallaPrincipal() {
        setTitle("Biblioteca");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);

        // Crear botones
        JButton buscarButton = new JButton();
        buscarButton.setText("Buscar");
        buscarButton.addActionListener(e -> new BuscarGUI().setVisible(true));

        JButton prestarButton = new JButton();
        prestarButton.setText("Prestar");
        prestarButton.addActionListener(e -> new PrestarGUI().setVisible(true));

        JButton devolverButton = new JButton();
        devolverButton.setText("Devolver");
        devolverButton.addActionListener(e -> new PrestarGUI().setVisible(true));

        JButton adminButton = new JButton();
        adminButton.setText("Administrar");
        adminButton.addActionListener(e -> new AdministrarGUI().setVisible(true));


        JPanel panelPrincipal = new JPanel(new GridLayout(4, 1,10,10));
        panelPrincipal.add(buscarButton);
        panelPrincipal.add(prestarButton);
        panelPrincipal.add(devolverButton);
        panelPrincipal.add(adminButton);

        add(panelPrincipal);

    }


}
