/**
 * Created by dimitri on 13/05/2017.
 */
public class Dado {
    char colore =""; //bianco (b) nero (n) arancione (a)
    int faccia = 0;
    public Dado (char colore){
        this.colore=colore;
    }
    public int lancia(){
        faccia = (int)(Math.random()*6);
        return faccia;
    }
    public int getValue(){
        return faccia;
    }
}
