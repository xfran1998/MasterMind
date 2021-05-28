/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.controller;


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
                
                if(model.compararAciertos())
                    view.setAnim(3);
                else
                    view.setAnim(4);
                
                if (model.getTurno() == 5 || model.comprobarVictoria())
                {
                    if(model.comprobarVictoria())
                        view.setAnim(5);
                    else
                        view.setAnim(6);
                    
                    model.setFin();
                            
                    view.cambiaBoton();
                }
                
                
                view.repinta();
            }
            
            if (comando == "ranking")
            {
                view.stopAnim();
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
                if(!model.getFin())
                {
                    view.setAnim(2);
                
                    if (me.getSource().getClass().toString().contains("ColoresPanel"))
                        for (int i = 0; i < model.getLargoColores(); i++)
                            if (me.getX() > view.getBorde()+(view.getAncho()*i) && me.getX() <= view.getBorde()+(view.getAncho()*(i+1)) && me.getY() > view.getBorde() && me.getY() <= view.getAltura())
                            {
                                if (model.getAcierto(0, model.getSeleccionado2()-1) != 2)
                                {
                                    model.addColor2(model.getColor(i));
                                }
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
                }
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
