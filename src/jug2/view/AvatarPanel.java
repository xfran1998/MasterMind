/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
class AvatarPanel extends JPanel{
    
    public AvatarPanel(){
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
    }
}