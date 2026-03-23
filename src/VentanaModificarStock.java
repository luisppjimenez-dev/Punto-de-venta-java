import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaModificarStock extends JFrame{
    private int stockNuevo;
    private JLabel labelStockNumero;

    public VentanaModificarStock() {
        setTitle("Modificar Stock");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(Color.WHITE);

        // ===== menu =====
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // ===== BUSCADOR (NORTH) =====
        JPanel panelBusqueda = new JPanel(new BorderLayout());
        panelBusqueda.setBackground(Color.WHITE);

        // ===== COMPONENTES =====
        JTextField buscador = new JTextField(15);
        buscador.setPreferredSize(new Dimension(180, 30));

        JButton btnBuscar = new JButton("🔍");
        btnBuscar.setFocusPainted(false);

        /// Panel interno para alinear a la derecha
        JPanel derecha = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        derecha.setBackground(Color.WHITE);
        derecha.add(btnBuscar);
        derecha.add(buscador);

        // ===== LINEAS =====
        JSeparator lineaArriba = new JSeparator();
        JSeparator lineaAbajo = new JSeparator();

        // ===== ARMADO =====
        panelBusqueda.add(lineaArriba, BorderLayout.NORTH);
        panelBusqueda.add(derecha, BorderLayout.CENTER);
        panelBusqueda.add(lineaAbajo, BorderLayout.SOUTH);

        add(panelBusqueda, BorderLayout.NORTH);

        // ===== TABLA (CENTER) =====
        String[] columnas = {"ID", "NOMBRE","STOCK"};
        Object[][] datos = {
                {"0123", "PRODUCTO 1", "150"}
        };

        JTable tabla = new JTable(datos, columnas);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);


        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);
        // Panel sur
        JPanel sur = new JPanel(new FlowLayout(FlowLayout.RIGHT));


        // Botones
        JButton guardar = new JButton("Guardar");
        JButton cancelar = new JButton("Cancelar");

        guardar.setBackground(Color.RED);
        guardar.setForeground(Color.WHITE);

        cancelar.setBackground(Color.RED);
        cancelar.setForeground(Color.WHITE);

        sur.add(guardar);
        sur.add(cancelar);


        //CONTADOR
        stockNuevo = 0;

        JButton btnMenos = new JButton("-");
        JButton btnMas   = new JButton("+");
        labelStockNumero = new JLabel("0", JLabel.CENTER);

        JPanel panelContador = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelContador.setBackground(Color.WHITE);
        panelContador.add(btnMas);
        panelContador.add(labelStockNumero);
        panelContador.add(btnMenos);





    }
    public void setVisible(boolean b) {
    }
}