import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Clase que crea los botones principales del sistema
 * y sirve para las ventanas:
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelBotones extends JPanel{
    public PanelBotones() {

        setLayout(new BorderLayout());

        JPanel panelBotonLogo = new JPanel(new BorderLayout());
        panelBotonLogo.setBackground(Color.WHITE);
        // 1. Cargar las imágenes una sola vez (como atributos o variables locales antes del listener)
        ImageIcon logoG = new ImageIcon("src/donroyG.png");
        ImageIcon logo = new ImageIcon("src/donroy.png");
        JLabel botonLogo = new JLabel(logo);
        panelBotonLogo.add(botonLogo, BorderLayout.WEST);

        // PANEL BOTONES
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 30));
        panelBotones.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelBotones.setBackground(Color.WHITE);

        JButton puntoVenta = new JButton("Punto de venta");
        JButton inventario = new JButton("Inventario");
        JButton historial = new JButton("<html><center>Historial<br>de ventas</center></html>");

        puntoVenta.setFont(new Font("Open Sans", Font.BOLD, 18));
        inventario.setFont(new Font("Open Sans", Font.BOLD, 18));
        historial.setFont(new Font("Open Sans", Font.BOLD, 18));
        panelBotones.add(puntoVenta);
        panelBotones.add(inventario);
        panelBotones.add(historial);
        puntoVenta.setBackground(new Color(255, 0, 0));
        inventario.setBackground(new Color(255, 0, 0));
        historial.setBackground(new Color(255, 0, 0));
        puntoVenta.setForeground(Color.WHITE);
        inventario.setForeground(Color.WHITE);
        historial.setForeground(Color.WHITE);
        puntoVenta.setFocusPainted(false);
        inventario.setFocusPainted(false);
        historial.setFocusPainted(false);

        add(panelBotonLogo, BorderLayout.NORTH);
        panelBotonLogo.add(panelBotones, BorderLayout.CENTER);


        // Acciones botones =============

        puntoVenta.addActionListener(e -> {
            Window ventana = SwingUtilities.getWindowAncestor(this);
            ventana.dispose();
            new VentanaPuntoDeVenta().setVisible(true);
        });

        inventario.addActionListener(e -> {
            Window ventana = SwingUtilities.getWindowAncestor(this);
            ventana.dispose();
            new VentanaInventario().setVisible(true);
        });


        historial.addActionListener(e -> {
            Window ventana = SwingUtilities.getWindowAncestor(this);
            ventana.dispose();
            new VentanaHistorial().setVisible(true);
        });

        // Acciones botones solo apariencia=============




        // 2. Usarlas en el MouseAdapter
        botonLogo.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Window ventana = SwingUtilities.getWindowAncestor(PanelBotones.this);
                ventana.dispose();
                new VentanaPrincipal().setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                botonLogo.setIcon(logoG);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonLogo.setIcon(logo);
            }

        });

        puntoVenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                puntoVenta.setBackground(new Color(239, 75, 75));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                puntoVenta.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

        inventario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                inventario.setBackground(new Color(239, 75, 75));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                inventario.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

        historial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                historial.setBackground(new Color(239, 75, 75));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                historial.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

    }
}
