package giocatore;

import carte.*;
import giocatore.disco.DiscoFede;
import giocatore.disco.DiscoMilitare;
import giocatore.disco.DiscoTurni;
import giocatore.disco.DiscoVittoria;
import giocatore.plancia.Plancia;
import giocatore.plancia.VettoreTerritori;
import principale.Colore;
import principale.Famigliare;
import risorse.*;
import tabellone.chiesa.CuboScomunica;

/**
 * Created by dimitri on 17/05/2017.
 */
public class Giocatore {
    private String nome;
    private Colore colore ;
    private int posixTurnoIniz;
    private Plancia plancia = new Plancia();
    private Famigliare[] famGiocatore = new Famigliare[4];
    private CuboScomunica[] cubi = new CuboScomunica[3];
    private DiscoVittoria discoVittoria = new DiscoVittoria(colore,0);
    private DiscoMilitare discoMilitare = new DiscoMilitare(colore,0);
    private DiscoFede discoFede = new DiscoFede(colore,0);
    private DiscoTurni discoTurni = new DiscoTurni(colore,posixTurnoIniz);
    private Legna risorseLegno = new Legna(2);
    private Pietra risorsePietra = new Pietra(2);
    private Moneta monete = new Moneta();
    private Servitore servitori = new Servitore(2);
    private PuntiVittoria puntiVittoria = new PuntiVittoria();
    private PuntiMilitari puntiMilitari = new PuntiMilitari();
    private PuntiFede puntiFede = new PuntiFede();
    private Risorsa malus1 = null;
    private int malusTerritori = 0;
    private int malusEdifici = 0;
    private int malusPersonaggi = 0;
    private int malusImprese = 0;
    private boolean malus3 = false;
    private String tipoMalus3 = null;
   // private boolean prendiCarta = false;
  //  private int valoreFrozaPrendiCarta = 0;

    public Giocatore(int posixTurnoIniz,Colore colore){
        this.posixTurnoIniz = posixTurnoIniz;
        this.colore = colore;
    }

    public Giocatore(){}

    public int getPuntiVittoria(){return puntiVittoria.getValoreRisorsa();}

    public int getPuntiMilitari(){return puntiMilitari.getValoreRisorsa();}

    public int getPuntiFede(){return puntiFede.getValoreRisorsa();}

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

    public void setColore(){ // QUESTO METODO NON SERVE BASTA METTERE UN COLORE NEL FAMIGLIARE E APPENA SI CREA UN OGGETTO ALL INTERNO DEL GIOCATORE NEL COSTRUTTORE SI PASSA IL COLORE DEL GIOCATORE:
        // TRANNE PER IL FAMIGLIARE NEUTRO CHE LO CHIAMIAMO PROPRIO NEUTRO COSI é PARTICOLARE E DIVERSO NEI CONTROLLI POSSIAMO FACILITAR LA COSA
        for(int i=0;i<3;i++){
            famGiocatore[i].setColore(colore);
        }famGiocatore[3].setColore(Colore.WHITE);  //famigliare neutro
        for(int i=0;i<3;i++){
            cubi[i].setColore(colore);
        }
    }

    public void setMoneteIniziali(){
        if(posixTurnoIniz == 1){monete.impostaRis(5);}
        if(posixTurnoIniz == 2){monete.impostaRis(6);}
        if(posixTurnoIniz == 3){monete.impostaRis(7);}
        if(posixTurnoIniz == 4){monete.impostaRis(8);}
    }

    private boolean pagaLegno(int prezzo){
        if(risorseLegno.getValoreRisorsa() >= prezzo){
            risorseLegno.decrementaRis(prezzo);
            return true;
        }return false;
    }

    private boolean pagaPietra(int prezzo){
        if(risorsePietra.getValoreRisorsa() >= prezzo){
            risorsePietra.decrementaRis(prezzo);
            return true;
        }return false;
    }

    private boolean pagaMoneta(int prezzo){
        if(monete.getValoreRisorsa() >= prezzo){
            monete.decrementaRis(prezzo);
            return true;
        }return false;
    }

    private boolean pagaServitori(int prezzo){
        if(servitori.getValoreRisorsa() >= prezzo){
            servitori.decrementaRis(prezzo);
            return true;
        }return false;
    }

    private void prendiLegno(int prezzo) {
        risorseLegno.incrementaRis(prezzo);
    }

    private void prendiPietra(int prezzo) {
        risorsePietra.incrementaRis(prezzo);
    }

    private void prendiMonete(int prezzo) {
        monete.incrementaRis(prezzo);
    }

    private void prendiServitori(int prezzo) {
        servitori.incrementaRis(prezzo);
    }

    public void setNickname(String nickname){
        nome = nickname;
    }

    public String getNickname(){
        return nome;
    }

    public void setMalus1(Risorsa malus){
        malus1 = malus;
    }

    public CuboScomunica getCubo(int periodo){
        if(periodo == 1){cubi[0].setScomunicato();return cubi[0];}
        if(periodo == 2){cubi[1].setScomunicato();return cubi[1];}
        if(periodo == 3){cubi[2].setScomunicato();return cubi[2];}
        return null;
    }

    public int getMalusTerritori(){return malusTerritori;}

    public int getMalusEdifici(){return malusEdifici;}

    public int getMalusPersonaggi(){return malusPersonaggi;}

    public int getMalusImprese(){return malusImprese;}

    public void setMalusEdifici(int m){
        malusEdifici = m;
    }

    public void setMalusTerritori(int m){
        malusTerritori = m;
    }

    public void setMalusPersonaggi(int m){
        malusPersonaggi = m;
    }

    public void setMalusImprese(int m){
        malusImprese = m;
    }

    public Boolean getMalus3(){return malus3;}

    public void setMalus3(boolean valore){malus3 = valore;}

    public String getTipoMalus3(){return tipoMalus3;}

    public void setTipoMalus3(String tipo){tipoMalus3 = tipo;}

    public void prendiRisorsa(Risorsa ris) { //gestire privilegio
        if (malus1 != null) {
            if (ris instanceof Legna && malus1 instanceof Legna) {
                prendiLegno(((Legna) ris).getValoreRisorsa() - ((Legna) malus1).getValoreRisorsa());
            }
            if (ris instanceof Pietra && malus1 instanceof Legna) {
                prendiPietra(((Pietra) ris).getValoreRisorsa() - ((Legna) malus1).getValoreRisorsa());
            }
            if (ris instanceof Moneta && malus1 instanceof Moneta) {
                prendiMonete(((Moneta) ris).getValoreRisorsa() - ((Moneta) malus1).getValoreRisorsa());
            }
            if (ris instanceof Servitore && malus1 instanceof Servitore) {
                prendiServitori(((Servitore) ris).getValoreRisorsa() - ((Servitore) malus1).getValoreRisorsa());
            }
            if (ris instanceof PuntiFede) {
                incremPuntiFede(((PuntiFede) ris).getValoreRisorsa());
            }
            if (ris instanceof PuntiMilitari && malus1 instanceof PuntiMilitari) {
                incremPuntiMil(((PuntiMilitari) ris).getValoreRisorsa() - ((PuntiMilitari) malus1).getValoreRisorsa());
            }
            if(ris instanceof PuntiVittoria) {
                incremPuntiVitt(ris.getValoreRisorsa());
            }
        }else{
            if(ris instanceof Legna){prendiLegno(((Legna) ris).getValoreRisorsa());}
            if(ris instanceof Pietra){prendiPietra(((Pietra) ris).getValoreRisorsa());}
            if(ris instanceof Moneta){prendiMonete(((Moneta) ris).getValoreRisorsa());}
            if(ris instanceof Servitore){prendiServitori(((Servitore) ris).getValoreRisorsa());}
            if(ris instanceof PuntiFede){incremPuntiFede(((PuntiFede) ris).getValoreRisorsa());}
            if(ris instanceof PuntiMilitari){incremPuntiMil(((PuntiMilitari) ris).getValoreRisorsa());}
            if(ris instanceof PuntiVittoria){incremPuntiVitt(ris.getValoreRisorsa());}
    }
    }

    public void prendiVettRisorsa(Risorsa[] ris){
        int i = 0;
        while(ris[i] != null){
            prendiRisorsa(ris[i]);
            i++;
        }

    }

    public void togliRisorsa(Risorsa ris){
        if(ris instanceof Legna){pagaLegno(((Legna) ris).getValoreRisorsa());}
        if(ris instanceof Pietra){pagaPietra(((Pietra) ris).getValoreRisorsa());}
        if(ris instanceof Moneta){pagaMoneta(((Moneta) ris).getValoreRisorsa());}
        if(ris instanceof Servitore){pagaServitori(((Servitore) ris).getValoreRisorsa());}
        if(ris instanceof PuntiFede){incremPuntiFede(((PuntiFede) ris).getValoreRisorsa());}
        if(ris instanceof PuntiMilitari){incremPuntiMil(((PuntiMilitari) ris).getValoreRisorsa());}
    }

    private boolean controllaCostoCarta(Carta carta){
        if(carta instanceof CartaTerritorio){return true;}
        if(carta instanceof CartaEdifici) {
            if (risorseLegno.getValoreRisorsa() >= ((CartaEdifici) carta).getCostoLegno()
                    && risorsePietra.getValoreRisorsa() >= ((CartaEdifici) carta).getCostoPietra()
                    && servitori.getValoreRisorsa() >= ((CartaEdifici) carta).getCostoServitori()
                    && monete.getValoreRisorsa() >= ((CartaEdifici) carta).getCostoMoneta()) {
                return true;
            } else {
                return false;
            }
        }
        if(carta instanceof CartaImprese){
            if (risorseLegno.getValoreRisorsa() >= ((CartaImprese) carta).getCostoLegno()
                    && risorsePietra.getValoreRisorsa() >= ((CartaImprese) carta).getCostoPietra()
                    && servitori.getValoreRisorsa() >= ((CartaImprese) carta).getCostoServitori()
                    && monete.getValoreRisorsa() >= ((CartaImprese) carta).getCostoMoneta()
                    || puntiMilitari.getValoreRisorsa() >= ((CartaImprese) carta).getVincoloMilitare()
                    && puntiMilitari.getValoreRisorsa() >= ((CartaImprese) carta).getCostoMilitare()) {
                return true;
            } else {
                return false;
            }

        }
        if(carta instanceof CartaPersonaggi){
            if(monete.getValoreRisorsa() >= ((CartaPersonaggi) carta).getCostoMonete()){
                return true;
            } else{
                return false;
            }
        }return false;
    }

    private void prendiPremioPersonaggio(Carta carta){
       if(carta instanceof CartaPersonaggi) {
           if (((CartaPersonaggi) carta).getTipoAzione().equals("null")) {
               int i = 0;
               if (((CartaPersonaggi) carta).getTipoRisScambio1().equals("punti vittoria")) {
                   if (((CartaPersonaggi) carta).getTipoRisScambio2().equals("cartapersonaggio")) {
                       i = (plancia.getPers().size()) * 2;
                       incremPuntiVitt(i);
                   }
                   if (((CartaPersonaggi) carta).getTipoRisScambio2().equals("cartaimpresa")) {
                       i = (plancia.getImp().size()) * 2;
                       incremPuntiVitt(i);
                   }
                   if (((CartaPersonaggi) carta).getTipoRisScambio2().equals("punti militari")) {
                       i = (getPuntiMilitari() / 2);
                       incremPuntiVitt(i);
                   }
               }
           } else {
               Risorsa[] risorse = ((CartaPersonaggi) carta).getRisorsaScambio();
               prendiRisorsa(risorse[0]);
               if (((CartaPersonaggi) carta).getTipoAzione().equals("raccolta")) {
                controllaBonusRaccolta(((CartaPersonaggi) carta).getValoreAzione());
               }
               if (((CartaPersonaggi) carta).getTipoAzione().equals("produzione")) {
                controllaBonusProduzione(((CartaPersonaggi) carta).getValoreAzione());
               }
           /* if(carta.getTipoAzione().equals("prendi carta")){
                /*fare la funzione predi carta che la aggiunge alla collezzione del giocatore ma prima aggiungere nel giocatore
                boolean prendiCarta che e true se si attivaa questo,e aggiungere int valoreForzaPrendiCarta
                 che passo da qua e nel metodo prendiCarta faro un if per specificare se prendiCarta = true cioe se lo sto chiamando solo
                 per via dell'effetto e faro la procedura...chiesso if nell'else metto metodo normale

            }*/
           }
       }
    }

    public void prendiCarta(Carta carta) {
        if (controllaCostoCarta(carta)) {
            if (carta instanceof CartaPersonaggi) {
                plancia.getPers().aggiungiCarta(((CartaPersonaggi) carta));
                prendiPremioPersonaggio(carta);
            }
            if (carta instanceof CartaTerritorio) {
                int[] vincolo = plancia.getTerr().getVincoloMil();
                if(vincolo[plancia.getTerr().size()] <= puntiMilitari.getValoreRisorsa()){
                    plancia.getTerr().aggiungiCarta(((CartaTerritorio) carta));
                    prendiVettRisorsa(((CartaTerritorio) carta).getBonusIstantaneo());
                }else{System.out.println("vincolo militare non rispettato non puoi prendere la carta");}
            }
            if(carta instanceof CartaEdifici){
                plancia.getEdif().aggiungiCarta(((CartaEdifici) carta));
                prendiVettRisorsa(((CartaEdifici) carta).getBonusIstantaneo());
            }
            if(carta instanceof CartaImprese){
                plancia.getImp().aggiungiCarta(((CartaImprese) carta));
                if(((CartaImprese) carta).getTipoAzioneIstant() != null){
                    if(((CartaImprese) carta).getTipoAzioneIstant() == "raccolta"){
                        controllaBonusRaccolta(((CartaImprese) carta).getValoreAzioneIstant());
                    }
                    if(((CartaImprese) carta).getTipoAzioneIstant() == "produzione"){
                        controllaBonusProduzione(((CartaImprese) carta).getValoreAzioneIstant());
                    }
                }else{
                prendiVettRisorsa(((CartaImprese) carta).getEffettoIstant());
                }
            }
        }else{System.out.println("costo non soddisfacibile");}
    }

    public void controllaBonusRaccolta(int forzaFami){
        for(int i=0;i<6;i++){
            if(forzaFami >= plancia.getTerr().getCarta(i).getValoreRaccolta()){
                prendiVettRisorsa(plancia.getTerr().getCarta(i).getBonusPermanente());
            }
        }
    }

    public void controllaBonusProduzione(int forzaFami){
        for(int i=0;i<6;i++){
            if(forzaFami >= plancia.getEdif().getCarta(i).getValoreAzioneProd()){
                prendiVettRisorsa(plancia.getEdif().getCarta(i).getBonusPermanente());
            }
        }
    }
}
