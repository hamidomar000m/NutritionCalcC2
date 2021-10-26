package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.MongoDBConnector;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;

public class SupplementsFrame {

	private static JFrame frame;
	private JScrollPane scrollPane;
	
	public SupplementsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Supplements");
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("Supplements");
		heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		heading.setBounds(376, 28, 231, 45);
		frame.getContentPane().add(heading);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(92, 250, 800, 215);
		frame.getContentPane().add(scrollPane_1);
		
		String[][] tableData = MongoDBConnector.getSupplements(MongoDBConnector.getAim("username"));
		String[] columnNames = {
				"", ""
		};
		
		JTable supTable = new JTable(tableData,columnNames);
		supTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		supTable.setRowMargin(3);
		supTable.setRowHeight(25);
		supTable.setFont(new Font("Arial", Font.PLAIN, 16));
		
		scrollPane_1.setViewportView(supTable);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		nameLabel.setBounds(267, 194, 52, 30);
		frame.getContentPane().add(nameLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		descriptionLabel.setBounds(638, 194, 102, 30);
		frame.getContentPane().add(descriptionLabel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(33, 560, 210, 30);
		frame.getContentPane().add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("food recommendation clicked");
				frame.setVisible(false);
				MainFrame.displayFrame();
			}
		});
		
		JButton foodButton = new JButton("Food Recommendation");
		foodButton.setFont(new Font("Arial", Font.PLAIN, 16));
		foodButton.setBounds(738, 560, 210, 30);
		frame.getContentPane().add(foodButton);
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("food recommendation clicked");
				frame.setVisible(false);
				FoodRecommendationFrame.displayFrame();
			}
		});
		
		
		frame.setVisible(false);
		frame = utils.update(frame);
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
}
