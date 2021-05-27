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
class AvatarPanel extends JPanel{
    private BufferedImage imagen;


    public AvatarPanel() {
        try {
            imagen = ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar1.png"));
        } catch (IOException ex) {
            Logger.getLogger(AvatarPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(3,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
    }

    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(imagen, 0, 0, 396, 396, this);
    }
}


