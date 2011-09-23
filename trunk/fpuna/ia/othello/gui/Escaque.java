/*
 */

package fpuna.ia.othello.gui;
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
        /*this.addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mousePressed(MouseEvent e) {

            }

            public void mouseReleased(MouseEvent e) {

            }

            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });*/
        //super( "", new ImageIcon( Main.class.getClassLoader().getResource("fpuna/ia/recurso/negro001.png" ) ) );

        //ImageIcon img = new ImageIcon( getClass().getResource( "../../recurso/negro.ico" ) );

        //this.imageUpdate( Toolkit.getDefaultToolkit().getImage(getClass().getResource( "fpuna/ia/recurso/negro.ico" )), 1, 5, 5, 5, 5 );
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
