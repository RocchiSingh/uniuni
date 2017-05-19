package giocatore.disco;

import giocatore.Giocatore;
import principale.Colore;

/**
 * Created by dimitri on 18/05/2017.
 */
public class DiscoMilitare extends Disco {

    public DiscoMilitare(Colore colore, int posizione){
        super(colore,posizione);
    }

    public void setPosizoneMil(){
        setPosizione(Giocatore.getPuntiMilitari());
    }
}
