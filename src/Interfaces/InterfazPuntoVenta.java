package Interfaces;

import java.awt.event.ActionListener;

/**
 * Interfaz para evitar el acoplamiento en los botones punto de Venta
 *  * @author Erick
 *  * @version 1.0
 */

public interface InterfazPuntoVenta {
    /**
     *Agrega articulo al carrito de venta
     * @param listener escucha del botón Agregar
     */
    void addAgregarListener(ActionListener listener);
    /**
     *Imprime tiket y agrega venta a historial
     * @param listener escucha del botón Pagar
     */
    void addPagarListener(ActionListener listener);
    /**
     *Cancela compra y deja el carrito vacío
     * @param listener escucha del botón cancelar
     */
    void addCancelarListener(ActionListener listener);
    /**
     *Elimina Producto seleccionado
     * @param listener escucha del botón eliminar Producto
     */
    void addEliminarListener(ActionListener listener);

    void addBuscarListener(ActionListener listener);

    // Entradas

    /**
     * retornamos el texto ingresado en el buscador
     * @return cadena de texto del buscador
     */
    String getTextoBuscador();
    /**
     *retornamos la posicion de la fila de la tabla
     * @return posicion de la fila en la tabla
     */
    int getFilas();
    /**
     *retornamos el dato de la fila y columna seleccionada
     * @param fila posicion de la tabla
     * @param columna posicion columna
     * @return dato del objeto
     */
    Object getValor(int fila, int columna);
    int getFilaSeleccionada();
    /**
     * limpia el buscador despues de agregar
     */
    void limpiarBuscador();
    /**
     * metodo para crear ventana emergente de aviso
     * @param mensaje que quieres que muestre el aviso
     */
    void mostrarMensaje(String mensaje);
    /**
     * metodos para agregar objeto a la tabla
     * @param fila objeto para agregar ala tabla
     */
    void agregarFila(Object[] fila);
    /**
     * modifica el dato del objeto en la fila y columna seleccionada
     * @param valor El dato del objeto
     * @param fila la poscion de la fila
     * @param columna la psoicion de la columna
     */
    void setValor(Object valor, int fila, int columna);
    /**
     * Elimina fila atraves de su posicion
     * @param fila posicion de la tabla
     */
    void eliminarFila(int fila);
    /**
     * Limpia tabla despues de pagar o cancelar
     */
    void limpiarTabla();
    /**
     * Modifica el total cada que se agrega producto o quita
     * @param total a modificar
     */
    void actualizarTotal(double total);

}
