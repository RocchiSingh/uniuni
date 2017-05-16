package tabellone;

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
        this.famigliare = famigliare;
        occupato = true;
    }

    public void rimuoviMembro(){
        famigliare = null;
        occupato = false;
    }
}
