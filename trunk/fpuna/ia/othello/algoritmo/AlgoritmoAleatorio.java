/*
 */

package fpuna.ia.othello.algoritmo;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class AlgoritmoAleatorio extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    public AlgoritmoAleatorio(){

    }
    /*******************************************************************/
    

    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero ){

        System.out.println( "analizando siguiente jugada con ALEATORIO" );

         try{
            Thread.sleep( 1000 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }

        return( tablero );
    }
}
