/*
 */

package fpuna.ia.othello.algoritmo;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class AlgoritmoMinimax extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    public AlgoritmoMinimax(){

    }
    /*******************************************************************/
    

    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero ){

        System.out.println( "analizando siguiente jugada con MINIMAX" );

         try{
            Thread.sleep( 1000 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }

        return( tablero );
    }
}
