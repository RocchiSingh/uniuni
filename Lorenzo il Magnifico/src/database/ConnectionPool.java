package database;
import java.sql.*;

/**
 * Created by dimitri on 22/05/2017.
 */
public class ConnectionPool {
    Connection con[];
    boolean occupato[];
    String who[];
    private int numConnessioni = 10;

    String databaseUrl = "jdbc:mysql://localhost/lorenzo?user=";
    String dataUsername = "root";
    String dataPassword = "";
    String driverString = "com.mysql.jdbc.Driver";
    String connectionString = databaseUrl + dataUsername +"&password=" + dataPassword;

    public ConnectionPool(String dataUsername,String dataPassword,int numConnessioni)
    throws Exception{
        connectionString = this.databaseUrl + dataUsername +"&password=" + dataPassword;
        this.numConnessioni = numConnessioni;
        newConnections();
    }

    public ConnectionPool()throws Exception{
        newConnections();
    }

    private synchronized void newConnections()throws Exception{
        con = new Connection[numConnessioni];
        occupato = new boolean[numConnessioni];
        who = new String[numConnessioni];
        Class.forName(driverString);

    for (int i=0;i< numConnessioni;i++){
        con[i] = DriverManager.getConnection(connectionString);
        occupato[i] = false;
        who[i] = "";
    }
    }

    public synchronized Connection getConnection(String who) throws Exception{
        int indFree = findFreeConnection();
        occupato[indFree] = true;
        this.who[indFree] = "who";
        return con[indFree];
    }

    public synchronized Connection getConnection()throws Exception{
        return getConnection("noName");
    }

    public synchronized void releaseConnection(Connection c){
        for(int i=0;i<numConnessioni;i++){
            if(con[i] == c){
                who[i] = "";
                occupato[i] = false;
            }
        }
    }

    private int findFreeConnection(){
        for(int i=0;i<numConnessioni;i++){
            if(!occupato[i]){return i;}
        }return -1;
    }

    public String printStatusConnection(){
        String result = "";
        for(int i=0;i<numConnessioni;i++){
            result += "Conn." + i + ":" + occupato[i] + "used by" + who[i];
        }return result;
    }

}
