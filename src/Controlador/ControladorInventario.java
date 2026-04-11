package Controlador;

import Interfaces.InterfazInventario;
import Interfaces.Navegador;
import Vista.DialogProducto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Controlador de las acciones de los botones inventario
 *  * @author Erick
 *  * @version 1.0
 */

public class ControladorInventario {
    //creamos atributos usando la interfaz de inventario y navegador
    private InterfazInventario vista;
    private Navegador ventana;

    public ControladorInventario(Navegador ventana, InterfazInventario vista) {
        this.ventana = ventana;
        this.vista = vista;

        // Agregregar
        vista.addAgregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // creamos una ventana emergente atraves de la clase dialogPrducto
                DialogProducto agregarProducto = new DialogProducto((JFrame) ventana, "Agregar Producto");

                //Creamos una landa para el boton guardar que existe en la clase
                agregarProducto.getPanel().getGuardar().addActionListener(ev -> {

                    //Creamos variables auxiliares para guardar los datos de los campos de la ventana
                    String id = agregarProducto.getPanel().getId();
                    String nombre = agregarProducto.getPanel().getNombre();
                    String stock = agregarProducto.getPanel().getStock();
                    String precio = agregarProducto.getPanel().getPrecio();

                    //verificamos que no se quede ningun campo vacio si alguno esta vacio
                    //llamamos al metodo mostrar mensaje para una ventana emergente
                    if (id.isEmpty() || nombre.isEmpty() || stock.isEmpty() || precio.isEmpty()) {
                        vista.mostrarMensaje("Todos los campos son obligatorios");
                        return;
                    }

                    //Pasamos los datos al metodo agregar fila para que se agregen
                    vista.agregarFila(new Object[]{id, nombre, Integer.parseInt(stock), Double.parseDouble(precio)});
                    agregarProducto.dispose();
                });
                //Evento para el boton cancelar solo cierra la ventana
                agregarProducto.getPanel().getCancelar().addActionListener(ev -> agregarProducto.dispose());
                agregarProducto.setVisible(true);
            }
        });

        // Modificar
        vista.addModificarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Creamos un objeto y pasamos los datos del objeto seleecionado
                Object[] data = vista.getProductoSeleccionado();

                // Verificamos que se muestre un producto
                if (data == null) {
                    vista.mostrarMensaje("Seleccione un producto");
                    return;
                }

                //creamos una ventana emergente atraves de la clase dialogPrducto
                DialogProducto modificarProducto = new DialogProducto((JFrame) ventana, "Modificar Producto");

                //Cargamos los datos al formulario
                modificarProducto.getPanel().cargarDatos(
                        data[0].toString(),
                        data[1].toString(),
                        data[2].toString(),
                        data[3].toString()
                );

                //Creamos landa para el boton guardar parecido al boton agregar
                modificarProducto.getPanel().getGuardar().addActionListener(ev -> {

                    // pasamos la posicion del producto seleccionado
                    int fila = vista.getFilaSeleccionada();

                    //verificamos que si haya un producto seleccionado
                    if (fila == -1) {
                        vista.mostrarMensaje("Seleccione un producto");
                        return;
                    }

                    //Variables auxiliares para modificoar
                    String id = modificarProducto.getPanel().getId();
                    String nombre = modificarProducto.getPanel().getNombre();
                    String stock = modificarProducto.getPanel().getStock();
                    String precio = modificarProducto.getPanel().getPrecio();

                    //Actualizamos la fila seleccionada
                    vista.actualizarFila(fila, new Object[]{
                            id,
                            nombre,
                            Integer.parseInt(stock),
                            Double.parseDouble(precio)
                    });
                    modificarProducto.dispose();
                });
                //evento para boton cancelar solo cierra la ventana
                modificarProducto.getPanel().getCancelar().addActionListener(ev -> modificarProducto.dispose());
                modificarProducto.setVisible(true);
            }
        });

        // Eliminar
        vista.addEliminarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // pasamos la posicion del producto sleecionado
                int fila = vista.getFilaSeleccionada();
                //Verificamos que se selccione alguno
                if (fila == -1) {
                    vista.mostrarMensaje("Seleccione un producto");
                    return;
                }
                //Eliminamos Producto con el metodo de la interface
                vista.eliminarFila(fila);
            }
        });

        // Imprimir, atraves del metodo creado en la interface
        vista.addImprimirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.imprimirInventarioCompleto();
            }
        });
        // Buscar
        vista.addBuscarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // leemos el texto del buscador
                String texto = vista.getTextoBuscador();
                //lo filtamos en la tabla
                vista.filtrarTabla(texto);
            }
        });
    }
}

