package tabellone;
import principale.*;
import tabellone.RaccoltaProduzione.Produzione;
import tabellone.RaccoltaProduzione.Raccolto;
import tabellone.chiesa.Chiesa;
import tabellone.torre.AreaTorre;
import tabellone.torre.Torre;
import risorse.*;

public class Tabellone {

    private Dado dadoNero=new Dado(Colore.BLACK);
    private Dado dadoBianco=new Dado(Colore.WHITE);
    private Dado dadoArancione=new Dado(Colore.ORANGE);

    private Torre torreTerritori = new Torre("territori", new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
            new AreaTorre(2, new Legna(1), 5), new AreaTorre(3, new Legna(2),7));

    private Torre torreEdifici = new Torre("edifici", new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
            new AreaTorre(2, new PuntiMilitari(1), 5), new AreaTorre(3, new PuntiMilitari(2), 7));

    private Torre torrePersonaggi = new Torre("personaggi", new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
            new AreaTorre(2, new Pietra(1), 5), new AreaTorre(3, new Pietra(2),7));


    private Torre torreImprese = new Torre("imprese", new AreaTorre(0, null, 1), new AreaTorre(1, null, 3),
            new AreaTorre(2, new Moneta(1), 5), new AreaTorre(3, new Moneta(2),7));


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

}