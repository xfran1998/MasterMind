/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author oscar
 */
class NombrePanel extends JPanel{
    private JLabel texto;
    private JTextField nombre;
    private JButton boton;
    
    public NombrePanel(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        
        texto = new JLabel("Introduce tu nombre");
        texto.setAlignmentX(CENTER_ALIGNMENT);
        texto.setForeground(new Color(10, 159, 224));
        //texto.setForeground(new Color(250, 240, 240));
        texto.setFont(new Font("Monoespaced", Font.PLAIN, 20));
        
        JPanel contenedor = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        
        nombre = new JTextField();
        nombre.setPreferredSize(new Dimension(250, 40));
        nombre.setBackground(new Color(15,15,15));
        nombre.setForeground(Color.white);
        nombre.setFont(new Font("Monoespaced", Font.PLAIN, 18));
        nombre.setHorizontalAlignment(JLabel.CENTER);
        nombre.setCaretColor(Color.white);
        
        Border borde1 = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.white);
        
        nombre.setBorder(borde1);
        
        boton = new JButton("Comienza a jugar");
        boton.setAlignmentX(CENTER_ALIGNMENT);
        boton.setBackground(new Color(40, 40, 40));
        boton.setForeground(new Color(240, 240, 240));
        boton.setFont(new Font("Monoespaced", Font.PLAIN, 18));
        boton.setFocusPainted(false);
        
        Border bordeExt = BorderFactory.createMatteBorder(2, 1, 2, 1, new Color(80, 80, 80));
        Border bordeInt = BorderFactory.createEmptyBorder(10,20,10,20);
        
        boton.setBorder(BorderFactory.createCompoundBorder(bordeExt,bordeInt));
        
        contenedor.add(nombre);
        
        add(texto);
        add(contenedor);
        add(boton);
        
        Border superior = BorderFactory.createEmptyBorder(50, 0, 130, 0);
        setBorder(superior);
        
    }
}
