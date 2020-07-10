package userInterfaceLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import BussinessLayer.Adoption;
import BussinessLayer.serverTunnel;

import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

public class AdoptionHistory_Panel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow window1;

	private JTable table;
	private JTextField textField_AdopterName;
	private JTextField textField_AdopterID;
	private JTextField textField_AdopterGender;
	private JTextField textField_AdopterAge;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Create the panel.
	 */
	public AdoptionHistory_Panel() {
		serverTunnel tunnel=null;
  		try {
			tunnel=serverTunnel.getInstance();
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}
		
			ArrayList<Adoption> adoptions=tunnel.getAdoptions();

			JPanel panel_2 = new JPanel();
			panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));

			  String options_gender[]={"Female","Male"};        
			JComboBox comboBox = new JComboBox(options_gender);
  			comboBox.setBounds(92, 131, 96, 21);
  			panel_2.add(comboBox);
			  String options_type[]={"DOG","Cat"};        
			 JComboBox comboBox_1 = new JComboBox(options_type);
			comboBox_1.setBounds(92, 50, 96, 21);
			panel_2.add(comboBox_1);
	
			JLabel lblYouCanSelect = new JLabel("You can select any adoption case for details");
  			lblYouCanSelect.setForeground(Color.WHITE);
  			lblYouCanSelect.setFont(new Font("David", Font.BOLD, 30));
  			lblYouCanSelect.setBounds(64, 242, 684, 37);
  			add(lblYouCanSelect);
				

  			JLabel lblNewLabel = new JLabel("New label");
  			lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
  			lblNewLabel.setBounds(556, 321, 150, 151);
  			add(lblNewLabel);
  			lblNewLabel.setVisible(false);
  			
  			JLabel lblNewLabel_1 = new JLabel("New label");
  			lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
  			lblNewLabel_1.setForeground(new Color(255, 255, 255));
  			lblNewLabel_1.setBounds(168, 243, 251, 30);
  			add(lblNewLabel_1);
  			lblNewLabel_1.setVisible(false);
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 796, 545);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 82, 776, 151);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
			  	table = new JTable();
			  	scrollPane.setViewportView(table);
			  	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
			  	table.getTableHeader().setBackground(new Color(70,130,180));
			  	table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 18));
			  	
			  			table.setBorder(null);
			  			table.setBackground(new Color(112, 128, 144));
			  			table.addMouseListener(new MouseAdapter() {
			  			@Override
			  			public void mouseClicked(MouseEvent e) {
		  			lblNewLabel_1.setVisible(true);
			  				lblYouCanSelect.setVisible(false);
			  				lblNewLabel.setVisible(true);
			  				int i= table.getSelectedRow();
			  				TableModel model = table.getModel(); 
			  				serverTunnel tunnel=null;
			  				try {
						tunnel=serverTunnel.getInstance();
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
			  				for(int j = 0; j < adoptions.size(); j++){
			  					if(Integer.parseInt(model.getValueAt(i, 3).toString())==adoptions.get(j).animal.getId())
			  					{
			  						
			  						lblNewLabel_1.setText("Adoption Case : "+adoptions.get(j).getID());
			  						
			  						
			  						
					  textField_AdopterID.setText(""+adoptions.get(j).adopter.GetId());
			    	   textField_AdopterName.setText(adoptions.get(j).adopter.GetName());
			    	   textField_AdopterGender.setText(adoptions.get(j).adopter.GetGender());
			    	   textField_AdopterAge.setText(""+adoptions.get(j).adopter.GetAge());
			    	   textField_4.setText(adoptions.get(j).adopter.GetOccupation());
			    	   textField_5.setText(""+adoptions.get(j).adopter.GetPhoneNumber());
			    	   textField_6.setText(adoptions.get(j).adopter.GetAddress());
			    	   
			    	   
			    	   comboBox_1.setSelectedItem(adoptions.get(j).animal.getType());
			    	   comboBox.setSelectedItem(adoptions.get(j).animal.getGender());
			    	   textField_10.setText(""+adoptions.get(j).animal.getId());
			    	   textField_9.setText(adoptions.get(j).animal.getName());
			    	   textField_8.setText(""+adoptions.get(j).animal.getAge());
			    	   if(adoptions.get(j).animal.getHisun()==0)
				    	   textField_7.setText("NO");
			    	   else	 textField_7.setText("YES");


			    		 ImageIcon newImage=tunnel.ImageByAnimal(adoptions.get(j).animal, lblNewLabel.getHeight(), lblNewLabel.getWidth()); 
			    		   	
			    		 lblNewLabel.setIcon(newImage);
			    		 
			    		 
			    		 
		   				    
			    	   
			  					}
			  				}
				    
				    
			  			}
			});
			  			
			  					table.setBorder(null);
			  					table.setBackground(new Color(95, 158, 160));
			  					
			  					
			  					
			  					
			  							table.addMouseListener(new MouseAdapter() {
					  	@Override
					  	public void mouseClicked(MouseEvent e) {
					  		int i= table.getSelectedRow();
					  		TableModel model = table.getModel();       
					  		
						 
					  	}
					});
	  			
	  			
	  			
	  		
	  			
	  			JPanel panel_1 = new JPanel();
	  			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	  			panel_1.setBackground(new Color(0, 128, 128));
	  			panel_1.setBounds(10, 292, 243, 243);
	  			add(panel_1);
	  			panel_1.setLayout(null);
	  			
	  			textField_AdopterName = new JTextField();
	  			textField_AdopterName.setColumns(10);
	  			textField_AdopterName.setBackground(Color.WHITE);
	  			textField_AdopterName.setBounds(101, 69, 125, 19);
	  			panel_1.add(textField_AdopterName);
	  			
	  			textField_AdopterID = new JTextField();
	  			textField_AdopterID.setColumns(10);
	  			textField_AdopterID.setBackground(Color.WHITE);
	  			textField_AdopterID.setBounds(80, 39, 145, 19);
	  			panel_1.add(textField_AdopterID);
	  			
	  			textField_AdopterGender = new JTextField();
	  			textField_AdopterGender.setColumns(10);
	  			textField_AdopterGender.setBackground(Color.WHITE);
	  			textField_AdopterGender.setBounds(81, 98, 145, 19);
	  			panel_1.add(textField_AdopterGender);
	  			
	  			textField_AdopterAge = new JTextField();
	  			textField_AdopterAge.setColumns(10);
	  			textField_AdopterAge.setBackground(Color.WHITE);
	  			textField_AdopterAge.setBounds(101, 127, 125, 19);
	  			panel_1.add(textField_AdopterAge);
	  			
	  			textField_4 = new JTextField();
	  			textField_4.setColumns(10);
	  			textField_4.setBackground(Color.WHITE);
	  			textField_4.setBounds(101, 152, 125, 19);
	  			panel_1.add(textField_4);
	  			
	  			textField_5 = new JTextField();
	  			textField_5.setColumns(10);
	  			textField_5.setBackground(Color.WHITE);
	  			textField_5.setBounds(130, 183, 96, 19);
	  			panel_1.add(textField_5);
	  			
	  			textField_6 = new JTextField();
	  			textField_6.setColumns(10);
	  			textField_6.setBackground(Color.WHITE);
	  			textField_6.setBounds(101, 212, 125, 19);
	  			panel_1.add(textField_6);
	  			
	  			JLabel label = new JLabel("Address:");
	  			label.setForeground(Color.WHITE);
	  			label.setFont(new Font("David", Font.PLAIN, 13));
	  			label.setBackground(Color.YELLOW);
	  			label.setBounds(10, 193, 116, 50);
	  			panel_1.add(label);
	  			
	  			JLabel label_1 = new JLabel("Phone Number:");
	  			label_1.setForeground(Color.WHITE);
	  			label_1.setFont(new Font("David", Font.PLAIN, 13));
	  			label_1.setBackground(Color.YELLOW);
	  			label_1.setBounds(10, 164, 131, 50);
	  			panel_1.add(label_1);
	  			
	  			JLabel label_AdopterAge = new JLabel("Occupation:");
	  			label_AdopterAge.setForeground(Color.WHITE);
	  			label_AdopterAge.setFont(new Font("David", Font.PLAIN, 13));
	  			label_AdopterAge.setBackground(Color.YELLOW);
	  			label_AdopterAge.setBounds(10, 133, 116, 50);
	  			panel_1.add(label_AdopterAge);
	  			
	  			JLabel label_AdopterGender = new JLabel("Gender");
	  			label_AdopterGender.setForeground(Color.WHITE);
	  			label_AdopterGender.setFont(new Font("David", Font.PLAIN, 13));
	  			label_AdopterGender.setBackground(Color.YELLOW);
	  			label_AdopterGender.setBounds(10, 89, 116, 38);
	  			panel_1.add(label_AdopterGender);
	  			
	  			JLabel labe_AdopterName = new JLabel("Full Name:");
	  			labe_AdopterName.setForeground(Color.WHITE);
	  			labe_AdopterName.setFont(new Font("David", Font.PLAIN, 13));
	  			labe_AdopterName.setBackground(Color.YELLOW);
	  			labe_AdopterName.setBounds(10, 50, 105, 50);
	  			panel_1.add(labe_AdopterName);
	  			
	  			JLabel label_AdopterID = new JLabel("ID:");
	  			label_AdopterID.setForeground(Color.WHITE);
	  			label_AdopterID.setFont(new Font("David", Font.PLAIN, 13));
	  			label_AdopterID.setBackground(Color.YELLOW);
	  			label_AdopterID.setBounds(10, 24, 116, 50);
	  			panel_1.add(label_AdopterID);
	  			
	  			JLabel label_6 = new JLabel("Age");
	  			label_6.setForeground(Color.WHITE);
	  			label_6.setFont(new Font("David", Font.PLAIN, 13));
	  			label_6.setBackground(Color.YELLOW);
	  			label_6.setBounds(10, 112, 116, 50);
	  			panel_1.add(label_6);
	  			
	  			JLabel lblNewLabel_2 = new JLabel("Adopter");
	  			lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 18));
	  			lblNewLabel_2.setForeground(new Color(0, 0, 0));
	  			lblNewLabel_2.setBounds(81, 10, 83, 19);
	  			panel_1.add(lblNewLabel_2);
	  			
	  			panel_2.setBackground(new Color(0, 128, 128));
	  			panel_2.setBounds(263, 292, 243, 243);
	  			add(panel_2);
	  			panel_2.setLayout(null);
	  			
	  			JLabel label_7 = new JLabel("Type");
	  			label_7.setForeground(Color.WHITE);
	  			label_7.setFont(new Font("David", Font.BOLD, 13));
	  			label_7.setBounds(45, 54, 49, 14);
	  			panel_2.add(label_7);
	  			
	  			JLabel label_8 = new JLabel("ID");
	  			label_8.setForeground(Color.WHITE);
	  			label_8.setFont(new Font("David", Font.BOLD, 13));
	  			label_8.setBounds(45, 81, 49, 14);
	  			panel_2.add(label_8);
	  			
	  			JLabel label_9 = new JLabel("Name");
	  			label_9.setForeground(Color.WHITE);
	  			label_9.setFont(new Font("David", Font.BOLD, 13));
	  			label_9.setBounds(45, 105, 49, 14);
	  			panel_2.add(label_9);
	  			
	  			JLabel label_10 = new JLabel("Gender");
	  			label_10.setForeground(Color.WHITE);
	  			label_10.setFont(new Font("David", Font.BOLD, 13));
	  			label_10.setBounds(45, 140, 49, 14);
	  			panel_2.add(label_10);
	  			
	  			JLabel label_11 = new JLabel("Age");
	  			label_11.setForeground(Color.WHITE);
	  			label_11.setFont(new Font("David", Font.BOLD, 13));
	  			label_11.setBounds(45, 170, 49, 14);
	  			panel_2.add(label_11);
	  			
	  			JLabel lblInjection = new JLabel("Injection");
	  			lblInjection.setForeground(Color.WHITE);
	  			lblInjection.setFont(new Font("David", Font.BOLD, 13));
	  			lblInjection.setBounds(39, 201, 49, 14);
	  			panel_2.add(lblInjection);
	  			lblInjection.setVisible(false);
	  			textField_7 = new JTextField();
	  			textField_7.setColumns(10);
	  			textField_7.setBounds(92, 194, 96, 20);
	  			panel_2.add(textField_7);
	  			textField_7.setVisible(false);
	  			textField_8 = new JTextField();
	  			textField_8.setColumns(10);
	  			textField_8.setBounds(92, 164, 96, 20);
	  			panel_2.add(textField_8);
	  			
	  		
	  			
	  			textField_9 = new JTextField();
	  			textField_9.setColumns(10);
	  			textField_9.setBounds(92, 102, 96, 20);
	  			panel_2.add(textField_9);
	  			
	  			textField_10 = new JTextField();
	  			textField_10.setColumns(10);
	  			textField_10.setBounds(92, 78, 96, 20);
	  			panel_2.add(textField_10);
	  			
	  			JLabel lblAnimal = new JLabel("Animal");
	  			lblAnimal.setForeground(Color.BLACK);
	  			lblAnimal.setFont(new Font("Dialog", Font.BOLD, 18));
	  			lblAnimal.setBounds(76, 10, 83, 19);
	  			panel_2.add(lblAnimal);
	  			
	  			JLabel label_13 = new JLabel("SOS Adoptions Managment");
	  			label_13.setForeground(Color.WHITE);
	  			label_13.setFont(new Font("Dialog", Font.ITALIC, 40));
	  			label_13.setBackground(Color.WHITE);
	  			label_13.setBounds(106, 10, 531, 59);
	  			add(label_13);
	  			
	  		

DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "ID";
columnsName1[1] = "Date";
columnsName1[2] = "Animal";
columnsName1[3] = "Animal ID";
columnsName1[4] = "Adopter";
columnsName1[5] = "Adopter ID";

model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[6];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}




for(int i = 0; i < adoptions.size(); i++){
	//String[] parts = adoptions.get(i).split(","); // String array, each element is text between dots
		 

    rowData[0] =adoptions.get(i).getID();

     rowData[1] =tunnel.DateByCase(adoptions.get(i));
      rowData[2] = adoptions.get(i).animal.getName();
      rowData[3] = adoptions.get(i).animal.getId();
      rowData[4] = adoptions.get(i).adopter.GetName();
      rowData[5] = adoptions.get(i).adopter.GetId();
       
       model1.addRow(rowData);
	    table.setModel(model1);
      
}

	}
}
