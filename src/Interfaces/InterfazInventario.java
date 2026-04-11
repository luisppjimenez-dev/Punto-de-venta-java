package Interfaces;

import java.awt.event.ActionListener;

/**
 * Interfaz para evitar el acoplamiento en los botones de invnetario
 *  * @author Erick
 *  * @version 1.0
 */

public interface InterfazInventario {
    /**
     *Abre la ventana modificar
     * @param listener escucha del botón modificar
     */
     void addModificarListener(ActionListener listener);
    /**
     *Abre la ventana Agregar Nuevo
     * @param listener escucha del botón Agregar Nuevo
     */
    void addAgregarListener(ActionListener listener);
    /**
     *Imprime el inventario completo
     * @param listener escucha del botón imprimir
     */
     void addImprimirListener(ActionListener listener);
    /**
     *elimina el inventario seleccionado
     * @param listener escucha del botón eliminar
     */
     void addEliminarListener(ActionListener listener);
    /**
     *Busca Producto insertado en el buscador
     * @param listener escucha del botón Buscar
     */
    void addBuscarListener(ActionListener listener);
    /**
     * Metodo para agregar una fila al modelo con un arreglo de objetos
     *     }
     * @param fila arreglo de objetos para agregar a tabla invnetario
     */
    void agregarFila(Object[] fila);

    /**
     * Elimina la fila seleeciona atraves de su posicion
     * @param fila entero para escoger la posicion de la fila
     */
    void eliminarFila(int fila);
    /**
     * Ordena la filas correctamente en modelo atraves del sorter
     * @param fila entero para seleccionar la posicion a actualizar
     * @param datos objetos que con los datos que se movera
     */
    void actualizarFila(int fila, Object[] datos);
    /**
     * getter getter que retorna la pocision de la fila seleccionada
     * @return entero posicion de la fila seleccionada en la tabla
     */
    int getFilaSeleccionada();
    /**
     *Retorna el producto seleccionado verificando si se seleciono correctamente,
     * @return retorna la fila seleecionada con todos sus datos en objeto
     */
    Object[] getProductoSeleccionado();

    /**
     * Metodo que abre una ventana y agrega el mensaje a mostrar
     * @param mensaje que desea que aparesca en la ventana
     */
    void mostrarMensaje(String mensaje);
    /**
     * Metodo para imprimir el invnetario completo
     */
    void imprimirInventarioCompleto();
    /**
     * Este metodo filtra el texto para buscarlo en la tabla evitando minusculas y mayusculas atraves del sorter
     * @param texto cadena que se buscara en tabla
     */
    void filtrarTabla(String texto);
    /**
     * Getter para obtener el texto introducido en el buscador
     * @return texto introducido en el buscador
     */
    String getTextoBuscador();

    /**
     * Busca Producto por nombre para mandarlo a la tabla de punto de venta
     * @param nombre del producto a comprar
     * @return el producto encontrado con todos sus datos
     */
    Object[] buscarProductoPorNombre(String nombre);

    /**
     * Modificamos del stock del producto comprado
     * @param id del producto comprado
     * @param nuevoStock la cantidad del nuevo stock depsues de comprar
     */
    void actualizarStock(String id, int nuevoStock);

}
