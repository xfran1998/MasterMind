/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.model;

import java.awt.Color;
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
    private Color[] elegidos2 = {Color.white, Color.white, Color.white, Color.white};
    private int seleccionado = 1;
    private int seleccionado2 = 1;
    private final Color[] colores = {Color.red, Color.yellow, Color.blue, Color.green, Color.pink, new Color(112, 36, 160), new Color(150, 75, 0), new Color(63, 224, 208)};
    
    private int numColores = 8;
    private int turno = 0;
    
    private int[] aciertos1 = {0,0,0,0};
    private int[] aciertos2 = {0,0,0,0};
    private int[] aciertos3 = {0,0,0,0};
    private int[] aciertos4 = {0,0,0,0};
    private int[] aciertos5 = {0,0,0,0};
    
    private Color[] intento1 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento2 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento3 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento4 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento5 = {Color.white, Color.white, Color.white, Color.white};
    
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
    
    public void setSeleccionado(int i){
        seleccionado = i;
    }

    public void setSeleccionado2(int i) {
        seleccionado2 = i;
    }
    
    public int getSeleccionado(){
        return seleccionado;
    }
    
    public int getSeleccionado2() {
        return seleccionado2;
    }
    
    public void addColor(Color color)
    {
        comprobarColor(color);
        elegidos[seleccionado-1] = color;
    }
    
    public void addColor2(Color color) {
        comprobarColor2(color);
        elegidos2[seleccionado2-1] = color;
    }
    
    public void comprobarColor(Color color)
    {
        for (int i = 0; i < elegidos.length; i++)
            if (elegidos[i] == color)
                elegidos[i] = Color.white;
    }
    
    public void comprobarColor2(Color color)
    {
        for (int i = 0; i < elegidos.length; i++)
            if (elegidos2[i] == color)
                elegidos2[i] = Color.white;
    }
    
    public Color[] getElecciones()
    {
        return elegidos;
    }
    
    public Color getColorEleccion(int i)
    {
        return elegidos[i];
    }
    
    public Color getColorEleccion2(int i) {
        return elegidos2[i];
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
    
    public Boolean comprobarCompleto2()
    {
        Boolean todo = true;
        
        for(int i = 0; i < elegidos2.length; i++)
            if(elegidos2[i] == Color.white)
                todo = false;
        
        return todo;
    }

    public Color getColor(int i) {
        return colores[i];
    }

    public int getLargoColores() {
        return colores.length;
    }
    
    public void siguienteCirc() {
        seleccionado++;
        
        if (seleccionado > 4)
            seleccionado = 1;
    }

    public void siguienteCirc2() {
        seleccionado2++;
        
        if (seleccionado2 > 4)
            seleccionado2 = 1;
    }

    public String getSNumber(int tipo, int circulo) {
        int cont = 0;
        
        switch(tipo)
        {
            case 1:
                while((cont < (numColores) && (elegidos[circulo] != colores[cont])))
                    cont++;
                break;
            
            case 2:
                while((cont < (numColores) && (elegidos2[circulo] != colores[cont])))
                    cont++;
                break;
                
            case 3:
                while((cont < (numColores) && (intento5[circulo] != colores[cont])))
                    cont++;
                break;
                
            case 4:
                while((cont < (numColores) && (intento4[circulo] != colores[cont])))
                    cont++;
                break;
                
            case 5:
                while((cont < (numColores) && (intento3[circulo] != colores[cont])))
                    cont++;
                break;
                
            case 6:
                while((cont < (numColores) && (intento2[circulo] != colores[cont])))
                    cont++;
                break;
                
            case 7:
                while((cont < (numColores) && (intento1[circulo] != colores[cont])))
                    cont++;
                break;
        }
        
        cont++;
        
        if (cont > numColores)
            return "-";
        else
            return String.valueOf(cont);
    }
    
    public Boolean comprobarNombre()
    {
        return !nombre.isEmpty();
    }

    public int getTurno() {
        return turno;
    }
    
    public void aumentaTurno() {
        turno++;
    }
    
    public void comprobarIntento() {
        
        for(int j = 0; j < 4; j++)
        {
            intento5[j] = intento4[j];
            aciertos5[j] = aciertos4[j];
            intento4[j] = intento3[j];
            aciertos4[j] = aciertos3[j];
            intento3[j] = intento2[j];
            aciertos3[j] = aciertos2[j];
            intento2[j] = intento1[j];
            aciertos2[j] = aciertos1[j];
            intento1[j] = elegidos2[j];
        }
        
        for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (elegidos2[i] == elegidos[j])
                {
                    if(i == j)
                        aciertos1[i] = 2;
                    else
                        aciertos1[i] = 1;
                }
            }
        }
    }

    public boolean comprobarVictoria() {
        boolean victoria = true;
        
        for (int i = 0; i < 4; i++)
        {
            if(aciertos1[i] != 2)
                victoria = false;
        }
        
        return victoria;
    }

    public Color getIntento(int tipo, int circulo) {
        Color salida = Color.white;
        
        switch(tipo)
        {
            case 0:
                salida = intento1[circulo];
                break;
                
            case 1:
                salida = intento2[circulo];
                break;
                
            case 2:
                salida = intento3[circulo];
                break;
                
            case 3:
                salida = intento4[circulo];
                break;
                
            case 4:
                salida = intento5[circulo];
                break;
        }
        
        return salida;
    }
    
    public int getAcierto(int tipo, int circulo)
    {
        int salida = 0;
        
        switch(tipo)
        {
            case 0:
                salida = aciertos1[circulo];
                break;
                
            case 1:
                salida = aciertos2[circulo];
                break;
                
            case 2:
                salida = aciertos3[circulo];
                break;
                
            case 3:
                salida = aciertos4[circulo];
                break;
                
            case 4:
                salida = aciertos5[circulo];
                break;
        }
        
        return salida;
    }
}
