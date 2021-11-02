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

import backend.MongoDBConnector;

import java.awt.Font;

public class MicronutrientsFrame {

	public static JFrame frame;
	private String userName;

	public MicronutrientsFrame(final String _id) {
		
		this.userName = _id;
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
		
		String[][] tableData = MongoDBConnector.getMicronutrients(userName);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(55, 108, 277, 449);
		frame.getContentPane().add(scrollPane);
		
		JTable micronutrientTable = new JTable(tableData, tableHeading);
		micronutrientTable.setEnabled(false);
		micronutrientTable.setFont(new Font("Arial", Font.PLAIN, 14));
		micronutrientTable.setRowMargin(3);
		micronutrientTable.setRowHeight(25);
		scrollPane.setViewportView(micronutrientTable);
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				MainFrame.enableFrame();
			}
			
		});
		
		frame.setVisible(false);
		
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
}
