import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import userInterface.Work;
import webserver.serverTunnel;

public class AvailableAnimals_Panel extends JPanel {
	private JTable table;
	public static String path;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblNewLabel_8;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	

	/**
	 * Create the panel.
	 */
	public AvailableAnimals_Panel() {
		setBackground(new Color(0, 139, 139));
		setBounds(219, 0, 758, 545);
		setLayout(null);
		setVisible(true);
		setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(0, 0, 492, 275);
		add(panel);
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		JPanel panel_Adoption = new JPanel();
		panel_Adoption.setBounds(34, 270, 350, 275);
		add(panel_Adoption);
		panel_Adoption.setBackground(new Color(0, 139, 139));
		panel_Adoption.setLayout(null);
		panel_Adoption.setVisible(false);
		
		
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.getTableHeader().setBackground(new Color(32,103,100));
		table.getTableHeader().setFont(new Font("David", Font.BOLD, 18));
		
				table.setBorder(null);
				table.setBackground(new Color(153, 255, 204));
				 DefaultTableModel model1 = new DefaultTableModel();
				    Object[] columnsName1 = new Object[5];
				    
				    columnsName1[0] = "Name";
				    columnsName1[1] = "Type";
				    columnsName1[2] = "Gender";
				    columnsName1[3] = "Age";
				    columnsName1[4] = "Hisun";
				    
				    model1.setColumnIdentifiers(columnsName1);
					Object[] rowData = new Object[4];
		    		for( int i = model1.getRowCount() - 1; i >= 0; i-- )
		    		{
		    		    model1.removeRow(i);
		    		}
		    	    for(int i = 0; i < getUsers().size(); i++){
		    	       
		    	        rowData[0] = getUsers().get(i).getName();
		    	         rowData[1] = getUsers().get(i).getType();
		    	          rowData[2] = getUsers().get(i).getAge();
		    	           rowData[3] = getUsers().get(i).getHisun();
		    	           
		    	           model1.addRow(rowData);
		    	    	    table.setModel(model1);

		    	          
		    	    }
		
		
		
		JButton button_1 = new JButton("Submit");
		button_1.setBounds(69, 244, 65, 21);
		panel_Adoption.add(button_1);
		
		JLabel label_11 = new JLabel("Fill the Adopter's Details");
		label_11.setBounds(10, 10, 200, 50);
		panel_Adoption.add(label_11);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("David", Font.PLAIN, 18));
		label_11.setBackground(Color.YELLOW);
		
		JLabel label_5 = new JLabel("ID:");
		label_5.setBounds(10, 41, 116, 50);
		panel_Adoption.add(label_5);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("David", Font.PLAIN, 13));
		label_5.setBackground(Color.YELLOW);
		
		textField_5 = new JTextField();
		textField_5.setBounds(69, 60, 157, 19);
		panel_Adoption.add(textField_5);
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		
		textField_6 = new JTextField();
		textField_6.setBounds(101, 91, 125, 19);
		panel_Adoption.add(textField_6);
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		
		JLabel label_6 = new JLabel("Full Name:");
		label_6.setBounds(10, 72, 105, 50);
		panel_Adoption.add(label_6);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("David", Font.PLAIN, 13));
		label_6.setBackground(Color.YELLOW);
		
		JLabel label_7 = new JLabel("Gender");
		label_7.setBounds(10, 101, 116, 50);
		panel_Adoption.add(label_7);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("David", Font.PLAIN, 13));
		label_7.setBackground(Color.YELLOW);
		
		JLabel label_8 = new JLabel("Address:");
		label_8.setBounds(10, 132, 116, 50);
		panel_Adoption.add(label_8);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("David", Font.PLAIN, 13));
		label_8.setBackground(Color.YELLOW);
		
		JLabel label_9 = new JLabel("Phone Number:");
		label_9.setBounds(10, 163, 131, 50);
		panel_Adoption.add(label_9);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("David", Font.PLAIN, 13));
		label_9.setBackground(Color.YELLOW);
		
		JLabel label_10 = new JLabel("Address:");
		label_10.setBounds(10, 192, 116, 50);
		panel_Adoption.add(label_10);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("David", Font.PLAIN, 13));
		label_10.setBackground(Color.YELLOW);
		
		textField_10 = new JTextField();
		textField_10.setBounds(101, 211, 125, 19);
		panel_Adoption.add(textField_10);
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		
		textField_9 = new JTextField();
		textField_9.setBounds(130, 182, 96, 19);
		panel_Adoption.add(textField_9);
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		
		textField_8 = new JTextField();
		textField_8.setBounds(101, 151, 125, 19);
		panel_Adoption.add(textField_8);
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		
		textField_7 = new JTextField();
		textField_7.setBounds(81, 120, 145, 19);
		panel_Adoption.add(textField_7);
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		
		
		JPanel panel_animal_details = new JPanel();
		panel_animal_details.setBounds(281, 74, 467, 250);
		add(panel_animal_details);
		panel_animal_details.setBackground(new Color(0, 139, 139));
		panel_animal_details.setLayout(null);
		panel_animal_details.setVisible(false);
		
		
		JLabel lblNewLabel_8_1 = new JLabel("");
		lblNewLabel_8_1.setBounds(193, 22, 168, 159);
		panel_animal_details.add(lblNewLabel_8_1);
		lblNewLabel_8_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
			
			
				
	   	    
			JButton buttonAdopt = new JButton("Adopt");
			buttonAdopt.setBounds(373, 87, 85, 21);
			panel_animal_details.add(buttonAdopt);
			buttonAdopt.addActionListener(new ActionListener() {
				
			public void actionPerformed(ActionEvent e) {
				panel_Adoption.setVisible(true);
				panel_animal_details.setVisible(false);
					
				}
			});
			buttonAdopt.setBackground(new Color(107, 106, 104));
			
			JButton btnUploadPicture = new JButton("Upload Picture");
			btnUploadPicture.setBounds(228, 187, 104, 21);
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
   	       		 JOptionPane.showMessageDialog(null, path, "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
   	       		

   	            }
   	             //if the user click on save in Jfilechooser


   	            else if(result == JFileChooser.CANCEL_OPTION){
   	                System.out.println("No File Select");
   	            }
   	    		
   	    		
   	    	}				
				
			});
			btnUploadPicture.setBackground(new Color(107, 106, 104));
			
			
			JButton btnSave = new JButton("Save");
			btnSave.setBounds(20, 181, 62, 21);
			panel_animal_details.add(btnSave);
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
			
			JButton btnUpdate = new JButton("Update");
			btnUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
				}
			});
			btnUpdate.setBounds(92, 180, 85, 21);
			panel_animal_details.add(btnUpdate);
			btnUpdate.setBackground(new Color(107, 106, 104));
			
			textField_4 = new JTextField();
			textField_4.setBounds(57, 150, 96, 20);
			panel_animal_details.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel label_4 = new JLabel("Hisun");
			label_4.setBounds(10, 157, 49, 14);
			panel_animal_details.add(label_4);
			label_4.setFont(new Font("David", Font.BOLD, 13));
			
			JLabel label_3 = new JLabel("Age");
			label_3.setBounds(10, 126, 49, 14);
			panel_animal_details.add(label_3);
			label_3.setFont(new Font("David", Font.BOLD, 13));
			
			JLabel label_2 = new JLabel("Gender");
			label_2.setBounds(10, 96, 49, 14);
			panel_animal_details.add(label_2);
			label_2.setFont(new Font("David", Font.BOLD, 13));
			
			JLabel label_1 = new JLabel("Type");
			label_1.setBounds(10, 64, 49, 14);
			panel_animal_details.add(label_1);
			label_1.setFont(new Font("David", Font.BOLD, 13));
			
			
			   	   
					
					JLabel label = new JLabel("Name");
					label.setBounds(10, 37, 49, 14);
					panel_animal_details.add(label);
					label.setFont(new Font("David", Font.BOLD, 13));
					
		textField = new JTextField();
		textField.setBounds(57, 34, 96, 20);
		panel_animal_details.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(57, 61, 96, 20);
		panel_animal_details.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(57, 88, 96, 20);
		panel_animal_details.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(57, 120, 96, 20);
		panel_animal_details.add(textField_3);
		textField_3.setColumns(10);
				lblNewLabel_8_1.setVisible(false);
		table.addMouseListener(new MouseAdapter() {
	      	@Override
	      	public void mouseClicked(MouseEvent e) {
	      		int i= table.getSelectedRow();
	      		TableModel model = table.getModel();       
	      		lblNewLabel_8_1.setVisible(true);
	        	   textField.setText(model.getValueAt(i, 0).toString());
	   	    textField_1.setText(model.getValueAt(i, 1).toString());
	   	    textField_2.setText(model.getValueAt(i, 2).toString());
	   	    textField_3.setText(model.getValueAt(i, 3).toString());
	   	 
	   	 try {
//%%%
	   		serverTunnel tunnel= new serverTunnel();
   		
				String query2 ="SELECT Picture FROM available_animal WHERE Name='"+textField.getText()+"';";
		   		 ResultSet rs = tunnel.SelectCommand(query2);

				
	////
			 
			 	 if(rs.next()){
	                 byte[] img = rs.getBytes("Picture");



	                 //Resize The ImageIcon
	                 ImageIcon image = new ImageIcon(img);
	                 Image im = image.getImage();
	                 Image myImg = im.getScaledInstance(lblNewLabel_8_1.getWidth(), lblNewLabel_8_1.getHeight(),Image.SCALE_SMOOTH);
	                 ImageIcon newImage = new ImageIcon(myImg);
	                 lblNewLabel_8_1.setIcon(newImage);
	              
	                 
	             }
	             
	             else{
	                 JOptionPane.showMessageDialog(null, "No Data");
	             }
	   	} catch (SQLException ex) {
            Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
        }
	   	 panel_animal_details.setVisible(true);
	


	}
});
		
	
    		

		    
		    
	}
	 static ArrayList<Animal> getUsers(){
	      
	      ArrayList<Animal> animals = new ArrayList<Animal>();
	      
	      ResultSet rs;
	      String query;
	      Animal u;
	      
	      try {
	          
	          
	          	serverTunnel tunnel= new serverTunnel();
	    		 query = "SELECT * FROM available_animal";
	    		 rs = tunnel.SelectCommand(query);
	    		 
	          
	          while(rs.next()){
	              
	              u = new Animal(
	                      rs.getString("Name"),
	                      rs.getString("Type"),
	                      rs.getString("Gender"),
	                      rs.getInt("Age"),
	                      rs.getInt("Hisun")
	                      
	              );
	              
	              animals.add(u);
	          }
	           
	      } catch (SQLException ex) {
	          Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
	      }

	      return animals;
	  }
}
	
