package network.client;

import org.omg.CORBA.portable.ResponseHandler;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * Created by ggnsingh on 01/06/2017.
 */
public class ClientProtocol {
private final ObjectInputStream inputStream;
private final ObjectOutputStream outputStream;
private static final Object OUTPUT_MUTEX=new Object();
private final HashMap<Object, ResponseHandler> mappaRisposta;

public ClientProtocol(ObjectOutputStream outputStream, ObjectInputStream inputStream){
    this.inputStream=inputStream;
    this.outputStream=outputStream;
    mappaRisposta=new HashMap<>();
    loadResponse();
}
//scrivere qua tutte le rispote del server e aggiungere alle mappse eseguire la funzione specifica
private void loadResponse() {
    mappaRisposta.put("AZIONE NON VALIDA", this::azioneNonValida);

//qua nserisco tutti i metodi senza parametri mentre quelli con i parametri li gestisco con public da sotto direttamente

}

private void azioneNonValida(){
    try {
        int errorCode=(int)inputStream.readObject();
    }catch (ClassNotFoundException|ClassCastException|IOException e){
        System.out.println("errore in lettra"+e.getMessage());
    }
}

    public void loginPlayer(String nickname) throws Exception {
        int responseCode;
        try {
            outputStream.writeObject("login");
            outputStream.writeObject(nickname);
            outputStream.flush();
            responseCode = (int) inputStream.readObject();
        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            throw new Exception("NETWORK EXCEPTION");
        }
        if (responseCode ==-1) {
            //throw new// LoginException();
        }
    }




public void handleResponse(Object object){
    ResponseHandler handler=mappaRisposta.get(object);
    if (handler!=null){

        handler.handle();
    }
}

private interface ResponseHandler{
    void handle();
}
}
