package tabellone;

import Risorse.Risorsa;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class AreaMercato {
    private final int vincolo = 1;
    private boolean occupato = false;
    private Famigliare famigliare = null;
    private Risorsa bonusRis=null;
    private int puntiMil=3;
    private int bonusDen=0;
    private Privilegio[] bonusPrivi= new Privilegio[2];

    public AreaMercato(){}
    public AreaMercato(Risorsa bonusRisorsa){
        bonusRis=bonusRisorsa;
    }
    public AreaMercato(int puntiMil,int bonusDen){
        this.puntiMil=puntiMil;
        this.bonusDen=bonusDen;
    }
    public AreaMercato(int denaro){
        bonusDen=denaro;
    }
    public AreaMercato(Privilegio p1, Privilegio p2 ){

    }

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

    public void rimuoviFamig(){
        famigliare = null;
        occupato = false;
    }

}
