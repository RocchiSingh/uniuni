package tabellone.chiesa;
import principale.Colore;

/**
 * Created by dimitri on 16/05/2017.
 */
public class CuboScomunica {
    private Colore colore;
    private boolean scomunicato = false;

    public CuboScomunica(Colore color){
        colore = color;
    }

    public void setColore(Colore color){
        colore = color;
    }

    public void setScomunicato(){scomunicato = true;}
}
