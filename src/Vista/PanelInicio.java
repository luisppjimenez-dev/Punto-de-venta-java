package Vista;

import javax.swing.*;
import java.awt.*;

public class PanelInicio extends JPanel {

    public PanelInicio(){
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        // PANEL CENTRO (imagen tienda)
        ImageIcon tienda = new ImageIcon(getClass().getResource("/imagenes/store.png"));
        JLabel imagentienda = new JLabel(tienda);

        imagentienda.setHorizontalAlignment(JLabel.CENTER);
        imagentienda.setVerticalAlignment(JLabel.CENTER);

        add(imagentienda, BorderLayout.CENTER);
    }
}