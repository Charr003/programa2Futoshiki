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
public class AjustesFutoshiki implements Serializable {

   protected String nombre;
   protected int IndiceTam;
   protected int IndiceNivel;
   protected int IndiceMultiNivel;
   protected int IndiceReloj;
   protected int IndicePosicion;
   protected int HorasG;
   protected int MinutosG;
   protected int SegundosG;
   
    public AjustesFutoshiki(String nombre, int IndiceTam, int Nivel, int IndiceMultiNivel, int IndiceReloj, int IndicePosicion, int hora, int min, int seg) {
        
        this.nombre = nombre;
        this.IndiceTam = IndiceTam;
        this.IndiceNivel = Nivel;
        this.IndiceMultiNivel = IndiceMultiNivel;
        this.IndiceReloj = IndiceReloj;
        this.IndicePosicion = IndicePosicion;
        this.HorasG = hora;
        this.MinutosG = min;
        this.SegundosG = seg;
    }
}
