import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import webserver.*;

public class MainWindow {
	private AnimalInsertion_Panel panelAnimalInsertion;
	private AvailableAnimals_Panel panelAvailableAnimals;
	private Home_Panel panellHome;
	
	private JTable table;

	
	private JFrame frame;

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
		panelAvailableAnimals.setBounds(0, 0, 733, 494);

		

		
		
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 128, 128));
		panelMenu.setBounds(0, 0, 218, 545);
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
		
		JPanel panelAdoptionHistory = new JPanel();
		panelAdoptionHistory.addMouseListener(new PanelButtonMouseAdapter(panelAdoptionHistory)
				{
			public void mouseClicked(MouseEvent e) 
			{
				menuClicked(panelAdoptionHistory);

			}
				
	});
		panelAdoptionHistory.setBackground(new Color(0, 139, 139));
		panelAdoptionHistory.setBounds(0, 241, 214, 37);
		panelMenu.add(panelAdoptionHistory);
		panelAdoptionHistory.setLayout(null);
		
		JLabel lblAdoptionsHistory = new JLabel("Adoption's History");
		lblAdoptionsHistory.setForeground(new Color(255, 255, 255));
		lblAdoptionsHistory.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAdoptionsHistory.setBounds(38, 7, 129, 27);
		panelAdoptionHistory.add(lblAdoptionsHistory);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 139, 139));
		panel.setBounds(219, 0, 758, 545);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		frame.setBounds(100, 100, 991, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(panelAnimalInsertion);
		panel.add(panelAvailableAnimals);
		panel.add(panellHome);
		
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

