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
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import BussinessLayer.Manager;
import BussinessLayer.Volunteer;
import BussinessLayer.serverTunnel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class Management_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static String path;
	public static int next_case_id=21;
	private JTextField textField_Name;
	public MainWindow window1;
	private JTextField textField_pass;
	private JTextField textField_ID;
	private JTextField textField_Age;
	
	/**
	 * Create the panel.
	 */
	public Management_Panel() {
		
		  System.setProperty("sun.java2d.uiScale", "1.0");
		  
		setBackground(new Color(47, 79, 79));
		setBounds(219, 0, 794, 550);

		setLayout(null);
		setVisible(true);
       JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(116, 322, 447, 205);
		add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(false);

	
		JButton btnUpdate = new JButton("Update");
		JButton btn_submit = new JButton("Submit");
		btn_submit.setBounds(173, 149, 85, 27);
		panel_1.add(btn_submit);
		btn_submit.setBackground(new Color(70, 130, 180));
		JButton btn_Delete = new JButton("Delete");
		btn_Delete.setBackground(new Color(70, 130, 180));
		

		
	
		JButton btnUpdate_1 = new JButton("Update");

       String options[]={"Admin","Vulanteer"};        
       String options_Gender[]={"Male","Female"};        
       JComboBox comboBox_Gender = new JComboBox(options_Gender);
		comboBox_Gender.setBounds(78, 58, 96, 21);
		panel_1.add(comboBox_Gender);
		JComboBox comboBox_permission = new JComboBox(options);
		comboBox_permission.setModel(new DefaultComboBoxModel(new String[] {"Admin", "Volanteer"}));
		comboBox_permission.setBounds(78, 102, 96, 21);
		panel_1.add(comboBox_permission);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(229, 288, 154, 24);
		add(lblNewLabel_1);
							
								
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(55, 76, 679, 214);
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
			   			  	@Override
			   			  	public void mouseClicked(MouseEvent e) {
			   					btn_Delete.setVisible(true);

			   					table.setRowSelectionAllowed(true);
			   			  		int i= table.getSelectedRow();
			   			  		TableModel model = table.getModel(); 
			   					panel_1.setVisible(true);
			   					btn_submit.setVisible(false);
			   					btnUpdate_1.setVisible(true);
			   					lblNewLabel_1.setText("Update User");
			   			  	textField_ID.setText(model.getValueAt(i, 0).toString());
   			    	textField_Name.setText(model.getValueAt(i, 1).toString());
   			    	comboBox_Gender.setSelectedItem(model.getValueAt(i, 2).toString());
   				 textField_Age.setText(model.getValueAt(i, 3).toString());
   				    textField_pass.setText(model.getValueAt(i, 4).toString());
   				 comboBox_permission.setSelectedItem(model.getValueAt(i, 5).toString());
   				    
   				    
				}
			   			});
		

	   
		
		
		JButton btnUpdateRecord = new JButton("Update / Delete Record");
		btnUpdateRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 btn_Delete.setVisible(true);

				table.setRowSelectionAllowed(true);
				btn_submit.setVisible(false);
				lblNewLabel_1.setText("Update User");
				btnUpdate_1.setVisible(true);
				panel_1.setVisible(true);



			}
		});
		btnUpdateRecord.setBackground(new Color(70, 130, 180));
		btnUpdateRecord.setBounds(573, 333, 139, 42);
		add(btnUpdateRecord);
		

		JButton btnNewRecord = new JButton("New Record");
		btnNewRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_Delete.setVisible(false);
				table.setRowSelectionAllowed(false);
				lblNewLabel_1.setVisible(true);
				table.setRowSelectionAllowed(false);
				lblNewLabel_1.setText("New Record");
		
			  		 textField_ID.setText("");
	   				 comboBox_Gender.setSelectedItem("");
   				    textField_Name.setText("");
   				    textField_Age.setText("");
   				    textField_pass.setText("");
   				    comboBox_permission.setSelectedItem("");
   				 btnUpdate_1.setVisible(false);
   				btn_submit.setVisible(true);
				panel_1.setVisible(true);

   				

			}
			
		});
		btnNewRecord.setBackground(new Color(70, 130, 180));
		btnNewRecord.setBounds(573, 385, 139, 42);
		add(btnNewRecord);
		
		JLabel lblNewLabel = new JLabel("Users Management");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 27));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(260, 31, 324, 35);
		add(lblNewLabel);
		
		
	
		
		textField_pass = new JTextField();
		textField_pass.setBounds(304, 102, 96, 20);
		panel_1.add(textField_pass);
		textField_pass.setColumns(10);
		
		textField_Name = new JTextField();
		textField_Name.setBounds(78, 10, 96, 20);
		panel_1.add(textField_Name);
		textField_Name.setColumns(10);
		
		JLabel lblJob = new JLabel("Name");
		lblJob.setBounds(14, 21, 49, 14);
		panel_1.add(lblJob);
		lblJob.setForeground(new Color(255, 255, 255));
		lblJob.setFont(new Font("David", Font.BOLD, 13));
		
		JLabel lblId = new JLabel("password");
		lblId.setBounds(226, 105, 68, 21);
		panel_1.add(lblId);
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("David", Font.BOLD, 13));
		
		
		   	   
				
				JLabel lblPermission = new JLabel("Permission");
				lblPermission.setBounds(0, 106, 68, 14);
				panel_1.add(lblPermission);
				lblPermission.setForeground(new Color(255, 255, 255));
				lblPermission.setFont(new Font("David", Font.BOLD, 13));
				
				
		
				
				textField_ID = new JTextField();
				textField_ID.setColumns(10);
				textField_ID.setBounds(304, 10, 96, 20);
				panel_1.add(textField_ID);
				
				JLabel lblId_1 = new JLabel("ID");
				lblId_1.setForeground(Color.WHITE);
				lblId_1.setFont(new Font("David", Font.BOLD, 13));
				lblId_1.setBounds(240, 21, 49, 14);
				panel_1.add(lblId_1);
				
				textField_Age = new JTextField();
				textField_Age.setColumns(10);
				textField_Age.setBounds(304, 58, 96, 20);
				panel_1.add(textField_Age);
				
				JLabel lblAge = new JLabel("Age");
				lblAge.setForeground(Color.WHITE);
				lblAge.setFont(new Font("David", Font.BOLD, 13));
				lblAge.setBounds(226, 61, 68, 14);
				panel_1.add(lblAge);
				
				
				
				JLabel lblGender = new JLabel("Gender");
				lblGender.setForeground(Color.WHITE);
				lblGender.setFont(new Font("David", Font.BOLD, 13));
				lblGender.setBounds(0, 62, 68, 14);
				panel_1.add(lblGender);
				
				btnUpdate_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						serverTunnel tunnel=null;

						try {
							tunnel=serverTunnel.getInstance();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}          	     		 
					
						if(!comboBox_permission.getSelectedItem().toString().equals("Admin"))
						{
							Volunteer volanteer=new Volunteer(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
			      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
							tunnel.userUpdateInDB(volanteer);

						}
						else 
						{
							Manager manager=new Manager(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
			      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
							tunnel.userUpdateInDB(manager);

						}
					 	EventQueue.invokeLater(new Runnable() {
	    					public void run() {
	    						try {
	    							MainWindow.closeWindow();
	    							MainWindow window =new MainWindow(MainWindow.user);
	    							MainWindow.frame.setVisible(true);
	    							

	    						} catch (Exception e) {
	    							e.printStackTrace();
	    						}
	    					}
	    				});
						
					}
				});
				btnUpdate_1.setBackground(new Color(70, 130, 180));
				btnUpdate_1.setBounds(173, 162, 85, 27);
				panel_1.add(btnUpdate_1);
				
				btn_Delete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						serverTunnel tunnel=null;

						try {
							tunnel=serverTunnel.getInstance();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}          	     		 
					
						if(!comboBox_permission.getSelectedItem().toString().equals("Admin"))
						{
							Volunteer volanteer=new Volunteer(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
			      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
							tunnel.userDeleteFromDB(volanteer);

						}
						else 
						{
							Manager manager=new Manager(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
			      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
							tunnel.userDeleteFromDB(manager);

						}
					 	EventQueue.invokeLater(new Runnable() {
	    					public void run() {
	    						try {
	    							MainWindow.closeWindow();
	    							MainWindow window =new MainWindow(MainWindow.user);
	    							MainWindow.frame.setVisible(true);
	    							

	    						} catch (Exception e) {
	    							e.printStackTrace();
	    						}
	    					}
	    				});
						
					}
					
						
			  
					
				});
				btn_Delete.setBounds(277, 165, 85, 21);
				panel_1.add(btn_Delete);
				
					btn_submit.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							if(textField_Age.getText().equals("")||
									textField_ID.getText().equals("")||	
									textField_Name.getText().equals("")||
									textField_pass.getText().equals("")||	
									comboBox_Gender.getSelectedItem().toString().equals("")||
									comboBox_permission.getSelectedItem().toString().equals("")
									)
		        				JOptionPane.showMessageDialog(null, "You must fill all the fields", "Details", JOptionPane.PLAIN_MESSAGE);

								else if((!textField_Age.getText().chars().allMatch(Character::isDigit)) ||
										Integer.parseInt(textField_Age.getText())<0
										||!textField_ID.getText().chars().allMatch(Character::isDigit) ||
								Integer.parseInt(textField_ID.getText())<0)
				        				JOptionPane.showMessageDialog(null, "Age\\ID must  be equal to zero and above.", "Details", JOptionPane.PLAIN_MESSAGE);
								else
								{
							
							
							
							serverTunnel tunnel=null;

							try {
								tunnel=serverTunnel.getInstance();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}          	     		 
							
 	     	
			      			 //Volunteer vol=new Volunteer(rs.getInt("ID"), rs.getString("Name"), rs.getString("Gender"),rs.getInt("Age"), rs.getInt("Experience"), rs.getString("pass"),rs.getString("premmission"));
							if(!comboBox_permission.getSelectedItem().toString().equals("Admin"))
							{
								Volunteer volanteer=new Volunteer(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
				      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
								tunnel.userToDB(volanteer);

							}
							else 
							{
								Manager manager=new Manager(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),comboBox_Gender.getSelectedItem().toString(),
				      					Integer.parseInt(textField_Age.getText()),  textField_pass.getText(),comboBox_permission.getSelectedItem().toString());
								tunnel.userToDB(manager);

							}
							
							

						 	EventQueue.invokeLater(new Runnable() {
		    					public void run() {
		    						try {
		    							MainWindow.closeWindow();
		    							MainWindow window =new MainWindow(MainWindow.user);
		    							MainWindow.frame.setVisible(true);
		    							

		    						} catch (Exception e) {
		    							e.printStackTrace();
		    						}
		    					}
		    				});
				     				
				     				
				     			}
						}
						
					});
		
	
DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "id";
columnsName1[1] = "Name";
columnsName1[2] = "Gender";
columnsName1[3] = "Age";
columnsName1[4] = "Password";
columnsName1[5] = "Premission";


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
ArrayList<Volunteer> volunteer=tunnel.getVolunteers();
for(int i = 0; i < volunteer.size(); i++){

    rowData[0] =volunteer.get(i).GetId();
     rowData[1] = volunteer.get(i).GetName();
      rowData[2] =  volunteer.get(i).GetGender();
      rowData[3] =  volunteer.get(i).GetAge();
      rowData[4] =  volunteer.get(i).getPassword();
      rowData[5] =  volunteer.get(i).getPermmission();
       model1.addRow(rowData);
	    table.setModel(model1);  
}
ArrayList<Manager> managers=tunnel.getManagers();
for(int i = 0; i < managers.size(); i++){

	 rowData[0] =managers.get(i).GetId();
     rowData[1] = managers.get(i).GetName();
      rowData[2] =  managers.get(i).GetGender();
      rowData[3] =  managers.get(i).GetAge();
      rowData[4] =  managers.get(i).getPassword();
      rowData[5] =  managers.get(i).getPermmission();
       model1.addRow(rowData);
	    table.setModel(model1);  
}


////////////




		    
		    
	}
}
	
