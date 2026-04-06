package Vista;

import Interfaces.InterfazInventario;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.RowFilter;


public class PanelInventario extends JPanel implements InterfazInventario {
    private JButton agregarNuevo;
    private JButton modificar;
    private JButton imprimir;
    private JButton eliminar;
    private TableRowSorter<DefaultTableModel> sorter;
    private JTable tabla;
    private DefaultTableModel modelo;
    private PanelBuscador panelBuscador;

    public PanelInventario() {

        // El panel de Inventario se dividira en 3 Paneles usando border
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // En la parte Norte se aplicara un panel border para acomodar agregaremos el panel buscador

        panelBuscador = new PanelBuscador();
        add(panelBuscador, BorderLayout.NORTH);

        // En el panel del centro se insertara la tabla con scroll
        //creamos un arreglo para los titulos de las columnas de la tabla
        String[] columnas = {"ID", "Nombre", "Stock", "Precio"};

        //inicializamos modelo con el arreglo para conectar los datos de las tabla
        modelo = new DefaultTableModel(columnas, 0);

        // creamos los datos brutos
        modelo.addRow(new Object[]{"2323", "coca", "5", "20"});
        modelo.addRow(new Object[]{"2224", "sabritas", "8", "23"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        modelo.addRow(new Object[]{"8767", "Atun", "34", "14"});
        modelo.addRow(new Object[]{"8767", "marias galletas", "90", "19"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        modelo.addRow(new Object[]{"8767", "emperador galletas", "2", "26"});
        //inicializamos la tabla para agregarle los datos
        tabla = new JTable(modelo);
        tabla.setRowHeight(25);
        tabla.setDefaultEditor(Object.class, null);
        tabla.getTableHeader().setReorderingAllowed(false);

        sorter = new TableRowSorter<>(modelo);
        tabla.setRowSorter(sorter);

        // conectar buscador con filtro creando lamda
        panelBuscador.getBtnBuscar().addActionListener(e -> {
            String texto = panelBuscador.getBuscador().getText();

            // si el filtro esta vacio muestrat todo
            if (texto.trim().isEmpty()) {
                sorter.setRowFilter(null);
            }
            // busca considencias sin importar si es maysucula o minuscula
            else {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
            }
        });
        // Creamos el scrool para la tabla
        JScrollPane scroll = new JScrollPane(tabla);

        // Ordenamos el panel centro
        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(20, 50, 20, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);

        // En el panel Sur organizaremos los paneles usando un gring layout
        JPanel panelBotones = new JPanel(new GridLayout(1, 4, 20, 10));
        panelBotones.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelBotones.setBackground(Color.WHITE);

        agregarNuevo = new JButton("<html><center>Agregar<br>Nuevo</center></html>");
        modificar = new JButton("Modificar");
        imprimir = new JButton("Imprimir");
        eliminar = new JButton("Eliminar");

        //Agregamos los botones y les aplicamos estética
        panelBotones.add(eliminar);
        panelBotones.add(agregarNuevo);
        panelBotones.add(modificar);
        panelBotones.add(imprimir);

        estilizarBoton(modificar);
        estilizarBoton(agregarNuevo);
        estilizarBoton(imprimir);
        estilizarBoton(eliminar);

        add(panelBotones, BorderLayout.SOUTH);

        resaltadoBotones(agregarNuevo);
        resaltadoBotones(modificar);
        resaltadoBotones(imprimir);
        resaltadoBotones(eliminar);
    }

    /**
     * Este metodo modifica la estética de los botones de la parte sur
     * @param b Un Jbutton para modificar su estética
     */
    private void estilizarBoton(JButton b) {

        b.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        b.setFont(new Font("Open Sans", Font.BOLD, 18));
        b.setBackground(new Color(255, 0, 0));
        b.setForeground(Color.WHITE);
        b.setContentAreaFilled(false);
        b.setOpaque(true);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setFocusable(false);
    }
    public void resaltadoBotones(JButton b){
        b.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                b.setBackground(new Color(204, 114, 114));// Color más claro al pasar el ratón
            }

            @Override
            public void mouseExited(MouseEvent e) {
                b.setBackground(new Color(255, 0, 0));// Color original al salir
            }
        });
    }
    public void imprimirInventarioCompleto() {
        try {

            boolean done = tabla.print(
                    JTable.PrintMode.FIT_WIDTH,
                    new java.text.MessageFormat("INVENTARIO COMPLETO"),
                    new java.text.MessageFormat("Página {0}")
            );

            if (done) {
                JOptionPane.showMessageDialog(this, "Impresión enviada correctamente");
            } else {
                JOptionPane.showMessageDialog(this, "Impresión cancelada");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al imprimir inventario");
            e.printStackTrace();
        }
    }
    public Object[] getProductoSeleccionado() {

        int fila = tabla.getSelectedRow();

        if (fila == -1) return null;

        int modelRow = tabla.convertRowIndexToModel(fila);

        return new Object[]{
                modelo.getValueAt(modelRow, 0), // ID
                modelo.getValueAt(modelRow, 1), // Nombre
                modelo.getValueAt(modelRow, 2), // Stock
                modelo.getValueAt(modelRow, 3)  // Precio
        };
    }
    public void actualizarFilaSeleccionada(Object[] fila) {

        int filaVista = tabla.getSelectedRow();

        // si no hay fila seleccionada
        if (filaVista == -1) {
            return;
        }

        // convertir a índice del modelo (por el sorter)
        int filaModelo = tabla.convertRowIndexToModel(filaVista);

        // actualizar cada columna
        for (int i = 0; i < fila.length; i++) {
            modelo.setValueAt(fila[i], filaModelo, i);
        }
    }
    public void eliminarFila(int fila) {
        modelo.removeRow(fila);
    }
    public int getFilaSeleccionada() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) return -1;
        return tabla.convertRowIndexToModel(fila);
    }

    public void addModificarListener(ActionListener listener){
        modificar.addActionListener(listener);
    }
    public void addAgregarListener(ActionListener listener){
        agregarNuevo.addActionListener(listener);
    }
    public void addImprimirListener(ActionListener listener){
        imprimir.addActionListener(listener);
    }
    public void addEliminarListener(ActionListener listener){
        eliminar.addActionListener(listener);
    }
    public void agregarFila(Object[] fila) {
        modelo.addRow(fila);
    }
}