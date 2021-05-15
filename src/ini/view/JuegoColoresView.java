/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import ini.view.MyDefaultMetalTheme3;
import ini.view.PreferencesPanel;
import ini.view.NombrePanel;
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
 */
public class JuegoColoresView extends JFrame{
    private TituloPanel titulo;
    private NombrePanel nombre;
    private PreferencesPanel pref;
            
    public JuegoColoresView(){
        
        //estilo de la ventana
        setLayout(new BorderLayout());
        //hacer que al cerrar desde la x se cierre el programa
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setTitle("Mastermind");
        
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
        titulo = new TituloPanel();
        nombre = new NombrePanel();
        pref = new PreferencesPanel();
        
        add(titulo, BorderLayout.NORTH);
        add(nombre, BorderLayout.CENTER);
        add(pref, BorderLayout.SOUTH);
        
        
        this.setVisible(true);
        
    }
}
