package userInterfaceLayer;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import BussinessLayer.Animal;
import BussinessLayer.AnimalFactory;
import BussinessLayer.serverTunnel;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class AnimalInsertion_Panel extends JPanel {
	/**
	 * 
	 */
    private int injeqtion;
	private static final long serialVersionUID = 1L;
	public static String path;
	public File selectedFile;
	public static int next_id;
	private JTextField textField_Name;
	private JTextField textField_Age;
	private Boolean File_Choosed=false;


	/**
	 * Create the panel.
	 */
	public AnimalInsertion_Panel() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
		// comboBox_Type Deceleration & settings
	    String options_guide[]={"YES","NO"};
	    
		// comboBox_Gender Deceleration & settings
		  String options_gender[]={"Female","Male"};        
		JComboBox comboBox_Gender = new JComboBox(options_gender);
	    comboBox_Gender.setBounds(256, 232, 96, 21);
	    add(comboBox_Gender);

		// comboBox_Type Deceleration & settings
		  String options[]={"DOG","CAT"};        
		    JComboBox comboBox_Type = new JComboBox(options);
		    comboBox_Type.setBounds(256, 155, 96, 21);
		    add(comboBox_Type);
		  
		   
		    
		
		 // Picture label Deceleration & settings
			JLabel Label_Picture = new JLabel("");
			Label_Picture.setBounds(398, 151, 268, 192);
			Label_Picture.setBorder(new LineBorder(new Color(0, 0, 0), 1));
			add(Label_Picture);
			setVisible(false);
			
			// Name label Deceleration & settings
		JLabel Label_Name = new JLabel("Name");
		Label_Name.setForeground(new Color(255, 255, 255));
		Label_Name.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_Name.setBounds(179, 194, 59, 17);
		add(Label_Name);
		
		// Type label Deceleration & settings
		JLabel Label_Type = new JLabel("Type");
		Label_Type.setForeground(new Color(255, 255, 255));
		Label_Type.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_Type.setBounds(179, 151, 59, 26);
		add(Label_Type);
		
		// Gender label Deceleration & settings
		JLabel Label_Gender = new JLabel("Gender");
		Label_Gender.setForeground(new Color(255, 255, 255));
		Label_Gender.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_Gender.setBounds(171, 221, 78, 34);
		add(Label_Gender);
		
		// Age label Deceleration & settings
		JLabel Label_Age = new JLabel("Age");
		Label_Age.setForeground(new Color(255, 255, 255));
		Label_Age.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_Age.setBounds(191, 276, 59, 26);
		add(Label_Age);
		
		// Injeqtion label Deceleration & settings
		JLabel lblInjeqtion = new JLabel("Injection");
		lblInjeqtion.setForeground(new Color(255, 255, 255));
		lblInjeqtion.setFont(new Font("Dialog", Font.BOLD, 20));
		lblInjeqtion.setBounds(154, 322, 96, 34);
		add(lblInjeqtion);
	    
		// Naem text field Deceleration & settings
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBounds(256, 191, 96, 20);
		add(textField_Name);
		
		
		// Age text field Deceleration & settings
		textField_Age = new JTextField();
		textField_Age.setColumns(10);
		textField_Age.setBounds(256, 281, 96, 20);
		add(textField_Age);
		
		
		
		  JRadioButton rdbtnNewRadioButton = new JRadioButton("YES");
		  rdbtnNewRadioButton.setBackground(new Color(47, 79, 79));
		  rdbtnNewRadioButton.setForeground(new Color(255, 255, 255));
		    rdbtnNewRadioButton.setBounds(275, 322, 103, 21);
		    add(rdbtnNewRadioButton);
		    
		    JRadioButton rdbtnNo = new JRadioButton("NO");
		    rdbtnNo.setBackground(new Color(47, 79, 79));
		    rdbtnNo.setForeground(new Color(255, 255, 255));
		    rdbtnNo.setBounds(275, 345, 103, 21);
		    add(rdbtnNo);
		    rdbtnNo.setSelected(true);


		       //Group the radio buttons.
		    ButtonGroup group = new ButtonGroup();
		    group.add(rdbtnNewRadioButton);
		    group.add(rdbtnNo);
		    
		    

		    
		
		// UploadPicture Button  Deceleration & settings
		JButton btn_UploadPicture = new JButton("Upload Picture");
		btn_UploadPicture.addActionListener(new ActionListener() {
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
   	            	 File_Choosed=true;
   	                 selectedFile = file.getSelectedFile();
   	                path = selectedFile.getAbsolutePath();
   	       		ImageIcon icon = new ImageIcon(path);
   	       		Image dabImage=icon.getImage();
   	       		Image newImage=dabImage.getScaledInstance(Label_Picture.getWidth(),Label_Picture.getHeight(),1);
          		ImageIcon newImage1 = new ImageIcon(newImage);
   	       		Label_Picture.setIcon(newImage1);
   				Label_Picture.setBorder(new LineBorder(new Color(0, 0, 0), 2));

   				
   			
   				
   	  
   	            }
   	             //if the user click on save in Jfilechooser


   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    	}				
			
		});
		btn_UploadPicture.setBackground(new Color(70, 130, 180));
		btn_UploadPicture.setBounds(305, 430, 120, 46);
		add(btn_UploadPicture);
		
		
		
		
		// Save Button  Deceleration & settings
		JButton btn_Save = new JButton("Save");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_Name.getText().equals("") ||
						comboBox_Type.getSelectedItem().toString().equals("") || 
						comboBox_Gender.getSelectedItem().toString().equals("") ||
						textField_Age.getText().equals("") ||File_Choosed==false)
   	     		{
   	     		 JOptionPane.showMessageDialog(null, "You must fill all the fields", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	     		}
				else if((!textField_Age.getText().chars().allMatch(Character::isDigit)) ||
						Integer.parseInt(textField_Age.getText())<0)
        				JOptionPane.showMessageDialog(null, "Age must not be equal to zero and above.", "Details", JOptionPane.PLAIN_MESSAGE);

        	
        		else
        		{
   	     		
   	     		if(rdbtnNewRadioButton.isSelected()){
			    	injeqtion=1;
		        }
		        else if(rdbtnNo.isSelected()){
		        	injeqtion=0;
		        }	  	     
   	     			AnimalFactory animalFctory = new AnimalFactory(); // create factory object
   	     			Animal a = animalFctory.createAnimal(++next_id,textField_Name.getText(), 
   	     				comboBox_Type.getSelectedItem().toString(), comboBox_Gender.getSelectedItem().toString(), 
   	     					Integer.parseInt(textField_Age.getText()), 
   	     					injeqtion);  // create the dog or cat object.
   	     		serverTunnel tunnel=null;
   	     			try {
   	     				
						 tunnel=serverTunnel.getInstance();
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
   	     			tunnel.AnimalToDB(a,selectedFile);
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

	   	     			serverTunnel.NotifyWatingListContact(a);
   	     		}
   	     		
   	     		 
   	     		}
   	     		
   	     	
   	     	
			
		});
		btn_Save.setBackground(new Color(70, 130, 180));
		btn_Save.setBounds(179, 430, 96, 46);
		add(btn_Save);
		
		
		// Main label Deceleration & settings
		JLabel Label_Main = new JLabel("Animal's Insertion");
		Label_Main.setForeground(Color.WHITE);
		Label_Main.setFont(new Font("Dialog", Font.BOLD, 32));
		Label_Main.setBounds(232, 10, 319, 64);
		add(Label_Main);
		
		
		
		
		 Image image2=new ImageIcon(getClass().getResource("/pics/general3.jpg")).getImage().getScaledInstance(Label_Picture.getWidth(),Label_Picture.getHeight(), Image.SCALE_SMOOTH);	
	    ImageIcon newImage3 = new ImageIcon(image2);
	    Label_Picture.setIcon(newImage3);
	    
		 
	
	    
	      
	    
	}
}

