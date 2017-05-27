package giocatore.plancia;

import risorse.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class TesseraBonus {
    private final static PuntiMilitari ricompPuntiMil = new PuntiMilitari(1);
    private final static Moneta ricompMoneta = new Moneta(2);
    private final static Legna ricompLegno = new Legna(1);
    private final static  Pietra ricompPietra = new Pietra(1);
    private final static Servitore ricompServitore = new Servitore(1);

    public static void setRicompProd(){
        /*giocatore.puntiMilitari+ = ricompPuntiMil*/;
        /*giocatore.monete+ = ricompMoneta*/;
    }

    public static void setRicompRaccolta(){
        /*giocatore.legno+ = ricompLegno*/;
        /*giocatore.pietra+ = ricompPietra*/;
        /*giocatore.servitori+ = ricompServitore*/;
    }
}
