/*
 */

package fpuna.ia.othello.algoritmo;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class AlgoritmoHumano extends Algoritmo{
// ----------------------------------------------------------------------

// ----------------------------------------------------------------------

    /** Constructores **************************************************/
    public AlgoritmoHumano(){

    }
    /*******************************************************************/
    

    public Tablero obtenerNuevaConfiguracionTablero( Tablero tablero ){

        System.out.println( "analizando siguiente jugada con HUMANO" );

        try{
            Thread.sleep( 1000 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }

        return( tablero );
    }
}
