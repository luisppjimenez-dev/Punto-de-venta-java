import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PanelPuntoDeVenta extends JPanel {

    public PanelPuntoDeVenta() {
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

        // Panel interno para alinear a la derecha
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
        String[] columnas = {"Descripción", "Precio", "Cantidad", "Importe"};

        Object[][] datos = {
                {"Producto 1", "10", "1", "10"},
                {"Producto 2", "20", "1", "20"},
                {"Producto 3", "15", "1", "15"},
        };

        JTable tabla = new JTable(datos, columnas);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);

        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(20, 50, 20, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);

        // ===== BOTONES (SOUTH) =====
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setBackground(Color.WHITE);

        JButton cancelar = new JButton("Cancelar");
        JButton pagar = new JButton("Pagar");

        cancelar.setBackground(new Color(255, 0, 0));
        cancelar.setForeground(Color.WHITE);

        pagar.setBackground(new Color(255, 0, 0));
        pagar.setForeground(Color.WHITE);

        bottom.add(cancelar);
        bottom.add(pagar);

        add(bottom, BorderLayout.SOUTH);
    }
}