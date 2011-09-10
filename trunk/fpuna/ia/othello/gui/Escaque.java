/*
 */

package fpuna.ia.othello.gui;

import  java.awt.*;

import javax.swing.*;

/**
 *
 * @author gusamasan
 */
public class Escaque extends JButton{
// ------------------------------------------------------------------------

// ------------------------------------------------------------------------

    public Escaque(){
        super();
        //super( "", new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/negro001.png" ) ) );

        //ImageIcon img = new ImageIcon( getClass().getResource( "../../recurso/negro.ico" ) );

        //this.imageUpdate( Toolkit.getDefaultToolkit().getImage(getClass().getResource( "fpuna/ia/recurso/negro.ico" )), 1, 5, 5, 5, 5 );
    }

    private void inicializar(){

    }

    private ImageIcon obtenerImagen(){

        /*
        java.net.URL imgURL = getClass.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }*/
        return( new ImageIcon( super.getClass().getResource( "./recurso/negro.ico" ) ));
    }

    public void mostrarFichaBlanca(){
        this.setIcon( new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/blanco001.png" ) ) );
    }

    public void mostrarFichaNegra(){
        this.setIcon( new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/negro001.png" ) ) );
    }
}
