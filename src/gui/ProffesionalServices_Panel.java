package gui;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import gui.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import userInterface.Work;
import webserver.serverTunnel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class ProffesionalServices_Panel extends JPanel {
	private JTable table;
	public static String path;
	public static int next_case_id=21;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	public MainWindow window1;
	private JTextField textField_11;
	private FileInputStream fis;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	
	/**
	 * Create the panel.
	 */
	public ProffesionalServices_Panel() {
		  System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));
		setBounds(219, 0, 794, 550);

		setLayout(null);
		setVisible(true);
		
		JPanel panel_proffessional_details = new JPanel();
       ButtonGroup G1 = new ButtonGroup();
		
	
       String options_gender[]={"Female","Male"};        
  		JComboBox comboBox_1 = new JComboBox(options_gender);
  		comboBox_1.setBounds(83, 102, 96, 21);
  		panel_proffessional_details.add(comboBox_1);
  		
			 
       String options[]={"Vet","Trainer"};        
		JComboBox comboBox = new JComboBox(options);
	  
		comboBox.setBounds(83, 17, 96, 21);
		panel_proffessional_details.add(comboBox);
		
	
		JButton btnNewButton_1 = new JButton("Delete");

		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(229, 288, 154, 24);
		add(lblNewLabel_1);
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(70, 130, 180));
		
		
		JButton btnUpdate_1 = new JButton("Update");
		btnUpdate_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 serverTunnel tunnel= new serverTunnel();	          	   
					 /*textField_11.setText(model.getValueAt(i, 0).toString());
	   				    textField.setText(model.getValueAt(i, 1).toString());
	   				    textField_1.setText(model.getValueAt(i, 2).toString());
	   				    textField_4.setText(model.getValueAt(i, 3).toString());
	   				    textField_13.setText(model.getValueAt(i, 4).toString());
	   				    textField_2.setText(model.getValueAt(i, 5).toString());
	   				    textField_3.setText(model.getValueAt(i, 6).toString());
	   				    textField_15.setText(model.getValueAt(i, 7).toString());
	   				    textField_14.setText(model.getValueAt(i, 8).toString());
	   				    */
					 String query ="UPDATE proffesional_services SET"
					 		+ " id="+textField_11.getText()+
							 ",Name= '"+ comboBox_1.getSelectedItem().toString()+
							 "', Job ='"+comboBox.getSelectedItem().toString()+
							 "',Speciality ='"+textField_4.getText()+
							 "',Experience ="+Integer.parseInt(textField_13.getText())+
							 ",Gender ='"+textField_2.getText()+
							 "',Age ="+textField_3.getText()+
							 ",Address ='"+textField_15.getText()+
							 "',Phone ="+textField_14.getText()+
							" WHERE id='"+textField_11.getText()+"';";
	    			tunnel.UpdateDB(query);
				}catch(Exception e1)
        		{
        			System.err.println(e1);
    
        		} 
         		 JOptionPane.showMessageDialog(null, "Update in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
        		EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainWindow window = new MainWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				});
			}
		});
		btnUpdate_1.setBackground(new Color(70, 130, 180));
		btnUpdate_1.setBounds(224, 180, 85, 27);
		panel_proffessional_details.add(btnUpdate_1);	
							
								
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(10, 76, 679, 214);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
	   	table = new JTable();
	   	table.setForeground(new Color(255, 255, 255));
	   	scrollPane.setViewportView(table);
	   	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	   	table.getTableHeader().setBackground(new Color(70,130,180));
	   	table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 14));
	   	
	   			table.setBorder(null);
	   			table.setBackground(new Color(112, 128, 144));
	   			table.addMouseListener(new MouseAdapter() {
	   				String query;
	   				ResultSet rs;
	   			  	@Override
	   			  	public void mouseClicked(MouseEvent e) {
	   			  		int i= table.getSelectedRow();
	   			  		TableModel model = table.getModel();       
	   			  	panel_proffessional_details.setVisible(true);
		   			btnNewButton_1.setVisible(true);
					
	   			 btnUpdate_1.setVisible(true);
	   			btnNewButton.setVisible(false);
	   			  		  textField_11.setText(model.getValueAt(i, 0).toString());
	   			  		comboBox_1.setSelectedItem(model.getValueAt(i, 1).toString());
		   				 comboBox.setSelectedItem((model.getValueAt(i, 2).toString()));
		   				    textField_4.setText(model.getValueAt(i, 3).toString());
		   				    textField_13.setText(model.getValueAt(i, 4).toString());
		   				    textField_2.setText(model.getValueAt(i, 5).toString());
		   				    textField_3.setText(model.getValueAt(i, 6).toString());
		   				    textField_14.setText(model.getValueAt(i, 7).toString());
		   				    textField_15.setText(model.getValueAt(i, 8).toString());

	   			  
	   			  		if(lblNewLabel_1.getText().equals("New Record"))
	   			  		{
	   			  		  textField_11.setText("");
	   			  		comboBox_1.setSelectedItem("");
		   				 comboBox.setSelectedItem("");
		   				    textField_4.setText("");
		   				    textField_13.setText("");
		   				    textField_2.setText("");
		   				    textField_3.setText("");
		   				    textField_15.setText("");
		   				    textField_14.setText("");
		   					    
	   			  		}
	   			    	 
	   				    
	   		
	   				 panel_proffessional_details.setVisible(true);
	   			  	}
	   			});
		

		
	
	   	JButton btnUpdate = new JButton("Update");
				
						
						panel_proffessional_details.setBounds(52, 318, 449, 214);
						add(panel_proffessional_details);
						panel_proffessional_details.setForeground(new Color(255, 255, 255));
						panel_proffessional_details.setBackground(new Color(47, 79, 79));
						panel_proffessional_details.setLayout(null);
						panel_proffessional_details.setVisible(false);
								
								
								
								
								
								textField_4 = new JTextField();
								textField_4.setBounds(83, 140, 96, 20);
								panel_proffessional_details.add(textField_4);
								textField_4.setColumns(10);
								
								JLabel lblExperience = new JLabel("Speciality");
								lblExperience.setForeground(new Color(255, 255, 255));
								lblExperience.setBounds(10, 143, 75, 14);
								panel_proffessional_details.add(lblExperience);
								lblExperience.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel label_3 = new JLabel("Age");
								label_3.setForeground(new Color(255, 255, 255));
								label_3.setBounds(265, 61, 49, 14);
								panel_proffessional_details.add(label_3);
								label_3.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel label_2 = new JLabel("Gender");
								label_2.setForeground(new Color(255, 255, 255));
								label_2.setBounds(265, 21, 49, 14);
								panel_proffessional_details.add(label_2);
								label_2.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel lblJob = new JLabel("Job");
								lblJob.setForeground(new Color(255, 255, 255));
								lblJob.setBounds(10, 21, 49, 14);
								panel_proffessional_details.add(lblJob);
								lblJob.setFont(new Font("David", Font.BOLD, 13));
								
								
								   	   
										
										JLabel label = new JLabel("Name");
										label.setForeground(new Color(255, 255, 255));
										label.setBounds(10, 106, 49, 14);
										panel_proffessional_details.add(label);
										label.setFont(new Font("David", Font.BOLD, 13));
		
		textField_2 = new JTextField();
		textField_2.setBounds(312, 13, 96, 20);
		panel_proffessional_details.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(312, 55, 96, 20);
		panel_proffessional_details.add(textField_3);
		textField_3.setColumns(10);
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_11.getText().equals("") || comboBox.getSelectedItem().toString().equals("") ||
						comboBox_1.getSelectedItem().toString().equals("") || textField_4.getText().equals("") ||
						textField_13.getText().equals("") || textField_2.getText().equals("") 	||
					textField_3.getText().equals("") || textField_14.getText().equals("") 
					|| textField_15.getText().equals("") )
	        		{
	        		 JOptionPane.showMessageDialog(null, "Please Fill all the Fields.", "Details", JOptionPane.PLAIN_MESSAGE);
	        		}
	        		else
	        		{
	        			Trainer trainer=new Trainer(Integer.parseInt(textField_11.getText()),
	        					comboBox_1.getSelectedItem().toString(),
	        					textField_4.getText(),
	        					Integer.parseInt(textField_13.getText()),
	        					textField_2.getText(),
	        					Integer.parseInt(textField_3.getText()),
	        					Integer.parseInt(textField_14.getText()),
	        					textField_15.getText()
	        					);
	        			String query="Insert into proffesional_services (ID,Name,Job,Speciality,Experience,Gender,Age,Phone,Address) values ("
	        					+trainer.GetId()+",'"+trainer.GetName()+"','"+comboBox.getSelectedItem().toString()+"','"+trainer.GetSpeciality()+"',"+trainer.GetExperience()+",'"
	        							+trainer.GetGender()+"',"+trainer.GetAge()+","+trainer.GetPhoneNumber()+",'"+trainer.GetAddress()+"');";
	        			;
	        			       		try {
	        				 				serverTunnel tunnel= new serverTunnel();
	        			       				tunnel.InsertCommand(query);
	        			       		}catch(Exception e1)
	        				     		{
	        				     			System.err.println(e1);

	        				     		} 
	        			       		EventQueue.invokeLater(new Runnable() { // open new window to see the changes
	        							public void run() {
	        								try {
	        									MainWindow window = new MainWindow();
	        									window.frame.setVisible(true);
	        								} catch (Exception e) {
	        									e.printStackTrace();
	        								}
	        							}
	        						
	        						});
	        		}
	        		
	    
			}
		});
		btnNewButton.setBounds(312, 180, 85, 27);
		panel_proffessional_details.add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("David", Font.BOLD, 13));
		lblId.setBounds(10, 61, 49, 14);
		panel_proffessional_details.add(lblId);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(83, 58, 96, 20);
		panel_proffessional_details.add(textField_11);
		
		
	
		JLabel lblExperience_1 = new JLabel("Experience");
		lblExperience_1.setForeground(Color.WHITE);
		lblExperience_1.setFont(new Font("David", Font.BOLD, 13));
		lblExperience_1.setBounds(10, 187, 75, 14);
		panel_proffessional_details.add(lblExperience_1);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(83, 184, 96, 20);
		panel_proffessional_details.add(textField_13);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("David", Font.BOLD, 13));
		lblPhoneNumber.setBounds(224, 143, 90, 14);
		panel_proffessional_details.add(lblPhoneNumber);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(312, 140, 96, 20);
		panel_proffessional_details.add(textField_14);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("David", Font.BOLD, 13));
		lblAddress.setBounds(243, 106, 90, 14);
		panel_proffessional_details.add(lblAddress);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(312, 103, 96, 20);
		panel_proffessional_details.add(textField_15);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 serverTunnel tunnel= new serverTunnel();	          	   
					
					 String query ="Delete from proffesional_services WHERE ID="+Integer.parseInt(textField_11.getText())+";";
	    			tunnel.InsertCommand(query);
				}catch(Exception e1)
       		{
       			System.err.println(e1);
   
       		} 
        		 JOptionPane.showMessageDialog(null, "Delete Action in Progress.\n proccess will be finished in few seconds.\n Press ok to continue.", "Details", JOptionPane.PLAIN_MESSAGE);
       		EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							MainWindow window = new MainWindow();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					
				});
			}
		});
		btnNewButton_1.setBounds(364, 180, 85, 27);
		panel_proffessional_details.add(btnNewButton_1);
		
	  
		
		
		JButton btnUpdateRecord = new JButton("Update / Delete Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("Update Record");
				table.setRowSelectionAllowed(true);
	   			btnNewButton_1.setVisible(true);
	   			btnUpdate_1.setVisible(true);
	   			btnNewButton.setVisible(false);


			}
		});
		btnUpdateRecord.setBackground(new Color(70, 130, 180));
		btnUpdateRecord.setBounds(573, 333, 139, 42);
		add(btnUpdateRecord);
		
		JButton btnNewRecord = new JButton("New Record");
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btnUpdate_1.setVisible(false);
		   			btnNewButton.setVisible(true);
		   			btnNewButton_1.setVisible(false);
		   			
				table.setRowSelectionAllowed(false);
				panel_proffessional_details.setVisible(true);
				lblNewLabel_1.setText("New Record");
		
			  		  textField_11.setText("");
   				    comboBox_1.setSelectedItem("");
   				 comboBox.setSelectedItem("");
   				    textField_4.setText("");
   				    textField_13.setText("");
   				    textField_2.setText("");
   				    textField_3.setText("");
   				    textField_15.setText("");
   				    textField_14.setText("");
   				

			}
			
		});
		btnNewRecord.setBackground(new Color(70, 130, 180));
		btnNewRecord.setBounds(573, 385, 139, 42);
		add(btnNewRecord);
		
		JLabel lblNewLabel = new JLabel("Proffessional Services");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(196, 31, 324, 35);
		add(lblNewLabel);
		
		
		
		
;

DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[9];

columnsName1[0] = "id";
columnsName1[1] = "Name";
columnsName1[2] = "Job";
columnsName1[3] = "Speciality";
columnsName1[4] = "Exprience";
columnsName1[5] = "Gender";
columnsName1[6] = "Age";
columnsName1[7] = "Phone";
columnsName1[8] = "Address";

model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[9];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}
for(int i = 0; i < getUsers().size(); i++){
	String[] parts = getUsers().get(i).split(","); // String array, each element is text between dots

    rowData[0] =parts[0];
     rowData[1] = parts[1];
      rowData[2] = parts[2];
      rowData[3] = parts[3];
      rowData[4] = parts[4];
      rowData[5] = parts[5];
      rowData[6] = parts[6];
      rowData[7] = parts[7];
      rowData[8] = parts[8];
       model1.addRow(rowData);
	    table.setModel(model1);
      
}


////////////




		    
		    
	}
	 static ArrayList<String> getUsers(){
	      
	      ArrayList<String> preoffesionls = new ArrayList<String>();
	      
	      ResultSet rs;
	      String query;
	      String u;
	      
	      try {
	          
	          
	          	serverTunnel tunnel= new serverTunnel();
	       	
	          
    		 query = "SELECT * FROM proffesional_services order by Job,Experience DESC";

			 //else  query = "SELECT * FROM proffesional_services";

			 
	    		 rs = tunnel.SelectCommand(query);
	    		 
	          
	          while(rs.next()){
	     		
	              u =  ""+
	                      rs.getInt("ID")+","+
	                      rs.getString("Name")+","+
	                      rs.getString("Job")+","+
	                      rs.getString("Speciality")+","+
	                      rs.getInt("Experience")+","+
	                      rs.getString("Gender")+","+
	                      rs.getInt("Age")+","+
	                      rs.getInt("Phone")+","+
                  rs.getString("Address");


	              preoffesionls.add(u);
	          }
	           
	      } catch (SQLException ex) {
	          Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
	      }

	      return preoffesionls;
	  }
}
	
