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
    protected int SegundosTotal;

    public AjustesTop10(String Nickname, String Dificultad, int SegundosTotal) {
        
        this.Nickname = Nickname;
        this.Dificultad = Dificultad;
        this.SegundosTotal = SegundosTotal;
    }
}
