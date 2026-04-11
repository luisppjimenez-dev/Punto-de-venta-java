package Controlador;

import Interfaces.InterfazHistorial;
import Interfaces.InterfazInventario;
import Interfaces.Navegador;
import Interfaces.InterfazPuntoVenta;
import Vista.PanelHistorial;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controlador de las acciones de los botones de Punto de venta
 *  * @author Erick
 *  * @version 1.0
 */
public class ControladorPuntoVenta {

    // cramos nuestros atributos con las interfaces
    private Navegador ventana;
    private InterfazPuntoVenta vista;
    private InterfazInventario inventario;
    private InterfazHistorial historialVista;

    public ControladorPuntoVenta(Navegador ventana, InterfazPuntoVenta vista,
                                 InterfazInventario inventario, InterfazHistorial historial ) {
        this.ventana = ventana;
        this.vista = vista;
        this.inventario = inventario;
        this.historialVista = historial;

        // Agregar producto al la tabla
        this.vista.addAgregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });

        // Buscar con lupa
        this.vista.addBuscarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto();
            }
        });


        // Eliminar
        this.vista.addEliminarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarProducto();
            }
        });

        //Cancelar
        this.vista.addCancelarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelarVenta();
            }
        });

        //Pagar
        this.vista.addPagarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pagarVenta();
            }
        });
    }



    /**
     * Metodo para agregar un producto a la tabla de punto de venta
     */
    private void agregarProducto() {

        String texto = vista.getTextoBuscador().trim();

        if (texto.isEmpty()) {
            vista.mostrarMensaje("Escribe un producto");
            return;
        }

        Object[] producto = inventario.buscarProductoPorNombre(texto);

        if (producto == null) {
            vista.mostrarMensaje("Producto no encontrado");
            return;
        }

        String id = producto[0].toString();
        String nombre = producto[1].toString();
        int stock = Integer.parseInt(producto[2].toString());
        double precio = Double.parseDouble(producto[3].toString());

        if (stock <= 0) {
            vista.mostrarMensaje("Sin stock disponible");
            return;
        }

        int fila = buscarProducto(nombre);

        if (fila != -1) {

            int cant = (int) vista.getValor(fila, 2) + 1;
            vista.setValor(cant, fila, 2);
            vista.setValor(cant * precio, fila, 4);

        } else {

            vista.agregarFila(new Object[]{
                    id,
                    nombre,
                    1,
                    precio,
                    precio
            });
        }

        //Descontamos stock
        inventario.actualizarStock(id, stock - 1);

        vista.limpiarBuscador();
        actualizarTotal();
    }

    /**
     *  metodo para buscar la posicion del producto atraves de su nombre en el carrito
     * @param nombre nombre del producto
     * @return posicion del producto
     */
    private int buscarProducto(String nombre) {
        for (int i = 0; i < vista.getFilas(); i++) {
            if (vista.getValor(i, 1).toString().equalsIgnoreCase(nombre)) {
                return i;
            }
        }
        return -1;
    }
    /**
     * Modifica el total cada que se agrega o borra producto
     */
    private void actualizarTotal() {
        double total = 0;
        for (int i = 0; i < vista.getFilas(); i++) {
            total += Double.parseDouble(vista.getValor(i, 4).toString());
        }
        vista.actualizarTotal(total);
    }
    /**
     * Metodo para el listener,  de eliminar
     */
    private void eliminarProducto() {
        int fila = vista.getFilaSeleccionada();
        if (fila == -1) {
            vista.mostrarMensaje("Selecciona un producto");
            return;
        }
        vista.eliminarFila(fila);
        actualizarTotal();
    }

    /**
     * Metodo Para el listener de Cancelar comprar
     */
    private void cancelarVenta() {
        vista.limpiarTabla();
        actualizarTotal();
        vista.mostrarMensaje("Venta cancelada");
    }

    /**
     * Metodo para el listener de pagar
     */
    private void pagarVenta() {

        if (vista.getFilas() == 0) {
            vista.mostrarMensaje("No hay productos en la venta");
            return;
        }

        //  calcula el total antes de borrar
        double total = 0;
        for (int i = 0; i < vista.getFilas(); i++) {
            total += Double.parseDouble(vista.getValor(i, 4).toString());
        }

        //  variables auxiliares para registrar fecha y hora
        String fecha = java.time.LocalDate.now().toString();
        String hora = java.time.LocalTime.now().withNano(0).toString();

        //  guardar en historial
        historialVista.agregarVenta(fecha, hora, total);

        //   ventana emergente
        vista.mostrarMensaje("Venta realizada correctamente");

        //  limpiar despues de todo
        vista.limpiarTabla();
        actualizarTotal();
    }
}