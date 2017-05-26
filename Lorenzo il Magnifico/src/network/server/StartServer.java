package network.server;

import network.server.rmi.RmiServerImpl;
import network.server.rmi.RmiServerInterface;
import network.server.socket.SocketServer;

import javax.management.remote.rmi.RMIConnection;
import javax.management.remote.rmi.RMIServerImpl;
import javax.naming.NamingException;
import javax.security.auth.Subject;
import java.io.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.concurrent.Executors;

/**
 * Created by ggnsingh on 22/05/2017.
 */
public class StartServer {

    public static void main(String [] args)throws RemoteException,NamingException{
        int port=3005;
       System.out.println("avvia Start SERVER");
        SocketServer socketServer = new SocketServer();
         BufferedReader inKeyboard;

        inKeyboard = new BufferedReader(new InputStreamReader(System.in));
        //valuto qua cosa far partire se il socket o RMI

        while (true){
            System.out.println("Scegliere connessione Socket (s) o Rmi (r) Exit (e");
            try{
                String scelta=inKeyboard.readLine();
                if(scelta.equals("s")) {
                    socketServer.startServer();
                    System.out.println("socket avviato");
                }

                if (scelta.equals("r")){
                   try {
                       RmiServerInterface rmiServer = new RmiServerImpl();
                    System.out.println("binding server impl to reg");
                    Registry registry= LocateRegistry.createRegistry(port);
                    registry.bind("RmiServerInterface",rmiServer);}
                    catch (Exception e){
                       System.out.println("eccezioneee"+e.getMessage());
                    }
                    System.out.println("waiting clients");
                }
                if (scelta.equals("e")){
                    System.out.print("fine");
                    break;
                }
            }catch (Exception e){
                System.out.println("caduto nell eccezione try non va");
            }


        }

    }
}
