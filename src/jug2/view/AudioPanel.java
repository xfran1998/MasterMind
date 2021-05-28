/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import juegocolores.model.MastermindModel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
class AudioPanel extends JPanel{
    private JSlider slider;
    private Polygon altavoz;
    
    /**
     * 
     *constructor
     * 
     */
    public AudioPanel(){
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50) {
            @Override
            public void updateUI() {
                setUI(new MyJSlider(this));
            }
        };
        slider.setMajorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPreferredSize(new Dimension(320,320));
        
        add(slider, BorderLayout.EAST);
        
        altavoz = new Polygon();
        //puntos del altavoz
        altavoz.addPoint(15, 45);
        altavoz.addPoint(15, 65);
        altavoz.addPoint(30, 60);
        altavoz.addPoint(60, 80);
        altavoz.addPoint(60, 30);
        altavoz.addPoint(30, 50);
        
        setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(2,2,2,2), BorderFactory.createMatteBorder(2,2,2,2,Color.WHITE)));
    }
    
    /**
     * 
     * override paintComponent
     * 
     */
    @Override
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(altavoz);
        
        //poner que pueda estar muted al clicar sobre el altavoz
        if (getVolumen() == 0)
        {
            g2.setColor(Color.red);
            g2.drawLine(20, 90, 70, 20);
            g2.drawLine(20, 20, 70, 90);
        }
        else
        {
            g2.setColor(Color.white);
            g2.drawLine(70, 40, 70, 70);
        }
        
        if (getVolumen() > 40)
            g2.drawLine(80, 30, 80, 80);
        
        if (getVolumen() > 80)
            g2.drawLine(90, 20, 90, 90);
        
        g2.setStroke(new BasicStroke(1));
        g2.setColor(Color.white);
    }
    
    /**
     * 
     * getter volumen
     * 
     */
    public int getVolumen(){
        return slider.getValue();
    }

    /**
     * 
     * setter SliderListener
     * 
     */
    void setMySliderListener(ChangeListener cl) {
        slider.addChangeListener(cl);
    }
}
