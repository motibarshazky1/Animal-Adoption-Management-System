package userInterface;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class shir2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					shir2 frame = new shir2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public shir2() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 417);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
String perm[]={"Admin User","Regular User"};         
		
		JPanel panel_create_user = new JPanel();
		panel_create_user.setLayout(null);
		panel_create_user.setBounds(152, 61, 486, 262);
		contentPane.add(panel_create_user);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(110, 194, 115, 29);
		panel_create_user.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("New User ");
		lblNewLabel.setBounds(155, 0, 178, 54);
		panel_create_user.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblNewLabel_3 = new JLabel("permission:");
		lblNewLabel_3.setBounds(10, 134, 101, 20);
		panel_create_user.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JComboBox <String>comboBox = new JComboBox<>(perm);
		comboBox.setBounds(110, 132, 146, 26);
		panel_create_user.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setBounds(110, 99, 146, 26);
		panel_create_user.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password:");
		lblNewLabel_2.setBounds(10, 101, 87, 20);
		panel_create_user.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("User name:");
		lblNewLabel_1.setBounds(10, 64, 101, 33);
		panel_create_user.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(110, 68, 146, 26);
		panel_create_user.add(textField);
		textField.setColumns(10);
		JComboBox<String> jc = new JComboBox<>();
		panel_create_user.add(jc);
 	      jc.setBounds(10,10,146, 26); 
 	      
 	     JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Change Premmission");
 		rdbtnNewRadioButton_1.setBounds(112, 236, 155, 29);
 		panel_create_user.add(rdbtnNewRadioButton_1);
 		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Chaenge Password");
 		rdbtnNewRadioButton_1.setBounds(150, 236, 155, 29);
 		panel_create_user.add(rdbtnNewRadioButton_2);
 	     ButtonGroup bgroup = new ButtonGroup();
         bgroup.add(rdbtnNewRadioButton_1);
         bgroup.add(rdbtnNewRadioButton_2);
 	      


	}
}