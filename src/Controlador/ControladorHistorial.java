package Controlador;

import Interfaces.InterfazHistorial;
import Interfaces.InterfazPuntoVenta;
import Interfaces.Navegador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador de las acciones de los botones Historial
 *  * @author Erick
 *  * @version 1.0
 */
public class ControladorHistorial {
    private Navegador ventana;
    private InterfazHistorial vista;
    private InterfazPuntoVenta puntoVenta;

    public ControladorHistorial(Navegador ventana, InterfazHistorial vista, InterfazPuntoVenta  puntoVenta) {
        this.ventana = ventana;
        this.vista = vista;
        this.puntoVenta = puntoVenta;

        vista.addVerListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verVenta();
            }
        });

        vista.addBuscarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = vista.getTextoBusqueda();
                vista.filtrarHistorial(texto);
            }
        });

    }

    /**
     * Metodo para mostrar la venta seleccionada
     */
    private void verVenta() {
        int fila = vista.getFilaSeleccionada();

        if (fila == -1) {
            vista.mostrarTicket("Selecciona una venta");
            return;
        }
        String fecha = vista.getValorTabla(fila, 0);
        String hora = vista.getValorTabla(fila, 1);
        String total = vista.getValorTabla(fila, 2);

        String ticket =
                "===== VENTA =====\n\n" +
                        "Fecha: " + fecha + "\n" +
                        "Hora: " + hora + "\n" +
                        "Total: $" + total + "\n" +
                        "=================";
        vista.mostrarTicket(ticket);
    }
}
