/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;
import jug1.view.ColoresPanel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class IzquierdaPanel extends JPanel{
    private IntentosPanel intentos;
    private ColoresPanel colores;
    
    /**
     * 
     * getter constructor
     * 
     */
    public IzquierdaPanel(MastermindModel model) {
        setLayout(new BorderLayout());
        
        intentos = new IntentosPanel(model);
        
        
        colores = new ColoresPanel(2, model);
        colores.setPreferredSize(new Dimension(110, 110));
        
        add(intentos, BorderLayout.CENTER);
        add(colores, BorderLayout.SOUTH);
    }

    /**
     * 
     * setter MouseListener
     * 
     */
    void setMyMouseListener(MouseListener ml) {
        colores.addMouseListener(ml);
        intentos.setMyMouseListener(ml);
    }

    /**
     * 
     * getter ancho
     * 
     */
    int getAncho() {
        return colores.getAncho();
    }

    /**
     * 
     * getter borde
     * 
     */
    int getBorde() {
        return colores.getBorde();
    }

    /**
     * 
     * getter altura
     * 
     */
    int getAltura() {
        return colores.getAltura();
    }

    /**
     * 
     * getter radio
     * 
     */
    int getRadio() {
        return intentos.getRadio();
    }

    /**
     * 
     * getter repinta intentos panel
     * 
     */
    void repinta() {
        intentos.repinta();
    }

    /**
     * 
     * getter espacio
     * 
     */
    int getEspacio() {
        return intentos.getEspacio();
    }

    /**
     * 
     * getter centrar
     * 
     */
    int getCentrar() {
        return intentos.getCentrar();
    }

    /**
     * 
     * getter OffsetX
     * 
     */
    int getOffsetX() {
        return intentos.getOffsetX();
    }
}
