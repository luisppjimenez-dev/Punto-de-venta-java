import javax.swing.*;
import java.awt.*;

public class VentanaAgregarNuevo extends JFrame {
    public VentanaAgregarNuevo() {
        setTitle("Inventario");
        setSize(900,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());
        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Imagen
        JLabel imagen = new JLabel("Ingresa imagen", JLabel.CENTER);
        imagen.setPreferredSize(new Dimension(150,120));
        imagen.setOpaque(true);
        imagen.setBackground(Color.BLACK);
        imagen.setForeground(Color.WHITE);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.insets = new Insets(10,20,4,40);
        panel.add(imagen, gbc);

        gbc.gridheight = 1;

        // Nombre
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JLabel("Nombre"), gbc);

        gbc.gridy = 1;
        JTextField nombre = new JTextField("Ingresa el nombre",30);
        panel.add(nombre, gbc);

        // ID
        gbc.gridy = 2;
        panel.add(new JLabel("Id"), gbc);

        gbc.gridy = 3;
        JTextField id = new JTextField("Ingresa el ID",30);
        panel.add(id, gbc);

        // Precio
        gbc.gridy = 4;
        panel.add(new JLabel("Precio"), gbc);

        gbc.gridy = 5;
        JTextField precio = new JTextField("Ingresa el precio",30);
        panel.add(precio, gbc);

        // Stock
        gbc.gridy = 6;
        panel.add(new JLabel("Stock"), gbc);

        gbc.gridy = 7;
        JTextField stock = new JTextField("Ingresa numero de articulos",30);
        panel.add(stock, gbc);

        // Botones
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

// Agregar al frame
        add(panel, BorderLayout.CENTER);
        add(sur, BorderLayout.SOUTH);
        setVisible(true);


    }



}

