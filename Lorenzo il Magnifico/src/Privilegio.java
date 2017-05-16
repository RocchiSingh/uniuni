import Risorse.Risorsa;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Privilegio {

    private Risorsa[] legnoPietra=new Risorsa[2];
    private Risorsa servitore=new Risorsa();
    private int monete=2;
    private int puntiMil=2;
    private int puntiFede=1;

    public Privilegio(){
        legnoPietra[0]=new Risorsa("legna",1);
        legnoPietra[1]=new Risorsa("pietra",1);
        servitore=new Risorsa("servitore",2);

    }
    public int getLegnoPietra(){
        return (legnoPietra[0].getValoreRisorsa()+legnoPietra[1].getValoreRisorsa());
    }

    public int getServitore(){
        return (servitore.getValoreRisorsa());
    }

    public int getMonete(){
        return monete;
    }

    public int getPuntiMil(){
        return puntiMil;
    }

    public int getPuntiFede(){
        return puntiFede;
    }





}
