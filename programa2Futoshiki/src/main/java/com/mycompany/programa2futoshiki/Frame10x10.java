/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.programa2futoshiki;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
/**
 *
 * @author jxdga
 */
public class Frame10x10 extends javax.swing.JFrame {
    
    private Timer timer;
    private int horas, minutos, segundos;
    private int tiempoTranscurridoSegundos = 0;
    private int ModoTiempo = 0;
    private boolean esCronometro = true;
    private JButton[][] botones;
    int PuntoX,PuntoY,PuntoX2,PuntoY2;
    int [][] matrizNumeros = {
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0}
    };
    
    /**
     * Creates new form Frame10x10
     */
    
    public Frame10x10() {
        initComponents();
        inicializarBotones();
        setLocationRelativeTo(null);
        
        
        timer = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                
                tiempoTranscurridoSegundos++; // Esto se usa para el calculo del tiempo total en ambos modos

                if(esCronometro){
                    // Lógica para cuenta hacia adelante
                    segundos++;
                    
                    if(segundos == 60){
                        
                        segundos = 0;
                        minutos++;
                        
                        if(minutos == 60){
                            
                            minutos = 0;
                            horas++;
                        }
                    }

                    // Validacion del cronometro, revisar si se alcanzado el limite de tiempo: 10 mins
                    if(minutos == 10 && segundos == 0){
                        detenerTiempo("Se ha acabado el tiempo del cronómetro.");
                    }

                }else{
                    // Lógica para cuenta hacia atras
                    if(segundos == 0) {
                        
                        if(minutos == 0){
                            
                            detenerTiempo("Se ha acabado el tiempo del temporizador.");
                            return;
                            
                        }else{
                            minutos--;
                            segundos = 59;
                        }
                        
                    }else{
                        segundos--;
                    }
                }

                // Actualizar el label de tiempo
                
                HorasTiempo.setText(String.format("%2d", horas));
                MinutosTiempo.setText(String.format("%2d", minutos));
                SegundosTiempo.setText(String.format("%02d", segundos));
            }
        });     
             
    }

    /**
     * Método para inicializar la matriz de botones y enlazarlos con los botones del formulario.
     */
    private void inicializarBotones() {
        botones = new JButton[10][10]; // Creamos la matriz de 10x10

        // Asignación de cada botón de la matriz a su posición correspondiente
        botones[0][0] = Boton0_0;
        botones[0][1] = Boton0_1;
        botones[0][2] = Boton0_2;
        botones[0][3] = Boton0_3;
        botones[0][4] = Boton0_4;
        botones[0][5] = Boton0_5;
        botones[0][6] = Boton0_6;
        botones[0][7] = Boton0_7;
        botones[0][8] = Boton0_8;
        botones[0][9] = Boton0_9;

        botones[1][0] = Boton1_0;
        botones[1][1] = Boton1_1;
        botones[1][2] = Boton1_2;
        botones[1][3] = Boton1_3;
        botones[1][4] = Boton1_4;
        botones[1][5] = Boton1_5;
        botones[1][6] = Boton1_6;
        botones[1][7] = Boton1_7;
        botones[1][8] = Boton1_8;
        botones[1][9] = Boton1_9;
        
        botones[2][0] = Boton2_0;
        botones[2][1] = Boton2_1;
        botones[2][2] = Boton2_2;
        botones[2][3] = Boton2_3;
        botones[2][4] = Boton2_4;
        botones[2][5] = Boton2_5;
        botones[2][6] = Boton2_6;
        botones[2][7] = Boton2_7;
        botones[2][8] = Boton2_8;
        botones[2][9] = Boton2_9;
        
        botones[3][0] = Boton3_0;
        botones[3][1] = Boton3_1;
        botones[3][2] = Boton3_2;
        botones[3][3] = Boton3_3;
        botones[3][4] = Boton3_4;
        botones[3][5] = Boton3_5;
        botones[3][6] = Boton3_6;
        botones[3][7] = Boton3_7;
        botones[3][8] = Boton3_8;
        botones[3][9] = Boton3_9;
        
        botones[4][0] = Boton4_0;
        botones[4][1] = Boton4_1;
        botones[4][2] = Boton4_2;
        botones[4][3] = Boton4_3;
        botones[4][4] = Boton4_4;
        botones[4][5] = Boton4_5;
        botones[4][6] = Boton4_6;
        botones[4][7] = Boton4_7;
        botones[4][8] = Boton4_8;
        botones[4][9] = Boton4_9;
        
        botones[5][0] = Boton5_0;
        botones[5][1] = Boton5_1;
        botones[5][2] = Boton5_2;
        botones[5][3] = Boton5_3;
        botones[5][4] = Boton5_4;
        botones[5][5] = Boton5_5;
        botones[5][6] = Boton5_6;
        botones[5][7] = Boton5_7;
        botones[5][8] = Boton5_8;
        botones[5][9] = Boton5_9;
        
        botones[6][0] = Boton6_0;
        botones[6][1] = Boton6_1;
        botones[6][2] = Boton6_2;
        botones[6][3] = Boton6_3;
        botones[6][4] = Boton6_4;
        botones[6][5] = Boton6_5;
        botones[6][6] = Boton6_6;
        botones[6][7] = Boton6_7;
        botones[6][8] = Boton6_8;
        botones[6][9] = Boton6_9;
        
        botones[7][0] = Boton7_0;
        botones[7][1] = Boton7_1;
        botones[7][2] = Boton7_2;
        botones[7][3] = Boton7_3;
        botones[7][4] = Boton7_4;
        botones[7][5] = Boton7_5;
        botones[7][6] = Boton7_6;
        botones[7][7] = Boton7_7;
        botones[7][8] = Boton7_8;
        botones[7][9] = Boton7_9;
        
        botones[8][0] = Boton8_0;
        botones[8][1] = Boton8_1;
        botones[8][2] = Boton8_2;
        botones[8][3] = Boton8_3;
        botones[8][4] = Boton8_4;
        botones[8][5] = Boton8_5;
        botones[8][6] = Boton8_6;
        botones[8][7] = Boton8_7;
        botones[8][8] = Boton8_8;
        botones[8][9] = Boton8_9;
        
        botones[9][0] = Boton9_0;
        botones[9][1] = Boton9_1;
        botones[9][2] = Boton9_2;
        botones[9][3] = Boton9_3;
        botones[9][4] = Boton9_4;
        botones[9][5] = Boton9_5;
        botones[9][6] = Boton9_6;
        botones[9][7] = Boton9_7;
        botones[9][8] = Boton9_8;
        botones[9][9] = Boton9_9;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Boton0_0 = new javax.swing.JButton();
        Boton0_1 = new javax.swing.JButton();
        Boton0_2 = new javax.swing.JButton();
        Boton0_3 = new javax.swing.JButton();
        Boton0_4 = new javax.swing.JButton();
        Boton0_5 = new javax.swing.JButton();
        Boton0_6 = new javax.swing.JButton();
        Boton0_7 = new javax.swing.JButton();
        Boton0_8 = new javax.swing.JButton();
        Boton0_9 = new javax.swing.JButton();
        Boton1_0 = new javax.swing.JButton();
        Boton1_1 = new javax.swing.JButton();
        Boton1_2 = new javax.swing.JButton();
        Boton1_3 = new javax.swing.JButton();
        Boton1_4 = new javax.swing.JButton();
        Boton1_5 = new javax.swing.JButton();
        Boton1_6 = new javax.swing.JButton();
        Boton1_7 = new javax.swing.JButton();
        Boton1_8 = new javax.swing.JButton();
        Boton1_9 = new javax.swing.JButton();
        Boton2_0 = new javax.swing.JButton();
        Boton2_1 = new javax.swing.JButton();
        Boton2_2 = new javax.swing.JButton();
        Boton2_3 = new javax.swing.JButton();
        Boton2_4 = new javax.swing.JButton();
        Boton2_5 = new javax.swing.JButton();
        Boton2_6 = new javax.swing.JButton();
        Boton2_7 = new javax.swing.JButton();
        Boton2_8 = new javax.swing.JButton();
        Boton2_9 = new javax.swing.JButton();
        Boton1 = new javax.swing.JButton();
        Boton2 = new javax.swing.JButton();
        Boton3 = new javax.swing.JButton();
        Boton3_0 = new javax.swing.JButton();
        Boton3_1 = new javax.swing.JButton();
        Boton3_2 = new javax.swing.JButton();
        Boton3_3 = new javax.swing.JButton();
        Boton3_4 = new javax.swing.JButton();
        Boton3_5 = new javax.swing.JButton();
        Boton3_6 = new javax.swing.JButton();
        Boton3_7 = new javax.swing.JButton();
        Boton3_8 = new javax.swing.JButton();
        Boton3_9 = new javax.swing.JButton();
        Boton4_0 = new javax.swing.JButton();
        Boton4_1 = new javax.swing.JButton();
        Boton4_2 = new javax.swing.JButton();
        Boton4_3 = new javax.swing.JButton();
        Boton4_4 = new javax.swing.JButton();
        Boton4_5 = new javax.swing.JButton();
        Boton4_6 = new javax.swing.JButton();
        Boton4_7 = new javax.swing.JButton();
        Boton4_8 = new javax.swing.JButton();
        Boton4_9 = new javax.swing.JButton();
        Boton5_0 = new javax.swing.JButton();
        Boton5_1 = new javax.swing.JButton();
        Boton5_2 = new javax.swing.JButton();
        Boton5_3 = new javax.swing.JButton();
        Boton5_4 = new javax.swing.JButton();
        Boton5_5 = new javax.swing.JButton();
        Boton5_6 = new javax.swing.JButton();
        Boton5_7 = new javax.swing.JButton();
        Boton5_8 = new javax.swing.JButton();
        Boton5_9 = new javax.swing.JButton();
        Boton6_0 = new javax.swing.JButton();
        Boton6_1 = new javax.swing.JButton();
        Boton6_2 = new javax.swing.JButton();
        Boton6_3 = new javax.swing.JButton();
        Boton6_4 = new javax.swing.JButton();
        Boton6_5 = new javax.swing.JButton();
        Boton6_6 = new javax.swing.JButton();
        Boton6_7 = new javax.swing.JButton();
        Boton6_8 = new javax.swing.JButton();
        Boton6_9 = new javax.swing.JButton();
        Boton7_0 = new javax.swing.JButton();
        Boton8_0 = new javax.swing.JButton();
        Boton9_0 = new javax.swing.JButton();
        Texto0_0 = new javax.swing.JLabel();
        Texto0_1 = new javax.swing.JLabel();
        Texto0_2 = new javax.swing.JLabel();
        Texto0_3 = new javax.swing.JLabel();
        Texto0_4 = new javax.swing.JLabel();
        Texto0_5 = new javax.swing.JLabel();
        Texto0_6 = new javax.swing.JLabel();
        Texto0_7 = new javax.swing.JLabel();
        Texto0_8 = new javax.swing.JLabel();
        Texto1_0 = new javax.swing.JLabel();
        Texto1_1 = new javax.swing.JLabel();
        Texto1_2 = new javax.swing.JLabel();
        Texto1_3 = new javax.swing.JLabel();
        Texto1_4 = new javax.swing.JLabel();
        Texto1_5 = new javax.swing.JLabel();
        Texto1_6 = new javax.swing.JLabel();
        Texto1_7 = new javax.swing.JLabel();
        Texto1_8 = new javax.swing.JLabel();
        Texto1_9 = new javax.swing.JLabel();
        Texto2_0 = new javax.swing.JLabel();
        Texto2_1 = new javax.swing.JLabel();
        Texto2_2 = new javax.swing.JLabel();
        Texto2_3 = new javax.swing.JLabel();
        Texto2_4 = new javax.swing.JLabel();
        Texto2_5 = new javax.swing.JLabel();
        Texto2_6 = new javax.swing.JLabel();
        Texto2_7 = new javax.swing.JLabel();
        Texto2_8 = new javax.swing.JLabel();
        Texto3_0 = new javax.swing.JLabel();
        Texto3_1 = new javax.swing.JLabel();
        Texto3_2 = new javax.swing.JLabel();
        Texto3_3 = new javax.swing.JLabel();
        Texto3_4 = new javax.swing.JLabel();
        Texto3_5 = new javax.swing.JLabel();
        Texto3_6 = new javax.swing.JLabel();
        Texto3_7 = new javax.swing.JLabel();
        Texto3_8 = new javax.swing.JLabel();
        Texto3_9 = new javax.swing.JLabel();
        Texto4_0 = new javax.swing.JLabel();
        Texto4_1 = new javax.swing.JLabel();
        Texto4_2 = new javax.swing.JLabel();
        Texto4_3 = new javax.swing.JLabel();
        Texto4_4 = new javax.swing.JLabel();
        Texto4_5 = new javax.swing.JLabel();
        Texto4_6 = new javax.swing.JLabel();
        Texto4_7 = new javax.swing.JLabel();
        Texto4_8 = new javax.swing.JLabel();
        Texto5_0 = new javax.swing.JLabel();
        Texto5_1 = new javax.swing.JLabel();
        Texto5_2 = new javax.swing.JLabel();
        Texto5_3 = new javax.swing.JLabel();
        Texto5_4 = new javax.swing.JLabel();
        Texto5_5 = new javax.swing.JLabel();
        Texto5_6 = new javax.swing.JLabel();
        Texto5_7 = new javax.swing.JLabel();
        Texto5_8 = new javax.swing.JLabel();
        Texto5_9 = new javax.swing.JLabel();
        Texto6_0 = new javax.swing.JLabel();
        Texto6_1 = new javax.swing.JLabel();
        Texto6_2 = new javax.swing.JLabel();
        Texto6_3 = new javax.swing.JLabel();
        Texto6_4 = new javax.swing.JLabel();
        Texto6_5 = new javax.swing.JLabel();
        Texto6_6 = new javax.swing.JLabel();
        Texto6_7 = new javax.swing.JLabel();
        Texto6_8 = new javax.swing.JLabel();
        Texto7_0 = new javax.swing.JLabel();
        Texto7_1 = new javax.swing.JLabel();
        Texto7_2 = new javax.swing.JLabel();
        Texto7_3 = new javax.swing.JLabel();
        Texto7_4 = new javax.swing.JLabel();
        Texto7_5 = new javax.swing.JLabel();
        Texto7_6 = new javax.swing.JLabel();
        Texto7_7 = new javax.swing.JLabel();
        Texto7_8 = new javax.swing.JLabel();
        Texto7_9 = new javax.swing.JLabel();
        Texto9_0 = new javax.swing.JLabel();
        Texto9_1 = new javax.swing.JLabel();
        Texto9_2 = new javax.swing.JLabel();
        Texto9_3 = new javax.swing.JLabel();
        Texto9_4 = new javax.swing.JLabel();
        Texto9_5 = new javax.swing.JLabel();
        Texto9_6 = new javax.swing.JLabel();
        Texto9_7 = new javax.swing.JLabel();
        Texto9_8 = new javax.swing.JLabel();
        Texto9_9 = new javax.swing.JLabel();
        Boton7_1 = new javax.swing.JButton();
        Boton7_2 = new javax.swing.JButton();
        Boton7_3 = new javax.swing.JButton();
        Boton7_4 = new javax.swing.JButton();
        Boton7_5 = new javax.swing.JButton();
        Boton7_6 = new javax.swing.JButton();
        Boton7_7 = new javax.swing.JButton();
        Boton7_8 = new javax.swing.JButton();
        Boton7_9 = new javax.swing.JButton();
        Boton8_1 = new javax.swing.JButton();
        Boton8_2 = new javax.swing.JButton();
        Boton8_3 = new javax.swing.JButton();
        Boton8_4 = new javax.swing.JButton();
        Boton8_5 = new javax.swing.JButton();
        Boton8_6 = new javax.swing.JButton();
        Boton8_7 = new javax.swing.JButton();
        Boton8_8 = new javax.swing.JButton();
        Boton8_9 = new javax.swing.JButton();
        Boton9_1 = new javax.swing.JButton();
        Boton9_2 = new javax.swing.JButton();
        Boton9_3 = new javax.swing.JButton();
        Boton9_4 = new javax.swing.JButton();
        Boton9_5 = new javax.swing.JButton();
        Boton9_6 = new javax.swing.JButton();
        Boton9_7 = new javax.swing.JButton();
        Boton9_8 = new javax.swing.JButton();
        Boton9_9 = new javax.swing.JButton();
        Texto11_0 = new javax.swing.JLabel();
        Texto11_1 = new javax.swing.JLabel();
        Texto11_2 = new javax.swing.JLabel();
        Texto11_3 = new javax.swing.JLabel();
        Texto11_4 = new javax.swing.JLabel();
        Texto11_5 = new javax.swing.JLabel();
        Texto11_6 = new javax.swing.JLabel();
        Texto11_7 = new javax.swing.JLabel();
        Texto11_8 = new javax.swing.JLabel();
        Texto11_9 = new javax.swing.JLabel();
        Boton4 = new javax.swing.JButton();
        Boton5 = new javax.swing.JButton();
        Boton6 = new javax.swing.JButton();
        Boton7 = new javax.swing.JButton();
        Texto13_0 = new javax.swing.JLabel();
        Texto13_1 = new javax.swing.JLabel();
        Texto13_2 = new javax.swing.JLabel();
        Texto13_3 = new javax.swing.JLabel();
        Texto13_4 = new javax.swing.JLabel();
        Texto13_5 = new javax.swing.JLabel();
        Texto13_6 = new javax.swing.JLabel();
        Texto13_7 = new javax.swing.JLabel();
        Texto13_8 = new javax.swing.JLabel();
        Texto13_9 = new javax.swing.JLabel();
        Texto8_0 = new javax.swing.JLabel();
        Texto8_1 = new javax.swing.JLabel();
        Texto8_2 = new javax.swing.JLabel();
        Texto8_3 = new javax.swing.JLabel();
        Texto8_4 = new javax.swing.JLabel();
        Texto8_5 = new javax.swing.JLabel();
        Texto8_6 = new javax.swing.JLabel();
        Texto8_7 = new javax.swing.JLabel();
        Texto8_8 = new javax.swing.JLabel();
        Texto10_0 = new javax.swing.JLabel();
        Texto10_1 = new javax.swing.JLabel();
        Texto10_2 = new javax.swing.JLabel();
        Texto10_3 = new javax.swing.JLabel();
        Texto10_4 = new javax.swing.JLabel();
        Texto10_5 = new javax.swing.JLabel();
        Texto10_6 = new javax.swing.JLabel();
        Texto10_7 = new javax.swing.JLabel();
        Texto10_8 = new javax.swing.JLabel();
        Texto12_0 = new javax.swing.JLabel();
        Texto12_1 = new javax.swing.JLabel();
        Texto12_2 = new javax.swing.JLabel();
        Texto12_3 = new javax.swing.JLabel();
        Texto12_4 = new javax.swing.JLabel();
        Texto12_5 = new javax.swing.JLabel();
        Texto12_6 = new javax.swing.JLabel();
        Texto12_7 = new javax.swing.JLabel();
        Texto12_8 = new javax.swing.JLabel();
        Texto14_0 = new javax.swing.JLabel();
        Texto14_1 = new javax.swing.JLabel();
        Texto14_2 = new javax.swing.JLabel();
        Texto14_3 = new javax.swing.JLabel();
        Texto14_4 = new javax.swing.JLabel();
        Texto14_5 = new javax.swing.JLabel();
        Texto14_6 = new javax.swing.JLabel();
        Texto14_7 = new javax.swing.JLabel();
        Texto14_8 = new javax.swing.JLabel();
        Texto15_0 = new javax.swing.JLabel();
        Texto15_1 = new javax.swing.JLabel();
        Texto15_2 = new javax.swing.JLabel();
        Texto15_3 = new javax.swing.JLabel();
        Texto15_4 = new javax.swing.JLabel();
        Texto15_5 = new javax.swing.JLabel();
        Texto15_6 = new javax.swing.JLabel();
        Texto15_7 = new javax.swing.JLabel();
        Texto15_8 = new javax.swing.JLabel();
        Texto15_9 = new javax.swing.JLabel();
        Texto16_0 = new javax.swing.JLabel();
        Texto16_1 = new javax.swing.JLabel();
        Texto16_2 = new javax.swing.JLabel();
        Texto16_3 = new javax.swing.JLabel();
        Texto16_4 = new javax.swing.JLabel();
        Texto16_5 = new javax.swing.JLabel();
        Texto16_6 = new javax.swing.JLabel();
        Texto16_7 = new javax.swing.JLabel();
        Texto16_8 = new javax.swing.JLabel();
        Texto18_0 = new javax.swing.JLabel();
        Texto18_1 = new javax.swing.JLabel();
        Texto18_2 = new javax.swing.JLabel();
        Texto18_3 = new javax.swing.JLabel();
        Texto18_4 = new javax.swing.JLabel();
        Texto18_5 = new javax.swing.JLabel();
        Texto18_6 = new javax.swing.JLabel();
        Texto18_7 = new javax.swing.JLabel();
        Texto18_8 = new javax.swing.JLabel();
        Texto17_00 = new javax.swing.JLabel();
        Texto17_1 = new javax.swing.JLabel();
        Texto17_2 = new javax.swing.JLabel();
        Texto17_3 = new javax.swing.JLabel();
        Texto17_4 = new javax.swing.JLabel();
        Texto17_5 = new javax.swing.JLabel();
        Texto17_6 = new javax.swing.JLabel();
        Texto17_7 = new javax.swing.JLabel();
        Texto17_8 = new javax.swing.JLabel();
        Texto17_9 = new javax.swing.JLabel();
        Boton9 = new javax.swing.JButton();
        Boton10 = new javax.swing.JButton();
        Boton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonIniciarJuego = new javax.swing.JButton();
        BotonBorrarJugada = new javax.swing.JButton();
        BotonBorrarJuego = new javax.swing.JButton();
        BotonGuardarJuego = new javax.swing.JButton();
        BotonRehacerJugada = new javax.swing.JButton();
        BotonCargarJuego = new javax.swing.JButton();
        BotonTerminarJuego = new javax.swing.JButton();
        Horatexto = new javax.swing.JTextField();
        MinutosTexto = new javax.swing.JTextField();
        SegundosTexto = new javax.swing.JTextField();
        HorasTiempo = new javax.swing.JTextField();
        MinutosTiempo = new javax.swing.JTextField();
        SegundosTiempo = new javax.swing.JTextField();
        BorrarBoton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        NombreJugador = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Boton0_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_0ActionPerformed(evt);
            }
        });

        Boton0_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_1ActionPerformed(evt);
            }
        });

        Boton0_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_2ActionPerformed(evt);
            }
        });

        Boton0_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_3ActionPerformed(evt);
            }
        });

        Boton0_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_4ActionPerformed(evt);
            }
        });

        Boton0_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_5ActionPerformed(evt);
            }
        });

        Boton0_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_6ActionPerformed(evt);
            }
        });

        Boton0_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_7ActionPerformed(evt);
            }
        });

        Boton0_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_8ActionPerformed(evt);
            }
        });

        Boton0_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_9ActionPerformed(evt);
            }
        });

        Boton1_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_0ActionPerformed(evt);
            }
        });

        Boton1_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_1ActionPerformed(evt);
            }
        });

        Boton1_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_2ActionPerformed(evt);
            }
        });

        Boton1_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_3ActionPerformed(evt);
            }
        });

        Boton1_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_4ActionPerformed(evt);
            }
        });

        Boton1_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_5ActionPerformed(evt);
            }
        });

        Boton1_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_6ActionPerformed(evt);
            }
        });

        Boton1_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_7ActionPerformed(evt);
            }
        });

        Boton1_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_8ActionPerformed(evt);
            }
        });

        Boton1_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_9ActionPerformed(evt);
            }
        });

        Boton2_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_0ActionPerformed(evt);
            }
        });

        Boton2_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_1ActionPerformed(evt);
            }
        });

        Boton2_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_2ActionPerformed(evt);
            }
        });

        Boton2_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_3ActionPerformed(evt);
            }
        });

        Boton2_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_4ActionPerformed(evt);
            }
        });

        Boton2_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_5ActionPerformed(evt);
            }
        });

        Boton2_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_6ActionPerformed(evt);
            }
        });

        Boton2_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_7ActionPerformed(evt);
            }
        });

        Boton2_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_8ActionPerformed(evt);
            }
        });

        Boton2_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_9ActionPerformed(evt);
            }
        });

        Boton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton1.setText("(1)");
        Boton1.setAlignmentY(0.0F);
        Boton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });

        Boton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton2.setText("(2)");
        Boton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2ActionPerformed(evt);
            }
        });

        Boton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton3.setText("(3)");
        Boton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3ActionPerformed(evt);
            }
        });

        Boton3_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_0ActionPerformed(evt);
            }
        });

        Boton3_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_1ActionPerformed(evt);
            }
        });

        Boton3_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_2ActionPerformed(evt);
            }
        });

        Boton3_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_3ActionPerformed(evt);
            }
        });

        Boton3_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_4ActionPerformed(evt);
            }
        });

        Boton3_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_5ActionPerformed(evt);
            }
        });

        Boton3_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_6ActionPerformed(evt);
            }
        });

        Boton3_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_7ActionPerformed(evt);
            }
        });

        Boton3_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_8ActionPerformed(evt);
            }
        });

        Boton3_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_9ActionPerformed(evt);
            }
        });

        Boton4_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_0ActionPerformed(evt);
            }
        });

        Boton4_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_1ActionPerformed(evt);
            }
        });

        Boton4_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_2ActionPerformed(evt);
            }
        });

        Boton4_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_3ActionPerformed(evt);
            }
        });

        Boton4_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_4ActionPerformed(evt);
            }
        });

        Boton4_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_5ActionPerformed(evt);
            }
        });

        Boton4_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_6ActionPerformed(evt);
            }
        });

        Boton4_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_7ActionPerformed(evt);
            }
        });

        Boton4_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_8ActionPerformed(evt);
            }
        });

        Boton4_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_9ActionPerformed(evt);
            }
        });

        Boton5_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_0ActionPerformed(evt);
            }
        });

        Boton5_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_1ActionPerformed(evt);
            }
        });

        Boton5_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_2ActionPerformed(evt);
            }
        });

        Boton5_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_3ActionPerformed(evt);
            }
        });

        Boton5_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_4ActionPerformed(evt);
            }
        });

        Boton5_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_5ActionPerformed(evt);
            }
        });

        Boton5_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_6ActionPerformed(evt);
            }
        });

        Boton5_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_7ActionPerformed(evt);
            }
        });

        Boton5_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_8ActionPerformed(evt);
            }
        });

        Boton5_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_9ActionPerformed(evt);
            }
        });

        Boton6_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_0ActionPerformed(evt);
            }
        });

        Boton6_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_1ActionPerformed(evt);
            }
        });

        Boton6_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_2ActionPerformed(evt);
            }
        });

        Boton6_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_3ActionPerformed(evt);
            }
        });

        Boton6_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_4ActionPerformed(evt);
            }
        });

        Boton6_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_5ActionPerformed(evt);
            }
        });

        Boton6_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_6ActionPerformed(evt);
            }
        });

        Boton6_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_7ActionPerformed(evt);
            }
        });

        Boton6_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_8ActionPerformed(evt);
            }
        });

        Boton6_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_9ActionPerformed(evt);
            }
        });

        Boton7_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_0ActionPerformed(evt);
            }
        });

        Boton8_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_0ActionPerformed(evt);
            }
        });

        Boton9_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_0ActionPerformed(evt);
            }
        });

        Texto0_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_0.setText(">");

        Texto0_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_1.setText(">");

        Texto0_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_2.setText(">");

        Texto0_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_3.setText(">");

        Texto0_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_4.setText(">");

        Texto0_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_5.setText(">");

        Texto0_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_6.setText(">");

        Texto0_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_7.setText(">");

        Texto0_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_8.setText(">");

        Texto1_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_0.setText(" ^");
        Texto1_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_1.setText(" ^");
        Texto1_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_2.setText(" ^");
        Texto1_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_3.setText(" ^");
        Texto1_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_4.setText(" ^");
        Texto1_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_5.setText(" ^");
        Texto1_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_6.setText(" ^");
        Texto1_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_7.setText(" ^");
        Texto1_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_8.setText(" ^");
        Texto1_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto1_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_9.setText(" ^");
        Texto1_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto2_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_0.setText(">");

        Texto2_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_1.setText(">");

        Texto2_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_2.setText(">");

        Texto2_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_3.setText(">");

        Texto2_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_4.setText(">");

        Texto2_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_5.setText(">");

        Texto2_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_6.setText(">");

        Texto2_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_7.setText(">");

        Texto2_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_8.setText(">");

        Texto3_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_0.setText(" ^");
        Texto3_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_1.setText(" ^");
        Texto3_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_2.setText(" ^");
        Texto3_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_3.setText(" ^");
        Texto3_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_4.setText(" ^");
        Texto3_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_5.setText(" ^");
        Texto3_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_6.setText(" ^");
        Texto3_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_7.setText(" ^");
        Texto3_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_8.setText(" ^");
        Texto3_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto3_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_9.setText(" ^");
        Texto3_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto4_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_0.setText(">");

        Texto4_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_1.setText(">");

        Texto4_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_2.setText(">");

        Texto4_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_3.setText(">");

        Texto4_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_4.setText(">");

        Texto4_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_5.setText(">");

        Texto4_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_6.setText(">");

        Texto4_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_7.setText(">");

        Texto4_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_8.setText(">");

        Texto5_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_0.setText(" ^");
        Texto5_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_1.setText(" ^");
        Texto5_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_2.setText(" ^");
        Texto5_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_3.setText(" ^");
        Texto5_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_4.setText(" ^");
        Texto5_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_5.setText(" ^");
        Texto5_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_6.setText(" ^");
        Texto5_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_7.setText(" ^");
        Texto5_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_8.setText(" ^");
        Texto5_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto5_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_9.setText(" ^");
        Texto5_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto6_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_0.setText(">");

        Texto6_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_1.setText(">");

        Texto6_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_2.setText(">");

        Texto6_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_3.setText(">");

        Texto6_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_4.setText(">");

        Texto6_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_5.setText(">");

        Texto6_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_6.setText(">");

        Texto6_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_7.setText(">");

        Texto6_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_8.setText(">");

        Texto7_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_0.setText(" ^");
        Texto7_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_1.setText(" ^");
        Texto7_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_2.setText(" ^");
        Texto7_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_3.setText(" ^");
        Texto7_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_4.setText(" ^");
        Texto7_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_5.setText(" ^");
        Texto7_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_6.setText(" ^");
        Texto7_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_7.setText(" ^");
        Texto7_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_8.setText(" ^");
        Texto7_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto7_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_9.setText(" ^");
        Texto7_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_0.setText(" ^");
        Texto9_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_1.setText(" ^");
        Texto9_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_2.setText(" ^");
        Texto9_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_3.setText(" ^");
        Texto9_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_4.setText(" ^");
        Texto9_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_5.setText(" ^");
        Texto9_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_6.setText(" ^");
        Texto9_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_7.setText(" ^");
        Texto9_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_8.setText(" ^");
        Texto9_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto9_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_9.setText(" ^");
        Texto9_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Boton7_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_1ActionPerformed(evt);
            }
        });

        Boton7_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_2ActionPerformed(evt);
            }
        });

        Boton7_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_3ActionPerformed(evt);
            }
        });

        Boton7_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_4ActionPerformed(evt);
            }
        });

        Boton7_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_5ActionPerformed(evt);
            }
        });

        Boton7_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_6ActionPerformed(evt);
            }
        });

        Boton7_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_7ActionPerformed(evt);
            }
        });

        Boton7_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_8ActionPerformed(evt);
            }
        });

        Boton7_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_9ActionPerformed(evt);
            }
        });

        Boton8_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_1ActionPerformed(evt);
            }
        });

        Boton8_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_2ActionPerformed(evt);
            }
        });

        Boton8_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_3ActionPerformed(evt);
            }
        });

        Boton8_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_4ActionPerformed(evt);
            }
        });

        Boton8_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_5ActionPerformed(evt);
            }
        });

        Boton8_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_6ActionPerformed(evt);
            }
        });

        Boton8_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_7ActionPerformed(evt);
            }
        });

        Boton8_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_8ActionPerformed(evt);
            }
        });

        Boton8_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton8_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8_9ActionPerformed(evt);
            }
        });

        Boton9_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_1ActionPerformed(evt);
            }
        });

        Boton9_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_2ActionPerformed(evt);
            }
        });

        Boton9_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_3ActionPerformed(evt);
            }
        });

        Boton9_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_4ActionPerformed(evt);
            }
        });

        Boton9_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_5ActionPerformed(evt);
            }
        });

        Boton9_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_6ActionPerformed(evt);
            }
        });

        Boton9_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_7ActionPerformed(evt);
            }
        });

        Boton9_8.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_8ActionPerformed(evt);
            }
        });

        Boton9_9.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton9_9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9_9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9_9ActionPerformed(evt);
            }
        });

        Texto11_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_0.setText(" ^");
        Texto11_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_1.setText(" ^");
        Texto11_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_2.setText(" ^");
        Texto11_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_3.setText(" ^");
        Texto11_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_4.setText(" ^");
        Texto11_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_5.setText(" ^");
        Texto11_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_6.setText(" ^");
        Texto11_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_7.setText(" ^");
        Texto11_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_8.setText(" ^");
        Texto11_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto11_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_9.setText(" ^");
        Texto11_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Boton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton4.setText("(4)");
        Boton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4ActionPerformed(evt);
            }
        });

        Boton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton5.setText("(5)");
        Boton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5ActionPerformed(evt);
            }
        });

        Boton6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton6.setText("(6)");
        Boton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6ActionPerformed(evt);
            }
        });

        Boton7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton7.setText("(7)");
        Boton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7ActionPerformed(evt);
            }
        });

        Texto13_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_0.setText(" ^");
        Texto13_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_1.setText(" ^");
        Texto13_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_2.setText(" ^");
        Texto13_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_3.setText(" ^");
        Texto13_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_4.setText(" ^");
        Texto13_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_5.setText(" ^");
        Texto13_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_6.setText(" ^");
        Texto13_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_7.setText(" ^");
        Texto13_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_8.setText(" ^");
        Texto13_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto13_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_9.setText(" ^");
        Texto13_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto8_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_0.setText(">");

        Texto8_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_1.setText(">");

        Texto8_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_2.setText(">");

        Texto8_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_3.setText(">");

        Texto8_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_4.setText(">");

        Texto8_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_5.setText(">");

        Texto8_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_6.setText(">");

        Texto8_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_7.setText(">");

        Texto8_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_8.setText(">");

        Texto10_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_0.setText(">");

        Texto10_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_1.setText(">");

        Texto10_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_2.setText(">");

        Texto10_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_3.setText(">");

        Texto10_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_4.setText(">");

        Texto10_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_5.setText(">");

        Texto10_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_6.setText(">");

        Texto10_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_7.setText(">");

        Texto10_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_8.setText(">");

        Texto12_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_0.setText(">");

        Texto12_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_1.setText(">");

        Texto12_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_2.setText(">");

        Texto12_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_3.setText(">");

        Texto12_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_4.setText(">");

        Texto12_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_5.setText(">");

        Texto12_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_6.setText(">");

        Texto12_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_7.setText(">");

        Texto12_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_8.setText(">");

        Texto14_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_0.setText(">");

        Texto14_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_1.setText(">");

        Texto14_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_2.setText(">");

        Texto14_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_3.setText(">");

        Texto14_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_4.setText(">");

        Texto14_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_5.setText(">");

        Texto14_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_6.setText(">");

        Texto14_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_7.setText(">");

        Texto14_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_8.setText(">");

        Texto15_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_0.setText(" ^");
        Texto15_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_1.setText(" ^");
        Texto15_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_2.setText(" ^");
        Texto15_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_3.setText(" ^");
        Texto15_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_4.setText(" ^");
        Texto15_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_5.setText(" ^");
        Texto15_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_6.setText(" ^");
        Texto15_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_7.setText(" ^");
        Texto15_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_8.setText(" ^");
        Texto15_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto15_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto15_9.setText(" ^");
        Texto15_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto16_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_0.setText(">");

        Texto16_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_1.setText(">");

        Texto16_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_2.setText(">");

        Texto16_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_3.setText(">");

        Texto16_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_4.setText(">");

        Texto16_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_5.setText(">");

        Texto16_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_6.setText(">");

        Texto16_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_7.setText(">");

        Texto16_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto16_8.setText(">");

        Texto18_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_0.setText(">");

        Texto18_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_1.setText(">");

        Texto18_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_2.setText(">");

        Texto18_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_3.setText(">");

        Texto18_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_4.setText(">");

        Texto18_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_5.setText(">");

        Texto18_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_6.setText(">");

        Texto18_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_7.setText(">");

        Texto18_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto18_8.setText(">");

        Texto17_00.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_00.setText(" ^");
        Texto17_00.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_1.setText(" ^");
        Texto17_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_2.setText(" ^");
        Texto17_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_3.setText(" ^");
        Texto17_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_4.setText(" ^");
        Texto17_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_5.setText(" ^");
        Texto17_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_6.setText(" ^");
        Texto17_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_7.setText(" ^");
        Texto17_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_8.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_8.setText(" ^");
        Texto17_8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Texto17_9.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto17_9.setText(" ^");
        Texto17_9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Boton9.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton9.setText("(9)");
        Boton9.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton9ActionPerformed(evt);
            }
        });

        Boton10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Boton10.setText("(10)");
        Boton10.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton10ActionPerformed(evt);
            }
        });

        Boton8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton8.setText("(8)");
        Boton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("FUTOSHIKI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(116, 116, 116))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
        );

        BotonIniciarJuego.setBackground(new java.awt.Color(255, 51, 51));
        BotonIniciarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonIniciarJuego.setText("INICIAR JUEGO");
        BotonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarJuegoActionPerformed(evt);
            }
        });

        BotonBorrarJugada.setBackground(new java.awt.Color(0, 204, 204));
        BotonBorrarJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJugada.setText("BORRAR JUGADA");
        BotonBorrarJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));

        BotonBorrarJuego.setBackground(new java.awt.Color(153, 153, 255));
        BotonBorrarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJuego.setText("BORRAR JUEGO");

        BotonGuardarJuego.setBackground(new java.awt.Color(51, 153, 0));
        BotonGuardarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonGuardarJuego.setText("GUARDAR JUEGO");
        BotonGuardarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));

        BotonRehacerJugada.setBackground(new java.awt.Color(255, 204, 51));
        BotonRehacerJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonRehacerJugada.setText("REHACER JUGADA");
        BotonRehacerJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));

        BotonCargarJuego.setBackground(new java.awt.Color(153, 51, 0));
        BotonCargarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonCargarJuego.setText("CARGAR JUEGO");
        BotonCargarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonCargarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarJuegoActionPerformed(evt);
            }
        });

        BotonTerminarJuego.setBackground(new java.awt.Color(255, 204, 51));
        BotonTerminarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonTerminarJuego.setText("TERMINAR JUEGO");
        BotonTerminarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));

        Horatexto.setText("Horas");

        MinutosTexto.setText("Minutos");

        SegundosTexto.setText("Segundos");

        HorasTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        HorasTiempo.setText("0");

        MinutosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinutosTiempo.setText("0");
        MinutosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinutosTiempoActionPerformed(evt);
            }
        });

        SegundosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SegundosTiempo.setText("0");
        SegundosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegundosTiempoActionPerformed(evt);
            }
        });

        BorrarBoton.setText("Borrar");
        BorrarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarBotonActionPerformed(evt);
            }
        });

        jLabel2.setText("JUGADOR:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Texto5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Texto5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Texto5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Texto7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Texto7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(Texto7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Texto13_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Texto13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(Texto13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Texto15_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(Texto15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(Texto15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(Texto15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Boton0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_0)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_1)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_2)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(Texto0_3))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(NombreJugador, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Boton0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_4)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_5)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(Texto0_6)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(Texto0_7)
                                        .addGap(6, 6, 6)
                                        .addComponent(Boton0_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addComponent(Texto0_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton0_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_1)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_3)
                                .addGap(7, 7, 7)
                                .addComponent(Boton1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto2_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto2_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_1)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_3)
                                .addGap(7, 7, 7)
                                .addComponent(Boton2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto4_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto4_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton2_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_1)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto6_3)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto6_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto6_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_1)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto8_3)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Texto8_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto8_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(Texto9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Texto9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_1)
                                .addGap(1, 1, 1)
                                .addComponent(Boton5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_3)
                                .addGap(13, 13, 13)
                                .addComponent(Boton5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto10_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto11_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(Texto11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Texto11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto11_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_1)
                                .addGap(1, 1, 1)
                                .addComponent(Boton6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_3)
                                .addGap(13, 13, 13)
                                .addComponent(Boton6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto12_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton6_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Texto1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Texto1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_1)
                                .addGap(1, 1, 1)
                                .addComponent(Boton7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_3)
                                .addGap(13, 13, 13)
                                .addComponent(Boton7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto14_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Texto3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(Texto3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton8_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_1)
                                .addGap(1, 1, 1)
                                .addComponent(Boton8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_3)
                                .addGap(13, 13, 13)
                                .addComponent(Boton8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto16_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Texto17_00, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(Texto17_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Texto17_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(Texto17_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Boton9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_0)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_1)
                                .addGap(1, 1, 1)
                                .addComponent(Boton9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_2)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(Texto18_3)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_4)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_5)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_6)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_7)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(Texto18_8)
                                .addGap(6, 6, 6)
                                .addComponent(Boton9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(Boton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(Horatexto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MinutosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(HorasTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(MinutosTiempo)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SegundosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SegundosTiempo)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(BotonBorrarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonGuardarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonBorrarJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonRehacerJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonCargarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(BotonTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(BorrarBoton)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(NombreJugador))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boton0_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto0_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton0_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(BorrarBoton)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto1_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto1_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boton1_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto2_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton1_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(BotonIniciarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto3_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto3_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Boton2_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Texto4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton2_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Boton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BotonTerminarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(Texto5_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Texto5_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto5_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Texto5_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Boton3_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto6_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton3_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonBorrarJugada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boton4_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton4_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonRehacerJugada, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BotonGuardarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boton5_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto10_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton5_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto11_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto11_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Boton6_0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Texto12_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton6_9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotonCargarJuego, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Texto13_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto13_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Boton7_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Texto14_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton7_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Boton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonBorrarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto15_0, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto15_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto15_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Texto15_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Texto15_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton8_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(Texto16_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Boton8_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto16_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton8_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Texto17_00, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto17_9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Boton9_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_0, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Texto18_8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton9_9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Boton10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Horatexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinutosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SegundosTexto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(HorasTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(MinutosTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SegundosTiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton0_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_0ActionPerformed
        PuntoX=0;
        PuntoY=0;
    }//GEN-LAST:event_Boton0_0ActionPerformed

    private void Boton0_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_1ActionPerformed
        PuntoX=0;
        PuntoY=1;
    }//GEN-LAST:event_Boton0_1ActionPerformed

    private void Boton0_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_2ActionPerformed
        PuntoX=0;
        PuntoY=2;
    }//GEN-LAST:event_Boton0_2ActionPerformed

    private void Boton0_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_3ActionPerformed
        PuntoX=0;
        PuntoY=3;
    }//GEN-LAST:event_Boton0_3ActionPerformed

    private void Boton0_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_4ActionPerformed
        PuntoX=0;
        PuntoY=4;
    }//GEN-LAST:event_Boton0_4ActionPerformed

    private void Boton0_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_5ActionPerformed
        PuntoX=0;
        PuntoY=5;
    }//GEN-LAST:event_Boton0_5ActionPerformed

    private void Boton0_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_6ActionPerformed
        PuntoX=0;
        PuntoY=6;
    }//GEN-LAST:event_Boton0_6ActionPerformed

    private void Boton0_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_7ActionPerformed
        PuntoX=0;
        PuntoY=7;
    }//GEN-LAST:event_Boton0_7ActionPerformed

    private void Boton0_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_8ActionPerformed
        PuntoX=0;
        PuntoY=8;
    }//GEN-LAST:event_Boton0_8ActionPerformed

    private void Boton0_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton0_9ActionPerformed
        PuntoX=0;
        PuntoY=9;
    }//GEN-LAST:event_Boton0_9ActionPerformed

    private void Boton1_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_0ActionPerformed
        PuntoX=1;
        PuntoY=0;
    }//GEN-LAST:event_Boton1_0ActionPerformed

    private void Boton1_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_1ActionPerformed
        PuntoX=1;
        PuntoY=1;
    }//GEN-LAST:event_Boton1_1ActionPerformed

    private void Boton1_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_2ActionPerformed
        PuntoX=1;
        PuntoY=2;
    }//GEN-LAST:event_Boton1_2ActionPerformed

    private void Boton1_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_3ActionPerformed
        PuntoX=1;
        PuntoY=3;
    }//GEN-LAST:event_Boton1_3ActionPerformed

    private void Boton1_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_4ActionPerformed
        PuntoX=1;
        PuntoY=4;
    }//GEN-LAST:event_Boton1_4ActionPerformed

    private void Boton1_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_5ActionPerformed
        PuntoX=1;
        PuntoY=5;
    }//GEN-LAST:event_Boton1_5ActionPerformed

    private void Boton1_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_6ActionPerformed
        PuntoX=1;
        PuntoY=6;
    }//GEN-LAST:event_Boton1_6ActionPerformed

    private void Boton1_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_7ActionPerformed
        PuntoX=1;
        PuntoY=7;
    }//GEN-LAST:event_Boton1_7ActionPerformed

    private void Boton1_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_8ActionPerformed
        PuntoX=1;
        PuntoY=8;
    }//GEN-LAST:event_Boton1_8ActionPerformed

    private void Boton1_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1_9ActionPerformed
        PuntoX=1;
        PuntoY=9;
    }//GEN-LAST:event_Boton1_9ActionPerformed

    private void Boton2_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_0ActionPerformed
        PuntoX=2;
        PuntoY=0;
    }//GEN-LAST:event_Boton2_0ActionPerformed

    private void Boton2_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_1ActionPerformed
        PuntoX=2;
        PuntoY=1;
    }//GEN-LAST:event_Boton2_1ActionPerformed

    private void Boton2_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_2ActionPerformed
        PuntoX=2;
        PuntoY=2;
    }//GEN-LAST:event_Boton2_2ActionPerformed

    private void Boton2_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_3ActionPerformed
        PuntoX=2;
        PuntoY=3;
    }//GEN-LAST:event_Boton2_3ActionPerformed

    private void Boton2_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_4ActionPerformed
        PuntoX=2;
        PuntoY=4;
    }//GEN-LAST:event_Boton2_4ActionPerformed

    private void Boton2_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_5ActionPerformed
        PuntoX=2;
        PuntoY=5;
    }//GEN-LAST:event_Boton2_5ActionPerformed

    private void Boton2_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_6ActionPerformed
        PuntoX=2;
        PuntoY=6;
    }//GEN-LAST:event_Boton2_6ActionPerformed

    private void Boton2_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_7ActionPerformed
        PuntoX=2;
        PuntoY=7;
    }//GEN-LAST:event_Boton2_7ActionPerformed

    private void Boton2_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_8ActionPerformed
        PuntoX=2;
        PuntoY=8;
    }//GEN-LAST:event_Boton2_8ActionPerformed

    private void Boton2_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2_9ActionPerformed
        PuntoX=2;
        PuntoY=9;
    }//GEN-LAST:event_Boton2_9ActionPerformed

    private void Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1ActionPerformed
        AsignarNum(PuntoX, PuntoY, 1);
    }//GEN-LAST:event_Boton1ActionPerformed

    private void Boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2ActionPerformed
        AsignarNum(PuntoX, PuntoY, 2);
    }//GEN-LAST:event_Boton2ActionPerformed

    private void Boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3ActionPerformed
        AsignarNum(PuntoX, PuntoY, 3);
    }//GEN-LAST:event_Boton3ActionPerformed

    private void Boton3_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_0ActionPerformed
        PuntoX=3;
        PuntoY=0;
    }//GEN-LAST:event_Boton3_0ActionPerformed

    private void Boton3_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_1ActionPerformed
        PuntoX=3;
        PuntoY=1;
    }//GEN-LAST:event_Boton3_1ActionPerformed

    private void Boton3_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_2ActionPerformed
        PuntoX=3;
        PuntoY=2;
    }//GEN-LAST:event_Boton3_2ActionPerformed

    private void Boton3_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_3ActionPerformed
        PuntoX=3;
        PuntoY=3;
    }//GEN-LAST:event_Boton3_3ActionPerformed

    private void Boton3_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_4ActionPerformed
        PuntoX=3;
        PuntoY=4;
    }//GEN-LAST:event_Boton3_4ActionPerformed

    private void Boton3_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_5ActionPerformed
        PuntoX=3;
        PuntoY=5;
    }//GEN-LAST:event_Boton3_5ActionPerformed

    private void Boton3_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_6ActionPerformed
        PuntoX=3;
        PuntoY=6;
    }//GEN-LAST:event_Boton3_6ActionPerformed

    private void Boton3_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_7ActionPerformed
        PuntoX=3;
        PuntoY=7;
    }//GEN-LAST:event_Boton3_7ActionPerformed

    private void Boton3_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_8ActionPerformed
        PuntoX=3;
        PuntoY=8;
    }//GEN-LAST:event_Boton3_8ActionPerformed

    private void Boton3_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3_9ActionPerformed
        PuntoX=3;
        PuntoY=9;
    }//GEN-LAST:event_Boton3_9ActionPerformed

    private void Boton4_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_0ActionPerformed
        PuntoX=4;
        PuntoY=0;
    }//GEN-LAST:event_Boton4_0ActionPerformed

    private void Boton4_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_1ActionPerformed
        PuntoX=4;
        PuntoY=1;
    }//GEN-LAST:event_Boton4_1ActionPerformed

    private void Boton4_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_2ActionPerformed
        PuntoX=4;
        PuntoY=2;
    }//GEN-LAST:event_Boton4_2ActionPerformed

    private void Boton4_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_3ActionPerformed
        PuntoX=4;
        PuntoY=3;
    }//GEN-LAST:event_Boton4_3ActionPerformed

    private void Boton4_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_4ActionPerformed
        PuntoX=4;
        PuntoY=4;
    }//GEN-LAST:event_Boton4_4ActionPerformed

    private void Boton4_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_5ActionPerformed
        PuntoX=4;
        PuntoY=5;
    }//GEN-LAST:event_Boton4_5ActionPerformed

    private void Boton4_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_6ActionPerformed
        PuntoX=4;
        PuntoY=6;
    }//GEN-LAST:event_Boton4_6ActionPerformed

    private void Boton4_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_7ActionPerformed
        PuntoX=4;
        PuntoY=7;
    }//GEN-LAST:event_Boton4_7ActionPerformed

    private void Boton4_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_8ActionPerformed
        PuntoX=4;
        PuntoY=8;
    }//GEN-LAST:event_Boton4_8ActionPerformed

    private void Boton4_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4_9ActionPerformed
        PuntoX=4;
        PuntoY=9;
    }//GEN-LAST:event_Boton4_9ActionPerformed

    private void Boton5_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_0ActionPerformed
        PuntoX=5;
        PuntoY=0;
    }//GEN-LAST:event_Boton5_0ActionPerformed

    private void Boton5_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_1ActionPerformed
        PuntoX=5;
        PuntoY=1;
    }//GEN-LAST:event_Boton5_1ActionPerformed

    private void Boton5_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_2ActionPerformed
        PuntoX=5;
        PuntoY=2;
    }//GEN-LAST:event_Boton5_2ActionPerformed

    private void Boton5_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_3ActionPerformed
        PuntoX=5;
        PuntoY=3;
    }//GEN-LAST:event_Boton5_3ActionPerformed

    private void Boton5_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_4ActionPerformed
        PuntoX=5;
        PuntoY=4;
    }//GEN-LAST:event_Boton5_4ActionPerformed

    private void Boton5_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_5ActionPerformed
        PuntoX=5;
        PuntoY=5;
    }//GEN-LAST:event_Boton5_5ActionPerformed

    private void Boton5_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_6ActionPerformed
        PuntoX=5;
        PuntoY=6;
    }//GEN-LAST:event_Boton5_6ActionPerformed

    private void Boton5_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_7ActionPerformed
        PuntoX=5;
        PuntoY=7;
    }//GEN-LAST:event_Boton5_7ActionPerformed

    private void Boton5_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_8ActionPerformed
        PuntoX=5;
        PuntoY=8;
    }//GEN-LAST:event_Boton5_8ActionPerformed

    private void Boton5_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5_9ActionPerformed
        PuntoX=5;
        PuntoY=9;
    }//GEN-LAST:event_Boton5_9ActionPerformed

    private void Boton6_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_0ActionPerformed
        PuntoX=6;
        PuntoY=0;
    }//GEN-LAST:event_Boton6_0ActionPerformed

    private void Boton6_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_1ActionPerformed
        PuntoX=6;
        PuntoY=1;
    }//GEN-LAST:event_Boton6_1ActionPerformed

    private void Boton6_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_2ActionPerformed
        PuntoX=6;
        PuntoY=2;
    }//GEN-LAST:event_Boton6_2ActionPerformed

    private void Boton6_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_3ActionPerformed
        PuntoX=6;
        PuntoY=3;
    }//GEN-LAST:event_Boton6_3ActionPerformed

    private void Boton6_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_4ActionPerformed
        PuntoX=6;
        PuntoY=4;
    }//GEN-LAST:event_Boton6_4ActionPerformed

    private void Boton6_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_5ActionPerformed
        PuntoX=6;
        PuntoY=5;
    }//GEN-LAST:event_Boton6_5ActionPerformed

    private void Boton6_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_6ActionPerformed
        PuntoX=6;
        PuntoY=6;
    }//GEN-LAST:event_Boton6_6ActionPerformed

    private void Boton6_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_7ActionPerformed
        PuntoX=6;
        PuntoY=7;
    }//GEN-LAST:event_Boton6_7ActionPerformed

    private void Boton6_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_8ActionPerformed
        PuntoX=6;
        PuntoY=8;
    }//GEN-LAST:event_Boton6_8ActionPerformed

    private void Boton6_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6_9ActionPerformed
        PuntoX=6;
        PuntoY=9;
    }//GEN-LAST:event_Boton6_9ActionPerformed

    private void Boton7_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_0ActionPerformed
        PuntoX=7;
        PuntoY=0;
    }//GEN-LAST:event_Boton7_0ActionPerformed

    private void Boton8_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_0ActionPerformed
        PuntoX=8;
        PuntoY=0;
    }//GEN-LAST:event_Boton8_0ActionPerformed

    private void Boton9_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_0ActionPerformed
        PuntoX=9;
        PuntoY=0;
    }//GEN-LAST:event_Boton9_0ActionPerformed

    private void Boton7_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_1ActionPerformed
        PuntoX=7;
        PuntoY=1;
    }//GEN-LAST:event_Boton7_1ActionPerformed

    private void Boton7_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_2ActionPerformed
        PuntoX=7;
        PuntoY=2;
    }//GEN-LAST:event_Boton7_2ActionPerformed

    private void Boton7_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_3ActionPerformed
        PuntoX=7;
        PuntoY=3;
    }//GEN-LAST:event_Boton7_3ActionPerformed

    private void Boton7_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_4ActionPerformed
        PuntoX=7;
        PuntoY=4;
    }//GEN-LAST:event_Boton7_4ActionPerformed

    private void Boton7_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_5ActionPerformed
        PuntoX=7;
        PuntoY=5;
    }//GEN-LAST:event_Boton7_5ActionPerformed

    private void Boton7_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_6ActionPerformed
        PuntoX=7;
        PuntoY=6;
    }//GEN-LAST:event_Boton7_6ActionPerformed

    private void Boton7_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_7ActionPerformed
        PuntoX=7;
        PuntoY=7;
    }//GEN-LAST:event_Boton7_7ActionPerformed

    private void Boton7_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_8ActionPerformed
        PuntoX=7;
        PuntoY=8;
    }//GEN-LAST:event_Boton7_8ActionPerformed

    private void Boton7_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_9ActionPerformed
        PuntoX=7;
        PuntoY=9;
    }//GEN-LAST:event_Boton7_9ActionPerformed

    private void Boton8_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_1ActionPerformed
        PuntoX=8;
        PuntoY=1;
    }//GEN-LAST:event_Boton8_1ActionPerformed

    private void Boton8_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_2ActionPerformed
        PuntoX=8;
        PuntoY=2;
    }//GEN-LAST:event_Boton8_2ActionPerformed

    private void Boton8_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_3ActionPerformed
        PuntoX=8;
        PuntoY=3;
    }//GEN-LAST:event_Boton8_3ActionPerformed

    private void Boton8_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_4ActionPerformed
        PuntoX=8;
        PuntoY=4;
    }//GEN-LAST:event_Boton8_4ActionPerformed

    private void Boton8_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_5ActionPerformed
        PuntoX=8;
        PuntoY=5;
    }//GEN-LAST:event_Boton8_5ActionPerformed

    private void Boton8_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_6ActionPerformed
        PuntoX=8;
        PuntoY=6;
    }//GEN-LAST:event_Boton8_6ActionPerformed

    private void Boton8_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_7ActionPerformed
        PuntoX=8;
        PuntoY=7;
    }//GEN-LAST:event_Boton8_7ActionPerformed

    private void Boton8_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_8ActionPerformed
        PuntoX=8;
        PuntoY=8;
    }//GEN-LAST:event_Boton8_8ActionPerformed

    private void Boton8_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8_9ActionPerformed
        PuntoX=8;
        PuntoY=9;
    }//GEN-LAST:event_Boton8_9ActionPerformed

    private void Boton9_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_1ActionPerformed
        PuntoX=9;
        PuntoY=1;
    }//GEN-LAST:event_Boton9_1ActionPerformed

    private void Boton9_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_2ActionPerformed
        PuntoX=9;
        PuntoY=2;
    }//GEN-LAST:event_Boton9_2ActionPerformed

    private void Boton9_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_3ActionPerformed
        PuntoX=9;
        PuntoY=3;
    }//GEN-LAST:event_Boton9_3ActionPerformed

    private void Boton9_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_4ActionPerformed
        PuntoX=9;
        PuntoY=4;
    }//GEN-LAST:event_Boton9_4ActionPerformed

    private void Boton9_5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_5ActionPerformed
        PuntoX=9;
        PuntoY=5;
    }//GEN-LAST:event_Boton9_5ActionPerformed

    private void Boton9_6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_6ActionPerformed
        PuntoX=9;
        PuntoY=6;
    }//GEN-LAST:event_Boton9_6ActionPerformed

    private void Boton9_7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_7ActionPerformed
        PuntoX=9;
        PuntoY=7;
    }//GEN-LAST:event_Boton9_7ActionPerformed

    private void Boton9_8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_8ActionPerformed
        PuntoX=9;
        PuntoY=8;
    }//GEN-LAST:event_Boton9_8ActionPerformed

    private void Boton9_9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9_9ActionPerformed
        PuntoX=9;
        PuntoY=9;
    }//GEN-LAST:event_Boton9_9ActionPerformed

    private void Boton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton4ActionPerformed
        AsignarNum(PuntoX, PuntoY, 4);
    }//GEN-LAST:event_Boton4ActionPerformed

    private void Boton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton5ActionPerformed
        AsignarNum(PuntoX, PuntoY, 5);
    }//GEN-LAST:event_Boton5ActionPerformed

    private void Boton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton6ActionPerformed
        AsignarNum(PuntoX, PuntoY, 6);
    }//GEN-LAST:event_Boton6ActionPerformed

    private void Boton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7ActionPerformed
        AsignarNum(PuntoX, PuntoY, 7);
    }//GEN-LAST:event_Boton7ActionPerformed

    private void Boton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton9ActionPerformed
        AsignarNum(PuntoX, PuntoY, 9);
    }//GEN-LAST:event_Boton9ActionPerformed

    private void Boton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton10ActionPerformed
        AsignarNum(PuntoX, PuntoY, 10);
    }//GEN-LAST:event_Boton10ActionPerformed

    private void Boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8ActionPerformed
        AsignarNum(PuntoX, PuntoY, 8);
    }//GEN-LAST:event_Boton8ActionPerformed

    private void BotonCargarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarJuegoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonCargarJuegoActionPerformed

    private void MinutosTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinutosTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinutosTiempoActionPerformed

    private void SegundosTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SegundosTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SegundosTiempoActionPerformed

    private void BotonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarJuegoActionPerformed
        
        if(!timer.isRunning()){
           
           if(ModoTiempo ==0){
           
                reiniciarTiempo();
                esCronometro = true;
                tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
                timer.start();   
           
           
           }else if(ModoTiempo==1){
               
                esCronometro = false;
                horas = 0;
                minutos = 10;
                segundos = 0;
                
                HorasTiempo.setText(String.format("%2d", horas));
                MinutosTiempo.setText(String.format("%2d", minutos));
                SegundosTiempo.setText(String.format("%02d", segundos));
           }
           
           tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
           timer.start();
                       
        }else{
        
            detenerTiempo("Tiempo detenido.");
        }
        
    }//GEN-LAST:event_BotonIniciarJuegoActionPerformed

    private void BorrarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarBotonActionPerformed
        AsignarNum(PuntoX, PuntoY, 0);
    }//GEN-LAST:event_BorrarBotonActionPerformed

    public void AsignarNum(int fila, int columna, int num) {
        botones[fila][columna].setText(""+num); // Cambiar texto del botón
        if (num==0){
            botones[fila][columna].setText("");
        }
        boolean esta=verificarMatriz(matrizNumeros,fila,columna,num);
        if (esta==false){
            matrizNumeros[fila][columna]=num;
            botones[fila][columna].setForeground(Color.GREEN);
        }
        else{
            botones[fila][columna].setForeground(Color.RED);
        }
    }
    
    public boolean verificarMatriz(int[][] matriz,int fila, int columna,int numero){
        int size = matriz.length;
        System.out.print(size+"\n");
        
        for (int j = 0; j < size; j++) {
            if (matriz[fila][j] == numero) {
                return true; // Número encontrado en la fila
            }
        }
        for (int i = 0; i < size; i++) {
            if (matriz[i][columna] == numero) {
                return true; // Número encontrado en la columna
            }
        }
        return false;
    }
    public void imprimirMatriz(int[][] matriz){
        int size = matriz.length;
        String linea;
        for (int j = 0; j < size; j++) {
            linea="(";
            for (int i = 0; i < size; i++) {
                linea+=matrizNumeros[j][i]+",";
            }
            linea+=")";
            System.out.println(linea);
        }
    }
    
    public void reiniciarTiempo(){
        
        horas = 0;
        minutos = 0;
        segundos = 0;
    }
    
    public void detenerTiempo(String mensaje) {
        
        timer.stop();
        //JOptionPane.showMessageDialog(null, mensaje);

        // Calculo total del tiempo actual
        int horasTotales = tiempoTranscurridoSegundos / 3600;
        int minutosTotales = (tiempoTranscurridoSegundos % 3600) / 60;
        int segundosTotales = tiempoTranscurridoSegundos % 60;
        
        String tiempoDuracion = String.format("%02d:%02d:%02d", horasTotales, minutosTotales, segundosTotales);
        
        JOptionPane.showMessageDialog(null, "Tiempo total: " + tiempoDuracion);
        
        // Falta que pida al usuario si quiere seguir jugando o no.
    }    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame10x10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame10x10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame10x10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame10x10.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame10x10().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BorrarBoton;
    private javax.swing.JButton Boton0_0;
    private javax.swing.JButton Boton0_1;
    private javax.swing.JButton Boton0_2;
    private javax.swing.JButton Boton0_3;
    private javax.swing.JButton Boton0_4;
    private javax.swing.JButton Boton0_5;
    private javax.swing.JButton Boton0_6;
    private javax.swing.JButton Boton0_7;
    private javax.swing.JButton Boton0_8;
    private javax.swing.JButton Boton0_9;
    private javax.swing.JButton Boton1;
    private javax.swing.JButton Boton10;
    private javax.swing.JButton Boton1_0;
    private javax.swing.JButton Boton1_1;
    private javax.swing.JButton Boton1_2;
    private javax.swing.JButton Boton1_3;
    private javax.swing.JButton Boton1_4;
    private javax.swing.JButton Boton1_5;
    private javax.swing.JButton Boton1_6;
    private javax.swing.JButton Boton1_7;
    private javax.swing.JButton Boton1_8;
    private javax.swing.JButton Boton1_9;
    private javax.swing.JButton Boton2;
    private javax.swing.JButton Boton2_0;
    private javax.swing.JButton Boton2_1;
    private javax.swing.JButton Boton2_2;
    private javax.swing.JButton Boton2_3;
    private javax.swing.JButton Boton2_4;
    private javax.swing.JButton Boton2_5;
    private javax.swing.JButton Boton2_6;
    private javax.swing.JButton Boton2_7;
    private javax.swing.JButton Boton2_8;
    private javax.swing.JButton Boton2_9;
    private javax.swing.JButton Boton3;
    private javax.swing.JButton Boton3_0;
    private javax.swing.JButton Boton3_1;
    private javax.swing.JButton Boton3_2;
    private javax.swing.JButton Boton3_3;
    private javax.swing.JButton Boton3_4;
    private javax.swing.JButton Boton3_5;
    private javax.swing.JButton Boton3_6;
    private javax.swing.JButton Boton3_7;
    private javax.swing.JButton Boton3_8;
    private javax.swing.JButton Boton3_9;
    private javax.swing.JButton Boton4;
    private javax.swing.JButton Boton4_0;
    private javax.swing.JButton Boton4_1;
    private javax.swing.JButton Boton4_2;
    private javax.swing.JButton Boton4_3;
    private javax.swing.JButton Boton4_4;
    private javax.swing.JButton Boton4_5;
    private javax.swing.JButton Boton4_6;
    private javax.swing.JButton Boton4_7;
    private javax.swing.JButton Boton4_8;
    private javax.swing.JButton Boton4_9;
    private javax.swing.JButton Boton5;
    private javax.swing.JButton Boton5_0;
    private javax.swing.JButton Boton5_1;
    private javax.swing.JButton Boton5_2;
    private javax.swing.JButton Boton5_3;
    private javax.swing.JButton Boton5_4;
    private javax.swing.JButton Boton5_5;
    private javax.swing.JButton Boton5_6;
    private javax.swing.JButton Boton5_7;
    private javax.swing.JButton Boton5_8;
    private javax.swing.JButton Boton5_9;
    private javax.swing.JButton Boton6;
    private javax.swing.JButton Boton6_0;
    private javax.swing.JButton Boton6_1;
    private javax.swing.JButton Boton6_2;
    private javax.swing.JButton Boton6_3;
    private javax.swing.JButton Boton6_4;
    private javax.swing.JButton Boton6_5;
    private javax.swing.JButton Boton6_6;
    private javax.swing.JButton Boton6_7;
    private javax.swing.JButton Boton6_8;
    private javax.swing.JButton Boton6_9;
    private javax.swing.JButton Boton7;
    private javax.swing.JButton Boton7_0;
    private javax.swing.JButton Boton7_1;
    private javax.swing.JButton Boton7_2;
    private javax.swing.JButton Boton7_3;
    private javax.swing.JButton Boton7_4;
    private javax.swing.JButton Boton7_5;
    private javax.swing.JButton Boton7_6;
    private javax.swing.JButton Boton7_7;
    private javax.swing.JButton Boton7_8;
    private javax.swing.JButton Boton7_9;
    private javax.swing.JButton Boton8;
    private javax.swing.JButton Boton8_0;
    private javax.swing.JButton Boton8_1;
    private javax.swing.JButton Boton8_2;
    private javax.swing.JButton Boton8_3;
    private javax.swing.JButton Boton8_4;
    private javax.swing.JButton Boton8_5;
    private javax.swing.JButton Boton8_6;
    private javax.swing.JButton Boton8_7;
    private javax.swing.JButton Boton8_8;
    private javax.swing.JButton Boton8_9;
    private javax.swing.JButton Boton9;
    private javax.swing.JButton Boton9_0;
    private javax.swing.JButton Boton9_1;
    private javax.swing.JButton Boton9_2;
    private javax.swing.JButton Boton9_3;
    private javax.swing.JButton Boton9_4;
    private javax.swing.JButton Boton9_5;
    private javax.swing.JButton Boton9_6;
    private javax.swing.JButton Boton9_7;
    private javax.swing.JButton Boton9_8;
    private javax.swing.JButton Boton9_9;
    private javax.swing.JButton BotonBorrarJuego;
    private javax.swing.JButton BotonBorrarJugada;
    private javax.swing.JButton BotonCargarJuego;
    private javax.swing.JButton BotonGuardarJuego;
    private javax.swing.JButton BotonIniciarJuego;
    private javax.swing.JButton BotonRehacerJugada;
    private javax.swing.JButton BotonTerminarJuego;
    private javax.swing.JTextField HorasTiempo;
    private javax.swing.JTextField Horatexto;
    private javax.swing.JTextField MinutosTexto;
    private javax.swing.JTextField MinutosTiempo;
    private javax.swing.JTextField NombreJugador;
    private javax.swing.JTextField SegundosTexto;
    private javax.swing.JTextField SegundosTiempo;
    private javax.swing.JLabel Texto0_0;
    private javax.swing.JLabel Texto0_1;
    private javax.swing.JLabel Texto0_2;
    private javax.swing.JLabel Texto0_3;
    private javax.swing.JLabel Texto0_4;
    private javax.swing.JLabel Texto0_5;
    private javax.swing.JLabel Texto0_6;
    private javax.swing.JLabel Texto0_7;
    private javax.swing.JLabel Texto0_8;
    private javax.swing.JLabel Texto10_0;
    private javax.swing.JLabel Texto10_1;
    private javax.swing.JLabel Texto10_2;
    private javax.swing.JLabel Texto10_3;
    private javax.swing.JLabel Texto10_4;
    private javax.swing.JLabel Texto10_5;
    private javax.swing.JLabel Texto10_6;
    private javax.swing.JLabel Texto10_7;
    private javax.swing.JLabel Texto10_8;
    private javax.swing.JLabel Texto11_0;
    private javax.swing.JLabel Texto11_1;
    private javax.swing.JLabel Texto11_2;
    private javax.swing.JLabel Texto11_3;
    private javax.swing.JLabel Texto11_4;
    private javax.swing.JLabel Texto11_5;
    private javax.swing.JLabel Texto11_6;
    private javax.swing.JLabel Texto11_7;
    private javax.swing.JLabel Texto11_8;
    private javax.swing.JLabel Texto11_9;
    private javax.swing.JLabel Texto12_0;
    private javax.swing.JLabel Texto12_1;
    private javax.swing.JLabel Texto12_2;
    private javax.swing.JLabel Texto12_3;
    private javax.swing.JLabel Texto12_4;
    private javax.swing.JLabel Texto12_5;
    private javax.swing.JLabel Texto12_6;
    private javax.swing.JLabel Texto12_7;
    private javax.swing.JLabel Texto12_8;
    private javax.swing.JLabel Texto13_0;
    private javax.swing.JLabel Texto13_1;
    private javax.swing.JLabel Texto13_2;
    private javax.swing.JLabel Texto13_3;
    private javax.swing.JLabel Texto13_4;
    private javax.swing.JLabel Texto13_5;
    private javax.swing.JLabel Texto13_6;
    private javax.swing.JLabel Texto13_7;
    private javax.swing.JLabel Texto13_8;
    private javax.swing.JLabel Texto13_9;
    private javax.swing.JLabel Texto14_0;
    private javax.swing.JLabel Texto14_1;
    private javax.swing.JLabel Texto14_2;
    private javax.swing.JLabel Texto14_3;
    private javax.swing.JLabel Texto14_4;
    private javax.swing.JLabel Texto14_5;
    private javax.swing.JLabel Texto14_6;
    private javax.swing.JLabel Texto14_7;
    private javax.swing.JLabel Texto14_8;
    private javax.swing.JLabel Texto15_0;
    private javax.swing.JLabel Texto15_1;
    private javax.swing.JLabel Texto15_2;
    private javax.swing.JLabel Texto15_3;
    private javax.swing.JLabel Texto15_4;
    private javax.swing.JLabel Texto15_5;
    private javax.swing.JLabel Texto15_6;
    private javax.swing.JLabel Texto15_7;
    private javax.swing.JLabel Texto15_8;
    private javax.swing.JLabel Texto15_9;
    private javax.swing.JLabel Texto16_0;
    private javax.swing.JLabel Texto16_1;
    private javax.swing.JLabel Texto16_2;
    private javax.swing.JLabel Texto16_3;
    private javax.swing.JLabel Texto16_4;
    private javax.swing.JLabel Texto16_5;
    private javax.swing.JLabel Texto16_6;
    private javax.swing.JLabel Texto16_7;
    private javax.swing.JLabel Texto16_8;
    private javax.swing.JLabel Texto17_00;
    private javax.swing.JLabel Texto17_1;
    private javax.swing.JLabel Texto17_2;
    private javax.swing.JLabel Texto17_3;
    private javax.swing.JLabel Texto17_4;
    private javax.swing.JLabel Texto17_5;
    private javax.swing.JLabel Texto17_6;
    private javax.swing.JLabel Texto17_7;
    private javax.swing.JLabel Texto17_8;
    private javax.swing.JLabel Texto17_9;
    private javax.swing.JLabel Texto18_0;
    private javax.swing.JLabel Texto18_1;
    private javax.swing.JLabel Texto18_2;
    private javax.swing.JLabel Texto18_3;
    private javax.swing.JLabel Texto18_4;
    private javax.swing.JLabel Texto18_5;
    private javax.swing.JLabel Texto18_6;
    private javax.swing.JLabel Texto18_7;
    private javax.swing.JLabel Texto18_8;
    private javax.swing.JLabel Texto1_0;
    private javax.swing.JLabel Texto1_1;
    private javax.swing.JLabel Texto1_2;
    private javax.swing.JLabel Texto1_3;
    private javax.swing.JLabel Texto1_4;
    private javax.swing.JLabel Texto1_5;
    private javax.swing.JLabel Texto1_6;
    private javax.swing.JLabel Texto1_7;
    private javax.swing.JLabel Texto1_8;
    private javax.swing.JLabel Texto1_9;
    private javax.swing.JLabel Texto2_0;
    private javax.swing.JLabel Texto2_1;
    private javax.swing.JLabel Texto2_2;
    private javax.swing.JLabel Texto2_3;
    private javax.swing.JLabel Texto2_4;
    private javax.swing.JLabel Texto2_5;
    private javax.swing.JLabel Texto2_6;
    private javax.swing.JLabel Texto2_7;
    private javax.swing.JLabel Texto2_8;
    private javax.swing.JLabel Texto3_0;
    private javax.swing.JLabel Texto3_1;
    private javax.swing.JLabel Texto3_2;
    private javax.swing.JLabel Texto3_3;
    private javax.swing.JLabel Texto3_4;
    private javax.swing.JLabel Texto3_5;
    private javax.swing.JLabel Texto3_6;
    private javax.swing.JLabel Texto3_7;
    private javax.swing.JLabel Texto3_8;
    private javax.swing.JLabel Texto3_9;
    private javax.swing.JLabel Texto4_0;
    private javax.swing.JLabel Texto4_1;
    private javax.swing.JLabel Texto4_2;
    private javax.swing.JLabel Texto4_3;
    private javax.swing.JLabel Texto4_4;
    private javax.swing.JLabel Texto4_5;
    private javax.swing.JLabel Texto4_6;
    private javax.swing.JLabel Texto4_7;
    private javax.swing.JLabel Texto4_8;
    private javax.swing.JLabel Texto5_0;
    private javax.swing.JLabel Texto5_1;
    private javax.swing.JLabel Texto5_2;
    private javax.swing.JLabel Texto5_3;
    private javax.swing.JLabel Texto5_4;
    private javax.swing.JLabel Texto5_5;
    private javax.swing.JLabel Texto5_6;
    private javax.swing.JLabel Texto5_7;
    private javax.swing.JLabel Texto5_8;
    private javax.swing.JLabel Texto5_9;
    private javax.swing.JLabel Texto6_0;
    private javax.swing.JLabel Texto6_1;
    private javax.swing.JLabel Texto6_2;
    private javax.swing.JLabel Texto6_3;
    private javax.swing.JLabel Texto6_4;
    private javax.swing.JLabel Texto6_5;
    private javax.swing.JLabel Texto6_6;
    private javax.swing.JLabel Texto6_7;
    private javax.swing.JLabel Texto6_8;
    private javax.swing.JLabel Texto7_0;
    private javax.swing.JLabel Texto7_1;
    private javax.swing.JLabel Texto7_2;
    private javax.swing.JLabel Texto7_3;
    private javax.swing.JLabel Texto7_4;
    private javax.swing.JLabel Texto7_5;
    private javax.swing.JLabel Texto7_6;
    private javax.swing.JLabel Texto7_7;
    private javax.swing.JLabel Texto7_8;
    private javax.swing.JLabel Texto7_9;
    private javax.swing.JLabel Texto8_0;
    private javax.swing.JLabel Texto8_1;
    private javax.swing.JLabel Texto8_2;
    private javax.swing.JLabel Texto8_3;
    private javax.swing.JLabel Texto8_4;
    private javax.swing.JLabel Texto8_5;
    private javax.swing.JLabel Texto8_6;
    private javax.swing.JLabel Texto8_7;
    private javax.swing.JLabel Texto8_8;
    private javax.swing.JLabel Texto9_0;
    private javax.swing.JLabel Texto9_1;
    private javax.swing.JLabel Texto9_2;
    private javax.swing.JLabel Texto9_3;
    private javax.swing.JLabel Texto9_4;
    private javax.swing.JLabel Texto9_5;
    private javax.swing.JLabel Texto9_6;
    private javax.swing.JLabel Texto9_7;
    private javax.swing.JLabel Texto9_8;
    private javax.swing.JLabel Texto9_9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
