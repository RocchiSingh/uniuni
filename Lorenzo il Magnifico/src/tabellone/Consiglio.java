package tabellone;
import giocatore.Giocatore;
import risorse.*;
import principale.Famigliare;

import java.util.Scanner;

/**
 * Created by dimitri on 16/05/2017.
 */
public class Consiglio {

    private final int vincolo = 1;
    private final Moneta ricompensaMoneta = new Moneta(1);
    private Privilegio privilegio = new Privilegio();
    private Famigliare[] ordArr = new Famigliare[16]; //vedere come gestire i turni

  /*il metodo appena inserisci un famigliare butta fuori le risorse che deve poi il famigliare che inserisce il memmbro prendera subito le risorse buttare fuore le le memorizzera nella risorsa
  opportuna attraverso instanceOf() e cosi via. perchè alla fine non è il consiglio che deve assegnare i punti al giocatore. poichè giocatore non fa parte del consiglio. ma fa parte della partita
   */
    public Risorsa[] inserisciFam(Famigliare membro,int numPrivilegio){//gestire casi di errore e return particolari
        Risorsa[] bonusRitorno=new Risorsa[3];
        Risorsa[] bonusprivilegio= new Risorsa[2];
        bonusprivilegio=privilegio.getRisorsa(numPrivilegio);

        bonusRitorno[0]=ricompensaMoneta;
        bonusRitorno[1]=bonusprivilegio[0];
        bonusRitorno[2]=bonusprivilegio[1];
        for (int i=0;i<17;i++){
            if(ordArr[i] == null && membro.getForzaFami() >= vincolo){
                ordArr[i] = membro;// qua col ciclo avrebbe inserito quel membro in ogni postazione quindi non andava bene senza un return o break.
                return bonusRitorno;


            }
        }
    return null;
    }

    public void pulisciCons(){
        for(int i=0;i<17;i++){
            ordArr[i] = null;
        }
    }

    public Famigliare[] getOrdArr(){
        return ordArr;
    }
    //cancellati i metodi get moneta e ricompensa poichè in automatica se l'inserimento del famigliare va a buon fine avro fuori la ricompensa.
}
