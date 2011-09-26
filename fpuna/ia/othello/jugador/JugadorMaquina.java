/*
 */

package fpuna.ia.othello.jugador;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class JugadorMaquina extends Jugador{
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------

    /** Constructores *********************************************************/
    public JugadorMaquina(){

    }
    /**************************************************************************/

    public Tablero jugar(){

        return( this.algoritmo
                    .obtenerNuevaConfiguracionTablero( this.tablero )
               );
        
    }
}
