
package com.mycompany.programa2futoshiki;

/**
 *
 * @author jxdga
 */
public class Jugada {
    int cordenadaX;
    int cordenadaY;
    int num;
    
    public Jugada(int cordX, int cordY, int num){
        cordenadaX=cordX;
        cordenadaY=cordY;
        num=num;
    }
    
    public int getCordX(){
        return cordenadaX;
    }
    public int getCordY(){
        return cordenadaY;
    }
    public int getNum(){
        return num;
    }
}
