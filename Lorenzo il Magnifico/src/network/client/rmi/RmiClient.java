package network.client.rmi;

import network.client.ClientRmioSocket;
import network.client.InterfacciaClient;
import network.server.rmi.RmiServer;
import network.server.rmi.RmiServerInterface;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public class RmiClient extends ClientRmioSocket implements InterfacciaClientRmi{
    private String address="localhost";
    private int port=3005;
    private RmiServerInterface rmiServer;
    String tokesSessione;//ritorno dalla funzione di login per.
    public RmiClient(){}
    public RmiClient(String address, int port){
        this.address=address; this.port=port;
    }


    public void connetti()//mettere un eccezione da lanciare
    {
        try {
            //testare da qua PER AVVIARE RMI
            Registry registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RmiServerInterface) registry.lookup("RmiServerInterface");
            UnicastRemoteObject.exportObject(this,0);
        }catch (RemoteException | NotBoundException e){
            //lancio un eccezione nuova creata da me
            System.out.println("errore con rmi"+e.getMessage());
        }
    }

    public void login(String username)//lanciare eccezzione networkException
    {
        //farlo con try catc usando eccezione Login e IO
         try {
             tokesSessione = rmiServer.login(username);
             System.out.println("il ritorno del return");
             System.out.println(tokesSessione);
         }catch (IOException e){
             System.out.println("ERRORE DI IO IN RICECA FUNZIONE RMI");
         }

    }

    /* AGGIUNGERE QUA TUTTE LE FUNZIONE CHE IL GIOCATORE POTRA FARE SUL TABELLONE E ANCHE LE NOTICHE CHE RICEVE IL GIOCATORE DAL TABBELLONE.
    AD ESEMPIO TURNO; COMPRA; VENDI; PRENDI CARTE ETC.
    i metodi vanno implementati qui
     */

}
