package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class db_connection { // Singleton implementation�? in creating DB connections. 


    private static db_connection instance; // static instance
    
    private Connection connection;
    private String url = "jdbc:mysql://localhost/sos?useSSL=false&useUnicode=true&amp;";
    private String username = "root";
    private String password = "123123";

    private db_connection() throws SQLException { // db_connection constructor
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
        if (instance == null) {
            instance = new db_connection();
        } else if (instance.getConnection().isClosed()) {
            instance = new db_connection();
        }

        return instance;
    }
}