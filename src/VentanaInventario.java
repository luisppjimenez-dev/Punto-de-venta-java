import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaInventario extends JFrame {
    public VentanaInventario() {
        //Crear mi ventana
        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.PINK);


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
        puntoVenta.setBackground(new Color(255, 0, 0));
        inventario.setBackground(new Color(255, 0, 0));
        historial.setBackground(new Color(255, 0, 0));
        puntoVenta.setForeground(Color.WHITE);
        inventario.setForeground(Color.WHITE);
        historial.setForeground(Color.WHITE);

        JLabel centro = new JLabel("Centro", JLabel.CENTER);
        centro.setOpaque(true);
        centro.setBackground(Color.WHITE);


        JPanel sur = new JPanel();
        sur.setBackground(Color.RED);

        add( panelBotonLogo, BorderLayout.NORTH);
        panelBotonLogo.add(panelBotones, BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);




        // Acciones botones =============

        botonLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                new VentanaPrincipal().setVisible(true);
                setVisible(false);
            }
        });

        puntoVenta.addActionListener(e -> {
            new VentanaPuntoDeVenta().setVisible(true);
            setVisible(false);
        });

        inventario.addActionListener(e -> {
            new VentanaInventario().setVisible(true);
            setVisible(false);
        });


        historial.addActionListener(e -> {
            new  VentanaHistorial().setVisible(true);
            setVisible(false);
        });

        // Acciones botones solo apariencia=============


        // 1. Cargar las imágenes una sola vez (como atributos o variables locales antes del listener)
        ImageIcon donroy = new ImageIcon("src/donroy.png");
        ImageIcon donroyG = new ImageIcon("src/donroyG.png");

        // 2. Usarlas en el MouseAdapter
        botonLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                botonLogo.setIcon(donroyG);
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                botonLogo.setIcon(donroy);
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




        setVisible(true);



    }
}
