/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 */
class RankingPanel extends JPanel{
    private MastermindModel model;
    
    public RankingPanel(MastermindModel model){
        this.model = model;
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4),BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white)));
    }
}
