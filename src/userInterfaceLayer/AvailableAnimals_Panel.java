package userInterfaceLayer;

import javax.swing.ButtonGroup;
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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import BussinessLayer.*;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;



public class AvailableAnimals_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	public static String path;
	public  int next_case_id;
	public serverTunnel tunnel=null;
   	int flag2=0;
   	private int injeqtion;


	private JTextField textField_AnimalName;
	private JTextField textField_AnimalAge;
	private JTextField textField_AdopterAddress;
	private JTextField textField_AdopterPhone;
	private JTextField textField_AdopterOccupation;
	private JTextField textField_AdopterGender;
	private JTextField textField_AdopterName;
	private JTextField textField_10;
	private JTextField textField_AnimalID;
	private JTextField textField_AdopterAge;
	private JTextField textField_AdoptionMail;
	/**
	 * Create the panel.
	 */
	public AvailableAnimals_Panel() {
		  System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));
		setBounds(219, 0, 758, 545);

		setLayout(null);
		setVisible(true);
			
						
						 // Panel for adopter Deceleration & settings
	JPanel panel_adoption_details = new JPanel();
	panel_adoption_details.setBounds(187, 268, 346, 277);
	add(panel_adoption_details);
	panel_adoption_details.setBackground(new Color(47, 79, 79));
	panel_adoption_details.setLayout(null);
	panel_adoption_details.setVisible(false);
				
	
    textField_AdopterAddress = new JTextField();
	 textField_AdopterAddress.setBounds(111, 198, 125, 19);
	 panel_adoption_details.add(textField_AdopterAddress);
	textField_AdopterAddress.setColumns(10);
	textField_AdopterAddress.setBackground(Color.WHITE);
						    
	JLabel Label_AdopterAddress = new JLabel("Address:");
	Label_AdopterAddress.setBounds(20, 179, 116, 50);
	panel_adoption_details.add(Label_AdopterAddress);
	Label_AdopterAddress.setForeground(new Color(255, 255, 255));
	Label_AdopterAddress.setFont(new Font("David", Font.PLAIN, 13));
	Label_AdopterAddress.setBackground(Color.YELLOW);
						    
	 JLabel Label_AdopterPhone = new JLabel("Phone Number:");
	Label_AdopterPhone.setBounds(20, 150, 131, 50);
	panel_adoption_details.add(Label_AdopterPhone);
	Label_AdopterPhone.setForeground(new Color(255, 255, 255));
	Label_AdopterPhone.setFont(new Font("David", Font.PLAIN, 13));
	Label_AdopterPhone.setBackground(Color.YELLOW);
						    
	JLabel Label_AdopterAge = new JLabel("Occupation:");
	Label_AdopterAge.setBounds(20, 119, 116, 50);
	panel_adoption_details.add(Label_AdopterAge);
	 Label_AdopterAge.setForeground(new Color(255, 255, 255));
	 Label_AdopterAge.setFont(new Font("David", Font.PLAIN, 13));
	Label_AdopterAge.setBackground(Color.YELLOW);
						    
	 JLabel Label_AdopterGender = new JLabel("Gender");
	Label_AdopterGender.setBounds(20, 65, 116, 50);
						    panel_adoption_details.add(Label_AdopterGender);
						    Label_AdopterGender.setForeground(new Color(255, 255, 255));
	Label_AdopterGender.setFont(new Font("David", Font.PLAIN, 13));
						    Label_AdopterGender.setBackground(Color.YELLOW);
						    
	 JLabel Label_AdopterName = new JLabel("Full Name:");
	 Label_AdopterName.setBounds(20, 36, 105, 50);
	 panel_adoption_details.add(Label_AdopterName);
	 Label_AdopterName.setForeground(new Color(255, 255, 255));
						    Label_AdopterName.setFont(new Font("David", Font.PLAIN, 13));
	 Label_AdopterName.setBackground(Color.YELLOW);
						    
						    JLabel Label_AdopterID = new JLabel("ID:");
	 Label_AdopterID.setBounds(20, 10, 116, 50);
	 panel_adoption_details.add(Label_AdopterID);
	   Label_AdopterID.setForeground(new Color(255, 255, 255));
	Label_AdopterID.setFont(new Font("David", Font.PLAIN, 13));
	Label_AdopterID.setBackground(Color.YELLOW);
						    
	textField_AdopterName = new JTextField();
	textField_AdopterName.setBounds(111, 55, 125, 19);
panel_adoption_details.add(textField_AdopterName);
	textField_AdopterName.setColumns(10);
	textField_AdopterName.setBackground(Color.WHITE);
						    
	textField_AdopterGender = new JTextField();
	textField_AdopterGender.setBounds(91, 84, 145, 19);
	panel_adoption_details.add(textField_AdopterGender);
	textField_AdopterGender.setColumns(10);
	textField_AdopterGender.setBackground(Color.WHITE);
						    
	textField_AdopterOccupation = new JTextField();
	 textField_AdopterOccupation.setBounds(111, 138, 125, 19);
	 panel_adoption_details.add(textField_AdopterOccupation);
	textField_AdopterOccupation.setColumns(10);
	textField_AdopterOccupation.setBackground(Color.WHITE);
						    
	textField_AdopterPhone = new JTextField();
	textField_AdopterPhone.setBounds(140, 169, 96, 19);
	 panel_adoption_details.add(textField_AdopterPhone);
	textField_AdopterPhone.setColumns(10);
	textField_AdopterPhone.setBackground(Color.WHITE);
						    
	JLabel label_AdopterID = new JLabel("Fill the Adopter's Details");
	 label_AdopterID.setBounds(20, -12, 200, 50);
	panel_adoption_details.add(label_AdopterID);
	label_AdopterID.setForeground(new Color(255, 255, 255));
	label_AdopterID.setFont(new Font("David", Font.PLAIN, 18));
	 label_AdopterID.setBackground(Color.YELLOW);
						    
	textField_10 = new JTextField();
	textField_10.setColumns(10);
	textField_10.setBackground(Color.WHITE);
	textField_10.setBounds(90, 25, 145, 19);
	panel_adoption_details.add(textField_10);
						    
		  textField_AdopterAge = new JTextField();
		   textField_AdopterAge.setColumns(10);
		 textField_AdopterAge.setBackground(Color.WHITE);
	  textField_AdopterAge.setBounds(111, 113, 125, 19);
	  panel_adoption_details.add(textField_AdopterAge);
						    
	JLabel lblAge = new JLabel("Age");
	 lblAge.setForeground(Color.WHITE);
	lblAge.setFont(new Font("David", Font.PLAIN, 13));
	lblAge.setBackground(Color.YELLOW);
	lblAge.setBounds(20, 96, 116, 50);
	panel_adoption_details.add(lblAge);
						    
	 textField_AdoptionMail = new JTextField();
	textField_AdoptionMail.setColumns(10);
	textField_AdoptionMail.setBackground(Color.WHITE);
	textField_AdoptionMail.setBounds(111, 225, 125, 19);
	panel_adoption_details.add(textField_AdoptionMail);
	 JLabel Label_Adoption = new JLabel("Mail:");
	Label_Adoption.setForeground(Color.WHITE);
	Label_Adoption.setFont(new Font("David", Font.PLAIN, 13));
	 Label_Adoption.setBackground(Color.YELLOW);
	Label_Adoption.setBounds(30, 210, 116, 50);
	panel_adoption_details.add(Label_Adoption);
						    
						    
						    
						    
		 			

			JPanel panel = new JPanel();
			panel.setBackground(new Color(0, 139, 139));
			panel.setBounds(123, 63, 492, 203);
			add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			JScrollPane scrollPane = new JScrollPane();
			panel.add(scrollPane, BorderLayout.CENTER);
		 			
		 			
		 			
		 			
		 		    //Group the radio buttons.
				    ButtonGroup group = new ButtonGroup();
				    injeqtion=2;
				    
				    			
				    

					 // comboBox_AnimalType Deceleration & settings
				       String options[]={"DOG","CAT"};        
						
					 // comboBox_AnimalGender Deceleration & settings
				     String options_Gender[]={"Male","Female"};        
		 	JLabel lblAvailableAnimals = new JLabel("Available Animals");
		 	lblAvailableAnimals.setForeground(Color.WHITE);
		 	lblAvailableAnimals.setFont(new Font("David", Font.BOLD, 37));
		 	lblAvailableAnimals.setBounds(205, 16, 296, 37);
		 	add(lblAvailableAnimals);
		 		

		 			
		 			JLabel label_instruction = new JLabel("Select an Animal from our Association for Details");
		 			label_instruction.setForeground(new Color(255, 255, 255));
		 			label_instruction.setBounds(74, 360, 684, 37);
		 			add(label_instruction);
		 			label_instruction.setFont(new Font("David", Font.BOLD, 30));
		 			
		 		   			
													
									
	
		
		    

			// Panel for animal details Deceleration & settings
					JPanel panel_animal_details = new JPanel();
					panel_animal_details.setBounds(123, 285, 529, 260);
					add(panel_animal_details);
					panel_animal_details.setForeground(new Color(255, 255, 255));
					panel_animal_details.setBackground(new Color(47, 79, 79));
					panel_animal_details.setLayout(null);
					panel_animal_details.setVisible(false);
					JComboBox comboBox_AnimalType = new JComboBox(options);
					comboBox_AnimalType.setBounds(57, 6, 96, 21);
					panel_animal_details.add(comboBox_AnimalType);
					JComboBox comboBox_AnimalGender = new JComboBox(options_Gender);
					comboBox_AnimalGender.setBounds(57, 87, 96, 21);
					panel_animal_details.add(comboBox_AnimalGender);
					JRadioButton rdbtnYes = new JRadioButton("YES");
					rdbtnYes.setForeground(new Color(255, 255, 255));
					rdbtnYes.setBackground(new Color(47, 79, 79));
					rdbtnYes.setBounds(67, 146, 103, 21);
					panel_animal_details.add(rdbtnYes);
					group.add(rdbtnYes);
					
					JRadioButton rdbtnNo = new JRadioButton("NO");
					rdbtnNo.setForeground(new Color(255, 255, 255));
					rdbtnNo.setBackground(new Color(47, 79, 79));
					rdbtnNo.setBounds(67, 169, 103, 21);
					panel_animal_details.add(rdbtnNo);
					rdbtnNo.setSelected(true);
					group.add(rdbtnNo);
					
		 			// Picture label Deceleration & settings
		 			JLabel Label_Picture = new JLabel("");
		 			Label_Picture.setBounds(193, 22, 168, 159);
		 			panel_animal_details.add(Label_Picture);
		 			Label_Picture.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		 			
		 			Label_Picture.setVisible(false);
		 			 
		 			 										
		 	// adopt Button Deceleration & settings
		 					 	
		 	JButton btn_Adopt = new JButton("Adopt");
		 	btn_Adopt.setBounds(371, 87, 85, 53);
		 	panel_animal_details.add(btn_Adopt);
		 	btn_Adopt.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	panel_animal_details.setVisible(false);
		 	panel_adoption_details.setVisible(true);
		 					 					}
		 					 					});
		 	btn_Adopt.setBackground(new Color(70, 130, 180));
		 					 					
				
				
	   			// PictureUpload Button Deceleration & settings
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
   	            	flag2=1;
   	                File selectedFile = file.getSelectedFile();
   	                path = selectedFile.getAbsolutePath();	
   	                ImageIcon icon = new ImageIcon(path);
   	                Image dabImage=icon.getImage();
   	                Image newImage=dabImage.getScaledInstance(Label_Picture.getWidth(),Label_Picture.getHeight(),1);
   	                ImageIcon newImage1 = new ImageIcon(newImage);
   	                Label_Picture.setIcon(newImage1);
   	           }
   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    		
   	    	}				
									
								});
				btnUploadPicture.setBackground(new Color(70, 130, 180));
				
		
	   	// AnimalInjeqtion Text field Deceleration & settings
		JLabel lblInjeqtion = new JLabel("Injection");
		lblInjeqtion.setForeground(new Color(255, 255, 255));
		lblInjeqtion.setBounds(10, 160, 66, 14);
		panel_animal_details.add(lblInjeqtion);
		lblInjeqtion.setFont(new Font("David", Font.BOLD, 13));
		
	   	// AnimalAge Text field Deceleration & settings
		JLabel label_AnimalAge = new JLabel("Age");
		label_AnimalAge.setForeground(new Color(255, 255, 255));
		label_AnimalAge.setBounds(10, 126, 49, 14);
		panel_animal_details.add(label_AnimalAge);
		label_AnimalAge.setFont(new Font("David", Font.BOLD, 13));
		
	   	// AnimalGender label Deceleration & settings
		JLabel label_AnimalGender = new JLabel("Gender");
		label_AnimalGender.setForeground(new Color(255, 255, 255));
		label_AnimalGender.setBounds(10, 96, 49, 14);
		panel_animal_details.add(label_AnimalGender);
		label_AnimalGender.setFont(new Font("David", Font.BOLD, 13));
		
	   	// AnimalType label Deceleration & settings
		JLabel Label_AnimalType = new JLabel("Type");
		Label_AnimalType.setForeground(new Color(255, 255, 255));
		Label_AnimalType.setBounds(10, 10, 49, 14);
		panel_animal_details.add(Label_AnimalType);
		Label_AnimalType.setFont(new Font("David", Font.BOLD, 13));
		
	   	// AnimalName label Deceleration & settings		
		JLabel Label_AnimalName = new JLabel("Name");
		Label_AnimalName.setForeground(new Color(255, 255, 255));
		Label_AnimalName.setBounds(10, 61, 49, 14);
		panel_animal_details.add(Label_AnimalName);
		Label_AnimalName.setFont(new Font("David", Font.BOLD, 13));
		
	   	// AnimalName Text field Deceleration & settings		
		textField_AnimalName = new JTextField();
		textField_AnimalName.setBounds(57, 58, 96, 20);
		panel_animal_details.add(textField_AnimalName);
		textField_AnimalName.setColumns(10);
		
	   	// AnimalAge Text field Deceleration & settings		
		textField_AnimalAge = new JTextField();
		textField_AnimalAge.setBounds(57, 120, 96, 20);
		panel_animal_details.add(textField_AnimalAge);
		textField_AnimalAge.setColumns(10);
		
		
		
		
		
		
		
	   	// SubmitAdopter Button Deceleration & settings												
JButton btn_SunbmitAdopter = new JButton("Submit");
btn_SunbmitAdopter.setBackground(new Color(70, 130, 180));
btn_SunbmitAdopter.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	if(textField_10.getText().equals("") ||
			textField_AdopterName.getText().equals("") || 
			textField_AdopterGender.getText().equals("") || 
			textField_AdopterAge.getText().equals("") || 
			textField_AdopterOccupation.getText().equals("") || 
			textField_AdopterPhone.getText().equals("") || 
			textField_AdopterAddress.getText().equals("") || textField_AdoptionMail.getText().equals("")
			)
		{
		 JOptionPane.showMessageDialog(null, "You must fill all the fields", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
		}
	else if((!textField_10.getText().chars().allMatch(Character::isDigit)) ||
			Integer.parseInt(textField_10.getText())<0 ||
			!textField_AdopterAge.getText().chars().allMatch(Character::isDigit) ||
			Integer.parseInt(textField_AdopterAge.getText())<0 ||
			!textField_AdopterPhone.getText().chars().allMatch(Character::isDigit) ||
			Integer.parseInt(textField_AdopterPhone.getText())<0)
			JOptionPane.showMessageDialog(null, "ID,Age,Phone must not be equal to zero and above.", "Details", JOptionPane.PLAIN_MESSAGE);


	else
	{
      	         	AnimalFactory animalFctory = new AnimalFactory(); // create factory object
	     			Animal a = animalFctory.createAnimal(Integer.parseInt(textField_AnimalID.getText()),textField_AnimalName.getText(), 
	     					comboBox_AnimalType.getSelectedItem().toString(), comboBox_AnimalGender.getSelectedItem().toString(), 
	     					Integer.parseInt(textField_AnimalAge.getText()), 
	     					injeqtion);  // create the dog or cat object.
	     		    Adopter b=new Adopter(Integer.parseInt(textField_10.getText()), textField_AdopterName.getText(),
	     		    		  textField_AdopterGender.getText(),Integer.parseInt(textField_AdopterAge.getText()),
	     		    		  textField_AdopterOccupation.getText(),Integer.parseInt(textField_AdopterPhone.getText()),textField_AdopterAddress.getText(),textField_AdoptionMail.getText());
	   	     			try {
					tunnel=serverTunnel.getInstance();
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
	   	     			if(a.getStatus()==true)
	   	     				tunnel.case_Insertion(next_case_id,a,b); // make an adoption
	   	     			else  JOptionPane.showMessageDialog(null, "This Animal is not available.", "Details", JOptionPane.PLAIN_MESSAGE);

	                
      	         	EventQueue.invokeLater(new Runnable() { // open new window to see the changes
      	      		public void run() {
      	      			try {
					MainWindow.closeWindow();
					MainWindow window =new MainWindow(MainWindow.user);
      	      				window.frame.setVisible(true);
      	      			} catch (Exception e) {
      	      				e.printStackTrace();
      	      			}
      	      		}
      	      	
      	      	
      	      	});
      	         	
		}
}
		});
btn_SunbmitAdopter.setBounds(245, 201, 91, 39);
panel_adoption_details.add(btn_SunbmitAdopter);

	   	// UpdateAnimal Button Deceleration & settings		
		JButton btn_UpdateAnimal = new JButton("Update");
		btn_UpdateAnimal.setBackground(new Color(70, 130, 180));
		btn_UpdateAnimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(
						textField_AnimalID.getText().equals("") || 
						textField_AnimalName.getText().equals("") ||
						comboBox_AnimalType.getSelectedItem().toString().equals("") ||
						comboBox_AnimalGender.getSelectedItem().toString().equals("") ||
						textField_AnimalAge.getText().equals("")|| injeqtion!=2)
	        		{
	        		 JOptionPane.showMessageDialog(null, "Please Fill all the Fields.", "Details", JOptionPane.PLAIN_MESSAGE);
	        		}
	        		else if(!textField_AnimalAge.getText().chars().allMatch(Character::isDigit) ||
							Integer.parseInt(textField_AnimalAge.getText())<0 )
	        				JOptionPane.showMessageDialog(null, "Age\\ID must not be a negative number.", "Details", JOptionPane.PLAIN_MESSAGE);

	        	
	        		else
	        		{
	        			
	        			if(rdbtnYes.isSelected()){
	    			    	injeqtion=1;
	    		        }
	    		        else if(rdbtnNo.isSelected()){
	    		        	injeqtion=0;
	    		        }	  	    
	        			int animel_Id=Integer.parseInt(textField_AnimalID.getText());
	    	     		AnimalFactory animalFctory = new AnimalFactory(); // create factory object
	   	     			Animal newAnimal = animalFctory.createAnimal(animel_Id,textField_AnimalName.getText(), 
	   	     				comboBox_AnimalType.getSelectedItem().toString(), comboBox_AnimalGender.getSelectedItem().toString(), 
	   	     					Integer.parseInt(textField_AnimalAge.getText()), 
	   	     					injeqtion);  // create the dog or cat object.
	   	     			try {
							tunnel=serverTunnel.getInstance();
						} catch (SQLException e1) {
						
							e1.printStackTrace();
						}
	   	     			if(flag2==0)
	   	     			{
	   	     				
		   	     				tunnel.UpdateAnimalInDB(newAnimal);

	   	     			}
	   	     			else	
	   	     			{
	   	     				tunnel.UpdateAnimalInDB(newAnimal,path);

	   	     				
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
		btn_UpdateAnimal.setBounds(57, 196, 85, 34);
		panel_animal_details.add(btn_UpdateAnimal);
		
		
	   	// AnimalID label Deceleration & settings		
		JLabel Label_AnimalID = new JLabel("ID");
		Label_AnimalID.setForeground(new Color(255, 255, 255));
		Label_AnimalID.setFont(new Font("David", Font.BOLD, 13));
		Label_AnimalID.setBounds(10, 37, 49, 14);
		panel_animal_details.add(Label_AnimalID);
		
	   	// AnimalID text field Deceleration & settings		
		textField_AnimalID = new JTextField();
		textField_AnimalID.setColumns(10);
		textField_AnimalID.setBounds(57, 34, 96, 20);
		panel_animal_details.add(textField_AnimalID);
																		
																										



		// Tabel for animals Deceleration & settings
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
	   			  		Label_Picture.setVisible(true);
	   			  		label_instruction.setVisible(false);
	   			  	
	   			    	textField_AnimalID.setText(model.getValueAt(i, 0).toString());
	   			    	textField_AnimalName.setText(model.getValueAt(i, 1).toString());
	   				    comboBox_AnimalType.setSelectedItem(model.getValueAt(i, 2).toString());
	   				    comboBox_AnimalGender.setSelectedItem(model.getValueAt(i, 3).toString());
	   				    textField_AnimalAge.setText(model.getValueAt(i, 4).toString());
	   				  if(model.getValueAt(i, 5).toString().equals("NO"))
	   					rdbtnNo.setSelected(true);
	   				  else	rdbtnYes.setSelected(true);
	   					  

	   				    
	   				    
	   			        int animel_Id=Integer.parseInt(textField_AnimalID.getText());
	   					AnimalFactory animalFctory = new AnimalFactory(); // create factory object
			Animal animal = animalFctory.createAnimal(animel_Id,textField_AnimalName.getText(), 
				comboBox_AnimalType.getSelectedItem().toString(), comboBox_AnimalGender.getSelectedItem().toString(), 
					Integer.parseInt(textField_AnimalAge.getText()), 
					injeqtion);  // create the dog or cat object.

			 //this is the function that show the selected animal picture
			try {
			tunnel=serverTunnel.getInstance();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
			ImageIcon newImage=tunnel.ImageByAnimal(animal, Label_Picture.getHeight(), Label_Picture.getWidth()); 
			Label_Picture.setIcon(newImage); 
	   					 panel_animal_details.setVisible(true);
	   					 panel_adoption_details.setVisible(false);
	   			  	}
	   			});
DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "ID";
columnsName1[1] = "Name";
columnsName1[2] = "Type";
columnsName1[3] = "Gender";
columnsName1[4] = "Age";
columnsName1[5] = "Injection";


model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[6];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}
	try {
		tunnel=serverTunnel.getInstance();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
	}
ArrayList<Animal> a=tunnel.getAnimals();

for(int i = 0; i < a.size(); i++){
   
	     rowData[0] = a.get(i).getId();
	     rowData[1] = a.get(i).getName();
	     rowData[2] = a.get(i).getType();
	     rowData[3] = a.get(i).getGender();
	      rowData[4] = a.get(i).getAge();
	      if(a.get(i).getHisun()==1)
	    	  rowData[5] = "Yes";
	      else	rowData[5] = "NO";

       
       model1.addRow(rowData);
	    table.setModel(model1);
      
}

	}	
}
	
