/*
 */

package fpuna.ia.othello.gui;

import java.awt.*;

import javax.swing.*;

/**
 *
 * @author gusamasan
 */
public class TableroGUI extends JPanel{
// ------------------------------------------------------------------------

    private int cantidadColumnas    ,
                cantidadFilas;

    public static final int   CANTIDAD_FILAS_DEFECTO    = 8;
    public static final int   CANTIDAD_COLUMNAS_DEFECTO = 8;

    private Escaque[][] contenedorEscaques;
    
// ------------------------------------------------------------------------

    /** Constructores *****************************************************/
    public TableroGUI(){
        super();
        
        this.inicializar();
    }
    /**********************************************************************/


    private void inicializar(){
    // ------------------------------------------------------------------------

    // ------------------------------------------------------------------------

        this.cantidadFilas      = TableroGUI.CANTIDAD_FILAS_DEFECTO;
        this.cantidadColumnas   = TableroGUI.CANTIDAD_COLUMNAS_DEFECTO;
        

        this.setLayout( new GridLayout( this.cantidadFilas + 1,
                                        this.cantidadColumnas + 1 )
                       );

        contenedorEscaques  = new Escaque[ this.cantidadFilas ][ this.cantidadColumnas ];

        this.rellenarTablero();

        this.contenedorEscaques[3][3].mostrarFichaBlanca();
        this.contenedorEscaques[3][4].mostrarFichaNegra();
        this.contenedorEscaques[4][3].mostrarFichaNegra();
        this.contenedorEscaques[4][4].mostrarFichaBlanca();
    }

    private void rellenarTablero(){
    // ------------------------------------------------------------------------        
        int indice, fila, columna;

        Escaque unEscaque;

        String abecedario[]   = {"A", "B", "C", "D", "E", "F", "G", "H" };
    // ------------------------------------------------------------------------

        this.add( new JLabel( "" ) );

        // Agregando primera lInea (letras)
        for( indice=0; indice < this.cantidadFilas; indice++ )
            this.add( new JLabel("" + abecedario[ indice ]) );

        // Agregando los escaques (como botones por defecto)
        for( fila= 0; fila < this.cantidadFilas; fila++ ){
            
            // Agregando primera columna (nUmeros)
            this.add( new JLabel( "" + ( fila + 1 ) ) );
            for( columna= 0; columna < this.cantidadColumnas; columna++ ){
                
                    unEscaque   = new Escaque();
                    this.contenedorEscaques[ fila ][ columna ] = unEscaque;
                    this.add( unEscaque );
                    
            }
        }
    }
}
