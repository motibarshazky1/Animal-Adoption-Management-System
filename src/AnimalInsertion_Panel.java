import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import logicalLayers.serverTunnel;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.ActionEvent;

public class AnimalInsertion_Panel extends JPanel {
	public static String path;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	

	/**
	 * Create the panel.
	 */
	public AnimalInsertion_Panel() {
		setBackground(new Color(0, 139, 139));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("David", Font.BOLD, 13));
		label.setBounds(111, 173, 49, 14);
		add(label);
		
		JLabel label_1 = new JLabel("Type");
		label_1.setFont(new Font("David", Font.BOLD, 13));
		label_1.setBounds(111, 200, 49, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("Gender");
		label_2.setFont(new Font("David", Font.BOLD, 13));
		label_2.setBounds(111, 232, 49, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("Age");
		label_3.setFont(new Font("David", Font.BOLD, 13));
		label_3.setBounds(111, 262, 49, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("Hisun");
		label_4.setFont(new Font("David", Font.BOLD, 13));
		label_4.setBounds(111, 293, 49, 14);
		add(label_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
	    add(lblNewLabel_8);
	    lblNewLabel_8.setBounds(443, 170, 196, 185);
	    lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
	    lblNewLabel_8.setVisible(false);
	    
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(158, 170, 96, 20);
		add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(158, 197, 96, 20);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(158, 224, 96, 20);
		add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(158, 256, 96, 20);
		add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(158, 286, 96, 20);
		add(textField_4);
		
		JButton button = new JButton("Adopt");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button.setBackground(new Color(107, 106, 104));
		button.setBounds(290, 228, 85, 21);
		add(button);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals(""))
   	     		{
   	     		 JOptionPane.showMessageDialog(null, "�?נ�? מל�? �?ת כל השדות הדרושי�? לתהליך זה.", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	     		}
   	     		else
   	     		{
   	     		try {

	    		serverTunnel tunnel=new serverTunnel();
	    		File file=new File(path);
	     			FileInputStream fis=new FileInputStream(file);
	     			String query="Insert into available_animal (Name,Type,Gender,Age,Hisun,Picture) values("+textField.getText()+","+textField_1.getText()+","
	    		+textField_2.getText()+","+Integer.parseInt(textField_3.getText())+","+Integer.parseInt(textField_4.getText())+fis+");";
	    		tunnel.InsertCommand(query);
	   
	        		 	JOptionPane.showMessageDialog(null, "קליטת בעל החיי�? בוצעה בהצלחה.");
	        		 	fis.close();
   	     			}
   	     		
   	     		catch(Exception e1)
   	     		{
   	     			System.err.println(e1);
   	     		} 
   	     		}
   	     		
   	     	}
   	     	
			
		});
		btnSave.setBackground(new Color(107, 106, 104));
		btnSave.setBounds(111, 318, 62, 21);
		add(btnSave);
		
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
   	     	    lblNewLabel_8.setIcon(new ImageIcon(newImage));
   	     	    


   	            }
   	             //if the user click on save in Jfilechooser


   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    		
   	    	}				
			
		});
		btnUploadPicture.setBackground(new Color(107, 106, 104));
		btnUploadPicture.setBounds(183, 317, 104, 21);
		add(btnUploadPicture);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(new Color(107, 106, 104));
		btnUpdate.setBounds(297, 318, 85, 21);
		add(btnUpdate);
		setVisible(false);
	}
}
