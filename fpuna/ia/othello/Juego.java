/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fpuna.ia.othello;

import fpuna.ia.othello.Utils.Tablero;
import fpuna.ia.othello.jugador.Jugador;

/**
 *
 * @author gusamasan
 */
public class Juego extends Thread{
// ----------------------------------------------------------------------------

    private GUI intefazGUI;

    private boolean pararJuego;
    
    private short turno;

    private Jugador jugadorConFichaBlanca   ,
                    jugadorConFichaNegra    ,
                    jugadorDeTurno;

    private Tablero tableroFichaBlanca, tableroFichaNegra;

// ----------------------------------------------------------------------------

    /** Constructores ********************************************************/
    public Juego( GUI gui ){
        this.intefazGUI = gui;
        this.pararJuego = false;
    }
    /*************************************************************************/

    public static void esperarUnRato(){
        try{
            Thread.sleep( 10 );
        }
        catch( Exception e ){
            e.printStackTrace();
        }
    }

    public Jugador getJugadorConFichaBlanca() {
        return jugadorConFichaBlanca;
    }

    public void setJugadorConFichaBlanca(Jugador jugadorConFichaBlanca) {
        this.jugadorConFichaBlanca = jugadorConFichaBlanca;
    }

    public Jugador getJugadorConFichaNegra() {
        return jugadorConFichaNegra;
    }

    public void setJugadorConFichaNegra(Jugador jugadorConFichaNegra) {
        this.jugadorConFichaNegra = jugadorConFichaNegra;
    }

    public Jugador getJugadorDeTurno() {
        return jugadorDeTurno;
    }

    public void setJugadorDeTurno(Jugador jugadorDeTurno) {
        this.jugadorDeTurno = jugadorDeTurno;
    }

    public boolean estaParado(){
        return( this.pararJuego );
    }


    @Override
    public void run(){
    

        jugar();
        
    }

    public void jugar(){
    // ------------------------------------------------------------------------

        Tablero nuevoTablero;

    // ------------------------------------------------------------------------

        this.pararJuego = false;
        this.turno      = ConstanteOthello.TURNO_FICHA_NEGRA;

        while( !pararJuego ){

            /**/
            System.out.println( "********************************" );

            nuevoTablero = jugadorDeTurno.getTablero();
            nuevoTablero.imprimirTablero();

            System.out.println( "*********************************" );

            nuevoTablero = this.jugadorDeTurno.jugar(turno);

            System.out.println( "##################################" );

            nuevoTablero.imprimirTablero();
            
            System.out.println( "##################################" );
            /**/
            

            if( !pararJuego && nuevoTablero != null ){
                this.intefazGUI.setTablero( nuevoTablero );
                this.intefazGUI.refrescarTablero();

                if( turno == ConstanteOthello.TURNO_FICHA_NEGRA ){

                    this.jugadorDeTurno = this.jugadorConFichaBlanca;
                    this.intefazGUI.avisarTurnoFichaBlanca();

                    turno = ConstanteOthello.TURNO_FICHA_BLANCA;

                    this.tableroFichaNegra = nuevoTablero;
                }
                else{
                    this.jugadorDeTurno = this.jugadorConFichaNegra;
                    this.intefazGUI.avisarTurnoFichaNegra();

                    turno = ConstanteOthello.TURNO_FICHA_NEGRA;

                    this.tableroFichaBlanca = nuevoTablero;
                }

                this.jugadorDeTurno.setTablero( nuevoTablero );
           }
           else{ // pasa de turno

                if( turno == ConstanteOthello.TURNO_FICHA_NEGRA ){
                    this.tableroFichaNegra = null;
                    this.intefazGUI.avisarPasoTurnoFichaNegra();
                }
                else{
                    this.tableroFichaBlanca= null;
                    this.intefazGUI.avisarPasoTurnoFichaBlanca();
                }

                
                if( this.tableroFichaNegra == null && this.tableroFichaBlanca == null ) // ningún jugador puede seguir
                    pararJuego = true;
           }

           this.intefazGUI.limpiarAvisoPasoTurno();
           this.esperarUnRato();

        }
    }

    public void pararJuego(){
        this.pararJuego = true;
    }
}
