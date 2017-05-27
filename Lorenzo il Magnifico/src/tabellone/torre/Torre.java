package tabellone.torre;
import carte.Carta;
import giocatore.Giocatore;
import principale.*;
/**
 * Created by dimitri on 13/05/2017.
 */
public class Torre {
    private Colore coloreTorre = null;
    private AreaTorre[] livelli = new AreaTorre[4];
    public Torre(Colore coloreTorre,AreaTorre a0,AreaTorre a1,AreaTorre a2,AreaTorre a3){
        this.coloreTorre = coloreTorre;
        livelli[0] = a0;
        a0.setPianoTorre(0);
        livelli[1] = a1;
        a1.setPianoTorre(1);
        livelli[2] = a2;
        a2.setPianoTorre(2);
        livelli[3] = a3;
        a3.setPianoTorre(3);
    }

    public void pulisciTorre(){
        for(int i=0;i<4;i++){
            livelli[i].rimuoviCarta();
            livelli[i].rimuoviMembro();
        }
    }

    public void riempiTorre(Carta[] mazzo/*passare vettore di 4 carte univoche e mescolate in base periodo*/){
        for(int i=0;i<4;i++){
            livelli[i].impostaCarta(mazzo[i]);/*vettore di carte*/
        }
    }

    public boolean contrlPres(){
        for(int i=0;i<4;i++){
            if(livelli[i].getOcccupato() == true){
                return true;
            }
        }return false;
    }

    public boolean contrlPresFam(Colore color){
       if(contrlPres()){
        for(int i=0;i<4;i++) {
           if (livelli[i].getColoreFam()==color)
               return true;
          }return false;
        }return false;
    }

    public void setRicompensa(Torre torre){//questo metodo non serve poichè va messo alla creazione dell area torre per passaggio nel costruttore del area torre. e visto che tutte le aree hanno
        //risorse diverse veranno passate uelle giusto invece di passare un int ogni volta e ricordarlo per scrivere il tutto
           // livelli[2].setRicompensa(1);
           // livelli[3].setRicompensa(2);
    }

    public Colore getColoreTorre(){return coloreTorre;}

    public void giveRicompensa(AreaTorre area,Torre torre,Giocatore giocatore){
     // queso metodo lo chiamiamo imetti fmigliare e come return darà una risorsa. il giocatore prende la risosrsa e la aggiunge alle sue. il metodo avra in ingresso solo il famigliare
        //il metodo avra in ingresso il piano e il amigliare e se assegnare o no la risorsa dipende dall variare risorsa dell area se ha una risorsa o no
        //guarda il consiglio
        }
    }


