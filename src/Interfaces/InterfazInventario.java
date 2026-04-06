package Interfaces;

import java.awt.event.ActionListener;

public interface InterfazInventario {
    /**
     *Abre la ventana modificar
     * @param listener escucha del botón modificar
     */
    public void addModificarListener(ActionListener listener);
    /**
     *Abre la ventana Agregar Nuevo
     * @param listener escucha del botón Agregar Nuevo
     */
    public void addAgregarListener(ActionListener listener);
    /**
     *Imprime el el inventario seleccionado
     * @param listener escucha del botón imprimir
     */
    public void addImprimirListener(ActionListener listener);
    /**
     *elimina el el inventario seleccionado
     * @param listener escucha del botón eliminar
     */
    public void addEliminarListener(ActionListener listener);
}
