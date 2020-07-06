package userInterfaceLayer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import logicalLayers.login;
import logicalLayers.serverTunnel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class Login_Panel extends JFrame {
	private login login1;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public MainWindow a;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					System.setProperty("sun.java2d.uiScale", "1.0");
					Login_Panel frame = new Login_Panel();
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
	public Login_Panel() {
		MainWindow a=new MainWindow();
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 login1=new login();
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(35, 10, 391, 243);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		start_login(textField.getText(),textField_1.getText());
	    	
	    		
				
			}
		});
		btnNewButton.setBackground(new Color(70, 130, 180));
		btnNewButton.setBounds(133, 169, 85, 37);
		panel.add(btnNewButton);
		
		
		textField = new JTextField();
		textField.setBounds(186, 93, 106, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(186, 131, 106, 19);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(80, 87, 104, 28);
		panel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPassword.setBounds(85, 123, 104, 28);
		panel.add(lblPassword);
		
		JLabel lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setForeground(new Color(0, 0, 0));
		lblLoginPage.setFont(new Font("Dialog", Font.BOLD, 24));
		lblLoginPage.setBounds(97, 10, 157, 44);
		panel.add(lblLoginPage);
	}

	public void start_login(String user,String pass) {
		serverTunnel tunnel=new serverTunnel();
		login1.setUser(user);
		login1.setPass(pass);

		if(tunnel.login(login1))
		{
			dispose();
	           a.frame.setVisible(true);
		}		
	}

}
