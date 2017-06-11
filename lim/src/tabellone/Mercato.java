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
    private Moneta bonusAreaUno = null;
    private Servitore bonusAreaDue = null;
    private Risorsa[] bonusAreaTre = new Risorsa[2];
    private Risorsa[][] privilegio = new Risorsa[5][2];
    private boolean[] privilegioPreso = {false, false, false, false, false};
    private String[] elencoPrivilegi = {"LegnaPietra", "Servitore", "Monete", "PuntiMilitari", "PuntiFede"};

    //tengo due costruttori per usare 2 mercati diversi a secondo del numero dei giocatori;
    public Mercato() {
    }

    public Mercato(Moneta bonusA1, Servitore bonusA2) {
        bonusAreaUno = bonusA1;
        bonusAreaDue = bonusA2;

        bonusAreaTre[0] = null;
        bonusAreaTre[1] = null;
        privilegio[0][0] = null;
        privilegio[0][1] = null;
        privilegio[1][0] = null;
        privilegio[1][1] = null;
        privilegio[2][0] = null;
        privilegio[2][1] = null;
        privilegio[3][0] = null;
        privilegio[3][1] = null;
        privilegio[4][0] = null;
        privilegio[4][1] = null;

    }

    public Mercato(Moneta bonusA1, Servitore bonusA2, Moneta denaro, PuntiMilitari puntiMilitari) {
        this(bonusA1, bonusA2);
        bonusAreaTre[0] = denaro;
        bonusAreaTre[1] = puntiMilitari;
        privilegio[0][0] = new Legna(1);
        privilegio[0][1] = new Pietra(1);
        privilegio[1][0] = new Servitore(2);
        privilegio[1][1] = null;
        privilegio[2][0] = new Moneta(2);
        privilegio[2][1] = null;
        privilegio[3][0] = new PuntiMilitari(2);
        privilegio[3][1] = null;
        privilegio[4][0] = new PuntiFede(1);
        privilegio[4][1] = null;


    }

    public void getBonusAreaUno(Famigliare membro, Giocatore giocatore) {
        if (occupato[0] == false) {
            famigliare[0] = membro;
            occupato[0] = true;
            giocatore.prendiRisorsa(bonusAreaUno);
        }
    }

    public void getBonusAreaDue(Famigliare membro,Giocatore giocatore) {
        if (occupato[1] == false) {
            famigliare[1] = membro;
            occupato[1] = true;
            giocatore.prendiRisorsa(bonusAreaDue);
        }
    }

    public void getBonusAreaTre(Famigliare membro,Giocatore giocatore) {
        if (occupato[2] == false) {
            famigliare[2] = membro;
            occupato[2] = true;
            giocatore.prendiVettRisorsa(bonusAreaTre);
        }
    }

    public void getBonusPrivi(int numPrivilegio, Famigliare membro,Giocatore giocatore) {
        if (occupato[3] == false) {
            famigliare[3] = membro;
            occupato[3] = true;
            Risorsa[] ris = new Risorsa[2];
            if (privilegioPreso[numPrivilegio] == false) {
                if (privilegio[numPrivilegio][0] != null) {
                    ris[0] = privilegio[numPrivilegio][0];
                    ris[1] = privilegio[numPrivilegio][1];
                    privilegioPreso[numPrivilegio] = true;
                    elencoPrivilegi[numPrivilegio] = "GiaPreso";
                }
            } else {
                ris[0] = null;
                ris[1] = null;
                System.out.println("privilegio gia preso");
            }

            giocatore.prendiVettRisorsa(ris);
        }
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
