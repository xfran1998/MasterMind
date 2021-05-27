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
public class ColoresPanel extends JPanel{
    private final Color[] colores = {Color.red, Color.yellow, Color.blue, Color.green, Color.pink, new Color(112, 36, 160)};
    private final String[] numeros = {"1","2","3","4","5","6"};
    private int ancho;
    private int altura;
    
    private int borde;
    
    
    
    public ColoresPanel(int tipo){
        setLayout(new FlowLayout(FlowLayout.CENTER));

        if (tipo == 1)
            borde = 20;
        else if (tipo == 2)
            borde = 2;
        
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(borde,borde,borde,borde),BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(250, 250, 250))));
    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        ancho = (this.getBounds().width - borde*2)/6;
        altura = (this.getBounds().height - borde*2);
        
        Graphics2D g2 = (Graphics2D)g;
        
        System.out.println(altura + " " + ancho);
        
        for(int i = 0; i < colores.length; i++)
        {
            g2.setColor(colores[i]);
            g2.fillRect(borde+(ancho*i), borde, ancho+2, altura);
            
            System.out.println(ancho*i);
            
            //aqui habria que mirar en el modelo si esta puest el modo daltonicos
            if (true)
            {
                g.setColor(Color.black);
                g.setFont(new Font("Dialog", Font.BOLD, 18));
                g.drawString(numeros[i], (borde+(ancho*i)+ancho/2)-5, 50);
            }
        }
        
        
    }
}