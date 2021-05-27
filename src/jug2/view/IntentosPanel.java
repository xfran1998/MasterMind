/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.GridLayout;
import javax.swing.JPanel;
import jug1.view.SeleccionPanel;

/**
 *
 * @author oscar
 */
public class IntentosPanel extends JPanel{
    private SeleccionPanel seleccion;
    private CirculosPanel[] circulos =  new CirculosPanel[4];
    
    public IntentosPanel() {
        setLayout(new GridLayout(5,0));
        
        for (int i = 0; i < circulos.length; i++)
        {
            circulos[i] = new CirculosPanel();
            add(circulos[i]);
        }
        
        seleccion = new SeleccionPanel(2);
        add(seleccion);
        
        
    }
}
