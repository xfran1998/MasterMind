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
 * @author oscar
 */
public class IntentosPanel extends JPanel{
    private SeleccionPanel seleccion;
    private CirculosPanel[] circulos =  new CirculosPanel[5];
    
    public IntentosPanel(MastermindModel model) {
        setLayout(new GridLayout(6,0));
        
        for (int i = 0; i < circulos.length; i++)
        {
            circulos[i] = new CirculosPanel();
            add(circulos[i]);
        }
        
        seleccion = new SeleccionPanel(2, model);
        add(seleccion);
        
        
    }

    void setMyMouseListener(MouseListener ml) {
        seleccion.addMouseListener(ml);
    }

    int getRadio() {
        return seleccion.getRadio();
    }

    void repinta() {
        seleccion.repaint();
    }

    int getEspacio() {
        return seleccion.getEspacio();
    }

    int getCentrar() {
        return seleccion.getCentrar();
    }

    int getOffsetX() {
        return seleccion.getOffsetX();
    }
}
