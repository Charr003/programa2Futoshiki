
package com.mycompany.programa2futoshiki;

/**
 *
 * @author jxdga
 */
public class Jugada {
    int cordenadaX;
    int cordenadaY;
    int num;
    
    public Jugada(int cordX, int cordY, int Num){
        cordenadaX=cordX;
        cordenadaY=cordY;
        num=Num;
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
