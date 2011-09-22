/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fpuna.ia.othello.Utils;

/**
 *
 * @author Lamia
 */

public class Casilla{      
   // ------------------------------------------------------------------------

    public int fila;
    public int col;

    public static short FICHA_NEGRA         = 0;
    public static short FICHA_BLANCA        = 1;
    public static short FICHA_TRANSPARENTE  = 0 ;

    private short   colorFicha;

// ------------------------------------------------------------------------

    /** Constructores ****************************************************/
    public Casilla(){
        this.colorFicha = Casilla.FICHA_TRANSPARENTE;
    }

    public Casilla(int fila, int col){
      this.fila = fila;
      this.col = col;
    }
    /*********************************************************************/


    /**
     * Indica si la casilla representa o no a una ficha negra
     *
     * @return <code>true</code> si la ficha representa a una ficha negra;
     *          <code>false</code> en caso contrario
     *
     * @autor gusamasan
     */
    public boolean esNegra(){

        if( this.colorFicha == Casilla.FICHA_NEGRA )
            return( true );
        else
            return( false );
    }

    /**
     * Indica si la casilla representa o no a una ficha blanca
     *
     * @return <code>true</code> si la ficha representa a una ficha blanca;
     *          <code>false</code> en caso contrario
     *
     * @autor gusamasan
     */
    public boolean esBlanca(){
        if( this.colorFicha == Casilla.FICHA_BLANCA )
            return( true );
        else
            return( false );
    }


    /**
     * Indica si la casilla está o no vacía.
     *
     * @return <code>true</code> si la casilla está vacía; <code>false</code> en
     *          caso contrario
     */
    public boolean estaVacia(){
        if( this.colorFicha == Casilla.FICHA_TRANSPARENTE )
            return( true );
        else
            return( false );
    }

    /**
     * Asigna una ficha blanca a la instancia de esta clase
     *
     * @autor gusamasan
     */
    public void asignarFichaBlanca(){
        this.colorFicha = Casilla.FICHA_BLANCA;
    }

    /**
     * Asigna una ficha negra a la instancia de esta clase
     *
     * @autor gusamasan
     */
    public void asignarFichaNegra(){
        this.colorFicha = Casilla.FICHA_NEGRA;
    }


    /**
     * Voltea o cambia el color de la ficha representada por la casilla; si el
     * color actual es negro, asigna el color blanco; en caso contrario, asigna
     * el color negro.
     *
     * @autor gusamasan
     */
    public void voltear(){
        if( this.colorFicha == Casilla.FICHA_BLANCA )
            this.colorFicha = Casilla.FICHA_NEGRA;
        else
            this.colorFicha = Casilla.FICHA_BLANCA;
    }
}