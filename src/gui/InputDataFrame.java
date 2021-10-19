package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import backend.Access;
import backend.MongoDBConnector;

public class InputDataFrame {

	public static JFrame frame;
	public static String gender = "";
	
	public InputDataFrame() {
		
	}
	/*
	public  userNameInput;
	public String passwordInput;
	
	public float height;
	public float weight;
	public Integer age;
	*/
	
	
	/*
	 * Was man noch hinzufügen könnte:
	 * Körpertyp? Ektomorph, Mesomorph, Endomorph
	 * Körperfettanteil
	 * Aktivität in der Woche (Sport)
	 * Aktivität im Alltag
	 */
	
	//Das Frame, in dem der/die Nutzer*in seine/ihre Körperdaten eingeben kann
	public InputDataFrame(final String title, final int width, final int height) {
		
		//Grundeinstellungen für das Frame
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
		
		//Der Name der App als Überschrift
		JLabel header = new JLabel("Clean Eat", SwingConstants.CENTER);
		header.setForeground(Color.white);
		header.setFont(new Font("Verdana", Font.BOLD, 60));
		
		/////////////////////////////////////////
		
		//Panel and Label for Login
		JPanel loginLabelPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		loginLabelPnl.setBackground(new Color(50, 72, 81));
		JLabel loginLabel = new JLabel("Benutzerdaten");
		loginLabel.setForeground(Color.white);
		loginLabel.setFont(new Font("Verdana", Font.BOLD, 24));
		loginLabelPnl.add(loginLabel);
		
		//Panel, Label and Textfield for username
		JPanel userNamePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		userNamePnl.setBackground(new Color(50, 72, 81));
		JLabel userName = new JLabel("Benutzername:");
		userName.setForeground(Color.white);
		JTextField userNameInput = new JTextField(25);
		userNamePnl.add(userName);
		userNamePnl.add(userNameInput);
		
		//Panel, Label and Textfield for password
		JPanel passwordPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		passwordPnl.setBackground(new Color(50, 72, 81));
		JLabel password = new JLabel("Passwort:");
		password.setForeground(Color.white);
		JTextField passwordInput = new JTextField(25);
		passwordPnl.add(password);
		passwordPnl.add(passwordInput);
		
		///////////////////////////////////
		
		//Panel with radiobuttons for gender selection
		JPanel genderPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		genderPnl.setBackground(new Color(50, 72, 81));
		JLabel genderLabel = new JLabel("Geschlecht");
		genderLabel.setForeground(Color.white);
		genderLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		JRadioButton maleButton = new JRadioButton("männlich");
		maleButton.setBackground(new Color(50, 72, 81));
		maleButton.setForeground(Color.white);
		
		maleButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(maleButton.isSelected()) {
					
					gender = "male";
					System.out.println(gender);
					
				}
				
			}
			
		});
		
		JRadioButton femaleButton = new JRadioButton("weiblich");
		femaleButton.setBackground(new Color(50, 72, 81));
		femaleButton.setForeground(Color.white);
		
		femaleButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if(femaleButton.isSelected()) {
					
					gender = "female";
					System.out.println(gender);
					
				}
				
			}
			
		});
		
		ButtonGroup genderButtons = new ButtonGroup();
		genderButtons.add(femaleButton);
		genderButtons.add(maleButton);
		genderPnl.add(genderLabel);
		genderPnl.add(maleButton);
		genderPnl.add(femaleButton);
		
		//Panel for height
		JPanel heightPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		heightPnl.setBackground(new Color(50, 72, 81));
		JLabel heightLabel = new JLabel("Größe");
		heightLabel.setForeground(Color.white);
		heightLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		JTextField heightTextField = new JTextField(5);
		heightTextField.setText("in cm");
		heightPnl.add(heightLabel);
		heightPnl.add(heightTextField);
		
		//Panel for weight
		JPanel weightPnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		weightPnl.setBackground(new Color(50, 72, 81));
		JLabel weightLabel = new JLabel("Gewicht");
		weightLabel.setForeground(Color.white);
		weightLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		JTextField weightTextField = new JTextField(5);
		weightTextField.setText("in kg");
		weightPnl.add(weightLabel);
		weightPnl.add(weightTextField);
		
		//Panel for age
		JPanel agePnl = new JPanel(new FlowLayout(FlowLayout.LEFT));
		agePnl.setBackground(new Color(50, 72, 81));
		JLabel ageLabel = new JLabel("Alter");
		ageLabel.setForeground(Color.white);
		ageLabel.setFont(new Font("Verdana", Font.BOLD, 18));
		JTextField ageTextField = new JTextField(5);
		agePnl.add(ageLabel);
		agePnl.add(ageTextField);
		
		//Button to submit data
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				// added by hamid can be deleted ////////////////////////////////////////
				//Access access = new Access(userNameInput.getText(), passwordInput.getText(), gender, weightTextField.getText(), heightTextField.getText(), ageTextField.getText());
				//access.toMap();
				//Access.toMap(userNameInput.getText(), passwordInput.getText(), gender.getText(), weightTextField, heightTextField, ageTextField.getText());
				MongoDBConnector mongoDBConnector = new MongoDBConnector(userNameInput.getText().toLowerCase(), passwordInput.getText(), gender, weightTextField.getText(), heightTextField.getText(), ageTextField.getText());
				mongoDBConnector.signUpUser();

				
				//MongoDBConnector.MongoDBConnector();

				
			}
			
		});
		
		JPanel borderPnl = new JPanel();
		//borderPnl.setLayout(new BoxLayout(borderPnl, BoxLayout.PAGE_AXIS));
		borderPnl.setLayout(new GridLayout(7, 1, 50, 20));
		borderPnl.setBorder(BorderFactory.createTitledBorder(null, "Körperdaten eingeben", TitledBorder.LEFT, TitledBorder.TOP, new Font("Verdana", Font.PLAIN, 12), Color.white));
		borderPnl.setBackground(new Color(50, 72, 81));
		borderPnl.add(userNamePnl);
		borderPnl.add(passwordPnl);
		borderPnl.add(genderPnl);
		borderPnl.add(heightPnl);
		borderPnl.add(weightPnl);
		borderPnl.add(agePnl);
		borderPnl.add(submitButton);
		borderPnl.setSize(frame.getWidth(), frame.getHeight());
		
		//Container (includes all elements)
		JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
		container.setBackground(new Color(50, 72, 81));
		container.add(borderPnl);
		
		contentPane.add(BorderLayout.PAGE_START, header);
		contentPane.add(BorderLayout.CENTER, container);
		frame.setContentPane(contentPane);
		
		frame = utils.update(frame);
		
	}
	
	
}
