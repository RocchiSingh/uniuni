package tabellone.RaccoltaProduzione;
import giocatore.Giocatore;
import principale.*;
import giocatore.plancia.*;


/**
 * Created by ggnsingh on 15/05/2017.
 */
public class Produzione {//manca gestione giocatori meno di 4


    private final int quantifam =5;
    private final int malusFisso=3;
    private AreaProd[] celle= new AreaProd[quantifam];

    private void malus(Famigliare mem){
        mem.setMalusForza(malusFisso);

    }



    public boolean contrlPres(){
        for(int i=0;i<=quantifam;i++){
            if(celle[i].getOcccupato()){
                return true;
            }
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



    public boolean inserisciMembro(Famigliare membro, Giocatore giocatore){

        if(contrlPresFam(membro.getColore())){return false;} //fare controllo su id per distinguere i neutri
        if(!contrlPresFam(membro.getColore()) || (contrlPresFam(membro.getColore()) && membro.getId() == 0)){//se non ci sono famigliari o sto inserendo fam neutro
            if(!(celle[0].getOcccupato())){
                celle[0].setMembro(membro);
                giocatore.controllaBonusProduzione(membro.getForzaFami());
                return true;}
            for(int i=1;i<quantifam;i++) {
                if (!(celle[i].getOcccupato())) {
                    celle[i].setMembro(membro);
                    malus(membro);
                    giocatore.controllaBonusProduzione(membro.getForzaFami());
                    return true;
                }
            }

        }return false;


    }
}
