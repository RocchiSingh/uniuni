package network.server.socket;
import javax.print.DocFlavor;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketServer {
   private int port=3000;
   public SocketServer(){
   }
public void startServer(){
    ExecutorService executor= Executors.newCachedThreadPool();
    ServerSocket serverSocket;
    try {
        serverSocket=new ServerSocket(port);
        System.out.print("server partito");
    }catch (IOException e){
        System.out.print(e.getMessage());
        return;
    }System.out.println("server pronto");
    while (true){
        try {
            Socket socket = serverSocket.accept();
            executor.submit(new SocketPlayer(socket));
        }catch (IOException e){
            break; //entro qua a serversocket chiuso
        }
    }
    executor.shutdown();
    try {
        serverSocket.close();

    }catch (IOException e){
        System.err.println(e.getMessage());
        return;
    }
   }
}

