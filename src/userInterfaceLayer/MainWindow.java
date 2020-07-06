package userInterfaceLayer;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


import logicalLayers.*;

public class MainWindow {
	private Home_Panel panellHome;
	private AnimalInsertion_Panel panelAnimalInsertion;
	private AvailableAnimals_Panel panelAvailableAnimals;
	private AdoptionHistory_Panel panelAdoptionHistory;
	private AdoptionStatistics_Panel panelAdoptionStatistics;
	private ProffesionalServices_Panel panelProffesionalServices;
	

	public JPanel paneHome;
	public static ArrayList<Adoption> cases1;
	public JFrame frame;
	private Image image=new ImageIcon(getClass().getResource("/pics/blue-home-icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
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
	public MainWindow() {
		initialize();

	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.setProperty("sun.java2d.uiScale", "1.0");

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(47, 79, 79));
		frame.getContentPane().setLayout(null);
		
		

		panellHome =new Home_Panel();
		panellHome.setBounds(0, 0, 733, 494);	
		
		panelAnimalInsertion =new AnimalInsertion_Panel();
		panelAnimalInsertion.setBounds(0, 0, 733, 494);
		
		panelAvailableAnimals=new AvailableAnimals_Panel();
		panelAvailableAnimals.setBounds(0, 0, 791, 585);

		panelAdoptionHistory=new AdoptionHistory_Panel();
		panelAdoptionHistory.setBounds(0, 0, 733, 535);

		panelAdoptionStatistics=new AdoptionStatistics_Panel();
		panelAdoptionStatistics.setBounds(0, 0, 733, 535);
		
		panelProffesionalServices=new ProffesionalServices_Panel();
		panelProffesionalServices.setBounds(0, 0, 733, 535);
		
		
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
		paneHome.setBounds(0, 131, 214, 37);
		panelMenu.add(paneHome);
		paneHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNewLabel.setBounds(78, 12, 45, 13);
		paneHome.add(lblNewLabel);
		
		
		JPanel paneAvailableAnimals = new JPanel();
		paneAvailableAnimals.addMouseListener(new PanelButtonMouseAdapter(paneAvailableAnimals)
		{
			
			public void mouseClicked(MouseEvent e) 
			{
				
				menuClicked(panelAvailableAnimals);
				

			}
				
	});
		
		paneAvailableAnimals.setBackground(new Color(0, 139, 139));
		paneAvailableAnimals.setBounds(0, 169, 214, 37);
		panelMenu.add(paneAvailableAnimals);
		paneAvailableAnimals.setLayout(null);
		
		JLabel lblAvailableAnimals = new JLabel("Available Animals");
		lblAvailableAnimals.setForeground(new Color(255, 255, 255));
		lblAvailableAnimals.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAvailableAnimals.setBounds(38, 6, 132, 27);
		paneAvailableAnimals.add(lblAvailableAnimals);
		
		JPanel paneAnimalInsertion = new JPanel();
		paneAnimalInsertion.addMouseListener(new PanelButtonMouseAdapter(paneAnimalInsertion)
{
			
			public void mouseClicked(MouseEvent e) 
			{
				
				menuClicked(panelAnimalInsertion);
				
			}
			
				
	});
		paneAnimalInsertion.setBackground(new Color(0, 139, 139));
		paneAnimalInsertion.setBounds(0, 205, 214, 37);
		panelMenu.add(paneAnimalInsertion);
		paneAnimalInsertion.setLayout(null);
		
		JLabel lblAnimalInsertion = new JLabel("Animal Insertion");
		lblAnimalInsertion.setForeground(new Color(255, 255, 255));
		lblAnimalInsertion.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAnimalInsertion.setBounds(38, 10, 142, 17);
		paneAnimalInsertion.add(lblAnimalInsertion);
		
		JPanel paneAdoptionHistory = new JPanel();
		paneAdoptionHistory.addMouseListener(new PanelButtonMouseAdapter(paneAdoptionHistory)
				{
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelAdoptionHistory);

			}
				
	});
		paneAdoptionHistory.setBackground(new Color(0, 139, 139));
		paneAdoptionHistory.setBounds(0, 241, 214, 37);
		panelMenu.add(paneAdoptionHistory);
		paneAdoptionHistory.setLayout(null);
		
		JLabel lblAdoptionsHistory = new JLabel("Adoption's History");
		lblAdoptionsHistory.setForeground(new Color(255, 255, 255));
		lblAdoptionsHistory.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdoptionsHistory.setBounds(38, 7, 129, 27);
		paneAdoptionHistory.add(lblAdoptionsHistory);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(image));
		lblNewLabel_1.setBounds(60, 10, 125, 111);
		panelMenu.add(lblNewLabel_1);
		
		JPanel paneAdoptionStatistics = new JPanel();
		paneAdoptionStatistics.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menuClicked(panelAdoptionStatistics);

				
			}
		});
		paneAdoptionStatistics.setLayout(null);
		paneAdoptionStatistics.setBackground(new Color(0, 139, 139));
		paneAdoptionStatistics.setBounds(0, 277, 214, 37);
		panelMenu.add(paneAdoptionStatistics);
		
		JLabel lblAdoptionsStatistics = new JLabel("Adoption's Statistics");
		lblAdoptionsStatistics.setForeground(Color.WHITE);
		lblAdoptionsStatistics.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdoptionsStatistics.setBounds(22, 3, 166, 27);
		paneAdoptionStatistics.add(lblAdoptionsStatistics);
		
		JLabel lblNewLabel_2 = new JLabel("Shir Bata");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(28, 516, 64, 23);
		panelMenu.add(lblNewLabel_2);
		
		JLabel lblKoralBukra = new JLabel("Koral Bukra");
		lblKoralBukra.setForeground(Color.WHITE);
		lblKoralBukra.setBounds(112, 516, 106, 23);
		panelMenu.add(lblKoralBukra);
		
		JLabel lblMotiBarshazky = new JLabel("Moti Barshazky");
		lblMotiBarshazky.setForeground(Color.WHITE);
		lblMotiBarshazky.setBounds(109, 536, 109, 23);
		panelMenu.add(lblMotiBarshazky);
		
		JLabel lblTomerCarmel = new JLabel("Tomer Carmel");
		lblTomerCarmel.setForeground(Color.WHITE);
		lblTomerCarmel.setBounds(18, 536, 106, 23);
		panelMenu.add(lblTomerCarmel);
		
		JPanel paneProffessionalServices = new JPanel();
		paneProffessionalServices.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				menuClicked(panelProffesionalServices);

				
			}
		});
		paneProffessionalServices.setLayout(null);
		paneProffessionalServices.setBackground(new Color(0, 139, 139));
		paneProffessionalServices.setBounds(0, 315, 214, 37);
		panelMenu.add(paneProffessionalServices);
		
		JLabel lblProffessionalServices = new JLabel("Proffessional Services");
		lblProffessionalServices.setForeground(Color.WHITE);
		lblProffessionalServices.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProffessionalServices.setBounds(22, 3, 166, 27);
		paneProffessionalServices.add(lblProffessionalServices);
		
		
	
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(219, 0, 791, 585);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setBounds(100, 100, 1024, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(panelAnimalInsertion);
		panel.add(panelAvailableAnimals);
		panel.add(panellHome);
		panel.add(panelAdoptionHistory);
		panel.add(panelAdoptionStatistics);
		panel.add(panelProffesionalServices);
		
		
		
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

