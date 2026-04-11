package Controlador;

import Interfaces.Navegador;
import Interfaces.InterfazBtnPrincipales;
import Vista.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Controlador de las acciones de los botones pricipales
 *  * @author Erick
 *  * @version 1.0
 */

public class ControladorBotonesPrincipales {

    private Navegador ventana;
    private InterfazBtnPrincipales vista;
    private PanelInventario inventario;
    private PanelPuntoDeVenta puntoVenta;
    private PanelHistorial historial;


    public ControladorBotonesPrincipales(Navegador ventana, InterfazBtnPrincipales vista,PanelInventario inventario,
    PanelPuntoDeVenta puntoVenta, PanelHistorial historial ) {

        this.ventana = ventana;
        this.vista = vista;
        this.inventario = inventario;
        this.puntoVenta = puntoVenta;
        this.historial = historial;

        this.vista.addInventarioListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(inventario);
            }
        });

        this.vista.addPuntoVentaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(puntoVenta);
            }
        });

        this.vista.addHistorialListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(historial);
            }
        });

        this.vista.addBotonLogoListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ventana.mostrarPanel(new PanelInicio());
            }
        });
    }
}