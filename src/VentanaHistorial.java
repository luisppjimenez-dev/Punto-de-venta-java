import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaHistorial extends JFrame{
    public VentanaHistorial() {
        //Crear mi ventana
        setTitle("VentanaHistorial");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new PanelBotones(), BorderLayout.NORTH);

        setVisible(true);
    }
}
