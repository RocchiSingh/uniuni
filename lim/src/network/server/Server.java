package network.server;

import giocatore.Giocatore;
import network.server.rmi.RmiServer;
import network.server.socket.SocketServer;

import java.util.HashMap;

/**
 * Created by ggnsingh on 31/05/2017.
 */
public class Server {
//qua definisco i server
    //e li faccio partire con start
    private static final Object PLAYERS_MUTEX=new Object();
    private static final Object ROOMS_MUTEX=new Object();
    private HashMap<String, Giocatore> players;
    private RmiServer rmiServer=new RmiServer();
    private SocketServer socketServer=new SocketServer();

    public static void main(String[] args) {

        try {
            Server server = new Server();
            server.startServer();
        } catch (Exception e) {
            System.out.println("errore partenza server");
        }
    }

    private void startServer() throws Exception{
        socketServer.startServer();
        rmiServer.startServer();
    }



    public void loginPlayer(String nickname , Giocatore player)throws Exception{
     System.out.println(nickname);
       synchronized (PLAYERS_MUTEX) {
            if (!players.containsKey(nickname)) {
                players.put(nickname, player);
                player.setNickname(nickname);
            } else {
                throw new Exception("errore login");
            }
        }
    }
}
