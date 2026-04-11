package Vista;

import javax.swing.*;
import java.awt.*;

/**
 * Panel del boton logo
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelInicio extends JPanel {

    public PanelInicio(){
        //creamos layout border para el panel principal
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        // Cargamos la imagen
        ImageIcon tienda = new ImageIcon(getClass().getResource("/imagenes/store.png"));
        JLabel imagentienda = new JLabel(tienda);

        //Alineamos imagen
        imagentienda.setHorizontalAlignment(JLabel.CENTER);
        imagentienda.setVerticalAlignment(JLabel.CENTER);

        add(imagentienda, BorderLayout.CENTER);
    }
}