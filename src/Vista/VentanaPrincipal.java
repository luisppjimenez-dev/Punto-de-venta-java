package Vista;

import Interfaces.Navegador;
import javax.swing.*;
import java.awt.*;
/**
 * Ventana pricipal que muestra los paneles y los botones pricipales
 *  * @author Luis
 *  * @version 1.0
 */

public class VentanaPrincipal extends JFrame implements Navegador {

    // creamos los paneles principales de la ventana principal
    private JPanel panelContenido;
    private PanelBotones panelBotones;

    public VentanaPrincipal(){

        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Panel  para las ventanas inventario, punto de venta e historial lo centramos en el panel principal
        panelContenido = new JPanel(new BorderLayout());
        add(panelContenido, BorderLayout.CENTER);

        // Panel para los botones principales, lo colocamos en la parte norte
        panelBotones = new PanelBotones();
        add(panelBotones, BorderLayout.NORTH);

        // por defecto mostramos la ventana pricipal
        mostrarPanel(new PanelInicio());
    }

    // geter para mostrar los botones pricipales
    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

   // metodo para cambiar los paneles en la ventana pricipal
    public void mostrarPanel(JPanel panel){
        panelContenido.removeAll();
        panelContenido.add(panel, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
