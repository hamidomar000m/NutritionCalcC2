package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class InputDataFrame {

	private JFrame frame;
	
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
					
					final String gender = "male";
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
					
					final String gender = "female";
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
				
				double userHeight = Double.parseDouble(heightTextField.getText());
				double weight = Double.parseDouble(weightTextField.getText());
				int age = Integer.parseInt(ageTextField.getText());
				
				System.out.println(userHeight+ " " + weight + " " + age);
				
			}
			
		});
		
		JPanel borderPnl = new JPanel();
		//borderPnl.setLayout(new BoxLayout(borderPnl, BoxLayout.PAGE_AXIS));
		borderPnl.setLayout(new GridLayout(5, 1, 50, 20));
		borderPnl.setBorder(BorderFactory.createTitledBorder(null, "Körperdaten eingeben", TitledBorder.LEFT, TitledBorder.TOP, new Font("Verdana", Font.PLAIN, 12), Color.white));
		borderPnl.setBackground(new Color(50, 72, 81));
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
