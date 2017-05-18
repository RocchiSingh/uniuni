package tabellone.RaccoltaProduzione;
import principale.*;


/**
 * Created by ggnsingh on 15/05/2017.
 */
public class Produzione {//manca gestione giocatori meno di 4


    private final int quantifam =5;
    private final int malusFisso=3;
    private AreaProd[] celle= new AreaProd[quantifam];
    private void malus(Famigliare mem){
        mem.decrementaForza(malusFisso);

    }



    public boolean contrlPres(){
        for(int i=0;i<=quantifam;i++){
            return celle[i].getOcccupato();
        }return false;
    }

    public boolean contrlPresFam(Colore color){
        if(contrlPres()){
            for(int i=0;i<=quantifam;i++) {
                if (celle[i].getColoreFam()==color)
                    return true;
            }return false;
        }return false;
    }



    public boolean inserisciMembro(Famigliare membro){

        if(contrlPresFam(membro.getColore())){return false;} //fare controllo su id per distinguere i neutri
        else{
            if(!(celle[0].getOcccupato())){celle[0].setMembro(membro); return true;}
            for(int i=1;i<quantifam;i++) {
                if (!(celle[i].getOcccupato())) {
                    celle[i].setMembro(membro);
                    malus(membro);
                    return true;
                }
            }
            return false;

        }


    }
}
