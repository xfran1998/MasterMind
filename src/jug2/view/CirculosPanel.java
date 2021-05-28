/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

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
    
    public CirculosPanel(){
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
            g2.setColor(Color.WHITE); //Test
            g2.fillOval(offsetX+(radio*i)+(espacio*i), centrar, radio, radio);
        }
    }
}


