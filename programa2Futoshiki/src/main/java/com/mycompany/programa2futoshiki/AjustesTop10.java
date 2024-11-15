/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa2futoshiki;
import java.io.Serializable;
/**
 *
 * @author XPC
 */
public class AjustesTop10 implements Serializable {
    
    protected String Nickname;
    protected String Dificultad;
    protected String TamTablero;
    protected int SegundosTotal;

    public AjustesTop10(String Nickname, String Dificultad, String Tablero, int SegundosTotal){
        
        this.Nickname = Nickname;
        this.Dificultad = Dificultad;
        this.TamTablero = Tablero;
        this.SegundosTotal = SegundosTotal;
    }
    public String tiempoFormateado(){
        
        int horas = SegundosTotal / 3600;
        int minutos = (SegundosTotal % 3600) / 60;
        int segundos = SegundosTotal % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    
    @Override
    public String toString(){
        
        return Nickname + " - Tiempo: " + tiempoFormateado();
    } 
    
}
