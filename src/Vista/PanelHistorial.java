package Vista;

import Interfaces.InterfazHistorial;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel pricipal del boton historial
 *  * @author Brenda
 *  * @version 1.0
 */
public class PanelHistorial extends JPanel implements InterfazHistorial {

    private PanelBuscador panelBuscador;
    private JTable tabla;
    private JButton ver;

    //componete para ordenar tabla y filtrar el buscador
    private TableRowSorter<DefaultTableModel> sorter;
    //para guardar datos reales de la tabla
    private DefaultTableModel modelo;

    public PanelHistorial() {
        //Separamos el Layout pricipal con border
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Creamor el panel buscador y lo alineamos al norte
        panelBuscador = new PanelBuscador();
        add(panelBuscador, BorderLayout.NORTH);

        // Inicializamos la tabla y ajustamos los interlineados y agregamos el modole para datos reales
        String[] columnas = {"Fecha", "Hora", "Total"};
        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setDefaultEditor(Object.class, null);

        // sorter
        sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        //Asignamos scroll a la tabla
        JScrollPane scroll = new JScrollPane(tabla);

        //Creamos el panel de la tabla colocamos en el centro del layout principal
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);

        // Boton Ver lo acomodamos al sur del panel principal
        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBorder(new EmptyBorder(30, 50, 30, 50));
        bottom.setBackground(Color.WHITE);

        ver = new JButton("Ver");
        ver.setBackground(new Color(255, 0, 0));
        ver.setForeground(Color.WHITE);

        //Estetica
        EsteticaBoton.estilizarBoton(ver);
        EsteticaBoton.resaltadoBotones(ver);
        bottom.add(ver, BorderLayout.EAST);

        add(bottom, BorderLayout.SOUTH);
    }

    // Escuchas
    public void addVerListener(ActionListener listener) {
        ver.addActionListener(listener);
    }

    public void addBuscarListener(ActionListener listener) {
        panelBuscador.getBtnBuscar().addActionListener(listener);
    }

    //Se agrega una venta a la tabla
    public void agregarVenta(String fecha, String hora, double total) {
        modelo.addRow(new Object[]{fecha, hora, total});
    }

    // geter de la fila seleccionada en la tabla
    public int getFilaSeleccionada() {
        return tabla.getSelectedRow();
    }

    // getter que busca datos en la tabla atraves de columna y fila
    public String getValorTabla(int fila, int columna) {
        return tabla.getValueAt(fila, columna).toString();
    }

    //Ventana emergente para mostrar tiket
    public void mostrarTicket(String texto) {
        JOptionPane.showMessageDialog(this, texto);
    }

    //Metodo para buscar con el buscador en la tabla
    public void filtrarHistorial(String texto) {

        if (texto == null || texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(
                    RowFilter.regexFilter("(?i)" + texto)
            );
        }
    }

    //retorna la cadena escrita en el buscador desde el panel buscar
    public String getTextoBusqueda() {
        return panelBuscador.getBuscador().getText(); // ajusta según tu PanelBuscador
    }
}
