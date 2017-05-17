package risorse;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class PuntiMilitari extends Risorsa {
    private int valoreRisorsa = 0;

    public PuntiMilitari(){
        valoreRisorsa = 0;
    }
    public PuntiMilitari (int valoreRisorsa){
        this.valoreRisorsa = valoreRisorsa;
    }
    public int getValoreRisorsa(){
        return valoreRisorsa;
    }

    public void impostaRis(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }
}
