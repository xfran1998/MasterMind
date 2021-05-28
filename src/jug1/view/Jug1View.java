package jug1.view;

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
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import juegocolores.controller.Jug1Controller;
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 * @author francisco
 */
public class Jug1View extends JFrame{
    private ColoresPanel colores;
    private SeleccionPanel seleccion;
    private BotonPanel boton;
    private MastermindModel model;
    private MastermindMenuBar menu;

    public Jug1View(MastermindModel model){
        
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,420);
        setTitle("Mastermind - Jugador 1");
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
        
        this.model = model;
        
        colores = new ColoresPanel(1, model);
        colores.setPreferredSize(new Dimension(0, 160));
        
        seleccion = new SeleccionPanel(1, model);
        
        boton = new BotonPanel(1);
        
        add(colores, BorderLayout.NORTH);
        add(seleccion, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }

    /**
     * 
     * setActionLsitener
     * 
     */
    public void setActionListener(ActionListener al) {
        boton.setActionListener(al);
        menu.setActionListener(al);
    }

    /**
     * 
     * setter MouseListener
     * 
     */
    public void setMyMouseListener(MouseListener ml) {
        colores.addMouseListener(ml);
        seleccion.addMouseListener(ml);
    }
    
    /**
     * 
     * getter ancho
     * 
     */
    public int getAncho()
    {
        return colores.getAncho();
    }
    
    /**
     * 
     * getter borde
     * 
     */
    public int getBorde()
    {
        return colores.getBorde();
    }
    
    /**
     * 
     * getter altura
     * 
     */
    public int getAltura()
    {
        return colores.getAltura();
    }

    /**
     * 
     *  repinta
     * 
     */
    public void repinta() {
        seleccion.repaint();
    }
    
    /**
     * 
     * getter radio
     * 
     */
    public int getRadio()
    {
        return seleccion.getRadio();
    }
    
    /**
     * 
     * getter espacio
     * 
     */
    public int getEspacio()
    {
        return seleccion.getEspacio();
    }
    
    /**
     * 
     * getter centrar
     * 
     */
    public int getCentrar()
    {
        return seleccion.getCentrar();
    }
    
    /**
     * 
     * getter ofssetX
     * 
     */
    public int getOffsetX()
    {
        return seleccion.getOffsetX();
    }
}