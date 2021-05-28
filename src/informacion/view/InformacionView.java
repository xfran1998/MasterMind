/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion.view;

import ini.view.MyDefaultMetalTheme;
import ini.view.MyDefaultMetalTheme2;
import ini.view.MyDefaultMetalTheme3;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import juegocolores.controller.InfoController;
import juegocolores.model.MastermindModel;
import jug1.view.BotonPanel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class InformacionView extends JFrame{
    BotonPanel boton;
    InfoPanel informacion;
    
    public InformacionView(int tipo, MastermindModel model) {
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        if (tipo == 1)
        {
            setSize(700,600);
            setTitle("Mastermind - Instrucciones");
        }
        else if (tipo == 2)
        {
            setSize(700,200);
            setTitle("Mastermind - Informacion");
        }
        else if (tipo == 3)
        {
            setSize(700,500);
            setTitle("Mastermind - Opciones");
        }
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
        informacion = new InfoPanel(model, tipo);
        
        JScrollPane scroller = new JScrollPane(informacion, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        boton = new BotonPanel(3);
        
        add(scroller, BorderLayout.CENTER);
        add(boton, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    public void setActionListener(ActionListener al) {
        boton.setActionListener(al);
    }
    
}
