package principale;

/**
 * Created by dimitri on 15/05/2017.
 */
public class Test{
    public static void main(String[] args){
        Famigliare fam= new Famigliare(Colore.GREEN);
        if(fam.getColore()==Colore.RED){
            System.out.print("ok");
        }
        else
            System.out.print("non uguale");
    }
}
