package risorse;

/**
 * Created by dimitri on 23/05/2017.
 */
public class PuntiVittoria extends Risorsa {
    private int valoreRisorsa = 0;

    public PuntiVittoria(){
        valoreRisorsa = 0;
    }
    public PuntiVittoria (int valoreRisorsa){
        this.valoreRisorsa = valoreRisorsa;
    }
    public int getValoreRisorsa(){
        return valoreRisorsa;
    }

    public void impostaRis(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }

    public void incrementaVitt(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa += valoreRisorsa;
    }

    public void decrementaVitt(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }
}
