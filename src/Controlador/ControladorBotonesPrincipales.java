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

public class ControladorBotonesPrincipales {

    private Navegador ventana;
    private InterfazBtnPrincipales vista;
    private PanelInventario inventario;


    public ControladorBotonesPrincipales(Navegador ventana, InterfazBtnPrincipales vista,PanelInventario inventario) {

        this.ventana = ventana;
        this.vista = vista;
        this.inventario = inventario;

        this.vista.addInventarioListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(inventario);
            }
        });

        this.vista.addPuntoVentaListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(new PanelPuntoDeVenta());
            }
        });

        this.vista.addHistorialListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventana.mostrarPanel(new PanelHistorial());
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