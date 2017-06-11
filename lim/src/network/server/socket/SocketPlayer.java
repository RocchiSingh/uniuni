package network.server.socket;


import giocatore.Giocatore;
import network.server.Server;

import javax.jws.soap.SOAPBinding;
import java.io.*;
import java.net.Socket;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketPlayer extends Giocatore implements Runnable {
    private Socket socket;
    private ServerProtocol socketProtocol;
    private Server server;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public SocketPlayer(Socket socket,Server server)throws IOException{
        this.server=server;
        this.socket=socket;
        input=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
        output=new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        output.flush();
        socketProtocol=new ServerProtocol(output,input,this);
    }
    @Override
    public void run() {
        try {
            while (true){
                Object object =input.readObject();
                socketProtocol.handleClientRequest(object);
            }
        }catch(IOException | ClassNotFoundException e){
                System.out.println();
            }
            finally {
            chiudi(input,"errore chiusura input stream");
            chiudi(output,"errore chiusura output stream");
            chiudi(socket,"errore chiusura Socket");

        }
        }

        private void chiudi(Closeable closeable, String msg){
        try{
            closeable.close();
        }catch (IOException e){
            System.err.println("ERRORE CHIUSURA OGGETTO");
        }
        }

        //definire qua tutte le funzione che saranno chiamate dall handler poi passate al server con il propio giocatore in pratica
//alcuni metodi sono sul server altri direttamente sul protocol
    public void loginPlayer(String nickname) throws Exception  {
        server.loginPlayer(nickname, this);
    }

   /* public void joinRoom() {
        server.joinFirstAvailableRoom(this);
    }


    public void dispatchGameSession(BaseGame baseGame) {
        socketProtocol.notifyGameStarted(baseGame);
    }


    public void onGameTurnStarted(String nickname, int seconds)  {
        socketProtocol.notifyGameTurnStarted(nickname, seconds);
    }*/


}

