/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.*;  
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JFrame;  

/**
 *
 * @author oscar
 */
class AvatarPanel extends JPanel implements Runnable{
    private ArrayList<BufferedImage> pensando = new ArrayList<>();
    private int stage = 1;
    private int frame = 0;


    public AvatarPanel() {
        try {
            for (int i=2; i <= 3; i++){
                pensando.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
                System.out.println("Leido: " + System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png");
            }
        } catch (IOException ex) {
            Logger.getLogger(AvatarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(pensando.get(frame), 0, 0, 396, 396, this);
    }
    
    @Override
    public void run() {
        
        while(true){
            repaint();
            frame++;
            
            if (frame == pensando.size()){
                frame = 0;
            }
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println("fallo el thread");
            }
        }
    }
}


