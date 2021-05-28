/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking.view;

import ini.view.MyDefaultMetalTheme2;
import ini.view.MyDefaultMetalTheme3;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import juegocolores.controller.RankingController;
import juegocolores.model.MastermindModel;
import jug1.view.BotonPanel;

/**
 *
 * @author oscar
 * @author francisco
 */
public class RankingView extends JFrame{
    private BotonPanel boton1, boton2;
    private RankingPanel ranking;
    private ResultadoPanel resultado;
    private JPanel panel;
    private int tipo;

    /**
     * 
     * Constructor
     * 
     */
    public RankingView(int tipo, MastermindModel model){
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        if (tipo == 1)
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        else if (tipo == 2)
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,700);
        setTitle("Mastermind - Ranking");
        setResizable(false);
        
        this.setLocationRelativeTo(null);

        this.setUndecorated(true);
        this.getRootPane().setWindowDecorationStyle(3);
        

        MetalLookAndFeel.setCurrentTheme(new MyDefaultMetalTheme2());
        
        try {
          UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }

        SwingUtilities.updateComponentTreeUI(this);
        
        //componentes de la vista
        boton1 = new BotonPanel(3);
        boton2 = new BotonPanel(4);
        
        this.tipo = tipo;
        ranking = new RankingPanel(model);
        
        resultado = new ResultadoPanel(model.comprobarVictoria(), model);
        
        panel = new JPanel(new GridLayout(0,tipo));
        
        if (tipo == 2)
        {
            panel.add(boton2);
            add(resultado, BorderLayout.NORTH);
        }
        
        add(ranking, BorderLayout.CENTER);
        panel.add(boton1);
        
        
        add(panel, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    /**
     * 
     * Devuelve el tipo
     * 
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * 
     * setea el ActionListener
     * 
     */
    public void setActionListener(ActionListener al) {
        boton1.setActionListener(al);
        boton2.setActionListener(al);
    }
}
