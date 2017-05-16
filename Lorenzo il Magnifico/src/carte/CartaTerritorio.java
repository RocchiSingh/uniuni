package carte;

/**
 * Created by dimitri on 15/05/2017.
 */
public class CartaTerritorio extends Carta {
    private String nome;
    private String effettoImm;
    private String effettoPer; //vedere se fare classe con tutti gli effetti

    public CartaTerritorio(String nome,String effettoImmed,String effettoPerman){
        this.nome = nome;
        effettoImm = effettoImmed;
        effettoPer = effettoPerman;
    }
}//vedere punti vittoria se servono
