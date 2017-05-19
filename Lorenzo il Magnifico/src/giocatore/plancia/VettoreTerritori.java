package giocatore.plancia;
import carte.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class VettoreTerritori {
    private CartaTerritorio[] territori = new CartaTerritorio[5];
    private int[] vincoloMil = {0,0,3,7,12,18};

    public void aggiungiCarta(CartaTerritorio carta){
        for(int i=0;i<6;i++){
            if(territori[i].getAggiunta() == false & vincoloMil[i] <= /*giocatore.puntiMilitari*/){
                territori[i] = carta;
                territori[i].setAggiunta();
            }
        }
    }

    public void setPuntiVittoria(){
        if(territori[5].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 20;*/
            return;
        }
        if(territori[4].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 10;*/
            return;
        }
        if(territori[3].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 4;*/
            return;
        }
        if(territori[2].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 1;*/
            return;
        }
    }
}

