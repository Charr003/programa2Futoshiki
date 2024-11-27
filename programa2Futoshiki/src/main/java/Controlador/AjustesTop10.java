/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import java.io.Serializable;
/**
 *
 * @author XPC
 */
public class AjustesTop10 implements Serializable {
    
    public String Nickname;
    public String Dificultad;
    public String TamTablero;
    public int SegundosTotal;

    /**
     *
     * @param Nickname Nombre de usuario
     * @param Dificultad Dificultad del tablero donde el usuario estaba jugando
     * @param Tablero Tamaño del tablero (3x3 - 10x10)
     * @param SegundosTotal Integer del total de segundos del juego del usuario
     */
    public AjustesTop10(String Nickname, String Dificultad, String Tablero, int SegundosTotal){
        
        this.Nickname = Nickname;
        this.Dificultad = Dificultad;
        this.TamTablero = Tablero;
        this.SegundosTotal = SegundosTotal;
    }
    
    
    // Funcion de debugging: toma el int de segundos y calcula segundos, minutos y horas
    public String tiempoFormateado(){
        
        int horas = SegundosTotal / 3600;
        int minutos = (SegundosTotal % 3600) / 60;
        int segundos = SegundosTotal % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
    
    // Funcion de debugging: Para print en consola
    @Override
    public String toString(){
        
        return Nickname + " - Tiempo: " + tiempoFormateado();
    } 
    
}
