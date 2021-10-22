package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class LoginFrame {
	
	private JFrame frame;
	
	public LoginFrame(final String title, final int width, final int height) {
		
		//Grundeinstellungen f�r das Frame zum Login
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.getContentPane().setBackground(new Color(50, 72, 81));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Content Pane for frame
		JPanel contentPane = new JPanel();
		contentPane.setBackground(new Color(50, 72, 81));
		contentPane.setLayout(new BorderLayout(10, 50));
		
		//Der Name der App als �berschrift
		JLabel appName = new JLabel("Clean Eat", SwingConstants.CENTER);
		appName.setForeground(Color.white);
		appName.setFont(new Font("Verdana", Font.BOLD, 60));
		
		//Panel and Label for Login
		JPanel loginLabelPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		loginLabelPnl.setBackground(new Color(50, 72, 81));
		JLabel loginLabel = new JLabel("Benutzerdaten");
		loginLabel.setForeground(Color.white);
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		loginLabelPnl.add(loginLabel);
		
		//Panel, Label and Textfield for username
		JPanel userNamePnl = new JPanel(new FlowLayout());
		userNamePnl.setBackground(new Color(50, 72, 81));
		JLabel userName = new JLabel("Benutzername:");
		userName.setForeground(Color.white);
		JTextField userNameInput = new JTextField(25);
		userNamePnl.add(userName);
		userNamePnl.add(userNameInput);
		
		//Panel, Label and Textfield for password
		JPanel passwordPnl = new JPanel(new FlowLayout());
		passwordPnl.setBackground(new Color(50, 72, 81));
		JLabel password = new JLabel("Passwort:");
		password.setForeground(Color.white);
		JTextField passwordInput = new JTextField(25);
		passwordPnl.add(password);
		passwordPnl.add(passwordInput);
		
		//Button to submit login data
		JButton loginButton = new JButton("Login");
		
		//Registry Button
		JPanel registryButtonPnl = new JPanel(new FlowLayout());
		registryButtonPnl.setBackground(new Color(50, 72, 81));
		JLabel registryLabel = new JLabel("Aren�t registered yet? Click here");
		registryLabel.setForeground(Color.white);
		JButton registryButton = new JButton("Register");
		registryButtonPnl.add(registryLabel);
		registryButtonPnl.add(registryButton);
		
		//Panel for creating two rows as a layout and adding all components
		JPanel borderPnl = new JPanel();
		//borderPnl.setLayout(new BoxLayout(borderPnl, BoxLayout.PAGE_AXIS));
		borderPnl.setLayout(new GridLayout(5, 1));
		borderPnl.setBorder(BorderFactory.createTitledBorder(null, "Anmelden", TitledBorder.LEFT, TitledBorder.TOP, new Font("Verdana", Font.PLAIN, 12), Color.white));
		borderPnl.setBackground(new Color(50, 72, 81));
		borderPnl.add(loginLabelPnl);
		borderPnl.add(userNamePnl);
		borderPnl.add(passwordPnl);
		borderPnl.add(loginButton);
		borderPnl.add(registryButtonPnl);
		
		//Container (includes all elements)
		JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
		container.setBackground(new Color(50, 72, 81));
		container.add(borderPnl);
		
		contentPane.add(BorderLayout.PAGE_START, appName);
		contentPane.add(BorderLayout.CENTER, container);
		frame.setContentPane(contentPane);
		
		frame = utils.update(frame);
		
	}
	
}
