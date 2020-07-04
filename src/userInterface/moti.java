package userInterface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class moti {

	private JFrame frame;
	private JTextField txtAges;
	private JTextField txtType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					moti window = new moti();
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
	public moti() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(500, 100, 720, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane ().setLayout(null);
		Font newFont = new Font("Tohama", Font.PLAIN, 20);
		Font newFont2 = new Font("Tohama", Font.BOLD, 14);

		//***************
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Dog");
		rdbtnNewRadioButton_1.setBounds(112, 236, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(newFont2);
    	JComboBox<String> comboBox3 = new JComboBox<String>();
    	comboBox3.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    	comboBox3.setRenderer(new MyComboBoxRenderer(" Is Domesticated "));
        comboBox3.setForeground(Color.BLACK);
        comboBox3.setBounds(112, 320, 155, 29);
		comboBox3.addItem(" Yes ");
		comboBox3.addItem(" No ");
		comboBox3.setSelectedItem(null);
		frame.getContentPane().add(comboBox3);
		comboBox3.setFont(newFont2);
    	JComboBox<String> comboBox2 = new JComboBox<String>();
    	comboBox2.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        comboBox2.setRenderer(new MyComboBoxRenderer(" guide Dog "));
		comboBox2.setForeground(Color.BLACK);
		comboBox2.setBounds(112, 320, 155, 29);
		comboBox2.addItem(" Yes dog ");
		comboBox2.addItem(" No dog");
		comboBox2.setSelectedItem(null);
		frame.getContentPane().add(comboBox2);
		comboBox2.setFont(newFont2);
		comboBox2.setVisible(false);
    	comboBox3.setVisible(false);
//***************
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	comboBox3.setVisible(false);
	        	comboBox2.setVisible(true);
	    		comboBox2.setSelectedItem(null);

	        }
	    });
		
		JRadioButton rdbtnNewRadioButton_1_1 = new JRadioButton("Cat");
		rdbtnNewRadioButton_1_1.setBounds(112, 273, 155, 29);
		frame.getContentPane().add(rdbtnNewRadioButton_1_1);
		rdbtnNewRadioButton_1_1.setFont(newFont2);
		rdbtnNewRadioButton_1_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	comboBox2.setVisible(false);
	        	comboBox3.setVisible(true);
	    		comboBox3.setSelectedItem(null);

	        }
	    });
		
		ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(rdbtnNewRadioButton_1);
        bgroup.add(rdbtnNewRadioButton_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("0-2");
		chckbxNewCheckBox.setBounds(484, 236, 66, 29);
		frame.getContentPane().add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(newFont2);	

		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("3-6");
		chckbxNewCheckBox_1.setBounds(484, 273, 66, 29);
		frame.getContentPane().add(chckbxNewCheckBox_1);
		chckbxNewCheckBox_1.setFont(newFont2);	

		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("7+");
		chckbxNewCheckBox_2.setBounds(484, 310, 66, 29);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		chckbxNewCheckBox_2.setFont(newFont2);	

		
		txtAges = new JTextField();
		txtAges.setText("     Age");
		txtAges.setBounds(466, 198, 84, 26);
		frame.getContentPane().add(txtAges);
		txtAges.setColumns(10);
		txtAges.setFont(newFont);
		
		JPanel panel = new JPanel();
		panel.setBounds(144, 42, 286, 113);
		panel.setLayout(null);

		frame.getContentPane().add(panel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel.add(comboBox);
		comboBox.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		comboBox.setRenderer(new MyComboBoxRenderer(" GENDER "));
		comboBox.setForeground(Color.BLACK);
		comboBox.addItem(" Male ");
		comboBox.addItem(" Female ");
		
		comboBox.setSelectedItem(null);
		comboBox.setFont(newFont);	
		
		txtType = new JTextField();
		txtType.setBounds(46, 66, 84, 26);
		panel.add(txtType);
		txtType.setText("    Type");
		txtType.setColumns(10);
		txtType.setFont(newFont);
		
		
	}
	class MyComboBoxRenderer extends JLabel implements ListCellRenderer<Object>
    {
        private String _title;

        public MyComboBoxRenderer(String title)
        {
            _title = title;
        }

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value,
                int index, boolean isSelected, boolean hasFocus)
        {
            if (index == -1 && value == null) setText(_title);
            else setText(value.toString());
            return this;
        }
    }
}