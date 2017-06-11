package carte;

import risorse.Risorsa;

/**
 * Created by dimitri on 16/05/2017.
 */
public class CartaImprese extends Carta  {
    private int costoMilitare;
    private int costoLegno;
    private int costoPietra;
    private int costoMoneta;
    private int costoServitori;
    private String nome;
    private int periodo;
    private Risorsa[] effettoIstant = new Risorsa[3];
    private int puntiVittoriaFinali;
    private int vincoloMilitare;
    private String tipoAzioneIstant = null;
    private int valoreAzioneIstant = 0;

    public CartaImprese(int costoMil,int costoLeg,int costoPie,int costoMon,int costoServ,String nome,Risorsa ris1
            ,Risorsa ris2,Risorsa ris3,String tipoAzione,int valoreAzione,int puntiVitt,int period,int vincolo){
        super(period);
        costoMilitare = costoMil;
        costoLegno = costoLeg;
        costoPietra = costoPie;
        costoMoneta = costoMon;
        costoServitori = costoServ;
        this.nome = nome;
        puntiVittoriaFinali = puntiVitt;
        effettoIstant[0] = ris1;
        effettoIstant[1] = ris2;
        effettoIstant[2] = ris3;
        tipoAzioneIstant = tipoAzione;
        valoreAzioneIstant = valoreAzione;
        vincoloMilitare = vincolo;
    }

    public int getCostoLegno(){return costoLegno;}
    public int getCostoPietra(){return costoPietra;}
    public int getCostoServitori(){return costoServitori;}
    public int getCostoMoneta(){return costoMoneta;}
    public int getCostoMilitare(){return costoMilitare;}

    public Risorsa[] getEffettoIstant(){return effettoIstant;}

    public int getPuntiVittoriaFinali(){return puntiVittoriaFinali;}

    public int getVincoloMilitare(){return vincoloMilitare;}

    public String getTipoAzioneIstant(){return tipoAzioneIstant;}

    public int getValoreAzioneIstant(){return valoreAzioneIstant;}
}
