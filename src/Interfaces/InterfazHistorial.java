package Interfaces;

import java.awt.event.ActionListener;
/**
 * Interfaz para evitar acoplo en Historial de Ventas
 *  * @author Erick
 *  * @version 1.0
 */
public interface InterfazHistorial {
    /**
     * Muestra una ventana emergente la tabla de ventas
     *
     * @param listener escucha del boton ver
     */
    void addVerListener(ActionListener listener);

    void addBuscarListener(ActionListener listener);
    /**
     * Este metodo Agrega la venta a la tabla
     * @param fecha de venta
     * @param hora de venta
     * @param total a pagar
     */
    void agregarVenta(String fecha, String hora, double total);
    /**
     * Getter para seleccionar venta
     * @return posicion de la venta
     */
    int getFilaSeleccionada();
    /**
     *retornamos el dato de la fila y columna seleccionada
     * @param fila posicion de la tabla
     * @param columna posicion columna
     * @return dato del objeto
     */
    String getValorTabla(int fila, int columna);
    /**
     * Imprime un string en formato de texto
     * @param texto tiket de compra
     */
    void mostrarTicket(String texto);
    /**
     * Metodo para buscar atraves del buscador en la tabla
     * @param texto cadena que se escribe en el buscador
     */
    void filtrarHistorial(String texto);
    /**
     * getter para retornar la cadena que se escribe en el buscador
     * @returnretorna la cadena escrita en el buscador desde el panel buscar
     */
    String getTextoBusqueda();
}
