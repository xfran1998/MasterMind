/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;
import jug1.view.ColoresPanel;

/**
 *
 * @author oscar
 */
public class IzquierdaPanel extends JPanel{
    private IntentosPanel intentos;
    private ColoresPanel colores;
    
    
    public IzquierdaPanel(MastermindModel model) {
        setLayout(new BorderLayout());
        
        intentos = new IntentosPanel(model);
        
        
        colores = new ColoresPanel(2, model);
        colores.setPreferredSize(new Dimension(110, 110));
        
        add(intentos, BorderLayout.CENTER);
        add(colores, BorderLayout.SOUTH);
    }
}
