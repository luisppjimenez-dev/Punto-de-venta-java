import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private JPanel panelContenido;

    public VentanaPrincipal(){

        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 🔴 ARRIBA (fijo)
        add(new PanelBotones(this), BorderLayout.NORTH);

        // 🟢 CENTRO (dinámico)
        panelContenido = new JPanel(new BorderLayout());
        add(panelContenido, BorderLayout.CENTER);

        // Mostrar inicio
        mostrarPanel(new PanelInicio());
    }

    public void mostrarPanel(JPanel panel){
        panelContenido.removeAll();
        panelContenido.add(panel, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}