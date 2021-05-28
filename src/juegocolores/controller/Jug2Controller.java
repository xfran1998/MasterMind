/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;

import ini.view.JuegoColoresView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import juegocolores.model.MastermindModel;
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
        view.setMyMouseListener(new Jug2Controller.MyMouseListener());
    }
    
    //clases empotradas
    class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ae) {
            String comando = ae.getActionCommand();
            
            if (comando == "siguiente")
            {
                model.aumentaTurno();
                model.comprobarIntento();
                
                if (model.getTurno() == 5 || model.comprobarVictoria())
                    view.cambiaBoton();
                
                view.repinta();
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
                            model.addColor2(model.getColor(i));
                            model.siguienteCirc2();
                            view.repinta();
                        }
                if (me.getSource().getClass().toString().contains("SeleccionPanel"))
                    for (int j = 0; j < 4; j++)
                        if (me.getX() >= (view.getOffsetX()+(view.getRadio()+view.getEspacio())*j) && me.getX() <= (view.getOffsetX()+(view.getRadio()*(j+1))+(view.getEspacio())*j))
                        {
                            model.setSeleccionado2(j+1);
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
