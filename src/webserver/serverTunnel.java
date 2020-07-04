package webserver;

import java.io.FileInputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import database.db_connection;
import userInterface.Work;
import gui.MainWindow;


public class serverTunnel
{
	public Statement st;
	public PreparedStatement pst;

public serverTunnel() {
}


public ResultSet SelectCommand(String query)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
	//Statement st=null;
    ResultSet rs=null;
        	      
    try {
        
        st = con.getConnection().createStatement();
        rs = st.executeQuery(query);

    }   catch (Exception e)
    {
    	
    }
    return rs;
}

public void UpdateDB(String query)
{
	  try {
			 db_connection conn=db_connection.getInstance();
			 PreparedStatement ps=conn.getConnection().prepareStatement(query);
			 ps.executeUpdate();	
	  }
	  catch (Exception e)
	    {
	    	
	    }

}
public void UpdateDB(String query,FileInputStream pic)
{
	  try {
			 db_connection conn=db_connection.getInstance();
			 PreparedStatement pst=conn.getConnection().prepareStatement(query);
			 pst.setBlob(1, pic);
			 pst.executeUpdate();	
	  }
	  catch (Exception e)
	    {
	    	
	    }

}

public void InsertCommand(String query)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
	 	JOptionPane.showMessageDialog(null, "הזנה1.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

        st = con.getConnection().createStatement();
	 	JOptionPane.showMessageDialog(null, query, "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

        st.executeUpdate(query);
        
	 	JOptionPane.showMessageDialog(null, "הזנה3.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

    }   catch (Exception e)
    {
    }
}
public void InsertCommand(String query,FileInputStream pic)
{
	db_connection  con=null;
	  try {
    		 con=db_connection.getInstance();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
	 	JOptionPane.showMessageDialog(null, "הזנה1.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

        pst = con.getConnection().prepareStatement(query);
        
	 	JOptionPane.showMessageDialog(null, query, "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

	 	pst.setBlob(1, pic);
		pst.executeUpdate();
   		        
	 	JOptionPane.showMessageDialog(null, "הזנה3.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);

    }   catch (Exception e)
    {
    }
}

public void closeConnection()
{
	  try {
    		 db_connection.getInstance().closeConnection();
    } catch (SQLException ex) {
        Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
    }

}


}