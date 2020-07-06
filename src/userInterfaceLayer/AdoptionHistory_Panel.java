package userInterfaceLayer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logicalLayers.serverTunnel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;

public class AdoptionHistory_Panel extends JPanel {
	public MainWindow window1;

	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
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
		
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));

		setBounds(219, 0, 758, 545);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 23, 696, 151);
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
	  			JScrollPane scrollPane = new JScrollPane();
	  			panel.add(scrollPane, BorderLayout.CENTER);
	  			
	  	table = new JTable();
	  	scrollPane.setViewportView(table);
	  	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
	  	table.getTableHeader().setBackground(new Color(32,103,100));
	  	table.getTableHeader().setFont(new Font("David", Font.BOLD, 18));
	  	
	  			table.setBorder(null);
	  			table.setBackground(new Color(95, 158, 160));
	  			
	  			JPanel panel_1 = new JPanel();
	  			panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
	  			panel_1.setBackground(new Color(0, 128, 128));
	  			panel_1.setBounds(10, 268, 243, 235);
	  			add(panel_1);
	  			panel_1.setLayout(null);
	  			
	  			textField = new JTextField();
	  			textField.setColumns(10);
	  			textField.setBackground(Color.WHITE);
	  			textField.setBounds(101, 55, 125, 19);
	  			panel_1.add(textField);
	  			
	  			textField_1 = new JTextField();
	  			textField_1.setColumns(10);
	  			textField_1.setBackground(Color.WHITE);
	  			textField_1.setBounds(80, 25, 145, 19);
	  			panel_1.add(textField_1);
	  			
	  			textField_2 = new JTextField();
	  			textField_2.setColumns(10);
	  			textField_2.setBackground(Color.WHITE);
	  			textField_2.setBounds(81, 84, 145, 19);
	  			panel_1.add(textField_2);
	  			
	  			textField_3 = new JTextField();
	  			textField_3.setColumns(10);
	  			textField_3.setBackground(Color.WHITE);
	  			textField_3.setBounds(101, 113, 125, 19);
	  			panel_1.add(textField_3);
	  			
	  			textField_4 = new JTextField();
	  			textField_4.setColumns(10);
	  			textField_4.setBackground(Color.WHITE);
	  			textField_4.setBounds(101, 138, 125, 19);
	  			panel_1.add(textField_4);
	  			
	  			textField_5 = new JTextField();
	  			textField_5.setColumns(10);
	  			textField_5.setBackground(Color.WHITE);
	  			textField_5.setBounds(130, 169, 96, 19);
	  			panel_1.add(textField_5);
	  			
	  			textField_6 = new JTextField();
	  			textField_6.setColumns(10);
	  			textField_6.setBackground(Color.WHITE);
	  			textField_6.setBounds(101, 198, 125, 19);
	  			panel_1.add(textField_6);
	  			
	  			JLabel label = new JLabel("Address:");
	  			label.setForeground(Color.WHITE);
	  			label.setFont(new Font("David", Font.PLAIN, 13));
	  			label.setBackground(Color.YELLOW);
	  			label.setBounds(10, 179, 116, 50);
	  			panel_1.add(label);
	  			
	  			JLabel label_1 = new JLabel("Phone Number:");
	  			label_1.setForeground(Color.WHITE);
	  			label_1.setFont(new Font("David", Font.PLAIN, 13));
	  			label_1.setBackground(Color.YELLOW);
	  			label_1.setBounds(10, 150, 131, 50);
	  			panel_1.add(label_1);
	  			
	  			JLabel label_2 = new JLabel("Occupation:");
	  			label_2.setForeground(Color.WHITE);
	  			label_2.setFont(new Font("David", Font.PLAIN, 13));
	  			label_2.setBackground(Color.YELLOW);
	  			label_2.setBounds(10, 119, 116, 50);
	  			panel_1.add(label_2);
	  			
	  			JLabel label_3 = new JLabel("Gender");
	  			label_3.setForeground(Color.WHITE);
	  			label_3.setFont(new Font("David", Font.PLAIN, 13));
	  			label_3.setBackground(Color.YELLOW);
	  			label_3.setBounds(10, 65, 116, 50);
	  			panel_1.add(label_3);
	  			
	  			JLabel label_4 = new JLabel("Full Name:");
	  			label_4.setForeground(Color.WHITE);
	  			label_4.setFont(new Font("David", Font.PLAIN, 13));
	  			label_4.setBackground(Color.YELLOW);
	  			label_4.setBounds(10, 36, 105, 50);
	  			panel_1.add(label_4);
	  			
	  			JLabel label_5 = new JLabel("ID:");
	  			label_5.setForeground(Color.WHITE);
	  			label_5.setFont(new Font("David", Font.PLAIN, 13));
	  			label_5.setBackground(Color.YELLOW);
	  			label_5.setBounds(10, 10, 116, 50);
	  			panel_1.add(label_5);
	  			
	  			JLabel label_6 = new JLabel("Age");
	  			label_6.setForeground(Color.WHITE);
	  			label_6.setFont(new Font("David", Font.PLAIN, 13));
	  			label_6.setBackground(Color.YELLOW);
	  			label_6.setBounds(10, 96, 116, 50);
	  			panel_1.add(label_6);
	  			
	  			JPanel panel_2 = new JPanel();
	  			panel_2.setBackground(new Color(0, 128, 128));
	  			panel_2.setBounds(263, 268, 243, 235);
	  			add(panel_2);
	  			panel_2.setLayout(null);
	  			
	  			JLabel label_7 = new JLabel("Type");
	  			label_7.setForeground(Color.WHITE);
	  			label_7.setFont(new Font("David", Font.BOLD, 13));
	  			label_7.setBounds(41, 35, 49, 14);
	  			panel_2.add(label_7);
	  			
	  			JLabel label_8 = new JLabel("ID");
	  			label_8.setForeground(Color.WHITE);
	  			label_8.setFont(new Font("David", Font.BOLD, 13));
	  			label_8.setBounds(41, 62, 49, 14);
	  			panel_2.add(label_8);
	  			
	  			JLabel label_9 = new JLabel("Name");
	  			label_9.setForeground(Color.WHITE);
	  			label_9.setFont(new Font("David", Font.BOLD, 13));
	  			label_9.setBounds(41, 86, 49, 14);
	  			panel_2.add(label_9);
	  			
	  			JLabel label_10 = new JLabel("Gender");
	  			label_10.setForeground(Color.WHITE);
	  			label_10.setFont(new Font("David", Font.BOLD, 13));
	  			label_10.setBounds(41, 121, 49, 14);
	  			panel_2.add(label_10);
	  			
	  			JLabel label_11 = new JLabel("Age");
	  			label_11.setForeground(Color.WHITE);
	  			label_11.setFont(new Font("David", Font.BOLD, 13));
	  			label_11.setBounds(41, 151, 49, 14);
	  			panel_2.add(label_11);
	  			
	  			JLabel label_12 = new JLabel("Hisun");
	  			label_12.setForeground(Color.WHITE);
	  			label_12.setFont(new Font("David", Font.BOLD, 13));
	  			label_12.setBounds(41, 182, 49, 14);
	  			panel_2.add(label_12);
	  			
	  			textField_7 = new JTextField();
	  			textField_7.setColumns(10);
	  			textField_7.setBounds(88, 175, 96, 20);
	  			panel_2.add(textField_7);
	  			
	  			textField_8 = new JTextField();
	  			textField_8.setColumns(10);
	  			textField_8.setBounds(88, 145, 96, 20);
	  			panel_2.add(textField_8);
	  			
	  			JComboBox comboBox = new JComboBox(new Object[]{});
	  			comboBox.setBounds(88, 112, 96, 21);
	  			panel_2.add(comboBox);
	  			
	  			textField_9 = new JTextField();
	  			textField_9.setColumns(10);
	  			textField_9.setBounds(88, 83, 96, 20);
	  			panel_2.add(textField_9);
	  			
	  			textField_10 = new JTextField();
	  			textField_10.setColumns(10);
	  			textField_10.setBounds(88, 59, 96, 20);
	  			panel_2.add(textField_10);
	  			
	  			JComboBox comboBox_1 = new JComboBox(new Object[]{});
	  			comboBox_1.setBounds(88, 31, 96, 21);
	  			panel_2.add(comboBox_1);
					table.addMouseListener(new MouseAdapter() {
					  	@Override
					  	public void mouseClicked(MouseEvent e) {
					  		int i= table.getSelectedRow();
					  		TableModel model = table.getModel();       
					  		
						 
					  	}
					});
					

DefaultTableModel model1 = new DefaultTableModel();
Object[] columnsName1 = new Object[6];

columnsName1[0] = "Adoption ID";
columnsName1[1] = "Date";
columnsName1[2] = "Animal Name";
columnsName1[3] = "Animal ID";
columnsName1[4] = "Adopter ID";
columnsName1[5] = "Adopter Name";

model1.setColumnIdentifiers(columnsName1);
Object[] rowData = new Object[6];
for( int i = model1.getRowCount() - 1; i >= 0; i-- )
{
    model1.removeRow(i);
}

ArrayList<String> adoptions=serverTunnel.getAdoptions();

for(int i = 0; i < adoptions.size(); i++){
	String[] parts = adoptions.get(i).split(","); // String array, each element is text between dots

    rowData[0] =parts[0];
     rowData[1] = parts[1];
      rowData[2] = parts[2];
      rowData[3] = parts[3];
      rowData[4] = parts[4];
      rowData[5] = parts[5];
       
       model1.addRow(rowData);
	    table.setModel(model1);
      
}

	}
}
