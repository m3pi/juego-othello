/* 
 */

package fpuna.ia.othello.gui.accion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;

import fpuna.ia.othello.gui.TableroGUI;

/**
 *
 * @author gusamasan
 */
public class AccionConfiguracionLista implements ActionListener{
// ------------------------------------------------------------------------

    private JTabbedPane pestanias;

// ------------------------------------------------------------------------

    /** Constructores ****************************************************/
    public AccionConfiguracionLista( JTabbedPane unasPestanias ){
        this.pestanias  = unasPestanias;
    }
    /*********************************************************************/

    public void actionPerformed( ActionEvent evento ){
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

        this.pestanias.setSelectedIndex(0);
        
    }

}
