package Controlador;

import Interfaces.Navegador;
import Vista.PanelInventario;
import Vista.DialogProducto;
import Vista.PanelProductoFormulario;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorInventario {

    private PanelInventario vista;
    private Navegador ventana;

    public ControladorInventario(Navegador ventana, PanelInventario vista) {
        this.ventana = ventana;
        this.vista = vista;

        vista.addAgregarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DialogProducto dialog = new DialogProducto((JFrame) ventana, "Agregar Producto");

                dialog.getPanel().getGuardar().addActionListener(ev -> {

                    String id = dialog.getPanel().getId();
                    String nombre = dialog.getPanel().getNombre();
                    String stock = dialog.getPanel().getStock();
                    String precio = dialog.getPanel().getPrecio();

                    if (id.isEmpty() || nombre.isEmpty() || stock.isEmpty() || precio.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Todos los campos son obligatorios");
                        return;
                    }

                    vista.agregarFila(new Object[]{id, nombre, stock, precio});

                    dialog.dispose();
                });

                dialog.getPanel().getCancelar().addActionListener(ev -> dialog.dispose());

                dialog.setVisible(true);
            }
        });

        vista.addImprimirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.imprimirInventarioCompleto();
            }
        });

        vista.addModificarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] data = vista.getProductoSeleccionado();

                if (data == null) {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
                    return;
                }

                DialogProducto dialog = new DialogProducto((JFrame) ventana, "Modificar Producto");
                PanelProductoFormulario form = dialog.getPanel();

                // cargar datos (activa modo edición)
                form.cargarDatos(
                        data[1].toString(),
                        data[0].toString(),
                        data[3].toString(),
                        data[2].toString()
                );

                // limpiar listeners
                for (ActionListener al : form.getGuardar().getActionListeners()) {
                    form.getGuardar().removeActionListener(al);
                }

                form.getGuardar().addActionListener(ev -> {

                    String nombre = form.getNombre();
                    String id = form.getId();
                    String stock = form.getStock();
                    String precio = form.getPrecio();

                    if (nombre.isEmpty() || id.isEmpty() || stock.isEmpty() || precio.isEmpty()) {
                        JOptionPane.showMessageDialog(dialog, "Todos los campos son obligatorios");
                        return;
                    }

                    // actualizar fila
                    vista.actualizarFilaSeleccionada(new Object[]{id, nombre, stock, precio});

                    dialog.dispose();
                });

                form.getCancelar().addActionListener(ev -> dialog.dispose());

                dialog.setVisible(true);
            }
        });

        vista.addEliminarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int fila = vista.getFilaSeleccionada();

                if (fila == -1) {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto para eliminar");
                    return;
                }

                //  Obtener datos para mostrar (opcional pero recomendado)
                Object[] data = vista.getProductoSeleccionado();

                int confirm = JOptionPane.showConfirmDialog(
                        null,
                        "¿Eliminar producto: " + data[1] + "?",
                        "Confirmar eliminación",
                        JOptionPane.YES_NO_OPTION
                );

                if (confirm == JOptionPane.YES_OPTION) {
                    vista.eliminarFila(fila); // AQUÍ ESTÁ LA CLAVE
                }
            }
        });
    }
}

