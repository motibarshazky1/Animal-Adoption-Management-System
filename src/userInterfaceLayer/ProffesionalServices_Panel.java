package userInterfaceLayer;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BussinessLayer.Trainer;
import BussinessLayer.Vet;
import BussinessLayer.serverTunnel;

import javax.swing.JComboBox;

public class ProffesionalServices_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static String path;
	public static int next_case_id=21;
	private JTextField textField_Speciality;
	private JTextField textField_Age;
	private JTextField textField_Name;
	public MainWindow window1;
	private JTextField textField_ID;
	private JTextField textField_Experience;
	private JTextField textField_Phone;
	private JTextField textField_Address;
	
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
		JComboBox comboBox_Gender = new JComboBox(options_gender);

	
  		
			 
       String options[]={"Vet","Trainer"};        
		JComboBox comboBox_Job = new JComboBox(options);
	  
		comboBox_Job.setBounds(83, 17, 96, 21);
		panel_proffessional_details.add(comboBox_Job);
		
	
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.setBackground(new Color(70, 130, 180));

		
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
				if(textField_ID.getText().equals("") || comboBox_Job.getSelectedItem().toString().equals("") ||
						comboBox_Gender.getSelectedItem().toString().equals("") || textField_Name.getText().equals("") ||
						textField_Experience.getText().equals("") || textField_Speciality.getText().equals("") 	||
					textField_Age.getText().equals("") || textField_Phone.getText().equals("") 
					|| textField_Address.getText().equals("") )
	        		{
	        		 JOptionPane.showMessageDialog(null, "Please Fill all the Fields.", "Details", JOptionPane.PLAIN_MESSAGE);
	        		}
				else if(!textField_ID.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_ID.getText())<0  ||
						!textField_Age.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Age.getText())<0 ||
						!textField_Experience.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Experience.getText())<0  ||
						!textField_Phone.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Phone.getText())<0 
	
						)
        				JOptionPane.showMessageDialog(null, "Age,ID,Experience,phone must contains only digits .", "Details", JOptionPane.PLAIN_MESSAGE);

        		
	        		else
	        		{
						
					serverTunnel tunnel=null;
		       		try {
			 				 tunnel= serverTunnel.getInstance();				 			
		      
		       		}catch(Exception e1)
			     		{
			     			System.err.println(e1);

			     		} 
		       		if(comboBox_Job.getSelectedItem().toString().equals("Vet"))
		       		{
		       			Vet vet=new Vet(Integer.parseInt(textField_ID.getText()),
	        					textField_Name.getText(),
	        					comboBox_Gender.getSelectedItem().toString(),
	        					Integer.parseInt(textField_Age.getText()),
	        					textField_Speciality.getText(),
	        					Integer.parseInt(textField_Experience.getText()),
	        					Integer.parseInt(textField_Phone.getText()),
	        					textField_Address.getText()
	        					);
		 				 tunnel.UpdateProffInDB(vet);
		       		}
		       		else
		       		{
		       			Trainer trainer=new Trainer(Integer.parseInt(textField_ID.getText()),
	        					textField_Name.getText(),
	        					comboBox_Gender.getSelectedItem().toString(),
	        					Integer.parseInt(textField_Age.getText()),
	        					textField_Speciality.getText(),
	        					Integer.parseInt(textField_Experience.getText()),
	        					Integer.parseInt(textField_Phone.getText()),
	        					textField_Address.getText()
	        					);
		 				 tunnel.UpdateProffInDB(trainer);
		       		}
	        		}
			}
			
			
		});
		btnUpdate_1.setBackground(new Color(70, 130, 180));
		btnUpdate_1.setBounds(224, 180, 85, 27);
		panel_proffessional_details.add(btnUpdate_1);	
							
								
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(64, 76, 679, 214);
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
	   			////ffffff
	   			  		  textField_ID.setText(model.getValueAt(i, 0).toString());
	   			  		comboBox_Gender.setSelectedItem(model.getValueAt(i, 1).toString());
		   				 comboBox_Job.setSelectedItem((model.getValueAt(i, 2).toString()));
		   				    textField_Name.setText(model.getValueAt(i, 1).toString());
		   				    textField_Experience.setText(model.getValueAt(i, 4).toString());
		   				    textField_Speciality.setText(model.getValueAt(i, 3).toString());
		   				    textField_Age.setText(model.getValueAt(i, 6).toString());
		   				    textField_Phone.setText(model.getValueAt(i, 7).toString());
		   				    textField_Address.setText(model.getValueAt(i, 8).toString());

	   			  
	   			  		if(lblNewLabel_1.getText().equals("New Record"))
	   			  		{
	   			  		  textField_ID.setText("");
	   			  		comboBox_Gender.setSelectedItem("");
		   				 comboBox_Job.setSelectedItem("");
		   				    textField_Name.setText("");
		   				    textField_Experience.setText("");
		   				    textField_Speciality.setText("");
		   				    textField_Age.setText("");
		   				    textField_Address.setText("");
		   				    textField_Phone.setText("");
		   					    
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
								
								
								
								
								
								textField_Name = new JTextField();
								textField_Name.setBounds(83, 103, 96, 20);
								panel_proffessional_details.add(textField_Name);
								textField_Name.setColumns(10);
								
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
								label_2.setBounds(248, 21, 49, 14);
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
		
		textField_Speciality = new JTextField();
		textField_Speciality.setBounds(83, 140, 96, 20);
		panel_proffessional_details.add(textField_Speciality);
		textField_Speciality.setColumns(10);
		
		textField_Age = new JTextField();
		textField_Age.setBounds(312, 55, 96, 20);
		panel_proffessional_details.add(textField_Age);
		textField_Age.setColumns(10);
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_ID.getText().equals("") || comboBox_Job.getSelectedItem().toString().equals("") ||
						comboBox_Gender.getSelectedItem().toString().equals("") || textField_Name.getText().equals("") ||
						textField_Experience.getText().equals("") || textField_Speciality.getText().equals("") 	||
					textField_Age.getText().equals("") || textField_Phone.getText().equals("") 
					|| textField_Address.getText().equals("") )
	        		{
	        		 JOptionPane.showMessageDialog(null, "Please Fill all the Fields.", "Details", JOptionPane.PLAIN_MESSAGE);
	        		}
				else if(!textField_ID.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_ID.getText())<0  ||
						!textField_Age.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Age.getText())<0 ||
						!textField_Experience.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Experience.getText())<0  ||
						!textField_Phone.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Phone.getText())<0 
	
						
						)
        				JOptionPane.showMessageDialog(null, "Age,ID,Experience,phone must contains only digits .", "Details", JOptionPane.PLAIN_MESSAGE);

        	
        		
	        		else
	        		{
	        			serverTunnel tunnel=null;
			       		try {
				 				 tunnel= serverTunnel.getInstance();				 			
			      
			       		}catch(Exception e1)
				     		{
				     			System.err.println(e1);

				     		} 
			       		if(comboBox_Job.getSelectedItem().toString().equals("Vet"))
			       		{
			       			Vet vet=new Vet(Integer.parseInt(textField_ID.getText()),
		        					textField_Name.getText(),
		        					comboBox_Gender.getSelectedItem().toString(),
		        					Integer.parseInt(textField_Age.getText()),
		        					textField_Speciality.getText(),
		        					Integer.parseInt(textField_Experience.getText()),
		        					Integer.parseInt(textField_Phone.getText()),
		        					textField_Address.getText()
		        					);
			 				 tunnel.ProffToDB(vet);
			       		}
			       		else
			       		{
			       			Trainer trainer=new Trainer(Integer.parseInt(textField_ID.getText()),
		        					textField_Name.getText(),
		        					comboBox_Gender.getSelectedItem().toString(),
		        					Integer.parseInt(textField_Age.getText()),
		        					textField_Speciality.getText(),
		        					Integer.parseInt(textField_Experience.getText()),
		        					Integer.parseInt(textField_Phone.getText()),
		        					textField_Address.getText()
		        					);
			 				 tunnel.ProffToDB(trainer);
			       		}
	        			

	        

	        			
	        			       	
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
		
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBounds(83, 58, 96, 20);
		panel_proffessional_details.add(textField_ID);
		
		
	
		JLabel lblExperience_1 = new JLabel("Experience");
		lblExperience_1.setForeground(Color.WHITE);
		lblExperience_1.setFont(new Font("David", Font.BOLD, 13));
		lblExperience_1.setBounds(10, 187, 75, 14);
		panel_proffessional_details.add(lblExperience_1);
		
		textField_Experience = new JTextField();
		textField_Experience.setColumns(10);
		textField_Experience.setBounds(83, 184, 96, 20);
		panel_proffessional_details.add(textField_Experience);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setFont(new Font("David", Font.BOLD, 13));
		lblPhoneNumber.setBounds(224, 143, 90, 14);
		panel_proffessional_details.add(lblPhoneNumber);
		
		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBounds(312, 140, 96, 20);
		panel_proffessional_details.add(textField_Phone);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setFont(new Font("David", Font.BOLD, 13));
		lblAddress.setBounds(243, 106, 90, 14);
		panel_proffessional_details.add(lblAddress);
		
		textField_Address = new JTextField();
		textField_Address.setColumns(10);
		textField_Address.setBounds(312, 103, 96, 20);
		panel_proffessional_details.add(textField_Address);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 serverTunnel tunnel= serverTunnel.getInstance();	    
					if(comboBox_Job.getSelectedItem().toString().equals("VET"))
					{
						Vet vet=new Vet(Integer.parseInt(textField_ID.getText()),textField_Name.getText(),
								comboBox_Gender.getSelectedItem().toString(),Integer.parseInt(textField_Age.getText()),
								textField_Speciality.getText(),Integer.parseInt(textField_Experience.getText()),
										Integer.parseInt(textField_Phone.getText()),textField_Address.getText());
						 tunnel.DeleteProffFromDB(vet);

					}
					else
					{

						Trainer trainer=new Trainer(Integer.parseInt(textField_ID.getText()),textField_Name.getText(),
								comboBox_Gender.getSelectedItem().toString(),Integer.parseInt(textField_Age.getText()),
								textField_Speciality.getText(),Integer.parseInt(textField_Experience.getText()),
										Integer.parseInt(textField_Phone.getText()),textField_Address.getText());
						 tunnel.DeleteProffFromDB(trainer);

					}
					
				
					
				}catch(Exception e1)
       		{
       			System.err.println(e1);
   
       		} 
				 
			}
		});
		btnNewButton_1.setBounds(364, 180, 85, 27);
		panel_proffessional_details.add(btnNewButton_1);
		comboBox_Gender.setBounds(312, 17, 96, 21);
		panel_proffessional_details.add(comboBox_Gender);
		
	  
		
		
		JButton btnUpdateRecord = new JButton("Update / Delete Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1.setText("Update Record");
				table.setRowSelectionAllowed(true);
	   			btnNewButton_1.setVisible(true);
	   			btnUpdate_1.setVisible(true);
	   			btnNewButton.setVisible(false);
	   			panel_proffessional_details.setVisible(true);


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
		
			  		  textField_ID.setText("");
   				    comboBox_Gender.setSelectedItem("");
   				 comboBox_Job.setSelectedItem("");
   				    textField_Name.setText("");
   				    textField_Experience.setText("");
   				    textField_Speciality.setText("");
   				    textField_Age.setText("");
   				    textField_Address.setText("");
   				    textField_Phone.setText("");
   				

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
serverTunnel tunnel=null;
try {
	tunnel = serverTunnel.getInstance();
} catch (SQLException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
ArrayList<Vet> vets=tunnel.getVets();
for(int i = 0; i < vets.size(); i++){

    rowData[0] =vets.get(i).GetId();
     rowData[1] = vets.get(i).GetName();

      rowData[2] = "VET";
      rowData[3] = vets.get(i).GetSpecialty();
      rowData[4] = vets.get(i).GetExperience();
      rowData[5] =  vets.get(i).GetGender();
      rowData[6] =  vets.get(i).GetAge();
      rowData[7] =  vets.get(i).getPhone();
      rowData[8] =  vets.get(i).getAddress();
       model1.addRow(rowData);
	    table.setModel(model1);  
}
ArrayList<Trainer> trainers=tunnel.getTrainers();
for(int i = 0; i < trainers.size(); i++){

    rowData[0] =trainers.get(i).GetId();
     rowData[1] = trainers.get(i).GetName();
      rowData[2] = "Trainer";
      rowData[3] = trainers.get(i).GetSpecialty();
      rowData[4] = trainers.get(i).GetExperience();
      rowData[5] =  trainers.get(i).GetGender();
      rowData[6] =  trainers.get(i).GetAge();
      rowData[7] =  trainers.get(i).GetPhoneNumber();
      rowData[8] =  trainers.get(i).GetAddress();
       model1.addRow(rowData);
	    table.setModel(model1);  
}


////////////




		    
		    
	}
	
}
	
