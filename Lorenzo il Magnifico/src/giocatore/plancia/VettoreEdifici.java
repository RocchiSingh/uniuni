package giocatore.plancia;
import carte.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class VettoreEdifici {
    private CartaEdifici[] edifici = new CartaEdifici[5];

    public void aggiungiCarta(CartaEdifici carta){
        for(int i=0;i<6;i++){
            if(edifici[i].getAggiunta() == false){
                edifici[i] = carta;
                edifici[i].setAggiunta();
            }
        }
    }
}
