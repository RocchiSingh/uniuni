package tabellone.chiesa;

import carte.TesseraScomunica;

/**
 * Created by dimitri on 16/05/2017.
 */
public class Chiesa {
    private AreaChiesa[] slotPeriodo = new AreaChiesa[2];

    public void riempiChiesa(TesseraScomunica periodI, TesseraScomunica periodII, TesseraScomunica periodIII){
        slotPeriodo[0].setTessera(periodI);
        slotPeriodo[1].setTessera(periodII);
        slotPeriodo[2].setTessera(periodIII);
    }

    public void pulisciChiesa(){// dobbiamo valutare se serve o no poichè alla fine la chiesa si riempie una sola volta. e nn si cambia durante la partita. mentre serve per pulire a fine partita ma non do
        //se a fine partira si riparte da tabbellone nuovo e tutto nuovo quidi forse nn serve. valuteremo
        for(int i=0;i<3;i++){
            slotPeriodo[i].togliTessera();
        }
    }
}
