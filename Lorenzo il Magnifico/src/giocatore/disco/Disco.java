package giocatore.disco;

import principale.Colore;

/**
 * Created by dimitri on 17/05/2017.
 */
public class Disco {
    private Colore color;
    private int posizione;

    public Disco(Colore col,int posix){
        color = col;
        posizione = posix;
    }

    public Disco(){}

    public Colore getColore(){return color;}

    public int getPosizione(){return posizione;}

    public void setPosizione(int posix){
        posizione = posix;
    }
}
