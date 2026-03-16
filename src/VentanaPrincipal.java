import javax.swing.*;

/**
 * Clase que crea la ventana principal del sistema
 * de punto de venta "Tiendita Don Roy".
 *  * @author Luis
 *  * @version 1.0
 */
public class VentanaPrincipal extends JFrame {

    /**
     * Constructor que crea la ventana principal del sistema.
     *
     * La ventana:
     * - Tiene el título "Tiendita Don Roy"
     * - Mide 900 x 600 píxeles
     * - Se centra en el monitor
     * - Se cierra completamente al presionar la X
     */
    public VentanaPrincipal(){
        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setVisible(true);
    }
}