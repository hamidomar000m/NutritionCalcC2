package gui;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import backend.MongoDBConnector;
import backend.NutritionCalculator;

import javax.swing.JLabel;

public class SignUpFrame extends Thread {

	public static JFrame frmDataCollection;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JComboBox genderComboBox;
	private JComboBox goalComboBox;
	private JComboBox activityComboBox;
	private JTextPane txtpnBmi_1;

	private String username;
	private String password;
	private String gender;
	private String goal;
	private String activity;
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
	 */
	private void initialize() {
		frmDataCollection = new JFrame();
		frmDataCollection.setTitle("Sign up");
		frmDataCollection.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDataCollection.getContentPane().setBackground(new Color(154, 205, 50));
		frmDataCollection.getContentPane().setLayout(null);
		frmDataCollection.setLocationRelativeTo(null);

		JTextPane txtpnRegistration = new JTextPane();
		txtpnRegistration.setEditable(false);
		txtpnRegistration.setBackground(new Color(154, 205, 50));
		txtpnRegistration.setForeground(new Color(0, 0, 0));
		txtpnRegistration.setFont(new Font("Arial rounded MT", Font.BOLD, 36));
		txtpnRegistration.setText("NutritionCalc");
		txtpnRegistration.setBounds(234, 10, 232, 51);
		frmDataCollection.getContentPane().add(txtpnRegistration);

		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setBackground(new Color(255, 255, 255));
		txtpnUsername.setEditable(false);
		txtpnUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnUsername.setText("Username");
		txtpnUsername.setBounds(120, 75, 130, 30);
		frmDataCollection.getContentPane().add(txtpnUsername);

		usernameField = new JTextField();
		usernameField.setFont(new Font("Arial", Font.PLAIN, 16));
		usernameField.setColumns(10);
		usernameField.setBounds(290, 75, 290, 30);
		frmDataCollection.getContentPane().add(usernameField);

		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setBackground(new Color(255, 255, 255));
		txtpnPassword.setForeground(new Color(0, 0, 0));
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password");
		txtpnPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnPassword.setBounds(120, 115, 130, 30);
		frmDataCollection.getContentPane().add(txtpnPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(290, 115, 290, 30);
		frmDataCollection.getContentPane().add(passwordField);

		JTextPane txtpnGender = new JTextPane();
		txtpnGender.setEditable(false);
		txtpnGender.setText("Gender:");
		txtpnGender.setForeground(Color.BLACK);
		txtpnGender.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnGender.setBackground(Color.WHITE);
		txtpnGender.setBounds(120, 189, 130, 30);
		frmDataCollection.getContentPane().add(txtpnGender);

		genderComboBox = new JComboBox();
		genderComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		genderComboBox.setModel(new DefaultComboBoxModel(new String[] { "", "male", "female" }));
		genderComboBox.setBackground(new Color(255, 255, 255));
		genderComboBox.setBounds(290, 191, 290, 30);
		frmDataCollection.getContentPane().add(genderComboBox);

		JTextPane txtpnAge = new JTextPane();
		txtpnAge.setEditable(false);
		txtpnAge.setText("Age:");
		txtpnAge.setForeground(Color.BLACK);
		txtpnAge.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnAge.setBackground(Color.WHITE);
		txtpnAge.setBounds(120, 229, 130, 30);
		frmDataCollection.getContentPane().add(txtpnAge);

		ageField = new JTextField();
		ageField.setFont(new Font("Arial", Font.PLAIN, 16));
		ageField.setBounds(290, 229, 290, 30);
		frmDataCollection.getContentPane().add(ageField);
		ageField.setColumns(10);

		JTextPane txtpnHeight = new JTextPane();
		txtpnHeight.setEditable(false);
		txtpnHeight.setText("Height (cm) :");
		txtpnHeight.setForeground(Color.BLACK);
		txtpnHeight.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnHeight.setBackground(Color.WHITE);
		txtpnHeight.setBounds(120, 269, 130, 30);
		frmDataCollection.getContentPane().add(txtpnHeight);

		heightField = new JTextField();
		heightField.setFont(new Font("Arial", Font.PLAIN, 16));
		heightField.setColumns(10);
		heightField.setBounds(290, 269, 290, 30);
		frmDataCollection.getContentPane().add(heightField);

		JTextPane txtpnWeight = new JTextPane();
		txtpnWeight.setEditable(false);
		txtpnWeight.setText("Weight (kg) :");
		txtpnWeight.setForeground(Color.BLACK);
		txtpnWeight.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnWeight.setBackground(Color.WHITE);
		txtpnWeight.setBounds(120, 309, 130, 30);
		frmDataCollection.getContentPane().add(txtpnWeight);

		weightField = new JTextField();
		weightField.setFont(new Font("Arial", Font.PLAIN, 16));
		weightField.setColumns(10);
		weightField.setBounds(290, 309, 290, 30);
		frmDataCollection.getContentPane().add(weightField);

		JTextPane txtpnAim = new JTextPane();
		txtpnAim.setEditable(false);
		txtpnAim.setText("Goal:");
		txtpnAim.setForeground(Color.BLACK);
		txtpnAim.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnAim.setBackground(Color.WHITE);
		txtpnAim.setBounds(120, 349, 130, 30);
		frmDataCollection.getContentPane().add(txtpnAim);

		goalComboBox = new JComboBox();
		goalComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "", "gain muscles", "muscle definition", "hold weight", "lose weight" }));
		goalComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		goalComboBox.setBackground(new Color(255, 255, 255));
		goalComboBox.setBounds(290, 349, 290, 30);
		frmDataCollection.getContentPane().add(goalComboBox);

		JTextPane txtpnDailyActivity = new JTextPane();
		txtpnDailyActivity.setText("Daily activity:");
		txtpnDailyActivity.setForeground(Color.BLACK);
		txtpnDailyActivity.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnDailyActivity.setEditable(false);
		txtpnDailyActivity.setBackground(Color.WHITE);
		txtpnDailyActivity.setBounds(120, 389, 130, 30);
		frmDataCollection.getContentPane().add(txtpnDailyActivity);

		activityComboBox = new JComboBox();
		String[] activities = new String[] { "", "Exclusively seated / lying activities",
				"Almost exclusively sedentary activities with almost no physical activity in the leisure",
				"Predominantly sedentary activities with occasional standing / walking activity",
				"Predominantly walking / standing activity", "Vigorous physical activity" };
		activityComboBox.setModel(new DefaultComboBoxModel(activities));
		activityComboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		activityComboBox.setBackground(new Color(255, 255, 255));
		activityComboBox.setBounds(290, 389, 290, 30);
		frmDataCollection.getContentPane().add(activityComboBox);

		JTextPane txtpnBmi = new JTextPane();
		txtpnBmi.setText("Your BMI is:");
		txtpnBmi.setForeground(Color.BLACK);
		txtpnBmi.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnBmi.setEditable(false);
		txtpnBmi.setBackground(new Color(154, 205, 50));
		txtpnBmi.setBounds(120, 463, 111, 30);
		frmDataCollection.getContentPane().add(txtpnBmi);

		txtpnBmi_1 = new JTextPane();
		txtpnBmi_1.setForeground(Color.BLACK);
		txtpnBmi_1.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnBmi_1.setEditable(false);
		txtpnBmi_1.setBackground(new Color(154, 205, 50));
		txtpnBmi_1.setBounds(290, 463, 130, 30);
		frmDataCollection.getContentPane().add(txtpnBmi_1);

		JButton registerButton = new JButton("Register");
		registerButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		registerButton.addActionListener(new RegisterListener());
		registerButton.setBackground(Color.GRAY);
		registerButton.setBounds(588, 468, 90, 35);
		frmDataCollection.getContentPane().add(registerButton);

		JLabel line_1 = new JLabel("");
		line_1.setOpaque(true);
		line_1.setEnabled(false);
		line_1.setBackground(new Color(0, 0, 0));
		line_1.setBounds(120, 166, 460, 2);
		frmDataCollection.getContentPane().add(line_1);

		JLabel line_2 = new JLabel("");
		line_2.setOpaque(true);
		line_2.setEnabled(false);
		line_2.setBackground(Color.BLACK);
		line_2.setBounds(120, 441, 460, 2);
		frmDataCollection.getContentPane().add(line_2);

		frmDataCollection.setSize(700, 550);
		frmDataCollection.setLocationRelativeTo(null);
		frmDataCollection.setVisible(true);
	}

	/*
	 * define the class SubmitListener which is needed for the Submit button
	 */
	class RegisterListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				if (inputValid()) {

					Object[] inputs = getData();

					MongoDBConnector registrationConnector = new MongoDBConnector(inputs[0].toString(),
							inputs[1].toString(), inputs[2].toString(), inputs[3].toString(), inputs[4].toString(),
							inputs[5].toString(), inputs[6].toString(), inputs[7].toString());
					registrationConnector.signUpUser();

					if (MongoDBConnector.notAlreadyRegistered) {

						NutritionCalculator n = new NutritionCalculator(inputs[2].toString(),
								Integer.parseInt(inputs[3].toString()), Double.parseDouble(inputs[4].toString()),
								Double.parseDouble(inputs[5].toString()), inputs[6].toString(), inputs[7].toString());
						n.calculate();
						double[] nutritionalValues = n.getNutritionalValues();
						String[] names = n.getNames();
						String[] nutrients = n.getNutrients();

						// MongoDBConnector nutrientInserter = new
						// MongoDBConnector(inputs[0].toString());
						MongoDBConnector.insertNutrients(inputs[0].toString(), nutritionalValues, names, nutrients);

						MainFrame mainFrame = new MainFrame(inputs[0].toString());
						mainFrame.frame.setVisible(true);
						FoodRecommendationFrame foodRecommendationFrame = new FoodRecommendationFrame();
						SupplementsFrame supplementsFrame = new SupplementsFrame(inputs[0].toString());
						SettingsFrame settingsFrame = new SettingsFrame();
						MicronutrientsFrame microNutrientsFrame = new MicronutrientsFrame(inputs[0].toString());

						isAlive = false;

					}
				} else {
					// JOptionPane.showMessageDialog(null, "Something went wrong", "ERROR",
					// JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "User already exists! Either log in or change username.", "ERROR",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	/*
	 * check whether the user input is valid
	 */
	private boolean inputValid() {
		try {
			username = usernameField.getText();
			if (username.equals("")) {
				JOptionPane.showMessageDialog(null, "Please enter a username", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			String password = new String(passwordField.getPassword());

			if (password.length() < 6) {
				JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters", "ERROR",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			gender = genderComboBox.getSelectedItem().toString();
			goal = goalComboBox.getSelectedItem().toString();
			activity = activityComboBox.getSelectedItem().toString();
			if (gender.equals("") || goal.equals("") || activity.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in all the boxes", "ERROR", JOptionPane.ERROR_MESSAGE);
				return false;
			}

			age = Integer.parseInt(ageField.getText());
			height = Double.parseDouble(heightField.getText());
			weight = Double.parseDouble(weightField.getText());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Input Error... please try again!", "ERROR", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/*
	 * read out the user inputs and return it
	 */
	public Object[] getData() {
		username = usernameField.getText();
		String password = new String(passwordField.getPassword());
		gender = genderComboBox.getSelectedItem().toString();
		goal = goalComboBox.getSelectedItem().toString();
		age = Integer.parseInt(ageField.getText());
		height = Double.parseDouble(heightField.getText());
		weight = Double.parseDouble(weightField.getText());
		activity = activityComboBox.getSelectedItem().toString();

		Object[] data = { username, password, gender, age, height, weight, goal, activity };
		return data;
	}

	/*
	 * try to calculate the BMI
	 */
	public void run() {
		double oldBMI = 0;
		double newBMI = 0;

		while (isAlive) {
			try {
				height = Double.parseDouble(heightField.getText());
				weight = Double.parseDouble(weightField.getText());
				newBMI = weight / ((height / 100) * (height / 100));
			} catch (Exception e) {
			}

			if (newBMI != oldBMI) {
				txtpnBmi_1.setText(newBMI + "");
				oldBMI = newBMI;
			}
		}
	}
}
