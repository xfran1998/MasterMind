/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 * @author francisco
 */
class PreferencesPanel extends JPanel{
    JCheckBox check1, check2;
    JLabel texto1, texto2;
    
    public PreferencesPanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        check1 = new JCheckBox();
        check1.setForeground(Color.white);
        
        texto1 = new JLabel("Activar modo daltonicos");
        texto1.setForeground(new Color(250, 240, 240));
        
        check2 = new JCheckBox();
        check2.setForeground(Color.white);
        
        texto2 = new JLabel("Modo 1 jugador");
        texto2.setForeground(new Color(250, 240, 240));
        
        JPanel capa1 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        JPanel capa2 = new JPanel(new FlowLayout(FlowLayout.LEFT,10,10));
        
        capa1.add(check1);
        capa1.add(texto1);
        
        capa2.add(check2);
        capa2.add(texto2);
        
        add(capa1);
        add(capa2);
    }
}
