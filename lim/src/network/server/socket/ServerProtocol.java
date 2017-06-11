package network.server.socket;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
//classe che gestisce le richieste con i protocolli poi manda la richiestea al socket player che manda al server che alla fine comunica con il gioco
/**
 * Created by ggnsingh on 31/05/2017.
 */
public class ServerProtocol {
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;
    private Object OUTPUT_MUTEX= new Object();
    private HashMap<Object,RequestHandler> mappaRichieste;

    private SocketPlayer callback;

    public ServerProtocol(ObjectOutputStream output, ObjectInputStream input, SocketPlayer callback){
        inputStream=input;
        outputStream=output;
        this.callback=callback;
        mappaRichieste=new HashMap<>();
        caricaRichieste();
    }

    private void caricaRichieste(){
        //caricare tutte le richieste qua con l'handlet opportuno

        mappaRichieste.put("richiestaLogin",this::loginPlayer);
       // mappaRichieste.put("joinRoom",this::joinRoom);

    }

    //inserire qua tutti gli handler inseriti sopra

    private void loginPlayer(){
        try {
            String username=(String)inputStream.readObject();
            loginPlayerAndRespond(username);
        }catch (ClassNotFoundException | ClassCastException| IOException e){
            System.out.println("errore di protoccolo");
        }
    }

    private void loginPlayerAndRespond(String username)throws IOException{
        int responseCode=-1;
        try {
            callback.loginPlayer(username);
            responseCode=200;

        }catch(Exception e){
            System.out.println("caduto nell eccezione login su server protocol gestirla con loignEx." +
            e.getMessage());
        }
        outputStream.writeObject(responseCode);
        outputStream.flush();

    }

    public void handleClientRequest(Object object){
        RequestHandler handler= mappaRichieste.get(object);
        if (handler!=null){
            synchronized (OUTPUT_MUTEX){
                handler.handle();
            }
        }
    }

    private interface RequestHandler {

        /**
         * Handle the client request.
         */
        void handle();
    }
}
