/*
 */

package fpuna.ia.othello.gui;
import javax.swing.*;

import fpuna.ia.othello.Utils.Casilla;

/**
 *
 * @author gusamasan
 */
public class Escaque extends JButton{
// ------------------------------------------------------------------------

// ------------------------------------------------------------------------

    public Escaque(){
        super();      
    }

    private void inicializar(){
    }

    public void limpiar(){
        this.setIcon(null);
    }

    private ImageIcon obtenerImagen()
    {
        return( new ImageIcon( super.getClass().getResource( "./recurso/negro.ico" ) ));
    }

    public void mostrarFichaBlanca(){
        this.setIcon( new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/blanco001.png" ) ) );
    }

    public void mostrarFichaNegra(){
        this.setIcon( new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/negro001.png" ) ) );
    }
}
