/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fpuna.ia.othello.Utils;

/**
 *
 * @author user
 */
public class Tablero {
// ----------------------------------------------------------------------

    public static final int   CANTIDAD_FILAS_DEFECTO    = 8;
    public static final int   CANTIDAD_COLUMNAS_DEFECTO = 8;

    private int canidadColumnas ,
                cantidadFilas;

    private Casilla[][] matrizTablero;
    
// ----------------------------------------------------------------------


    /** Constructores *****************************************************/
    public Tablero(){
        this.cantidadFilas      = Tablero.CANTIDAD_FILAS_DEFECTO;
        this.canidadColumnas    = Tablero.CANTIDAD_COLUMNAS_DEFECTO;

        this.cagarMatrizTablero();
        this.restarurarTablero();
        
    }
    /**********************************************************************/


    /**
     * Carga instancias de Casilla en cada posición de la matriz tablero
     *
     * @autor gusamasan
     */
    private void cagarMatrizTablero(){
    // ------------------------------------------------------------------

        int columna, fila;

    // ------------------------------------------------------------------

        this.matrizTablero  = new Casilla[ this.cantidadFilas ][ this.canidadColumnas ];

        for( fila =0; fila < this.cantidadFilas; fila++ ){
            for( columna=0; columna < this.canidadColumnas; columna++ ){
                this.matrizTablero[ fila ][ columna ] = new Casilla( fila, columna );
            }
        }
        
    }


    /**
     * Restaura el tablero a la configuración inicial del juego
     *
     * @autor gusamasan
     */
    public void restarurarTablero(){
    // ----------------------------------------------------------------
        int columna, fila;
    // ----------------------------------------------------------------

        for( fila =0; fila < this.cantidadFilas; fila++ ){
            for( columna=0; columna < this.canidadColumnas; columna++ ){
                this.matrizTablero[ fila ][ columna ].deshabilitar();
            }
        }

        this.matrizTablero[ 3 ][ 3 ].asignarFichaBlanca();
        this.matrizTablero[ 3 ][ 4 ].asignarFichaNegra();
        this.matrizTablero[ 4 ][ 4 ].asignarFichaBlanca();
        this.matrizTablero[ 4 ][ 3 ].asignarFichaNegra();
    }

    /**
     * Retorna la cantidad de columnas que conforman el tablero
     *
     * @return <code>int</code> que representa la cantidad
     *
     * @autor gusamasan
     */
    public int getCanidadColumnas() {
        return canidadColumnas;
    }

    /**
     * Asigna la cantidad de columnas que conformarAn el tablero
     *
     * @param <code>int canidadColumnas</code> que representa la cantidad
     *
     * @autor gusamasan
     */
    public void setCanidadColumnas(int canidadColumnas) {
        this.canidadColumnas = canidadColumnas;
    }

    /**
     * Retorna la cantidad de filas que conforman el tablero
     *
     * @return <code>int</code> que representa la cantidad
     *
     * @autor gusamasan
     */
    public int getCantidadFilas() {
        return cantidadFilas;
    }

    /**
     * Asigna la cantidad de filas que conformarAn el tablero
     *
     * @param <code>int canidadFilas</code> que representa la cantidad
     *
     * @autor gusamasan
     */
    public void setCantidadFilas(int cantidadFilas) {
        this.cantidadFilas = cantidadFilas;
    }


    /**
     * Retorna la matriz que representa, internamente, al tablero
     *
     * @return matriz del tipo <code>Casilla[][]</code>
     *
     * @autor gusamasan
     */
    public Casilla[][] getMatrizTablero() {
        return matrizTablero;
    }

    
    /**
     * Asigna la matriz que representa, internamente, al tablero
     *
     * @param matriz del tipo <code>Casilla[][]</code>
     *
     * @autor gusamasan
     */
    public void setMatrizTablero(Casilla[][] matrizTablero) {
        this.matrizTablero = matrizTablero;
    }
    
}
