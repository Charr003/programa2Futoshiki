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
public class Usuario implements Serializable{
    
    protected String Nickname;
    protected String Pin;
    protected String Correo;
    protected int UsuarioHoras;
    protected int UsuarioMinutos;
    protected int UsuarioSegundos;
    protected int TiempoTotal;
    
    public Usuario(String nombre, String pin, String correo){
    
        this.Nickname = nombre;
        this.Pin = pin;
        this.Correo = correo;
        
    }
    
}
