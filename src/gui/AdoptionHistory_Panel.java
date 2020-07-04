package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.fabric.xmlrpc.base.Array;

import userInterface.Work;
import webserver.serverTunnel;

import java.awt.BorderLayout;

public class AdoptionHistory_Panel extends JPanel {
	public MainWindow window1;

	private JTable table;

	/**
	 * Create the panel.
	 */
	public AdoptionHistory_Panel() {
		
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 23, 696, 151);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	  			JScrollPane scrollPane = new JScrollPane();
	  			panel.add(scrollPane, BorderLayout.CENTER);
	  			
	  	table = new JTable();
	  	scrollPane.setViewportView(table);
	  	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	  	table.getTableHeader().setBackground(new Color(32,103,100));
	  	table.getTableHeader().setFont(new Font("David", Font.BOLD, 18));
	  	
	  			table.setBorder(null);
	  			table.setBackground(new Color(95, 158, 160));
					table.addMouseListener(new MouseAdapter() {
					  	@Override
					  	public void mouseClicked(MouseEvent e) {
					  		int i= table.getSelectedRow();
					  		TableModel model = table.getModel();       
					  		
						 
					  	}
					});
					

DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "Adoption ID";
columnsName1[1] = "Date";
columnsName1[2] = "Animal Name";
columnsName1[3] = "Animal ID";
columnsName1[4] = "Adopter ID";
columnsName1[5] = "Adopter Name";

model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[6];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}


for(int i = 0; i < getAdoption().size(); i++){
	String[] parts = getAdoption().get(i).split(","); // String array, each element is text between dots

    rowData[0] =parts[0];
     rowData[1] = parts[1];
      rowData[2] = parts[2];
      rowData[3] = parts[3];
      rowData[4] = parts[4];
      rowData[5] = parts[5];
       
       model1.addRow(rowData);
	    table.setModel(model1);
      
}

	}
	public static ArrayList<String> getAdoption(){
	      
	      ArrayList<String> adoptions = new ArrayList<String>();
	      ResultSet rs;
	      String query;
	     // Animal a;
	     // Adopter b;
	      //Adoption u;
	      String case2;
	      
	      try {
	          
	          	serverTunnel tunnel= new serverTunnel();
	    		 query = "SELECT * FROM adoption_history";
	    		 rs = tunnel.SelectCommand(query);
	          
	          while(rs.next()){
	        	  
	        	  case2=""+rs.getInt("Adoption_ID")+","+","+rs.getString("Animal_Name")+","+rs.getInt("Animal_ID")+","+rs.getInt("Adopter_ID")+","+rs.getString("Adopter_Name")+"";
	        	  
	        	  //a=new Animal(rs.getString("Animal_Name"),"","",0,0);
	        	 // b=new Adopter("","",rs.getInt("Adopter_ID"),0);
	           
	             // u = new Adoption( 
	            		 //rs.getInt("Adoption_ID"),rs.getDate("Date").toString(),a,b);
	             
        
	              adoptions.add(case2);
	          }
	           
	      } catch (SQLException ex) {
	          Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
	      }

	      return adoptions;
	  }
	
}
