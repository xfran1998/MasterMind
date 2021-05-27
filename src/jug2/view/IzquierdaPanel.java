/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jug2.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import jug1.view.ColoresPanel;

/**
 *
 * @author oscar
 */
public class IzquierdaPanel extends JPanel{
    private IntentosPanel intentos;
    private ColoresPanel colores;
    
    
    public IzquierdaPanel() {
        setLayout(new BorderLayout());
        
        intentos = new IntentosPanel();
        
        
        colores = new ColoresPanel(2);
        colores.setPreferredSize(new Dimension(120, 120));
        
        add(intentos, BorderLayout.CENTER);
        add(colores, BorderLayout.SOUTH);
    }
}
