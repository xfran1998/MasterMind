/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking.view;

import ini.view.MyDefaultMetalTheme2;
import ini.view.MyDefaultMetalTheme3;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import jug1.view.BotonPanel;

/**
 *
 * @author oscar
 */
public class RankingView extends JFrame{
    private BotonPanel boton;
    private RankingPanel ranking;
    private ResultadoPanel resultado;

    public RankingView(int tipo){
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        boton = new BotonPanel(3);
        
        ranking = new RankingPanel();
        
        resultado = new ResultadoPanel(2);
        
        if (tipo == 2)
            add(resultado, BorderLayout.NORTH);

        add(ranking, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
}
