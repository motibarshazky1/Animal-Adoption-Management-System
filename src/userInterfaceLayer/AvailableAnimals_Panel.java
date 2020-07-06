package userInterfaceLayer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logicalLayers.*;
import javax.swing.JComboBox;


public class AvailableAnimals_Panel extends JPanel {
	private JTable table;
	public static String path;
	public static int next_case_id=21;

	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	public MainWindow window1;
	private JTextField textField_11;
	private FileInputStream fis;
	private JTextField textField_12;
	/**
	 * Create the panel.
	 */
	public AvailableAnimals_Panel() {
		  System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));
		setBounds(219, 0, 758, 545);

		setLayout(null);
		setVisible(true);
		
		JPanel panel_animal_details = new JPanel();

		
	       String options[]={"DOG","CAT"};        
		JComboBox comboBox = new JComboBox(options);
		comboBox.setBounds(57, 6, 96, 21);
		panel_animal_details.add(comboBox);
										
	     String options_Gender[]={"Male","Female"};        
			JComboBox comboBox_1 = new JComboBox(options_Gender);
			comboBox_1.setBounds(57, 87, 96, 21);
			panel_animal_details.add(comboBox_1);
													
		

		JPanel panel_adoption_details = new JPanel();
		panel_adoption_details.setBounds(237, 295, 346, 250);
		add(panel_adoption_details);
		panel_adoption_details.setBackground(new Color(47, 79, 79));
		panel_adoption_details.setLayout(null);
		panel_adoption_details.setVisible(false);
		

								
								
								JLabel lblNewLabel_8_1_1 = new JLabel("");
								lblNewLabel_8_1_1.setBounds(193, 22, 168, 159);
								panel_animal_details.add(lblNewLabel_8_1_1);
								lblNewLabel_8_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
								
								
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(123, 10, 492, 275);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
	   	table = new JTable();
	   	table.setForeground(new Color(255, 255, 255));
	   	scrollPane.setViewportView(table);
	   	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	   	table.getTableHeader().setBackground(new Color(70,130,180));
	   	table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
	   	
	   			table.setBorder(null);
	   			table.setBackground(new Color(112, 128, 144));
	   			table.addMouseListener(new MouseAdapter() {
	   			  	@Override
	   			  	public void mouseClicked(MouseEvent e) {
	   			  		int i= table.getSelectedRow();
	   			  		TableModel model = table.getModel();       
	   			  		lblNewLabel_8_1_1.setVisible(true);
	   			  		//this 6 lines below get the selected animal details.
	   			    	   textField_11.setText(model.getValueAt(i, 0).toString());
	   			    	   textField.setText(model.getValueAt(i, 1).toString());
	   				    comboBox.setSelectedItem(model.getValueAt(i, 2).toString());
	   				 comboBox_1.setSelectedItem(model.getValueAt(i, 3).toString());
	   				    textField_3.setText(model.getValueAt(i, 4).toString());
	   				    textField_4.setText(model.getValueAt(i, 5).toString());
	   				    
	   				    
	   			        int animel_Id=Integer.parseInt(textField_11.getText());
	   					AnimalFactory animalFctory = new AnimalFactory(); // create factory object
	   	     			Animal animal = animalFctory.createAnimal(animel_Id,textField.getText(), 
	   	     				comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(), 
	   	     					Integer.parseInt(textField_3.getText()), 
	   	     					Integer.parseInt(textField_4.getText()));  // create the dog or cat object.
	   	     		
	   				 ImageIcon newImage=serverTunnel.AnimalInTable(animal, fis, lblNewLabel_8_1_1.getHeight(), lblNewLabel_8_1_1.getWidth()); 
	   				 //this is the function that show the selected animal picture
	   			     lblNewLabel_8_1_1.setIcon(newImage);
	   				    
	   					 panel_animal_details.setVisible(true);
	   					 panel_adoption_details.setVisible(false);
	   			  	}
	   			});
		
	   			

		
	
				
						
						panel_animal_details.setBounds(133, 295, 470, 240);
						add(panel_animal_details);
						panel_animal_details.setForeground(new Color(255, 255, 255));
						panel_animal_details.setBackground(new Color(47, 79, 79));
						panel_animal_details.setLayout(null);
						panel_animal_details.setVisible(false);
						
				
									
	   	    
								JButton button = new JButton("Adopt");
								button.setBounds(371, 87, 85, 53);
								panel_animal_details.add(button);
								button.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										panel_animal_details.setVisible(false);
										panel_adoption_details.setVisible(true);
									}
								});
								button.setBackground(new Color(70, 130, 180));
								
								JButton btnUploadPicture = new JButton("Upload Picture");
								btnUploadPicture.setBounds(203, 187, 129, 21);
								panel_animal_details.add(btnUploadPicture);
								btnUploadPicture.addActionListener(new ActionListener() {
									
									@Override
									public void actionPerformed(ActionEvent e) {
   	    		JFileChooser file = new JFileChooser();
   	            file.setCurrentDirectory(new File(System.getProperty("user.home")));
   	            //filter the files
   	            FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
   	            file.addChoosableFileFilter(filter);
   	            int result = file.showSaveDialog(null);
   	             //if the user click on save in Jfilechooser
   	            if(result == JFileChooser.APPROVE_OPTION){
   	                File selectedFile = file.getSelectedFile();
   	                path = selectedFile.getAbsolutePath();
	     			try {
						 fis=new FileInputStream(selectedFile);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	     		
   	       		 
   	       	

   	            }
   	             //if the user click on save in Jfilechooser


   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    		
   	    	}				
									
								});
								btnUploadPicture.setBackground(new Color(70, 130, 180));
								
								
								
								
								
								textField_4 = new JTextField();
								textField_4.setBounds(57, 150, 96, 20);
								panel_animal_details.add(textField_4);
								textField_4.setColumns(10);
								
								JLabel label_4 = new JLabel("Hisun");
								label_4.setForeground(new Color(255, 255, 255));
								label_4.setBounds(10, 157, 49, 14);
								panel_animal_details.add(label_4);
								label_4.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel label_3 = new JLabel("Age");
								label_3.setForeground(new Color(255, 255, 255));
								label_3.setBounds(10, 126, 49, 14);
								panel_animal_details.add(label_3);
								label_3.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel label_2 = new JLabel("Gender");
								label_2.setForeground(new Color(255, 255, 255));
								label_2.setBounds(10, 96, 49, 14);
								panel_animal_details.add(label_2);
								label_2.setFont(new Font("David", Font.BOLD, 13));
								
								JLabel label_1 = new JLabel("Type");
								label_1.setForeground(new Color(255, 255, 255));
								label_1.setBounds(10, 10, 49, 14);
								panel_animal_details.add(label_1);
								label_1.setFont(new Font("David", Font.BOLD, 13));
								
								
								   	   
										
										JLabel label = new JLabel("Name");
										label.setForeground(new Color(255, 255, 255));
										label.setBounds(10, 61, 49, 14);
										panel_animal_details.add(label);
										label.setFont(new Font("David", Font.BOLD, 13));
										
		textField = new JTextField();
		textField.setBounds(57, 58, 96, 20);
		panel_animal_details.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(57, 120, 96, 20);
		panel_animal_details.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_11.getText().equals("") || textField.getText().equals("") || comboBox.getSelectedItem().toString().equals("") || comboBox_1.getSelectedItem().toString().equals("") || textField_3.getText().equals("")|| textField_4.getText().equals(""))
	        		{
	        		 JOptionPane.showMessageDialog(null, "Please Fill all the Fields.", "Details", JOptionPane.PLAIN_MESSAGE);
	        		}
	        		else
	        		{
	        			int animel_Id=Integer.parseInt(textField_11.getText());
	    	     		AnimalFactory animalFctory = new AnimalFactory(); // create factory object
	   	     			Animal newAnimal = animalFctory.createAnimal(animel_Id,textField.getText(), 
	   	     				comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(), 
	   	     					Integer.parseInt(textField_3.getText()), 
	   	     					Integer.parseInt(textField_4.getText()));  // create the dog or cat object.
	   	     		
	        			serverTunnel.UpdateAnimalInDB(newAnimal,fis);
	        			
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
	        		
	    
			}
		});
		btnNewButton.setBounds(57, 190, 85, 40);
		panel_animal_details.add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(new Color(255, 255, 255));
		lblId.setFont(new Font("David", Font.BOLD, 13));
		lblId.setBounds(10, 37, 49, 14);
		panel_animal_details.add(lblId);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(57, 34, 96, 20);
		panel_animal_details.add(textField_11);
		
	  
							
																		
																		JButton button_1 = new JButton("Submit");
																		button_1.setBackground(new Color(70, 130, 180));
																		button_1.addActionListener(new ActionListener() {
																			public void actionPerformed(ActionEvent e) {
			
      	         	
      	        	AnimalFactory animalFctory = new AnimalFactory(); // create factory object
	     			Animal a = animalFctory.createAnimal(Integer.parseInt(textField_11.getText()),textField.getText(), 
	     					comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(), 
	     					Integer.parseInt(textField_3.getText()), 
	     					Integer.parseInt(textField_4.getText()));  // create the dog or cat object.
	     		      Adopter b=new Adopter(Integer.parseInt(textField_10.getText()), textField_9.getText(),
	     		    		  textField_8.getText(),Integer.parseInt(textField_12.getText()),
	     		    		  textField_7.getText(),Integer.parseInt(textField_6.getText()),textField_5.getText());

	                serverTunnel.case_Insertion(next_case_id,a,b); // make an adoption
	                
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
																		});
																		button_1.setBounds(245, 201, 91, 39);
																		panel_adoption_details.add(button_1);
																		
																										
																										
																										textField_5 = new JTextField();
																										textField_5.setBounds(111, 198, 125, 19);
																										panel_adoption_details.add(textField_5);
																										textField_5.setColumns(10);
																										textField_5.setBackground(Color.WHITE);
																										
																										JLabel label_10 = new JLabel("Address:");
																										label_10.setBounds(20, 179, 116, 50);
																										panel_adoption_details.add(label_10);
																										label_10.setForeground(new Color(255, 255, 255));
																										label_10.setFont(new Font("David", Font.PLAIN, 13));
																										label_10.setBackground(Color.YELLOW);
																										
																										JLabel label_11 = new JLabel("Phone Number:");
																										label_11.setBounds(20, 150, 131, 50);
																										panel_adoption_details.add(label_11);
																										label_11.setForeground(new Color(255, 255, 255));
																										label_11.setFont(new Font("David", Font.PLAIN, 13));
																										label_11.setBackground(Color.YELLOW);
																										
																										JLabel lblOccupation = new JLabel("Occupation:");
																										lblOccupation.setBounds(20, 119, 116, 50);
																										panel_adoption_details.add(lblOccupation);
																										lblOccupation.setForeground(new Color(255, 255, 255));
																										lblOccupation.setFont(new Font("David", Font.PLAIN, 13));
																										lblOccupation.setBackground(Color.YELLOW);
																										
																										JLabel label_8 = new JLabel("Gender");
																										label_8.setBounds(20, 65, 116, 50);
																										panel_adoption_details.add(label_8);
																										label_8.setForeground(new Color(255, 255, 255));
																										label_8.setFont(new Font("David", Font.PLAIN, 13));
																										label_8.setBackground(Color.YELLOW);
																										
																										JLabel label_7 = new JLabel("Full Name:");
																										label_7.setBounds(20, 36, 105, 50);
																										panel_adoption_details.add(label_7);
																										label_7.setForeground(new Color(255, 255, 255));
																										label_7.setFont(new Font("David", Font.PLAIN, 13));
																										label_7.setBackground(Color.YELLOW);
																										
																										JLabel label_6 = new JLabel("ID:");
																										label_6.setBounds(20, 10, 116, 50);
																										panel_adoption_details.add(label_6);
																										label_6.setForeground(new Color(255, 255, 255));
																										label_6.setFont(new Font("David", Font.PLAIN, 13));
																										label_6.setBackground(Color.YELLOW);
																										
																										textField_9 = new JTextField();
																										textField_9.setBounds(111, 55, 125, 19);
																										panel_adoption_details.add(textField_9);
																										textField_9.setColumns(10);
																										textField_9.setBackground(Color.WHITE);
																										
																										textField_8 = new JTextField();
																										textField_8.setBounds(91, 84, 145, 19);
																										panel_adoption_details.add(textField_8);
																										textField_8.setColumns(10);
																										textField_8.setBackground(Color.WHITE);
																										
																										textField_7 = new JTextField();
																										textField_7.setBounds(111, 138, 125, 19);
																										panel_adoption_details.add(textField_7);
																										textField_7.setColumns(10);
																										textField_7.setBackground(Color.WHITE);
																										
																										textField_6 = new JTextField();
																										textField_6.setBounds(140, 169, 96, 19);
																										panel_adoption_details.add(textField_6);
																										textField_6.setColumns(10);
																										textField_6.setBackground(Color.WHITE);
																										
																										JLabel label_5 = new JLabel("Fill the Adopter's Details");
																										label_5.setBounds(20, -12, 200, 50);
																										panel_adoption_details.add(label_5);
																										label_5.setForeground(new Color(255, 255, 255));
																										label_5.setFont(new Font("David", Font.PLAIN, 18));
																										label_5.setBackground(Color.YELLOW);
																										
																										textField_10 = new JTextField();
																										textField_10.setColumns(10);
																										textField_10.setBackground(Color.WHITE);
																										textField_10.setBounds(90, 25, 145, 19);
																										panel_adoption_details.add(textField_10);
																										
																										textField_12 = new JTextField();
																										textField_12.setColumns(10);
																										textField_12.setBackground(Color.WHITE);
																										textField_12.setBounds(111, 113, 125, 19);
																										panel_adoption_details.add(textField_12);
																										
																										JLabel lblAge = new JLabel("Age");
																										lblAge.setForeground(Color.WHITE);
																										lblAge.setFont(new Font("David", Font.PLAIN, 13));
																										lblAge.setBackground(Color.YELLOW);
																										lblAge.setBounds(20, 96, 116, 50);
																										panel_adoption_details.add(lblAge);
		
		
		lblNewLabel_8_1_1.setVisible(false);


DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "ID";
columnsName1[1] = "Name";
columnsName1[2] = "Type";
columnsName1[3] = "Gender";
columnsName1[4] = "Age";
columnsName1[5] = "Hisun";

model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[6];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}
ArrayList<Animal> a=serverTunnel.getAnimals();

for(int i = 0; i < a.size(); i++){
   
	     rowData[0] = a.get(i).getId();
	     rowData[1] = a.get(i).getName();
	     rowData[2] = a.get(i).getType();
	     rowData[3] = a.get(i).getGender();
	      rowData[4] = a.get(i).getAge();
	      rowData[5] = a.get(i).getHisun();
       
       model1.addRow(rowData);
	    table.setModel(model1);
      
}

	}	

}
	
