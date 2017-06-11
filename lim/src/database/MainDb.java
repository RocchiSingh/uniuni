package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by dimitri on 22/05/2017.
 */
public class MainDb {
    public static void main(String[] args) {
        ConnectionPool test;

        try {
            test = new ConnectionPool();
            Connection con = test.getConnection();
            String query = "SELECT * FROM giocatore";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                System.out.println(rs.getString("username"));
            }
            rs.close();
            stmt.close();
            test.releaseConnection(con);
        } catch (Exception e) {
            System.out.print("errore di connessione" + e.getMessage());
        }


    }
}
