package jug2.view;

import general.view.MastermindMenuBar;
import ini.view.MyDefaultMetalTheme3;
import ini.view.TituloPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import juegocolores.controller.Jug2Controller;
import juegocolores.model.MastermindModel;


/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class Jug2View extends JFrame{
    private DerechaPanel derecha;
    private IzquierdaPanel izquierda;
    private MastermindMenuBar menu;

    /**
     * 
     * constructor
     * 
     */
    public Jug2View(MastermindModel model){
        
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,720);
        setTitle("Mastermind - Jugador 2");
        setResizable(false);
        
        this.setLocationRelativeTo(null);

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(3);
        

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme3());
        
        try {
          UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(this);
        
        //componentes de la vista
        menu = new MastermindMenuBar();
        setJMenuBar(menu);
        
        izquierda = new IzquierdaPanel(model);
        izquierda.setPreferredSize(new Dimension(550,550));
        
        add(izquierda, BorderLayout.WEST);
        
        derecha = new DerechaPanel();
        add(derecha, BorderLayout.CENTER);
        
        derecha.startAnim();
        
        this.setVisible(true);
        
    }

    /**
     * 
     * setter ActionListener
     * 
     */
    public void setActionListener(ActionListener al) {
        derecha.setActionListener(al);
        menu.setActionListener(al);
    }

    /**
     * 
     * setter MouseListener
     * 
     */
    public void setMyMouseListener(MouseListener ml) {
        izquierda.setMyMouseListener(ml);
    }
    
    /**
     * 
     * getter ancho
     * 
     */
    public int getAncho()
    {
        return izquierda.getAncho();
    }
    
    /**
     * 
     * getter borde
     * 
     */
    public int getBorde()
    {
        return izquierda.getBorde();
    }
    
    /**
     * 
     * getter altura
     * 
     */
    public int getAltura()
    {
        return izquierda.getAltura();
    }

    /**
     * 
     * repinta izquierda panel
     * 
     */
    public void repinta() {
        izquierda.repinta();
    }
    
    /**
     * 
     * getter radio
     * 
     */
    public int getRadio()
    {
        return izquierda.getRadio();
    }
    
    /**
     * 
     * getter espacio
     * 
     */
    public int getEspacio()
    {
        return izquierda.getEspacio();
    }
    
    /**
     * 
     * getter centrar
     * 
     */
    public int getCentrar()
    {
        return izquierda.getCentrar();
    }

    /**
     * 
     * getter OffsetX
     * 
     */
    
    public int getOffsetX()
    {
        return izquierda.getOffsetX();
    }

    /**
     * 
     * cambia el boton
     * 
     */
    public void cambiaBoton() {
        derecha.cambiaBoton(); 
    }
    
    /**
     * 
     * getter volumen
     * 
     */
    public void setAnim(int anim){
        derecha.setAnim(anim);
    }
    
    /**
     * 
     * para la animacion personaje
     * 
     */
    public void stopAnim(){
        derecha.stopAnim();
    }

    /**
     * 
     * repinta icono volumen
     * 
     */
    public void repintaVolumen() {
        derecha.repaint();
    }

    /**
     * 
     * getter volumen
     * 
     */
    public int getVolumen() {
        return derecha.getVolumen();
    }

    /**
     * 
     * setea SliderListener
     * 
     */
    public void setMySliderListener(ChangeListener cl) {
        derecha.setMySliderListener(cl);
    }
}