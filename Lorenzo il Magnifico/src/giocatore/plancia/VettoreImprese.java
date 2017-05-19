package giocatore.plancia;
import carte.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class VettoreImprese {
    private CartaImprese[] imprese = new CartaImprese[5];

    public void aggiungiCarta(CartaImprese carta){
        for(int i=0;i<6;i++){
            if(imprese[i].getAggiunta() == false){
                imprese[i] = carta;
                imprese[i].setAggiunta();
            }
        }
    }
}
