package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import backend.MongoDBConnector;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Cursor;

public class LoginFrame {

	private static JFrame frame;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private String username = null;
	private String password;

	public LoginFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Login");
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
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setForeground(Constants.LIGHTGRAY);
		btnLogin.setFont(Constants.BUTTONTEXTBOLD);
		btnLogin.setFocusPainted(false);
		btnLogin.setBorderPainted(false);
		btnLogin.setBorder(null);
		btnLogin.setBackground(Constants.MIDGREEN);
		btnLogin.setBounds(35, 175, 83, 26);
		btnLogin.setEnabled(false);
		sidePnl.add(btnLogin);
		
		JLabel headingLbl = new JLabel("NutritionCalc");
		headingLbl.setBounds(35, 50, 195, 36);
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
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
		btnRegister.setForeground(Constants.LIGHTGRAY);
		btnRegister.setFont(Constants.BUTTONTEXTBOLD);
		btnRegister.setFocusPainted(false);
		btnRegister.setBorderPainted(false);
		btnRegister.setBorder(null);
		btnRegister.setBackground(Constants.MIDGREEN);
		btnRegister.setBounds(35, 215, 88, 26);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				RegisterFrame registerDevFrame = new RegisterFrame();
				registerDevFrame.start();
				RegisterFrame.displayFrame();
				
			}
		});
		sidePnl.add(btnRegister);
		
		JPanel mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		URL logoIconPath = this.getClass().getResource("/resources/logo.png");
		JLabel logo = new JLabel(new ImageIcon(logoIconPath));
		logo.setBounds(298, -5, 403, 247);
		mainPnl.add(logo);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(250, 318, 103, 26);
		lblUsername.setFont(Constants.LOGINTEXT);
		mainPnl.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(250, 301, 499, 15);
		mainPnl.add(separator);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblLogin.setBounds(250, 263, 103, 26);
		lblLogin.setFont(Constants.HEADING);
		mainPnl.add(lblLogin);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(Constants.LOGINTEXT);
		lblPassword.setBounds(250, 363, 107, 26);
		mainPnl.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(386, 364, 363, 26);
		passwordField.setFont(Constants.PLAINTEXT);
		passwordField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		passwordField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(passwordField);
		
		usernameField = new JTextField();
		usernameField.setBounds(386, 319, 363, 26);
		usernameField.setFont(Constants.PLAINTEXT);
		usernameField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		usernameField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(usernameField);
		usernameField.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(660, 428, 89, 23);
		btnSubmit.setFont(Constants.BUTTONTEXT);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		btnSubmit.setBackground(Constants.LIGHTGRAY);
		btnSubmit.addActionListener(new SubmitListener());
		mainPnl.add(btnSubmit);
		
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
		
		frame.setVisible(true);
		
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
	public static void hideFrame() {
		frame.setVisible(false);
	}
	
	class SubmitListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			try {
				String password = new String(passwordField.getPassword());
				if (inputValid()) {

					MongoDBConnector mongoDBConnector = new MongoDBConnector(usernameField.getText(), password);
					mongoDBConnector.logInUser();

				} else {
					JOptionPane.showMessageDialog(null,
							"Input Error... please try again!\r\nPassword should be at least 6 characters!", "ERROR",
							JOptionPane.ERROR_MESSAGE);
				}

			} catch (Exception e2) {
				frame.setVisible(false);
			}

		}

	}

	/*
	 * check whether the user input is valid
	 */
	private boolean inputValid() {
		try {
			username = usernameField.getText();
			password = new String(passwordField.getPassword());

			if (username != "" && password.length() > 5)
				return true;
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
}
