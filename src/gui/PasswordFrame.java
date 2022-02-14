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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backend.MongoDBConnector;

import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class PasswordFrame {

	private static JFrame frame;
	private JPasswordField rePasswordField;
	private JPasswordField passwordField;

	public PasswordFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Settings");
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
		
		JLabel headingLbl = new JLabel("NutritionCalc");
		headingLbl.setBounds(35, 50, 194, 36);
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
		
		JButton passwordBtn = new JButton("Change password");
		passwordBtn.setHorizontalAlignment(SwingConstants.LEFT);
		passwordBtn.setForeground(Constants.LIGHTGRAY);
		passwordBtn.setFont(Constants.BUTTONTEXTBOLD2);
		passwordBtn.setFocusPainted(false);
		passwordBtn.setBorderPainted(false);
		passwordBtn.setBorder(null);
		passwordBtn.setBackground(Constants.MIDGREEN);
		passwordBtn.setBounds(60, 632, 169, 21);
		passwordBtn.setEnabled(false);
		sidePnl.add(passwordBtn);
		
		JButton bodydataBtn = new JButton("Change body data");
		bodydataBtn.setHorizontalAlignment(SwingConstants.LEFT);
		bodydataBtn.setForeground(Constants.LIGHTGRAY);
		bodydataBtn.setFont(Constants.BUTTONTEXT2);
		bodydataBtn.setFocusPainted(false);
		bodydataBtn.setBorderPainted(false);
		bodydataBtn.setBorder(null);
		bodydataBtn.setBackground(Constants.MIDGREEN);
		bodydataBtn.setBounds(60, 664, 169, 21);
		bodydataBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				BodyDataFrame.displayFrame();
				
			}
		});
		sidePnl.add(bodydataBtn);
		
		JButton deleteAccBtn = new JButton("Delete account");
		deleteAccBtn.setHorizontalAlignment(SwingConstants.LEFT);
		deleteAccBtn.setForeground(Constants.LIGHTGRAY);
		deleteAccBtn.setFont(Constants.BUTTONTEXT2);
		deleteAccBtn.setFocusPainted(false);
		deleteAccBtn.setBorderPainted(false);
		deleteAccBtn.setBorder(null);
		deleteAccBtn.setBackground(Constants.MIDGREEN);
		deleteAccBtn.setBounds(60, 696, 138, 21);
		sidePnl.add(deleteAccBtn);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setHorizontalAlignment(SwingConstants.LEFT);
		btnSettings.setForeground(Constants.LIGHTGRAY);
		btnSettings.setFont(Constants.BUTTONTEXTBOLD);
		btnSettings.setFocusPainted(false);
		btnSettings.setBorderPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setBackground(Constants.MIDGREEN);
		btnSettings.setBounds(35, 600, 84, 23);
		btnSettings.setEnabled(false);
		sidePnl.add(btnSettings);
		
		JButton btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Constants.LIGHTGRAY);
		btnHome.setFont(Constants.BUTTONTEXT);
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(Constants.MIDGREEN);
		btnHome.setBounds(35, 175, 61, 23);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				StartFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(btnHome);
		
		JButton foodRecBtn = new JButton("Food");
		foodRecBtn.setHorizontalAlignment(SwingConstants.LEFT);
		foodRecBtn.setFocusPainted(false);
		foodRecBtn.setBorderPainted(false);
		foodRecBtn.setBorder(null);
		foodRecBtn.setBackground(Constants.MIDGREEN);
		foodRecBtn.setForeground(Constants.LIGHTGRAY);
		foodRecBtn.setFont(Constants.BUTTONTEXT);
		foodRecBtn.setBounds(35, 215, 61, 23);
		foodRecBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				FoodsFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(foodRecBtn);
		
		JButton supBtn = new JButton("Supplements");
		supBtn.setHorizontalAlignment(SwingConstants.LEFT);
		supBtn.setForeground(Constants.LIGHTGRAY);
		supBtn.setFont(Constants.BUTTONTEXT);
		supBtn.setFocusPainted(false);
		supBtn.setBorderPainted(false);
		supBtn.setBorder(null);
		supBtn.setBackground(Constants.MIDGREEN);
		supBtn.setBounds(35, 255, 126, 23);
		supBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				SupplementFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(supBtn);
		
		JButton btnWorkout = new JButton("Workout");
		btnWorkout.setHorizontalAlignment(SwingConstants.LEFT);
		btnWorkout.setForeground(Constants.LIGHTGRAY);
		btnWorkout.setFont(Constants.BUTTONTEXT);
		btnWorkout.setFocusPainted(false);
		btnWorkout.setBorderPainted(false);
		btnWorkout.setBorder(null);
		btnWorkout.setBackground(Constants.MIDGREEN);
		btnWorkout.setBounds(35, 295, 84, 26);
		btnWorkout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				WorkoutFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(btnWorkout);
		sidePnl.add(btnWorkout);
		
		JButton btnTracking = new JButton("Tracking");
		btnTracking.setHorizontalAlignment(SwingConstants.LEFT);
		btnTracking.setForeground(Constants.LIGHTGRAY);
		btnTracking.setFont(Constants.BUTTONTEXT);
		btnTracking.setFocusPainted(false);
		btnTracking.setBorderPainted(false);
		btnTracking.setBorder(null);
		btnTracking.setBackground(Constants.MIDGREEN);
		btnTracking.setBounds(35, 335, 84, 23);
		btnTracking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				TrackingFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(btnTracking);
		
		JPanel mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		JLabel lblUsername = new JLabel("NEW PASSWORD");
		lblUsername.setBounds(250, 318, 141, 23);
		lblUsername.setFont(Constants.LOGINTEXT);
		mainPnl.add(lblUsername);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(250, 301, 499, 15);
		mainPnl.add(separator);
		
		JLabel lblLogin = new JLabel("CHANGE PASSWORD");
		lblLogin.setBounds(250, 263, 279, 36);
		lblLogin.setFont(Constants.HEADING);
		mainPnl.add(lblLogin);
		
		JLabel lblPassword = new JLabel("REPEAT");
		lblPassword.setFont(Constants.LOGINTEXT);
		lblPassword.setBounds(250, 363, 107, 26);
		mainPnl.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		passwordField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		passwordField.setBackground(SystemColor.menu);
		passwordField.setBounds(405, 319, 344, 26);
		mainPnl.add(passwordField);
		
		rePasswordField = new JPasswordField();
		rePasswordField.setBounds(405, 364, 344, 26);
		rePasswordField.setFont(Constants.PLAINTEXT);
		rePasswordField.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		rePasswordField.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(rePasswordField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(660, 428, 89, 23);
		btnSubmit.setFont(Constants.BUTTONTEXT);
		btnSubmit.setFocusPainted(false);
		btnSubmit.setBorder(BorderFactory.createLineBorder(Constants.DARKGRAY, 1));
		btnSubmit.setBackground(Constants.LIGHTGRAY);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String newPassword = String.valueOf(passwordField.getPassword());
					String confirmedPassword = String.valueOf(rePasswordField.getPassword());

					if(newPassword.equals("")) {
						JOptionPane.showMessageDialog(null, "Password can't be empty! ", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					if(newPassword.length() <= 5 && !newPassword.equals("")) {
						JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters! ", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					if(!newPassword.equals(confirmedPassword)) {
						JOptionPane.showMessageDialog(null, "The given passwords are not equal!", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					if(newPassword.equals(confirmedPassword) && newPassword.length() >= 6) {
						//change password in database
						MongoDBConnector.changePassword(MongoDBConnector._id, newPassword);
						JOptionPane.showMessageDialog(null, "Successfully changed your password to " + newPassword, "INFO", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch(Exception ex) {
					
				}
				
			}
			
		});
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
		
		JLabel currentWindowLbl = new JLabel(this.frame.getTitle());
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
