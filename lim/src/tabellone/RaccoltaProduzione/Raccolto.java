package tabellone.RaccoltaProduzione;
import giocatore.Giocatore;
import principale.*;
import giocatore.plancia.*;
/**
 * Created by dimitri on 15/05/2017.
 */
public class Raccolto {//MANCA GESTIONE GIOCATORI DIVERSI DA 4
    private final int quantifam = 5;
    private final int malusFisso = 3;
    private AreaRacc[] celle = new AreaRacc[quantifam];

    private void malus(Famigliare mem) {
        mem.decrementaForza(malusFisso);
    }


    public boolean contrlPres() {
        for (int i = 0; i <= quantifam; i++) {
            return celle[i].getOcccupato();
        }
        return false;
    }

    public boolean contrlPresFam(Colore color) {
        if (contrlPres()) {
            for (int i = 0; i <= quantifam; i++) {
                if (celle[i].getColoreFam() == color)
                    return true;
            }
            return false;
        }
        return false;
    }


    public boolean inserisciMembro(Famigliare membro, Giocatore giocatore) {

        if (contrlPresFam(membro.getColore())) {
            return false;
        }
        if (!contrlPresFam(membro.getColore()) || contrlPresFam(membro.getColore()) && membro.getId() == 0) {
            if (!(celle[0].getOcccupato())) {
                celle[0].setMembro(membro);
                giocatore.controllaBonusRaccolta(membro.getForzaFami());
                return true;
            }
            for (int i = 1; i < quantifam; i++) {
                if (!(celle[i].getOcccupato())) {
                    celle[i].setMembro(membro);
                    malus(membro);
                    giocatore.controllaBonusRaccolta(membro.getForzaFami());
                    return true;
                }
            }

        }
        return false;
    }
}



