package gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import backend.MongoDBConnector;
import backend.NutritionCalculator;

import java.awt.Font;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.TextField;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Box;
import javax.swing.JOptionPane;

public class SignUpFrame extends Thread{

	public JFrame frmDataCollection;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JTextPane txtpnBmi_1;
	
	private String username = null;
	private String password = null;
	private String gender = null;
	private String goal = null;
	private String activity = null;
	private int age = 0;
	private double height = 0;
	private double weight = 0;
	
	private boolean isAlive;
	
	
	/**
	 * Create the application.
	 */
	public SignUpFrame() {
		isAlive = true;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public void initialize() {
		frmDataCollection = new JFrame();
		frmDataCollection.setTitle("Sign Up");
		frmDataCollection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDataCollection.getContentPane().setBackground(new Color(153, 204, 102));
		frmDataCollection.setVisible(true);
		frmDataCollection.getContentPane().setLayout(null);
		
		JTextPane txtpnRegistration = new JTextPane();
		txtpnRegistration.setEditable(false);
		txtpnRegistration.setBackground(Color.WHITE);
		txtpnRegistration.setForeground(new Color(153, 204, 102));
		txtpnRegistration.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtpnRegistration.setText("Registration");
		txtpnRegistration.setBounds(282, 20, 121, 31);
		frmDataCollection.getContentPane().add(txtpnRegistration);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnUsername.setText("Username");
		txtpnUsername.setBounds(120, 75, 130, 30);
		frmDataCollection.getContentPane().add(txtpnUsername);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 75, 290, 30);
		frmDataCollection.getContentPane().add(textField_3);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password");
		txtpnPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnPassword.setBounds(120, 115, 130, 30);
		frmDataCollection.getContentPane().add(txtpnPassword);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(290, 115, 290, 30);
		frmDataCollection.getContentPane().add(textField_4);
		
		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setEditable(false);
		txtpnGender.setText("Gender:");
		txtpnGender.setForeground(Color.BLACK);
		txtpnGender.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnGender.setBackground(Color.WHITE);
		txtpnGender.setBounds(120, 189, 130, 30);
		frmDataCollection.getContentPane().add(txtpnGender);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "male", "female"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(290, 191, 290, 30);
		frmDataCollection.getContentPane().add(comboBox);
		
		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setEditable(false);
		txtpnAge.setText("Age:");
		txtpnAge.setForeground(Color.BLACK);
		txtpnAge.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnAge.setBackground(Color.WHITE);
		txtpnAge.setBounds(120, 229, 130, 30);
		frmDataCollection.getContentPane().add(txtpnAge);
		
		textField = new JTextField();
		textField.setBounds(290, 229, 290, 30);
		frmDataCollection.getContentPane().add(textField);
		textField.setColumns(10);
		
		JTextPane txtpnHeight = new JTextPane();
		txtpnHeight.setEditable(false);
		txtpnHeight.setText("Height (cm) :");
		txtpnHeight.setForeground(Color.BLACK);
		txtpnHeight.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnHeight.setBackground(Color.WHITE);
		txtpnHeight.setBounds(120, 269, 130, 30);
		frmDataCollection.getContentPane().add(txtpnHeight);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(290, 269, 290, 30);
		frmDataCollection.getContentPane().add(textField_1);
		
		JTextPane txtpnWeight = new JTextPane();
		txtpnWeight.setEditable(false);
		txtpnWeight.setText("Weight (kg) :");
		txtpnWeight.setForeground(Color.BLACK);
		txtpnWeight.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnWeight.setBackground(Color.WHITE);
		txtpnWeight.setBounds(120, 309, 130, 30);
		frmDataCollection.getContentPane().add(txtpnWeight);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(290, 309, 290, 30);
		frmDataCollection.getContentPane().add(textField_2);
		
		JTextPane txtpnAim = new JTextPane();
		txtpnAim.setEditable(false);
		txtpnAim.setText("Goal:");
		txtpnAim.setForeground(Color.BLACK);
		txtpnAim.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnAim.setBackground(Color.WHITE);
		txtpnAim.setBounds(120, 349, 130, 30);
		frmDataCollection.getContentPane().add(txtpnAim);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "gain muscles", "muscle definition", "hold weight", "lose weight"}));
		comboBox_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(290, 349, 290, 30);
		frmDataCollection.getContentPane().add(comboBox_1);
		
		JTextPane txtpnDailyActivity = new JTextPane();
		txtpnDailyActivity.setText("Daily activity:");
		txtpnDailyActivity.setForeground(Color.BLACK);
		txtpnDailyActivity.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnDailyActivity.setEditable(false);
		txtpnDailyActivity.setBackground(Color.WHITE);
		txtpnDailyActivity.setBounds(120, 389, 130, 30);
		frmDataCollection.getContentPane().add(txtpnDailyActivity);

		comboBox_1_1 = new JComboBox();
		String[] activities = new String[] {"", "Exclusively seated / lying activities",
				"Almost exclusively sedentary activities with almost no physical activity in the leisure",
				"Predominantly sedentary activities with occasional standing / walking activity",
				"Predominantly walking / standing activity", "Vigorous physical activity"};
		comboBox_1_1.setModel(new DefaultComboBoxModel(activities));
		comboBox_1_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		comboBox_1_1.setBackground(Color.WHITE);
		comboBox_1_1.setBounds(290, 389, 290, 30);
		frmDataCollection.getContentPane().add(comboBox_1_1);
		
		JTextPane txtpnBmi = new JTextPane();
		txtpnBmi.setText("Your BMI is:");
		txtpnBmi.setForeground(Color.BLACK);
		txtpnBmi.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnBmi.setEditable(false);
		txtpnBmi.setBackground(new Color(153, 204, 102));
		txtpnBmi.setBounds(120, 429, 100, 30);
		frmDataCollection.getContentPane().add(txtpnBmi);
		
		txtpnBmi_1 = new JTextPane();
		txtpnBmi_1.setForeground(Color.BLACK);
		txtpnBmi_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnBmi_1.setEditable(false);
		txtpnBmi_1.setBackground(new Color(153, 204, 102));
		txtpnBmi_1.setBounds(290, 429, 130, 30);
		frmDataCollection.getContentPane().add(txtpnBmi_1);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new SubmitListener());
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(488, 468, 90, 35);
		frmDataCollection.getContentPane().add(btnNewButton);
		
		frmDataCollection.setSize(700, 550);
		frmDataCollection.setLocationRelativeTo(null);
		frmDataCollection.setVisible(true);
	}
	
	/*
	 * define the class SubmitListener which is needed for the Submit button
	 */
	class SubmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(inputValid()) {
				Object[] inputs = getData();
				MongoDBConnector mongoDBConnector = new MongoDBConnector(inputs[0].toString(), inputs[1].toString(), inputs[2].toString(), inputs[3].toString(), inputs[4].toString(), inputs[5].toString(), inputs[6].toString(), inputs[7].toString());
				mongoDBConnector.signUpUser();
				frmDataCollection.setVisible(false);
				NutritionCalculator n = new NutritionCalculator(inputs[2].toString(),
										Integer.parseInt(inputs[3].toString()), Double.parseDouble(inputs[4].toString()),
										Double.parseDouble(inputs[5].toString()), inputs[6].toString(), inputs[7].toString());
				n.calculate();
				n.printNutritionalValues();
				n.printAll();
				isAlive = false;
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid data!\r\nNo field should be empty!\r\nPassword should be at least 6 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	
	
	/*
	 * check whether the user input is valid
	 */
	private boolean inputValid() {
		try {
			username = textField_3.getText().toLowerCase();
			password = textField_4.getText();
			gender = comboBox.getSelectedItem().toString();
			goal = comboBox_1.getSelectedItem().toString();
			activity = comboBox_1_1.getSelectedItem().toString();
			age = Integer.parseInt(textField.getText());
			height = Double.parseDouble(textField_1.getText());
			weight = Double.parseDouble(textField_2.getText());
			
			if(username != "" && password.length() > 5 && gender != "" && goal != "" && activity != "")
				return true;
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	
	
	
	/*
	 * read out the user inputs and return it
	 */
	public Object[] getData() {
		username = textField_3.getText();
		password = textField_4.getText(); 
		gender = comboBox.getSelectedItem().toString();
		goal = comboBox_1.getSelectedItem().toString();
		age = Integer.parseInt(textField.getText());
		height = Double.parseDouble(textField_1.getText());
		weight = Double.parseDouble(textField_2.getText());
		activity = comboBox_1_1.getSelectedItem().toString();
		
		Object[] data = {username, password, gender, age, weight, height, goal, activity};
		return data;
	}
	
	
	
	/*
	 * try to calculate the BMI
	 */
	public void run() {
		double oldBMI = 0;
		double newBMI = 0;
		
		while(isAlive) {
			try {
				height = Double.parseDouble(textField_1.getText());
				weight = Double.parseDouble(textField_2.getText());
				newBMI = weight / ( (height/100)*(height/100) );
			}catch(Exception e) {}
			
			if(newBMI != oldBMI) {
				txtpnBmi_1.setText(newBMI+"");
				oldBMI = newBMI;
				System.out.println("hejjksafj");
			}
		}
	}
}


