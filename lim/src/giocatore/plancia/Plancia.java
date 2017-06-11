package giocatore.plancia;

/**
 * Created by dimitri on 17/05/2017.
 */
public class Plancia {
    private VettoreEdifici edif;
    private VettoreImprese imp;
    private VettorePersonaggi pers;
    private VettoreTerritori terr;

    public VettoreEdifici getEdif(){return edif;}
    public VettoreTerritori getTerr(){return terr;}
    public VettorePersonaggi getPers(){return pers;}
    public VettoreImprese getImp(){return imp;}
}
