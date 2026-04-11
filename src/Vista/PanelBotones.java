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
 * Crea los botones del menu principal que esta fijo en la parte superior de las ventana principal
 *  * @author Luis
 *  * @version 1.0
 */

public class PanelBotones extends JPanel implements InterfazBtnPrincipales {

    // Creamos botones pricipales
    private JButton puntoVenta;
    private JButton inventario;
    private JButton historial;
    private JLabel botonLogo;
    private ImageIcon logo;
    private ImageIcon logoG;


    public PanelBotones() {

        //Dividimos el panel con border
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        //Creamos un nuevo panel para el boton logo
        JPanel panelBotonLogo = new JPanel(new BorderLayout());
        panelBotonLogo.setBackground(Color.WHITE);

        //Cargamos la imagen logo
        logo = new ImageIcon(getClass().getResource("/imagenes/donroy.png"));
        logoG = new ImageIcon(getClass().getResource("/imagenes/donroyG.png"));
        botonLogo = new JLabel(logo);
        panelBotonLogo.add(botonLogo, BorderLayout.WEST);


        // Panel Botones pricipales los ordenamos con grid layout en columnas y modificamos dimensiones de los botones
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 30, 30));
        panelBotones.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelBotones.setBackground(Color.WHITE);

        puntoVenta = new JButton("Punto de venta");
        inventario = new JButton("Inventario");
        historial = new JButton("<html><center>Historial<br>de ventas</center></html>");

        // Estetica de botones
        EsteticaBoton.estilizarBoton(puntoVenta);
        EsteticaBoton.estilizarBoton(inventario);
        EsteticaBoton.estilizarBoton(historial);

        EsteticaBoton.resaltadoBotones(puntoVenta);
        EsteticaBoton.resaltadoBotones(inventario);
        EsteticaBoton.resaltadoBotones(historial);
        efectoLogo();

        panelBotones.add(puntoVenta);
        panelBotones.add(inventario);
        panelBotones.add(historial);

        // Ordenar boton de logo al norte y  despues el panel botones en el centro
        add(panelBotonLogo, BorderLayout.NORTH);
        panelBotonLogo.add(panelBotones, BorderLayout.CENTER);


    }

    // Escuchas de los botones
    public void addPuntoVentaListener(ActionListener listener) {
        puntoVenta.addActionListener(listener);
    }

    public void addInventarioListener(ActionListener listener) {
        inventario.addActionListener(listener);
    }

    public void addHistorialListener(ActionListener listener) {
        historial.addActionListener(listener);
    }

    public void addBotonLogoListener(MouseListener listener) {
        botonLogo.addMouseListener(listener);
    }

    /**
     * Metodo para resaltar la imagen del logo cuando el cursor pase por el
     */
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
