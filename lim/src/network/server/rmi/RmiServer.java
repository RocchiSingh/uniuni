package network.server.rmi;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ggnsingh on 01/06/2017.
 */
public class RmiServer {
   private static final int RMI_PORT=3002;
   public RmiServer(){}
   public void startServer(){
     try {
        RmiServerInterface rmiServer = new RmiServerImpl();
        System.out.println("binding server impl to reg");
        Registry registry= LocateRegistry.createRegistry(RMI_PORT);
        registry.bind("RmiServerInterface",rmiServer);}
                    catch (Exception e){
        System.out.println("eccezioneee"+e.getMessage());
    }
                    System.out.println("waiting clients");


   }
}
