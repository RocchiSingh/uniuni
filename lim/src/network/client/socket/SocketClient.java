package network.client.socket;

import network.client.ClientProtocol;

import java.io.*;
import java.net.Socket;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketClient {
    private final static int PORT = 3000;
    private final static String address = "localhost";

    private Socket socket;
    private ObjectInputStream inSocket;
    private ObjectOutputStream outSocket;
    private BufferedReader inKeyboard;

    private ClientProtocol socketProtocol;

    public SocketClient() { }

    private void connetti() {
        try {
            System.out.println("il client tenta di connettersi");
            socket = new Socket(address, PORT);
            inSocket = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            outSocket = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
//aggiungere messagio di client connesso e implementare qua i canali di comunicazione
            outSocket.flush();
            System.out.println("connessione avvenuta");
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();

            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }

    public void inizializzaConnessione(){
        socketProtocol=new ClientProtocol(outSocket,inSocket);
    }



//lanciare eccezzione NETWORK DI RETe
    public void loginPlayer(String nome)throws Exception{
        socketProtocol.loginPlayer(nome);
    }

    private void chiudi() {
        try {
            socket.close();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        } finally {
            // Always close it:
            try {
                socket.close();
            } catch (IOException ex) {
                System.err.println("Socket not closed");
            }
        }
    }
}

