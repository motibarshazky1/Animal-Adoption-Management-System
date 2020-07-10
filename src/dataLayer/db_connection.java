package dataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class db_connection { // Singleton implementation in creating DB connections. 


    private static db_connection instance; // static instance
    public static int id;
    
    private Connection connection;
    private String url = "jdbc:mysql://localhost/sos?useSSL=false&useUnicode=true&amp;";
    private String username = "root";
    private String password = "123123";
   

    private db_connection() throws SQLException { // db_connection constructor
    	id++;
        try {
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
       
    }

    public void closeConnection() { // close Connection.
         this.closeConnection();
    }
    
    public Connection getConnection() { // return Connection.
        return connection;
    }

    public static db_connection getInstance() throws SQLException { // create new db_connection instance.
        if (instance == null) { // NO Instance
            instance = new db_connection();
        } else if (instance.getConnection().isClosed()) { //Instance is closed
            instance = new db_connection();
        }

        return instance; // return the exist instance
    }
}