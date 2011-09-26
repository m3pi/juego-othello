/*
 */

package fpuna.ia.othello.algoritmo;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class AlgoritmoPodaAlfaBeta extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    public AlgoritmoPodaAlfaBeta(){

    }
    /*******************************************************************/
    

    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero ){

        System.out.println( "analizando siguiente jugada con ALFABETA" );

         try{
            Thread.sleep( 1000 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }

        return( tablero );
    }
}
