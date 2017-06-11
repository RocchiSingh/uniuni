package network.client;

import network.client.rmi.RmiClient;
import network.client.socket.SocketClient;
import network.server.socket.SocketServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public class StartClient {
    private ClientRmioSocket client=null;

    public static void main(String[] args) {
        System.out.println("scelgiere RMI o SOCKET r o s");
        BufferedReader inKeyboard = new BufferedReader(new InputStreamReader(System.in));
        try {
            String scelta=inKeyboard.readLine();
//testare da qua e risolvere lerrore 0
            if(scelta.equals("s")) {
                System.out.println("SOCKET SELEZIONATO");
                SocketClient socketClient = new SocketClient();
            }
            if(scelta.equals("r")){
                RmiClient rmiClient=new RmiClient();
                rmiClient.connetti();
                rmiClient.login("prova");
            }
        }catch(Exception e){
            System.out.println("ECCEZIONE INTERCETTATA CLIENT"+e.getMessage());

}}}