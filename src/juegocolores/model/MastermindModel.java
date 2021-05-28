/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.model;

import java.awt.Color;
import static java.lang.Math.random;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author oscar
 */
public class MastermindModel {
    private String nombre = "";
    private int jugadas = 0;
    
    private int modo = 2;
    private Boolean daltonicos = false;

    private Color[] elegidos = {Color.white, Color.white, Color.white, Color.white};
    private int seleccionado = 1;
    private final Color[] colores = {Color.red, Color.yellow, Color.blue, Color.green, Color.pink, new Color(112, 36, 160), new Color(150, 75, 0), new Color(63, 224, 208)};
    
    public MastermindModel(){
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void changeModo()
    {
        if (modo == 2)
            modo = 1;
        else
            modo = 2;
    }
    
    public int getModo()
    {
        return modo;
    }
    
    public void changeDaltonicos()
    {
        daltonicos = !daltonicos;
    }
    
    public Boolean getDaltonicos()
    {
        return daltonicos;
    }
    
    public void setSeleccionado(int seleccion){
        seleccionado = seleccion;
    }
    
    public int getSeleccionado(){
        return seleccionado;
    }
    
    public void addColor(Color color)
    {
        comprobarColor(color);
        elegidos[seleccionado] = color;
    }
    
    public void comprobarColor(Color color)
    {
        for (int i = 0; i < elegidos.length; i++)
            if (elegidos[i] == color)
                elegidos[i] = Color.white;
    }
    
    public Color[] getElecciones()
    {
        return elegidos;
    }
    
    public void randomizeSelections()
    {
        final Random random = new Random();
        final Set<Integer> intSet = new HashSet<>();
        
        while (intSet.size() < 4)
            intSet.add(random.nextInt(8)+1);
        
        final Iterator<Integer> iter = intSet.iterator();
        
        for(int i = 0; iter.hasNext(); i++)
            addColor(colores[iter.next()]);
    }
    
    public Boolean comprobarCompleto()
    {
        Boolean todo = true;
        
        for(int i = 0; i < elegidos.length; i++)
            if(elegidos[i] == Color.white)
                todo = false;
        
        return todo;
    }

    public Color getColor(int i) {
        return colores[i];
    }

    public int getLargoColores() {
        return colores.length;
    }
}
