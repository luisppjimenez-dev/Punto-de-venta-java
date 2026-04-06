package Vista;

import Interfaces.InterfazBtnPrincipales;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Crea los botones del menu principal que esta fijo en la parte superior de las ventanas
 * principales
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelBotones extends JPanel implements InterfazBtnPrincipales {

    private JButton puntoVenta;
    private JButton inventario;
    private JButton historial;
    private JLabel botonLogo;
    private ImageIcon logo;
    private ImageIcon logoG;


    public PanelBotones() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        //Panel boton logo
        JPanel panelBotonLogo = new JPanel(new BorderLayout());
        panelBotonLogo.setBackground(Color.WHITE);
        logo = new ImageIcon(getClass().getResource("/imagenes/donroy.png"));
        logoG = new ImageIcon(getClass().getResource("/imagenes/donroyG.png"));
        botonLogo = new JLabel(logo);
        panelBotonLogo.add(botonLogo, BorderLayout.WEST);


        // Panel Botones pricipales
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 30));
        panelBotones.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelBotones.setBackground(Color.WHITE);

        puntoVenta = new JButton("Punto de venta");
        inventario = new JButton("Inventario");
        historial = new JButton("<html><center>Historial<br>de ventas</center></html>");

        estilizarBoton(puntoVenta);
        estilizarBoton(inventario);
        estilizarBoton(historial);

        panelBotones.add(puntoVenta);
        panelBotones.add(inventario);
        panelBotones.add(historial);

        // Ordenar boton de logo
        add(panelBotonLogo, BorderLayout.NORTH);
        panelBotonLogo.add(panelBotones, BorderLayout.CENTER);

        resaltadoBotones(puntoVenta);
        resaltadoBotones(inventario);
        resaltadoBotones(historial);
        efectoLogo();
    }

    /**
     * Este metodo modifica la estética de los botones principales
     * @param b Un Jbutton para modificar su estética
     */
    private void estilizarBoton(JButton b) {

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

    public void addPuntoVentaListener(ActionListener listener){
        puntoVenta.addActionListener(listener);
    }

    public void addInventarioListener(ActionListener listener){
        inventario.addActionListener(listener);
    }

    public void addHistorialListener(ActionListener listener){
        historial.addActionListener(listener);
    }

    public void addBotonLogoListener(MouseListener listener) {
        botonLogo.addMouseListener(listener);
    }

    public void resaltadoBotones(JButton b){
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });
    }
    private void efectoLogo() {
        botonLogo.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                botonLogo.setIcon(logoG);
            }

            public void mouseExited(MouseEvent e) {
                botonLogo.setIcon(logo);
            }
        });
    }
}
