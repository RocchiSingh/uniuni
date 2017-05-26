package network.server.rmi;

import network.client.InterfacciaClient;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public interface RmiServerInterface extends Remote {
/*scrivere tutte le funzioni che saranno eseguiti dal giocatore
questo file verra scaricato dal client per poi richiamare le funzioni necessarie
 */
String login(String username) throws IOException;

}
