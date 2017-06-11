package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 01/06/2017.
 */
public class TesseraII extends TesseraScomunica {

    private int malusForza =4;
    private String tipo = null;

    public TesseraII(String tipo){
        super(2);
        this.tipo = tipo;
    }

    public String getTipo(){return tipo;}

}
