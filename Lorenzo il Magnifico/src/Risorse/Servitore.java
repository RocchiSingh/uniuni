package risorse;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Servitore extends Risorsa {

    private int valoreRisorsa = 0;

    public Servitore(){
        valoreRisorsa = 0;
    }
    public Servitore( int valoreRisorsa){
        this.valoreRisorsa = valoreRisorsa;
    }
    public int getValoreRisorsa(){
        return valoreRisorsa;
    }

    public void impostaRis(int valoreRisorsa) { //usare le eccezzioni

        this.valoreRisorsa = valoreRisorsa;
    }
}
