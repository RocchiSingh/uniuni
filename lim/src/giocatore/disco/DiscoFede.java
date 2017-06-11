package giocatore.disco;

import giocatore.Giocatore;
import principale.Colore;

/**
 * Created by dimitri on 18/05/2017.
 */
public class DiscoFede extends Disco {

    public DiscoFede(Colore colore,int posizione){
        super(colore,posizione);
    }

    public void setPosizoneFede(Giocatore giocatore){
        setPosizione(giocatore.getPuntiFede());
    }
}
