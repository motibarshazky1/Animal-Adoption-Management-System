package userInterfaceLayer;

import javax.swing.*;
import java.awt.Image;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;


public class Home_Panel extends JPanel {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public Home_Panel() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));
		setBounds(219, 0, 758, 545);
		setLayout(null);
		setVisible(true);

		
		// Picture Deceleration & settings
		JLabel Label_MainPicture = new JLabel("");
		Label_MainPicture.setBounds(33, 136, 665, 317);
		add(Label_MainPicture);
		Label_MainPicture.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		Image image=new ImageIcon(getClass().getResource("/pics/general1.jpeg")).getImage().getScaledInstance(
														Label_MainPicture.getWidth(),Label_MainPicture.getHeight(),
														Image.SCALE_SMOOTH);
		ImageIcon newImage = new ImageIcon(image);
		Label_MainPicture.setIcon(newImage);
	
	    
	   
		// Main Label Deceleration & settings
	    JLabel Label_Main = new JLabel("SOS Adoptions Managment");
	    Label_Main.setBackground(Color.WHITE);
	    Label_Main.setFont(new Font("Dialog", Font.ITALIC, 40));
	    Label_Main.setForeground(Color.WHITE);
	    Label_Main.setBounds(116, 50, 531, 59);
	    add(Label_Main);
	    
	}
}
