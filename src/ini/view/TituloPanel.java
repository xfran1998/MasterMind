/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author oscar
 */
public class TituloPanel extends JPanel{
    private JLabel titulo = new JLabel("MASTERMIND COLOR");
    
    public TituloPanel() {
        setLayout(new FlowLayout(FlowLayout.CENTER,30,20));
        
        titulo.setForeground(new Color(235, 235, 245));
        titulo.setFont(new Font("Monoespaced", Font.BOLD, 30));
        add(titulo);
                
        Border superior = BorderFactory.createMatteBorder(1,0,0,0,new Color(255,250,250));
        Border intermedio = BorderFactory.createEmptyBorder(30, 20, 0, 20);
        
        /* feo
        Border inferior = BorderFactory.createMatteBorder(6,6,6,6,new Color(50,50,50));
        Border interior = BorderFactory.createMatteBorder(3,3,3,3,new Color(100,100,100));
        Border interior2 = BorderFactory.createMatteBorder(1,0,1,0,new Color(200,200,200));
        */
        
        /* iluminacion
        Border inferior = BorderFactory.createMatteBorder(6,6,6,6,new Color(23,23,23));
        Border interior = BorderFactory.createMatteBorder(4,4,4,4,new Color(40,40,40));
        Border interior2 = BorderFactory.createMatteBorder(4,0,4,0,new Color(60,60,60));
        */
        Border inferior = BorderFactory.createMatteBorder(6,6,6,6,new Color(23,23,23));
        Border interior = BorderFactory.createMatteBorder(4,4,4,4,new Color(40,40,40));
        Border interior2 = BorderFactory.createMatteBorder(4,0,4,0,new Color(60,60,60));
        
        /* azul
        Border inferior = BorderFactory.createMatteBorder(6,6,6,6,new Color(5,5,40));
        Border interior = BorderFactory.createMatteBorder(6,6,6,6,new Color(5,5,80));
        Border interior2 = BorderFactory.createMatteBorder(3,0,3,0,new Color(5,5,160));
        */

        setBorder(BorderFactory.createCompoundBorder(superior, BorderFactory.createCompoundBorder(intermedio, BorderFactory.createCompoundBorder(inferior, BorderFactory.createCompoundBorder(interior, interior2)))));
    }
}
