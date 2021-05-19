/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug1.view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 * @author francisco
 */
public class SeleccionPanel extends JPanel{
    private final int radio = 80;
    private final int offsetX = 60;
    private final int offsetY = 15; // Altura centro del circulo
    private final int numColor = 4;
    private int espacio;
    
    
    public SeleccionPanel(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        espacio = (this.getBounds().width - (offsetX*2) - radio*4)/3;
        
        Graphics2D g2 = (Graphics2D)g;
        
        for(int i = 0; i < numColor; i++)
        {
            if (i == 0)
                g2.setColor(Color.red);
            else
                g2.setColor(Color.WHITE); //Test
            g2.fillOval(offsetX+(radio*i)+(espacio*i), offsetY, radio, radio);
        }
        
        if (true)
        {
            g.setColor(Color.black);
            g.setFont(new Font("Dialog", Font.BOLD, 18));
            g.drawString("1", (offsetX+radio/2)-5, offsetY+(radio/2)+5);
        }
        
        g2.setColor(Color.orange);
        g2.setStroke(new BasicStroke(6));
        //los valores extra son para reposicionar el circulo grande y centrarlo sobre el circulo pequeño
        g2.drawOval(offsetX-2+radio+espacio, offsetY-2, radio+4, radio+4);
    }
}