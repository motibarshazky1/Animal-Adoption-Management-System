package gui;

import javax.swing.JPanel;

import webserver.serverTunnel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.ResultSet;
import java.awt.Color;
import javax.swing.JSeparator;

public class AdoptionStatistics_Panel extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdoptionStatistics_Panel() {
		setBounds(219, 0, 758, 545);

		setBackground(new Color(47, 79, 79));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistics");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 26));
		lblNewLabel.setBounds(290, 8, 200, 62);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("The oldest animal :");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_1.setBounds(10, 162, 194, 24);
		add(lblNewLabel_1);
		
		JLabel lblX = new JLabel("x");
		lblX.setForeground(new Color(0, 0, 0));
		lblX.setFont(new Font("Dialog", Font.BOLD, 18));
		lblX.setBounds(186, 162, 169, 24);
		add(lblX);
		
		JLabel lblTheYoungestAnimal = new JLabel("The youngest animal :");
		lblTheYoungestAnimal.setForeground(Color.WHITE);
		lblTheYoungestAnimal.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTheYoungestAnimal.setBounds(10, 196, 207, 24);
		add(lblTheYoungestAnimal);
		
		JLabel lblY = new JLabel("y");
		lblY.setForeground(Color.BLACK);
		lblY.setFont(new Font("Dialog", Font.BOLD, 18));
		lblY.setBounds(214, 196, 141, 24);
		add(lblY);
		
		JLabel lblTheAnimalsAvarage = new JLabel("The Animal's Avarage age :");
		lblTheAnimalsAvarage.setForeground(Color.WHITE);
		lblTheAnimalsAvarage.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTheAnimalsAvarage.setBounds(10, 230, 242, 24);
		add(lblTheAnimalsAvarage);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setForeground(Color.BLACK);
		lblZ.setFont(new Font("Dialog", Font.BOLD, 18));
		lblZ.setBounds(262, 230, 121, 24);
		add(lblZ);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 205));
		panel.setBounds(10, 332, 107, 45);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Dialog", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(46, 10, 51, 25);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(219, 112, 147));
		panel_1.setLayout(null);
		panel_1.setBounds(141, 332, 107, 45);
		add(panel_1);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setFont(new Font("Dialog", Font.ITALIC, 18));
		label_6.setBounds(37, 10, 46, 25);
		panel_1.add(label_6);
		
		JLabel lblMale = new JLabel("Male");
		lblMale.setForeground(Color.WHITE);
		lblMale.setFont(new Font("Dialog", Font.BOLD, 18));
		lblMale.setBounds(42, 298, 55, 24);
		add(lblMale);
		
		JLabel lblFemale = new JLabel("Female");
		lblFemale.setForeground(Color.WHITE);
		lblFemale.setFont(new Font("Dialog", Font.BOLD, 18));
		lblFemale.setBounds(157, 298, 70, 24);
		add(lblFemale);
		
		JLabel label = new JLabel("Female");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(567, 299, 70, 24);
		add(label);
		
		JLabel label_1 = new JLabel("Male");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 18));
		label_1.setBounds(452, 299, 55, 24);
		add(label_1);
		
		JLabel label_2 = new JLabel("The Animal's Avarage age :");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 18));
		label_2.setBounds(393, 230, 242, 24);
		add(label_2);
		
		JLabel label_3 = new JLabel("The youngest animal :");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 18));
		label_3.setBounds(393, 196, 207, 24);
		add(label_3);
		
		JLabel label_4 = new JLabel("The oldest animal :");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 18));
		label_4.setBounds(393, 162, 194, 24);
		add(label_4);
		
		JLabel label_5 = new JLabel("x");
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Dialog", Font.BOLD, 18));
		label_5.setBounds(565, 161, 156, 24);
		add(label_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(new Color(0, 0, 205));
		panel_3.setBounds(420, 333, 107, 45);
		add(panel_3);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setBounds(29, 10, 51, 25);
		panel_3.add(label_7);
		label_7.setFont(new Font("Dialog", Font.ITALIC, 18));
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(219, 112, 147));
		panel_2.setBounds(551, 333, 107, 45);
		add(panel_2);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setBounds(34, 10, 46, 25);
		panel_2.add(label_8);
		label_8.setFont(new Font("Dialog", Font.ITALIC, 18));
		
		JLabel label_9 = new JLabel("x");
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Dialog", Font.BOLD, 18));
		label_9.setBounds(597, 195, 178, 24);
		add(label_9);
		
		JLabel label_10 = new JLabel("x");
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Dialog", Font.BOLD, 18));
		label_10.setBounds(648, 229, 178, 24);
		add(label_10);
		
		JLabel lblIsWaitingSince = new JLabel("is waiting since");
		lblIsWaitingSince.setForeground(Color.WHITE);
		lblIsWaitingSince.setFont(new Font("Dialog", Font.BOLD, 18));
		lblIsWaitingSince.setBounds(48, 427, 156, 24);
		add(lblIsWaitingSince);
		
		JLabel label_11 = new JLabel("is waiting since");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Dialog", Font.BOLD, 18));
		label_11.setBounds(481, 427, 156, 24);
		add(label_11);
		
		JLabel label_12 = new JLabel(".");
		label_12.setForeground(Color.BLACK);
		label_12.setFont(new Font("Dialog", Font.BOLD, 18));
		label_12.setBounds(83, 405, 121, 24);
		add(label_12);
		
		JLabel label_13 = new JLabel(".");
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Dialog", Font.BOLD, 18));
		label_13.setBounds(526, 405, 121, 24);
		add(label_13);
		
		JLabel label_14 = new JLabel(".");
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Dialog", Font.BOLD, 18));
		label_14.setBounds(83, 452, 121, 24);
		add(label_14);
		
		JLabel lblHelpHimFind = new JLabel("Help him find home");
		lblHelpHimFind.setForeground(Color.WHITE);
		lblHelpHimFind.setFont(new Font("Dialog", Font.BOLD, 18));
		lblHelpHimFind.setBounds(48, 474, 200, 24);
		add(lblHelpHimFind);
		
		JLabel label_15 = new JLabel(".");
		label_15.setForeground(Color.BLACK);
		label_15.setFont(new Font("Dialog", Font.BOLD, 18));
		label_15.setBounds(526, 452, 121, 24);
		add(label_15);
		
		JLabel label_16 = new JLabel("Help him find home");
		label_16.setForeground(Color.WHITE);
		label_16.setFont(new Font("Dialog", Font.BOLD, 18));
		label_16.setBounds(452, 474, 200, 24);
		add(label_16);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(72, 61, 139));
		panel_4.setBounds(10, 92, 291, 37);
		add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Dogs");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_3.setBounds(118, 6, 73, 27);
		panel_4.add(lblNewLabel_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(72, 61, 139));
		panel_5.setBounds(457, 92, 291, 37);
		add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblCats = new JLabel("Cats");
		lblCats.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCats.setBounds(109, 6, 73, 27);
		panel_5.add(lblCats);
		
		   serverTunnel tunnel=null;
		   String query="";
	         	try {
 	         tunnel=new serverTunnel();
	    		 query="Select max(Age) as max,Name from available_animal where Type='Dog';";
 	         	ResultSet rs=tunnel.SelectCommand(query);
 	         	while(rs.next())
 	         	{
 	         		lblX.setText(rs.getString("Name")+"  Age: "+rs.getInt("max"));
 	         	}
 	        	if(lblX.getText().equals("null  Age: 0"))	
 	        		lblX.setText("none");
 	         		}catch(Exception e1)
     	     		{
	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
     	     			System.err.println(e1);
     	     		}		
	         	
	          	try {
	   	    		query="Select min(Age) as min,Name from available_animal where Type='Dog';";
	    	         	ResultSet rs2=tunnel.SelectCommand(query);
	    	         	while(rs2.next())
	    	         	{
	    	         		lblY.setText(rs2.getString("Name")+"  Age: "+rs2.getInt("min"));
	    	         	}
	    	         	if(lblY.getText().equals("null  Age: 0"))	
	    	         		lblY.setText("none");
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	try {
	   	    		query="Select AVG(Age) as avg1 from available_animal where Type='Dog';";
	    	         	ResultSet rs3=tunnel.SelectCommand(query);
	    	         	while(rs3.next())
	    	         	{
	    	         		lblZ.setText(" "+rs3.getInt("avg1"));
	    	         	}
	    	        	if(lblZ.getText().equals(" 0"))	
	    	        		lblZ.setText("none");
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	
	        	
	        	
	        	
	        	try {
	   	    		query="Select count(*) as count from available_animal where Type='Dog' and Gender='Male';";
	    	         	ResultSet rs4=tunnel.SelectCommand(query);
	    	         	while(rs4.next())
	    	         	{
	    	         		lblNewLabel_2.setText(" "+rs4.getInt("count"));
	    	         	}
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	try {
	   	    		query="Select count(*) as count from available_animal where Type='Dog' and Gender='Female';";
	    	         	ResultSet rs5=tunnel.SelectCommand(query);
	    	         	while(rs5.next())
	    	         	{
	    	         		label_6.setText(" "+rs5.getInt("count"));
	    	         	}
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	try {
	   	    		query="Select count(*) as count from available_animal where Type='Cat' and Gender='Male';";
	    	         	ResultSet rs7=tunnel.SelectCommand(query);
	    	         	while(rs7.next())
	    	         	{
	    	         		label_7.setText(" "+rs7.getInt("count"));
	    	         	}
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	try {
	   	    		query="Select count(*) as count from available_animal where Type='Cat' and Gender='Female';";
	    	         	ResultSet rs8=tunnel.SelectCommand(query);
	    	         	while(rs8.next())
	    	         	{
	    	         		label_8.setText(" "+rs8.getInt("count"));
	    	         	}
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}	
	        	
	          	try {
	    	         tunnel=new serverTunnel();
	   	    		 query="Select max(Age) as max,Name from available_animal where Type='Cat';";
	    	         	ResultSet rs9=tunnel.SelectCommand(query);
	    	         	while(rs9.next())
	    	         	{
	    	         			label_5.setText(rs9.getString("Name")+"  Age: "+rs9.getInt("max"));
	    	         
	    	         		
	    	         	}
	    	         	if(label_5.getText().equals("null  Age: 0"))	
	    	         			label_5.setText("none");
	    	         		}catch(Exception e1)
	        	     		{
	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	        	     			System.err.println(e1);
	        	     		}		
	   	         	
	   	          	try {
	   	   	    		query="Select min(Age) as min,Name from available_animal where Type='Cat';";
	   	    	         	ResultSet rs10=tunnel.SelectCommand(query);
	   	    	         	while(rs10.next())
	   	    	         	{
		    	         			label_9.setText(rs10.getString("Name")+"  Age: "+rs10.getInt("min"));
		    	         		
		    	         		
	   	    	         	}
	   	    	         if(label_9.getText().equals("null  Age: 0"))	
	   	    	        	label_9.setText("none");
	   	    	         		}catch(Exception e1)
	   	        	     		{
	   	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	   	        	     			System.err.println(e1);
	   	        	     		}	
	   	        	try {
	   	   	    		query="Select AVG(Age) as avg1 from available_animal where Type='Cat';";
	   	    	         	ResultSet rs11=tunnel.SelectCommand(query);
	   	    	         	while(rs11.next())
	   	    	         	{
		    	         			label_10.setText(" "+rs11.getInt("avg1"));
		    	        		
	   	    	         	}

		   	    	         if(label_10.getText().equals(" 0"))	
		   	    	        	label_10.setText("none");
	   	    	         		}catch(Exception e1)
	   	        	     		{
	   	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	   	        	     			System.err.println(e1);
	   	        	     		}
	   	        	
	   	        	try {
	   	   	    		query="Select Name,Date from available_animal where Type='Dog' order by Date DESC limit 1;";
	   	    	         	ResultSet rs12=tunnel.SelectCommand(query);
	   	    	         	while(rs12.next())
	   	    	         	{
	    	         			label_12.setText(" "+rs12.getString("Name"));
	    	         			label_14.setText(" "+rs12.getDate("Date").toString());
		    	         		lblIsWaitingSince.setVisible(true);
		    	         		lblHelpHimFind.setVisible(true);

	   	    	         	}
	   	    	         	if(label_12.getText().equals("."))
	   	    	         	{
	   	    	         	label_12.setVisible(false);
	    	         		label_14.setVisible(false);
	    	         		lblIsWaitingSince.setVisible(false);
	    	         		lblHelpHimFind.setVisible(false);
	   	    	         	}

	   	    	     	
	   	    	         		}catch(Exception e1)
	   	        	     		{
	   	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
	   	        	     			System.err.println(e1);
	   	        	     		}
	   	     
   	        	try {
   	   	    		query="Select Name,Date from available_animal where Type='Cat' order by Date DESC limit 1;";
   	    	         	ResultSet rs13=tunnel.SelectCommand(query);
   	    	         	while(rs13.next())
   	    	         	{
    	         			label_13.setText(" "+rs13.getString("Name"));
    	         			label_15.setText(" "+rs13.getDate("Date").toString());
    	         			label_11.setVisible(true);
        	         		label_16.setVisible(true);
	    	        		
   	    	         	}
   	    	         	if(label_13.getText().equals("."))
   	    	         	{
   	    	         	label_13.setVisible(false);
    	         		label_15.setVisible(false);
    	         		label_11.setVisible(false);
    	         		label_16.setVisible(false);
   	    	         	}
   	    	         		
   	    	         		}catch(Exception e1)
   	        	     		{
   	   	           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
   	        	     			System.err.println(e1);
   	        	     		}
	        	
	        	
	        	
		
		

	}
}
