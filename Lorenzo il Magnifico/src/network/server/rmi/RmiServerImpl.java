package network.server.rmi;

import javax.management.remote.rmi.RMIServer;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public class RmiServerImpl extends UnicastRemoteObject implements RmiServerInterface {
    private static final long serialVersionUID=1L;//default

    public RmiServerImpl()throws RemoteException {}
    public String login(String username) throws IOException
    {
        System.out.println(username);
        System.out.println("STO ESEGUENDO LA FUNZIONE LOGIN");
        System.out.println("il parametro ricevuto è"+username);
        return "LOGIN ESEGUITO";
    }

}
