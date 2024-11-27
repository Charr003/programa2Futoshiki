/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Modelo.Usuario;
import Modelo.*;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


public class SistemaCorreos {

    
    /**
     *
     * @param fromEmail Correo del sistema
     * @param password Contraseña del correo del sistema
     * @param toEmail Correo del usuario
     * @param subject Titular del correo
     * @param messageBody Cuerpo del correo
     * @throws Exception
     */
    public static void EnviarCorreo(String fromEmail, String password, String toEmail, String subject, String messageBody) throws Exception {
        
        /*
           Función base para enviar todos los correos
        */

        // Validar los inputs
        if (fromEmail == null || !fromEmail.contains("@")){
            throw new IllegalArgumentException("Correo del remitente inválido");
        }
        if (password == null || password.length() < 6){
            throw new IllegalArgumentException("Contraseña inválida");
        }
        if (toEmail == null || !toEmail.contains("@")){
            throw new IllegalArgumentException("Correo del destinatario inválido");
        }
        
        // Configurar las propiedades de conexion
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Autenticacion
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            
            // Crear el mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageBody);

            // Enviar el mensaje
            Transport.send(message);
            System.out.println("Correo enviado correctamente");

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al enviar el correo");
        }
    }

    /**
     *
     * @param correo Correo del usuario
     */
    public void EnviarCorreoConfirmacion(String correo){
        
        // Funcion para envio de correo: notificacion de creacion de usuario
        
        try {
            String fromEmail = "parksysp11@gmail.com"; 
            String password = "nvei wqaw cugk qtvf"; 
            String toEmail = correo; // Correo del destinatario
            String subject = "Confirmacion de Cuenta";
            
            
            String messageBody = "Se ha creado exitosamente su perfil.";

            EnviarCorreo(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    
    }
    
    /**
     *
     * @param usuario Objecto con la información del usuario
     */
    public void EnviarCorreoNuevoPin(Usuario usuario){
        
        // Funcion para envio de correo: Envio de recuperacion de PIN para usuario existente
    
        try {
            String fromEmail = "parksysp11@gmail.com"; 
            String password = "nvei wqaw cugk qtvf"; 
            String toEmail = usuario.Correo; // Correo del destinatario
            String subject = "Cambio del PIN";
            
            
            String messageBody = "Estimado usuario, " + usuario.Nickname +"\n\nSe ha generado un nuevo PIN para su cuenta."
                    + "\nPIN: " +usuario.Pin;

            EnviarCorreo(fromEmail, password, toEmail, subject, messageBody);

        } catch (IllegalArgumentException e) {
            System.out.println("Error en los parámetros: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }  
    
    
    }
}
