package tabellone.chiesa;

import carte.TesseraScomunica;
import giocatore.Giocatore;

import java.util.Scanner;

/**
 * Created by dimitri on 16/05/2017.
 */
public class Chiesa {
    private AreaChiesa[] slotPeriodo = new AreaChiesa[3];

    public void riempiChiesa(TesseraScomunica periodI, TesseraScomunica periodII, TesseraScomunica periodIII){
        slotPeriodo[0].setTessera(periodI);
        slotPeriodo[1].setTessera(periodII);
        slotPeriodo[2].setTessera(periodIII);
    }

    public void pulisciChiesa(){/*vedere se serve perche si riempe una sola volta*/
        for(int i=0;i<3;i++){
            slotPeriodo[i].togliTessera();
        }
    }

    public void scomunica(Giocatore giocatore,int turno){//gestione della scomunica da solol la scomunica
        if(turno == 2 ){
            giocatore.setMalus1(slotPeriodo[0].getRisorsa());
            slotPeriodo[0].setCuboscomunica(giocatore.getCubo(1));
        }
        if(turno == 4){
            switch(slotPeriodo[1].getTessera().getTipo()){
                case("territorio"):
                {
                    giocatore.setMalusTerritori(4);
                    slotPeriodo[1].setCuboscomunica(giocatore.getCubo(2));
                    break;
                }
                case("edifici"):
                    {
                    giocatore.setMalusEdifici(4);
                    slotPeriodo[1].setCuboscomunica(giocatore.getCubo(2));
                    break;
                }
                case("personaggio"):
                    {
                    giocatore.setMalusPersonaggi(4);
                    slotPeriodo[1].setCuboscomunica(giocatore.getCubo(2));
                    break;
                }
                case("impresa"):
                    {
                    giocatore.setMalusImprese(4);
                    slotPeriodo[1].setCuboscomunica(giocatore.getCubo(1));
                    break;
                }
            }

        }
        if(turno == 6){
            giocatore.setMalus3(true);
            slotPeriodo[2].setCuboscomunica(giocatore.getCubo(3));
            switch(slotPeriodo[2].getTessera().getTipoMalus()){
                case("imprese"):{giocatore.setTipoMalus3("imprese");break;}
                case("punti vittoria"):{giocatore.setTipoMalus3("punti vittoria");break;}
                case("territori"):{giocatore.setTipoMalus3("territori");break;}
                case("punti militari"):{giocatore.setTipoMalus3("punti militari");break;}
            }
        }
    }

    public void sostegnoChiesa(Giocatore giocatore,int turno){
        System.out.print("vuoi sostenere la chiesa azzerando i tuoi punti fede?" +
                "1-si" +
                "2-no");
        Scanner scan = new Scanner(System.in);
        int scelta = scan.nextInt();
        if(scelta == 1){giocatore.setPuntiFede(0);}
        if(scelta == 2){scomunica(giocatore, turno);}
    }

}
