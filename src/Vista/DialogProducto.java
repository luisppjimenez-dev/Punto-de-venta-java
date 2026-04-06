package Vista;

import javax.swing.*;
import java.awt.*;


public class DialogProducto extends JDialog {

    private PanelProductoFormulario panel;

    public DialogProducto(JFrame parent, String titulo) {

        super(parent, titulo, true);

        setSize(600, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        panel = new PanelProductoFormulario();
        add(panel, BorderLayout.CENTER);
    }

    public PanelProductoFormulario getPanel() {
        return panel;
    }
}
