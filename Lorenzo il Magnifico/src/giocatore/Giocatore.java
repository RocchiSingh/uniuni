package giocatore;

import giocatore.disco.DiscoFede;
import giocatore.disco.DiscoMilitare;
import giocatore.disco.DiscoTurni;
import giocatore.disco.DiscoVittoria;
import giocatore.plancia.Plancia;
import principale.Colore;
import principale.Famigliare;
import risorse.Legna;
import risorse.Moneta;
import risorse.Pietra;
import risorse.Servitore;
import tabellone.chiesa.CuboScomunica;

/**
 * Created by dimitri on 17/05/2017.
 */
public class Giocatore {
    private String nome;
    private Plancia plancia;
    private Famigliare[] famGiocatore = new Famigliare[3];
    private CuboScomunica[] cubi = new CuboScomunica[2];
    private DiscoVittoria discoVittoria;
    private DiscoMilitare discoMilitare;
    private DiscoFede discoFede;
    private DiscoTurni discoTurni;
    private Legna risorseLegno;
    private Pietra risorsePietra;
    private Moneta monete;
    private Servitore servitori;
    private Colore colore;
    private static int puntiVittoria = 0;
    private static int puntiMilitari = 0;
    private static int puntiFede = 0;

    public static int getPuntiVittoria(){return puntiVittoria;}

    public static int getPuntiMilitari(){return puntiMilitari;}

    public static int getPuntiFede(){return puntiFede;}

    public void setColore(Colore color){
        for(int i=0;i<4;i++){
            famGiocatore[i].setColore(color);
        }
        for(int i=0;i<3;i++){
            cubi[i].setColore(color);
        }
    }

    public void setRisorseIniziali(){
        risorseLegno.impostaRis(2);
        risorsePietra.impostaRis(2);
        servitori.impostaRis(2);
    }
}
