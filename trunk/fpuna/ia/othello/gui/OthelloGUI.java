/*
 * 
 */

package fpuna.ia.othello.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

import fpuna.ia.othello.gui.accion.AccionJuegoNuevo;
import fpuna.ia.othello.gui.accion.AccionConfiguracionLista;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class OthelloGUI extends JFrame{
// ----------------------------------------------------------------------

    private TableroGUI elTableroGUI;

    private JTabbedPane pestanias;
    
    //private Tablero tablero;
    
// ----------------------------------------------------------------------

    /** Constructores ***************************************************/
    public OthelloGUI(){
        super( "Othello" );

        this.inicializar();
    }
    /********************************************************************/
   

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

        //this.tablero   = new Tablero();
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

        
        JPanel panelJugadorUno   = this.obtenerOpcionesJugador( "Jugador (1)");
        //panelJugadorUno.setLayout( new BoxLayout( panelJugadorUno, BoxLayout.Y_AXIS ) );
        //panelJugadorUno.add( new JLabel("Jugador(1)") );
        //panelJugadorUno.add( separador);
        //panelJugadorUno.add( this.obtenerOpcionesJugador() );

        JPanel panelJugadorDos   = this.obtenerOpcionesJugador( "Jugador (2)");
        //panelJugadorDos.setLayout( new BoxLayout( panelJugadorDos, BoxLayout.Y_AXIS ) );
        //panelJugadorDos.add( new JLabel("Jugador(2)") );
        //panelJugadorDos.add( separador2 );
        //panelJugadorDos.add( this.obtenerOpcionesJugador() );
        //panelJugadorDos = this.obtenerOpcionesJugador( "Jugador (2)");

        JPanel panelAlgoritmo   = this.obtenerOpcionesAlgoritmo();
        //panelAlgoritmo.setLayout( new BoxLayout( panelAlgoritmo, BoxLayout.Y_AXIS ) );
        //panelAlgoritmo.add( new JLabel("Algoritmo") );
        //panelAlgoritmo.add( separador3);
        //panelAlgoritmo.add( this.obtenerOpcionesAlgoritmo() );

        JPanel panelFicha   = this.obtenerOpcionesFichas();
        //panelFicha.setLayout( new BoxLayout( panelFicha, BoxLayout.Y_AXIS ) );
        //panelFicha.add( new JLabel("Ficha para Jugador(1)") );
        //panelFicha.add( separador4);
        //panelFicha.add( this.obtenerOpcionesFichas() );

        JPanel panelVarios   = new JPanel();
        //panelVarios.setLayout( new BoxLayout( panelVarios, BoxLayout.Y_AXIS ) );
        panelVarios.setLayout( new GridLayout( 3, 1) );
        panelVarios.add(new JLabel("Varios"));
        panelVarios.add( new JSeparator() );
        panelVarios.add( this.obtenerOpcionesVarios() );        


        JPanel izquierda = new JPanel();
        JPanel derecha = new JPanel();

        izquierda.setLayout( new GridLayout(3, 1 ) );
        derecha.setLayout( new GridLayout(2, 1 ) );

        /*
        izquierda.add( panelJugadorUno );
        izquierda.add( panelJugadorDos );
        izquierda.add( panelFicha );

        derecha.add( panelAlgoritmo );
        derecha.add( panelVarios );
         *
         */
        
        panel.add( panelJugadorUno );
        panel.add( panelJugadorDos );
        panel.add( panelFicha );
        panel.add( panelAlgoritmo );        
        panel.add( panelVarios );
        panel.add( new JSeparator() );
        panel.add( this.obtenerBotonConfiguracionLista() );
        /*
        jSplitPane1.add( izquierda );
        jSplitPane1.add( derecha );

        panel.add( jSplitPane1 );
        */
        return( panel );
    }


    private JButton obtenerBotonConfiguracionLista(){
    // ------------------------------------------------------------------------

        JButton boton;

    // ------------------------------------------------------------------------

        boton   = new JButton( "Listo" );
        boton.addActionListener( new AccionConfiguracionLista( this.pestanias ) );
        
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
        boton.addActionListener( new AccionJuegoNuevo( this.elTableroGUI ) );

        return( boton );
    }

    public JPanel obtenerOpcionesAlgoritmo(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------
        
        panel   = new JPanel();
        panel.setLayout( new GridLayout( 6, 1 ) );
        //panel.setayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        //panel.setPreferredSize( new java.awt.Dimension( 150, 100 ) );

        JRadioButton minimax = new JRadioButton( "MiniMax" );
        minimax.setMnemonic(KeyEvent.VK_M );
        minimax.setActionCommand( "MINIMAX" );
        minimax.setSelected(true);

        JRadioButton alfaBeta = new JRadioButton( "Alfa Beta" );
        alfaBeta.setMnemonic(KeyEvent.VK_L );
        alfaBeta.setActionCommand( "ALFABETA" );

        JRadioButton aleatorio = new JRadioButton( "Aleatorio" );
        aleatorio.setMnemonic(KeyEvent.VK_A );
        aleatorio.setActionCommand( "ALEATORIO" );

        ButtonGroup group = new ButtonGroup();
        group.add( minimax      );
        group.add( alfaBeta     );
        group.add( aleatorio    );

        panel.add( new JLabel( "Algoritmo" ) );
        panel.add( new JSeparator() );
        panel.add( minimax      );
        panel.add( alfaBeta     );
        panel.add( aleatorio    );
        panel.add( new JLabel( "" ) );

        return( panel );
    }

    public JPanel obtenerOpcionesJugador( String etiqueta ){
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
        jugadorHumano.setActionCommand( "HUMANO" );
        jugadorHumano.setSelected(true);

        JRadioButton jugadorMaquina = new JRadioButton( "Máquina" );
        jugadorMaquina.setMnemonic(KeyEvent.VK_I );
        jugadorMaquina.setActionCommand( "MAQUINA" );

        
        ButtonGroup group = new ButtonGroup();
        group.add( jugadorHumano    );
        group.add( jugadorMaquina   );
        

        panel.add( new JLabel( etiqueta ) );
        panel.add( separador );
        panel.add( jugadorHumano      );
        panel.add( jugadorMaquina     );
        panel.add( new JLabel( "" ) );

        return( panel );
    }

    public JPanel obtenerOpcionesFichas(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        //panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );
        panel.setLayout( new GridLayout( 5, 1 ) );

        JRadioButton fichaNegra = new JRadioButton( "Negra" );
        fichaNegra.setMnemonic(KeyEvent.VK_N );
        fichaNegra.setActionCommand( "FICHA_NEGRA" );
        fichaNegra.setSelected(true);

        JRadioButton fichaBlanca = new JRadioButton( "Blanca" );
        fichaBlanca.setMnemonic(KeyEvent.VK_B );
        fichaBlanca.setActionCommand( "FICHA_BLANCA" );

        ButtonGroup group = new ButtonGroup();
        group.add( fichaNegra      );
        group.add( fichaBlanca     );        

        panel.add( new JLabel( "Ficha para Jugador (1) " ) );
        panel.add( new JSeparator() );
        panel.add( fichaNegra      );
        panel.add( fichaBlanca     );
        panel.add( new JLabel( "" ) );

        return( panel );
    }


    public JComponent obtenerOpcionesVarios(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        panel.setSize( 150, 10 );
        //panel.setLayout( new BoxLayout( panel, BoxLayout.X_AXIS ) );

        panel.add( new JLabel( "Profundidad" ) );
        panel.add(new JTextField( "3" , 15));

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
}
