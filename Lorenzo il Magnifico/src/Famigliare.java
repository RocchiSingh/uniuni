import tabellone.AreaTorre;

/**
 * Created by dimitri on 13/05/2017.
 */
public class Famigliare {
    private Colore colore =null;//aggiungere id per distinguere i neutri
    private int forzaFami=0;
    private Colore coloreDado;

    public Famigliare ( Colore colore)
    {
        this.colore=colore;

    }
    public Famigliare ( Colore colore, Colore coloreDado, int forzaFami )
    {
        this.colore=colore;
        this.coloreDado=coloreDado;
        this.forzaFami=forzaFami;

    }
    public void incrementaForza(int numServitori){

        forzaFami+=numServitori;
    }

    public void decrementaForza(int forzaDaTogliere){

        forzaFami-=forzaDaTogliere;
    }
    public void posiziona(AreaTorre area){
        if (forzaFami>=area.getVincolodado())
        area.setMembro(this);// dovrei passare il famigliare stesso in quella area facendo controllo opportuni


    }
    public Colore getColore(){
        return colore;
    }

}
