package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import backend.MongoDBConnector;

public class SettingFrame {

	private static JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private String userName;
	private boolean isVisiblePw = false;
	private boolean isVisibleBd = false;
	private JTextField newValueTxt;

	public SettingFrame() {
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
		headingLbl.setBounds(35, 50, 190, 36);
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
		
		JButton btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Constants.LIGHTGRAY);
		btnHome.setFont(Constants.BUTTONTEXT);
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(Constants.MIDGREEN);
		btnHome.setBounds(35, 175, 73, 23);
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

			@Override
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
		supBtn.setBounds(35, 255, 138, 23);
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
		btnWorkout.setBounds(35, 295, 95, 23);
		btnWorkout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				WorkoutFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(btnWorkout);
		
		JButton btnTracking = new JButton("Tracking");
		btnTracking.setHorizontalAlignment(SwingConstants.LEFT);
		btnTracking.setForeground(Constants.LIGHTGRAY);
		btnTracking.setFont(Constants.BUTTONTEXT);
		btnTracking.setFocusPainted(false);
		btnTracking.setBorderPainted(false);
		btnTracking.setBorder(null);
		btnTracking.setBackground(Constants.MIDGREEN);
		btnTracking.setBounds(35, 335, 95, 23);
		btnTracking.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				TrackingFrame.displayFrame();
				
			}
			
		});
		sidePnl.add(btnTracking);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.setHorizontalAlignment(SwingConstants.LEFT);
		btnSettings.setForeground(Constants.LIGHTGRAY);
		btnSettings.setFont(Constants.BUTTONTEXTBOLD);
		btnSettings.setFocusPainted(false);
		btnSettings.setBorderPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setBackground(Constants.MIDGREEN);
		btnSettings.setBounds(35, 600, 95, 26);
		btnSettings.setEnabled(false);
		sidePnl.add(btnSettings);
		
		JButton passwordBtn = new JButton("Change password");
		passwordBtn.setHorizontalAlignment(SwingConstants.LEFT);
		passwordBtn.setForeground(Constants.LIGHTGRAY);
		passwordBtn.setFont(Constants.BUTTONTEXT2);
		passwordBtn.setFocusPainted(false);
		passwordBtn.setBorderPainted(false);
		passwordBtn.setBorder(null);
		passwordBtn.setBackground(Constants.MIDGREEN);
		passwordBtn.setBounds(60, 632, 153, 21);
		sidePnl.add(passwordBtn);
		
		JButton bodydataBtn = new JButton("Change body data");
		bodydataBtn.setHorizontalAlignment(SwingConstants.LEFT);
		bodydataBtn.setForeground(Constants.LIGHTGRAY);
		bodydataBtn.setFont(Constants.BUTTONTEXT2);
		bodydataBtn.setFocusPainted(false);
		bodydataBtn.setBorderPainted(false);
		bodydataBtn.setBorder(null);
		bodydataBtn.setBackground(Constants.MIDGREEN);
		bodydataBtn.setBounds(60, 664, 165, 21);
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
		
		JPanel mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("user data");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 109, 84, 21);
		mainPnl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter new password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 248, 114, 14);
		lblNewLabel_1.setVisible(false);
		mainPnl.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(38, 273, 212, 31);
		mainPnl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("confirm new password");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(38, 320, 126, 14);
		lblNewLabel_1_1.setVisible(false);
		mainPnl.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 343, 212, 31);
		textField_1.setVisible(false);
		mainPnl.add(textField_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "", "gender", "weight", "height", "age", "goal", "activity" }));
		comboBox.setBounds(38, 273, 233, 31);
		comboBox.setVisible(false);
		mainPnl.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(38, 345, 348, 31);
		comboBox_1.setVisible(false);
		mainPnl.add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel("Which data would you like to change?");
		lblNewLabel_2.setBounds(38, 248, 233, 14);
		lblNewLabel_2.setVisible(false);
		mainPnl.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("enter new value");
		lblNewLabel_3.setBounds(38, 320, 137, 14);
		lblNewLabel_3.setVisible(false);
		mainPnl.add(lblNewLabel_3);
		
		newValueTxt = new JTextField();
		newValueTxt.setBounds(38, 345, 212, 29);
		newValueTxt.setVisible(false);
		mainPnl.add(newValueTxt);
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
		mainPnl.add(submitPwBtn);
		
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
		mainPnl.add(submitBdBtn);
		
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
		mainPnl.add(pwBtn);
		
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
		mainPnl.add(btnKrperdatenAktualisieren);
		
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
		mainPnl.add(deleteBtn);
		
		frame.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				//Reloading frame
				MainFrame.frame.dispose();
				MainFrame reloadedMainFrame = new MainFrame(userName);
				reloadedMainFrame.frame.setVisible(true);
				
				MicronutrientsFrame.frame.dispose();
				MicronutrientsFrame reloadedMicronutrientsFrame = new MicronutrientsFrame();
				
			}
			
		});
		
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
