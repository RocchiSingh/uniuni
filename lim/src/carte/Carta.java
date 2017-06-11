package carte;

public class Carta {
    private int periodo;
    private int costoEffetto;
    private boolean aggiunta ;
//in che senso aggiunta??
    public Carta (int period){
        periodo = period;
        aggiunta = false;
    }

    public Carta(){}

    public boolean getAggiunta(){return aggiunta;}

    public void setAggiunta(){aggiunta = true;}

    public void stampa(){
        System.out.println("sto stampando il periodo della carta");
        System.out.println(periodo);
    }


}