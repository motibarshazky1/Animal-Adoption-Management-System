package userInterfaceLayer;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;

import BussinessLayer.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow {
	private Home_Panel panellHome;
	private AnimalInsertion_Panel panelAnimalInsertion;
	private AvailableAnimals_Panel panelAvailableAnimals;
	private AdoptionHistory_Panel panelAdoptionHistory;
	private AdoptionStatistics_Panel panelAdoptionStatistics;
	private ProffesionalServices_Panel panelProffesionalServices;
	private Management_Panel panelManagement;
	private WaitingList_Panel panelWaitingList;

	public static Volunteer user;
	public JPanel paneHome;
	public static ArrayList<Adoption> cases1;
	public static JFrame frame;
	public static JLabel lblNewLabel_4;



	/**
	 * Launch the application.
	 */
	public static void closeWindow()
	{
		frame.dispose();
		
	}
	
	

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow(user);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	/*public MainWindow() {
	 * 
		initialize("");

	}
	*/
	public MainWindow(Volunteer userName) {
		

		initialize(userName);


	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Volunteer userName) {
		System.setProperty("sun.java2d.uiScale", "1.0");
		
		  user=userName;
		  JPanel paneMenagement = new JPanel();
			paneMenagement.addMouseListener(new PanelButtonMouseAdapter(paneMenagement)
			{
		public void mouseClicked(MouseEvent e) 
		{
			menuClicked(panelManagement);

		}
			
	});
			paneMenagement.setLayout(null);
			paneMenagement.setBackground(new Color(0, 139, 139));
			paneMenagement.setBounds(0, 440, 214, 37);
			
			
		  
		  //JOptionPane.showMessageDialog(null, "adi "+userName.getPermmission(), "מילוי שדות", JOptionPane.PLAIN_MESSAGE);

		if(!userName.getPermmission().equals("Admin"))
		  {
				//panelManagement.setVisible(false);
			paneMenagement.setVisible(false);

		  }
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/pics/icon.png")));
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);
		frame.setSize(1051, 622);
		frame.setLocationRelativeTo(null);
		
		panellHome =new Home_Panel();
		panellHome.setBounds(0, 0, 733, 494);	
		
		panelAnimalInsertion =new AnimalInsertion_Panel();
		panelAnimalInsertion.setBounds(0, 0, 733, 494);
		
		panelAvailableAnimals=new AvailableAnimals_Panel();
		panelAvailableAnimals.setBounds(0, 0, 822, 585);

		panelAdoptionHistory=new AdoptionHistory_Panel();
		panelAdoptionHistory.setBounds(0, 0, 822, 585);

		panelAdoptionStatistics=new AdoptionStatistics_Panel();
		panelAdoptionStatistics.setBounds(0, 0, 733, 535);
		
		panelProffesionalServices=new ProffesionalServices_Panel();
		panelProffesionalServices.setBounds(0, 0, 733, 535);
		
		panelManagement=new Management_Panel();
		panelManagement.setBounds(0, 0, 733, 535);
		
		
		panelWaitingList=new WaitingList_Panel();
		panelWaitingList.setBounds(0, 0, 733, 535);
		
		
		
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 218, 585);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome)
	{
			
			public void mouseClicked(MouseEvent e) 
			{

				menuClicked(panellHome);

			}
				
	});
		paneHome.setBackground(new Color(0, 139, 139));
		paneHome.setBounds(0, 160, 214, 37);
		panelMenu.add(paneHome);
		paneHome.setLayout(null);
		
		JLabel Label_Home = new JLabel("Home");
		Label_Home.setForeground(new Color(255, 255, 255));
		Label_Home.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_Home.setBounds(78, 12, 45, 13);
		paneHome.add(Label_Home);
		
		
		JPanel paneAvailableAnimals = new JPanel();
		paneAvailableAnimals.addMouseListener(new PanelButtonMouseAdapter(paneAvailableAnimals)
		{
			
			public void mouseClicked(MouseEvent e) 
			{
				
				menuClicked(panelAvailableAnimals);
				

			}
				
	});
		
		paneAvailableAnimals.setBackground(new Color(0, 139, 139));
		paneAvailableAnimals.setBounds(0, 200, 214, 37);
		panelMenu.add(paneAvailableAnimals);
		paneAvailableAnimals.setLayout(null);
		
		JLabel Label_AvailableAnimals = new JLabel("Available Animals");
		Label_AvailableAnimals.setForeground(new Color(255, 255, 255));
		Label_AvailableAnimals.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_AvailableAnimals.setBounds(38, 6, 132, 27);
		paneAvailableAnimals.add(Label_AvailableAnimals);
		
		JPanel paneAnimalInsertion = new JPanel();
		paneAnimalInsertion.addMouseListener(new PanelButtonMouseAdapter(paneAnimalInsertion)
{
			
			public void mouseClicked(MouseEvent e) 
			{
				
				menuClicked(panelAnimalInsertion);
				
			}
			
				
	});
		paneAnimalInsertion.setBackground(new Color(0, 139, 139));
		paneAnimalInsertion.setBounds(0, 240, 214, 37);
		panelMenu.add(paneAnimalInsertion);
		paneAnimalInsertion.setLayout(null);
		
		JLabel Label_AnimalInsertion = new JLabel("Animal Insertion");
		Label_AnimalInsertion.setForeground(new Color(255, 255, 255));
		Label_AnimalInsertion.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_AnimalInsertion.setBounds(38, 10, 142, 17);
		paneAnimalInsertion.add(Label_AnimalInsertion);
		
		JPanel paneAdoptionHistory = new JPanel();
		paneAdoptionHistory.addMouseListener(new PanelButtonMouseAdapter(paneAdoptionHistory)
				{
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelAdoptionHistory);

			}
				
	});
		paneAdoptionHistory.setBackground(new Color(0, 139, 139));
		paneAdoptionHistory.setBounds(0, 280, 214, 37);
		panelMenu.add(paneAdoptionHistory);
		paneAdoptionHistory.setLayout(null);
		
		JLabel Label_AdoptionsHistory = new JLabel("Adoption's History");
		Label_AdoptionsHistory.setForeground(new Color(255, 255, 255));
		Label_AdoptionsHistory.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_AdoptionsHistory.setBounds(38, 7, 129, 27);
		paneAdoptionHistory.add(Label_AdoptionsHistory);
		
		JLabel Label_HousePicture = new JLabel("");
		Image image=new ImageIcon(getClass().getResource("/pics/blue-home-icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		Label_HousePicture.setIcon(new ImageIcon(image));
		Label_HousePicture.setBounds(60, 10, 125, 111);
		panelMenu.add(Label_HousePicture);
		
		JPanel paneAdoptionStatistics = new JPanel();
		paneAdoptionStatistics.addMouseListener(new PanelButtonMouseAdapter(paneAdoptionStatistics) {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelAdoptionStatistics);

			}
		});
		paneAdoptionStatistics.setLayout(null);
		paneAdoptionStatistics.setBackground(new Color(0, 139, 139));
		paneAdoptionStatistics.setBounds(0, 320, 214, 37);
		panelMenu.add(paneAdoptionStatistics);
		
		JLabel Label_AdoptionsStatistics = new JLabel("Adoption's Statistics");
		Label_AdoptionsStatistics.setForeground(Color.WHITE);
		Label_AdoptionsStatistics.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_AdoptionsStatistics.setBounds(22, 3, 166, 27);
		paneAdoptionStatistics.add(Label_AdoptionsStatistics);
		
		JLabel lblNewLabel_2 = new JLabel("Shir Bata");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(28, 516, 64, 23);
		panelMenu.add(lblNewLabel_2);
		
		JLabel lblKoralBukra = new JLabel("Koral Bokra");
		lblKoralBukra.setForeground(Color.WHITE);
		lblKoralBukra.setBounds(112, 516, 106, 23);
		panelMenu.add(lblKoralBukra);
		
		
		panelMenu.add(paneMenagement);

		
		JLabel lblMotiBarshazky = new JLabel("Moti Barshazky");
		lblMotiBarshazky.setForeground(Color.WHITE);
		lblMotiBarshazky.setBounds(109, 536, 109, 23);
		panelMenu.add(lblMotiBarshazky);
		
		JLabel lblTomerCarmel = new JLabel("Tomer Carmel");
		lblTomerCarmel.setForeground(Color.WHITE);
		lblTomerCarmel.setBounds(18, 536, 106, 23);
		panelMenu.add(lblTomerCarmel);
		
		JPanel paneProffessionalServices = new JPanel();
		paneProffessionalServices.addMouseListener(new PanelButtonMouseAdapter(paneProffessionalServices){
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelProffesionalServices);

			}
		});
		paneProffessionalServices.setLayout(null);
		paneProffessionalServices.setBackground(new Color(0, 139, 139));
		paneProffessionalServices.setBounds(0, 360, 214, 37);
		panelMenu.add(paneProffessionalServices);
		
		JLabel lLabel_ProffessionalServices = new JLabel("Proffessional Services");
		lLabel_ProffessionalServices.setForeground(Color.WHITE);
		lLabel_ProffessionalServices.setFont(new Font("Dialog", Font.BOLD, 14));
		lLabel_ProffessionalServices.setBounds(22, 3, 166, 27);
		paneProffessionalServices.add(lLabel_ProffessionalServices);
		
		
		JLabel Label_Management = new JLabel("Management");
		Label_Management.setForeground(Color.WHITE);
		Label_Management.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_Management.setBounds(45, 0, 117, 27);
		paneMenagement.add(Label_Management);
		

		 lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel_4.setText("Hello, ");
		lblNewLabel_4.setBounds(45, 118, 169, 32);
		panelMenu.add(lblNewLabel_4);
		  lblNewLabel_4.setText("Hello, "+userName.GetName());

		
		
		JPanel paneWaitingList = new JPanel();
		paneWaitingList.addMouseListener(new PanelButtonMouseAdapter(paneWaitingList)
		{
	public void mouseClicked(MouseEvent e) 
	{
		menuClicked(panelWaitingList);

	}
		
});
		paneWaitingList.setLayout(null);
		paneWaitingList.setBackground(new Color(0, 139, 139));
		paneWaitingList.setBounds(0, 400, 214, 37);
		panelMenu.add(paneWaitingList);
		
		JLabel Label_WaitingList = new JLabel("Waiting List");
		Label_WaitingList.setForeground(Color.WHITE);
		Label_WaitingList.setFont(new Font("Dialog", Font.BOLD, 14));
		Label_WaitingList.setBounds(45, 0, 117, 27);
		paneWaitingList.add(Label_WaitingList);
		
		JButton btn_Disconnect = new JButton("Disconnect");
		btn_Disconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainWindow.closeWindow();
				Login_Panel login=new Login_Panel();
				login.setVisible(true);
			}
		});
		btn_Disconnect.setBackground(new Color(70, 130, 180));
		btn_Disconnect.setBounds(45, 487, 106, 21);
		panelMenu.add(btn_Disconnect);
		
		
	
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(219, 0, 791, 585);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(panelAnimalInsertion);
		panel.add(panelAvailableAnimals);
		panel.add(panellHome);
		panel.add(panelAdoptionHistory);
		panel.add(panelAdoptionStatistics);
		panel.add(panelProffesionalServices);
		panel.add(panelManagement);
		panel.add(panelWaitingList);
		
		
		
		Home_Panel home_Panel = new Home_Panel();
		home_Panel.setBounds(0, 0, 733, 494);
		panel.add(home_Panel);
		menuClicked(panellHome);

		
	}
	
	public void menuClicked(JPanel panel)
	{
		panellHome.setVisible(false);
		panelAnimalInsertion.setVisible(false);
		panelAvailableAnimals.setVisible(false);
		panelAdoptionHistory.setVisible(false);
		panelAdoptionStatistics.setVisible(false);
		panelProffesionalServices.setVisible(false);
		panelManagement.setVisible(false);
		panelWaitingList.setVisible(false);
	
		panel.setVisible(true);
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter
	{ 
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel)
		{
			this.panel=panel;
		}
		public void mouseEntered(MouseEvent e)
		{
			panel.setBackground(new Color (112,128,144));
			
		}
		public void mouseExited(MouseEvent e)
		{
			

			panel.setBackground(new Color(0, 139, 139));

		}
		public void mousePressed(MouseEvent e)
		{
			panel.setBackground(new Color (60,179,113));

		}
		public void mouseReleased(MouseEvent e)
		{
			panel.setBackground(new Color (112,128,144));

		}
		
		
	}

	
}

