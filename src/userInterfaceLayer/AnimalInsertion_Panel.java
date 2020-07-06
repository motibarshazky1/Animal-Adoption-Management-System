package userInterfaceLayer;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import logicalLayers.Animal;
import logicalLayers.AnimalFactory;
import logicalLayers.serverTunnel;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class AnimalInsertion_Panel extends JPanel {
	public static String path;
	public static int next_id;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_4;
	private Image image=new ImageIcon(getClass().getResource("/pics/1741491.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);


	/**
	 * Create the panel.
	 */
	public AnimalInsertion_Panel() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
		  String options_gender[]={"Female","Male"};        
		JComboBox comboBox_1 = new JComboBox(options_gender);
	    comboBox_1.setBounds(256, 232, 96, 21);
	    add(comboBox_1);
		
		  String options[]={"DOG","CAT"};        
		    JComboBox comboBox = new JComboBox(options);
		    comboBox.setBounds(256, 155, 96, 21);
		    add(comboBox);
		
		JLabel label = new JLabel("Name");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Dialog", Font.BOLD, 20));
		label.setBounds(179, 194, 59, 17);
		add(label);
		
		JLabel label_1 = new JLabel("Type");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setBounds(179, 151, 59, 20);
		add(label_1);
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setBounds(171, 221, 78, 34);
		add(label_2);
		
		JLabel label_3 = new JLabel("Age");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setBounds(191, 276, 59, 26);
		add(label_3);
		
		JLabel label_4 = new JLabel("Hisun");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Dialog", Font.BOLD, 20));
		label_4.setBounds(188, 319, 62, 34);
		add(label_4);
	    
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(256, 191, 96, 20);
		add(textField);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(256, 281, 96, 20);
		add(textField_3);
		
		
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(256, 331, 96, 20);
		add(textField_4);
		
		JButton btnUploadPicture = new JButton("Upload Picture");
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
   	       		 JOptionPane.showMessageDialog(null, path, "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	       		ImageIcon icon = new ImageIcon(path);
   	       		Image dabImage=icon.getImage();
   	       		Image newImage=dabImage.getScaledInstance(150,150,1);

   	            }
   	             //if the user click on save in Jfilechooser


   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    		
   	    	}				
			
		});
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || comboBox.getSelectedItem().toString().equals("") || comboBox_1.getSelectedItem().toString().equals("") || textField_3.getText().equals(""))
   	     		{
   	     		 JOptionPane.showMessageDialog(null, "�?נ�? מל�? �?ת כל השדות הדרושי�? לתהליך זה.", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	     		}
   	     		else
   	     		{
   	     			AnimalFactory animalFctory = new AnimalFactory(); // create factory object
   	     			Animal a = animalFctory.createAnimal(++next_id,textField.getText(), 
   	     				comboBox.getSelectedItem().toString(), comboBox_1.getSelectedItem().toString(), 
   	     					Integer.parseInt(textField_3.getText()), 
   	     					Integer.parseInt(textField_4.getText()));  // create the dog or cat object.
   	     		
   	     			serverTunnel.AnimalToDB(a,path);
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
		btnSave.setBackground(new Color(70, 130, 180));
		btnSave.setBounds(187, 382, 96, 46);
		add(btnSave);
		
	
		btnUploadPicture.setBackground(new Color(70, 130, 180));
		btnUploadPicture.setBounds(313, 382, 120, 46);
		add(btnUploadPicture);
		
		JLabel lblAnimalsInsertion = new JLabel("Animal's Insertion");
		lblAnimalsInsertion.setForeground(Color.WHITE);
		lblAnimalsInsertion.setFont(new Font("Dialog", Font.BOLD, 32));
		lblAnimalsInsertion.setBounds(232, 10, 319, 64);
		add(lblAnimalsInsertion);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(398, 151, 268, 192);
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		add(lblNewLabel);
		setVisible(false);
	    ImageIcon image3 = new ImageIcon("C:/Users/Tomer/Desktop/general3.jpg");
	    Image im3 = image3.getImage();
	    Image myImg3 = im3.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage3 = new ImageIcon(myImg3);
	    lblNewLabel.setIcon(newImage3);
	    
	    
	    
	     
	    
	    
	}
}

