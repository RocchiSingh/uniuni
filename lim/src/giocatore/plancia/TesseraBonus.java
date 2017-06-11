package giocatore.plancia;

import risorse.*;

/**
 * Created by dimitri on 17/05/2017.
 */
public class TesseraBonus {
    private final PuntiMilitari ricompPuntiMil = new PuntiMilitari(1);
    private final Moneta ricompMoneta = new Moneta(2);
    private final Legna ricompLegno = new Legna(1);
    private final Pietra ricompPietra = new Pietra(1);
    private final Servitore ricompServitore = new Servitore(1);
    private Risorsa[] ricompense = new Risorsa[3];

    public Risorsa[] getRicompProd(){
        ricompense[0] = ricompPuntiMil;
        ricompense[1] = ricompMoneta;
        return ricompense;
    }

    public Risorsa[] getRicompRaccolta(){
        ricompense[0] = ricompLegno;
        ricompense[1] = ricompPietra;
        ricompense[2] = ricompServitore;
        return ricompense;
    }
}
