package network.server.socket;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import giocatore.Giocatore;
import network.client.socket.SocketClient;
import network.server.Server;

import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketServer {
   private static final int SOCKET_PORT=3000;
   private ServerSocket serverSocket;
   private Server server;
   private ArrayList<Giocatore> giocatoriDisp=new ArrayList<Giocatore>();

   public SocketServer(){

   }
   public void startServer(){

       try {
           serverSocket=new ServerSocket(SOCKET_PORT);
           new SocketPlayerHandler().start();
           System.out.println("server partito");

       }catch (IOException e){
           System.out.print(e.getMessage());

       }
   }

   private class SocketPlayerHandler extends Thread{
     public void run(){
         while (true){
             try {
                 Socket clientSocket=serverSocket.accept();
                 System.out.println("nuova richiessta socket");
                 SocketPlayer socketPlayer=new SocketPlayer(clientSocket,server);
                 new Thread(socketPlayer).start();
             }catch (IOException e){
                 System.out.println("eccezzione accettazione socket client"+e.getMessage());
                 break;
             }
         }
     }

      /* public void run(){
           {
               while (true) {
                   try {

                       Socket clientSocket = serverSocket.accept();
                       System.out.println("connessione accettata da:" + clientSocket.getInetAddress());
                       //creo un giocatore e metto dentro il suo socket e poi lo metto nella lista
                       Giocatore giocatore =new Giocatore(clientSocket);

                       aggiungiGiocatore( giocatore);
                       String line;
                       System.out.println("sono nel SocketPlayerHandler");
                       Scanner in = new Scanner(clientSocket.getInputStream());
                       PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
                       //leggo e scrivo finche non ricevo fine
                       while (true) {//qua ricevo i comandi e in base ai comandi richiamo un spefico metodo del giocatore
                           System.out.println("pronto a ricevere comandi client metti quit");

                           line = in.nextLine();
                           System.out.println(line);


                           if(line.equals("gioca")){
                               System.out.println("il gioco è partito");
                               iniziaGioco();
                           }
                           if (line.equals("close")) {
                               in.close();
                               out.close();
                               clientSocket.close();
                               System.out.println("chiusura connessione");
                               break;
                           }
                           if (line.equals("login")) {
                               System.out.println("GESTIRE IL LOGIN");
                               line = in.nextLine();
                               if (line.equals("ok")) {
                                   line = in.nextLine();
                                   if (line.equals("ok")) {
                                       System.out.println("dati ricevuto correttamente");
                                       out.println(true);
                                       out.flush();
                                   }
                               }

                               out.println(false);
                               out.flush();


                           } else {
                           }
                       }


                   } catch (IOException e) {
                       System.err.print(e.getMessage());
                   }
               }




           }
       }
       //gestisco qua quanti giocatori ho selezionato in partenza e
       public void aggiungiGiocatore(Giocatore giocatore){
           giocatoriDisp.add(giocatore);
       }

       public void iniziaGioco(){giocatoriDisp.clear();
       //far partire il gioco
       }*/


   }
}