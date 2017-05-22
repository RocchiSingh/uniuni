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

    public void pulisciChiesa(){/*vedere se serve perche si riempe una sola volta*/
        for(int i=0;i<3;i++){
            slotPeriodo[i].togliTessera();
        }
    }
}
