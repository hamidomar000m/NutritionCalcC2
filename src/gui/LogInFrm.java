package gui;



import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

import backend.MongoDBConnector;
import backend.NutritionCalculator;
import gui.SignUpFrame.SubmitListener;

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
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class LogInFrm extends Thread{

	public static JFrame frmLogIn;

	private JTextField userNameField;
	private JPasswordField PasswordField;

	
	private String username = null;
	private String password;

	
	private boolean isAlive;
	
	
	/**
	 * Create the application.
	 */
	public LogInFrm() {
		isAlive = true;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	public  void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setBackground(new Color(153, 204, 102));
		frmLogIn.getContentPane().setLayout(null);
		frmLogIn.setResizable(false);
		
		JTextPane txtpnRegistration = new JTextPane();
		txtpnRegistration.setEditable(false);
		txtpnRegistration.setBackground(new Color(154, 205, 50));
		txtpnRegistration.setForeground(new Color(0, 0, 0));
		txtpnRegistration.setFont(new Font("Arial rounded MT", Font.BOLD, 36));
		txtpnRegistration.setText("NutritionCalc");
		txtpnRegistration.setBounds(234, 10, 232, 51);
		frmLogIn.getContentPane().add(txtpnRegistration);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnUsername.setText("Username");
		txtpnUsername.setBounds(120, 75, 130, 30);
		frmLogIn.getContentPane().add(txtpnUsername);
		
		userNameField = new JTextField();
		userNameField.setColumns(10);
		userNameField.setBounds(290, 75, 290, 30);
		frmLogIn.getContentPane().add(userNameField);

		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password");
		txtpnPassword.setFont(new Font("Arial", Font.PLAIN, 16));
		txtpnPassword.setBounds(120, 115, 130, 30);
		frmLogIn.getContentPane().add(txtpnPassword);
		
		PasswordField = new JPasswordField();
		PasswordField.setColumns(10);
		PasswordField.setBounds(290, 115, 290, 30);
		frmLogIn.getContentPane().add(PasswordField);
	
		
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.addActionListener(new SubmitListener());
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(388, 168, 190, 35);
		frmLogIn.getContentPane().add(btnNewButton);

		
		JLabel registryLabel = new JLabel("Aren´t registered yet? Click on Register");
		registryLabel.setForeground(Color.white);
		registryLabel.setBounds(125, 208, 250, 35);
		frmLogIn.getContentPane().add(registryLabel);
		
		JButton btnRegisterButton = new JButton("Register");
		btnRegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		//btnRegisterButton.addActionListener(new SubmitListener());
		btnRegisterButton.setBackground(Color.GRAY);
		btnRegisterButton.setBounds(488, 208, 90, 35);
		frmLogIn.getContentPane().add(btnRegisterButton);
		btnRegisterButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				SignUpFrame signUpFrame = new SignUpFrame();
				signUpFrame.start();
				frmLogIn.setVisible(false);
			}
		});
		
		frmLogIn.setSize(700, 300);
		frmLogIn.setLocationRelativeTo(null);
		frmLogIn.setVisible(true);
	}

	
	/*
	 * define the class SubmitListener which is needed for the Submit button
	 */
	class SubmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			try {
				String password = new String(PasswordField.getPassword());
				if(inputValid()) {

					MongoDBConnector mongoDBConnector = new MongoDBConnector(userNameField.getText().toLowerCase(), password);
					mongoDBConnector.logInUser();
					
					

				}
				else {
					JOptionPane.showMessageDialog(null, "Input Error... please try again!\r\nPassword should be at least 6 characters!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				
			} catch (Exception e2) {
				frmLogIn.setVisible(false);
			}

		}
		
	}
	
	
	
	/*
	 * check whether the user input is valid
	 */
	private boolean inputValid() {
		try {
			username = userNameField.getText().toLowerCase();
			password = new String(PasswordField.getPassword());

			
			if(username != "" && password.length() > 5 )
				return true;
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	
}



