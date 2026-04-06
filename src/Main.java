import Controlador.ControladorBotonesPrincipales;
import Controlador.ControladorInventario;
import Vista.PanelBotones;
import Vista.PanelInventario;
import Vista.VentanaPrincipal;


void main() {
    VentanaPrincipal ventana = new VentanaPrincipal();
    PanelInventario inventario = new PanelInventario();

    new ControladorBotonesPrincipales(ventana, ventana.getPanelBotones(),inventario);

    new ControladorInventario(ventana,inventario);
    ventana.setVisible(true);
}
