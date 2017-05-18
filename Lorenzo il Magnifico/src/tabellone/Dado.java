package tabellone;

import principale.Colore;

/**
 * Created by dimitri on 13/05/2017.
 */
public class Dado {
    private Colore color =null;
    private int faccia = 0;
    public Dado (){color=null; faccia=0;}
    public Dado (Colore colore){
        this.color=colore;
    }
    public void setDado( int val){
        faccia=val;

    }
    public int lancia(){
        faccia = (int)(Math.random()*6);
        return faccia;
    }
    public int getValue(){
        return faccia;
    }


}
