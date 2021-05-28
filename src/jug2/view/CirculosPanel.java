/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 */
public class CirculosPanel extends JPanel{
    private int offsetX = 20;
    private int offsetY = 10;
    private int radio = 70;
    private final int numColor = 4;
    private int espacio;
    private int centrar;
    private MastermindModel model;
    private int tipo;
    
    public CirculosPanel(int tipo, MastermindModel model){
        this.model = model;
        this.tipo = tipo;
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
    }
    
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        espacio = (this.getBounds().width - (offsetX*2) - radio*4)/3;
        centrar = (this.getBounds().height/2)-(radio/2); 
        
        Graphics2D g2 = (Graphics2D)g;
        
        for(int i = 0; i < numColor; i++)
        {
            g2.setColor(model.getIntento(4-tipo, i));
            g2.fillOval(offsetX+(radio*i)+(espacio*i), centrar, radio, radio);
            
            if (model.getDaltonicos())
            {
                g.setColor(Color.black);
                g.setFont(new Font("Dialog", Font.BOLD, 18));
                g.drawString(model.getSNumber(3+tipo, i), (offsetX+(radio+espacio)*i)+(radio/2)-5, offsetY+(radio/2)+5);
            }
        }
    }
}


