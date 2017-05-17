package tabellone;
import principale.*;
import risorse.*;

/**
 * Created by ggnsingh on 16/05/2017.
 */
public class Mercato {
    int quantiGiocatori=4;
    private final int vincolo = 1;
    private boolean[] occupato = {false,false,false,false};
    private Famigliare[] famigliare = new Famigliare[4];
    private Moneta bonusAreaUno=null;
    private Servitore bonusAreaDue=null;
    private Risorsa[] bonusAreaTre=new Risorsa[2];
    private Risorsa[][] privilegio= new Risorsa[5][2];
    private boolean[] privilegioPreso ={false,false,false,false,false};
    private String[] elencoPrivilegi={"LegnaPietra","Servitore","Monete","PuntiMilitari","PuntiFede"};

    public Mercato(){}
    public Mercato(Moneta bonusA1,Servitore bonusA2){
        bonusAreaUno=bonusA1;
        bonusAreaDue=bonusA2;
    }

    public Mercato(Moneta bonusA1,Servitore bonusA2, Moneta denaro, PuntiMilitari puntiMilitari){
        bonusAreaUno=bonusA1;
        bonusAreaDue=bonusA2;
        bonusAreaTre[0]=denaro;
        bonusAreaTre[1]=puntiMilitari;

        privilegio[0][0]=new Legna(1);
        privilegio[0][1]=new Pietra(1);
        privilegio[1][0]=new Servitore(2);
        privilegio[1][1]=null;
        privilegio[2][0]=new Moneta(2);
        privilegio[2][1]=null;
        privilegio[3][0]=new PuntiMilitari(2);
        privilegio[3][1]=null;
        privilegio[4][0]=new PuntiFede(1);
        privilegio[4][1]=null;



    }
    public Moneta getBonusAreaUno(){
        return bonusAreaUno;
    }

    public Servitore getBonusAreaDue(){
        return bonusAreaDue;
    }
    public Risorsa[] getBonusAreaTre(){
        return bonusAreaTre;
    }

    private Risorsa[] getBonusPrivi(int numPrivilegio){
        Risorsa[] ris= new Risorsa[2];
        if(privilegioPreso[numPrivilegio]==false)
        {
        ris[0]=privilegio[numPrivilegio][0];
        ris[1]=privilegio[numPrivilegio][1];
        privilegioPreso[numPrivilegio]=true;
        elencoPrivilegi[numPrivilegio]="GiaPreso";
        }
        else{
            ris[0]=null;
            ris[1]=null;//STAMPARE UN MESSAGGIO PRIVILEGIO GIA PRESO
        }

        return ris;
    }

    public String[] mostraTuttiPrivilegio(){
        return elencoPrivilegi;
    }


}
