package userInterfaceLayer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import BussinessLayer.Person;
import BussinessLayer.Volunteer;
import BussinessLayer.login;
import BussinessLayer.serverTunnel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Login_Panel extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_Username;
	private JPasswordField textField_Password;

	
	
	
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

	
	public Login_Panel() {
		
		//icon login window
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login_Panel.class.getResource("/pics/icon.png"))); 
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(10, 10, 458, 235);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		//set Login window in the center of the screen
		setBounds((Toolkit.getDefaultToolkit().getScreenSize().width/2)-(panel.getWidth()/2),
				(Toolkit.getDefaultToolkit().getScreenSize().height/2)-(panel.getHeight()/2), 484, 292);

		
		// Login Button Deceleration settings
		JButton btn_Login = new JButton("Login");
		btn_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// create a login object with username and password
				login login1=new login(textField_Username.getText(),textField_Password.getText());
	    		
	    		serverTunnel tunnel=null;
	    		try {
	    			 tunnel=serverTunnel.getInstance();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	    		
	    		
	    		// this is a check for access all the information data and abilities
	    		if(tunnel.login(login1))
	    		{
	    			Volunteer user=tunnel.checkPermession(textField_Username.getText());
	    			//create new window for the accessed system
	    			MainWindow a=new MainWindow(user);
	    	         a.frame.setVisible(true);
	    	         
	    	         // close the login window
	    	         dispose();
	    	        
	    			
	    		}		
	    	
	    		
				
			}

			
		});
		btn_Login.setBackground(new Color(70, 130, 180));
		btn_Login.setBounds(118, 164, 85, 37);
		panel.add(btn_Login);
		
		// username text field Deceleration & settings
		textField_Username = new JTextField();
		textField_Username.setBounds(108, 88, 106, 19);
		panel.add(textField_Username);
		textField_Username.setColumns(10);
		
		
		// password text field Deceleration & settings
		textField_Password = new JPasswordField();
		textField_Password.setColumns(10);
		textField_Password.setBounds(108, 122, 106, 19);
		panel.add(textField_Password);
		
		// username label Deceleration & settings
		JLabel Label_Username = new JLabel("Username");
		Label_Username.setForeground(new Color(255, 255, 255));
		Label_Username.setFont(new Font("Dialog", Font.BOLD, 18));
		Label_Username.setBounds(0, 81, 104, 28);
		panel.add(Label_Username);
		
		// password label Deceleration & settings
		JLabel Label_Password = new JLabel("Password");
		Label_Password.setForeground(new Color(255, 255, 255));
		Label_Password.setFont(new Font("Dialog", Font.BOLD, 18));
		Label_Password.setBounds(5, 117, 104, 28);
		panel.add(Label_Password);
		
		// Main label Deceleration & settings
		JLabel Label_LoginPage = new JLabel("Login Page");
		Label_LoginPage.setForeground(new Color(0, 0, 0));
		Label_LoginPage.setFont(new Font("Dialog", Font.BOLD, 24));
		Label_LoginPage.setBounds(135, 0, 157, 44);
		panel.add(Label_LoginPage);
		
		
		// Picture Deceleration & settings
		JLabel Label_LockPicture = new JLabel("");
		Label_LockPicture.setBounds(238, 39, 188, 175);
		panel.add(Label_LockPicture);
		Image image=new ImageIcon(getClass().getResource("/pics/891399.png")).getImage().getScaledInstance(
														Label_LockPicture.getWidth(),Label_LockPicture.getHeight(),	
														Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(image);
		Label_LockPicture.setIcon(newImage);
		 
	}



}
