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
   
    public AjustesFutoshiki(String nombre, int IndiceTam, int IndiceNivel, int IndiceMultiNivel, int IndiceReloj, int IndicePosicion) {
        
        this.nombre = nombre;
        this.IndiceTam = IndiceTam;
        this.IndiceNivel = IndiceNivel;
        this.IndiceMultiNivel = IndiceMultiNivel;
        this.IndiceReloj = IndiceReloj;
        this.IndicePosicion = IndicePosicion;
    }
   
   
}
