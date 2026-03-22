import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelHistorial extends JPanel{

    public PanelHistorial() {
        // ===== menu =============
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
        String[] columnas = {"Fecha", "Hora","Total"};
        Object[][] datos = {
                {"01/04/2026", "10:30", "150"},
                {"02/04/2026", "12:00", "200"},
                {"02/04/2026", "13:00", "300"}
        };

        JTable tabla = new JTable(datos, columnas);
        tabla.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tabla);


        JPanel panelTabla = new JPanel(new BorderLayout());
        panelTabla.setBorder(new EmptyBorder(30, 50, 30, 50));
        panelTabla.add(scroll, BorderLayout.CENTER);

        add(panelTabla, BorderLayout.CENTER);

        // ===== BOTONES (SOUTH) =====
        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.setBackground(Color.WHITE);

        JButton ver = new JButton("Ver");
        ver.setBackground(new Color(255, 0, 0));
        ver.setForeground(Color.WHITE);

        bottom.add(ver);

        add(bottom, BorderLayout.SOUTH);

        ver.addActionListener(e -> {

            int fila = tabla.getSelectedRow();

            if (fila != -1) {
                String fecha = tabla.getValueAt(fila, 0).toString();
                String hora = tabla.getValueAt(fila, 1).toString();
                String total = tabla.getValueAt(fila, 2).toString();

                // 👇 AQUÍ ABRES LA VENTANA CON DATOS CORRECTOS
                new VentanaVer(fecha, hora, total, "").setVisible(true);

            } else {
                JOptionPane.showMessageDialog(this, "Selecciona una venta");
            }
        });


    }

}

