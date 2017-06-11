package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 16/05/2017.
 */
public class CartaPersonaggi extends Carta  {
    private int costoMonete;
    private String nome;
    private int periodo;
    private Risorsa[] risorsaScambio = new Risorsa[2]; //in 0 risorsaa che guadagno in 1 risorse che servono
    private String tipoRisScambio1 = null;
    private String tipoRisScambio2 = null;
    private int valoreAzione; //valore azione raccolta/prod/prendere carta
    private String tipoAzione = null; //tipo di azione che posso compiere

    public CartaPersonaggi(int money,String nome,Risorsa ris1,Risorsa ris2,String tipo1
            ,String tipo2,int valoreAz,String tipoAz,int period){
        super(period);
        costoMonete = money;
        this.nome = nome;
        risorsaScambio[0] = ris1;
        risorsaScambio[1] = ris2;
        tipoRisScambio1 = tipo1;
        tipoRisScambio2 = tipo2;
        valoreAzione = valoreAz;
        tipoAzione = tipoAz;
    }

    public int getCostoMonete(){return costoMonete;}

    public Risorsa[] getRisorsaScambio(){return risorsaScambio;}

    public String getTipoRisScambio1(){return tipoRisScambio1;}
    public String getTipoRisScambio2(){return tipoRisScambio2;}

    public int getValoreAzione(){return valoreAzione;}
    public String getTipoAzione(){return tipoAzione;}


}
