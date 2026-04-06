package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PanelProductoFormulario extends JPanel {

    private JTextField nombre;
    private JTextField id;
    private JTextField precio;
    private JTextField stock;

    private JButton btnImagen;
    private JLabel previewImagen;
    private String rutaImagen;

    private JButton guardar;
    private JButton cancelar;

    // ✔ SOLO UNA VEZ
    private boolean modoEdicion = false;

    public PanelProductoFormulario() {

        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        btnImagen = new JButton("Agregar Imagen");

        previewImagen = new JLabel("Sin imagen", JLabel.CENTER);
        previewImagen.setPreferredSize(new Dimension(160, 160));
        previewImagen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        previewImagen.setOpaque(true);
        previewImagen.setBackground(Color.LIGHT_GRAY);

        btnImagen.addActionListener(e -> seleccionarImagen());

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(Color.WHITE);

        leftPanel.add(previewImagen);
        leftPanel.add(btnImagen);

        add(leftPanel, BorderLayout.WEST);

        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        nombre = new JTextField(30);
        id = new JTextField(30);
        precio = new JTextField(30);
        stock = new JTextField(30);

        int y = 0;

        form.add(new JLabel("Nombre"), pos(gbc, 0, y++));
        form.add(nombre, pos(gbc, 0, y++));

        form.add(new JLabel("ID"), pos(gbc, 0, y++));
        form.add(id, pos(gbc, 0, y++));

        form.add(new JLabel("Precio"), pos(gbc, 0, y++));
        form.add(precio, pos(gbc, 0, y++));

        form.add(new JLabel("Stock"), pos(gbc, 0, y++));
        form.add(stock, pos(gbc, 0, y++));

        add(form, BorderLayout.CENTER);

        JPanel south = new JPanel();

        guardar = new JButton("Guardar");
        cancelar = new JButton("Cancelar");

        south.add(guardar);
        south.add(cancelar);
        estilizarBoton(guardar);
        estilizarBoton(cancelar);

        add(south, BorderLayout.SOUTH);

        resaltadoBotones(guardar);
        resaltadoBotones(cancelar);
    }

    // ================= IMAGEN =================
    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {

            rutaImagen = fileChooser.getSelectedFile().getAbsolutePath();

            ImageIcon icon = new ImageIcon(rutaImagen);

            Image img = icon.getImage().getScaledInstance(160, 160, Image.SCALE_SMOOTH);

            previewImagen.setText("");
            previewImagen.setIcon(new ImageIcon(img));
        }
    }

    // ================= MODO EDICIÓN =================
    public void cargarDatos(String nombre, String id, String precio, String stock) {

        this.nombre.setText(nombre);
        this.id.setText(id);
        this.precio.setText(precio);
        this.stock.setText(stock);

        setModoEdicion(true);
    }

    public void setModoEdicion(boolean modo) {
        this.modoEdicion = modo;

        guardar.setText(modo ? "Actualizar" : "Guardar");
    }

    public boolean isModoEdicion() {
        return modoEdicion;
    }

    // ================= POS =================
    private GridBagConstraints pos(GridBagConstraints gbc, int x, int y) {
        GridBagConstraints c = (GridBagConstraints) gbc.clone();
        c.gridx = x;
        c.gridy = y;
        return c;
    }
    //Estetica
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

    // ================= GETTERS =================
    public String getNombre() { return nombre.getText(); }
    public String getId() { return id.getText(); }
    public String getPrecio() { return precio.getText(); }
    public String getStock() { return stock.getText(); }
    public String getRutaImagen() { return rutaImagen; }

    public JButton getGuardar() { return guardar; }
    public JButton getCancelar() { return cancelar; }
}