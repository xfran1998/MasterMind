package jug1.view;

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

    public Jug1View(MastermindModel model){
        
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
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

    public void setActionListener(ActionListener al) {
        boton.setActionListener(al);
    }

    public void setMyMouseListener(MouseListener ml) {
        colores.addMouseListener(ml);
        seleccion.addMouseListener(ml);
    }
    
    public int getAncho()
    {
        return colores.getAncho();
    }
    
    public int getBorde()
    {
        return colores.getBorde();
    }
    
    public int getAltura()
    {
        return colores.getAltura();
    }

    public void repinta() {
        seleccion.repaint();
    }
    
    public int getRadio()
    {
        return seleccion.getRadio();
    }
    
    public int getEspacio()
    {
        return seleccion.getEspacio();
    }
    
    public int getCentrar()
    {
        return seleccion.getCentrar();
    }
    
    public int getOffsetX()
    {
        return seleccion.getOffsetX();
    }
}