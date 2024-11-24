
package Modelo;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.io.File;
/**
 *
 * @author jxdga
 */
public class ArchivosXML {
    public static void guardarEnXML(int [][] matrizNumeros, String [][] matrizSimbolos, int horas, int minutos, int segundos, int temphoras, int tempminutos, int tempsegundos, int tiempo, boolean ValidoTop) {
        try {
        // Crear el document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Crear el documento XML
        Document document = builder.newDocument();
        
        // Crear el elemento raíz
        Element root = document.createElement("partida");
        document.appendChild(root);

        // Guardar la matriz de números
        Element numeros = document.createElement("Numeros");
        root.appendChild(numeros);
        
        int filas = matrizNumeros.length;
        int columnas = matrizNumeros[0].length;

        for (int j = 0; j < filas; j++) {
            for (int i = 0; i < columnas; i++) {
                Element cordNum = document.createElement("Num_" + j + "_" + i);
                // Agregar el valor de matrizNumeros como texto dentro del elemento
                cordNum.appendChild(document.createTextNode(String.valueOf(matrizNumeros[j][i])));
                numeros.appendChild(cordNum);
            }
        }

        // Guardar la matriz de símbolos
        Element simbolos = document.createElement("Simbolos");
        root.appendChild(simbolos);

        for (int j = 0; j < matrizSimbolos.length; j++) {
            for (int i = 0; i < matrizSimbolos[j].length; i++) {
                Element cordSim = document.createElement("Sim_" + j + "_" + i);
                // Agregar el valor de matrizSimbolos como texto dentro del elemento
                cordSim.appendChild(document.createTextNode(matrizSimbolos[j][i]));
                simbolos.appendChild(cordSim);
            }
        }
        
        Element horasElement = document.createElement("Horas");
        horasElement.appendChild(document.createTextNode(String.valueOf(horas)));
        root.appendChild(horasElement);        
        
        Element minutosElement = document.createElement("Minutos");
        minutosElement.appendChild(document.createTextNode(String.valueOf(minutos)));
        root.appendChild(minutosElement);
        
        Element segundosElement = document.createElement("Segundos");
        segundosElement.appendChild(document.createTextNode(String.valueOf(segundos)));
        root.appendChild(segundosElement);

        Element tiempoTranscurridoElement = document.createElement("TiempoTranscurridoSegundos");
        tiempoTranscurridoElement.appendChild(document.createTextNode(String.valueOf(tiempo)));
        root.appendChild(tiempoTranscurridoElement);        

        Element TemphorasElement = document.createElement("TempHoras");
        TemphorasElement.appendChild(document.createTextNode(String.valueOf(horas)));
        root.appendChild(TemphorasElement);        
        
        Element TempminutosElement = document.createElement("TempMinutos");
        TempminutosElement.appendChild(document.createTextNode(String.valueOf(minutos)));
        root.appendChild(TempminutosElement);
        
        Element TempsegundosElement = document.createElement("TempSegundos");
        TempsegundosElement.appendChild(document.createTextNode(String.valueOf(tempsegundos)));
        root.appendChild(TempsegundosElement);   
        
        Element ValidoTopElement = document.createElement("ValidoParaTop");
        ValidoTopElement.appendChild(document.createTextNode(String.valueOf(ValidoTop)));
        root.appendChild(ValidoTopElement);  
        
        
        
        // Guardar el documento XML en un archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("PartidaGuardada.xml"));

        transformer.transform(domSource, streamResult);

        System.out.println("Archivo XML guardado correctamente con su partida.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static int[][] cargarMatrizNumeros() {
        int[][] matrizNumeros = null;

    try {
        File file = new File("PartidaGuardada.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(file);
        document.getDocumentElement().normalize();

        NodeList numeroNodos = document.getElementsByTagName("Numeros").item(0).getChildNodes();

        // Calcular tamaño de la matriz
        int filas = (int) Math.sqrt(numeroNodos.getLength());
        matrizNumeros = new int[filas][filas];

        // Llenar la matriz de números
        for (int i = 0; i < numeroNodos.getLength(); i++) {
            Node nodo = numeroNodos.item(i);

            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String[] coords = elemento.getTagName().split("_");
                int j = Integer.parseInt(coords[1]);
                int k = Integer.parseInt(coords[2]);
                
                // Verificar si el contenido está vacío antes de convertir
                String valorTexto = elemento.getTextContent();
                if (valorTexto != null && !valorTexto.isEmpty()) {
                    matrizNumeros[j][k] = Integer.parseInt(valorTexto);
                } else {
                    // Asignar un valor predeterminado si el contenido está vacío
                    matrizNumeros[j][k] = 0;
                }
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return matrizNumeros;
    }

    // Método para cargar la matriz de símbolos desde el XML
    public static String[][] cargarMatrizSimbolos() {
        String[][] matrizSimbolos = null;

        try {
            File file = new File("PartidaGuardada.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList simboloNodos = document.getElementsByTagName("Simbolos").item(0).getChildNodes();

            // Calcular tamaño de la matriz
            int filas = (int) Math.sqrt(simboloNodos.getLength());
            matrizSimbolos = new String[filas][filas];

            // Llenar la matriz de símbolos
            for (int i = 0; i < simboloNodos.getLength(); i++) {
                Node nodo = simboloNodos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String[] coords = elemento.getTagName().split("_");
                    int j = Integer.parseInt(coords[0].substring(3));
                    int k = Integer.parseInt(coords[1]);
                    matrizSimbolos[j][k] = elemento.getTextContent();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrizSimbolos;
    }
    
    //Metodo para cargar la partida nueva
    public static String[][] cargarMatrizSimbolos2(String archivo) {
        String[][] matrizSimbolos = new String[18][10]; // Matriz de tamaño fijo 18x10

        try {
            // Cargar el archivo XML
            File file = new File(archivo);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            // Obtener nodos de símbolos
            NodeList simboloNodos = document.getElementsByTagName("Simbolos").item(0).getChildNodes();

            // Llenar la matriz de símbolos
            for (int i = 0; i < simboloNodos.getLength(); i++) {
                Node nodo = simboloNodos.item(i);

                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) nodo;
                    String[] coords = elemento.getTagName().split("_");

                    try {
                        // Obtener las coordenadas j y k del nombre de la etiqueta
                        int j = Integer.parseInt(coords[1]);
                        int k = Integer.parseInt(coords[2]);

                        // Verificar que las coordenadas están dentro del rango de la matriz
                        if (j >= 0 && j < 18 && k >= 0 && k < 10) {
                            // Obtener el contenido del elemento y asignar "" si es nulo o vacío
                            String contenido = elemento.getTextContent();
                            matrizSimbolos[j][k] = (contenido != null && !contenido.isEmpty()) ? contenido : "";
                        }
                    } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                        System.err.println("Error al analizar las coordenadas en la etiqueta: " + elemento.getTagName());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrizSimbolos;
    }
    
    
    public static void guardarEnXML2(String [][] matrizSimbolos) {
        try {
        // Crear el document builder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Crear el documento XML
        Document document = builder.newDocument();
        
        // Crear el elemento raíz
        Element root = document.createElement("partida");
        document.appendChild(root);
        
        // Guardar la matriz de símbolos
        Element simbolos = document.createElement("Simbolos");
        root.appendChild(simbolos);

        for (int j = 0; j < matrizSimbolos.length; j++) {
            for (int i = 0; i < matrizSimbolos[j].length; i++) {
                Element cordSim = document.createElement("Sim_" + j + "_" + i);
                // Agregar el valor de matrizSimbolos como texto dentro del elemento
                cordSim.appendChild(document.createTextNode(matrizSimbolos[j][i]));
                simbolos.appendChild(cordSim);
            }
        }

        // Guardar el documento XML en un archivo
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(new File("Juego1F.xml"));

        transformer.transform(domSource, streamResult);

        System.out.println("Archivo XML guardado correctamente con su partida.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public int[] restaurarValoresTiempo(){
        
        int[] valores = new int[7];
        
        try{
            
            File file = new File("PartidaGuardada.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);

            valores[0] = Integer.parseInt(document.getElementsByTagName("Horas").item(0).getTextContent());
            valores[1] = Integer.parseInt(document.getElementsByTagName("Minutos").item(0).getTextContent());
            valores[2] = Integer.parseInt(document.getElementsByTagName("Segundos").item(0).getTextContent());
            valores[3] = Integer.parseInt(document.getElementsByTagName("TiempoTranscurridoSegundos").item(0).getTextContent());
            valores[4] = Integer.parseInt(document.getElementsByTagName("TempHoras").item(0).getTextContent());
            valores[5] = Integer.parseInt(document.getElementsByTagName("TempMinutos").item(0).getTextContent());
            valores[6] = Integer.parseInt(document.getElementsByTagName("TempSegundos").item(0).getTextContent());
            valores[7] = Integer.parseInt(document.getElementsByTagName("ValidoParaTop").item(0).getTextContent());
            
            System.out.println("Datos restaurados exitosamente desde tiempo.xml");
            
        }catch (Exception e){
            
            e.printStackTrace();
        }
        
        return valores;
    }    
    
}
