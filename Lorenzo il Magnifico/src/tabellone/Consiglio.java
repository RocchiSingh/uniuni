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
    private final int ricompensaMoneta = 1;
    private Privilegio privilegio = new Privilegio();
    private Famigliare[] ordArr = new Famigliare[16]; //vedere come gestire i turni
<<<<<<< HEAD

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


=======

    public void inserisciFam(Famigliare membro, Giocatore giocatore){
        for (int i=0;i<17;i++){
            if(ordArr[i] == null && membro.getForzaFami() >= vincolo){
                ordArr[i] = membro;
                giocatore.prendiMonete(ricompensaMoneta);
                System.out.print("scegli privilegio:" +
                        "0=legno/pietra" +
                        "1=servitori"+
                        "2=monete" +
                        "3=punti militari" +
                        "4=punti fede");
                Scanner scan = new Scanner(System.in);
                int numeropriv = scan.nextInt();
                if(numeropriv == 0){privilegio.getLegnaPietra(giocatore);}
                if(numeropriv == 1){privilegio.getServitore(giocatore);}
                if(numeropriv == 2){privilegio.getMonete(giocatore);}
                if(numeropriv == 3){privilegio.getPuntiMil(giocatore);}
                if(numeropriv == 4){privilegio.getPuntiFede(giocatore);}
>>>>>>> origin/master
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
<<<<<<< HEAD
    //cancellati i metodi get moneta e ricompensa poichè in automatica se l'inserimento del famigliare va a buon fine avro fuori la ricompensa.
=======
    public int getRicompensaMoneta(){return ricompensaMoneta;}
    public Privilegio getPrivilegio(){return privilegio;}
>>>>>>> origin/master
}
