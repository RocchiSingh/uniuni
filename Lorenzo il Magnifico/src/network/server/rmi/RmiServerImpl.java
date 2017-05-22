package network.server.rmi;

import javax.management.remote.rmi.RMIServer;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public class RmiServerImpl extends UnicastRemoteObject implements RmiInterface {
    private static final long serialVersionUID=1L;//default

    public RmiServer()throws RemoteException {}

}
