package giocatore;

import giocatore.disco.DiscoFede;
import giocatore.disco.DiscoMilitare;
import giocatore.disco.DiscoTurni;
import giocatore.disco.DiscoVittoria;
import giocatore.plancia.Plancia;
import principale.Colore;
import principale.Famigliare;
import risorse.*;
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
    private static Legna risorseLegno;
    private static Pietra risorsePietra;
    private static Moneta monete;
    private static Servitore servitori;
    private Colore colore;
    private static PuntiVittoria puntiVittoria = null;
    private static PuntiMilitari puntiMilitari = null;
    private static PuntiFede puntiFede = null;

    public static PuntiVittoria getPuntiVittoria(){return puntiVittoria;}

    public static PuntiMilitari getPuntiMilitari(){return puntiMilitari;}

    public static PuntiFede getPuntiFede(){return puntiFede;}

    public void setPuntiFede(int punti){
        puntiFede.impostaRis(punti);
    }

    public void setPuntiMilitari(int punti){
        puntiMilitari.impostaRis(punti);
    }

    public void setPuntiVittoria(int punti){
        puntiVittoria.impostaRis(punti);
    }

    public void incremPuntiFede(int quantità){
        puntiFede.incrementaFede(quantità);
    }

    public void incremPuntiMil(int quantità){
        puntiMilitari.incrementaMil(quantità);
    }

    public void incremPuntiVitt(int quantità){
        puntiVittoria.incrementaVitt(quantità);
    }

    public void decremPuntiFede(int quantità){
        puntiFede.decrementaFede(quantità);
    }

    public void decremPuntiMil(int quantità){
        puntiMilitari.decrementaMil(quantità);
    }

    public void decremPuntiVitt(int quantità){
        puntiVittoria.decrementaVitt(quantità);
    }

    public void setColore(Colore color){
        for(int i=0;i<3;i++){
            famGiocatore[i].setColore(color);
        }famGiocatore[3].setColore(Colore.WHITE);  //famigliare neutro
        for(int i=0;i<3;i++){
            cubi[i].setColore(color);
        }
        discoFede.setColor(color);
        discoMilitare.setColor(color);
        discoVittoria.setColor(color);
        discoTurni.setColor(color);
    }

    public void setRisorseIniziali(){
        risorseLegno.impostaRis(2);
        risorsePietra.impostaRis(2);
        servitori.impostaRis(2);
    }

    public static boolean pagaLegno(int prezzo){
        if(risorseLegno.getValoreRisorsa() >= prezzo){
            risorseLegno.decrementaRis(prezzo);
            return true;
        }return false;
    }

    public static boolean pagaPietra(int prezzo){
        if(risorsePietra.getValoreRisorsa() >= prezzo){
            risorsePietra.decrementaRis(prezzo);
            return true;
        }return false;
    }

    public static boolean pagaMoneta(int prezzo){
        if(monete.getValoreRisorsa() >= prezzo){
            monete.decrementaRis(prezzo);
            return true;
        }return false;
    }

    public static void prendiLegno(int prezzo) {
        risorseLegno.incrementaRis(prezzo);
    }

    public static void prendiPietra(int prezzo) {
        risorsePietra.incrementaRis(prezzo);
    }

    public static void prendiMonete(int prezzo) {
        monete.incrementaRis(prezzo);
    }

    public static void prendiServitori(int prezzo) {
        servitori.incrementaRis(prezzo);
    }

    public void setNickname(String nickname){
        nome = nickname;
    }

    public String getNickname(){
        return nome;
    }
}
