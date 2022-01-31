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
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.SystemColor;

public class RegisterFrame {

	private static JFrame frame;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField ageField;
	private JTextField heightField;
	private JTextField WeightField;
	
	public RegisterFrame() {
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
		lblLogin.setBounds(250, 262, 189, 36);
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
		
		textField = new JTextField();
		textField.setBounds(386, 318, 363, 26);
		textField.setFont(Constants.PLAINTEXT);
		textField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		textField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(660, 693, 89, 23);
		btnSubmit.setFont(Constants.BUTTONTEXT);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		btnSubmit.setBackground(Constants.LIGHTGRAY);
		mainPnl.add(btnSubmit);
		
		JLabel lblGender = new JLabel("GENDER");
		lblGender.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblGender.setBounds(250, 420, 72, 23);
		mainPnl.add(lblGender);
		
		JLabel lblAge = new JLabel("AGE");
		lblAge.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblAge.setBounds(250, 465, 38, 23);
		mainPnl.add(lblAge);
		
		JLabel lblHeight = new JLabel("HEIGHT (cm)");
		lblHeight.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblHeight.setBounds(250, 510, 107, 23);
		mainPnl.add(lblHeight);
		
		JLabel lblWeightkg = new JLabel("WEIGHT (kg)");
		lblWeightkg.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblWeightkg.setBounds(250, 555, 107, 23);
		mainPnl.add(lblWeightkg);
		
		JLabel lblGoal = new JLabel("ACTIVITY");
		lblGoal.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblGoal.setBounds(250, 600, 89, 23);
		mainPnl.add(lblGoal);
		
		JLabel lblGoal_2 = new JLabel("GOAL");
		lblGoal_2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblGoal_2.setBounds(250, 645, 52, 23);
		mainPnl.add(lblGoal_2);
		
		JRadioButton femaleButton = new JRadioButton("FEMALE");
		femaleButton.setBounds(386, 424, 77, 27);
		femaleButton.setFont(Constants.PLAINTEXT);
		mainPnl.add(femaleButton);
		
		JRadioButton maleButton = new JRadioButton("MALE");
		maleButton.setBounds(470, 424, 63, 27);
		maleButton.setFont(Constants.PLAINTEXT);
		mainPnl.add(maleButton);
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(femaleButton);
		genderGroup.add(maleButton);
		
		JComboBox activityBox = new JComboBox();
		activityBox.setBounds(386, 600, 363, 26);
		activityBox.setFont(Constants.PLAINTEXT);
		activityBox.setBackground(Constants.MAINBACKGROUND);
		String[] activities = new String[] { "", "Exclusively seated/lying activities",
				"Very often sedentary activities",
				"Predominantly sedentary activities",
				"Predominantly walking / standing activity", "Vigorous physical activity" };
		activityBox.setModel(new DefaultComboBoxModel(activities));
		mainPnl.add(activityBox);
		
		JComboBox goalBox = new JComboBox();
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
		mainPnl.add(ageField);
		
		heightField = new JTextField();
		heightField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		heightField.setColumns(10);
		heightField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		heightField.setBackground(SystemColor.menu);
		heightField.setBounds(386, 510, 147, 26);
		mainPnl.add(heightField);
		
		WeightField = new JTextField();
		WeightField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		WeightField.setColumns(10);
		WeightField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		WeightField.setBackground(SystemColor.menu);
		WeightField.setBounds(386, 555, 147, 26);
		mainPnl.add(WeightField);
		
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
}
