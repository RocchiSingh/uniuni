package tabellone.RaccoltaProduzione;
import principale.*;

/**
 * Created by dimitri on 15/05/2017.
 */
public class AreaProd {
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
        if(famigliare.getForzaFami()>=vincolo&&occupato==false){
        this.famigliare = famigliare;//eccezione famigliare presente
        occupato = true;} //lanciare eccezione per gestire il tutto se la forza non è abbastanza
    }

    public void rimuoviMembro(){
        famigliare = null;
        occupato = false;
    }
}
