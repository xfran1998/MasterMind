/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;

import informacion.view.InformacionView;
import ini.view.JuegoColoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import juegocolores.model.MastermindModel;
import jug1.view.Jug1View;
import jug2.view.Jug2View;
import ranking.view.RankingView;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class InfoController {
    private InformacionView view;
    private MastermindModel model;
            
    public InfoController(InformacionView view, MastermindModel model){
        this.view = view;
        this.model = model;
        
        view.setActionListener(new MyActionListener());
    }
    
    //clases empotradas
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String comando = ae.getActionCommand();
            System.out.println(comando);
            
            switch (comando) {
                case "cerrar":
                    view.dispose();
                    break;
            }
        }
    }
}
