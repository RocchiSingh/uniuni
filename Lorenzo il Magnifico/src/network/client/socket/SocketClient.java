package network.client.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketClient {
    private final static int PORT = 3000;
    private final static int NUMSPAZI = 100;
    private final static String address = "localhost";

    private Socket socket;
    private BufferedReader inSocket;
    private PrintWriter outSocket;
    private BufferedReader inKeyboard;


    public SocketClient() {
        //messaggio di client avviato
        System.out.println("client avviato");
        try {
            connetti();
            login();
        } catch (Exception e) {

            //eccezione da gestire
        } finally {
            try {
                socket.close();

            } catch (IOException e) {
                System.err.println("socket non chiusa");
            }
        }
    }

    private void connetti() {
        try {
            socket = new Socket(address, PORT);
            inSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outSocket = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
//aggiungere messagio di client connesso e implementare qua i canali di comunicazione
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

    /*private void esegui() {
        try {
            connetti();
            login();
            interagisci();
            chiudi();
        } catch (Exception e) {
            System.out.println("Exception: " + e);
            e.printStackTrace();
        } finally {
            // Always close it:
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Socket not closed");
            }
        }
    }*/

    //inserire i comandi da inviare al server qua
    //scrivere tutte le funzioni che il cliente esegue sullo server e richiamarle
    private void interagisci() {
        try {
            login();
        } catch (Exception e) {
            System.out.print("comando non inviato");
        }

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

    private void login() {
        try {
            boolean loggato = false;

            while (!loggato) {
                System.out.println("Inserire login:");
                String username = inKeyboard.readLine();

                System.out.println("Inserire password:");
                String password = inKeyboard.readLine();

                outSocket.println("login");
                outSocket.flush();
                outSocket.println(username);
                outSocket.flush();
                outSocket.println(password);
                outSocket.flush();

                System.out.println("invitao i dati");

                loggato = Boolean.valueOf(inSocket.readLine()).booleanValue();

                if (loggato)
                    System.out.println("Login effettuato correttamente");
                else
                    System.out.println("Nome utente in uso con altra password");
            }
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
}

