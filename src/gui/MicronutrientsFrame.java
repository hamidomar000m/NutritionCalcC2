package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;

public class MicronutrientsFrame {

	private JFrame frame;

	public MicronutrientsFrame() {
		
		initialize();
		
	}

	private void initialize() {
		frame = new JFrame("Micronutrients");
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JLabel lblHeading = new JLabel("Micronutrients");
		lblHeading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
		lblHeading.setBounds(97, 26, 204, 33);
		frame.getContentPane().add(lblHeading);
		

		String[] tableHeading = {"Micronutrient", "Amount"};
		
		String[][] tableData = new String[][] {
			
			{"Vitamin A", "1.1 mg"},
			{"Vitamin B", "1.2 mg"},
			{"Vitamin C", "1.2 mg"},
			{"Vitamin D", "1.3 mg"},
			{"Vitamin E", "1.3 mg"}
			
		};
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 108, 277, 449);
		frame.getContentPane().add(scrollPane);
		
		JTable micronutrientTable = new JTable(tableData, tableHeading);
		scrollPane.setViewportView(micronutrientTable);
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				MainFrame.enableFrame();
			}
			
		});
		
		frame.setVisible(true);
		
	}
}
