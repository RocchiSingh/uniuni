package carte;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import database.*;
import risorse.*;

/**
 * Created by dimitri on 07/06/2017.
 */
public class Mazzo{
    private ConnectionPool connessione;
    private ArrayList<Carta> mazzo = new ArrayList<Carta>();//lista delle carte nel mazzo
    private String tipo = null;
    private int periodo;
    private Risorsa ris1 = null;
    private Risorsa ris2 = null;
    private Risorsa ris3 = null;
    private Risorsa ris4 = null;

    public Mazzo(String tipomazzo,int periodo) {
        this.tipo = tipomazzo;
        this.periodo = periodo;
    }

    public void creaMazzo(){
        try {
            connessione = new ConnectionPool();
            Connection con = connessione.getConnection();
            String query = "SELECT * FROM "+tipo+" WHERE periodo="+periodo;
            System.out.println(query);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                if (tipo == "cartaterritorio") {
                    setTipoRisorsa(rs.getString("tipoBonusImm1"),rs.getInt("bonusImm1"),ris1);
                    setTipoRisorsa(rs.getString("tipoBonusImm2"),rs.getInt("bonusImm2"),ris2);
                    setTipoRisorsa(rs.getString("tipoBonusPer1"),rs.getInt("bonusPer1"),ris3);
                    setTipoRisorsa(rs.getString("tipoBonusPer2"),rs.getInt("bonusPer2"),ris4);
                    caricaCarta(new CartaTerritorio(rs.getString("nome"),ris1,ris2,ris3,ris4,
                            rs.getInt("periodo"),rs.getInt("valoreAzione")));
                    return;
                }
                if (tipo == "cartaedificio"){
                    setTipoRisorsa(rs.getString("tipoBonusImm1"),rs.getInt("bonusImm1"),ris1);
                    setTipoRisorsa(rs.getString("tipoBonusImm2"),rs.getInt("bonusImm2"),ris2);
                    setTipoRisorsa(rs.getString("tipoBonusPer1"),rs.getInt("bonusPer1"),ris3);
                    setTipoRisorsa(rs.getString("tipoBonusPer2"),rs.getInt("bonusPer2"),ris4);
                    caricaCarta(new CartaEdifici(rs.getInt("costo legno"),rs.getInt("costo pietra"),
                            rs.getInt("costo moneta"),rs.getInt("costo servitori"),rs.getString("nome"),
                            ris1,ris2,ris3,ris4,rs.getInt("periodo"),rs.getInt("valoreAzione")));
                    return;
                }
                if (tipo == "cartaimpresa"){
                    setTipoRisorsa(rs.getString("tipoBonusImm1"),rs.getInt("bonusImm1"),ris1);
                    setTipoRisorsa(rs.getString("tipoBonusImm2"),rs.getInt("bonusImm2"),ris2);
                    setTipoRisorsa(rs.getString("tipoBonusImm3"),rs.getInt("bonusImm3"),ris3);
                    caricaCarta(new CartaImprese(rs.getInt("costo puntiMilitari"),rs.getInt("costo legno"),
                            rs.getInt("costo pietra"),rs.getInt("costo moneta"),rs.getInt("costo servitori"),rs.getString("nome")
                    ,ris1,ris2,ris3,rs.getString("tipoAzione"),rs.getInt("valoreAzione"),rs.getInt("puntiVittoria finali"),rs.getInt("periodo"),rs.getInt("vincoloMilitare")));
                    return;
                }
                if (tipo == "cartapersonaggio"){
                    setTipoRisorsa(rs.getString("tipoRisorsa0"),rs.getInt("risorsa0"),ris1);
                    setTipoRisorsa(rs.getString("tipoRisorsa1"),rs.getInt("risorsa1"),ris2);
                    caricaCarta(new CartaPersonaggi(rs.getInt("costo moneta"),rs.getString("nome"),ris1,ris2,
                            rs.getString("tipoRisorsa0"),rs.getString("tipoRisorsa1"),
                            rs.getInt("valoreAzione"),rs.getString("tipoAzione"),rs.getInt("periodo")));
                    return;
                }
            }
            rs.close();
            stmt.close();
            connessione.releaseConnection(con);
        } catch (Exception e) {
            System.out.print("errore di connessione" + e.getMessage());
        }


    }

    private void caricaCarta(Carta carta){mazzo.add(carta);}

    private void setTipoRisorsa(String tipo,int valoreBonus,Risorsa ris){
        if(tipo.equals("punti militari")){ris = new PuntiMilitari(valoreBonus);return;}
        if(tipo.equals("servitore")){ris = new Servitore(valoreBonus);return;}
        if(tipo.equals("punti vittoria")){ris = new PuntiVittoria(valoreBonus);return;}
        if(tipo.equals("moneta")){ris = new Moneta(valoreBonus);return;}
        if(tipo.equals("punti fede")){ris = new PuntiFede(valoreBonus);return;}
        if(tipo.equals("pietra")){ris = new Pietra(valoreBonus);return;}
        if(tipo.equals("privilegio")){ris = new Privilegio();return;}
        if(tipo.equals("legno")){ris = new Legna(valoreBonus);return;}
    }

    public void shuffle(){Collections.shuffle(mazzo);}

    public Carta giveCarta(int i){return mazzo.get(i);}

   /* public void stampaCarta(){
        for(Carta carta : mazzo){
            carta.stampa();
        }
    }

    public static void main(String[] args){
        Mazzo mazzo = new Mazzo("cartaterritorio",1);
        mazzo.stampaCarta();
    }*/

}