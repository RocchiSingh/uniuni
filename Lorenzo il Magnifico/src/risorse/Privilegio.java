package risorse;

import giocatore.Giocatore;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Privilegio {

    private String preso=""; // per prendere due cose confronto questa stringa nei due vettori dei privilegi e faccio in modo che siano entrambe diverse
    private int[] legnaPietra = new int[2];
    private int[] servitore = new int[2];
    private int[] monete = new int[2];
    private int[] puntiMil = new int[2];
    private int[] puntiFede = new int[2];

    public Privilegio(){
        legnaPietra[0]=1;
        legnaPietra[1]=1;
        servitore[0]=2;
        servitore[1]=0;
        monete[0]=2;
        monete[1]=0;
        puntiFede[0]=1;
        puntiFede[1]=0;
        puntiMil[0]=2;
        puntiMil[1]=0;
    }

    public void resettaPreso(){
        preso="";
    }
    public String getPreso(){
        return preso;
    }


    public void  getLegnaPietra(Giocatore giocatore){
        preso="lengaPietra";
        giocatore.prendiLegno(legnaPietra[0]);
        giocatore.prendiPietra(legnaPietra[1]);
    }

    public void getServitore(Giocatore giocatore){
        preso="servitore";
        giocatore.prendiServitori(servitore[0]);
    }

    public void getMonete(Giocatore giocatore){
        preso="monete";
        giocatore.prendiMonete(monete[0]);
    }

    public void getPuntiMil(Giocatore giocatore){
        preso="puntiMilitari";
        giocatore.incremPuntiMil(puntiMil[0]);
    }

    public void getPuntiFede(Giocatore giocatore){
        preso="puntiFede";
        giocatore.decremPuntiFede(puntiFede[0]);
    }





}
