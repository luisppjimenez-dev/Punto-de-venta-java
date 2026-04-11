package Vista;

import Interfaces.InterfazPuntoVenta;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel pricipal del boton punto de venta
 *  * @author Luis
 *  * @version 1.0
 */
public class PanelPuntoDeVenta extends JPanel implements InterfazPuntoVenta {

    private PanelBuscador panelBuscador;
    private JTable tabla;
    private JLabel labelTotal;

    //componete para ordenar tabla y filtrar el buscador
    private TableRowSorter<DefaultTableModel> sorter;
    //para guardar datos reales de la tabla
    private DefaultTableModel modelo;


    // Botones principales
    private JButton agregar;
    private JButton pagar;
    private JButton cancelar;
    private JButton eliminar;

    public PanelPuntoDeVenta() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // inizializamos buscador y lo mandamos al norte del panel
        panelBuscador = new PanelBuscador();
        add(panelBuscador, BorderLayout.NORTH);

        //  Inicializamos tabla y la colocamos en el centro del panel
        String[] columnas = {"ID", "Nombre", "Cantidad", "Precio", "Importe"};

        modelo = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setDefaultEditor(Object.class, null);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(20, 50, 20, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);

        // Creamos panel para botones y los colocamos en el sur del panel
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        bottom.setBackground(Color.WHITE);

        agregar = new JButton("Agregar");
        cancelar = new JButton("Cancelar");
        pagar = new JButton("Pagar");
        eliminar = new JButton("<html><center>Eliminar<br>Producto</center></html>");

        labelTotal = new JLabel("Total: $0.00");
        labelTotal.setFont(new Font("Arial", Font.BOLD, 18));

        EsteticaBoton.estilizarBoton(agregar);
        EsteticaBoton.estilizarBoton(cancelar);
        EsteticaBoton.estilizarBoton(pagar);
        EsteticaBoton.estilizarBoton(eliminar);

        EsteticaBoton.resaltadoBotones(agregar);
        EsteticaBoton.resaltadoBotones(cancelar);
        EsteticaBoton.resaltadoBotones(pagar);
        EsteticaBoton.resaltadoBotones(eliminar);

        bottom.add(eliminar);
        bottom.add(agregar);
        bottom.add(cancelar);
        bottom.add(pagar);
        bottom.add(labelTotal);


        add(bottom, BorderLayout.SOUTH);
    }

    //Escuchas de Botonoes
    public void addAgregarListener(ActionListener listener){
        agregar.addActionListener(listener);
    }
    public void addPagarListener(ActionListener listener){
        pagar.addActionListener(listener);
    }
    public void addCancelarListener(ActionListener listener){
        cancelar.addActionListener(listener);
    }
    public void addEliminarListener(ActionListener listener){
        eliminar.addActionListener(listener);
    }
    public void addBuscarListener(ActionListener listener){
        panelBuscador.getBtnBuscar().addActionListener(listener);
    }

    // retornamos el texto ingresado en el buscador
    public String getTextoBuscador() {
        return panelBuscador.getBuscador().getText();
    }

    //retornamos la posicion de la fila de la tabla
    public int getFilas() {
        return modelo.getRowCount();
    }

    //retornamos el dato de la fila y columna seleccionada
    public Object getValor(int fila, int columna) {
        if (fila < 0) return null;
        return modelo.getValueAt(fila, columna);
    }

    //retorna la fila seleccionada en la tabla
    public int getFilaSeleccionada() {
        return tabla.getSelectedRow();
    }

    //limpia el buscador despues de agregar
    public void limpiarBuscador() {
        panelBuscador.getBuscador().setText("");
    }

    //metodo para crear ventana emergente de aviso
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    // metodos para agregar objeto a la tabla
    public void agregarFila(Object[] fila) {
        modelo.addRow(fila);
    }

    // modifica el dato del objeto en la fila y columna seleccionada
    public void setValor(Object valor, int fila, int columna) {
        modelo.setValueAt(valor, fila, columna);
    }

    //Limpia tabla despues de pagar o cancelar
    public void limpiarTabla() {
        modelo.setRowCount(0);
    }

    //Elimina fila atraves de su posicion
    public void eliminarFila(int fila) {
        if (fila >= 0) {
            modelo.removeRow(fila);
        }
    }
    // Modifica el total cada que se agrega producto
    public void actualizarTotal(double total) {
        labelTotal.setText("Total: $" + String.format("%.2f", total));
    }
}