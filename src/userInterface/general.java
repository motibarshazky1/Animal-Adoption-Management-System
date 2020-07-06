package userInterface;

import java.net.MalformedURLException;
import userInterface.Screen_Available_Animal;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import logicalLayers.serverTunnel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;


public class general {
	
	public static String path;
	private static JTextField textField_login;
	private static JPasswordField textField_1_login;
	private static JTextField textField_1;
	private static JTextField textField_1_create_user;
	private static JTextField textField_create_user;
	private static JTextField textField;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JLabel lblNewLabel_5;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private static JTextField textField_8;
	private static JTextField textField_9;
	private static JTextField textField_10;
	/**
	 * @wbp.nonvisual location=180,-16
	 */
	private static final JSplitPane splitPane = new JSplitPane();
	

  public static void main(String... args) throws MalformedURLException, IOException
  {
	  System.setProperty("sun.java2d.uiScale", "1.0");
      String perm[]={"Admin User","Regular User"};         
	    JComboBox <String>comboBox_create_user = new JComboBox(perm);
	    JRadioButton radioButton_1 = new JRadioButton("Update User");

	  JPanel p = new JPanel();
      JPanel panel_insert_Animal = new JPanel();
      JPanel panel_1 = new JPanel();
      JPanel panel_Adoption = new JPanel();
      panel_Adoption.setBackground(new Color(0, 128, 128));
	    JButton btnAdopt = new JButton("Adopt");
		    JButton button_1 = new JButton("New button");


      panel_insert_Animal.setBackground(new Color(0, 128, 128));
	  JPanel panel_create_user = new JPanel();
      JComboBox<String> jc = new JComboBox<>();
        jc.addItem(" ");


	      jc.setBounds(10,50,170, 26); 
	      jc.addActionListener(new ActionListener() {
 	         	public void actionPerformed(ActionEvent e) {
 	         		 
     	      	    ResultSet rs;
     	      	    String query;
     	         	try{
     	         		serverTunnel tunnel= new serverTunnel();
        	     		 query = "select * from users where username='"+jc.getSelectedItem().toString()+"';";
        	     		 rs = tunnel.SelectCommand(query);
     	      	        if(rs.next())
     	      	        {
     	      	        	textField_1_create_user.setText(rs.getString("pass"));
     	      	        	comboBox_create_user.setSelectedItem(rs.getString("premmission"));
     	      	        }
     	      	        panel_create_user.add(jc);
     	      	    }catch(Exception e2){
     	      	        JOptionPane.showMessageDialog(null, "ERROR");
     	      	    }
 	         		
 	         		
 	         		textField_create_user.setText(jc.getSelectedItem().toString());
 	         	}
 	         	});
	  
	  	    
	  	    panel_create_user.setBackground(new Color(0, 128, 128));
	  	    p.add(panel_create_user);
	  	    panel_create_user.setVisible(false);
	  	    panel_create_user.setLayout(null);
	  	    panel_create_user.setBounds(160, 547, 486, 262);
	  	    JLabel lblNewLabel_create_user = new JLabel("New User ");
	  	    lblNewLabel_create_user.setBounds(155, 0, 178, 42);
	  	    panel_create_user.add(lblNewLabel_create_user);
	  	    lblNewLabel_create_user.setForeground(Color.WHITE);
	  	    lblNewLabel_create_user.setFont(new Font("Tahoma", Font.BOLD, 24));
	  	    
	  	    JLabel lblNewLabel_3_create_user = new JLabel("permission:");
	  	    lblNewLabel_3_create_user.setBounds(10, 122, 101, 20);
	  	    panel_create_user.add(lblNewLabel_3_create_user);
	  	    lblNewLabel_3_create_user.setForeground(Color.WHITE);
	  	    lblNewLabel_3_create_user.setFont(new Font("Tahoma", Font.PLAIN, 18));
	  	    comboBox_create_user.setBounds(110, 120, 146, 26);
	  	    panel_create_user.add(comboBox_create_user);
	  	    
	  	    textField_1_create_user = new JTextField();
	  	    textField_1_create_user.setBounds(228, 90, 146, 26);
	  	    panel_create_user.add(textField_1_create_user);
	  	    textField_1_create_user.setColumns(10);
	  	    
	  	    JLabel lblNewLabel_2_create_user = new JLabel("Password:");
	  	    lblNewLabel_2_create_user.setBounds(10, 89, 87, 20);
	  	    panel_create_user.add(lblNewLabel_2_create_user);
	  	    lblNewLabel_2_create_user.setFont(new Font("Tahoma", Font.PLAIN, 18));
	  	    lblNewLabel_2_create_user.setForeground(Color.WHITE);
	  	    
	  	    JLabel lblNewLabel_1_create_user = new JLabel("User name:");
	  	    lblNewLabel_1_create_user.setBounds(10, 52, 101, 33);
	  	    panel_create_user.add(lblNewLabel_1_create_user);
	  	    lblNewLabel_1_create_user.setFont(new Font("Tahoma", Font.PLAIN, 18));
	  	    lblNewLabel_1_create_user.setForeground(Color.WHITE);
	  	    
	  	    textField_create_user = new JTextField();
	  	    textField_create_user.setBounds(110, 56, 146, 26);
	  	    panel_create_user.add(textField_create_user);
	  	    textField_create_user.setColumns(10);
	  	    
	  	    JButton submit_btn_create_user = new JButton("Submit");
	  	    submit_btn_create_user.addActionListener(new ActionListener() {
	  	    	public void actionPerformed(ActionEvent e) {
	  	    		 if(textField_create_user.getText().equals("") || textField_1_create_user.getText().equals("") || comboBox_create_user.getSelectedItem().toString().equals(""))
	      	     		{
	      	     		 JOptionPane.showMessageDialog(null, "�?נ�? מל�? �?ת כל השדות הדרושי�? לתהליך זה.", "מילוי שדות", JOptionPane.PLAIN_MESSAGE);
	      	     		}
	      	     		else
	      	     		{

	      	     			String query;
	      	     		try {

	      	     			serverTunnel tunnel= new serverTunnel();	          	     		 
	          	     		 if(radioButton_1.isSelected())
	      	     			{
	      	     				query="UPDATE users set pass='"+textField_1_create_user.getText()+"',premmission='"+comboBox_create_user.getSelectedItem().toString()+"' WHERE username='"+textField_create_user.getText()+"';";
		      	     			tunnel.UpdateDB(query);
		      	     			
	      	     			}
	      	     			else
	      	     			{
	      	     				
	      	     				
	      	     				query="Insert into users (username,pass,premmission) values("+textField_create_user.getText()+textField_1_create_user.getText()+comboBox_create_user.getSelectedItem().toString()+");";
	      	    	    		tunnel.InsertCommand(query);
	      	 	   
	      	     				
	      	     				
	      	     			}
	      	     			 
	      	        		 	JOptionPane.showMessageDialog(null, "קליטת בעל החיי�? בוצעה בהצלחה.");

	      	     			  
	      	     			}
	      	     		
	      	     		catch(Exception e1)
	      	     		{
	      	     			System.err.println(e1);

	      	     		} 
	      	     		}
	  	    	}
	  	    });
	  	    submit_btn_create_user.setBounds(110, 182, 115, 29);
	  	    panel_create_user.add(submit_btn_create_user);
	  	    submit_btn_create_user.setFont(new Font("Tahoma", Font.BOLD, 18));
	  	    submit_btn_create_user.setForeground(Color.BLACK);

	  JPanel panel_images = new JPanel();
	  panel_images.setBackground(new Color(0, 128, 128));
	    panel_images.setLayout(null);
	    panel_images.setBounds(502, 698, 628, 488);
	    p.add(panel_images);
	    
	    JLabel lblNewLabel_7 = new JLabel("");
	    lblNewLabel_7.setBounds(316, 22, 301, 199);
	    panel_images.add(lblNewLabel_7);
	    lblNewLabel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    
	  JLabel lblNewLabel_9 = new JLabel("");
	    lblNewLabel_9.setBounds(10, 22, 301, 199);
	    panel_images.add(lblNewLabel_9);
	    lblNewLabel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    
	    JLabel lblNewLabel_8 = new JLabel("");
	    p.add(lblNewLabel_8);
	    lblNewLabel_8.setBounds(563, 275, 196, 185);
	    lblNewLabel_8.setBorder(new LineBorder(new Color(0, 0, 0), 3));
	    lblNewLabel_8.setVisible(false);
	    
	    JLabel lblNewLabel_10 = new JLabel("New label");
	    lblNewLabel_10.setBounds(10, 224, 607, 250);
	    panel_images.add(lblNewLabel_10);
	    lblNewLabel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
	    
	    textField = new JTextField();
	    textField.setBounds(90, 10, 96, 20);
	    panel_insert_Animal.add(textField);
	    textField.setColumns(10);
	    
	    
	    JLabel lblNewLabel = new JLabel("Name");
	       panel_insert_Animal.add(lblNewLabel);
	       lblNewLabel.setBounds(29, 13, 49, 14);
	       lblNewLabel.setFont(new Font("David", Font.BOLD, 13));
	       
	       textField_1 = new JTextField();
	       textField_1.setBounds(90, 37, 96, 20);
	       panel_insert_Animal.add(textField_1);
	       textField_1.setVisible(false);
	       textField_1.setColumns(10);
	       
	       JLabel lblNewLabel_1 = new JLabel("Type");
	       lblNewLabel_1.setBounds(29, 40, 49, 14);
	       panel_insert_Animal.add(lblNewLabel_1);
	       lblNewLabel_1.setFont(new Font("David", Font.BOLD, 13));
	       
	       JLabel lblNewLabel_2 = new JLabel("Gender");
	       lblNewLabel_2.setBounds(29, 72, 49, 14);
	       panel_insert_Animal.add(lblNewLabel_2);
	       lblNewLabel_2.setFont(new Font("David", Font.BOLD, 13));
	       
	       JLabel lblNewLabel_3 = new JLabel("Age");
	       lblNewLabel_3.setBounds(29, 102, 49, 14);
	       panel_insert_Animal.add(lblNewLabel_3);
	       lblNewLabel_3.setFont(new Font("David", Font.BOLD, 13));
	       
	       JLabel lblNewLabel_4 = new JLabel("Hisun");
	       lblNewLabel_4.setBounds(29, 133, 49, 14);
	       panel_insert_Animal.add(lblNewLabel_4);
	       lblNewLabel_4.setFont(new Font("David", Font.BOLD, 13));
	       JButton btnNewButton_2 = new JButton("Close ");   
	       JButton btnSave = new JButton("Save");


	    
	  System.setProperty("sun.java2d.uiScale", "1.0");
	    ImageIcon image = new ImageIcon("C:/Users/Tomer/Desktop/general1.jpg");
	    Image im = image.getImage();
        Image myImg = im.getScaledInstance(lblNewLabel_7.getWidth(), lblNewLabel_7.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage = new ImageIcon(myImg);
	    ImageIcon image2 = new ImageIcon("C:/Users/Tomer/Desktop/general2.jpg");
	    Image im2 = image2.getImage();
	    Image myImg2 = im2.getScaledInstance(lblNewLabel_9.getWidth(), lblNewLabel_9.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage2 = new ImageIcon(myImg2);
	    ImageIcon image3 = new ImageIcon("C:/Users/Tomer/Desktop/general3.jpg");
	    Image im3 = image3.getImage();
	    Image myImg3 = im3.getScaledInstance(lblNewLabel_10.getWidth(), lblNewLabel_10.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage3 = new ImageIcon(myImg3);
	    lblNewLabel_7.setIcon(newImage);
	    lblNewLabel_9.setIcon(newImage2);
	    lblNewLabel_10.setIcon(newImage3);
	    
	    JRadioButton radioButton = new JRadioButton("New User");
	    radioButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		panel_create_user.setVisible(true);
		  	    jc.setVisible(false);
		  	  lblNewLabel_1_create_user.setBounds(10, 52, 101, 33);
		  	    lblNewLabel_2_create_user.setBounds(10, 89, 87, 20);
		  	    lblNewLabel_3_create_user.setBounds(10, 122, 101, 20);
		  	    textField_create_user.setBounds(110, 56, 146, 26);
		  	    textField_1_create_user.setBounds(110, 87, 146, 26);
		  	    comboBox_create_user.setBounds(110, 120, 146, 26);
		  	    submit_btn_create_user.setBounds(110, 182, 115, 29);

	    	}
	    });
	    radioButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    radioButton.setBackground(new Color(0, 128, 128));
	    radioButton.setBounds(250, 68, 103, 21);
	    p.add(radioButton);
	    radioButton.setVisible(false);
	    
	    radioButton_1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		
    	      	    ResultSet rs;
    	      	    String query;
    	         	try{
    	         		serverTunnel tunnel= new serverTunnel();
       	     		 query = "select username from users";
       	     		 rs = tunnel.SelectCommand(query);
       	     		 
    	      	        while(rs.next())
    	      	        {
    	      	            jc.addItem(rs.getString("username"));
    	      	        }
    	      	        panel_create_user.add(jc);
    	      	    }catch(Exception e1){
    	      	    }
	    		panel_create_user.setVisible(true);
		  	    lblNewLabel_1_create_user.setBounds(10, 103, 101, 33);
		  	    lblNewLabel_2_create_user.setBounds(10, 140, 87, 20);
		  	    lblNewLabel_3_create_user.setBounds(10, 173, 103, 20);
		  	    textField_create_user.setBounds(110, 107, 146, 26);
		  	    textField_1_create_user.setBounds(110, 138, 146, 26);
		  	    comboBox_create_user.setBounds(110, 171, 146, 26);
		  	    submit_btn_create_user.setBounds(110, 233, 115, 29);
		  	    jc.setVisible(true);

	    		

	    	}
	    });
	    radioButton_1.setBackground(new Color(0, 128, 128));
	    radioButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
	    radioButton_1.setBounds(400, 68, 103, 21);
	    p.add(radioButton_1);
	    radioButton_1.setVisible(false);
	    ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(radioButton);
        bgroup.add(radioButton_1);
	    		
	    		
	    p.setBackground(new Color(0, 128, 128));
	  DefaultTableModel model=new DefaultTableModel();
	  Object []Row=new Object[5];
	  model.addRow(Row);
    JFrame f = new JFrame();
    f.setResizable(false);
    f.setLocation(200, 200);
    f.setVisible(false);

    f.setTitle("pets4u4");
    ImageIcon img = new ImageIcon("C:\\Users\\Tomer\\Desktop\\Capture.JPG");
    f.setIconImage(img.getImage());
    p.setLayout(null);

    f.getContentPane().add(p);
    
    lblNewLabel_5 = new JLabel("קליטת בעל חיי�? לעמותה");
    lblNewLabel_5.setFont(new Font("David", Font.BOLD, 18));
    lblNewLabel_5.setBounds(418, 60, 171, 28);
    lblNewLabel_5.setVisible(false);
    p.add(lblNewLabel_5);
    // setLayout(null);
    f.setDefaultCloseOperation(3);
    f.setSize(936, 1029);
    f.setVisible(false);
    
    DefaultTableModel model1 = new DefaultTableModel();
    Object[] columnsName1 = new Object[5];
    
    columnsName1[0] = "Name";
    columnsName1[1] = "Type";
    columnsName1[2] = "Gender";
    columnsName1[3] = "Age";
    columnsName1[4] = "Hisun";
    
    model1.setColumnIdentifiers(columnsName1);
    
    //&&&
    
    
    
    
    
    
    
    
//    System.out.println(getUsers().size());
    
    
    JPanel panel_table = new JPanel();
    panel_table.setVisible(false);
    panel_table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
    panel_table.setBackground(new Color(0, 128, 128));
    panel_table.setBounds(280, 100, 479, 165);
    
    panel_table.setLayout(new BorderLayout());
    p.add(panel_table);
    JTable table1 = new JTable();
    table1.setFont(new Font("Tahoma", Font.PLAIN, 14));
    table1.getTableHeader().setBackground(new Color(32,103,100));
    table1.getTableHeader().setFont(new Font("David", Font.BOLD, 18));

      table1.setBorder(null);
      table1.setBackground(new Color(153, 255, 204));
      table1.addMouseListener(new MouseAdapter() {
      	@Override
      	public void mouseClicked(MouseEvent e) {
      		int i= table1.getSelectedRow();
      		TableModel model = table1.getModel();       
      		lblNewLabel_8.setVisible(true);
        	   textField.setText(model.getValueAt(i, 0).toString());
   	    textField_1.setText(model.getValueAt(i, 1).toString());
   	    textField_2.setText(model.getValueAt(i, 2).toString());
   	    textField_3.setText(model.getValueAt(i, 3).toString());
   	    ResultSet rs;
   	 String query;
   	 try {
 		
   		 
			

				serverTunnel tunnel= new serverTunnel();
				query ="SELECT Picture FROM available_animal WHERE Name='"+textField.getText()+"';";
	     		 rs = tunnel.SelectCommand(query);
	     		 
		 	 if(rs.next()){
                  byte[] img = rs.getBytes("Picture");



                  //Resize The ImageIcon
                 
                  ImageIcon image = new ImageIcon(img);
                  Image im = image.getImage();
                  Image myImg = im.getScaledInstance(lblNewLabel_8.getWidth(), lblNewLabel_8.getHeight(),Image.SCALE_SMOOTH);
                  ImageIcon newImage = new ImageIcon(myImg);
                  lblNewLabel_8.setIcon(newImage);
                  
                  
                  
                  
                  
              }
              
              else{
                  JOptionPane.showMessageDialog(null, "No Data");
              }
		 	 
			 	btnAdopt.setVisible(true);
			 	button_1.setVisible(true);
    	    btnNewButton_2.setVisible(false);
    	    lblNewLabel_5.setVisible(false);
    	
    		panel_insert_Animal.setVisible(true);
    		lblNewLabel_1.setVisible(true);
    		lblNewLabel_2.setVisible(true);
    		lblNewLabel_3.setVisible(true);
    		lblNewLabel_4.setVisible(true);
    		textField.setVisible(true);
    		textField_1.setVisible(true);
    		textField_2.setVisible(true);
    		textField_3.setVisible(true);
    		textField_4.setVisible(true);
    		panel_table.setVisible(true);
    		btnSave.setVisible(false);
    		panel_insert_Animal.setLocation(240,270);
    		button_1.setLocation(420, 420);
		 	
		 	////
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 	

		
			
		
      	} catch (SQLException ex) {
             Logger.getLogger(Work.class.getName()).log(Level.SEVERE, null, ex);
         }
      	}
      });
      
       JScrollPane pane1 = new JScrollPane(table1);
       panel_table.add(pane1, BorderLayout.CENTER);
       
              pane1.getVerticalScrollBar().setBackground(new Color(32,103,100));
              pane1.getHorizontalScrollBar().setBackground(new Color(32,103,100));
    
    Color col=new Color(107, 106, 104); //צבע חדש לרקע
    
   
    
    JLabel lblNewLabel_6 = new JLabel("Animals Adoption System");
    lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 33));
    p.add(lblNewLabel_6);
    lblNewLabel_6.setBounds(262, 10, 442, 69);
    
    JLabel label_1 = new JLabel("New label");
    label_1.setBounds(332, 431, 28, -4);
    p.add(label_1);
    
    panel_1.setBackground(new Color(0, 128, 128));
    panel_1.setLayout(null);
    panel_1.setBounds(10, 60, 209, 383);
    p.add(panel_1);
    JButton btnNewButton = new JButton("Available Animals");
    btnNewButton.setBounds(26, 77, 149, 46);
    panel_1.add(btnNewButton);
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btnNewButton.setBackground(col); // רקע לכפתור
    
    
    
    JButton btn_animal_insertion = new JButton("Animal Insertion");
    btn_animal_insertion.setBounds(28, 142, 147, 46);
    panel_1.add(btn_animal_insertion);
    btn_animal_insertion.setFont(new Font("Tahoma", Font.PLAIN, 14));
    btn_animal_insertion.setBackground(new Color(107, 106, 104));
    
    JButton btnNewButton_5 = new JButton("Adoption's History");
    btnNewButton_5.setBounds(31, 208, 144, 46);
    panel_1.add(btnNewButton_5);
    btnNewButton_5.setHorizontalAlignment(SwingConstants.TRAILING);
    btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
    
    JButton btnNewButton_4 = new JButton("New Adoption");
    btnNewButton_4.setBounds(31, 271, 144, 41);
    panel_1.add(btnNewButton_4);
    btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
    btnNewButton_4.setBackground(Color.GRAY);
    
    JButton btnNewButton_6 = new JButton("New button");
    btnNewButton_6.setBounds(57, 335, 118, 38);
    panel_1.add(btnNewButton_6);
    
    JLabel lblNewLabel_11 = new JLabel("New label");
    lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 18));
    lblNewLabel_11.setBounds(52, 29, 92, 19);
    panel_1.add(lblNewLabel_11);
       
       panel_insert_Animal.setBounds(240, 270, 313, 203);
       panel_insert_Animal.setLayout(null);
       p.add(panel_insert_Animal);
       
       
       JButton btnNewButton_1 = new JButton("Upload Picture");
       btnNewButton_1.setBounds(181, 160, 108, 28);
       panel_insert_Animal.add(btnNewButton_1);
       
       
       	    
       	    
       
       	    btnNewButton_1.setVisible(false);
       	    btnNewButton_1.setBackground(SystemColor.activeCaption);
       	    
       	     
       	     

       	     
       	     btnSave.setBounds(90, 160, 81, 28);
       	     panel_insert_Animal.add(btnSave);
       	     btnSave.setBackground(SystemColor.activeCaption);
       	     btnNewButton_2.setBounds(0, 159, 81, 28);
       	     panel_insert_Animal.add(btnNewButton_2);
       	     btnNewButton_2.setVisible(false);
       	     btnNewButton_2.setBackground(SystemColor.activeCaption);
       	         
       	         textField_4 = new JTextField();
       	         textField_4.setBounds(90, 130, 96, 20);
       	         panel_insert_Animal.add(textField_4);
       	         textField_4.setVisible(true);
       	         textField_4.setColumns(10);
       	         
       	         textField_3 = new JTextField();
       	         textField_3.setBounds(90, 99, 96, 20);
       	         panel_insert_Animal.add(textField_3);
       	         textField_3.setVisible(false);
       	         textField_3.setColumns(10);
       	         
       	         textField_2 = new JTextField();
       	         textField_2.setBounds(90, 67, 96, 20);
       	         panel_insert_Animal.add(textField_2);
       	         textField_2.setVisible(false);
       	         textField_2.setColumns(10);
       	         
       	         JPanel panel = new JPanel();
       	         panel.setBackground(new Color(0, 128, 128));
       	         panel.setLayout(null);
       	         panel.setBounds(32, 453, 171, 84);
       	         p.add(panel);
       	         panel.setVisible(false);
           	  
       	         
       	         
       	 
       	   
      	  
      	   
      	    
       	         
       	         JButton btnNewButton_3 = new JButton("Management");
       	         btnNewButton_3.addActionListener(new ActionListener() {
       	         	public void actionPerformed(ActionEvent e) {
           	         	radioButton_1.setVisible(true);
           	         	radioButton.setVisible(true);
       	         	
       	         	//panel_create_user.setVisible(true);
          	         panel_insert_Animal.setVisible(false);
           	         panel_images.setVisible(false);
           	         panel_table.setVisible(false);
           	         ///
           	     
     	     		

     	     	}
           	         ///
           	         
       	         	
       	         });
       	         btnNewButton_3.setBounds(20, 10, 116, 50);
       	         panel.add(btnNewButton_3);
       	         
       	         panel_Adoption.setLayout(null);
       	         panel_Adoption.setVisible(false);
       	         
         		panel_insert_Animal.setLocation(240,270);
         			    
         			    btnAdopt.setBounds(214, 68, 85, 21);
         			    panel_insert_Animal.add(btnAdopt);
         			    btnAdopt.setBackground(new Color(107, 106, 104));
         			    
         			    button_1.addActionListener(new ActionListener() {
         			    	public void actionPerformed(ActionEvent e) {
         			    		if(textField.getText().equals("") || textField_1.getText().equals("") || textField_2.getText().equals("") || textField_3.getText().equals(""))
     			        		{
     			        		 JOptionPane.showMessageDialog(null, "�?נ�? עדכן �?ת כל השדות הדרושי�? לתהליך זה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
     			        		}
     			        		else
     			        		{
     			        			String query;
     			        		try {
     			    
     			    	     		 serverTunnel tunnel= new serverTunnel();	          	     		 
     			        			 query ="UPDATE available_animal SET "+"Name ='"+ textField.getText()+"', Type ='"+textField_1.getText()+"',Age ="+ textField_2.getText()+",Hisun ="+ textField_3.getText()+" WHERE Name='"+textField.getText()+"';";
     			     	     		 tunnel.UpdateDB(query);
     			    
     			           		 	JOptionPane.showMessageDialog(null, "העידכון בוצע בהצלחה.", "עדכון שדות", JOptionPane.PLAIN_MESSAGE);
     			    
     			    
     			        		}
     			        			
     			        		
     			        		catch(Exception e1)
     			        		{
     			        			System.err.println(e1);
     			    
     			        		} 
     			        		}
     			        		
     			    
     			        	
     			        		
     			        	
         			    	}
         			    });
         			    panel_insert_Animal.add(button_1);
         			    button_1.setBounds(214, 126, 85, 21);
         			    btnAdopt.addActionListener(new ActionListener() {
         			    	public void actionPerformed(ActionEvent e) {
         			    		panel_Adoption.setVisible(true);
         			    		panel_insert_Animal.setVisible(false);
         			    		

         			    	}
         			    });
       	         panel_Adoption.setBounds(628, 300, 294, 275);
       	         p.add(panel_Adoption);
       	         
       	         JLabel lblFullName = new JLabel("ID:");
       	         panel_Adoption.add(lblFullName);
       	         lblFullName.setBounds(30, 40, 116, 50);
       	         lblFullName.setBackground(Color.YELLOW);
       	         lblFullName.setForeground(Color.BLACK);
       	         lblFullName.setFont(new Font("David", Font.PLAIN, 13));
       	         
       	         textField_5 = new JTextField();
       	         textField_5.setBounds(99, 59, 157, 19);
       	         panel_Adoption.add(textField_5);
       	         textField_5.setBackground(new Color(255, 255, 255));
       	         textField_5.setColumns(10);
       	         
       	         textField_6 = new JTextField();
       	         textField_6.setColumns(10);
       	         textField_6.setBackground(new Color(255, 255, 255));
       	         textField_6.setBounds(131, 90, 125, 19);
       	         panel_Adoption.add(textField_6);
       	         
       	         JLabel lblPhoneNumber = new JLabel("Full Name:");
       	         lblPhoneNumber.setForeground(Color.BLACK);
       	         lblPhoneNumber.setFont(new Font("David", Font.PLAIN, 13));
       	         lblPhoneNumber.setBackground(Color.YELLOW);
       	         lblPhoneNumber.setBounds(30, 71, 105, 50);
       	         panel_Adoption.add(lblPhoneNumber);
       	         
       	         textField_7 = new JTextField();
       	         textField_7.setColumns(10);
       	         textField_7.setBackground(new Color(255, 255, 255));
       	         textField_7.setBounds(111, 119, 145, 19);
       	         panel_Adoption.add(textField_7);
       	         
       	         JLabel lblAddress = new JLabel("Gender");
       	         lblAddress.setForeground(Color.BLACK);
       	         lblAddress.setFont(new Font("David", Font.PLAIN, 13));
       	         lblAddress.setBackground(Color.YELLOW);
       	         lblAddress.setBounds(30, 100, 116, 50);
       	         panel_Adoption.add(lblAddress);
       	         
       	         JButton btnNewButton_7 = new JButton("Submit");
       	         btnNewButton_7.addActionListener(new ActionListener() {
       	         	public void actionPerformed(ActionEvent e) {
       	         	int id=0;
       	         serverTunnel tunnel=null;
       	         	try {
           	         tunnel=new serverTunnel();
        	    		String query="Select ID from available_animal WHERE Name='"+textField.getText()+"';";
           	         	ResultSet rs=tunnel.SelectCommand(query);
           	         	while(rs.next())
           	         	{
           	         	   id=rs.getInt("ID");
           	         	}
           	         		}catch(Exception e1)
               	     		{
               	     			System.err.println(e1);
               	     		}		
       	         		
       	         		try {
       	         				String query="Insert into adoption_history (Date,Animal_Name,Animal_ID,Adopter_ID) values (now(),'"+textField.getText()+"',"+id+","+Integer.parseInt(textField_5.getText())+");";
       	         		    	tunnel.InsertCommand(query);
       	         		}catch(Exception e1)
           	     		{
           	     			System.err.println(e1);

           	     		} 
 	   
       	         		
       	         	}
       	         });
       	         btnNewButton_7.setBounds(100, 239, 85, 21);
       	         panel_Adoption.add(btnNewButton_7);
       	         
       	         JLabel lblSsss = new JLabel("Address:");
       	         lblSsss.setForeground(Color.BLACK);
       	         lblSsss.setFont(new Font("David", Font.PLAIN, 13));
       	         lblSsss.setBackground(Color.YELLOW);
       	         lblSsss.setBounds(30, 131, 116, 50);
       	         panel_Adoption.add(lblSsss);
       	         
       	         textField_8 = new JTextField();
       	         textField_8.setColumns(10);
       	         textField_8.setBackground(new Color(255, 255, 255));
       	         textField_8.setBounds(131, 150, 125, 19);
       	         panel_Adoption.add(textField_8);
       	         
       	         JLabel label_2 = new JLabel("Phone Number:");
       	         label_2.setForeground(Color.BLACK);
       	         label_2.setFont(new Font("David", Font.PLAIN, 13));
       	         label_2.setBackground(Color.YELLOW);
       	         label_2.setBounds(30, 162, 131, 50);
       	         panel_Adoption.add(label_2);
       	         
       	         textField_9 = new JTextField();
       	         textField_9.setColumns(10);
       	         textField_9.setBackground(new Color(255, 255, 255));
       	         textField_9.setBounds(160, 181, 96, 19);
       	         panel_Adoption.add(textField_9);
       	         
       	         JLabel label_3 = new JLabel("Address:");
       	         label_3.setForeground(Color.BLACK);
       	         label_3.setFont(new Font("David", Font.PLAIN, 13));
       	         label_3.setBackground(Color.YELLOW);
       	         label_3.setBounds(30, 191, 116, 50);
       	         panel_Adoption.add(label_3);
       	         
       	         textField_10 = new JTextField();
       	         textField_10.setColumns(10);
       	         textField_10.setBackground(new Color(255, 255, 255));
       	         textField_10.setBounds(131, 210, 125, 19);
       	         panel_Adoption.add(textField_10);
       	         
       	         JLabel lblFillTheAdopters = new JLabel("Fill the Adopter's Details");
       	         lblFillTheAdopters.setForeground(Color.BLACK);
       	         lblFillTheAdopters.setFont(new Font("David", Font.PLAIN, 18));
       	         lblFillTheAdopters.setBackground(Color.YELLOW);
       	         lblFillTheAdopters.setBounds(49, -1, 200, 50);
       	         panel_Adoption.add(lblFillTheAdopters);
       	         
  
       	       

       	         
   
       	         btnNewButton_2.addActionListener(new ActionListener() {
       	         	public void actionPerformed(ActionEvent e) {

       	         		panel_insert_Animal.setVisible(false);
       	         		lblNewLabel_5.setVisible(false);
       	         	    btnNewButton_1.setVisible(false);
       	         	    btnSave.setVisible(false);
       	         	    btnNewButton_2.setVisible(false);
       	         		
       	         	}
       	         });
       	     btnSave.setVisible(false);
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
       	    btnNewButton_1.addActionListener(new ActionListener() {
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
            panel_insert_Animal.setVisible(false);
    
       
    
    
    
    
   

    btnNewButton_6.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    });
    btnNewButton_4.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    	}
    });
    btn_animal_insertion.setVisible(true);
    
    
   
    
    
    
    btn_animal_insertion.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
         	panel_create_user.setVisible(false);
    		panel_images.setVisible(false);
    		
    	    button_1.setVisible(true);
    		lblNewLabel_5.setVisible(true);
    	    panel_insert_Animal.setVisible(true);
    		lblNewLabel_1.setVisible(true);
    		lblNewLabel_2.setVisible(true);
    		lblNewLabel_3.setVisible(true);
    		lblNewLabel_4.setVisible(true);
    		textField.setVisible(true);
    		textField_1.setVisible(true);
    		textField_2.setVisible(true);
    		textField_3.setVisible(true);
    		textField_4.setVisible(true);
    	    textField.setText("");
    	    textField_1.setText("");
    	    textField_2.setText("");
    	    textField_3.setText("");
    	    textField_4.setText("");
    	    btnSave.setVisible(true);
    	    panel_table.setVisible(false);
    	    lblNewLabel_8.setVisible(false);
    	    btnNewButton_2.setVisible(true);
    	
    	    
    	    btnNewButton_1.setVisible(true);
    	    
    	}
    });
    btnNewButton.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    	    panel_table.setVisible(true);
    		Object[] rowData = new Object[4];
    		panel_images.setVisible(false);
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
    	    	    table1.setModel(model1);

    	          
    	    }
	         	panel_create_user.setVisible(false);
    	    btnNewButton_1.setVisible(false);
    	    lblNewLabel_8.setVisible(false);
    	    button_1.setVisible(false);
    	    
    		lblNewLabel_5.setVisible(false);
    		panel_insert_Animal.setVisible(false);

    	    btnSave.setVisible(false);
    	    btnNewButton_2.setVisible(false);

    	    
    	}
    });
  
   
    	  JPanel p2 = new JPanel();
	 
	    p2.setBackground(new Color(0, 128, 128));
	
	  model.addRow(Row);
    JFrame f2 = new JFrame();
    f2.setResizable(false);
    f2.setLocation(200, 200);
    f2.setVisible(true);

    f2.setTitle("pets4u");

    

    
    
    p2.setLayout(null);
    

    f2.getContentPane().add(p2);
    
    textField_login = new JTextField();
    textField_login.setBounds(240, 65, 96, 19);
    p2.add(textField_login);
    textField_login.setColumns(10);
    
    textField_1_login = new JPasswordField();
    textField_1_login.setColumns(10);
    textField_1_login.setBounds(240, 94, 96, 19);
    p2.add(textField_1_login);
    
    JLabel lblNewLabel_login = new JLabel("LOGIN PAGE");
    lblNewLabel_login.setFont(new Font("Tahoma", Font.BOLD, 22));
    lblNewLabel_login.setBounds(240, 10, 143, 33);
    p2.add(lblNewLabel_login);
    
    JLabel label_login = new JLabel("Username");
    label_login.setFont(new Font("Tahoma", Font.BOLD, 16));
    label_login.setBounds(150, 58, 143, 33);
    p2.add(label_login);
    
    JLabel label_1_login = new JLabel("Password");
    label_1_login.setFont(new Font("Tahoma",Font.BOLD, 16));
    label_1_login.setBounds(150, 83, 143, 33);
    p2.add(label_1_login);
	  JFrame frame = new JFrame();
	  frame.setSize(577, 288);
	  

    JButton btnNewButton_login = new JButton("Login");
    btnNewButton_login.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		  ResultSet rs,rs2;
    	      String query,query2;
    	          	      
    	      try {
    	          
    	          query="SELECT * FROM users where username ='"+textField_login.getText()+"' and pass='"+textField_1_login.getText()+"';";
    	    		serverTunnel tunnel=new serverTunnel();
    	    		rs=tunnel.SelectCommand(query);
    	    		

    	          if (rs.next() == false) // if there is no result
    	        	  JOptionPane.showMessageDialog(null, "הפרטי�? שהוזנו שגויי�?", "דף התחברות", JOptionPane.PLAIN_MESSAGE);
    	          
    	          else
    	        	  {
    	        	  f2.setVisible(false);
  	        	      f.setVisible(true);
  	        	      lblNewLabel_11.setText("Hello "+textField_login.getText());
  	        
  	        	  try {
  	        		serverTunnel a2=new serverTunnel();
    	    		query2="SELECT premmission FROM users where username ='"+textField_login.getText()+"' and premmission='Admin User';";
   	        	  	JOptionPane.showMessageDialog(null, "הצלחה", "דף התחברות", JOptionPane.PLAIN_MESSAGE);
   	        	  	rs2 = a2.SelectCommand(query2);
   	       		 	JOptionPane.showMessageDialog(null, "הרש�?ההה1.");

   	              if (rs2.next()) // if there is no result
   	              {   	      
   	       		 	JOptionPane.showMessageDialog(null, "הרש�?ההה.");
   	            	  panel.setVisible(true);  
   	              }
   	             
  	        	  }
  	        	  catch (SQLException ex)
  	        	  {
  	    	      }
        	         
    	        	
    	        	  }

    	      } catch (SQLException ex) {
    	      }
    	}
    });
    btnNewButton_login.setBounds(250, 123, 87, 21);
    p2.add(btnNewButton_login);
    
    
    
    
    
    JLabel label_2_login = new JLabel("מנהל מערכת 0508274254");
    label_2_login.setFont(new Font("David", Font.PLAIN, 14));
    label_2_login.setBounds(10, 217, 175, 33);
    p2.add(label_2_login);
    

  
    // setLayout(null);
    f2.setDefaultCloseOperation(3);
    f2.setSize(577, 288);
    f2.setVisible(true);
    
  
    
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
  
  public class new_screen
  {
	  private  void newone()
	  {
		  new general();
	  }
  }
}
