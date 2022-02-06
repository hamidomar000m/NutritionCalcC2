package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import backend.MongoDBConnector;
import backend.NutritionCalculator;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class RegisterFrame extends Thread {

	private static JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField weightField;
	private JComboBox goalBox;
	private JComboBox activityBox;
	private ButtonGroup genderGroup;
	private JLabel lblBMI;
	
	private String username;
	private String password;
	private String gender;
	private String goal;
	private String activity;
	private int age = 0;
	private double height = 0;
	private double weight = 0;

	private boolean isAlive;
	
	public RegisterFrame() {
		isAlive = true;
		initialize();
	}
	
	private void initialize() {
		frame = new JFrame("Register");
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1250, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel parentPnl = new JPanel();
		frame.getContentPane().add(parentPnl, BorderLayout.NORTH);
		parentPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel sidePnl = new JPanel();
		sidePnl.setPreferredSize(new Dimension(250, 770));
		sidePnl.setBackground(Constants.MIDGREEN);
		parentPnl.add(sidePnl, BorderLayout.WEST);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(Constants.LIGHTGRAY);
		btnLogin.setFont(Constants.BUTTONTEXTBOLD);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Constants.MIDGREEN);
		btnLogin.setBounds(35, 175, 51, 26);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				LoginFrame.displayFrame();
				
			}
		});
		sidePnl.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(Constants.LIGHTGRAY);
		btnRegister.setFont(Constants.BUTTONTEXTBOLD);
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBorder(null);
		btnRegister.setBackground(Constants.MIDGREEN);
		btnRegister.setBounds(35, 215, 76, 26);
		btnRegister.setEnabled(false);
		sidePnl.add(btnRegister);
		
		JLabel headingLbl = new JLabel("NutritionCalc");
		headingLbl.setBounds(35, 50, 176, 36);
		headingLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		headingLbl.setForeground(Constants.LIGHTGRAY);
		headingLbl.setFont(Constants.HEADING);
		
		JLabel uHeadingLbl = new JLabel("Track your nutrition!");
		uHeadingLbl.setBounds(35, 84, 138, 19);
		uHeadingLbl.setForeground(Constants.LIGHTGRAY);
		uHeadingLbl.setFont(Constants.PLAINTEXT);
		
		JLabel versionLbl = new JLabel(Constants.VERSION);
		versionLbl.setForeground(Constants.LIGHTGRAY);
		versionLbl.setFont(Constants.PLAINTEXT);
		versionLbl.setBounds(191, 41, 49, 14);
		sidePnl.setLayout(null);
		sidePnl.add(headingLbl);
		sidePnl.add(uHeadingLbl);
		sidePnl.add(versionLbl);
		
		JPanel mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		URL logoIconPath = this.getClass().getResource("/resources/logo.png");
		JLabel logo = new JLabel(new ImageIcon(logoIconPath));
		logo.setBounds(298, -5, 403, 247);
		mainPnl.add(logo);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(250, 316, 103, 26);
		lblUsername.setFont(Constants.LOGINTEXT);
		mainPnl.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(250, 300, 499, 2);
		mainPnl.add(separator);
		
		JLabel lblLogin = new JLabel("REGISTRATION");
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblLogin.setBounds(250, 262, 213, 36);
		lblLogin.setFont(Constants.HEADING);
		mainPnl.add(lblLogin);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(Constants.LOGINTEXT);
		lblPassword.setBounds(250, 361, 107, 26);
		mainPnl.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 363, 363, 26);
		passwordField.setFont(Constants.PLAINTEXT);
		passwordField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		passwordField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setBounds(386, 318, 363, 26);
		usernameField.setFont(Constants.PLAINTEXT);
		usernameField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		usernameField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new RegisterListener());
		btnSubmit.setBounds(660, 693, 89, 23);
		btnSubmit.setFont(Constants.BUTTONTEXT);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		btnSubmit.setBackground(Constants.LIGHTGRAY);
		mainPnl.add(btnSubmit);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(Constants.LOGINTEXT);
		lblGender.setBounds(250, 420, 89, 23);
		mainPnl.add(lblGender);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(Constants.LOGINTEXT);
		lblAge.setBounds(250, 465, 52, 23);
		mainPnl.add(lblAge);
		
		JLabel lblHeight = new JLabel("HEIGHT (cm)");
		lblHeight.setFont(Constants.LOGINTEXT);
		lblHeight.setBounds(250, 510, 128, 23);
		mainPnl.add(lblHeight);
		
		JLabel lblWeightkg = new JLabel("WEIGHT (kg)");
		lblWeightkg.setFont(Constants.LOGINTEXT);
		lblWeightkg.setBounds(250, 555, 107, 23);
		mainPnl.add(lblWeightkg);
		
		JLabel lblGoal = new JLabel("ACTIVITY");
		lblGoal.setFont(Constants.LOGINTEXT);
		lblGoal.setBounds(250, 600, 89, 23);
		mainPnl.add(lblGoal);
		
		JLabel lblGoal_2 = new JLabel("GOAL");
		lblGoal_2.setFont(Constants.LOGINTEXT);
		lblGoal_2.setBounds(250, 645, 63, 23);
		mainPnl.add(lblGoal_2);
		
		lblBMI = new JLabel("BMI: ");
		lblBMI.setFont(Constants.BUTTONTEXTBOLD);
		lblBMI.setBounds(250, 693, 128, 23);
		mainPnl.add(lblBMI);
		
		JRadioButton femaleButton = new JRadioButton("FEMALE");
		femaleButton.setBounds(386, 424, 77, 27);
		femaleButton.setActionCommand("female");
		femaleButton.setFont(Constants.PLAINTEXT);
		mainPnl.add(femaleButton);
		
		JRadioButton maleButton = new JRadioButton("MALE");
		maleButton.setBounds(470, 424, 63, 27);
		maleButton.setActionCommand("male");
		maleButton.setFont(Constants.PLAINTEXT);
		mainPnl.add(maleButton);
		
		genderGroup = new ButtonGroup();
		genderGroup.add(femaleButton);
		genderGroup.add(maleButton);
		
		activityBox = new JComboBox();
		activityBox.setBounds(386, 600, 363, 26);
		activityBox.setFont(Constants.PLAINTEXT);
		activityBox.setBackground(Constants.MAINBACKGROUND);
		String[] activities = new String[] { "", "Exclusively seated/lying activities",
				"Very often sedentary activities",
				"Predominantly sedentary activities",
				"Predominantly walking / standing activity", "Vigorous physical activity" };
		activityBox.setModel(new DefaultComboBoxModel(activities));
		mainPnl.add(activityBox);
		
		goalBox = new JComboBox();
		goalBox.setBounds(386, 645, 363, 26);
		goalBox.setFont(Constants.PLAINTEXT);
		goalBox.setBackground(Constants.MAINBACKGROUND);
		goalBox.setModel(new DefaultComboBoxModel(
				new String[] { "", "gain muscles", "muscle definition", "hold weight", "lose weight" }));
		mainPnl.add(goalBox);
		
		ageField = new JTextField();
		ageField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ageField.setColumns(10);
		ageField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		ageField.setBackground(SystemColor.menu);
		ageField.setBounds(386, 465, 147, 26);
		ageField.setDocument(new LengthRestrictedDocument(3));
		mainPnl.add(ageField);
		
		heightField = new JTextField();
		heightField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		heightField.setColumns(10);
		heightField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		heightField.setBackground(SystemColor.menu);
		heightField.setBounds(386, 510, 147, 26);
		heightField.setDocument(new LengthRestrictedDocument(3));
		mainPnl.add(heightField);
		
		weightField = new JTextField();
		weightField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		weightField.setColumns(10);
		weightField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		weightField.setBackground(SystemColor.menu);
		weightField.setBounds(386, 555, 147, 26);
		weightField.setDocument(new LengthRestrictedDocument(3));
		mainPnl.add(weightField);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(250, 408, 499, 1);
		mainPnl.add(separator_1);
		
		JPanel topPnl = new JPanel();
		topPnl.setPreferredSize(new Dimension(10, 30));
		topPnl.setBackground(Constants.DARKGREEN);
		parentPnl.add(topPnl, BorderLayout.NORTH);
		topPnl.setLayout(new BorderLayout(0, 0));
		
		JPanel titlePnl = new JPanel();
		titlePnl.setPreferredSize(new Dimension(250, 10));
		titlePnl.setBackground(Constants.DARKGREEN);
		topPnl.add(titlePnl, BorderLayout.WEST);
		
		JPanel actionPnl = new JPanel();
		actionPnl.setPreferredSize(new Dimension(50, 10));
		actionPnl.setBackground(Constants.DARKGREEN);
		topPnl.add(actionPnl, BorderLayout.EAST);
		
		JLabel currentWindowLbl = new JLabel(frame.getTitle());
		currentWindowLbl.setAutoscrolls(true);
		currentWindowLbl.setForeground(Constants.LIGHTGRAY);
		currentWindowLbl.setFont(Constants.PLAINTEXT);
		titlePnl.add(currentWindowLbl);
		
		URL minimizeIconPath = this.getClass().getResource("/resources/minimize.png");
		BufferedImage minimizeIcon = null;
		try {
			minimizeIcon = ImageIO.read(minimizeIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton minimizeBtn = new JButton(new ImageIcon(minimizeIcon));
		minimizeBtn.setForeground(Constants.LIGHTGRAY);
		minimizeBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		minimizeBtn.setFocusPainted(false);
		minimizeBtn.setBorderPainted(false);
		minimizeBtn.setBorder(null);
		minimizeBtn.setBackground(Constants.DARKGREEN);
		minimizeBtn.setFocusPainted(false);
		minimizeBtn.setContentAreaFilled(false);
		minimizeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setState(Frame.ICONIFIED);
			}
		});
		actionPnl.add(minimizeBtn, BorderLayout.EAST);
		
		URL closeIconPath = this.getClass().getResource("/resources/close.png");
		BufferedImage closeIcon = null;
		try {
			closeIcon = ImageIO.read(closeIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton closeBtn = new JButton(new ImageIcon(closeIcon));
		closeBtn.setForeground(Constants.LIGHTGRAY);
		closeBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		closeBtn.setFocusPainted(false);
		closeBtn.setBorderPainted(false);
		closeBtn.setBorder(null);
		closeBtn.setBackground(Constants.DARKGREEN);
		closeBtn.setFocusPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		actionPnl.add(closeBtn, BorderLayout.EAST);
		
		frame.setVisible(false);
		
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
	public static void hideFrame() {
		frame.setVisible(false);
	}
	
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
						MongoDBConnector.insertNutrients(inputs[0].toString(), nutritionalValues, names, nutrients);

						StartFrame mainFrame = new StartFrame();
						StartFrame.displayFrame();
						FoodsFrame foodRecommendationFrame = new FoodsFrame();
						SupplementFrame supplementsFrame = new SupplementFrame();
						MicronutrientsFrame microNutrientsFrame = new MicronutrientsFrame();
						WorkoutFrame workoutFrame = new WorkoutFrame();
						TrackingFrame trackingFrame = new TrackingFrame();
						PasswordFrame passwordFrame = new PasswordFrame();
						BodyDataFrame bodyDataFrame = new BodyDataFrame();

						isAlive = false;

					}
				} else {
					
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

			gender = genderGroup.getSelection().getActionCommand();
			goal = goalBox.getSelectedItem().toString();
			activity = activityBox.getSelectedItem().toString();
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
		gender = genderGroup.getSelection().getActionCommand();
		goal = goalBox.getSelectedItem().toString();
		age = Integer.parseInt(ageField.getText());
		height = Double.parseDouble(heightField.getText());
		weight = Double.parseDouble(weightField.getText());
		activity = activityBox.getSelectedItem().toString();

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
				lblBMI.setText("BMI: " + Math.round(newBMI));
				oldBMI = newBMI;
			}
		}
	}
}
