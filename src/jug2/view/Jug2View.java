package jug2.view;

import ini.view.MyDefaultMetalTheme3;
import ini.view.TituloPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import juegocolores.controller.Jug2Controller;
import juegocolores.model.MastermindModel;

public class Jug2View extends JFrame{
    private DerechaPanel derecha;
    private IzquierdaPanel izquierda;

    public Jug2View(MastermindModel model){
        
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
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
        
        izquierda = new IzquierdaPanel(model);
        izquierda.setPreferredSize(new Dimension(550,550));
        
        add(izquierda, BorderLayout.WEST);
        
        derecha = new DerechaPanel();
        add(derecha, BorderLayout.CENTER);
        
        this.setVisible(true);
        
    }

    public void setActionListener(ActionListener al) {
        
    }
}