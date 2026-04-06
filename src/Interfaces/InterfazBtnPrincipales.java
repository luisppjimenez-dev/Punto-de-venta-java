package Interfaces;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface InterfazBtnPrincipales {
    /**
     *Cambia el panel inferior a punto de venta
     * @param listener escucha del botón punto de veta
     */
    public void addPuntoVentaListener(ActionListener listener);
    /**
     *Cambia el panel inferior a inventario
     * @param listener escucha del botón Inventario
     */
    public void addInventarioListener(ActionListener listener);
    /**
     *Cambia el panel inferior a Historial de ventas
     * @param listener escucha del botón Historial de ventas
     */
    public void addHistorialListener(ActionListener listener);
    /**
     *Cambia el panel inferior a Ventana Principal
     * @param listener escucha del botón logo
     */
    public void addBotonLogoListener(MouseListener listener);

}
