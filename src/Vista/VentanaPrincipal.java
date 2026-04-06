package Vista;

import Interfaces.Navegador;
import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame implements Navegador {

    private JPanel panelContenido;
    private PanelBotones panelBotones;

    public VentanaPrincipal(){

        setTitle("Tiendita Don Roy");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        //Panel central
        panelContenido = new JPanel(new BorderLayout());
        add(panelContenido, BorderLayout.CENTER);

        panelBotones = new PanelBotones();
        add(panelBotones, BorderLayout.NORTH);

        mostrarPanel(new PanelInicio());
    }

    public PanelBotones getPanelBotones() {
        return panelBotones;
    }

    @Override
    public void mostrarPanel(JPanel panel){
        panelContenido.removeAll();
        panelContenido.add(panel, BorderLayout.CENTER);
        panelContenido.revalidate();
        panelContenido.repaint();
    }
}
