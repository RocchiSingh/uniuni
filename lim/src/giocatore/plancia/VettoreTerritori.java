package giocatore.plancia;
import carte.*;
import giocatore.Giocatore;

/**
 * Created by dimitri on 17/05/2017.
 */
public class VettoreTerritori {
   private CartaTerritorio[] territori = new CartaTerritorio[5];
    private int[] vincoloMil = {0,0,3,7,12,18};

    public void aggiungiCarta(CartaTerritorio carta){
        for(int i=0;i<6;i++){
            if(territori[i].getAggiunta() == false ){
                territori[i] = carta;
                territori[i].setAggiunta();
                return;
            }
        }
    }

    public int getPuntiVittoria(){//semplificare con size
        if(territori[5].getAggiunta() == true){
            return 20;
        }
        if(territori[4].getAggiunta() == true){
            return 10;
        }
        if(territori[3].getAggiunta() == true){
            return 4;
        }
        if(territori[2].getAggiunta() == true){
            return 1;
        }return 0;
    }

    public int size(){
        int i=0;
        while(territori[i] != null){
            i++;
        }
        return i;
    }

    public int[] getVincoloMil(){return vincoloMil;}

    public CartaTerritorio getCarta(int i){return territori[i];}
}

