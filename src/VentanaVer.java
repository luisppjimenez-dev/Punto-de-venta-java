import javax.swing.*;
import java.awt.*;

public class VentanaVer extends JFrame {

    private JTextField textoNombre;
    private JTextField textoId;
    private JTextField textoPrecio;
    private JTextField textoStock;

    public VentanaVer(String nombre, String id, String precio, String stock) {

        setTitle("Ver Producto");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);
        panel.setBackground(Color.WHITE);

        // ===== ETIQUETAS =====
        JLabel etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setBounds(200,40,100,20);
        panel.add(etiquetaNombre);

        JLabel etiquetaId = new JLabel("Id");
        etiquetaId.setBounds(200,100,100,20);
        panel.add(etiquetaId);

        JLabel etiquetaPrecio = new JLabel("Precio");
        etiquetaPrecio.setBounds(200,160,100,20);
        panel.add(etiquetaPrecio);

        JLabel etiquetaStock = new JLabel("Stock");
        etiquetaStock.setBounds(200,220,100,20);
        panel.add(etiquetaStock);

        // ===== CAMPOS =====
        textoNombre = new JTextField(nombre);
        textoNombre.setBounds(200,60,200,30);
        panel.add(textoNombre);

        textoId = new JTextField(id);
        textoId.setBounds(200,120,200,30);
        panel.add(textoId);

        textoPrecio = new JTextField(precio);
        textoPrecio.setBounds(200,180,200,30);
        panel.add(textoPrecio);

        textoStock = new JTextField(stock);
        textoStock.setBounds(200,240,200,30);
        panel.add(textoStock);

        // ===== BOTÓN CERRAR =====
        JButton cerrar = new JButton("Cerrar");
        cerrar.setBounds(240,300,120,40);
        cerrar.setBackground(Color.RED);
        cerrar.setForeground(Color.WHITE);

        cerrar.addActionListener(e -> dispose());

        panel.add(cerrar);

        add(panel);
    }
}