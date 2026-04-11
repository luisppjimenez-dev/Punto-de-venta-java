package Interfaces;

import javax.swing.JPanel;
/**
 * Interfaz para evitar el acoplamiento en la ventana pricipal
 *  * @author Erick
 *  * @version 1.0
 */
public interface Navegador {
    /**
     *Modifica el panel principal inferior para que no tega problemas de abrir mas ventanas
     * @param  panel El panel que deseas visualizar
     */
    public void mostrarPanel(JPanel panel);
}