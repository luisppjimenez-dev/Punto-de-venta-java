package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Modifica los botones tamto en tamaño y tipo de letra y resalta cuando un cursor pasa por un boton
 *  * @author Luis
 *  * @version 1.0
 */
public class EsteticaBoton {

    /**
     * Modifica el color y la letra de un boton
     * @param b boton que desea modificar
     */
    public static void estilizarBoton(JButton b) {

        b.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        b.setFont(new Font("Open Sans", Font.BOLD, 18));
        b.setBackground(new Color(255, 0, 0));
        b.setForeground(Color.WHITE);
        
        b.setContentAreaFilled(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setFocusable(false);
    }
    /**
     * Resalta el boton cambiandolo de color cuando el cirsor pasa por el
     * @param b boton que quiere resaltar
     */
    public static void resaltadoBotones(JButton b){
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {b.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });
    }
}
