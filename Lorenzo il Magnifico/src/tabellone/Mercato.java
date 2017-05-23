package tabellone;
import giocatore.Giocatore;
import principale.*;
import risorse.*;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Mercato {
    int quantiGiocatori = 4;
    private final int vincolo = 1;
    private boolean[] occupato = {false, false, false, false};
    private Famigliare[] famigliare = new Famigliare[4];
    private int moneteBonusAreaUno = 0;
    private int servitoriBonusAreaDue = 0;
    private int[] bonusAreaTre = new int[2];
    private int[][] privilegio = new int[5][2];
    private boolean[] privilegioPreso = {false, false, false, false, false};
    private String[] elencoPrivilegi = {"LegnaPietra", "Servitore", "Monete", "PuntiMilitari", "PuntiFede"};

    //tengo due costruttori per usare 2 mercati diversi a secondo del numero dei giocatori;
    public Mercato() {
    }

    public Mercato(int bonusA1, int bonusA2) {
        moneteBonusAreaUno = bonusA1;
        servitoriBonusAreaDue = bonusA2;

        bonusAreaTre[0] = 0;
        bonusAreaTre[1] = 0;
        privilegio[0][0] = 0;
        privilegio[0][1] = 0;
        privilegio[1][0] = 0;
        privilegio[1][1] = 0;
        privilegio[2][0] = 0;
        privilegio[2][1] = 0;
        privilegio[3][0] = 0;
        privilegio[3][1] = 0;
        privilegio[4][0] = 0;
        privilegio[4][1] = 0;

    }

    public Mercato(int bonusA1, int bonusA2, int denaro, int puntiMilitari) {
        this(bonusA1, bonusA2);
        bonusAreaTre[0] = denaro;
        bonusAreaTre[1] = puntiMilitari;
        privilegio[0][0] = 1;
        privilegio[0][1] = 1;
        privilegio[1][0] = 2;
        privilegio[1][1] = 0;
        privilegio[2][0] = 2;
        privilegio[2][1] = 0;
        privilegio[3][0] = 2;
        privilegio[3][1] = 0;
        privilegio[4][0] = 1;
        privilegio[4][1] = 0;


    }

    public void getBonusAreaUno(Famigliare membro,Giocatore giocatore) {
        if (occupato[0] == false) {
            famigliare[0] = membro;
            occupato[0] = true;
            giocatore.prendiMonete(moneteBonusAreaUno);
        }else{System.out.print("area già occupata");}
    }

    public void getBonusAreaDue(Famigliare membro,Giocatore giocatore) {
        if (occupato[1] == false) {
            famigliare[1] = membro;
            occupato[1] = true;
            giocatore.prendiServitori(servitoriBonusAreaDue);
        } else{System.out.print("area già occupata");}
    }

    public void getBonusAreaTre(Famigliare membro,Giocatore giocatore) {
        if (occupato[2] == false) {
            famigliare[2] = membro;
            occupato[2] = true;
            giocatore.prendiMonete(bonusAreaTre[0]);
            giocatore.incremPuntiMil(bonusAreaTre[1]);
        } else{System.out.print("area già occupata");}
    }

    public void getBonusPrivi(int numPrivilegio, Famigliare membro,Giocatore giocatore) {
        if (occupato[3] == false) {
            famigliare[3] = membro;
            occupato[3] = true;
            int[] ris = new int[2];
            if (privilegioPreso[numPrivilegio] == false) {
                if (privilegio[numPrivilegio][0] != 0) {
                    ris[0] = privilegio[numPrivilegio][0];
                    ris[1] = privilegio[numPrivilegio][1];
                    privilegioPreso[numPrivilegio] = true;
                    elencoPrivilegi[numPrivilegio] = "GiaPreso";
                    if(numPrivilegio == 0){
                        giocatore.prendiLegno(ris[0]);
                        giocatore.prendiPietra(ris[1]);
                    }
                    if(numPrivilegio == 1){
                        giocatore.prendiServitori(ris[0]);
                    }
                    if(numPrivilegio == 2){
                        giocatore.prendiMonete(ris[0]);
                    }
                    if(numPrivilegio == 3){
                        giocatore.incremPuntiMil(ris[0]);
                    }
                    if(numPrivilegio == 4){
                        giocatore.decremPuntiFede(ris[0]);
                    }
                }
            } else {
                ris[0] = 0;
                ris[1] = 0;//STAMPARE UN MESSAGGIO PRIVILEGIO GIA PRESO
                System.out.print("privilegio gia preso");
            }


        } else{System.out.print("area già occupata");}
    }


    public String[] mostraTuttiPrivilegio() {
        return elencoPrivilegi;
    }


    public void pulisci() {
        for (int i = 0; i < quantiGiocatori; i++) {
            famigliare[i] = null;
        }
    }
}
