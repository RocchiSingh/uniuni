package tabellone;
import Risorse.Risorsa;

/**
 * Created by dimitri on 13/05/2017.
 */
public class AreaTorre {
   private int pianoTorre = -1; //piani vanno da 0 a 3
   private Risorsa ricompensa = new Risorsa();
  // private String tipoTorre = "";
   private int vincolodado = 0; // i vincoli sono da 1 ,3 ,5 ,7
   private Carta carta= new Carta();
   private boolean cartasi = false;
   private boolean occupato = false;
   private Famigliare membro = null;

    public AreaTorre(int piano,Risorsa premio,/*String tipo,*/int vincolo){
        pianoTorre = piano;
        ricompensa = premio;
       // tipoTorre = tipo;
        vincolodado = vincolo;
    }
    public void impostaCarta(Carta carta){
        this.carta = carta;
        cartasi = true;
    }
    public void rimuoviCarta(){
        carta = null;
        cartasi = false;
    }
    public Risorsa getRicompensa(){
        return ricompensa;
    }
    public int getVincolodado(){
        return vincolodado;
    }
    public Carta getcarta(){
        return carta;
    }
    public void setMembro(Famigliare famigliare){
        membro = famigliare;
        occupato = true;
    }
    public Famigliare getMembro(){
        return membro;
    }

    public boolean getOcccupato(){
        return occupato;
    }

    public Colore getColoreFam(){
        return membro.getColore();
    }

    public void rimuoviMembro(){
        membro = null;
        occupato = false;
    }
}
