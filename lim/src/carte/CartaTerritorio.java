package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 15/05/2017.
 */
public class CartaTerritorio extends Carta {
    private String nome;
    private int periodo;
    private Risorsa[] bonusIstantaneo = new Risorsa[2];
    private Risorsa[] bonusPermanente =  new Risorsa[2];
    private int valoreAzioneRaccolta;

    public CartaTerritorio(String nome,Risorsa bonusImm1,Risorsa bonusImm2,Risorsa bonusPer1,
            Risorsa bonusPer2,int period,int valore){
        super(period);
        this.nome = nome;
        bonusIstantaneo[0] = bonusImm1;
        bonusIstantaneo[1] = bonusImm2;
        bonusPermanente[0] = bonusPer1;
        bonusIstantaneo[1] = bonusPer2;
        valoreAzioneRaccolta = valore;
    }

    public Risorsa[] getBonusIstantaneo(){return bonusIstantaneo;}

    public Risorsa[] getBonusPermanente(){return bonusPermanente;}

    public int getValoreRaccolta(){return valoreAzioneRaccolta;}

   /* @Override
    public void stampa() {
        System.out.println("parte la stampa di cartaterritorio nome carta");
        System.out.println(nome);


        System.out.println("bonus pos 0 carta "+bonusIstantaneo[1].getValoreRisorsa());

    }*/
}

//vedere punti vittoria se servono
