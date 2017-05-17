package tabellone.torre;
import carte.Carta;
import principale.*;
/**
 * Created by dimitri on 13/05/2017.
 */
public class Torre {
    private String tipoTorre = "";
    private AreaTorre[] livelli = new AreaTorre[4];
    public Torre(String tipoTorre,AreaTorre a0,AreaTorre a1,AreaTorre a2,AreaTorre a3){
        this.tipoTorre = tipoTorre;
        livelli[0] = a0;
        livelli[1] = a1;
        livelli[2] = a2;
        livelli[3] = a3;
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

}
