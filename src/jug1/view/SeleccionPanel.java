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
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 * @author francisco
 */
public class SeleccionPanel extends JPanel{
    private int radio;
    private int offsetX = 0;
    private int offsetY = 0; // Altura centro del circulo
    private final int numColor = 4;
    private int espacio;
    private int centrar;
    private MastermindModel model;
    private int tipo;
    
    public SeleccionPanel(int tipo, MastermindModel model){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        this.model = model;
        this.tipo = tipo;
        
        if (tipo == 1)
        {
            offsetX = 60;
            offsetY = 15;
            radio = 80;
        }
        else if (tipo == 2)
        {
            offsetX = 20;
            offsetY = 10;
            radio = 70;
            
            setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
        }
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
            if (tipo == 1)
                g2.setColor(model.getColorEleccion(i));
            else
                g2.setColor(model.getColorEleccion2(i));
            
            g2.fillOval(offsetX+(radio*i)+(espacio*i), centrar, radio, radio);
            
            if (model.getDaltonicos())
            {
                g.setColor(Color.black);
                g.setFont(new Font("Dialog", Font.BOLD, 18));
                g.drawString(model.getSNumber(tipo, i), (offsetX+(radio+espacio)*i)+(radio/2)-5, offsetY+(radio/2)+5);
            }
        }
        
        g2.setColor(Color.orange);
        g2.setStroke(new BasicStroke(6));
        //los valores extra son para reposicionar el circulo grande y centrarlo sobre el circulo pequeño
        g2.drawOval((offsetX-2)+(radio+espacio)*((tipo == 1)? (model.getSeleccionado()-1):(model.getSeleccionado2()-1)), centrar-2, radio+4, radio+4);
    }
    
    public int getRadio()
    {
        return radio;
    }
    
    public int getEspacio()
    {
        return espacio;
    }
    
    public int getCentrar()
    {
        return centrar;
    }
    
    public int getOffsetX()
    {
        return offsetX;
    }
}