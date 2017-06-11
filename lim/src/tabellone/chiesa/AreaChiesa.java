package tabellone.chiesa;

import carte.TesseraI;
import carte.TesseraII;
import carte.TesseraIII;
import carte.TesseraScomunica;
import risorse.Risorsa;

/**
 * Created by dimitri on 16/05/2017.
 */
public class AreaChiesa {
    private TesseraScomunica tessera ;
    private CuboScomunica[] cuboscomunica = new CuboScomunica[4];
    private int periodo;

    public AreaChiesa(TesseraI tess){
        tessera = tess;
        periodo = 1;
    }

    public AreaChiesa(TesseraII tess){
        tessera = tess;
        periodo = 2;
    }

    public AreaChiesa(TesseraIII tess){
        tessera = tess;
        periodo = 3;
    }

    public TesseraScomunica getTessera(){return tessera;}

    public int getPeriodo(){return periodo;}

    public void setTessera(TesseraScomunica tess){
        tessera = tess;
    }

    public void togliTessera(){
        tessera = null;
    }

    public Risorsa getRisorsa(){return tessera.getRisorsa();}

    public void setCuboscomunica(CuboScomunica cubo){
        for(int i=0;i<5;i++){
            if(cuboscomunica[i] == null){
                cuboscomunica[i] = cubo;
                return;
            }
        }
    }

}
