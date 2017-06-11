package tabellone.RaccoltaProduzione;
import principale.*;


/**
 * Created by dimitri on 15/05/2017.
 */
public class AreaRacc {
     private Famigliare famigliare = null;
     private final int vincolo = 1;
     private boolean occupato = false;


    public Famigliare getMembro(){
        return famigliare;
    }

    public boolean getOcccupato(){
        return occupato;
    }

    public Colore getColoreFam(){
        return famigliare.getColore();
    }

    public void setMembro(Famigliare famigliare){
        if (famigliare.getForzaFami()>=vincolo&&occupato==false) {
            this.famigliare = famigliare;//eccezione famigliare gia presente
            occupato = true;
        }//lanciare un eccezione che dice che la forza famigliare non è sufficiente
    }

    public void rimuoviMembro(){
        famigliare = null;//eccezione famigliare non presente
        occupato = false;
    }
}
