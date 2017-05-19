package carte;

public class Carta {
    private int periodo;
    private int costoEffetto;
    private boolean aggiunta ;

    public Carta (int period,int costo){
        periodo = period;
        costoEffetto = costo;
        aggiunta = false;
    }

    public Carta(){}

    public boolean getAggiunta(){return aggiunta;}

    public void setAggiunta(){aggiunta = true;}
}