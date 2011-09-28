/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fpuna.ia.othello.jugador;

import fpuna.ia.othello.Utils.Tablero;
import fpuna.ia.othello.algoritmo.Algoritmo;

/**
 *
 * @author gusamasan
 */
public abstract class Jugador{
// -----------------------------------------------------------------------------

    protected Tablero     tablero;

    protected Algoritmo   algoritmo;

// -----------------------------------------------------------------------------

    /** Constructores *********************************************************/
    public Jugador(){

    }
    /**************************************************************************/

    public Algoritmo getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(Algoritmo algoritmo) {
        this.algoritmo = algoritmo;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    public abstract Tablero jugar(short turno);

    
}
