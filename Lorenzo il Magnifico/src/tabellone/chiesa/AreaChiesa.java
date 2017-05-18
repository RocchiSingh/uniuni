package tabellone.chiesa;

import carte.TesseraScomunica;

/**
 * Created by dimitri on 16/05/2017.
 */
public class AreaChiesa {
    private TesseraScomunica tessera;
    private int vincoloFede;
    private CuboScomunica[] cuboscomunica = new CuboScomunica[4];
    private int periodo;

    public AreaChiesa(TesseraScomunica tess,int vincolo,int period){
        tessera = tess;
        vincoloFede = vincolo;
        periodo = period;
    }

    public TesseraScomunica getTessera(){return tessera;}

    public int getVincoloFede(){return vincoloFede;}

    public int getPeriodo(){return periodo;}

    public void setTessera(TesseraScomunica tess){
        tessera = tess;
    }

    public void togliTessera(){
        tessera = null;
    }
}
