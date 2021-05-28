/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegocolores.model;

import ini.view.JuegoColoresView;
import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import jug1.view.Jug1View;
import jug2.view.Jug2View;
import javax.sound.sampled.*;

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
    
    private int acertado = 0;
    private Color[] coloresAcertados = {Color.white, Color.white, Color.white, Color.white};
    
    private Color[] intento1 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento2 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento3 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento4 = {Color.white, Color.white, Color.white, Color.white};
    private Color[] intento5 = {Color.white, Color.white, Color.white, Color.white};
    
    private JuegoColoresView vista1;
    private Jug1View vista2;
    private Jug2View vista3;
    
    Clip music;
    Ranking myRanking = new Ranking(5, 10);
    
    boolean fin = false;
    
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
        int color = 0;
        
        while (intSet.size() < 4)
            intSet.add(random.nextInt(7-0)+0);
        
        final Iterator<Integer> iter = intSet.iterator();
        
        for(int i = 0; iter.hasNext(); i++)
        {
            color = iter.next();
            addColor(colores[color]);
            siguienteCirc();
        }
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
            aciertos1[i] = 0;
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
    
    public boolean compararAciertos()
    {
        int nuevosAciertos = 0;
        boolean mayor = false;
        
        for(int i = 0; i < aciertos1.length; i++)
        {
            nuevosAciertos += aciertos1[i];
        }
        
        if (nuevosAciertos > acertado)
            mayor = true;
        
        acertado = nuevosAciertos;
        return mayor;
    }

    public void setFin() {
        fin = true;
    }
    
    public boolean getFin(){
        return fin;
    }

    public void reiniciar() {
        nombre = "";
        jugadas = 0;
        seleccionado = 1;
        seleccionado2 = 1;
        numColores = 8;
        turno = 0;
        acertado = 0;

        fin = false;
        
        for (int i = 0; i < 4; i++)
        {
            elegidos[i] = Color.white;
            elegidos2[i] = Color.white;
            
            aciertos1[i] = 0;
            aciertos2[i] = 0;
            aciertos3[i] = 0;
            aciertos4[i] = 0;
            aciertos5[i] = 0;
            
            intento1[i] = Color.white;
            intento2[i] = Color.white;
            intento3[i] = Color.white;
            intento4[i] = Color.white;
            intento5[i] = Color.white;
        }
        
        if(vista3 != null)
            vista3.dispose();
        
        if(vista2 != null)
            vista2.dispose();
        
        if(vista1 != null)
            vista1.setVisible(true);
    }
    
    public void setVista1 (JuegoColoresView vista1)
    {
        this.vista1 = vista1;
    }
    
    public void setVista2 (Jug1View vista2)
    {
        this.vista2 = vista2;
    }
    
    public void setVista3 (Jug2View vista3)
    {
        this.vista3 = vista3;
    }

    public boolean colorAcertado(int i) {
        boolean acertado = false;
        
        for(int j = 0; j < intento1.length; j++)
        {
            if (intento1[j] == colores[i] && aciertos1[i] == 2)
                acertado = true;
        }
        
        return acertado;
    }
    
    public void setMusic(){
        try {
            String path = System.getProperty("user.dir")+"/music/zavodilla.wav";
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            music = AudioSystem.getClip();
            music.open(inputStream);
            
            changeMusicLevel(50);
        }catch (Exception e){
            System.out.println("Musica no encontrada");
            System.err.println(e.getMessage());
        }
    }
    
    public void startMusic(){
        music.start();
    }
    
    public void stopMusic(){
        music.stop();
    }
    
    public void resetMusic(){
        music.setMicrosecondPosition(0);
    }
    
    public void quitMusic(){
        music.close();
    }
    
    public void changeMusicLevel(int musicLevel){
        FloatControl volumen = (FloatControl)music.getControl(FloatControl.Type.MASTER_GAIN);
        
        float level = (float)musicLevel/100.0f;
        
        float range = volumen.getMaximum() - volumen.getMinimum();
        float gain = (range * level) + volumen.getMinimum();
        volumen.setValue(gain);
    }
    
    public void loadRanking(){
        myRanking.LeerRanking();
    }
    
    public void saveRanking(){
        myRanking.saveRaking();
    }
    
    public void addPlayer(){
        myRanking.addRanking(new UserRanking(nombre, turno));
    }
    
    public String[] getRanking(){
        return myRanking.getRanking();
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getAutores(){
        String path = System.getProperty("user.dir")+"/textos/autores.txt";
        String name = "";
        
        try {
            Scanner myReader = new Scanner(new File(path));
            
            
            while (myReader.hasNextLine()) {
                name = myReader.nextLine();
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("no ha funcionado");
            e.printStackTrace();
        }
        
        return name;
    }
    
    public String getInstr(){
        String path = System.getProperty("user.dir")+"/textos/autores.txt";
        String name = "";
        
        try {
            Scanner myReader = new Scanner(new File(path));
            
            
            while (myReader.hasNextLine()) {
                name = myReader.nextLine();
            }
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("no ha funcionado");
            e.printStackTrace();
        }
        
        return name;
    }
    
    
}
