/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 *
 * @author oscar
 * @author francisco
 */
public class MyDefaultMetalTheme extends DefaultMetalTheme {
    //primer plano
    @Override
    public ColorUIResource getPrimary1(){
        return new ColorUIResource(java.awt.Color.black);
    }
    
    @Override
    public ColorUIResource getPrimary2(){
        return new ColorUIResource(java.awt.Color.black);
    }
    
    @Override
    public ColorUIResource getPrimary3(){
        return new ColorUIResource(java.awt.Color.white);
    }
    
    //para cuando esta en segundo plano
    @Override
    public ColorUIResource getSecondary1(){
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getSecondary2(){
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getSecondary3(){
        return new ColorUIResource(java.awt.Color.black);
    }
    
    @Override
    public ColorUIResource getPrimaryControlHighlight() {
        return new ColorUIResource(java.awt.Color.white);
    }
    @Override
    public ColorUIResource getPrimaryControlDarkShadow() {
        return new ColorUIResource(java.awt.Color.white);
    }
    @Override
    public ColorUIResource getPrimaryControl() {
        return new ColorUIResource(java.awt.Color.black);
    }
    /*
    //barra superior titulo pero no los recuadros de acciones
    @Override
    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //puntos en medio de la barra
    @Override
    public ColorUIResource getPrimaryControlHighlight() {
        return new ColorUIResource(java.awt.Color.green);
    }

    //borde exterior y parte de los simbolos
    @Override
    public ColorUIResource getPrimaryControlDarkShadow() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //recuadro de fondo de los simbolos
    @Override
    public ColorUIResource getPrimaryControl() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //barras del centro cuando inactivo
    @Override
    public ColorUIResource getControlHighlight() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //borde exterior y parte de los simbolos inactivo
    @Override
    public ColorUIResource getPrimaryControlDarkShadow() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //recuadro de fondo de los simbolos cuadno inactivo
    @Override
    public ColorUIResource getControl() {
        return new ColorUIResource(java.awt.Color.green);
    }
    */
}
