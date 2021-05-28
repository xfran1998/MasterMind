/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;

import ini.view.JuegoColoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import juegocolores.model.MastermindModel;
import jug1.view.Jug1View;
import jug2.view.Jug2View;

/**
 *
 * @author oscar
 */
public class MastermindController {
    private MastermindModel model;
    private JuegoColoresView view;
            
    public MastermindController(JuegoColoresView view, MastermindModel model){
        this.model = model;
        this.view = view;
        
        view.setActionListener(new MyActionListener());
    }
    
    //clases empotradas
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String comando = ae.getActionCommand();
            
            switch (comando) {
                case "siguiente":
                    model.setNombre(view.getNombre());
                
                    if (model.comprobarNombre())
                        if (model.getModo() == 2)
                        {
                            view.setVisible(false);
                            Jug1View viewJug1 = new Jug1View(model);
                            Jug1Controller controllerJug1 = new Jug1Controller(viewJug1, model);
                        }
                        else
                        {
                            model.randomizeSelections();
                            view.setVisible(false);
                            Jug2View viewJug2 = new Jug2View(model);
                            Jug2Controller controllerJug1 = new Jug2Controller(viewJug2, model);
                        }
                    break;
                
                case "cambioModo":
                    model.changeModo();
                    break;
                    
                case "daltonicos":
                    model.changeDaltonicos();
                    break;
            }
        }
    }
}
