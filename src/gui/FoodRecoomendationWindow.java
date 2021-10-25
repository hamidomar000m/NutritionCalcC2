package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;

import backend.MongoDBConnector;

public class FoodRecoomendationWindow {

	private JFrame frame;
	private JScrollPane scrollPane;
	private ArrayList<String> dataList;
	private String[] carbs;
	private String[] proteins;
	private String[] fats;

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
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("Food Recommendation");
		heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		heading.setBounds(285, 36, 415, 30);
		frame.getContentPane().add(heading);
		
		MongoDBConnector connectorCarb = new MongoDBConnector("carbohydrates");
		dataList = connectorCarb.getFoodRecommendation();
		String[] carbs = new String[dataList.size()];
		for(int i = 0; i<dataList.size(); i++) {
			carbs[i] = dataList.get(i);
		}
		
		MongoDBConnector connectorProt = new MongoDBConnector("proteins");
		dataList = connectorProt.getFoodRecommendation();
		String[] proteins = new String[dataList.size()];
		for(int i = 0; i<dataList.size(); i++) {
			proteins[i] = dataList.get(i);
		}
		MongoDBConnector connectorFats = new MongoDBConnector("fats");
		dataList = connectorFats.getFoodRecommendation();
		String[] fats = new String[dataList.size()];
		for(int i = 0; i<dataList.size(); i++) {
			fats[i] = dataList.get(i);
		}
		
		String[][] tableData = new String[24][3];
		
		for(int i = 0; i<carbs.length; i++) {
			tableData[i][0] = carbs[i];
		}
		for(int i = 0; i<proteins.length; i++) {
			tableData[i][1] = proteins[i];
		}
		for(int i = 0; i<fats.length; i++) {
			tableData[i][2] = fats[i];
		}
		
		String[] columnNames = {
				"", "", ""
		};
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(167, 130, 650, 400);
		frame.getContentPane().add(scrollPane);
		
		JTable foodTable = new JTable(tableData,columnNames);
		foodTable.setRowMargin(3);
		foodTable.setRowHeight(25);
		foodTable.setFont(new Font("Arial", Font.PLAIN, 16));
		scrollPane.setViewportView(foodTable);
		
		JLabel lblNewLabel = new JLabel("Carbohydrates");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(208, 101, 139, 30);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Proteins");
		lblNewLabel_1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(447, 101, 82, 30);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fats");
		lblNewLabel_2.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(674, 101, 50, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		frame.setVisible(true);
	}
}
