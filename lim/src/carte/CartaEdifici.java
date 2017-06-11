package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 15/05/2017.
 */
public class CartaEdifici extends Carta {
    private int costoLegno;
    private int costoPietra;
    private int costoMoneta;
    private int costoServitori;
    private String nome;
    private int periodo;
    private Risorsa[] bonusIstantaneo = new Risorsa[2];
    private Risorsa[] bonusPermanente =  new Risorsa[2];
    private int valoreAzioneProd;


    public CartaEdifici(int costlegn,int costpiet,int costomon,int costoserv,String nome,
                        Risorsa bonusImm1,Risorsa bonusImm2,Risorsa bonusPer1,
                        Risorsa bonusPer2,int period,int valore){
        super(period);
        costoLegno = costlegn;
       costoPietra = costpiet;
       costoMoneta = costomon;
       costoServitori = costoserv;
        this.nome = nome;
        bonusIstantaneo[0] = bonusImm1;
        bonusIstantaneo[1] = bonusImm2;
        bonusPermanente[0] = bonusPer1;
        bonusIstantaneo[1] = bonusPer2;
        valoreAzioneProd = valore;
    }

    public int getCostoLegno(){return costoLegno;}
    public int getCostoPietra(){return costoPietra;}
    public int getCostoServitori(){return costoServitori;}
    public int getCostoMoneta(){return costoMoneta;}

    public Risorsa[] getBonusIstantaneo(){return bonusIstantaneo;}

    public Risorsa[] getBonusPermanente(){return bonusPermanente;}

    public int getValoreAzioneProd(){return valoreAzioneProd;}
}
