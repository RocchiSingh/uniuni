package network.server.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by ggnsingh on 21/05/2017.
 */
public class SocketPlayer implements Runnable {
    private Socket socket;
    public SocketPlayer(Socket socket){
        this.socket=socket;
    }
    public void run(){
        try {
            Scanner in =new Scanner(socket.getInputStream());
            PrintWriter out=new PrintWriter(socket.getOutputStream());
            //leggo e scrivo fince non ricevo fine
            while (true){//qua ricevo i comandi e in base ai comandi richiamo un spefico metodo del giocatore
                String line=in.nextLine();
                if(line.equals("quit")){
                    break;
                }
                else{
                }
            }
            in.close();
            out.close();
            socket.close();
        }catch (IOException e){
            System.err.print(e.getMessage());
        }

    }
}
