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
            }
        }
    }

    public void pulisciCons(){
        for(int i=0;i<17;i++){
            ordArr[i] = null;
        }
    }

    public Famigliare[] getOrdArr(){
        return ordArr;
    }
    public int getRicompensaMoneta(){return ricompensaMoneta;}
    public Privilegio getPrivilegio(){return privilegio;}
}
