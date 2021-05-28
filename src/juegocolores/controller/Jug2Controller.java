/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;

import ini.view.JuegoColoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import juegocolores.model.MastermindModel;
import jug1.view.Jug1View;
import jug2.view.Jug2View;

/**
 *
 * @author oscar
 */
public class Jug2Controller {
    private MastermindModel model;
    private Jug2View view;
            
    public Jug2Controller(Jug2View view, MastermindModel model){
        this.model = model;
        this.view = view;
        
        view.setActionListener(new MyActionListener());
    }
    
    //clases empotradas
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String comando = ae.getActionCommand();
            
        }
    }
}
