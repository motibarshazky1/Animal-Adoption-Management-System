package gui;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.Image;
import java.awt.Label;
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
import webserver.serverTunnel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;


public class Home_Panel extends JPanel {
	private JLabel label_2;

	/**
	 * Create the panel.
	 */
	public Home_Panel() {
		System.setProperty("sun.java2d.uiScale", "1.0");
		setBackground(new Color(47, 79, 79));
		
		setBounds(219, 0, 758, 545);

		setLayout(null);
		setVisible(true);
		
		JLabel label = new JLabel("");
		label.setBounds(375, 119, 301, 199);
		add(label);
		label.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		JLabel label_1 = new JLabel("");
		label_1.setBounds(64, 119, 301, 199);
		add(label_1);
		label_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		
		label_2 = new JLabel("");
		label_2.setBounds(68, 321, 608, 183);
		add(label_2);
		label_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		
	    ImageIcon image = new ImageIcon("C:/Users/Tomer/Desktop/general1.jpg");
	    Image im = image.getImage();
        Image myImg = im.getScaledInstance(label.getWidth(), label.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage = new ImageIcon(myImg);
	    ImageIcon image2 = new ImageIcon("C:/Users/Tomer/Desktop/general2.jpg");
	    Image im2 = image2.getImage();
	    Image myImg2 = im2.getScaledInstance(label_1.getWidth(), label_1.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage2 = new ImageIcon(myImg2);
	    ImageIcon image3 = new ImageIcon("C:/Users/Tomer/Desktop/general3.jpg");
	    Image im3 = image3.getImage();
	    Image myImg3 = im3.getScaledInstance(label_2.getWidth(), label_2.getHeight(),Image.SCALE_SMOOTH);
	    ImageIcon newImage3 = new ImageIcon(myImg3);
	    
	    label.setIcon(newImage);
	    label_1.setIcon(newImage2);
	    label_2.setIcon(newImage3);
	    
	    JLabel lblNewLabel = new JLabel("SOS Adoptions Managment");
	    lblNewLabel.setBackground(Color.WHITE);
	    lblNewLabel.setFont(new Font("Dialog", Font.ITALIC, 40));
	    lblNewLabel.setForeground(Color.WHITE);
	    lblNewLabel.setBounds(116, 50, 531, 59);
	    add(lblNewLabel);

	}
}
