import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaPuntoDeVenta extends JFrame {
    public VentanaPuntoDeVenta() {
        //Crear mi ventana
        setTitle("VentanaPuntoDeVenta");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PanelBotones(), BorderLayout.NORTH);


        setVisible(true);
    }
}
