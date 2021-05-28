/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ranking.view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juegocolores.model.MastermindModel;

/**
 *
 * @author oscar
 */
class ResultadoPanel extends JPanel{
    private JLabel nombre;
    private JLabel resultado;
    private JLabel puntuacion;
    
    public ResultadoPanel(boolean tipo, MastermindModel model){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        if (tipo)
        {
            resultado = new JLabel("¡¡¡ENHORABUENA!!!");
            puntuacion = new JLabel("en " + model.getTurno() + " intentos");
        }
        else
        {
            resultado = new JLabel("MAS SUERTE LA PROXIMA");
            puntuacion = new JLabel("La proxima te saldra mejor");
        }
        
        resultado.setFont(new Font("Monoespaced", Font.BOLD, 20));
        resultado.setForeground(Color.white);
        resultado.setAlignmentX(CENTER_ALIGNMENT);
        
        nombre = new JLabel(model.getNombre());
        nombre.setFont(new Font("Monoespaced", Font.PLAIN, 20));
        nombre.setForeground(Color.white);
        nombre.setAlignmentX(CENTER_ALIGNMENT);
        
        
        puntuacion.setFont(new Font("Monoespaced", Font.PLAIN, 15));
        puntuacion.setForeground(Color.white);
        puntuacion.setAlignmentX(CENTER_ALIGNMENT);
        
        add(resultado);
        add(nombre);
        add(puntuacion);
    }
}
