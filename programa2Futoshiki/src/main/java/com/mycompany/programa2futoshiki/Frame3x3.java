/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.programa2futoshiki;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.ArrayList;

/**
 *
 * @author jxdga
 */
public class Frame3x3 extends javax.swing.JFrame {
    
    ArchivosXML archivoXML = new ArchivosXML();
    private Timer timer;
    private boolean ValidoTop = true;
    private int horas, minutos, segundos;
    private int tiempoTranscurridoSegundos = 0;
    private int ModoTiempo = 0;
    private boolean esCronometro = true;
    private String Dificultad;
    private int Multinivel;
    private String Posicion;
    private Usuario usuario2;
    int tempHora = 0;
    int tempMins = 0;
    int tempSeg= 0;
    
    JButton[][] botones;
    JLabel[][] texto;
    int PuntoX,PuntoY,PuntoX2,PuntoY2;
    boolean jugar=false;
    ArrayList<Jugada> jugadas;
    Jugada ultimaJugada;
    
    int [][] matrizNumeros = {
        {0,0,0},
        {0,0,0},
        {0,0,0}
    };
    String [][] matrizSimbolos={
        {"",""},
        {"","",""},
        {"",""},
        {"","",""},
        {"",""}
    };
    
    /**
     * Creates new form Frame10x10
     */
    
    public Frame3x3(String dificultad, int multinivel, int usoreloj, String posicion, String nombre, Usuario usuario, int Horas, int Minutos, int Segundos) {
        initComponents();
        inicializarBotones();
        inicializarTexto();
        setLocationRelativeTo(null);
        
        
        NombreJugador.setText(nombre);
        horas = Horas; 
        minutos = Minutos;
        segundos = Segundos;
        ModoTiempo = usoreloj;
        Dificultad = dificultad;
        Multinivel = multinivel;
        Posicion = posicion;
        usuario2 = usuario;

        
        timer = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                
                tiempoTranscurridoSegundos++; // Esto se usa para el calculo del tiempo total en ambos modos

                if(esCronometro){
                    // Lógica para cuenta hacia adelante
                    tempSeg++;
                                  
                    if(tempSeg == 60){
                        
                        tempSeg = 0;
                        tempMins++;
                        
                        if(tempMins == 60){
                            
                            tempMins = 0;
                            tempHora++;
                        }
                    }

                    // Validacion del cronometro, revisar si se alcanzado el limite de tiempo: 10 mins
                    
                    if(tempMins == minutos && tempSeg == segundos){
                        detenerTiempo("Se ha acabado el tiempo del cronómetro.");
                    }

                }else{
                    // Lógica para cuenta hacia atras
                  
                    if(segundos == 0){
                        
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
                if(ModoTiempo==1){
                    
                    HorasTiempo.setText(String.format("%2d", horas));
                    MinutosTiempo.setText(String.format("%2d", minutos));
                    SegundosTiempo.setText(String.format("%02d", segundos));
                }else if(ModoTiempo==0){
                    
                    HorasTiempo.setText(String.format("%2d", tempHora));
                    MinutosTiempo.setText(String.format("%2d", tempMins));
                    SegundosTiempo.setText(String.format("%02d", tempSeg));       
                }else{
                
                    HorasTiempo.setText("");
                    MinutosTiempo.setText("");
                    SegundosTiempo.setText("");  
                
                }    
            }
        });     
        jugadas = new ArrayList<Jugada>();
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

        botones[1][0] = Boton1_0;
        botones[1][1] = Boton1_1;
        botones[1][2] = Boton1_2;
        
        botones[2][0] = Boton2_0;
        botones[2][1] = Boton2_1;
        botones[2][2] = Boton2_2;
        
    }
    
    private void inicializarTexto(){
    texto = new JLabel[19][10]; // Creamos la matriz de 10x10

    texto[0][0] = Texto0_0;
    texto[0][1] = Texto0_1;

    texto[1][0] = Texto1_0;
    texto[1][1] = Texto1_1;
    texto[1][2] = Texto1_2;

    texto[2][0] = Texto2_0;
    texto[2][1] = Texto2_1;

    texto[3][0] = Texto3_0;
    texto[3][1] = Texto3_1;
    texto[3][2] = Texto3_2;

    texto[4][0] = Texto4_0;
    texto[4][1] = Texto4_1;
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
        Boton1_0 = new javax.swing.JButton();
        Boton1_1 = new javax.swing.JButton();
        Boton1_2 = new javax.swing.JButton();
        Boton2_0 = new javax.swing.JButton();
        Boton2_1 = new javax.swing.JButton();
        Boton2_2 = new javax.swing.JButton();
        Boton1 = new javax.swing.JButton();
        Boton2 = new javax.swing.JButton();
        Boton3 = new javax.swing.JButton();
        Texto0_0 = new javax.swing.JLabel();
        Texto0_1 = new javax.swing.JLabel();
        Texto1_0 = new javax.swing.JLabel();
        Texto1_1 = new javax.swing.JLabel();
        Texto1_2 = new javax.swing.JLabel();
        Texto2_0 = new javax.swing.JLabel();
        Texto2_1 = new javax.swing.JLabel();
        Texto3_0 = new javax.swing.JLabel();
        Texto3_1 = new javax.swing.JLabel();
        Texto3_2 = new javax.swing.JLabel();
        Texto4_0 = new javax.swing.JLabel();
        Texto4_1 = new javax.swing.JLabel();
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
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Boton0_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 120, 40, 40));

        Boton0_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 40, 40));

        Boton0_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 40, 40));

        Boton1_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 40, 40));

        Boton1_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 190, 40, 40));

        Boton1_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 40, 40));

        Boton2_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 40, 40));

        Boton2_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 260, 40, 40));

        Boton2_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 40, 40));

        Boton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton1.setText("(1)");
        Boton1.setAlignmentY(0.0F);
        Boton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 120, 40, 40));

        Boton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton2.setText("(2)");
        Boton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 190, 40, 40));

        Boton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton3.setText("(3)");
        Boton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 260, 40, 40));

        Texto0_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_0.setText(">");
        getContentPane().add(Texto0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, 40));

        Texto0_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_1.setText(">");
        getContentPane().add(Texto0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, 40));

        Texto1_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_0.setText(" ^");
        Texto1_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 160, 40, 25));

        Texto1_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_1.setText(" ^");
        Texto1_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 40, 25));

        Texto1_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_2.setText(" ^");
        Texto1_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 40, 25));

        Texto2_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_0.setText(">");
        getContentPane().add(Texto2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 190, -1, 40));

        Texto2_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_1.setText(">");
        getContentPane().add(Texto2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, -1, 40));

        Texto3_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_0.setText(" ^");
        Texto3_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 40, 25));

        Texto3_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_1.setText(" ^");
        Texto3_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 40, 25));

        Texto3_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_2.setText(" ^");
        Texto3_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 40, 25));

        Texto4_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_0.setText(">");
        getContentPane().add(Texto4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, -1, 40));

        Texto4_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_1.setText(">");
        getContentPane().add(Texto4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 260, -1, 40));

        jPanel1.setBackground(new java.awt.Color(255, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("FUTOSHIKI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(110, 110, 110))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(378, 6, 349, -1));

        BotonIniciarJuego.setBackground(new java.awt.Color(255, 51, 51));
        BotonIniciarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonIniciarJuego.setText("INICIAR JUEGO");
        BotonIniciarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIniciarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, 158, 70));

        BotonBorrarJugada.setBackground(new java.awt.Color(0, 204, 204));
        BotonBorrarJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJugada.setText("BORRAR JUGADA");
        BotonBorrarJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonBorrarJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarJugadaActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBorrarJugada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 158, 40));

        BotonBorrarJuego.setBackground(new java.awt.Color(153, 153, 255));
        BotonBorrarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJuego.setText("BORRAR JUEGO");
        BotonBorrarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBorrarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 158, 40));

        BotonGuardarJuego.setBackground(new java.awt.Color(51, 153, 0));
        BotonGuardarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonGuardarJuego.setText("GUARDAR JUEGO");
        BotonGuardarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonGuardarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonGuardarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 380, 158, 40));

        BotonRehacerJugada.setBackground(new java.awt.Color(255, 204, 51));
        BotonRehacerJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonRehacerJugada.setText("REHACER JUGADA");
        BotonRehacerJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonRehacerJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRehacerJugadaActionPerformed(evt);
            }
        });
        getContentPane().add(BotonRehacerJugada, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, 158, 40));

        BotonCargarJuego.setBackground(new java.awt.Color(153, 51, 0));
        BotonCargarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonCargarJuego.setText("CARGAR JUEGO");
        BotonCargarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonCargarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCargarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 470, 158, 40));

        BotonTerminarJuego.setBackground(new java.awt.Color(255, 204, 51));
        BotonTerminarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonTerminarJuego.setText("TERMINAR JUEGO");
        BotonTerminarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTerminarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonTerminarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 158, 50));

        Horatexto.setEditable(false);
        Horatexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Horatexto.setText("Horas");
        getContentPane().add(Horatexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 460, 49, -1));

        MinutosTexto.setEditable(false);
        MinutosTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinutosTexto.setText("Minutos");
        getContentPane().add(MinutosTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 50, -1));

        SegundosTexto.setEditable(false);
        SegundosTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SegundosTexto.setText("Segundos");
        getContentPane().add(SegundosTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        HorasTiempo.setEditable(false);
        HorasTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(HorasTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 49, 65));

        MinutosTiempo.setEditable(false);
        MinutosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinutosTiempo.setAutoscrolls(false);
        MinutosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinutosTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(MinutosTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 50, 65));

        SegundosTiempo.setEditable(false);
        SegundosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SegundosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegundosTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(SegundosTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 50, 65));

        BorrarBoton.setIcon(new javax.swing.ImageIcon("C:\\Users\\jxdga\\Documents\\GitHub\\programa2Futoshiki\\programa2Futoshiki\\src\\main\\java\\com\\mycompany\\programa2futoshiki\\borrador.jpg")); // NOI18N
        BorrarBoton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BorrarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(BorrarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, -1, 40));

        jLabel2.setText("JUGADOR:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 6, -1, 38));

        NombreJugador.setEditable(false);
        NombreJugador.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NombreJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NombreJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreJugadorActionPerformed(evt);
            }
        });
        getContentPane().add(NombreJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 6, 193, 38));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 810, -1, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 27, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 833, -1, -1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 20, -1));

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

    private void Boton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton1ActionPerformed
        AsignarNum(PuntoX, PuntoY, 1);
    }//GEN-LAST:event_Boton1ActionPerformed

    private void Boton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton2ActionPerformed
        AsignarNum(PuntoX, PuntoY, 2);
    }//GEN-LAST:event_Boton2ActionPerformed

    private void Boton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton3ActionPerformed
        AsignarNum(PuntoX, PuntoY, 3);
    }//GEN-LAST:event_Boton3ActionPerformed

    private void BotonCargarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonCargarJuegoActionPerformed
        cargarTiempo();
        int[][] matrizNumeroCargada = ArchivosXML.cargarMatrizNumeros();
        String[][] matrizSimbolosCargada = ArchivosXML.cargarMatrizSimbolos();
        jugar=true;
        for (int i = 0; i < texto.length; i++) {
            for (int j = 0; j < texto[i].length; j++) {
                if (texto[i][j]!=null){
                    texto[i][j].setText("");
                }
            }
        }
        for (int i = 0; i < matrizNumeroCargada.length; i++) {
            for (int j = 0; j < matrizNumeroCargada[i].length; j++) {
                AsignarNum(i, j, matrizNumeroCargada[i][j]);
            }
        }
        for (int i = 0; i < matrizSimbolosCargada.length; i++) {
            for (int j = 0; j < matrizSimbolosCargada[i].length; j++) {
                if (matrizSimbolosCargada[i][j]!=null){
                    matrizSimbolos[i][j]=matrizSimbolosCargada[i][j];
                    texto[i][j].setText(matrizSimbolos[i][j]);
                }
            }
        }
        //cargarTiempo();
        System.out.println("se cargo la partida guardada");
    }//GEN-LAST:event_BotonCargarJuegoActionPerformed

    private void MinutosTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinutosTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinutosTiempoActionPerformed

    private void SegundosTiempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SegundosTiempoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SegundosTiempoActionPerformed

    private void BotonIniciarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIniciarJuegoActionPerformed

    if(ModoTiempo !=2){  
        if(!timer.isRunning()){
           
           if(ModoTiempo ==0){
           
                //reiniciarTiempo();
                esCronometro = true;
                //tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
                timer.start();   
           
           
           }else if(ModoTiempo==1){
               
                esCronometro = false;

                
                HorasTiempo.setText(String.format("%2d", horas));
                MinutosTiempo.setText(String.format("%2d", minutos));
                SegundosTiempo.setText(String.format("%02d", segundos));
           }
           
           //tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
           timer.start();
                       
        }else{
        
            detenerTiempo("Tiempo detenido.");
        }
        jugar=true;
        
        for (int i = 0; i < texto.length; i++) {
            for (int j = 0; j < texto[i].length; j++) {
                if (texto[i][j] != null) {
                    texto[i][j].setText(""); // Limpia el texto anterior

                    // Verifica si el índice j está dentro de los límites de la fila i en matrizSimbolos
                    if (j < matrizSimbolos[i].length && matrizSimbolos[i][j] != null) {
                        if (matrizSimbolos[i][j].equals(">")) {
                            texto[i][j].setText(">");
                            System.out.println("Texto "+i+", "+j+" = >");
                        } else if (matrizSimbolos[i][j].equals("<")) {
                            texto[i][j].setText("<");
                            System.out.println("Texto "+i+", "+j+" = <");
                        }
                    }
                }
            }
        }

    }else{
    
        jugar=true;
        
        for (int i = 0; i < texto.length; i++) {
            for (int j = 0; j < texto[i].length; j++) {
                if (texto[i][j] != null) {
                    texto[i][j].setText(""); // Limpia el texto anterior

                    // Verifica si el índice j está dentro de los límites de la fila i en matrizSimbolos
                    if (j < matrizSimbolos[i].length && matrizSimbolos[i][j] != null) {
                        if (matrizSimbolos[i][j].equals(">")) {
                            texto[i][j].setText(">");
                            System.out.println("Texto "+i+", "+j+" = >");
                        } else if (matrizSimbolos[i][j].equals("<")) {
                            texto[i][j].setText("<");
                            System.out.println("Texto "+i+", "+j+" = <");
                        }
                    }
                }
            }
        }


    }
    
        String juego="Juego3x3";
        System.out.println(Dificultad);
        if (Dificultad=="Fácil"){
            juego+="F";
        }else if(Dificultad=="Intermedio"){
            juego+="M";
        }else{
            juego+="D";
        }
        try{
            System.out.println(juego);
            String [][] matrizSimbolosCargada=ArchivosXML.cargarMatrizSimbolos2(juego+".xml");
            for (int i = 0; i < matrizSimbolosCargada.length; i++) {
                for (int j = 0; j < matrizSimbolosCargada[i].length; j++) {
                    if (matrizSimbolosCargada[i][j]!=null){
                        if (matrizSimbolosCargada[i][j].equals(">")) {
                            texto[i][j].setText(">");
                            matrizSimbolos[i][j]=matrizSimbolosCargada[i][j];
                        } else if (matrizSimbolosCargada[i][j].equals("<")) {
                            texto[i][j].setText("<");
                            matrizSimbolos[i][j]=matrizSimbolosCargada[i][j];
                        }
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }//GEN-LAST:event_BotonIniciarJuegoActionPerformed

    private void BorrarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrarBotonActionPerformed
        AsignarNum(PuntoX, PuntoY, 0);
    }//GEN-LAST:event_BorrarBotonActionPerformed

    private void BotonRehacerJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRehacerJugadaActionPerformed
        if (!jugadas.isEmpty()) {}
            Jugada jugadaAnterior=jugadas.get(jugadas.size()-1);
            int cordX=jugadaAnterior.getCordX();
            int cordY=jugadaAnterior.getCordY();
            int num=jugadaAnterior.getNum();
            jugadas.remove(jugadas.size() - 1);
            botones[cordX][cordY].setText(""+num);
            if (num==0){
            botones[cordX][cordY].setText("");
            matrizNumeros[cordX][cordY]=num;
            }
            boolean esta=verificarMatriz(matrizNumeros,cordX,cordY,num);
            if (esta==false){
                matrizNumeros[cordX][cordY]=num;
                botones[cordX][cordY].setForeground(Color.GREEN);
            }
            else{
                botones[cordX][cordY].setForeground(Color.RED);
            }
    }//GEN-LAST:event_BotonRehacerJugadaActionPerformed

    private void BotonBorrarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarJuegoActionPerformed
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
        int size = matrizNumeros.length;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                botones[j][i].setText("");
            }
        }
        imprimirMatriz(matrizNumeros);
    }//GEN-LAST:event_BotonBorrarJuegoActionPerformed

    private void BotonBorrarJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarJugadaActionPerformed
        int cordX=ultimaJugada.getCordX();
            int cordY=ultimaJugada.getCordY();
            int num=ultimaJugada.getNum();
            botones[cordX][cordY].setText(""+num);
            if (num==0){
            botones[cordX][cordY].setText("");
            matrizNumeros[cordX][cordY]=num;
            }
            boolean esta=verificarMatriz(matrizNumeros,cordX,cordY,num);
            if (esta==false){
                matrizNumeros[cordX][cordY]=num;
                botones[cordX][cordY].setForeground(Color.GREEN);
            }
            else{
                botones[cordX][cordY].setForeground(Color.RED);
            }
    }//GEN-LAST:event_BotonBorrarJugadaActionPerformed

    private void BotonTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTerminarJuegoActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotonTerminarJuegoActionPerformed

    private void BotonGuardarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarJuegoActionPerformed
        ArchivosXML.guardarEnXML(matrizNumeros,matrizSimbolos,horas,minutos,segundos,tempHora,tempMins,tempSeg,tiempoTranscurridoSegundos);  
    }//GEN-LAST:event_BotonGuardarJuegoActionPerformed

    private void NombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreJugadorActionPerformed
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_NombreJugadorActionPerformed

    public void AsignarNum(int fila, int columna, int num) {
        if (jugar){
            int numAnterior=0;
            if (botones[fila][columna].getText()!=""){
            numAnterior=Integer.parseInt(botones[fila][columna].getText());
            }
            Jugada jugadaAnterior=new Jugada(fila,columna,numAnterior);
            ultimaJugada=new Jugada(fila,columna,numAnterior);
            jugadas.add(jugadaAnterior);
        botones[fila][columna].setText(""+num); // Cambiar texto del botón
        if (num==0){
            botones[fila][columna].setText("");
            matrizNumeros[fila][columna]=num;
        }
        boolean esta=verificarMatriz(matrizNumeros,fila,columna,num);
        boolean esta2=verificarMatriz2(matrizNumeros,fila,columna,num);
        if (esta==false && esta2==false){
            matrizNumeros[fila][columna]=num;
            botones[fila][columna].setForeground(Color.GREEN);
        }
        else{
            botones[fila][columna].setForeground(Color.RED);
        }
        boolean finJuego=juegoTerminado(matrizNumeros);
        if (finJuego){
            JOptionPane.showMessageDialog(null, "Juego Terminado");
            if (Multinivel==0){
                new MenuPrincipal().setVisible(true);
                this.dispose();
            }else{
                if (Dificultad=="Facil"){
                    new Frame3x3("Intermedio",Multinivel,ModoTiempo,Posicion,NombreJugador.getText(),usuario2,horas,minutos,segundos).setVisible(true);
                }else if(Dificultad=="Intermedio"){
                    new Frame3x3("Dificil",Multinivel,ModoTiempo,Posicion,NombreJugador.getText(),usuario2,horas,minutos,segundos).setVisible(true);
                }else{
                    new MenuPrincipal().setVisible(true);
                    this.dispose();
                }
            }
        }
        
        }
        
    }
    
    public boolean verificarMatriz(int[][] matriz,int fila, int columna,int numero){
        int size = matriz.length;
        
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
    public boolean verificarMatriz2(int[][] matriz, int fila, int columna, int numero) {
    boolean error = false;
    
    if (columna >= 0 && columna+1 < 3 && !matrizSimbolos[fila * 2][columna].equals("")) {
        String simbolo = matrizSimbolos[fila*2][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila][columna + 1] < numero) {
                error = true;
            }
        } else {
            if (matrizNumeros[fila][columna + 1] > 0 && matrizNumeros[fila][columna + 1] > numero) {
                error = true;
            }
        }
    }
    
    if (columna-1 >= 0 && !matrizSimbolos[fila * 2][columna - 1].equals("")) {
        String simbolo = matrizSimbolos[fila*2][columna - 1];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila*2-1][columna - 1] > numero) {
                error = true;
            }
        } else {
            if (matrizNumeros[fila][columna - 1] > 0 && matrizNumeros[fila][columna - 1] < numero) {
                error = true;
            }
        }
    }
    
    if (fila*2-1 >= 0 && !matrizSimbolos[(fila * 2-1)][columna].equals("")) {
        String simbolo = matrizSimbolos[(fila * 2 - 1)][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila * 2 - 1][columna] > numero) {
                error = true;
            }
        } else {
            if (matrizNumeros[fila * 2 - 1][columna] > 0 && matrizNumeros[fila * 2 - 1][columna] < numero) {
                error = true;
            }
        }
    }

    if (fila*2+1 >= 0 && fila*2+1 < 5 && !matrizSimbolos[fila * 2+1][columna].equals("")) {
        String simbolo = matrizSimbolos[fila * 2+1][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila * 2 + 1][columna] < numero) {
                error = true;
            }
        } else {
            if (matrizNumeros[fila * 2 + 1][columna] > 0 && matrizNumeros[fila * 2 + 1][columna] > numero) {
                error = true;
            }
        }
    }

    return error;
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
    public void imprimirMatriz2(String[][] matriz){
        int filas = matriz.length;
        int columnas = matriz[0].length;
        String linea;
        for (int j = 0; j < filas; j++) {
            linea = "(";
            for (int i = 0; i < columnas; i++) {
                linea += matriz[j][i] + ",";
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
        
        int resultado = JOptionPane.showConfirmDialog(null, "Seguir Jugando?", "Fin del Juego", JOptionPane.YES_NO_OPTION);
        
        if(resultado == JOptionPane.YES_OPTION){
        
            if(ModoTiempo==1){
                
                horas = tiempoTranscurridoSegundos / 3600;
                minutos = (tiempoTranscurridoSegundos % 3600) / 60;
                segundos = tiempoTranscurridoSegundos % 60;
                
                ModoTiempo=0;
                //timer.start();
                ValidoTop = false;
            
            
            }else{
            
                 //timer.start();
                 ModoTiempo=3;
                 ValidoTop = false;
            }
        }else{
            ValidoTop = false;
            setVisible(false);
        }    
    }
    
    public void determinarTiempo(){
    
        if(ModoTiempo==0){
        
            esCronometro = true;
            
        }else if(ModoTiempo==1){
        
            esCronometro = false;
        }
        // Falta opcion para no activar el cronometro
    }

    /**
     * @param args the command line arguments
     */
    
    public int generarNumeroAleatorio() {
    return (int) (Math.random() * 3) + 1;
    }
    
    public void cargarTiempo(){
        
        int [] valores = archivoXML.restaurarValoresTiempo();
        
        if (valores != null){
            horas = valores[0];
            minutos = valores[1];
            segundos = valores[2];
            tiempoTranscurridoSegundos = valores[3];
            tempHora = valores[4];
            tempMins = valores[5];
            tempSeg = valores[6];

        }else{
            System.out.println("Error al restaurar los valores desde el archivo XML.");
        }
    
    }    
    
    public boolean juegoTerminado(int[][] matriz){
        boolean fin=true;
        int size = matriz.length;
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                if (botones[j][i].getForeground().equals(Color.RED) || botones[j][i].getText().equals("")){
                    fin=false;
                }
            }
        }
        return fin;
    }
    
    
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
            java.util.logging.Logger.getLogger(Frame3x3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame3x3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame3x3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame3x3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Frame10x10().setVisible(true);  
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BorrarBoton;
    private javax.swing.JButton Boton0_0;
    private javax.swing.JButton Boton0_1;
    private javax.swing.JButton Boton0_2;
    private javax.swing.JButton Boton1;
    private javax.swing.JButton Boton1_0;
    private javax.swing.JButton Boton1_1;
    private javax.swing.JButton Boton1_2;
    private javax.swing.JButton Boton2;
    private javax.swing.JButton Boton2_0;
    private javax.swing.JButton Boton2_1;
    private javax.swing.JButton Boton2_2;
    private javax.swing.JButton Boton3;
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
    private javax.swing.JLabel Texto1_0;
    private javax.swing.JLabel Texto1_1;
    private javax.swing.JLabel Texto1_2;
    private javax.swing.JLabel Texto2_0;
    private javax.swing.JLabel Texto2_1;
    private javax.swing.JLabel Texto3_0;
    private javax.swing.JLabel Texto3_1;
    private javax.swing.JLabel Texto3_2;
    private javax.swing.JLabel Texto4_0;
    private javax.swing.JLabel Texto4_1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
