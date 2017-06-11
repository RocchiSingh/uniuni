package tabellone;
import giocatore.Giocatore;
import principale.*;
import tabellone.RaccoltaProduzione.Produzione;
import tabellone.RaccoltaProduzione.Raccolto;
import tabellone.chiesa.Chiesa;
import tabellone.torre.AreaTorre;
import tabellone.torre.Torre;
import risorse.*;

import java.util.Scanner;


/**
 * Created by dimitri on 18/05/2017.
 */
public class Tabellone {
        private Dado dadoNero=new Dado(Colore.BLACK);
        private Dado dadoBianco=new Dado(Colore.WHITE);
        private Dado dadoArancione=new Dado(Colore.ORANGE);

       private Torre torreTerritori = new Torre(Colore.GREEN, new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
                new AreaTorre(2, new Legna(1), 5), new AreaTorre(3, new Legna(2),7));

        private Torre torreEdifici = new Torre(Colore.YELLOW, new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
                new AreaTorre(2, new PuntiMilitari(1), 5), new AreaTorre(3, new PuntiMilitari(2), 7));

        private Torre torrePersonaggi = new Torre(Colore.BLUE, new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
                new AreaTorre(2, new Pietra(1), 5), new AreaTorre(3, new Pietra(2),7));


        private Torre torreImprese = new Torre(Colore.VIOLET, new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
                new AreaTorre(2, new Moneta(1), 5), new AreaTorre(3, new Moneta(2),7));

//guarda qua come sono passate le risorse dopo ci basta una funzione per riconoscere la classe e bom. faremo get e set
        private Mercato mercatoDueAree = new Mercato(new Moneta(5),new Servitore(5));
        private Mercato mercatoQuattroAree=new Mercato(new Moneta(5),new Servitore(5),
                new Moneta(2),new PuntiMilitari(3));

        private Consiglio consiglio =new Consiglio();
        private Chiesa chiesa=new Chiesa();

        private Raccolto raccolto =new Raccolto();
        private Produzione produzione=new Produzione();//inserire metodi che valutino il numero di giocatori per abilitare o disabilitare le aree.

        public void lanciaDadi(){
            dadoNero.lancia();
            dadoBianco.lancia();
            dadoArancione.lancia();
        }
        public void pulisci(){
            torreTerritori.pulisciTorre();
            torreEdifici.pulisciTorre();
            torreImprese.pulisciTorre();
            torrePersonaggi.pulisciTorre();
            consiglio.pulisciCons();
            mercatoDueAree.pulisci();
            mercatoQuattroAree.pulisci();


        }

    public void posizionaTorre(int pianoTorre, Torre torre, Famigliare fam, Giocatore giocatore){
        torre.posizionaFamigliare(fam,pianoTorre,giocatore);
    }

    public void posizionaRaccolto(Famigliare fam,Giocatore giocatore){
        raccolto.inserisciMembro(fam,giocatore);
    }

    public void posizionaProduzione(Famigliare fam,Giocatore giocatore){
        produzione.inserisciMembro(fam,giocatore);
    }

    public void posizionaConsiglio(Famigliare fam,Giocatore giocatore,int sceltaPrivilegio){
        consiglio.inserisciFam(fam,sceltaPrivilegio,giocatore);
    }

    public void posizionaMercaato4aree(Famigliare fam,Giocatore giocatore,int scegliArea){
            if(scegliArea == 1){
                mercatoQuattroAree.getBonusAreaUno(fam,giocatore);
            }
            if(scegliArea == 2){
                mercatoQuattroAree.getBonusAreaDue(fam,giocatore);
            }
            if(scegliArea == 3){
                mercatoQuattroAree.getBonusAreaTre(fam,giocatore);
            }
            if(scegliArea == 4){
                System.out.print("scegli privilegio:" +
                        "0=legno/pietra" +
                        "1=servitori"+
                        "2=monete" +
                        "3=punti militari" +
                        "4=punti fede");
                Scanner scan = new Scanner(System.in);
                int numeropriv = scan.nextInt();
                mercatoQuattroAree.getBonusPrivi(numeropriv,fam,giocatore);
            }
    }

    public void posizionaMercaato2aree(Famigliare fam,Giocatore giocatore,int scegliArea){
        if(scegliArea == 1){
            mercatoDueAree.getBonusAreaUno(fam,giocatore);
        }
        if(scegliArea == 2){
            mercatoDueAree.getBonusAreaDue(fam,giocatore);
        }
        if(scegliArea == 3){
            mercatoDueAree.getBonusAreaTre(fam,giocatore);
        }
        if(scegliArea == 4){
            System.out.print("scegli privilegio:" +
                    "0=legno/pietra" +
                    "1=servitori"+
                    "2=monete" +
                    "3=punti militari" +
                    "4=punti fede");
            Scanner scan = new Scanner(System.in);
            int numeropriv = scan.nextInt();
            mercatoDueAree.getBonusPrivi(numeropriv,fam,giocatore);
        }
    }
}

