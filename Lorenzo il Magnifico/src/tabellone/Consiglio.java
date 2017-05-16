/**
 * Created by dimitri on 16/05/2017.
 */
public class Consiglio {

    private final int vincolo = 1;
    private final int ricompensaMoneta = 1;
    private Privilegio privilegio = new Privilegio();
    private Famigliare[] ordArr = new Famigliare[16];

    public void inserisciFam(Famigliare membro){
        for (int i=0;i<17;i++){
            if(ordArr[i] == null){
                ordArr[i] = membro;
            }
        }
    }

    public void pulisciCons(){
        for(int i=0;i<17;i++){
            ordArr[i] = null;
        }
    }

    public Famigliare[] getOrdArr(){
        return ordArr;
    }
}
