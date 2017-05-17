package risorse;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Privilegio {

    private String preso=""; // per prendere due cose confronto questa stringa nei due vettori dei privilegi e faccio in modo che siano entrambe diverse
    private Risorsa[] legnaPietra=new Risorsa[2];
    private Risorsa[] servitore=new Risorsa[2];
    private Risorsa[] monete=new Risorsa[2];
    private Risorsa[] puntiMil=new Risorsa[2];
    private Risorsa[] puntiFede=new Risorsa[2];

    public Privilegio(){
        legnaPietra[0]=new Legna(1);
        legnaPietra[1]=new Pietra(1);
        servitore[0]=new Servitore(2);
        servitore[1]=new Servitore(0);
        monete[0]=new Moneta(2);
        monete[1]=new Moneta(0);
        puntiFede[0]=new PuntiFede(1);
        puntiFede[1]=new PuntiFede(0);
        puntiMil[0]=new PuntiMilitari(2);
        puntiMil[1]=new PuntiMilitari(0);

    }

    public void resettaPreso(){
        preso="";
    }
    public String getPreso(){
        return preso;
    }


    public Risorsa[]  getLegnaPietra(){
        preso="lengaPietra";
        return legnaPietra;
    }

    public Risorsa[] getServitore(){
        preso="servitore";
        return servitore;
    }

    public Risorsa[] getMonete(){
        preso="monete";
        return monete;
    }

    public Risorsa[] getPuntiMil(){
        preso="puntiMilitari";
        return puntiMil;
    }

    public Risorsa[] getPuntiFede(){
        preso="puntiFede";
        return puntiFede;
    }





}
