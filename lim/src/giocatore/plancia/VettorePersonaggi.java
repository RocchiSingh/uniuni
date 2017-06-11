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

    public int getPuntiVittoria(){
        if(personaggi[5].getAggiunta() == true){
            return 21;
                    }
        if(personaggi[4].getAggiunta() == true){
            return 15;
        }
        if(personaggi[3].getAggiunta() == true){
            return 10;
        }
        if(personaggi[2].getAggiunta() == true){
            return 6;
        }
        if(personaggi[1].getAggiunta() == true){
            return 3;
        }
        if(personaggi[0].getAggiunta() == true){
            return 1;
        }return 0;
    }

    public int size(){
        int i=0;
        while(personaggi[i] != null){
            i++;
        }
        return i;
    }
}
