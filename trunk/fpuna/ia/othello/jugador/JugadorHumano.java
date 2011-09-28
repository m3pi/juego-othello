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


    public Tablero jugar(short turno){
        return( this.algoritmo
                    .obtenerNuevaConfiguracionTablero( this.tablero,turno  )
              );
    }
}
