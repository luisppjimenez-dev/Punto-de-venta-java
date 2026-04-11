package Vista;

import javax.swing.*;
import java.awt.*;
/**
 * Ventana Emergente Para formulario de Agregar Producto y modificar producto
 *  * @author Brenda
 *  * @version 1.0
 */

public class DialogProducto extends JDialog {

    // Atributo para el panel de formulario
    private PanelProductoFormulario panel;

    public DialogProducto(JFrame parent, String titulo) {

        super(parent, titulo, true);

        //Dimensionamos la ventana emergente
        setSize(600, 500);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        //Agregamos el panel de formulario de producto y lo centramos
        panel = new PanelProductoFormulario();
        add(panel, BorderLayout.CENTER);
    }

    //Creamos Getter para mostrar el panel formulario
    public PanelProductoFormulario getPanel() {
        return panel;
    }
}
