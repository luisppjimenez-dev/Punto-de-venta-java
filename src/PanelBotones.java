import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * recibir la ventana principal:
 * Clase que crea los botones principales del sistema
 * y sirve para las ventanas: Principal, Invetario , Historial
 *
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelBotones extends JPanel{
    private VentanaPrincipal ventana;

    public PanelBotones(VentanaPrincipal ventana) {

        this.ventana = ventana;

        setLayout(new BorderLayout());

        JPanel panelBotonLogo = new JPanel(new BorderLayout());
        panelBotonLogo.setBackground(Color.WHITE);
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


        // ACCIONES
        puntoVenta.addActionListener(e -> {
            ventana.mostrarPanel(new PanelPuntoDeVenta());
        });

        inventario.addActionListener(e -> {
            ventana.mostrarPanel(new PanelInventario());
        });

        historial.addActionListener(e -> {
            ventana.mostrarPanel(new PanelHistorial());
        });

        botonLogo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPanel(new PanelInicio());
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
                puntoVenta.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                puntoVenta.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

        inventario.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                inventario.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                inventario.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

        historial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                historial.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                historial.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });

    }
}
