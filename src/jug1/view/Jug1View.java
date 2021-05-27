package jug1.view;

import ini.view.MyDefaultMetalTheme3;
import ini.view.TituloPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author oscar
 * @author francisco
 */
public class Jug1View extends JFrame{
    private ColoresPanel colores;
    private SeleccionPanel seleccion;
    private BotonPanel boton;

    public Jug1View(){
        
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
        
        colores = new ColoresPanel(1);
        colores.setPreferredSize(new Dimension(0, 160));
        
        seleccion = new SeleccionPanel(1);
        
        boton = new BotonPanel();
        
        add(colores, BorderLayout.NORTH);
        add(seleccion, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
        
        this.setVisible(true);
        
    }
}