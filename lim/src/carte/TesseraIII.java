package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 02/06/2017.
 */
public class TesseraIII extends TesseraScomunica {

    private String tipoMalus;

    public TesseraIII(String tipo){
        super(3);
        tipoMalus = tipo;
    }

    public String getTipoMalus(){return tipoMalus;}
}
