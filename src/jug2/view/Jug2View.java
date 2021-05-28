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

public class Jug2View extends JFrame{
    private DerechaPanel derecha;
    private IzquierdaPanel izquierda;
    private MastermindMenuBar menu;

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

    public void setActionListener(ActionListener al) {
        derecha.setActionListener(al);
        menu.setActionListener(al);
    }

    public void setMyMouseListener(MouseListener ml) {
        izquierda.setMyMouseListener(ml);
    }
    
    public int getAncho()
    {
        return izquierda.getAncho();
    }
    
    public int getBorde()
    {
        return izquierda.getBorde();
    }
    
    public int getAltura()
    {
        return izquierda.getAltura();
    }

    public void repinta() {
        izquierda.repinta();
    }
    
    public int getRadio()
    {
        return izquierda.getRadio();
    }
    
    public int getEspacio()
    {
        return izquierda.getEspacio();
    }
    
    public int getCentrar()
    {
        return izquierda.getCentrar();
    }
    
    public int getOffsetX()
    {
        return izquierda.getOffsetX();
    }

    public void cambiaBoton() {
        derecha.cambiaBoton(); 
    }
    
    public void setAnim(int anim){
        derecha.setAnim(anim);
    }
    
    public void stopAnim(){
        derecha.stopAnim();
    }

    public void repintaVolumen() {
        derecha.repaint();
    }

    public int getVolumen() {
        return derecha.getVolumen();
    }

    public void setMySliderListener(ChangeListener cl) {
        derecha.setMySliderListener(cl);
    }
}