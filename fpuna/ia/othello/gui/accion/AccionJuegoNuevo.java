/* 
 */

package fpuna.ia.othello.gui.accion;

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

    // ------------------------------------------------------------------------

        this.elTablero.reiniciarTablero();
    }

}
