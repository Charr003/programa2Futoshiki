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
public class AjustesFutoshiki implements Serializable {

   public String nombre;
   public int IndiceTam;
   public int IndiceNivel;
   public int IndiceMultiNivel;
   public int IndiceReloj;
   public int IndicePosicion;
   public int HorasG;
   public int MinutosG;
   public int SegundosG;
   
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
