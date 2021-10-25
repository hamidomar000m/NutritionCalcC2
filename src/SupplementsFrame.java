import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import gui.utils;

public class SupplementsFrame {

	private JFrame frame;
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
		heading.setBounds(376, 36, 231, 45);
		frame.getContentPane().add(heading);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(167, 158, 650, 400);
		frame.getContentPane().add(scrollPane_1);
		
		String[][] tableData = new String[][] {
	            {"test1", "test2"},
	            {"testa1", "testa2"}
		};
		String[] columnNames = {
				"", ""
		};
		
		JTable supTable = new JTable(tableData,columnNames);
		supTable.setRowMargin(3);
		supTable.setRowHeight(25);
		supTable.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane_1.setViewportView(supTable);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		nameLabel.setBounds(291, 128, 52, 30);
		frame.getContentPane().add(nameLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		descriptionLabel.setBounds(596, 128, 102, 30);
		frame.getContentPane().add(descriptionLabel);
		
		
		
		frame.setVisible(true);
		frame = utils.update(frame);
	}
}
