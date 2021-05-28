/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import jug1.view.BotonPanel;

/**
 *
 * @author oscar
 */
public class DerechaPanel extends JPanel{
    private AudioPanel audio;
    private BotonPanel boton;
    private AvatarPanel avatar;
    
    public DerechaPanel(){
        setLayout(new BorderLayout());
        
        audio = new AudioPanel();
        audio.setPreferredSize(new Dimension(110,110));
        
        boton = new BotonPanel(2);
        
        avatar = new AvatarPanel();
        avatar.setPreferredSize(new Dimension(400,400));
        
        add(audio, BorderLayout.SOUTH);
        add(boton, BorderLayout.CENTER);
        add(avatar, BorderLayout.NORTH);
    }

    void setActionListener(ActionListener al) {
        boton.setActionListener(al);
    }

    void cambiaBoton() {
        boton.cambiaBoton();
    }
}
