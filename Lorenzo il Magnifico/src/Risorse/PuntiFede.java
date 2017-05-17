package risorse;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class PuntiFede extends Risorsa {private int valoreRisorsa = 0;

    public PuntiFede(){
        valoreRisorsa = 0;
    }
    public PuntiFede( int valoreRisorsa){
        this.valoreRisorsa = valoreRisorsa;
    }
    public int getValoreRisorsa(){
        return valoreRisorsa;
    }

    public void impostaRis(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }
}
