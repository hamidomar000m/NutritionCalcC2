package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;

import backend.MongoDBConnector;
import javax.swing.JComboBox;

public class SettingsFrame {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String userName;
	private boolean isVisiblePw = false;
	private boolean isVisibleBd = false;
	private JTextField newValueTxt;

	public SettingsFrame(final String _id) {
		this.userName = _id;
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblHeading = new JLabel("Settings");
		lblHeading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		lblHeading.setBounds(125, 36, 146, 43);
		frame.getContentPane().add(lblHeading);
		
		JLabel lblNewLabel = new JLabel("user data");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 109, 84, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter new password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 248, 114, 14);
		lblNewLabel_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(38, 273, 212, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("confirm new password");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(38, 320, 126, 14);
		lblNewLabel_1_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 343, 212, 31);
		textField_1.setVisible(false);
		frame.getContentPane().add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "gender", "weight", "height", "age", "goal", "activity" }));
		comboBox.setBounds(38, 273, 233, 31);
		comboBox.setVisible(false);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(38, 345, 348, 31);
		comboBox_1.setVisible(false);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Which data would you like to change?");
		lblNewLabel_2.setBounds(38, 248, 233, 14);
		lblNewLabel_2.setVisible(false);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("enter new value");
		lblNewLabel_3.setBounds(38, 320, 137, 14);
		lblNewLabel_3.setVisible(false);
		frame.getContentPane().add(lblNewLabel_3);
		
		newValueTxt = new JTextField();
		newValueTxt.setBounds(38, 345, 212, 29);
		newValueTxt.setVisible(false);
		frame.getContentPane().add(newValueTxt);
		newValueTxt.setColumns(10);
		
		JButton submitPwBtn = new JButton("Submit");
		submitPwBtn.setBounds(38, 385, 89, 23);
		submitPwBtn.setVisible(false);
		submitPwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					String newPassword = textField.getText();
					String confirmedPassword = textField_1.getText();

					if(newPassword.equals("")) {
						JOptionPane.showMessageDialog(null, "Password can't be empty! ", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					if(newPassword.length() <= 5 && !newPassword.equals("")) {
						JOptionPane.showMessageDialog(null, "Password must contain at least 6 characters! ", "INFO", JOptionPane.ERROR_MESSAGE);
					}
					
					if(newPassword.equals(confirmedPassword) && newPassword.length() >= 6) {
						//change password in database
						MongoDBConnector.changePassword(userName, newPassword);
						JOptionPane.showMessageDialog(null, "Successfully changed your password to " + newPassword, "INFO", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} catch(Exception ex) {
					
				}
				
				
			}
			
		});
		System.out.println("Test");
		frame.getContentPane().add(submitPwBtn);
		
		JButton submitBdBtn = new JButton("Submit");
		submitBdBtn.setBounds(38, 385, 89, 23);
		submitBdBtn.setVisible(false);
		submitBdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(comboBox.getSelectedItem().toString().equals("weight")) {

					String newValue = newValueTxt.getText();
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Weight");
						
						if(!newValue.equals("") && isNumeric(newValue) && !newValue.equals(oldValue)) {
							MongoDBConnector.changeValue(userName, "userWeight", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your weight to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
						} else {
							JOptionPane.showMessageDialog(null, "Value must be valid and is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(comboBox.getSelectedItem().toString().equals("height")) {

					String newValue = newValueTxt.getText();
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Height");
						
						if(!newValue.equals("") && isNumeric(newValue) && !newValue.equals(oldValue)) {
							MongoDBConnector.changeValue(userName, "userHeight", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your height to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
						} else {
							JOptionPane.showMessageDialog(null, "Value must be valid and is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(comboBox.getSelectedItem().toString().equals("age")) {

					String newValue = newValueTxt.getText();
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Age");
						
						if(!newValue.equals("") && isNumeric(newValue) && !newValue.equals(oldValue)) {
							MongoDBConnector.changeValue(userName, "userAge", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your age to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
						} else {
							JOptionPane.showMessageDialog(null, "Value must be valid and is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(comboBox.getSelectedItem().toString().equals("gender")) {

					String newValue = comboBox_1.getSelectedItem().toString();
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Gender");
						
						if(!newValue.equals(oldValue)) {
							
							MongoDBConnector.changeValue(userName, "userGender", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your gender to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
							
						} else {
							JOptionPane.showMessageDialog(null, "Value is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(comboBox.getSelectedItem().toString().equals("goal")) {

					String newValue = comboBox_1.getSelectedItem().toString();
					
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Goal");
						
						if(!newValue.equals(oldValue)) {
							
							MongoDBConnector.changeValue(userName, "userGoal", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your goal to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
							//if the goal changes, the supplements have to be reloaded again
							SupplementsFrame reloadedSupFrame = new SupplementsFrame(userName);
							
						} else {
							JOptionPane.showMessageDialog(null, "Value is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(comboBox.getSelectedItem().toString().equals("activity")) {

					String newValue = comboBox_1.getSelectedItem().toString();
					
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Activity");
						
						if(!newValue.equals(oldValue)) {
							
							MongoDBConnector.changeValue(userName, "userActivity", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your activity to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
							
						} else {
							JOptionPane.showMessageDialog(null, "Value is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
					} catch (Exception e2) {
						
					}
					
				}
				
				comboBox.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblNewLabel_3.setVisible(false);
				comboBox_1.setVisible(false);
				submitBdBtn.setVisible(false);
				newValueTxt.setVisible(false);
				isVisibleBd = false;
				
			}
		});
		frame.getContentPane().add(submitBdBtn);
		
		JButton pwBtn = new JButton("change password");
		pwBtn.setBounds(117, 141, 162, 31);
		pwBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!isVisiblePw) {
					
					lblNewLabel_1.setVisible(true);
					textField.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
					textField_1.setVisible(true);
					submitPwBtn.setVisible(true);
					
					comboBox.setVisible(false);
					lblNewLabel_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
					comboBox_1.setVisible(false);
					submitBdBtn.setVisible(false);
					
					isVisibleBd = false;
					isVisiblePw = true;
					
				} else {
					
					lblNewLabel_1.setVisible(false);
					textField.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					textField_1.setVisible(false);
					submitPwBtn.setVisible(false);
					
					isVisiblePw = false;
					
				}
				
			}
		});
		frame.getContentPane().add(pwBtn);
		
		JButton btnKrperdatenAktualisieren = new JButton("refresh body data");
		btnKrperdatenAktualisieren.setBounds(117, 183, 162, 31);
		btnKrperdatenAktualisieren.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(!isVisibleBd) {
					
					comboBox.setVisible(true);
					lblNewLabel_2.setVisible(true);
					comboBox_1.setVisible(true);
					lblNewLabel_3.setVisible(true);
					submitBdBtn.setVisible(true);
				
					lblNewLabel_1.setVisible(false);
					textField.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					textField_1.setVisible(false);
					submitPwBtn.setVisible(false);
					
					isVisiblePw = false;
					isVisibleBd = true;
					
				} else {
					
					comboBox.setVisible(false);
					lblNewLabel_2.setVisible(false);
					lblNewLabel_3.setVisible(false);
					comboBox_1.setVisible(false);
					submitBdBtn.setVisible(false);
					
					isVisibleBd = false;
					
				}
				
			}
			
		});
		frame.getContentPane().add(btnKrperdatenAktualisieren);
		
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(comboBox.getSelectedItem().toString().equals("weight")) {
					comboBox_1.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(comboBox.getSelectedItem().toString().equals("height")) {
					comboBox_1.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(comboBox.getSelectedItem().toString().equals("age")) {
					comboBox_1.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(comboBox.getSelectedItem().toString().equals("gender")) {
					comboBox_1.setVisible(true);
					newValueTxt.setVisible(false);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "male", "female"}));
				}
				
				if(comboBox.getSelectedItem().toString().equals("goal")) {
					comboBox_1.setVisible(true);
					newValueTxt.setVisible(false);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "gain muscles", "muscle definition", "hold weight", "lose weight"}));
				}
				
				if(comboBox.getSelectedItem().toString().equals("activity")) {
					comboBox_1.setVisible(true);
					newValueTxt.setVisible(false);
					comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "Exclusively seated/lying activities",
							"Almost exclusively sedentary activities, almost no physical leisure activities",
							"Predominantly sedentary activities, occasional standing/walking activity",
							"Predominantly walking / standing activity", "Vigorous physical activity"}));
				}
				
			}
		});
		
		JButton deleteBtn = new JButton("delete account");
		deleteBtn.setBounds(237, 622, 126, 23);
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			    int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Delete Account", JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	MongoDBConnector.deleteAccount(userName);
			    	MongoDBConnector.deleteNutrients(userName);
			        System.exit(0);
			    }
				
			}
			
		});
		frame.getContentPane().add(deleteBtn);
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				//Reloading frame
				MainFrame.frame.dispose();
				MainFrame reloadedMainFrame = new MainFrame(userName);
				reloadedMainFrame.frame.setVisible(true);
				
				MicronutrientsFrame.frame.dispose();
				MicronutrientsFrame reloadedMicronutrientsFrame = new MicronutrientsFrame(userName);
				
			}
			
		});
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(false);
		
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
	public static boolean isNumeric(String str) {
		
		try {  
			
			Double.parseDouble(str);  
		    return true;
		    
		} catch(NumberFormatException e){  
		    return false;  
		  }  
		
	}
	
}
