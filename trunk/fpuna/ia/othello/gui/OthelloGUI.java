/*
 * 
 */

package fpuna.ia.othello.gui;

import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.*;

import fpuna.ia.othello.gui.accion.AccionJuegoNuevo;

import fpuna.ia.othello.Utils.Tablero;

/**
 *
 * @author gusamasan
 */
public class OthelloGUI extends JFrame{
// ----------------------------------------------------------------------

    private TableroGUI elTableroGUI;
    private Tablero tablero;
    
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

        this.setBounds( 100, 100, 650, 650 );
        
        this.add( this.obtenerPestanias() );
        
        this.pack();
        this.setVisible(true);

        this.tablero   = new Tablero();
    }

    private JTabbedPane obtenerPestanias(){
    // ----------------------------------------------------------------------

        JTabbedPane pestanias;

        JComponent panelJuego;
        JComponent panelConfiguracion;

    // ----------------------------------------------------------------------

        pestanias           = new JTabbedPane();
        //pestanias.setSize( 300, 300 );
        
        panelJuego          = makeTextPanel("Panel #1");

        panelJuego          = new JPanel();
        this.elTableroGUI      = new TableroGUI();

        panelJuego.setLayout(new BoxLayout( panelJuego, BoxLayout.PAGE_AXIS));
        panelJuego.add( this.elTableroGUI );
        panelJuego.add( this.obtenerBotonNuevoJuevo() );
        
        pestanias.addTab("Juego", null, panelJuego ,"Does nothing");

        pestanias.setMnemonicAt(0, KeyEvent.VK_1);

        panelConfiguracion = makeTextPanel("Panel #2");
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
        //panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

        javax.swing.JSplitPane jSplitPane1 = new javax.swing.JSplitPane();
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        //jSplitPane1.remove( 0 );
        jSplitPane1.remove( 0 );
        jSplitPane1.remove( 0 );
        jSplitPane1.setDividerSize(35);

        JPanel panelAlgoritmo   = new JPanel();
        panelAlgoritmo.setLayout( new BoxLayout( panelAlgoritmo, BoxLayout.Y_AXIS ) );
        panelAlgoritmo.add( new JLabel("Algoritmo") );
        JSeparator separador   = new JSeparator(SwingConstants.HORIZONTAL );
        separador.setSize( 50, 50 );
        panelAlgoritmo.add( separador);
        panelAlgoritmo.add( this.obtenerOpcionesAlgoritmo() );

        JPanel panelVarios   = new JPanel();
        panelVarios.setLayout( new BoxLayout( panelVarios, BoxLayout.Y_AXIS ) );
        panelVarios.add(new JLabel("Varios"));
        panelVarios.add(new JSeparator(SwingConstants.HORIZONTAL ));
        panelVarios.add( this.obtenerOpcionesVarios() );

        jSplitPane1.add( panelAlgoritmo );
        jSplitPane1.add( panelVarios );
        //panel.add( panelAlgoritmo );

        panel.add( jSplitPane1 );
        
        //panel.add( panelVarios );
        
        
        return( panel );
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

        boton  = new JButton( "nuevo juego" );
        boton.addActionListener( new AccionJuegoNuevo( this.elTableroGUI ) );

        return( boton );
    }

    public JComponent obtenerOpcionesAlgoritmo(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------
        
        panel   = new JPanel();
        panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );

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

        panel.add( minimax      );
        panel.add( alfaBeta     );
        panel.add( aleatorio    );

        return( panel );
    }

    public JComponent obtenerOpcionesVarios(){
    // ----------------------------------------------------------------------

        JPanel panel;

    // ----------------------------------------------------------------------

        panel   = new JPanel();
        //panel.setLayout( new BoxLayout( panel, BoxLayout.Y_AXIS ) );        
        
        panel.add( new JLabel( "Profundidad" ) );
        panel.add(new JTextField("Text field", 15));

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
