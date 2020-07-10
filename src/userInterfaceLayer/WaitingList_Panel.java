package userInterfaceLayer;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import BussinessLayer.PotentialAdopter;
import BussinessLayer.serverTunnel;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class WaitingList_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField_Name;
	private JTextField textField_ID;
	private JTextField textField_Phone;
	private JTextField textField_Mail;


	/**
	 * Create the panel.
	 */
	public WaitingList_Panel() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
			
			
		JPanel panel_Main = new JPanel();
		panel_Main.setBackground(new Color(47, 79, 79));
		panel_Main.setBounds(10, 111, 721, 394);
		add(panel_Main);
		panel_Main.setLayout(null);
		
		// FullName label Deceleration & settings
		JLabel Label_FullName = new JLabel("Full Name:");
		Label_FullName.setForeground(Color.WHITE);
		Label_FullName.setFont(new Font("David", Font.PLAIN, 13));
		Label_FullName.setBackground(Color.YELLOW);
		Label_FullName.setBounds(0, 10, 105, 50);
		panel_Main.add(Label_FullName);
		
		
		serverTunnel tunnel=null;
			try {
			 tunnel=serverTunnel.getInstance();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
			ArrayList<PotentialAdopter> waiting_people = tunnel.getWaiting_People();
			String []ids=new String[waiting_people.size()];
				 for (int i=0; i<waiting_people.size(); i++)
					 ids[i]=""+waiting_people.get(i).GetId();
					 
				 JComboBox comboBox_Delete = new JComboBox(ids);
				 comboBox_Delete.setBounds(552, 175, 96, 21);
				 panel_Main.add(comboBox_Delete);
		
		
		// AnimalAges label Deceleration & settings
		JLabel Label_AnimalAges = new JLabel("Age");
		Label_AnimalAges.setForeground(Color.WHITE);
		Label_AnimalAges.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_AnimalAges.setBounds(20, 283, 59, 26);
		panel_Main.add(Label_AnimalAges);
		
		// AnimalGender label Deceleration & settings
		JLabel Label_AnimalGender = new JLabel("Gender");
		Label_AnimalGender.setForeground(Color.WHITE);
		Label_AnimalGender.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_AnimalGender.setBounds(0, 224, 78, 34);
		panel_Main.add(Label_AnimalGender);

		
	
		// AnimalType label Deceleration & settings
		JLabel Label_AnimalType = new JLabel("Type");
		Label_AnimalType.setForeground(Color.WHITE);
		Label_AnimalType.setFont(new Font("Dialog", Font.BOLD, 20));
		Label_AnimalType.setBounds(0, 169, 59, 25);
		panel_Main.add(Label_AnimalType);
		
		
		// Name text field Deceleration & settings
		textField_Name = new JTextField();
		textField_Name.setColumns(10);
		textField_Name.setBackground(Color.WHITE);
		textField_Name.setBounds(78, 25, 125, 19);
		panel_Main.add(textField_Name);
		
		
		String options_gender[]={"Female","Male"};        
		JComboBox comboBox_AnimalGender = new JComboBox(options_gender);
		comboBox_AnimalGender.setBounds(85, 235, 96, 21);
		panel_Main.add(comboBox_AnimalGender);
		
		 String options_type[]={"DOG","CAT"};        
		JComboBox comboBox_AnimalType = new JComboBox(options_type);
		comboBox_AnimalType.setBounds(77, 173, 96, 21);
		panel_Main.add(comboBox_AnimalType);

		String options_ages[]={"0-3","4-7","8-11","up to 11"};        
		JComboBox comboBox_AnimalAges = new JComboBox(options_ages);
		comboBox_AnimalAges.setBounds(89, 290, 96, 21);
		panel_Main.add(comboBox_AnimalAges);
		
		
		// Save Button Deceleration & settings
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(60, 338, 96, 46);
		panel_Main.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField_ID.getText().equals("") || textField_Name.getText().equals("") ||
				   textField_Phone.getText().equals("") || textField_Mail.getText().equals("")||
				   comboBox_AnimalAges.getSelectedItem().toString().equals("") ||comboBox_AnimalType.getSelectedItem().toString().equals("")||
				   comboBox_AnimalGender.getSelectedItem().toString().equals(""))
   	     		{
   	     		 JOptionPane.showMessageDialog(null, "You must fill all the fields", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	     		}
				
				
			
				else if(!textField_ID.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_ID.getText())<0  ||
							!textField_Phone.getText().chars().allMatch(Character::isDigit) ||
						Integer.parseInt(textField_Phone.getText())<0 
	
						)
        				JOptionPane.showMessageDialog(null, "Age and phone must contains only digits .", "Details", JOptionPane.PLAIN_MESSAGE);
				else
					if(!textField_Mail.getText().contains("@"))
					{
        				JOptionPane.showMessageDialog(null, "Mail Address must contain @ .", "Details", JOptionPane.PLAIN_MESSAGE);

					}

				
   	     		else
   	     		{
   	     				serverTunnel tunnel=null;
   	     			try {
						 tunnel=serverTunnel.getInstance();
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
   	     			PotentialAdopter someone=new PotentialAdopter(Integer.parseInt(textField_ID.getText()), textField_Name.getText(),Integer.parseInt(textField_Phone.getText()), textField_Mail.getText(),comboBox_AnimalType.getSelectedItem().toString(),comboBox_AnimalGender.getSelectedItem().toString(),comboBox_AnimalAges.getSelectedItem().toString());

   	     			 	tunnel.WaiterToDB(someone);
	        		 	
   	     		}
   	     		
   	     		 
   	     		}
   	     		
   	     	
   	     	
			
		});
		btnSave.setBackground(new Color(70, 130, 180));
		
		// ID textfield Deceleration & settings
		textField_ID = new JTextField();
		textField_ID.setColumns(10);
		textField_ID.setBackground(Color.WHITE);
		textField_ID.setBounds(289, 25, 125, 19);
		panel_Main.add(textField_ID);
		
		
		// ID label Deceleration & settings
		JLabel Label_ID = new JLabel("ID:");
		Label_ID.setForeground(Color.WHITE);
		Label_ID.setFont(new Font("David", Font.PLAIN, 13));
		Label_ID.setBackground(Color.YELLOW);
		Label_ID.setBounds(231, 10, 48, 50);
		panel_Main.add(Label_ID);
		
		
		// Phone label Deceleration & settings
		JLabel Label_Phone = new JLabel("Phone:");
		Label_Phone.setForeground(Color.WHITE);
		Label_Phone.setFont(new Font("David", Font.PLAIN, 13));
		Label_Phone.setBackground(Color.YELLOW);
		Label_Phone.setBounds(0, 46, 105, 50);
		panel_Main.add(Label_Phone);
		
		// Phone text field Deceleration & settings
		textField_Phone = new JTextField();
		textField_Phone.setColumns(10);
		textField_Phone.setBackground(Color.WHITE);
		textField_Phone.setBounds(78, 61, 125, 19);
		panel_Main.add(textField_Phone);
		
		// Mail text field Deceleration & settings
		textField_Mail = new JTextField();
		textField_Mail.setColumns(10);
		textField_Mail.setBackground(Color.WHITE);
		textField_Mail.setBounds(289, 61, 125, 19);
		panel_Main.add(textField_Mail);
		
		// Mail label Deceleration & settings
		JLabel Label_Mail = new JLabel("Mail:");
		Label_Mail.setForeground(Color.WHITE);
		Label_Mail.setFont(new Font("David", Font.PLAIN, 13));
		Label_Mail.setBackground(Color.YELLOW);
		Label_Mail.setBounds(231, 46, 48, 50);
		panel_Main.add(Label_Mail);
		
		// Instruction label Deceleration & settings
		JLabel Label_Insruction = new JLabel("Please fill the following field according to your preferences :");
		Label_Insruction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Label_Insruction.setForeground(new Color(255, 255, 255));
		Label_Insruction.setBounds(13, 118, 447, 26);
		panel_Main.add(Label_Insruction);
		
		
		
		
		
		// Picture Deceleration & settings ####
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(231, 166, 261, 218);
			panel_Main.add(lblNewLabel);
			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		 Image image=new ImageIcon(getClass().getResource("/pics/general3.jpg")).getImage().getScaledInstance(lblNewLabel.getWidth(),lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		    ImageIcon newImage = new ImageIcon(image);
		 lblNewLabel.setIcon(newImage);
		 
		
		 
		 JLabel lblDeleteFromWaiting = new JLabel("Delete from Waiting List");
		 lblDeleteFromWaiting.setForeground(Color.WHITE);
		 lblDeleteFromWaiting.setFont(new Font("Tahoma", Font.PLAIN, 16));
		 lblDeleteFromWaiting.setBounds(514, 139, 363, 26);
		 panel_Main.add(lblDeleteFromWaiting);
		 
		 JButton btnDelete = new JButton("Delete");
		 btnDelete.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		serverTunnel tunnel=null;
				try {
				 tunnel=serverTunnel.getInstance();
			} catch (SQLException e1) {
			
				e1.printStackTrace();
			}
		 		tunnel.DeleteWaitingList(Integer.parseInt(comboBox_Delete.getSelectedItem().toString()));
		 	}
		 	
		 	
		 	
		 	
		 });
		 btnDelete.setBackground(new Color(70, 130, 180));
		 btnDelete.setBounds(552, 212, 96, 46);
		 panel_Main.add(btnDelete);
	


		  
		// Main label Deceleration & settings
		JLabel Label_Main = new JLabel("Adopter Waiting List");
		Label_Main.setForeground(Color.WHITE);
		Label_Main.setFont(new Font("Dialog", Font.BOLD, 32));
		Label_Main.setBounds(232, 10, 319, 64);
		add(Label_Main);
		setVisible(false);
	    

	}
}

