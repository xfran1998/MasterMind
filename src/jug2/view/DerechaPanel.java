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
import javax.swing.event.ChangeListener;
import juegocolores.model.MastermindModel;
import jug1.view.BotonPanel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class DerechaPanel extends JPanel{
    private AudioPanel audio;
    private BotonPanel boton;
    private AvatarPanel avatar;
    
    /**
     * 
     * getter constructor
     * 
     */
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

    /**
     * 
     * setter ActionListener
     * 
     */
    void setActionListener(ActionListener al) {
        boton.setActionListener(al);
    }

    /**
     * 
     * cambia boton
     * 
     */
    void cambiaBoton() {
        boton.cambiaBoton();
    }
    
    /**
     * 
     * setter anim
     * 
     */
    public void setAnim(int anim){
        avatar.setAnim(anim);
    }
    
    /**
     * 
     * empieza animacion
     * 
     */
    public void startAnim(){
        Thread avatarMovement = new Thread(avatar);
        avatarMovement.start();
    }
    
    /**
     * 
     * para animacion
     * 
     */
    public void stopAnim(){
        avatar.stopAnim();
    }

    /**
     * 
     * repinta volumen
     * 
     */
    public void repintaVolumen() {
        audio.repaint();
    }

    /**
     * 
     * getter volumen
     * 
     */
    public int getVolumen() {
        return audio.getVolumen();
    }

    /**
     * 
     * getter volumen
     * 
     */
    void setMySliderListener(ChangeListener cl) {
        audio.setMySliderListener(cl);
    }
}
