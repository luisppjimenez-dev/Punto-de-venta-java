import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que crea la ventana principal del sistema
 * de punto de venta "Tiendita Don Roy".
 *  * @author Luis
 *  * @version 1.0
 */
public class VentanaPrincipal extends JFrame {

    /**
     * Constructor que crea la ventana principal del sistema.
     *
     * La ventana:
     * - Tiene el título "Tiendita Don Roy - de tamaño 900 x 600 píxeles - Se centra en el monito Se cierra completamente al presionar la X
     * y por ultimo inserta una imagen al centro del panel CENTER
     */
    public VentanaPrincipal(){
        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());
        add(new PanelBotones(), BorderLayout.NORTH);

        // PANEL CENTRO (imagen tienda)
        ImageIcon tienda = new ImageIcon("src/store.png");
        JLabel tiendaLabel = new JLabel(tienda);
        tiendaLabel.setHorizontalAlignment(JLabel.CENTER);
        tiendaLabel.setBackground(Color.WHITE);
        tiendaLabel.setOpaque(true);// que hace permite que el fondo sí se pinte
        add(tiendaLabel, BorderLayout.CENTER);

        setVisible(true);
    }
}


//BorderLayout	divide la ventana en 5 zonas
//FlowLayout	coloca componentes en fila
//GridLayout	crea una tabla
//BoxLayout	acomoda en columna o fila

//WEST sur
//CENTER
//NORTH
//EAST Este
//WEST Oeste