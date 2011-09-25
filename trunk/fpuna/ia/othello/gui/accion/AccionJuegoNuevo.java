/* 
 */

package fpuna.ia.othello.gui.accion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import fpuna.ia.othello.gui.TableroGUI;

/**
 *
 * @author gusamasan
 */
public class AccionJuegoNuevo implements ActionListener{
// ------------------------------------------------------------------------

    private TableroGUI elTablero;

// ------------------------------------------------------------------------

    /** Constructores ****************************************************/
    public AccionJuegoNuevo( TableroGUI tablero ){
        this.elTablero  = tablero;
    }
    /*********************************************************************/

    public void actionPerformed( ActionEvent evento ){
    // ------------------------------------------------------------------------

        JButton botonLlamador;

    // ------------------------------------------------------------------------

        botonLlamador   = ( JButton )evento.getSource();

        if( botonLlamador.getText().equals( "jugar" ) ){
            botonLlamador.setText( "juego nuevo" );
            this.elTablero.habilitarTablero();
        }
        else{
            this.elTablero.refrescarTablerGUI();
            this.elTablero.deshabilitarTablero();
            
            botonLlamador.setText( "jugar" );
        }
    }

}
