/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Controlador.AjustesTop10;
import Modelo.ArchivosXML;
import Controlador.Jugada;
import Modelo.Usuario;
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
 * Este frame está encargado de un juego de Futoshiki de tamaño 8x8.
 * Todos los botones y funciones están contenidos en este frame.
 * La configuración depende de otra clase.
 *
 * @author Joshua
 */
public class Frame8x8 extends javax.swing.JFrame {
    
    ArchivosXML archivoXML = new ArchivosXML();
    MenuTop10 menuTop = new MenuTop10();
    
    
    private Timer timer;
    private boolean ValidoTop = true;
    private int horas, minutos, segundos;
    private int tiempoTranscurridoSegundos;
    private int ModoTiempo = 0;
    private boolean esCronometro = true;
    private String Dificultad;
    private int Multinivel;
    private String Posicion;
    private Usuario usuario2;
    private String Nombre;
    private String TamTablero ="8x8";
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
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0}
    };
    String [][] matrizSimbolos={
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""},
        {"","","","","","","",""},
        {"","","","","","",""}
    };
    
    /**
     * Creates new form Frame10x10
     */
    
    /**
     *
     * @param dificultad  Facil, Intermedio, Dificil
     * @param multinivel  0 = No , 1 = Si
     * @param usoreloj 0 = Cronometro, 1 = Temporizador 2 = No reloj
     * @param posicion 0 = Izquierda , 1 = Derecha
     * @param nombre Nombre de usuario
     * @param usuario Objecto de usuario
     * @param Horas Horas seleccionadas
     * @param Minutos Minutos seleccionados
     * @param Segundos Segundos seleccionados
     * @param SegundosTranscurridos Segundos totales
     */
    public Frame8x8(String dificultad, int multinivel, int usoreloj, String posicion, String nombre, Usuario usuario, int Horas, int Minutos, int Segundos, int SegundosTranscurridos) {
        initComponents();
        inicializarBotones();
        inicializarTexto();
        setLocationRelativeTo(null);
        
        tiempoTranscurridoSegundos = SegundosTranscurridos;
        Nombre = nombre;
        NombreJugador.setText(nombre);
        horas = Horas; 
        minutos = Minutos;
        segundos = Segundos;
        ModoTiempo = usoreloj;
        Dificultad = dificultad;
        Multinivel = multinivel;
        Posicion = posicion;
        usuario2 = usuario;

        // Manejo de tiempo
        timer = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                
                tiempoTranscurridoSegundos++; // Esto se usa para el calculo del tiempo total en ambos modos

                if(esCronometro){ // Cronometro
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

                    // Validacion del cronometro, revisar si se alcanzado el limite de tiempo
                    
                    if(tempMins == minutos && tempSeg == segundos){
                        detenerTiempo("Se ha acabado el tiempo del cronómetro.");
                    }

                }else{ // Temporizador
                    
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

                // Actualizar el label de tiempo para ambos modos
                if(ModoTiempo==1){
                    
                    HorasTiempo.setText(String.format("%2d", horas));
                    MinutosTiempo.setText(String.format("%2d", minutos));
                    SegundosTiempo.setText(String.format("%02d", segundos));
                }else if(ModoTiempo==0){
                    
                    HorasTiempo.setText(String.format("%2d", tempHora));
                    MinutosTiempo.setText(String.format("%2d", tempMins));
                    SegundosTiempo.setText(String.format("%02d", tempSeg));       
                }else{ // Actualizacion en modo no reloj
                
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
        botones[0][3] = Boton0_3;
        botones[0][4] = Boton0_4;
        botones[0][5] = Boton0_5;
        botones[0][6] = Boton0_6;
        botones[0][7] = Boton0_7;

        botones[1][0] = Boton1_0;
        botones[1][1] = Boton1_1;
        botones[1][2] = Boton1_2;
        botones[1][3] = Boton1_3;
        botones[1][4] = Boton1_4;
        botones[1][5] = Boton1_5;
        botones[1][6] = Boton1_6;
        botones[1][7] = Boton1_7;
        
        botones[2][0] = Boton2_0;
        botones[2][1] = Boton2_1;
        botones[2][2] = Boton2_2;
        botones[2][3] = Boton2_3;
        botones[2][4] = Boton2_4;
        botones[2][5] = Boton2_5;
        botones[2][6] = Boton2_6;
        botones[2][7] = Boton2_7;
        
        botones[3][0] = Boton3_0;
        botones[3][1] = Boton3_1;
        botones[3][2] = Boton3_2;
        botones[3][3] = Boton3_3;
        botones[3][4] = Boton3_4;
        botones[3][5] = Boton3_5;
        botones[3][6] = Boton3_6;
        botones[3][7] = Boton3_7;
        
        botones[4][0] = Boton4_0;
        botones[4][1] = Boton4_1;
        botones[4][2] = Boton4_2;
        botones[4][3] = Boton4_3;
        botones[4][4] = Boton4_4;
        botones[4][5] = Boton4_5;
        botones[4][6] = Boton4_6;
        botones[4][7] = Boton4_7;
        
        botones[5][0] = Boton5_0;
        botones[5][1] = Boton5_1;
        botones[5][2] = Boton5_2;
        botones[5][3] = Boton5_3;
        botones[5][4] = Boton5_4;
        botones[5][5] = Boton5_5;
        botones[5][6] = Boton5_6;
        botones[5][7] = Boton5_7;
        
        botones[6][0] = Boton6_0;
        botones[6][1] = Boton6_1;
        botones[6][2] = Boton6_2;
        botones[6][3] = Boton6_3;
        botones[6][4] = Boton6_4;
        botones[6][5] = Boton6_5;
        botones[6][6] = Boton6_6;
        botones[6][7] = Boton6_7;
        
        botones[7][0] = Boton7_0;
        botones[7][1] = Boton7_1;
        botones[7][2] = Boton7_2;
        botones[7][3] = Boton7_3;
        botones[7][4] = Boton7_4;
        botones[7][5] = Boton7_5;
        botones[7][6] = Boton7_6;
        botones[7][7] = Boton7_7;
    }
    
    private void inicializarTexto(){
        texto = new JLabel[19][10]; // Creamos la matriz de 10x10

        texto[0][0] = Texto0_0;
    texto[0][1] = Texto0_1;
    texto[0][2] = Texto0_2;
    texto[0][3] = Texto0_3;
    texto[0][4] = Texto0_4;
    texto[0][5] = Texto0_5;
    texto[0][6] = Texto0_6;

    texto[1][0] = Texto1_0;
    texto[1][1] = Texto1_1;
    texto[1][2] = Texto1_2;
    texto[1][3] = Texto1_3;
    texto[1][4] = Texto1_4;
    texto[1][5] = Texto1_5;
    texto[1][6] = Texto1_6;
    texto[1][7] = Texto1_7;

    texto[2][0] = Texto2_0;
    texto[2][1] = Texto2_1;
    texto[2][2] = Texto2_2;
    texto[2][3] = Texto2_3;
    texto[2][4] = Texto2_4;
    texto[2][5] = Texto2_5;
    texto[2][6] = Texto2_6;

    texto[3][0] = Texto3_0;
    texto[3][1] = Texto3_1;
    texto[3][2] = Texto3_2;
    texto[3][3] = Texto3_3;
    texto[3][4] = Texto3_4;
    texto[3][5] = Texto3_5;
    texto[3][6] = Texto3_6;
    texto[3][7] = Texto3_7;
    
    texto[4][0] = Texto4_0;
    texto[4][1] = Texto4_1;
    texto[4][2] = Texto4_2;
    texto[4][3] = Texto4_3;
    texto[4][4] = Texto4_4;
    texto[4][5] = Texto4_5;
    texto[4][6] = Texto4_6;

    texto[5][0] = Texto5_0;
    texto[5][1] = Texto5_1;
    texto[5][2] = Texto5_2;
    texto[5][3] = Texto5_3;
    texto[5][4] = Texto5_4;
    texto[5][5] = Texto5_5;
    texto[5][6] = Texto5_6;
    texto[5][7] = Texto5_7;

    texto[6][0] = Texto6_0;
    texto[6][1] = Texto6_1;
    texto[6][2] = Texto6_2;
    texto[6][3] = Texto6_3;
    texto[6][4] = Texto6_4;
    texto[6][5] = Texto6_5;
    texto[6][6] = Texto6_6;

    texto[7][0] = Texto7_0;
    texto[7][1] = Texto7_1;
    texto[7][2] = Texto7_2;
    texto[7][3] = Texto7_3;
    texto[7][4] = Texto7_4;
    texto[7][5] = Texto7_5;
    texto[7][6] = Texto7_6;
    texto[7][7] = Texto7_7;

    texto[8][0] = Texto8_0;
    texto[8][1] = Texto8_1;
    texto[8][2] = Texto8_2;
    texto[8][3] = Texto8_3;
    texto[8][4] = Texto8_4;
    texto[8][5] = Texto8_5;
    texto[8][6] = Texto8_6;

    texto[9][0] = Texto9_0;
    texto[9][1] = Texto9_1;
    texto[9][2] = Texto9_2;
    texto[9][3] = Texto9_3;
    texto[9][4] = Texto9_4;
    texto[9][5] = Texto9_5;
    texto[9][6] = Texto9_6;
    texto[9][7] = Texto9_7;

    texto[10][0] = Texto10_0;
    texto[10][1] = Texto10_1;
    texto[10][2] = Texto10_2;
    texto[10][3] = Texto10_3;
    texto[10][4] = Texto10_4;
    texto[10][5] = Texto10_5;
    texto[10][6] = Texto10_6;

    texto[11][0] = Texto11_0;
    texto[11][1] = Texto11_1;
    texto[11][2] = Texto11_2;
    texto[11][3] = Texto11_3;
    texto[11][4] = Texto11_4;
    texto[11][5] = Texto11_5;
    texto[11][6] = Texto11_6;
    texto[11][7] = Texto11_7;

    texto[12][0] = Texto12_0;
    texto[12][1] = Texto12_1;
    texto[12][2] = Texto12_2;
    texto[12][3] = Texto12_3;
    texto[12][4] = Texto12_4;
    texto[12][5] = Texto12_5;
    texto[12][6] = Texto12_6;

    texto[13][0] = Texto13_0;
    texto[13][1] = Texto13_1;
    texto[13][2] = Texto13_2;
    texto[13][3] = Texto13_3;
    texto[13][4] = Texto13_4;
    texto[13][5] = Texto13_5;
    texto[13][6] = Texto13_6;
    texto[13][7] = Texto13_7;

    texto[14][0] = Texto14_0;
    texto[14][1] = Texto14_1;
    texto[14][2] = Texto14_2;
    texto[14][3] = Texto14_3;
    texto[14][4] = Texto14_4;
    texto[14][5] = Texto14_5;
    texto[14][6] = Texto14_6;
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
        Boton1_0 = new javax.swing.JButton();
        Boton1_1 = new javax.swing.JButton();
        Boton1_2 = new javax.swing.JButton();
        Boton1_3 = new javax.swing.JButton();
        Boton1_4 = new javax.swing.JButton();
        Boton1_5 = new javax.swing.JButton();
        Boton1_6 = new javax.swing.JButton();
        Boton1_7 = new javax.swing.JButton();
        Boton2_0 = new javax.swing.JButton();
        Boton2_1 = new javax.swing.JButton();
        Boton2_2 = new javax.swing.JButton();
        Boton2_3 = new javax.swing.JButton();
        Boton2_4 = new javax.swing.JButton();
        Boton2_5 = new javax.swing.JButton();
        Boton2_6 = new javax.swing.JButton();
        Boton2_7 = new javax.swing.JButton();
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
        Boton4_0 = new javax.swing.JButton();
        Boton4_1 = new javax.swing.JButton();
        Boton4_2 = new javax.swing.JButton();
        Boton4_3 = new javax.swing.JButton();
        Boton4_4 = new javax.swing.JButton();
        Boton4_5 = new javax.swing.JButton();
        Boton4_6 = new javax.swing.JButton();
        Boton4_7 = new javax.swing.JButton();
        Boton5_0 = new javax.swing.JButton();
        Boton5_1 = new javax.swing.JButton();
        Boton5_2 = new javax.swing.JButton();
        Boton5_3 = new javax.swing.JButton();
        Boton5_4 = new javax.swing.JButton();
        Boton5_5 = new javax.swing.JButton();
        Boton5_6 = new javax.swing.JButton();
        Boton5_7 = new javax.swing.JButton();
        Boton6_0 = new javax.swing.JButton();
        Boton6_1 = new javax.swing.JButton();
        Boton6_2 = new javax.swing.JButton();
        Boton6_3 = new javax.swing.JButton();
        Boton6_4 = new javax.swing.JButton();
        Boton6_5 = new javax.swing.JButton();
        Boton6_6 = new javax.swing.JButton();
        Boton6_7 = new javax.swing.JButton();
        Boton7_0 = new javax.swing.JButton();
        Texto0_0 = new javax.swing.JLabel();
        Texto0_1 = new javax.swing.JLabel();
        Texto0_2 = new javax.swing.JLabel();
        Texto0_3 = new javax.swing.JLabel();
        Texto0_4 = new javax.swing.JLabel();
        Texto0_5 = new javax.swing.JLabel();
        Texto0_6 = new javax.swing.JLabel();
        Texto1_0 = new javax.swing.JLabel();
        Texto1_1 = new javax.swing.JLabel();
        Texto1_2 = new javax.swing.JLabel();
        Texto1_3 = new javax.swing.JLabel();
        Texto1_4 = new javax.swing.JLabel();
        Texto1_5 = new javax.swing.JLabel();
        Texto1_6 = new javax.swing.JLabel();
        Texto1_7 = new javax.swing.JLabel();
        Texto2_0 = new javax.swing.JLabel();
        Texto2_1 = new javax.swing.JLabel();
        Texto2_2 = new javax.swing.JLabel();
        Texto2_3 = new javax.swing.JLabel();
        Texto2_4 = new javax.swing.JLabel();
        Texto2_5 = new javax.swing.JLabel();
        Texto2_6 = new javax.swing.JLabel();
        Texto3_0 = new javax.swing.JLabel();
        Texto3_1 = new javax.swing.JLabel();
        Texto3_2 = new javax.swing.JLabel();
        Texto3_3 = new javax.swing.JLabel();
        Texto3_4 = new javax.swing.JLabel();
        Texto3_5 = new javax.swing.JLabel();
        Texto3_6 = new javax.swing.JLabel();
        Texto3_7 = new javax.swing.JLabel();
        Texto4_0 = new javax.swing.JLabel();
        Texto4_1 = new javax.swing.JLabel();
        Texto4_2 = new javax.swing.JLabel();
        Texto4_3 = new javax.swing.JLabel();
        Texto4_4 = new javax.swing.JLabel();
        Texto4_5 = new javax.swing.JLabel();
        Texto4_6 = new javax.swing.JLabel();
        Texto5_0 = new javax.swing.JLabel();
        Texto5_1 = new javax.swing.JLabel();
        Texto5_2 = new javax.swing.JLabel();
        Texto5_3 = new javax.swing.JLabel();
        Texto5_4 = new javax.swing.JLabel();
        Texto5_5 = new javax.swing.JLabel();
        Texto5_6 = new javax.swing.JLabel();
        Texto5_7 = new javax.swing.JLabel();
        Texto6_0 = new javax.swing.JLabel();
        Texto6_1 = new javax.swing.JLabel();
        Texto6_2 = new javax.swing.JLabel();
        Texto6_3 = new javax.swing.JLabel();
        Texto6_4 = new javax.swing.JLabel();
        Texto6_5 = new javax.swing.JLabel();
        Texto6_6 = new javax.swing.JLabel();
        Texto7_0 = new javax.swing.JLabel();
        Texto7_1 = new javax.swing.JLabel();
        Texto7_2 = new javax.swing.JLabel();
        Texto7_3 = new javax.swing.JLabel();
        Texto7_4 = new javax.swing.JLabel();
        Texto7_5 = new javax.swing.JLabel();
        Texto7_6 = new javax.swing.JLabel();
        Texto7_7 = new javax.swing.JLabel();
        Texto9_0 = new javax.swing.JLabel();
        Texto9_1 = new javax.swing.JLabel();
        Texto9_2 = new javax.swing.JLabel();
        Texto9_3 = new javax.swing.JLabel();
        Texto9_4 = new javax.swing.JLabel();
        Texto9_5 = new javax.swing.JLabel();
        Texto9_6 = new javax.swing.JLabel();
        Texto9_7 = new javax.swing.JLabel();
        Boton7_1 = new javax.swing.JButton();
        Boton7_2 = new javax.swing.JButton();
        Boton7_3 = new javax.swing.JButton();
        Boton7_4 = new javax.swing.JButton();
        Boton7_5 = new javax.swing.JButton();
        Boton7_6 = new javax.swing.JButton();
        Boton7_7 = new javax.swing.JButton();
        Texto11_0 = new javax.swing.JLabel();
        Texto11_1 = new javax.swing.JLabel();
        Texto11_2 = new javax.swing.JLabel();
        Texto11_3 = new javax.swing.JLabel();
        Texto11_4 = new javax.swing.JLabel();
        Texto11_5 = new javax.swing.JLabel();
        Texto11_6 = new javax.swing.JLabel();
        Texto11_7 = new javax.swing.JLabel();
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
        Texto8_0 = new javax.swing.JLabel();
        Texto8_1 = new javax.swing.JLabel();
        Texto8_2 = new javax.swing.JLabel();
        Texto8_3 = new javax.swing.JLabel();
        Texto8_4 = new javax.swing.JLabel();
        Texto8_5 = new javax.swing.JLabel();
        Texto8_6 = new javax.swing.JLabel();
        Texto10_0 = new javax.swing.JLabel();
        Texto10_1 = new javax.swing.JLabel();
        Texto10_2 = new javax.swing.JLabel();
        Texto10_3 = new javax.swing.JLabel();
        Texto10_4 = new javax.swing.JLabel();
        Texto10_5 = new javax.swing.JLabel();
        Texto10_6 = new javax.swing.JLabel();
        Texto12_0 = new javax.swing.JLabel();
        Texto12_1 = new javax.swing.JLabel();
        Texto12_2 = new javax.swing.JLabel();
        Texto12_3 = new javax.swing.JLabel();
        Texto12_4 = new javax.swing.JLabel();
        Texto12_5 = new javax.swing.JLabel();
        Texto12_6 = new javax.swing.JLabel();
        Texto14_0 = new javax.swing.JLabel();
        Texto14_1 = new javax.swing.JLabel();
        Texto14_2 = new javax.swing.JLabel();
        Texto14_3 = new javax.swing.JLabel();
        Texto14_4 = new javax.swing.JLabel();
        Texto14_5 = new javax.swing.JLabel();
        Texto14_6 = new javax.swing.JLabel();
        Boton8 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BotonIniciarJuego = new javax.swing.JButton();
        BotonGuardarJuego = new javax.swing.JButton();
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
        BotonBorrarJugada = new javax.swing.JButton();
        BotonRehacerJugada = new javax.swing.JButton();
        BotonBorrarJuego = new javax.swing.JButton();
        NivelDificultad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Boton0_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 70, 40, 40));

        Boton0_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 40, 40));

        Boton0_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, 40, 40));

        Boton0_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 40, 40));

        Boton0_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 70, 40, 40));

        Boton0_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 40, 40));

        Boton0_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, 40, 40));

        Boton0_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton0_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton0_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton0_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton0_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 70, 40, 40));

        Boton1_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 40, 40));

        Boton1_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 40, 40));

        Boton1_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 40, 40));

        Boton1_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 40, 40));

        Boton1_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 140, 40, 40));

        Boton1_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, 40, 40));

        Boton1_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, 40, 40));

        Boton1_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton1_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 140, 40, 40));

        Boton2_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 40, 40));

        Boton2_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 40, 40));

        Boton2_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 40, 40));

        Boton2_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 40, 40));

        Boton2_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 210, 40, 40));

        Boton2_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 40, 40));

        Boton2_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 210, 40, 40));

        Boton2_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton2_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 210, 40, 40));

        Boton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton1.setText("(1)");
        Boton1.setAlignmentY(0.0F);
        Boton1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, 40, 40));

        Boton2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton2.setText("(2)");
        Boton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 140, 40, 40));

        Boton3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton3.setText("(3)");
        Boton3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 210, 40, 40));

        Boton3_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 290, 40, 40));

        Boton3_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 40, 40));

        Boton3_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 290, 40, 40));

        Boton3_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 40, 40));

        Boton3_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 40, 40));

        Boton3_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 40, 40));

        Boton3_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 40, 40));

        Boton3_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton3_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton3_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton3_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 290, 40, 40));

        Boton4_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 40, 40));

        Boton4_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 360, 40, 40));

        Boton4_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 40, 40));

        Boton4_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 360, 40, 40));

        Boton4_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 360, 40, 40));

        Boton4_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 360, 40, 40));

        Boton4_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 360, 40, 40));

        Boton4_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton4_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 360, 40, 40));

        Boton5_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 430, 40, 40));

        Boton5_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 40, 40));

        Boton5_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, 40, 40));

        Boton5_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 40, 40));

        Boton5_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 430, 40, 40));

        Boton5_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, 40, 40));

        Boton5_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 40, 40));

        Boton5_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton5_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 430, 40, 40));

        Boton6_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 40, 40));

        Boton6_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 40, 40));

        Boton6_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 40, 40));

        Boton6_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 500, 40, 40));

        Boton6_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 500, 40, 40));

        Boton6_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 500, 40, 40));

        Boton6_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 40, 40));

        Boton6_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton6_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 500, 40, 40));

        Boton7_0.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_0.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_0ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 570, 40, 40));

        Texto0_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_0.setText(">");
        getContentPane().add(Texto0_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, 40));

        Texto0_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_1.setText(">");
        getContentPane().add(Texto0_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 40));

        Texto0_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_2.setText(">");
        getContentPane().add(Texto0_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, -1, 40));

        Texto0_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_3.setText(">");
        getContentPane().add(Texto0_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 70, -1, 40));

        Texto0_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_4.setText(">");
        getContentPane().add(Texto0_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, -1, 40));

        Texto0_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_5.setText(">");
        getContentPane().add(Texto0_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, -1, 40));

        Texto0_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto0_6.setText(">");
        getContentPane().add(Texto0_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, -1, 40));

        Texto1_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_0.setText(" ^");
        Texto1_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 40, 25));

        Texto1_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_1.setText(" ^");
        Texto1_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 120, 40, 25));

        Texto1_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_2.setText(" ^");
        Texto1_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 40, 25));

        Texto1_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_3.setText(" ^");
        Texto1_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 40, 25));

        Texto1_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_4.setText(" ^");
        Texto1_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 120, 40, 25));

        Texto1_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_5.setText(" ^");
        Texto1_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 40, 25));

        Texto1_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_6.setText(" ^");
        Texto1_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 120, 40, 25));

        Texto1_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto1_7.setText(" ^");
        Texto1_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto1_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 120, 40, 25));

        Texto2_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_0.setText(">");
        getContentPane().add(Texto2_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, 40));

        Texto2_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_1.setText(">");
        getContentPane().add(Texto2_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, 40));

        Texto2_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_2.setText(">");
        getContentPane().add(Texto2_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 140, -1, 40));

        Texto2_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_3.setText(">");
        getContentPane().add(Texto2_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 140, -1, 40));

        Texto2_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_4.setText(">");
        getContentPane().add(Texto2_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, 40));

        Texto2_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_5.setText(">");
        getContentPane().add(Texto2_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, 40));

        Texto2_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto2_6.setText(">");
        getContentPane().add(Texto2_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, 40));

        Texto3_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_0.setText(" ^");
        Texto3_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 40, 25));

        Texto3_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_1.setText(" ^");
        Texto3_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 40, 25));

        Texto3_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_2.setText(" ^");
        Texto3_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 40, 25));

        Texto3_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_3.setText(" ^");
        Texto3_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 40, 25));

        Texto3_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_4.setText(" ^");
        Texto3_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 40, 25));

        Texto3_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_5.setText(" ^");
        Texto3_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 40, 25));

        Texto3_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_6.setText(" ^");
        Texto3_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 190, 40, 25));

        Texto3_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto3_7.setText(" ^");
        Texto3_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto3_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 40, 25));

        Texto4_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_0.setText(">");
        getContentPane().add(Texto4_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, 40));

        Texto4_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_1.setText(">");
        getContentPane().add(Texto4_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, 40));

        Texto4_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_2.setText(">");
        getContentPane().add(Texto4_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, -1, 40));

        Texto4_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_3.setText(">");
        getContentPane().add(Texto4_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, 40));

        Texto4_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_4.setText(">");
        getContentPane().add(Texto4_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, -1, 40));

        Texto4_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_5.setText(">");
        getContentPane().add(Texto4_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 210, -1, 40));

        Texto4_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto4_6.setText(">");
        getContentPane().add(Texto4_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 210, -1, 40));

        Texto5_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_0.setText(" ^");
        Texto5_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 40, 25));

        Texto5_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_1.setText(" ^");
        Texto5_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, 40, 25));

        Texto5_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_2.setText(" ^");
        Texto5_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 40, 25));

        Texto5_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_3.setText(" ^");
        Texto5_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 40, 25));

        Texto5_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_4.setText(" ^");
        Texto5_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 40, 25));

        Texto5_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_5.setText(" ^");
        Texto5_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 260, 40, 25));

        Texto5_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_6.setText(" ^");
        Texto5_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 260, 40, 25));

        Texto5_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto5_7.setText(" ^");
        Texto5_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto5_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 40, 25));

        Texto6_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_0.setText(">");
        getContentPane().add(Texto6_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, 40));

        Texto6_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_1.setText(">");
        getContentPane().add(Texto6_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, 40));

        Texto6_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_2.setText(">");
        getContentPane().add(Texto6_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, -1, 40));

        Texto6_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_3.setText(">");
        getContentPane().add(Texto6_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, -1, 40));

        Texto6_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_4.setText(">");
        getContentPane().add(Texto6_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 290, -1, 40));

        Texto6_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_5.setText(">");
        getContentPane().add(Texto6_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 290, -1, 40));

        Texto6_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto6_6.setText(">");
        getContentPane().add(Texto6_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 290, -1, 40));

        Texto7_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_0.setText(" ^");
        Texto7_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, 40, 25));

        Texto7_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_1.setText(" ^");
        Texto7_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 40, 25));

        Texto7_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_2.setText(" ^");
        Texto7_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 40, 25));

        Texto7_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_3.setText(" ^");
        Texto7_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 330, 40, 25));

        Texto7_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_4.setText(" ^");
        Texto7_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 330, 40, 25));

        Texto7_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_5.setText(" ^");
        Texto7_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 330, 40, 25));

        Texto7_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_6.setText(" ^");
        Texto7_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 330, 40, 25));

        Texto7_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto7_7.setText(" ^");
        Texto7_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 330, 40, 25));

        Texto9_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_0.setText(" ^");
        Texto9_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 40, 25));

        Texto9_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_1.setText(" ^");
        Texto9_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 40, 25));

        Texto9_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_2.setText(" ^");
        Texto9_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 40, 25));

        Texto9_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_3.setText(" ^");
        Texto9_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 40, 25));

        Texto9_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_4.setText(" ^");
        Texto9_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 400, 40, 25));

        Texto9_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_5.setText(" ^");
        Texto9_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 400, 40, 25));

        Texto9_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_6.setText(" ^");
        Texto9_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 400, 40, 25));

        Texto9_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto9_7.setText(" ^");
        Texto9_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto9_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 400, 40, 25));

        Boton7_1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_1.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_1ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 570, 40, 40));

        Boton7_2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_2ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 40, 40));

        Boton7_3.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_3.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_3ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 570, 40, 40));

        Boton7_4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 570, 40, 40));

        Boton7_5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 570, 40, 40));

        Boton7_6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 570, 40, 40));

        Boton7_7.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Boton7_7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7_7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7_7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 570, 40, 40));

        Texto11_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_0.setText(" ^");
        Texto11_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 470, 40, 25));

        Texto11_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_1.setText(" ^");
        Texto11_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 40, 25));

        Texto11_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_2.setText(" ^");
        Texto11_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, 40, 25));

        Texto11_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_3.setText(" ^");
        Texto11_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 470, 40, 25));

        Texto11_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_4.setText(" ^");
        Texto11_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 470, 40, 25));

        Texto11_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_5.setText(" ^");
        Texto11_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 470, 40, 25));

        Texto11_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_6.setText(" ^");
        Texto11_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 470, 40, 25));

        Texto11_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto11_7.setText(" ^");
        Texto11_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto11_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 470, 40, 25));

        Boton4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton4.setText("(4)");
        Boton4.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton4ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 290, 40, 40));

        Boton5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton5.setText("(5)");
        Boton5.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton5ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 360, 40, 40));

        Boton6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton6.setText("(6)");
        Boton6.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton6ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 430, 40, 40));

        Boton7.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton7.setText("(7)");
        Boton7.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton7ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 40, 40));

        Texto13_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_0.setText(" ^");
        Texto13_0.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 550, 40, 25));

        Texto13_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_1.setText(" ^");
        Texto13_1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 40, 25));

        Texto13_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_2.setText(" ^");
        Texto13_2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 550, 40, 25));

        Texto13_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_3.setText(" ^");
        Texto13_3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 550, 40, 25));

        Texto13_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_4.setText(" ^");
        Texto13_4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 550, 40, 25));

        Texto13_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_5.setText(" ^");
        Texto13_5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 550, 40, 25));

        Texto13_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_6.setText(" ^");
        Texto13_6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 40, 25));

        Texto13_7.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto13_7.setText(" ^");
        Texto13_7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(Texto13_7, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 550, 40, 25));

        Texto8_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_0.setText(">");
        getContentPane().add(Texto8_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, 40));

        Texto8_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_1.setText(">");
        getContentPane().add(Texto8_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, -1, 40));

        Texto8_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_2.setText(">");
        getContentPane().add(Texto8_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 360, -1, 40));

        Texto8_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_3.setText(">");
        getContentPane().add(Texto8_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, -1, 40));

        Texto8_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_4.setText(">");
        getContentPane().add(Texto8_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 360, -1, 40));

        Texto8_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_5.setText(">");
        getContentPane().add(Texto8_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 360, -1, 40));

        Texto8_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto8_6.setText(">");
        getContentPane().add(Texto8_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 360, -1, 40));

        Texto10_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_0.setText(">");
        getContentPane().add(Texto10_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, -1, 40));

        Texto10_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_1.setText(">");
        getContentPane().add(Texto10_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 430, -1, 40));

        Texto10_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_2.setText(">");
        getContentPane().add(Texto10_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, -1, 40));

        Texto10_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_3.setText(">");
        getContentPane().add(Texto10_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 430, -1, 40));

        Texto10_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_4.setText(">");
        getContentPane().add(Texto10_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, -1, 40));

        Texto10_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_5.setText(">");
        getContentPane().add(Texto10_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, -1, 40));

        Texto10_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto10_6.setText(">");
        getContentPane().add(Texto10_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 430, -1, 40));

        Texto12_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_0.setText(">");
        getContentPane().add(Texto12_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 500, -1, 40));

        Texto12_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_1.setText(">");
        getContentPane().add(Texto12_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, 40));

        Texto12_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_2.setText(">");
        getContentPane().add(Texto12_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, -1, 40));

        Texto12_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_3.setText(">");
        getContentPane().add(Texto12_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, 40));

        Texto12_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_4.setText(">");
        getContentPane().add(Texto12_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 500, -1, 40));

        Texto12_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_5.setText(">");
        getContentPane().add(Texto12_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 500, -1, 40));

        Texto12_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto12_6.setText(">");
        getContentPane().add(Texto12_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 500, -1, 40));

        Texto14_0.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_0.setText(">");
        getContentPane().add(Texto14_0, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, -1, 40));

        Texto14_1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_1.setText(">");
        getContentPane().add(Texto14_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 570, -1, 40));

        Texto14_2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_2.setText(">");
        getContentPane().add(Texto14_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 570, -1, 40));

        Texto14_3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_3.setText(">");
        getContentPane().add(Texto14_3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 570, -1, 40));

        Texto14_4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_4.setText(">");
        getContentPane().add(Texto14_4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 570, -1, 40));

        Texto14_5.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_5.setText(">");
        getContentPane().add(Texto14_5, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 570, -1, 40));

        Texto14_6.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        Texto14_6.setText(">");
        getContentPane().add(Texto14_6, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 570, -1, 40));

        Boton8.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Boton8.setText("(8)");
        Boton8.setMargin(new java.awt.Insets(0, 0, 0, 0));
        Boton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton8ActionPerformed(evt);
            }
        });
        getContentPane().add(Boton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 570, 40, 40));

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
        getContentPane().add(BotonIniciarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 590, 158, 70));

        BotonGuardarJuego.setBackground(new java.awt.Color(51, 153, 0));
        BotonGuardarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonGuardarJuego.setText("GUARDAR JUEGO");
        BotonGuardarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonGuardarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonGuardarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 650, 158, 40));

        BotonCargarJuego.setBackground(new java.awt.Color(153, 51, 0));
        BotonCargarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonCargarJuego.setText("CARGAR JUEGO");
        BotonCargarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonCargarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonCargarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonCargarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 720, 158, 40));

        BotonTerminarJuego.setBackground(new java.awt.Color(255, 204, 51));
        BotonTerminarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonTerminarJuego.setText("TERMINAR JUEGO");
        BotonTerminarJuego.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonTerminarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonTerminarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonTerminarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 720, 158, 40));

        Horatexto.setEditable(false);
        Horatexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Horatexto.setText("Horas");
        getContentPane().add(Horatexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 49, -1));

        MinutosTexto.setEditable(false);
        MinutosTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinutosTexto.setText("Minutos");
        getContentPane().add(MinutosTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 670, 50, -1));

        SegundosTexto.setEditable(false);
        SegundosTexto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SegundosTexto.setText("Segundos");
        getContentPane().add(SegundosTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 670, -1, -1));

        HorasTiempo.setEditable(false);
        HorasTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(HorasTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 49, 65));

        MinutosTiempo.setEditable(false);
        MinutosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        MinutosTiempo.setAutoscrolls(false);
        MinutosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinutosTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(MinutosTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 700, 50, 65));

        SegundosTiempo.setEditable(false);
        SegundosTiempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        SegundosTiempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SegundosTiempoActionPerformed(evt);
            }
        });
        getContentPane().add(SegundosTiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 700, 50, 65));

        BorrarBoton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/programa2Futoshiki/borrador.jpg"))); // NOI18N
        BorrarBoton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BorrarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrarBotonActionPerformed(evt);
            }
        });
        getContentPane().add(BorrarBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, -1, 40));

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

        BotonBorrarJugada.setBackground(new java.awt.Color(0, 204, 204));
        BotonBorrarJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJugada.setText("BORRAR JUGADA");
        BotonBorrarJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonBorrarJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarJugadaActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBorrarJugada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, 158, 40));

        BotonRehacerJugada.setBackground(new java.awt.Color(255, 204, 51));
        BotonRehacerJugada.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonRehacerJugada.setText("REHACER JUGADA");
        BotonRehacerJugada.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BotonRehacerJugada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRehacerJugadaActionPerformed(evt);
            }
        });
        getContentPane().add(BotonRehacerJugada, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 720, 158, 40));

        BotonBorrarJuego.setBackground(new java.awt.Color(153, 153, 255));
        BotonBorrarJuego.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        BotonBorrarJuego.setText("BORRAR JUEGO");
        BotonBorrarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarJuegoActionPerformed(evt);
            }
        });
        getContentPane().add(BotonBorrarJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 650, 158, 40));

        NivelDificultad.setEditable(false);
        NivelDificultad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        NivelDificultad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NivelDificultad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NivelDificultadActionPerformed(evt);
            }
        });
        getContentPane().add(NivelDificultad, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 160, 38));

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

    private void Boton7_0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton7_0ActionPerformed
        PuntoX=7;
        PuntoY=0;
    }//GEN-LAST:event_Boton7_0ActionPerformed

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

    private void Boton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton8ActionPerformed
        AsignarNum(PuntoX, PuntoY, 8);
    }//GEN-LAST:event_Boton8ActionPerformed

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
        if(!timer.isRunning()){ // Si aun no se ha iniciado el reloj
           
           if(ModoTiempo ==0){ // Modo Cronometro
           
                //reiniciarTiempo();
                esCronometro = true;
                //tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
                timer.start();   
           
           
           }else if(ModoTiempo==1){ // Modo Temporizador
               
                esCronometro = false;

                // Actualizacion de los labels
                HorasTiempo.setText(String.format("%2d", horas));
                MinutosTiempo.setText(String.format("%2d", minutos));
                SegundosTiempo.setText(String.format("%02d", segundos));
           }
           
           //tiempoTranscurridoSegundos = 0; // Reiniciar tiempo transcurrido
           timer.start();
                       
        }else{ // Si el tiempo esta corriendo
        
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

    }else{ // Modo no reloj
    
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
    
        String juego="Juego8x8";
        System.out.println(Dificultad);
        NivelDificultad.setText("Nivel "+Dificultad);
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

    private void BotonTerminarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonTerminarJuegoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
            null,"¿ESTÁ SEGURO DE TERMINAR EL JUEGO? ","Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION){
            this.setVisible(false);
            //new Frame8x8(Dificultad,Multinivel,ModoTiempo,Posicion,NombreJugador.getText(),usuario2,horas,minutos,segundos,tiempoTranscurridoSegundos).setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BotonTerminarJuegoActionPerformed

    private void BotonGuardarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarJuegoActionPerformed
        ArchivosXML.guardarEnXML(matrizNumeros,matrizSimbolos,horas,minutos,segundos,tempHora,tempMins,tempSeg,tiempoTranscurridoSegundos,ValidoTop);  
    }//GEN-LAST:event_BotonGuardarJuegoActionPerformed

    private void NombreJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreJugadorActionPerformed
        // TODO add your handling code here:
        
       
        
    }//GEN-LAST:event_NombreJugadorActionPerformed

    private void BotonBorrarJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarJugadaActionPerformed
        if (!jugadas.isEmpty()) {}
        Jugada jugadaAnterior=jugadas.get(jugadas.size()-1);
        int cordX=jugadaAnterior.getCordX();
        int cordY=jugadaAnterior.getCordY();
        int num=Integer.parseInt(botones[cordX][cordY].getText());
        ultimaJugada=new Jugada(cordX,cordY,num);
        jugadas.remove(jugadas.size() - 1);
        botones[cordX][cordY].setText("");
        matrizNumeros[cordX][cordY]=0;
    }//GEN-LAST:event_BotonBorrarJugadaActionPerformed

    private void BotonRehacerJugadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRehacerJugadaActionPerformed
        if (ultimaJugada!=null) {
            int cordX=ultimaJugada.getCordX();
            int cordY=ultimaJugada.getCordY();
            int num=ultimaJugada.getNum();
            AsignarNum(cordX, cordY, num);
        }
    }//GEN-LAST:event_BotonRehacerJugadaActionPerformed

    private void BotonBorrarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarJuegoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(
            null,"¿ESTÁ SEGURO DE BORRAR EL JUEGO? ","Confirmacion",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (respuesta == JOptionPane.YES_OPTION){

            int size = matrizNumeros.length;
            for (int j = 0; j < size; j++) {
                for (int i = 0; i < size; i++) {
                    botones[j][i].setText("");
                    matrizNumeros[j][i]=0;
                }
            }

        }
    }//GEN-LAST:event_BotonBorrarJuegoActionPerformed

    private void NivelDificultadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NivelDificultadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NivelDificultadActionPerformed

     /**
     * Método encargado de asignar un número al cuadro haciendo todas las validaciones necesarias.
     *
     * @param fila    La fila del botón.
     * @param columna La columna del botón.
     * @param num     El número a asignar.
     */
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
            if (Multinivel==0){ // No multinivel
                       
                ConfValiUsuario(); // Validacion para ver si se uso un usuario
                
                if(ValidoTop){ // Valido para ser registrado en el top
                
                    menuTop.AgregarLista(new AjustesTop10(Nombre,Dificultad, TamTablero, tiempoTranscurridoSegundos));
                    menuTop.guardarAjustes();
                    JOptionPane.showMessageDialog(null, "Se ha registrado en el Top");
                
                }else{ // No se cumple el requisito para ser tomado en cuenta para el top
                
                    JOptionPane.showMessageDialog(null, "No se ha registrado en el Top");
                
                }    
                
                this.dispose();
            }else{ // Multinivel
                this.setVisible(false);
                if (Dificultad=="Fácil"){
                    new Frame8x8("Intermedio",Multinivel,ModoTiempo,Posicion,NombreJugador.getText(),usuario2,horas,minutos,segundos,tiempoTranscurridoSegundos).setVisible(true);
                }else if(Dificultad=="Intermedio"){
                    new Frame8x8("Dificil",Multinivel,ModoTiempo,Posicion,NombreJugador.getText(),usuario2,horas,minutos,segundos,tiempoTranscurridoSegundos).setVisible(true);
                }else{
                    
                    ConfValiUsuario(); // Validacion para ver si se uso un usuario
                    
                    if(ValidoTop){ // Valido para ser registrado en el top
                
                        menuTop.AgregarLista(new AjustesTop10(Nombre,Dificultad, TamTablero, tiempoTranscurridoSegundos));
                        menuTop.guardarAjustes();
                        JOptionPane.showMessageDialog(null, "Se ha registrado en el Top");
                
                    }else{ // No se cumple el requisito para ser tomado en cuenta para el top
                
                        JOptionPane.showMessageDialog(null, "No se ha registrado en el Top");
                    }            
                    this.dispose();
                }
            }
        }
        
        }
        
    }
    
    /**
     * Verifica que el número ya no esté en la fila o columna.
     *
     * @param matriz  La matriz de números.
     * @param fila    La fila a verificar.
     * @param columna La columna a verificar.
     * @param numero  El número a verificar.
     * @return true si el número ya está en la fila o columna, false de lo contrario.
     */
    public boolean verificarMatriz(int[][] matriz,int fila, int columna,int numero){
        int size = matriz.length;
        
        for (int j = 0; j < size; j++) {
            if (matriz[fila][j] == numero) {
                if (numero!=0){
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE EL ELEMENTO YA ESTÁ EN LA FILA");
                }
                return true; // Número encontrado en la fila
            }
        }
        for (int i = 0; i < size; i++) {
            if (matriz[i][columna] == numero) {
                if (numero!=0){
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE EL ELEMENTO YA ESTÁ EN LA COLUMNA");
                }
                return true; // Número encontrado en la columna
            }
        }
        return false;
    }
    /**
     * Verifica las restricciones de los símbolos adyacentes en la matriz.
     *
     * @param matriz  La matriz de números.
     * @param fila    La fila del número.
     * @param columna La columna del número.
     * @param numero  El número a verificar.
     * @return true si hay un error en las restricciones, false de lo contrario.
     */
    public boolean verificarMatriz2(int[][] matriz, int fila, int columna, int numero) {
    boolean error = false;
    
    if (columna >= 0 && columna+1 < 8 && !matrizSimbolos[fila * 2][columna].equals("")) {
        String simbolo = matrizSimbolos[fila*2][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila][columna + 1] < numero && matrizNumeros[fila][columna + 1] > 0) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MENOR");
                error = true;
            }
        } else {
            if (matrizNumeros[fila][columna + 1] > 0 && matrizNumeros[fila][columna + 1] > numero) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MAYOR");
                error = true;
            }
        }
    }
    
    if (columna-1 >= 0 && !matrizSimbolos[fila * 2][columna - 1].equals("")) {
        String simbolo = matrizSimbolos[fila*2][columna - 1];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila][columna - 1] > numero && matrizNumeros[fila][columna - 1] > 0) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MAYOR");
                error = true;
            }
        } else {
            if (matrizNumeros[fila][columna - 1] > 0 && matrizNumeros[fila][columna - 1] < numero) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MENOR");
                error = true;
            }
        }
    }
    
    if (fila-1 >= 0 && !matrizSimbolos[(fila * 2-1)][columna].equals("")) {
        String simbolo = matrizSimbolos[(fila * 2 - 1)][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila - 1][columna] > numero && matrizNumeros[fila - 1][columna] > 0) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MAYOR");
                error = true;
            }
        } else {
            if (matrizNumeros[fila - 1][columna] > 0 && matrizNumeros[fila- 1][columna] < numero) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MENOR");
                error = true;
            }
        }
    }

    if (fila+1 >= 0 && fila+1 < 8 && !matrizSimbolos[fila * 2+1][columna].equals("")) {
        String simbolo = matrizSimbolos[fila * 2+1][columna];
        if (simbolo.equals("<")) {
            if (matrizNumeros[fila + 1][columna] < numero && matrizNumeros[fila + 1][columna] > 0) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MENOR");
                error = true;
            }
        } else {
            if (matrizNumeros[fila + 1][columna] > 0 && matrizNumeros[fila + 1][columna] > numero) {
                JOptionPane.showMessageDialog(null, "JUGADA NO ES VÁLIDA PORQUE NO CUMPLE CON LA RESTRICCIÓN DE MAYOR");
                error = true;
            }
        }
    }

    return error;
}
    /**
     *
     */
    public void reiniciarTiempo(){
// Funcion para reiniciar el reloj
        horas = 0;
        minutos = 0;
        segundos = 0;
    }
    
    /**
     *
     * @param mensaje String Notificacion de tiempo
     */
    public void detenerTiempo(String mensaje) {
        
        // Funcion para detener el reloj y tomar sus valores
        timer.stop();
        

        // Calculo total del tiempo actual
        int horasTotales = tiempoTranscurridoSegundos / 3600;
        int minutosTotales = (tiempoTranscurridoSegundos % 3600) / 60;
        int segundosTotales = tiempoTranscurridoSegundos % 60;
        
        String tiempoDuracion = String.format("%02d:%02d:%02d", horasTotales, minutosTotales, segundosTotales);
        
        JOptionPane.showMessageDialog(null, "Tiempo total: " + tiempoDuracion);
        
        // Pide al usuario si quiere seguir jugando o no.
        // En este caso el usuario se quedo sin tiempo y ya no es valido para el top pero puede seguir jugando
        
        int resultado = JOptionPane.showConfirmDialog(null, "Seguir Jugando?", "Fin del Juego", JOptionPane.YES_NO_OPTION);
        
        if(resultado == JOptionPane.YES_OPTION){
        
            if(ModoTiempo==1){ // Temporizador se convierte en cronometro
                
                horas = tiempoTranscurridoSegundos / 3600;
                minutos = (tiempoTranscurridoSegundos % 3600) / 60;
                segundos = tiempoTranscurridoSegundos % 60;
                
                ModoTiempo=0;
                //timer.start();
                ValidoTop = false; // No valido para el top
            
            
            }else{ // De cronometro se pasa a modo de no reloj
            
                 //timer.start();
                 ModoTiempo=3;
                 ValidoTop = false;
            }
        }else{
            ValidoTop = false;
            setVisible(false);
        }    
    }
    
    /**
     *Determinar Timepo 
     */
    public void determinarTiempo(){
        // Validar si el modo de reloj es cronometro o temporizador
        if(ModoTiempo==0){ // cronometro
        
            esCronometro = true;
            
        }else if(ModoTiempo==1){ // temporizador
        
            esCronometro = false;
        }
        
    }


    
    public int generarNumeroAleatorio() {
    return (int) (Math.random() * 3) + 1;
    }
    
    /**
     *Carga de Tiempo
     */
    public void cargarTiempo(){
        // Restaura los valores del reloj y segundos del archivo XML
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
    
    /**
     *
     * @param matriz
     * @return
     */
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
    
    /**
     *
     * @return  
     */
    public boolean ConfValiUsuario(){
        // Validar si el juego es valido para el Top
        // Si es anonimo no cuenta
        if(Nombre.equalsIgnoreCase("Anónimo")){
        
                ValidoTop = false;
        }
        
        if(ValidoTop){
        
            return true;
        }
    
        return false;
    
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
            java.util.logging.Logger.getLogger(Frame8x8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame8x8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame8x8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame8x8.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton Boton0_3;
    private javax.swing.JButton Boton0_4;
    private javax.swing.JButton Boton0_5;
    private javax.swing.JButton Boton0_6;
    private javax.swing.JButton Boton0_7;
    private javax.swing.JButton Boton1;
    private javax.swing.JButton Boton1_0;
    private javax.swing.JButton Boton1_1;
    private javax.swing.JButton Boton1_2;
    private javax.swing.JButton Boton1_3;
    private javax.swing.JButton Boton1_4;
    private javax.swing.JButton Boton1_5;
    private javax.swing.JButton Boton1_6;
    private javax.swing.JButton Boton1_7;
    private javax.swing.JButton Boton2;
    private javax.swing.JButton Boton2_0;
    private javax.swing.JButton Boton2_1;
    private javax.swing.JButton Boton2_2;
    private javax.swing.JButton Boton2_3;
    private javax.swing.JButton Boton2_4;
    private javax.swing.JButton Boton2_5;
    private javax.swing.JButton Boton2_6;
    private javax.swing.JButton Boton2_7;
    private javax.swing.JButton Boton3;
    private javax.swing.JButton Boton3_0;
    private javax.swing.JButton Boton3_1;
    private javax.swing.JButton Boton3_2;
    private javax.swing.JButton Boton3_3;
    private javax.swing.JButton Boton3_4;
    private javax.swing.JButton Boton3_5;
    private javax.swing.JButton Boton3_6;
    private javax.swing.JButton Boton3_7;
    private javax.swing.JButton Boton4;
    private javax.swing.JButton Boton4_0;
    private javax.swing.JButton Boton4_1;
    private javax.swing.JButton Boton4_2;
    private javax.swing.JButton Boton4_3;
    private javax.swing.JButton Boton4_4;
    private javax.swing.JButton Boton4_5;
    private javax.swing.JButton Boton4_6;
    private javax.swing.JButton Boton4_7;
    private javax.swing.JButton Boton5;
    private javax.swing.JButton Boton5_0;
    private javax.swing.JButton Boton5_1;
    private javax.swing.JButton Boton5_2;
    private javax.swing.JButton Boton5_3;
    private javax.swing.JButton Boton5_4;
    private javax.swing.JButton Boton5_5;
    private javax.swing.JButton Boton5_6;
    private javax.swing.JButton Boton5_7;
    private javax.swing.JButton Boton6;
    private javax.swing.JButton Boton6_0;
    private javax.swing.JButton Boton6_1;
    private javax.swing.JButton Boton6_2;
    private javax.swing.JButton Boton6_3;
    private javax.swing.JButton Boton6_4;
    private javax.swing.JButton Boton6_5;
    private javax.swing.JButton Boton6_6;
    private javax.swing.JButton Boton6_7;
    private javax.swing.JButton Boton7;
    private javax.swing.JButton Boton7_0;
    private javax.swing.JButton Boton7_1;
    private javax.swing.JButton Boton7_2;
    private javax.swing.JButton Boton7_3;
    private javax.swing.JButton Boton7_4;
    private javax.swing.JButton Boton7_5;
    private javax.swing.JButton Boton7_6;
    private javax.swing.JButton Boton7_7;
    private javax.swing.JButton Boton8;
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
    private javax.swing.JTextField NivelDificultad;
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
    private javax.swing.JLabel Texto10_0;
    private javax.swing.JLabel Texto10_1;
    private javax.swing.JLabel Texto10_2;
    private javax.swing.JLabel Texto10_3;
    private javax.swing.JLabel Texto10_4;
    private javax.swing.JLabel Texto10_5;
    private javax.swing.JLabel Texto10_6;
    private javax.swing.JLabel Texto11_0;
    private javax.swing.JLabel Texto11_1;
    private javax.swing.JLabel Texto11_2;
    private javax.swing.JLabel Texto11_3;
    private javax.swing.JLabel Texto11_4;
    private javax.swing.JLabel Texto11_5;
    private javax.swing.JLabel Texto11_6;
    private javax.swing.JLabel Texto11_7;
    private javax.swing.JLabel Texto12_0;
    private javax.swing.JLabel Texto12_1;
    private javax.swing.JLabel Texto12_2;
    private javax.swing.JLabel Texto12_3;
    private javax.swing.JLabel Texto12_4;
    private javax.swing.JLabel Texto12_5;
    private javax.swing.JLabel Texto12_6;
    private javax.swing.JLabel Texto13_0;
    private javax.swing.JLabel Texto13_1;
    private javax.swing.JLabel Texto13_2;
    private javax.swing.JLabel Texto13_3;
    private javax.swing.JLabel Texto13_4;
    private javax.swing.JLabel Texto13_5;
    private javax.swing.JLabel Texto13_6;
    private javax.swing.JLabel Texto13_7;
    private javax.swing.JLabel Texto14_0;
    private javax.swing.JLabel Texto14_1;
    private javax.swing.JLabel Texto14_2;
    private javax.swing.JLabel Texto14_3;
    private javax.swing.JLabel Texto14_4;
    private javax.swing.JLabel Texto14_5;
    private javax.swing.JLabel Texto14_6;
    private javax.swing.JLabel Texto1_0;
    private javax.swing.JLabel Texto1_1;
    private javax.swing.JLabel Texto1_2;
    private javax.swing.JLabel Texto1_3;
    private javax.swing.JLabel Texto1_4;
    private javax.swing.JLabel Texto1_5;
    private javax.swing.JLabel Texto1_6;
    private javax.swing.JLabel Texto1_7;
    private javax.swing.JLabel Texto2_0;
    private javax.swing.JLabel Texto2_1;
    private javax.swing.JLabel Texto2_2;
    private javax.swing.JLabel Texto2_3;
    private javax.swing.JLabel Texto2_4;
    private javax.swing.JLabel Texto2_5;
    private javax.swing.JLabel Texto2_6;
    private javax.swing.JLabel Texto3_0;
    private javax.swing.JLabel Texto3_1;
    private javax.swing.JLabel Texto3_2;
    private javax.swing.JLabel Texto3_3;
    private javax.swing.JLabel Texto3_4;
    private javax.swing.JLabel Texto3_5;
    private javax.swing.JLabel Texto3_6;
    private javax.swing.JLabel Texto3_7;
    private javax.swing.JLabel Texto4_0;
    private javax.swing.JLabel Texto4_1;
    private javax.swing.JLabel Texto4_2;
    private javax.swing.JLabel Texto4_3;
    private javax.swing.JLabel Texto4_4;
    private javax.swing.JLabel Texto4_5;
    private javax.swing.JLabel Texto4_6;
    private javax.swing.JLabel Texto5_0;
    private javax.swing.JLabel Texto5_1;
    private javax.swing.JLabel Texto5_2;
    private javax.swing.JLabel Texto5_3;
    private javax.swing.JLabel Texto5_4;
    private javax.swing.JLabel Texto5_5;
    private javax.swing.JLabel Texto5_6;
    private javax.swing.JLabel Texto5_7;
    private javax.swing.JLabel Texto6_0;
    private javax.swing.JLabel Texto6_1;
    private javax.swing.JLabel Texto6_2;
    private javax.swing.JLabel Texto6_3;
    private javax.swing.JLabel Texto6_4;
    private javax.swing.JLabel Texto6_5;
    private javax.swing.JLabel Texto6_6;
    private javax.swing.JLabel Texto7_0;
    private javax.swing.JLabel Texto7_1;
    private javax.swing.JLabel Texto7_2;
    private javax.swing.JLabel Texto7_3;
    private javax.swing.JLabel Texto7_4;
    private javax.swing.JLabel Texto7_5;
    private javax.swing.JLabel Texto7_6;
    private javax.swing.JLabel Texto7_7;
    private javax.swing.JLabel Texto8_0;
    private javax.swing.JLabel Texto8_1;
    private javax.swing.JLabel Texto8_2;
    private javax.swing.JLabel Texto8_3;
    private javax.swing.JLabel Texto8_4;
    private javax.swing.JLabel Texto8_5;
    private javax.swing.JLabel Texto8_6;
    private javax.swing.JLabel Texto9_0;
    private javax.swing.JLabel Texto9_1;
    private javax.swing.JLabel Texto9_2;
    private javax.swing.JLabel Texto9_3;
    private javax.swing.JLabel Texto9_4;
    private javax.swing.JLabel Texto9_5;
    private javax.swing.JLabel Texto9_6;
    private javax.swing.JLabel Texto9_7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
