/* 
 */

package fpuna.ia.othello.jugador;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class JugadorHumano extends Jugador{
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------

    /** Constructores *********************************************************/
    public JugadorHumano(){

    }
    /**************************************************************************/    


    public Tablero jugar(){
        return( this.algoritmo
                    .obtenerNuevaConfiguracionTablero( this.tablero )
              );
    }
}
