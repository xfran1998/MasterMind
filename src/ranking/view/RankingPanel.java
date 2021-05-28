/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 */
class RankingPanel extends JPanel{
    private MastermindModel model;
    private JLabel[] rankingText = new JLabel[10];
    
    public RankingPanel(MastermindModel model){
        this.model = model;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        for (int i = 0; i < rankingText.length; i++)
        {
            rankingText[i] = new JLabel(model.getRanking()[i]);
            rankingText[i].setForeground(Color.white);
            rankingText[i].setAlignmentX(CENTER_ALIGNMENT);
            add(rankingText[i]);
        }
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4),BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white)));
    }
}
