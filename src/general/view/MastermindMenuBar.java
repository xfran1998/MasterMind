/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general.view;

import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Oscar Marín Egea
 * @author Francisco Sevillano Asensi
 * 
 */
public class MastermindMenuBar extends JMenuBar{
    private JMenu juego, ayuda;
    private JMenuItem nuevo, opciones, ranking, salir, instrucciones, info;
    
    /**
    * Constructor del menu del editor
    */
    public MastermindMenuBar() {
        juego = new JMenu("Juego");
        ayuda = new JMenu("Ayuda");
        
        nuevo = new JMenuItem("Nuevo Juego");
        nuevo.setActionCommand("reiniciar");
        
        opciones = new JMenuItem("Opciones");
        opciones.setActionCommand("opciones");
        
        ranking = new JMenuItem("Ranking");
        ranking.setActionCommand("ranking");
        
        salir = new JMenuItem("Salir");
        salir.setActionCommand("MenuSalir");
        
        instrucciones = new JMenuItem("Instrucciones");
        instrucciones.setActionCommand("instruc");
        
        info = new JMenuItem("Informacion");
        info.setActionCommand("info");
        
        juego.add(nuevo);
        juego.add(opciones);
        juego.add(ranking);
        juego.add(salir);
        add(juego);
        
        ayuda.add(instrucciones);
        ayuda.add(info);
        add(ayuda);
    }
    
    /**
    * Setter de los diferentes listeners para el menu
    * @param actionListener Listener
    */
    public void setActionListener(ActionListener actionListener) {
        opciones.addActionListener(actionListener);
        nuevo.addActionListener(actionListener);
        ranking.addActionListener(actionListener);
        salir.addActionListener(actionListener);
        instrucciones.addActionListener(actionListener);
        info.addActionListener(actionListener);
    }
}
