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

// ----------------------------------------------------------------------------

    public Juego( GUI gui ){
        this.intefazGUI = gui;
        this.pararJuego = false;
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



    @Override
    public void run(){
    // ----------------------------------------------------------------------

    // ----------------------------------------------------------------------

        jugar();
        
    }

    public void jugar(){
    // ------------------------------------------------------------------------

        Tablero nuevoTablero;

    // ------------------------------------------------------------------------


        this.pararJuego = false;
        this.turno      = ConstanteOthello.TURNO_FICHA_NEGRA;

        while( !pararJuego ){

            nuevoTablero = this.jugadorDeTurno.jugar();

            this.intefazGUI.setTablero( nuevoTablero );
            this.intefazGUI.refrescarTablero();
            
            if( turno == ConstanteOthello.TURNO_FICHA_NEGRA ){

                this.jugadorDeTurno = this.jugadorConFichaBlanca;

                turno = ConstanteOthello.TURNO_FICHA_BLANCA;
            }
            else{
                this.jugadorDeTurno = this.jugadorConFichaNegra;

                turno = ConstanteOthello.TURNO_FICHA_NEGRA;
            }
        }
    }

    public void pararJuego(){
        this.pararJuego = true;
    }
}
