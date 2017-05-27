package network.server.socket;
import javax.print.DocFlavor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

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
   public SocketServer(){
   }

   public void startServer(){

       try {
        serverSocket=new ServerSocket(SOCKET_PORT);
        new SocketPlayerHandler().start();
        System.out.println("server partito");

       }catch (IOException e){
        System.out.print(e.getMessage());
        return;

       }
   }

   private class SocketPlayerHandler extends Thread{
       public void run(){
           {
              try {

                  Socket socket = serverSocket.accept();
                  System.out.println("sono nel SocketPlayerHandler");
                  Scanner in = new Scanner(socket.getInputStream());
                  PrintWriter out = new PrintWriter(socket.getOutputStream());
                  //leggo e scrivo finche non ricevo fine
                  while (true) {//qua ricevo i comandi e in base ai comandi richiamo un spefico metodo del giocatore
                      System.out.println("pronto a ricevere comandi client metti quit");

                      String line = in.nextLine();
                      System.out.println(line);
                      if (line.equals("login")) {
                          System.out.println("GESTIRE IL LOGIN");
                          out.print(true);
                          break;
                      } else {
                      }
                  }
                  in.close();
                  out.close();
                  socket.close();

              } catch (IOException e) {
                  System.err.print(e.getMessage());
              }




           }
       }
   }
}