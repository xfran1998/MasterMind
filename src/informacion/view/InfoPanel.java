/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informacion.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import juegocolores.model.MastermindModel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
class InfoPanel extends JPanel{
    private JLabel info;
    
    
    public InfoPanel(MastermindModel model, int tipo){
        if(tipo == 2)
        {
            info = new JLabel(model.getAutores());
            info.setAlignmentY(CENTER_ALIGNMENT);
            info.setForeground(Color.white);

            add(info);
        }
        
        if(tipo == 1)
        {
            info = new JLabel(model.getInstr());
            info.setAlignmentY(CENTER_ALIGNMENT);
            info.setForeground(Color.white);
            
            add(info);
        }
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2,2,2,2), BorderFactory.createMatteBorder(2, 2, 2, 2, Color.white)));
    }
}
