package carte;

/**
 * Created by dimitri on 15/05/2017.
 */
public class CartaEdifici extends Carta {
    private int costoLegno;
    private int costoPietra;
    private String nome;
    private String effettoImm;
    private String effettoPer; //vedere se fare classe con tutti gli effetti

    public CartaEdifici(int costlegn,int costpiet,String nome,String effettoImmed,String effettoPerman,int period,int costo){
        super(period,costo);
        costoLegno = costlegn;
       costoPietra = costpiet;
        this.nome = nome;
        effettoImm = effettoImmed;
        effettoPer = effettoPerman;
    }
}
