package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.JTable;

public class FoodRecoomendationWindow {

	private JFrame frame;
	private JTable foodTable;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FoodRecoomendationWindow window = new FoodRecoomendationWindow();
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
	public FoodRecoomendationWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Food Recommendation");
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 900, 615);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("Food Recommendation");
		heading.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 25));
		heading.setBounds(312, 31, 288, 30);
		frame.getContentPane().add(heading);
		
		String[][] tableData = new String[][] {
			{"test1", "test2", "test3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"},
			{"testa1", "testa2", "testa3"}
		};
		String[] tableHeading = {
				"Carbs", "Protein", "Fats"
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(293, 218, 319, 150);
		frame.getContentPane().add(scrollPane);
		
		foodTable = new JTable(tableData, tableHeading);
		scrollPane.setViewportView(foodTable);
	}
}
