package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;

import backend.MongoDBConnector;
import javax.swing.JButton;

public class FoodRecommendationFrame {

	private static JFrame frame;
	private JScrollPane scrollPane;
	private ArrayList<String> dataList;
	private String[] carbs;
	private String[] proteins;
	private String[] fats;

	public FoodRecommendationFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Food Recommendation");
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("Food Recommendation");
		heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		heading.setBounds(289, 36, 406, 30);
		frame.getContentPane().add(heading);
		
		dataList = MongoDBConnector.getFoodRecommendation("carbohydrates");
		String[] carbs = new String[dataList.size()];
		for(int i = 0; i<dataList.size(); i++) {
			carbs[i] = dataList.get(i);
		}
		
		dataList = MongoDBConnector.getFoodRecommendation("proteins");
		String[] proteins = new String[dataList.size()];
		for(int i = 0; i<dataList.size(); i++) {
			proteins[i] = dataList.get(i);
		}
		
		dataList = MongoDBConnector.getFoodRecommendation("fats");
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
		
		JLabel carbsLabel = new JLabel("Carbohydrates");
		carbsLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		carbsLabel.setBounds(208, 101, 139, 30);
		frame.getContentPane().add(carbsLabel);
		
		JLabel proteinsLabel = new JLabel("Proteins");
		proteinsLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		proteinsLabel.setBounds(447, 101, 82, 30);
		frame.getContentPane().add(proteinsLabel);
		
		JLabel fatsLabel = new JLabel("Fats");
		fatsLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		fatsLabel.setBounds(674, 101, 50, 30);
		frame.getContentPane().add(fatsLabel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(106, 587, 125, 30);
		frame.getContentPane().add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Home clicked");
				frame.setVisible(false);
				MainFrame.displayFrame();
			}
		});
		
		JButton supplementButton = new JButton("Supplements");
		supplementButton.setFont(new Font("Arial", Font.PLAIN, 16));
		supplementButton.setBounds(757, 587, 125, 30);
		frame.getContentPane().add(supplementButton);
		supplementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Supplements clicked");
				frame.setVisible(false);
				SupplementsFrame.displayFrame();
			}
		});
		
		frame.setVisible(false);
		frame = utils.update(frame);
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
}
