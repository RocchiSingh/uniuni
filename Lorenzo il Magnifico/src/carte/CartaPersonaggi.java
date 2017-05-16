package carte;

/**
 * Created by dimitri on 16/05/2017.
 */
public class CartaPersonaggi extends Carta  {
    private int costoMonete;
    private String nome;
    private String effettoImm; //azione bonus?
    private String effettoPer; //vedere se fare classe con tutti gli effetti

    public CartaPersonaggi(int money,String nome,String effettoImmed,String effettoPerman){
        costoMonete = money;
        this.nome = nome;
        effettoImm = effettoImmed;
        effettoPer = effettoPerman;
    }
}
