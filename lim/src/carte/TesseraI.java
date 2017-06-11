package carte;

import risorse.*;

/**
 * Created by dimitri on 29/05/2017.
 */
public class TesseraI extends TesseraScomunica {

    private Risorsa risorsa = null;
    private Risorsa risorsa2 = null;

    public TesseraI(Moneta m){
        super(1);
        risorsa = m;
    }

    public TesseraI(PuntiMilitari p){
        super(1);
        risorsa = p;
    }

    public TesseraI(Servitore s){
        super(1);
        risorsa = s;
    }

    public TesseraI(Legna l,Pietra p){ //considerare solo il legno e ricordarsi che ci va anche la pietra
        super(1);
        risorsa = l;
        risorsa2 = p;
    }

    public Risorsa getRisorsa(){return risorsa;}

}
