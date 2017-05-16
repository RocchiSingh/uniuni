package carte;

/**
 * Created by dimitri on 16/05/2017.
 */
public class CartaImprese extends Carta  {
    private int costoMilitare;
    private int costoLegno;
    private int costoPietra;
    private String nome;
    private String effettoImm;
    //vedere se fare classe con tutti gli effetti
    private int puntiVittoria;

    public CartaImprese(int costoMil,int costoLeg,int costoPie,String nome,String effettoImmed,int puntiVitt){
        costoMilitare = costoMil;
        costoLegno = costoLeg;
        costoPietra = costoPie;
        this.nome = nome;
        effettoImm = effettoImmed;
        puntiVittoria = puntiVitt;
    }
}
