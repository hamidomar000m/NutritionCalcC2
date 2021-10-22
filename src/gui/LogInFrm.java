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

public class LogInFrm extends Thread{

	public JFrame frmLogIn;
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

	
	//private boolean isAlive;
	
	
	/**
	 * Create the application.
	 */
	public LogInFrm() {
		//isAlive = true;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogIn = new JFrame();
		frmLogIn.setTitle("Log In");
		frmLogIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogIn.getContentPane().setBackground(new Color(153, 204, 102));
		frmLogIn.getContentPane().setLayout(null);
		frmLogIn.setResizable(false);
		
		JTextPane txtpnRegistration = new JTextPane();
		txtpnRegistration.setEditable(false);
		txtpnRegistration.setBackground(Color.WHITE);
		txtpnRegistration.setForeground(new Color(153, 204, 102));
		txtpnRegistration.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		txtpnRegistration.setText("NutritionCalc");
		txtpnRegistration.setBounds(282, 20, 130, 31);
		frmLogIn.getContentPane().add(txtpnRegistration);
		
		JTextPane txtpnUsername = new JTextPane();
		txtpnUsername.setEditable(false);
		txtpnUsername.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnUsername.setText("Username");
		txtpnUsername.setBounds(120, 75, 130, 30);
		frmLogIn.getContentPane().add(txtpnUsername);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(290, 75, 290, 30);
		frmLogIn.getContentPane().add(textField_3);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setEditable(false);
		txtpnPassword.setText("Password");
		txtpnPassword.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		txtpnPassword.setBounds(120, 115, 130, 30);
		frmLogIn.getContentPane().add(txtpnPassword);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(290, 115, 290, 30);
		frmLogIn.getContentPane().add(textField_4);
		
		
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
				//signUpFrame.frmDataCollection.setVisible(true);
				//LogInFrm loginFrm = new LogInFrm();
				//loginFrm.frmLogIn.setVisible(false);
				//loginFrm.frmLogIn.dispose();

				
			}
			
		});
		
		frmLogIn.setSize(700, 350);
		frmLogIn.setLocationRelativeTo(null);
		frmLogIn.setVisible(true);
	}
	
	/*
	 * define the class SubmitListener which is needed for the Submit button
	 */
	class SubmitListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) {
			if(inputValid()) {

				MongoDBConnector mongoDBConnector = new MongoDBConnector(textField_3.getText().toLowerCase(), textField_4.getText());
				mongoDBConnector.logInUser();

				//frmLogIn.dispose();
				//isAlive = false;
			}
			else {
				JOptionPane.showMessageDialog(null, "Input Error... please try again!\r\nPassword should be at least 6 characters!", "ERROR", JOptionPane.ERROR_MESSAGE);
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

			
			if(username != "" && password.length() > 5 )
				return true;
			return false;
		}catch(Exception e) {
			return false;
		}
	}
	
}



