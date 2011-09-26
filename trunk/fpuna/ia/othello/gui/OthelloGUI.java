/*
 * 
 */

package fpuna.ia.othello.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

import fpuna.ia.othello.ConstanteOthello;
import fpuna.ia.othello.gui.accion.AccionJuegoNuevo;
import fpuna.ia.othello.gui.accion.AccionConfiguracionLista;
import fpuna.ia.othello.jugador.*;

import fpuna.ia.othello.Juego;

/**
 *
 * @author gusamasan
 */
public class OthelloGUI extends JFrame{
// ----------------------------------------------------------------------

    private short   turno;

    private boolean pararJuego;

    private TableroGUI elTableroGUI;

    private JTabbedPane pestanias;

    private Juego   elJuego;

    private ButtonGroup eleccionAlgoritmo       ,
                        eleccionFichaJugadorUno ,
                        eleccionJugadorUno      ,
                        eleccionJugadorDos;

    private JTextField  eleccionProfundidad;
    
// ----------------------------------------------------------------------

    /** Constructores ***************************************************/
    public OthelloGUI(){
        super( "Othello" );        
        
        this.inicializar();
    }
    /********************************************************************/
   
    public void jugar(){

        this.elJuego.start();
    }

    private void inicializar(){
    // -------------------------------------------------------------------

    // -------------------------------------------------------------------       

        this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        //this.setLayout( new GridLayout(1,1 ));
        //this.setLayout( null );

        //this.setSize( 100, 100 );
        java.awt.Dimension tamanio;

        tamanio = new java.awt.Dimension( 650, 750 );
        this.setPreferredSize( tamanio );
        //this.setSize( 350, 350 );
        
        this.add( this.obtenerPestanias() );
        
        this.pack();
        this.setVisible(true);

        //this.cargarConfiguracion();
        //this.tablero   = new Tablero();
    }

    public void cargarConfiguracion(){
    // ------------------------------------------------------------------------

        Jugador jugadorUno, jugadorDos;

    // ------------------------------------------------------------------------

        this.elJuego    = new Juego( this.elTableroGUI );

        jugadorUno  = FabricaAbstractaJugador
                        .obtenerJugador(    this.obtenerEleccionJugadorUno()    ,
                                            this.obtenerEleccionAlgoritmo()     ,
                                            Integer.parseInt(
                                                        this.obtenerEleccionProfundidad()
                                                        ));

        jugadorDos  = FabricaAbstractaJugador
                        .obtenerJugador(    this.obtenerEleccionJugadorDos()    ,
                                            this.obtenerEleccionAlgoritmo()     ,
                                            Integer.parseInt(
                                                        this.obtenerEleccionProfundidad()
                                                        ));

        jugadorUno.setTablero( this.elTableroGUI.getTablero() );
        jugadorDos.setTablero( this.elTableroGUI.getTablero() );

        if( this.eleccionFichaJugadorUno.getSelection()
                .getActionCommand()
                .equals( ConstanteOthello.FICHA_NEGRA )){
            this.elJuego.setJugadorDeTurno(         jugadorUno );
            this.elJuego.setJugadorConFichaNegra(   jugadorUno );
            this.elJuego.setJugadorConFichaBlanca(  jugadorDos );
        }else{            

            this.elJuego.setJugadorDeTurno(         jugadorDos );
            this.elJuego.setJugadorConFichaNegra(   jugadorDos );
            this.elJuego.setJugadorConFichaBlanca(  jugadorUno );
        }
        
    }

    public String obtenerEleccionAlgoritmo(){
        return( this.eleccionAlgoritmo.getSelection().getActionCommand() );
    }

    public String obtenerEleccionFichaJugadorUno(){        
        return( this.eleccionFichaJugadorUno.getSelection().getActionCommand() );
    }

    public String obtenerEleccionJugadorDos(){
        return( this.eleccionJugadorDos.getSelection().getActionCommand() );
    }

    public String obtenerEleccionJugadorUno(){
        return( this.eleccionJugadorUno.getSelection().getActionCommand() );
    }

    public String obtenerEleccionProfundidad(){
        return( this.eleccionProfundidad.getText().trim() );
    }

    private JTabbedPane obtenerPestanias(){
    // ----------------------------------------------------------------------        

        JComponent panelJuego;
        JComponent panelConfiguracion;

    // ----------------------------------------------------------------------

        pestanias           = new JTabbedPane();        

        panelJuego          = new JPanel();
        this.elTableroGUI      = new TableroGUI();
        
        panelJuego.setLayout(new BoxLayout( panelJuego, BoxLayout.PAGE_AXIS));
        //panelJuego.setLayout( new GridLayout( 3, 1 ) );
        panelJuego.add( this.elTableroGUI );
        panelJuego.add( new JSeparator() );
        panelJuego.add( this.obtenerBotonNuevoJuevo() );
        
        pestanias.addTab("Juego", null, panelJuego ,"Does nothing");

        pestanias.setMnemonicAt(0, KeyEvent.VK_1);

        panelConfiguracion = makeTextPanel("Configuración");
        pestanias.addTab("Configuración", null, this.obtenerPanelConfiguracion(),
                          "Definición de los parámetros del juego");
        pestanias.setMnemonicAt(1, KeyEvent.VK_2);        

        return( pestanias );
    }

    private JComponent obtenerPanelConfiguracion(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        //panel.setSize(400, 400 );
        panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        //panel.setLayout( new GridLayout( 4, 2 ) );


        this.eleccionJugadorUno     = new ButtonGroup();
        JPanel panelJugadorUno      = this.obtenerOpcionesJugador( "Jugador (1)", this.eleccionJugadorUno );

        this.eleccionJugadorDos     = new ButtonGroup();
        JPanel panelJugadorDos      = this.obtenerOpcionesJugador( "Jugador (2)", this.eleccionJugadorDos );

        JPanel panelAlgoritmo   = this.obtenerOpcionesAlgoritmo();        

        JPanel panelFicha   = this.obtenerOpcionesFichas();

        JPanel panelVarios   = new JPanel();        
        panelVarios.setLayout( new GridLayout( 3, 1) );
        panelVarios.add(new JLabel("Varios"));
        panelVarios.add( new JSeparator() );
        panelVarios.add( this.obtenerOpcionesVarios() );        


        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();

        izquierda.setLayout( new GridLayout(3, 1 ) );
        derecha.setLayout( new GridLayout(2, 1 ) );

        
        panel.add( panelJugadorUno );
        panel.add( panelJugadorDos );
        panel.add( panelFicha );
        panel.add( panelAlgoritmo );        
        panel.add( panelVarios );
        panel.add( new JSeparator() );
        panel.add( this.obtenerBotonConfiguracionLista() );
        
        return( panel );
    }


    private JButton obtenerBotonConfiguracionLista(){
    // ------------------------------------------------------------------------

        JButton boton;

    // ------------------------------------------------------------------------

        boton   = new JButton( "Listo" );
        boton.addActionListener( new AccionConfiguracionLista( this, this.pestanias ) );
        
        return( boton );
    }

    /**
     * Retorn el botón "nuevo juego" cuya función es reiniciar el juego
     *
     * @return objeto del tipo <JButton> utilizable para reiniciar el juego
     *
     * @autor gusamasan
     */
    private JButton obtenerBotonNuevoJuevo(){
    // ----------------------------------------------------------------------

        JButton boton;

    // ----------------------------------------------------------------------

        boton  = new JButton( "jugar" );
        boton.addActionListener( new AccionJuegoNuevo( this, this.elTableroGUI ) );

        return( boton );
    }

    private JPanel obtenerOpcionesAlgoritmo(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------
        
        panel   = new JPanel();
        panel.setLayout( new GridLayout( 6, 1 ) );        

        JRadioButton minimax = new JRadioButton( "MiniMax" );
        minimax.setMnemonic(KeyEvent.VK_M );
        minimax.setActionCommand( ConstanteOthello.ALGORITMO_MINIMAX );
        minimax.setSelected(true);

        JRadioButton alfaBeta = new JRadioButton( "Alfa Beta" );
        alfaBeta.setMnemonic(KeyEvent.VK_L );
        alfaBeta.setActionCommand( ConstanteOthello.ALGORITMO_PODA_ALFA_BETA );

        JRadioButton aleatorio = new JRadioButton( "Aleatorio" );
        aleatorio.setMnemonic(KeyEvent.VK_A );
        aleatorio.setActionCommand( ConstanteOthello.ALGORITMO_ALEATORIO );

        this.eleccionAlgoritmo = new ButtonGroup();
        this.eleccionAlgoritmo.add( minimax      );
        this.eleccionAlgoritmo.add( alfaBeta     );
        this.eleccionAlgoritmo.add( aleatorio    );

        panel.add( new JLabel( "Algoritmo" ) );
        panel.add( new JSeparator() );
        panel.add( minimax      );
        panel.add( alfaBeta     );
        panel.add( aleatorio    );
        panel.add( new JLabel( "" ) );

        return( panel );
    }

    private JPanel obtenerOpcionesJugador( String etiqueta, ButtonGroup grupo ){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        JSeparator separador   = new JSeparator(SwingConstants.HORIZONTAL );
        separador.setSize( 10, 10 );

        panel   = new JPanel();
        //panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        panel.setLayout( new GridLayout( 5, 1 ) );

        JRadioButton jugadorHumano = new JRadioButton( "Humano" );
        jugadorHumano.setMnemonic(KeyEvent.VK_O );
        jugadorHumano.setActionCommand( ConstanteOthello.JUGADOR_HUMANO );
        jugadorHumano.setSelected(true);

        JRadioButton jugadorMaquina = new JRadioButton( "Máquina" );
        jugadorMaquina.setMnemonic(KeyEvent.VK_I );
        jugadorMaquina.setActionCommand( ConstanteOthello.JUGADOR_MAQUINA );

        
        //&&grupo = new ButtonGroup();
        grupo.add( jugadorHumano    );
        grupo.add( jugadorMaquina   );
        

        panel.add( new JLabel( etiqueta ) );
        panel.add( separador );
        panel.add( jugadorHumano      );
        panel.add( jugadorMaquina     );
        panel.add( new JLabel( "" ) );

        return( panel );
    }

    private JPanel obtenerOpcionesFichas(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        //panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        panel.setLayout( new GridLayout( 5, 1 ) );

        JRadioButton fichaNegra = new JRadioButton( "Negra" );
        fichaNegra.setMnemonic(KeyEvent.VK_N );
        fichaNegra.setActionCommand( ConstanteOthello.FICHA_NEGRA );
        fichaNegra.setSelected(true);

        JRadioButton fichaBlanca = new JRadioButton( "Blanca" );
        fichaBlanca.setMnemonic(KeyEvent.VK_B );
        fichaBlanca.setActionCommand( ConstanteOthello.FICHA_BLANCA );

        this.eleccionFichaJugadorUno = new ButtonGroup();
        this.eleccionFichaJugadorUno.add( fichaNegra      );
        this.eleccionFichaJugadorUno.add( fichaBlanca     );

        panel.add( new JLabel( "Ficha para Jugador (1) " ) );
        panel.add( new JSeparator() );
        panel.add( fichaNegra      );
        panel.add( fichaBlanca     );
        panel.add( new JLabel( "" ) );

        return( panel );
    }


    private JComponent obtenerOpcionesVarios(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        panel.setSize( 150, 10 );
        //panel.setLayout( new BoxLayout( panel, BoxLayout.X_AXIS ) );

        this.eleccionProfundidad = new JTextField( "3", 15 );

        panel.add(  new JLabel( "Profundidad" ) );
        panel.add(  this.eleccionProfundidad    );

        return( panel );
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    public void pararJuego(){
        this.elJuego.pararJuego();
    }
}
