package Vista;

import Interfaces.InterfazInventario;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Panel pricipal del boton Inventario
 *  * @author Erick
 *  * @version 1.0
 */

public class PanelInventario extends JPanel implements InterfazInventario {

    // Creamos Botones como atributos
    private JButton agregarNuevo;
    private JButton modificar;
    private JButton imprimir;
    private JButton eliminar;

    private PanelBuscador panelBuscador;
    private JTable tabla;
    //para guardar datos reales de la tabla
    private DefaultTableModel modelo;
    //componete para ordenar tabla y filtrar el buscador
    private TableRowSorter<DefaultTableModel> sorter;

    public PanelInventario() {
        //dividimos Panel Principal Inentario con border
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Creamos el panel del buscador y colocamos al norte del principal
        panelBuscador = new PanelBuscador();
        add(panelBuscador, BorderLayout.NORTH);

        // Creamos las columnoas con sus titulos para inicializarlo en los parametros de modelo
        String[] columnas = {"ID", "Nombre", "Stock", "Precio"};
        modelo = new DefaultTableModel(columnas, 0);

        //inicializamos la tabla y modificámos acceso para que no se pueda modificar en la vista
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);

        // Inicializamos el sorter con el modelo para poder ordenar y filtrar la tabla
        sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        // Creamos scroll para la tabla
        JScrollPane scroll = new JScrollPane(tabla);

        //Creamos el panel de la tabla y la centramos en panel tabla y panel principal
        JPanel tabla = new JPanel(new BorderLayout());
        tabla.setBorder(new EmptyBorder(20, 50, 20, 50));
        tabla.add(scroll, BorderLayout.CENTER);
        add(tabla, BorderLayout.CENTER);

        // Creamos el panel botones y utilizamos grind para organizarlos en columnas
        JPanel BotonesInf = new JPanel(new GridLayout(1, 4, 20, 10));
        BotonesInf.setBorder(new EmptyBorder(30, 50, 30, 50));
        BotonesInf.setBackground(Color.WHITE);

        agregarNuevo = new JButton("Agregar");
        modificar = new JButton("Modificar");
        imprimir = new JButton("Imprimir");
        eliminar = new JButton("Eliminar");

        //usamos la clase estetica para los botones
        EsteticaBoton.estilizarBoton(agregarNuevo);
        EsteticaBoton.estilizarBoton(modificar);
        EsteticaBoton.estilizarBoton(imprimir);
        EsteticaBoton.estilizarBoton(eliminar);

        EsteticaBoton.resaltadoBotones(agregarNuevo);
        EsteticaBoton.resaltadoBotones(modificar);
        EsteticaBoton.resaltadoBotones(imprimir);
        EsteticaBoton.resaltadoBotones(eliminar);

        BotonesInf.add(eliminar);
        BotonesInf.add(agregarNuevo);
        BotonesInf.add(modificar);
        BotonesInf.add(imprimir);
        //Colocamos el panel botones inferiores en el sur
        add(BotonesInf, BorderLayout.SOUTH);
        agregarDatosIniciales();
    }
    // Creamos las clases de nuestra interfaz Inventario, comenzando por los escuchas de cada boton

    public void addModificarListener(ActionListener listener) {
        modificar.addActionListener(listener);
    }
    public void addAgregarListener(ActionListener listener) {
        agregarNuevo.addActionListener(listener);
    }
    public void addImprimirListener(ActionListener listener) {
        imprimir.addActionListener(listener);
    }
    public void addEliminarListener(ActionListener listener) {
        eliminar.addActionListener(listener);
    }
    public void addBuscarListener(ActionListener listener) {
        panelBuscador.getBtnBuscar().addActionListener(listener);
    }

    // Metodo para agregar una fila al modelo con una arreglo de objetos
    public void agregarFila(Object[] fila) {
        modelo.addRow(fila);
    }

    // Elimina la fila seleeciona atraves de su posicion
    public void eliminarFila(int fila) {
        modelo.removeRow(fila);
    }

    // Ordena la filas correctamente en modelo atraves del sorter
    public void actualizarFila(int filaVista, Object[] datos) {
        int filaModelo = tabla.convertRowIndexToModel(filaVista);
        for (int i = 0; i < datos.length; i++) {
            modelo.setValueAt(datos[i], filaModelo, i);
        }
    }
    // getter que retorna la pocision de la fila seleccionada
    public int getFilaSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            return -1;
        } else {
            return fila;
        }
    }
    //Retorna el prducto seleccionado verificando si se seleciono correctamente
    // despues retorna la fila seleecionada con todos sus datos
    public Object[] getProductoSeleccionado() {
        int filaVista = tabla.getSelectedRow();
        if (filaVista == -1) return null;

        int filaModelo = tabla.convertRowIndexToModel(filaVista);
        return new Object[]{
                modelo.getValueAt(filaModelo, 0), // ID
                modelo.getValueAt(filaModelo, 1), // Nombre
                modelo.getValueAt(filaModelo, 2), // Stock
                modelo.getValueAt(filaModelo, 3)  // Precio
        };
    }

    // Metodo que abre una ventana y agrega el mensaje a mostrar
    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    //Metodo para imprimir el invnetario completo
    public void imprimirInventarioCompleto() {
        try {
            boolean done = tabla.print(
                    JTable.PrintMode.FIT_WIDTH,
                    new java.text.MessageFormat("INVENTARIO COMPLETO"),
                    new java.text.MessageFormat("Página {0}")
            );
            if (done) {
                JOptionPane.showMessageDialog(this, "Impresión enviada correctamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al imprimir inventario");
        }
    }
    // Este metodo filtra el texto para buscarlo en la tabla evitando minusculas y mayusculas atraves del sorter
    public void filtrarTabla(String texto) {

        if (texto == null || texto.trim().isEmpty()) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(javax.swing.RowFilter.regexFilter("(?i)" + texto)
            );
        }
    }
    // Getter para obtener el texto introducido en el buscador
    public String getTextoBuscador() {
        return panelBuscador.getBuscador().getText();
    }

    // Busca Producto por nombre para mandarlo a la tabla de punto de venta
    public Object[] buscarProductoPorNombre(String nombre) {

        for (int i = 0; i < modelo.getRowCount(); i++) {

            // comprobamos que el porducto encontrado exista en el inventario
           //if (modelo.getValueAt(i, 1).toString().equalsIgnoreCase(nombre)) {
            if (modelo.getValueAt(i, 1).toString().toLowerCase().contains(nombre.toLowerCase())){
                // si existe retornamos el objetos con todos sus datos
                return new Object[]{
                        modelo.getValueAt(i, 0), // ID
                        modelo.getValueAt(i, 1), // Nombre
                        modelo.getValueAt(i, 2), // Stock
                        modelo.getValueAt(i, 3)  // Precio
                };
            }
        }
        return null;
    }

    //Modificamos del stock del producto comprado
    public void actualizarStock(String id, int nuevoStock) {

        for (int i = 0; i < modelo.getRowCount(); i++) {
            //buscamor por id el producto
            if (modelo.getValueAt(i, 0).toString().equals(id)) {
                // modificamos el stokc en el invnetario
                modelo.setValueAt(nuevoStock, i, 2);
                return;
            }
        }
    }

    /**
     * Metodo para agregar datos brutos
     */
    private void agregarDatosIniciales() {

        modelo.addRow(new Object[]{"1", "Arroz 1kg", 25, 28.50});
        modelo.addRow(new Object[]{"2", "Frijol 1kg", 18, 32.00});
        modelo.addRow(new Object[]{"3", "Azúcar 1kg", 20, 30.00});
        modelo.addRow(new Object[]{"4", "Aceite vegetal 1L", 15, 48.90});
        modelo.addRow(new Object[]{"5", "Leche 1L", 30, 24.50});
        modelo.addRow(new Object[]{"6", "Huevo (cartón 12)", 12, 42.00});
        modelo.addRow(new Object[]{"7", "Pan de caja", 22, 38.00});
        modelo.addRow(new Object[]{"8", "Café soluble 100g", 10, 55.00});
        modelo.addRow(new Object[]{"9", "Atún en lata", 40, 18.50});
        modelo.addRow(new Object[]{"10", "Pasta spaghetti 500g", 28, 16.00});
        modelo.addRow(new Object[]{"11", "Sal refinada 1kg", 35, 12.00});
        modelo.addRow(new Object[]{"12", "Galletas María", 40, 22.50});
        modelo.addRow(new Object[]{"13", "Salsa de tomate", 25, 18.00});
        modelo.addRow(new Object[]{"14", "Jabón en polvo 1kg", 14, 45.00});
        modelo.addRow(new Object[]{"15", "Agua embotellada 1L", 50, 10.00});
    }
}

