/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;

import ini.view.JuegoColoresView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import juegocolores.model.MastermindModel;
import jug1.view.Jug1View;
import jug2.view.Jug2View;

/**
 *
 * @author oscar
 */
public class Jug1Controller {
    private MastermindModel model;
    private Jug1View view;
            
    public Jug1Controller(Jug1View view, MastermindModel model){
        this.model = model;
        this.view = view;
        
        view.setActionListener(new MyActionListener());
        view.setMyMouseListener(new MyMouseListener());
    }
    
    //clases empotradas
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String comando = ae.getActionCommand();
            
            if (comando == "siguiente")
                if (model.comprobarCompleto())
                {
                    view.setVisible(false);
                    Jug2View viewJug2 = new Jug2View(model);
                    Jug2Controller controllerJug1 = new Jug2Controller(viewJug2, model);
                }
        }
    }
    
    class MyMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent me)
        {
            int boton = me.getButton();
            
            if(boton == 1)
            {
                System.out.println(me.getX() + " " + me.getY());
                
                if (me.getSource().getClass().toString().contains("ColoresPanel"))
                    for (int i = 0; i < model.getLargoColores(); i++)
                        if (me.getX() > view.getBorde()+(view.getAncho()*i) && me.getX() <= view.getBorde()+(view.getAncho()*(i+1)) && me.getY() > view.getBorde() && me.getY() <= view.getAltura())
                        {
                            model.addColor(model.getColor(i));
                            model.siguienteCirc();
                            view.repinta();
                        }
                if (me.getSource().getClass().toString().contains("SeleccionPanel"))
                    for (int j = 0; j < 4; j++)
                        if (me.getX() >= (view.getOffsetX()+(view.getRadio()+view.getEspacio())*j) && me.getX() <= (view.getOffsetX()+(view.getRadio()*(j+1))+(view.getEspacio())*j))
                        {
                            model.setSeleccionado(j+1);
                            view.repinta();
                        }
                
                //hay que hacer la seleccion del circulo a pintar
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
}
