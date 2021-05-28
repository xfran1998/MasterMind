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
    private BufferedImage idle;
    private ArrayList<BufferedImage> pensando = new ArrayList<>();
    private ArrayList<BufferedImage> acertado = new ArrayList<>();
    private ArrayList<BufferedImage> fallado = new ArrayList<>();
    private ArrayList<BufferedImage> ganado = new ArrayList<>();
    private ArrayList<BufferedImage> perdido = new ArrayList<>();
    final int maxAnim = 6;
    private int anim = 1;
    private int frame = 0;
    private Boolean runAnim = false;


    public AvatarPanel() {
        try {
            
            //Anim 1 -> Idle
            idle = ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar1.png"));
                    
            //Anim 2 -> Pensando
            for (int i=2; i <= 3; i++){
                pensando.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
                System.out.println("Leido: " + System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png");
            }
            
            //Anim 3 -> Acertar
            for (int i=8; i <= 9; i++){
                acertado.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
                System.out.println("Leido: " + System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png");
            }
            
            //Anim 4 -> Fallar
            for (int i=6; i <= 7; i++){
                fallado.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
                System.out.println("Leido: " + System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png");
            }
            
            //Anim 5 -> Ganar
            for (int i=4; i <= 5; i++){
                ganado.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
                System.out.println("Leido: " + System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png");
            }
            //Anim 6 -> Perder
            for (int i=10; i <= 11; i++){
                perdido.add(ImageIO.read(new File(System.getProperty("user.dir")+"/imagenes/avatar" + Integer.toString(i) + ".png")));
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
        
        switch (anim){
            case 1:
                g.drawImage(idle, 0, 0, 396, 396, this);
                System.out.println("anim: " + 1);
                break;
                
            case 2:
                g.drawImage(pensando.get(frame), 0, 0, 396, 396, this);
                System.out.println("anim: " + 2);
                break;
                
            case 3:
                g.drawImage(acertado.get(frame), 0, 0, 396, 396, this);
                System.out.println("anim: " + 3);
                break;
                
            case 4:
                g.drawImage(fallado.get(frame), 0, 0, 396, 396, this);
                System.out.println("anim: " + 4);
                break;
                
            case 5:
                g.drawImage(ganado.get(frame), 0, 0, 396, 396, this);
                System.out.println("anim: " + 5);
                break;
                
            case 6:
                g.drawImage(perdido.get(frame), 0, 0, 396, 396, this);
                System.out.println("anim: " + 6);
                break;
        }
    }
    
    @Override
    public void run() {
        runAnim = true;
        
        while(runAnim){
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
    
    public void setAnim(int anim){
        if (anim <= maxAnim)
        {
            this.anim = anim;
            frame = 0; //puede causar problemas de threading, posible synchronized metodo
        }
        System.out.println("anim: " + anim);
    }
    
    public void stopAnim(){
        this.runAnim = false;
    }
}


