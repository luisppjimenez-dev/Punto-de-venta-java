import Controlador.ControladorBotonesPrincipales;
import Controlador.ControladorHistorial;
import Controlador.ControladorInventario;
import Controlador.ControladorPuntoVenta;
import Vista.PanelHistorial;
import Vista.PanelInventario;
import Vista.PanelPuntoDeVenta;
import Vista.VentanaPrincipal;


public class Main {

    public static void main(String[] args) {
        // Creamos nuestra ventana principal y nuestros paneles proncipales
        VentanaPrincipal ventana = new VentanaPrincipal();
        PanelInventario inventario = new PanelInventario();
        PanelPuntoDeVenta puntoDeVenta = new PanelPuntoDeVenta();
        PanelHistorial historial = new PanelHistorial();

        //Creamos los controladores para pasar de parametros nuestros paneles y la ventana principal
        new ControladorBotonesPrincipales(ventana, ventana.getPanelBotones(),inventario,puntoDeVenta,historial);
        new ControladorInventario(ventana,inventario);
        new ControladorPuntoVenta(ventana,puntoDeVenta,inventario,historial);
        new ControladorHistorial(ventana, historial, puntoDeVenta);

        ventana.setVisible(true);
    }
}
