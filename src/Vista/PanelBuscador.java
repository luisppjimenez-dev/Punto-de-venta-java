package Vista;

import javax.swing.*;
import java.awt.*;
/**
 * Panel para la visualizacion del buscador en los paneles pricipales
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelBuscador extends JPanel {
    private JButton btnBuscar;
    private JTextField buscador;

    public PanelBuscador(){
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        buscador = new JTextField(15);
        buscador.setPreferredSize(new Dimension(180, 30));

        btnBuscar = new JButton("🔍");
        btnBuscar.setFocusPainted(false);

        // En el centro del primer panel se usara una panel flow para mover a la derecha el buscador
        JPanel derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        derecha.setBackground(Color.WHITE);
        derecha.add(btnBuscar);
        derecha.add(buscador);

        //Creamos lineas
        JSeparator lineaArriba = new JSeparator();
        JSeparator lineaAbajo = new JSeparator();

        // Organizamos El panel norte
        add(lineaArriba, BorderLayout.NORTH);
        add(derecha, BorderLayout.CENTER);
        add(lineaAbajo, BorderLayout.SOUTH);
    }

    public JTextField getBuscador() {
        return buscador;
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }
}
