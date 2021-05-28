/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.GridLayout;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;
import jug1.view.SeleccionPanel;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class IntentosPanel extends JPanel{
    private SeleccionPanel seleccion;
    private CirculosPanel[] circulos =  new CirculosPanel[5];
    
    /**
     * 
     * constructor
     * 
     */
    public IntentosPanel(MastermindModel model) {
        setLayout(new GridLayout(6,0));
        
        for (int i = 0; i < circulos.length; i++)
        {
            circulos[i] = new CirculosPanel(i, model);
            add(circulos[i]);
        }
        
        seleccion = new SeleccionPanel(2, model);
        add(seleccion);
        
        
    }

    /**
     * 
     * setter mouseLister
     * 
     */
    void setMyMouseListener(MouseListener ml) {
        seleccion.addMouseListener(ml);
    }

    /**
     * 
     * getter radio
     * 
     */
    int getRadio() {
        return seleccion.getRadio();
    }

    /**
     * 
     * repinta seleccion panel
     * 
     */
    void repinta() {
        seleccion.repaint();
        for (int i = 0; i < 5; i++) {
            circulos[i].repaint();
        }
    }

    /**
     * 
     * getter espacio
     * 
     */
    int getEspacio() {
        return seleccion.getEspacio();
    }

    /**
     * 
     * getter centrar
     * 
     */
    int getCentrar() {
        return seleccion.getCentrar();
    }

    /**
     * 
     * getter offsetX
     * 
     */
    int getOffsetX() {
        return seleccion.getOffsetX();
    }
}
