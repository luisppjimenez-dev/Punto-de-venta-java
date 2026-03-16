import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
     * - Tiene el título "Tiendita Don Roy"
     * - de tamaño 900 x 600 píxeles
     * - Se centra en el monito Se cierra completamente al presionar la X
     */
    public VentanaPrincipal(){
        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel panelBotonLogo = new JPanel(new BorderLayout());
        panelBotonLogo.setBackground(Color.PINK);
        ImageIcon logo = new ImageIcon("src/donroy.png");
        JLabel botonLogo = new JLabel(logo);
        panelBotonLogo.add(botonLogo, BorderLayout.WEST);

        // PANEL BOTONES
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 30));
        panelBotones.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelBotones.setBackground(Color.ORANGE);

        JButton puntoVenta = new JButton("Punto de venta");
        JButton inventario = new JButton("Inventario");
        JButton historial = new JButton("<html><center>Historial<br>de ventas</center></html>");

        puntoVenta.setFont(new Font("Open Sans", Font.BOLD, 18));
        inventario.setFont(new Font("Open Sans", Font.BOLD, 18));
        historial.setFont(new Font("Open Sans", Font.BOLD, 18));
        panelBotones.add(puntoVenta);
        panelBotones.add(inventario);
        panelBotones.add(historial);
        puntoVenta.setBackground(new Color(255, 51, 51));
        inventario.setBackground(new Color(255, 51, 51));
        historial.setBackground(new Color(255, 51, 51));
        puntoVenta.setForeground(Color.WHITE);
        inventario.setForeground(Color.WHITE);
        historial.setForeground(Color.WHITE);

        JLabel centro = new JLabel("Centro", JLabel.CENTER);
        centro.setOpaque(true);
        centro.setBackground(Color.WHITE);
        // PANEL CENTRO (imagen tienda)
        ImageIcon tienda = new ImageIcon("src/store.png");
        JLabel tiendaLabel = new JLabel(tienda);
        tiendaLabel.setHorizontalAlignment(JLabel.CENTER);
        tiendaLabel.setBackground(Color.WHITE);
        tiendaLabel.setOpaque(true);// que hace permite que el fondo sí se pinte
        add(tiendaLabel, BorderLayout.CENTER);

        JPanel sur = new JPanel();
        sur.setBackground(Color.RED);

        add( panelBotonLogo, BorderLayout.NORTH);
        panelBotonLogo.add(panelBotones, BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);

        setVisible(true);

        setVisible(true);
    }
}


