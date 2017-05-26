package tabellone.torre;
import carte.Carta;
import giocatore.Giocatore;
import principale.*;
/**
 * Created by dimitri on 13/05/2017.
 */
public class Torre {
    private Colore coloreTorre = null;
    private AreaTorre[] livelli = new AreaTorre[4];
    public Torre(Colore coloreTorre,AreaTorre a0,AreaTorre a1,AreaTorre a2,AreaTorre a3){
        this.coloreTorre = coloreTorre;
        livelli[0] = a0;
        a0.setPianoTorre(0);
        livelli[1] = a1;
        a1.setPianoTorre(1);
        livelli[2] = a2;
        a2.setPianoTorre(2);
        livelli[3] = a3;
        a3.setPianoTorre(3);
    }

    public void pulisciTorre(){
        for(int i=0;i<4;i++){
            livelli[i].rimuoviCarta();
            livelli[i].rimuoviMembro();
        }
    }

    public void riempiTorre(Carta[] mazzo/*passare vettore di 4 carte univoche e mescolate in base periodo*/){
        for(int i=0;i<4;i++){
            livelli[i].impostaCarta(mazzo[i]);/*vettore di carte*/
        }
    }

    public boolean contrlPres(){
        for(int i=0;i<4;i++){
            if(livelli[i].getOcccupato() == true){
                return true;
            }
        }return false;
    }

    public boolean contrlPresFam(Colore color){
       if(contrlPres()){
        for(int i=0;i<4;i++) {
           if (livelli[i].getColoreFam()==color)
               return true;
          }return false;
        }return false;
    }

    public void setRicompensa(Torre torre){
            livelli[2].setRicompensa(1);
            livelli[3].setRicompensa(2);
    }

    public Colore getColoreTorre(){return coloreTorre;}

    public void giveRicompensa(AreaTorre area,Torre torre,Giocatore giocatore){
        if(area.getPiano() == 2){
            if(torre.getColoreTorre() == Colore.GREEN){giocatore.prendiLegno(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.BLUE){giocatore.prendiPietra(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.YELLOW){giocatore.incremPuntiMil(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.PURPLE){giocatore.prendiMonete(area.getRicompensa());}
        }
        if(area.getPiano() == 3){
            if(torre.getColoreTorre() == Colore.GREEN){giocatore.prendiLegno(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.BLUE){giocatore.prendiPietra(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.YELLOW){giocatore.incremPuntiMil(area.getRicompensa());}
            if(torre.getColoreTorre() == Colore.PURPLE){giocatore.prendiMonete(area.getRicompensa());}
        }
    }


}
