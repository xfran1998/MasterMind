/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ini.view;

import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import javax.swing.plaf.metal.DefaultMetalTheme;

/**
 *
 * @author oscar
 * @author francisco
 */
public class MyDefaultMetalTheme3 extends DefaultMetalTheme {
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
    public ColorUIResource getWindowTitleBackground() {
        return new ColorUIResource(java.awt.Color.black);
    }
    @Override
    public ColorUIResource getPrimaryControlHighlight() {
        return new ColorUIResource(java.awt.Color.black);
    }
    @Override
    public ColorUIResource getPrimaryControl() {
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getWindowTitleForeground() {
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getWindowTitleInactiveForeground() {
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getMenuBackground() {
        return new ColorUIResource(java.awt.Color.white);
    }
    
    @Override
    public ColorUIResource getMenuForeground() {
        return new ColorUIResource(java.awt.Color.black);
    }
    
    @Override
    public ColorUIResource getMenuSelectedBackground() {
        return new ColorUIResource(java.awt.Color.black);
    }
    
    @Override
    public ColorUIResource getMenuSelectedForeground() {
        return new ColorUIResource(java.awt.Color.white);
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
    
    //barras laterales centrales
    @Override
    public ColorUIResource getPrimaryControlInfo(){
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //si quitas primary es lo mismo pero para cuando esta inactivo
    
    //color de fondo de la ventana
    @Override
    public ColorUIResource getWindowBackground() {
        return new ColorUIResource(java.awt.Color.green);
    }
    
    //color del titulo y del texto de la ventana
    @Override
    public ColorUIResource getWindowTitleForeground() {
        return new ColorUIResource(java.awt.Color.green);
    }
    //lo mismo para cuando esta inactivo
    @Override
    public ColorUIResource getWindowTitleInactiveForeground() {
        return new ColorUIResource(java.awt.Color.white);
    }
    
    //color de fondo de los menus
    @Override
    public ColorUIResource getMenuBackground() {
        return new ColorUIResource(java.awt.Color.white);
    }
    */
}