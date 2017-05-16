package Risorse;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Moneta extends Risorsa {
    private int valoreRisorsa = 0;

    public Moneta(){
        valoreRisorsa = 0;
    }
    public Moneta( int valoreRisorsa){
        this.valoreRisorsa = valoreRisorsa;
    }
    public int getValoreRisorsa(){
        return valoreRisorsa;
    }

    public void impostaRis(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }
}
