package giocatore.plancia;
import carte.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class VettorePersonaggi {
    private CartaPersonaggi[] personaggi = new CartaPersonaggi[5];

    public void aggiungiCarta(CartaPersonaggi carta){
        for(int i=0;i<6;i++){
            if(personaggi[i].getAggiunta() == false){
                personaggi[i] = carta;
                personaggi[i].setAggiunta();
            }
        }
    }

    public void setPuntiVittoria(){
        if(personaggi[5].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 21;*/
            return;
        }
        if(personaggi[4].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 15;*/
            return;
        }
        if(personaggi[3].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 10;*/
            return;
        }
        if(personaggi[2].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 6;*/
            return;
        }
        if(personaggi[1].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 3;*/
            return;
        }
        if(personaggi[0].getAggiunta() == true){
            /*giocatore.puntiVittoria+ = 1;*/
            return;
        }
    }
}
