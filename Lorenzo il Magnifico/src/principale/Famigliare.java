package principale;

import tabellone.Consiglio;
import tabellone.Mercato;
import tabellone.RaccoltaProduzione.Produzione;
import tabellone.RaccoltaProduzione.Raccolto;
import tabellone.torre.AreaTorre;
import tabellone.torre.Torre;
import giocatore.*;
import java.io.*;
import java.util.Scanner;


/**
 * Created by dimitri on 13/05/2017.
 */
public class Famigliare {
    private static Colore colore =null;//aggiungere id per distinguere i neutri
    private int forzaFami=0;
    private Colore coloreDado;
    private Giocatore giocAppartenenza;

    public Famigliare ( Colore colore)
    {
        this.colore=colore;

    }
    public Famigliare ( Colore colore, Colore coloreDado, int forzaFami )
    {
        this.colore=colore;
        this.coloreDado=coloreDado;
        this.forzaFami=forzaFami;

    }
    public void incrementaForza(int numServitori){

        forzaFami+=numServitori;
    }

    public void decrementaForza(int forzaDaTogliere){

        forzaFami-=forzaDaTogliere;
    }
    public void posizionaTorre(AreaTorre area, Torre torre,Famigliare fam){
       if(! area.getOcccupato() && !torre.contrlPresFam(fam.getColore())) {//fare controllo sull area se è prente o no
           if (forzaFami >= area.getVincolodado()) {
               area.setMembro(fam);// dovrei passare il famigliare stesso in quella area facendo controllo opportuni
           }
       }
       if(!area.getOcccupato() && torre.contrlPresFam(fam.getColore()) && fam.colore == Colore.WHITE){
           //significa che sto inserendo famigliare neutro
           if (forzaFami >= area.getVincolodado()){
               area.setMembro(fam);
           }
       }
       if(!area.getOcccupato() && torre.contrlPres()){
           //devo pagare tre monete perchè c'è un altro famigliare presente
           if(forzaFami >= area.getVincolodado()){
               area.setMembro(fam);
               giocAppartenenza.pagaMoneta(3);
           }
       }
       if(area.getOcccupato()){System.out.print("area occupata");}
       if(torre.contrlPresFam(fam.getColore()) && fam.colore != Colore.WHITE){
           System.out.print("famigliare presente nella torre! usare famigliare neutro");
       }
    }

    public void posizionaProduzione(Produzione produzione,Famigliare fam){
        produzione.inserisciMembro(fam);
    }

    public void posizionaRaccolto(Raccolto raccolto,Famigliare fam){
        raccolto.inserisciMembro(fam);
    }

    public void posizionaConsiglio(Consiglio consiglio,Famigliare fam){
        consiglio.inserisciFam(fam,giocAppartenenza);
    }

    public void posizionaMercato(Mercato mercato,Famigliare fam,int scegliarea){
        if(scegliarea == 1){
            mercato.getBonusAreaUno(fam,giocAppartenenza);
        }
        if(scegliarea == 2){
            mercato.getBonusAreaDue(fam,giocAppartenenza);
        }
        if(scegliarea == 3){
            mercato.getBonusAreaTre(fam,giocAppartenenza);
        }
        if(scegliarea == 4){
            System.out.print("scegli privilegio:" +
                    "0=legno/pietra" +
                    "1=servitori"+
                    "2=monete" +
                    "3=punti militari" +
                    "4=punti fede");
            Scanner scan = new Scanner(System.in);
            int numeropriv = scan.nextInt();
            mercato.getBonusPrivi(numeropriv,fam,giocAppartenenza);
        }
    }

    public static Colore getColore(){
        return colore;
    }

    public void setColore(Colore color){
        colore = color;
    }

    public int getForzaFami(){return forzaFami;}

}
