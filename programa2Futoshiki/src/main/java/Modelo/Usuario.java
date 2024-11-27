/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import java.io.Serializable;
/**
 *
 * @author XPC
 */
public class Usuario implements Serializable{
    
    public String Nickname;
    public String Pin;
    public String Correo;
    public int UsuarioHoras;
    public int UsuarioMinutos;
    public int UsuarioSegundos;
    public int TiempoTotal;
    
    /**
     *
     * @param nombre Nombre de Usuario
     * @param pin Numero PIn del Usuario
     * @param correo Correo electronico del usuario
     */
    
    public Usuario(String nombre, String pin, String correo){
        // Constructor utilizado para la creacion y registro de usuarios
        
        this.Nickname = nombre;
        this.Pin = pin;
        this.Correo = correo;
        
    }
    
}
