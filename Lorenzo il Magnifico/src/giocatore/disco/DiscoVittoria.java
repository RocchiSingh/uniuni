package giocatore.disco;

import giocatore.Giocatore;
import principale.Colore;

/**
 * Created by dimitri on 18/05/2017.
 */
public class DiscoVittoria extends Disco {

    public DiscoVittoria(Colore colore, int posizione){
        super(colore,posizione);
    }

    public void setPosizoneVitt(){
        setPosizione(Giocatore.getPuntiVittoria());
    }
}
