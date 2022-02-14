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

import javax.swing.JSeparator;
import java.awt.Color;

public class BodyDataFrame {

	private static JFrame frame;
	private JTextField newValueTxt;
	private final String userName = MongoDBConnector._id;

	public BodyDataFrame() {
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
		headingLbl.setBounds(35, 50, 188, 36);
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
		passwordBtn.setFont(Constants.BUTTONTEXT2);
		passwordBtn.setFocusPainted(false);
		passwordBtn.setBorderPainted(false);
		passwordBtn.setBorder(null);
		passwordBtn.setBackground(Constants.MIDGREEN);
		passwordBtn.setBounds(60, 632, 169, 21);
		passwordBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				PasswordFrame.displayFrame();
				
			}
		});
		sidePnl.add(passwordBtn);
		
		JButton bodydataBtn = new JButton("Change body data");
		bodydataBtn.setHorizontalAlignment(SwingConstants.LEFT);
		bodydataBtn.setForeground(Constants.LIGHTGRAY);
		bodydataBtn.setFont(Constants.BUTTONTEXTBOLD2);
		bodydataBtn.setFocusPainted(false);
		bodydataBtn.setBorderPainted(false);
		bodydataBtn.setBorder(null);
		bodydataBtn.setBackground(Constants.MIDGREEN);
		bodydataBtn.setBounds(60, 664, 169, 21);
		bodydataBtn.setEnabled(false);
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
		deleteAccBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

			    int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", "Delete Account", JOptionPane.YES_NO_OPTION);

			    if (confirmed == JOptionPane.YES_OPTION) {
			    	MongoDBConnector.deleteAccount(MongoDBConnector._id);
			    	MongoDBConnector.deleteNutrients(MongoDBConnector._id);
			        System.exit(0);
			    }
				
			}
		});
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
		btnHome.setBounds(35, 175, 72, 23);
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
		foodRecBtn.setBounds(35, 215, 57, 23);
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
		
		JComboBox dataCombobox = new JComboBox();
		dataCombobox.setFont(Constants.PLAINTEXT);
		dataCombobox.setBackground(Constants.MAINBACKGROUND);
		dataCombobox.setModel(new DefaultComboBoxModel(new String[] { "", "gender", "weight", "height", "age", "goal", "activity" }));
		dataCombobox.setBounds(250, 316, 233, 31);
		mainPnl.add(dataCombobox);
		
		JComboBox valueCombobox = new JComboBox();
		valueCombobox.setBounds(250, 388, 348, 31);
		valueCombobox.setFont(Constants.PLAINTEXT);
		valueCombobox.setBackground(Constants.MAINBACKGROUND);
		mainPnl.add(valueCombobox);
		
		JLabel lblNewLabel_2 = new JLabel("WHICH DATA WOULD YOU LIKE TO CHANGE?");
		lblNewLabel_2.setBounds(250, 291, 297, 19);
		lblNewLabel_2.setFont(Constants.PLAINTEXT);
		mainPnl.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("ENTER NEW VALUE");
		lblNewLabel_3.setBounds(250, 363, 137, 14);
		lblNewLabel_3.setFont(Constants.PLAINTEXT);
		mainPnl.add(lblNewLabel_3);
		
		newValueTxt = new JTextField();
		newValueTxt.setBounds(250, 388, 212, 29);
		newValueTxt.setFont(Constants.PLAINTEXT);
		newValueTxt.setColumns(10);
		mainPnl.add(newValueTxt);
		
		JButton submitBdBtn = new JButton("Submit");
		submitBdBtn.setBounds(660, 440, 89, 23);
		submitBdBtn.setFont(Constants.BUTTONTEXT);
		submitBdBtn.setFocusPainted(false);
		submitBdBtn.setBorderPainted(false);
		submitBdBtn.setBorder(null);
		submitBdBtn.setBackground(Constants.LIGHTGRAY);
		submitBdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(dataCombobox.getSelectedItem().toString().equals("weight")) {

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
				
				if(dataCombobox.getSelectedItem().toString().equals("height")) {

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
				
				if(dataCombobox.getSelectedItem().toString().equals("age")) {

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
				
				if(dataCombobox.getSelectedItem().toString().equals("gender")) {

					String newValue = valueCombobox.getSelectedItem().toString();
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
				
				if(dataCombobox.getSelectedItem().toString().equals("goal")) {

					String newValue = valueCombobox.getSelectedItem().toString();
					
					try {
						
						String oldValue = MongoDBConnector.getUserValue(userName, "Goal");
						
						if(!newValue.equals(oldValue)) {
							
							MongoDBConnector.changeValue(userName, "userGoal", newValue);
							JOptionPane.showMessageDialog(null, "Successfully changed your goal to " + newValue, "INFO", JOptionPane.INFORMATION_MESSAGE);
							MongoDBConnector.reloadNutritionCalculation(userName);
							//if the goal changes, the supplements have to be reloaded again
							SupplementFrame reloadedSupFrame = new SupplementFrame();
							
						} else {
							JOptionPane.showMessageDialog(null, "Value is not allowed to be the same!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
						
						
					} catch (Exception e2) {
						
					}
					
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("activity")) {

					String newValue = valueCombobox.getSelectedItem().toString();
					
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
			
			reloadAllFrames();
				
			}
		});
		mainPnl.add(submitBdBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(250, 265, 499, 15);
		mainPnl.add(separator);
		
		JLabel lblLogin = new JLabel("CHANGE BODY DATA");
		lblLogin.setFont(Constants.HEADING);
		lblLogin.setBounds(250, 227, 285, 36);
		mainPnl.add(lblLogin);
		
		dataCombobox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(dataCombobox.getSelectedItem().toString().equals("weight")) {
					valueCombobox.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("height")) {
					valueCombobox.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("age")) {
					valueCombobox.setVisible(false);
					newValueTxt.setVisible(true);
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("gender")) {
					valueCombobox.setVisible(true);
					newValueTxt.setVisible(false);
					valueCombobox.setModel(new DefaultComboBoxModel(new String[] {"", "male", "female"}));
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("goal")) {
					valueCombobox.setVisible(true);
					newValueTxt.setVisible(false);
					valueCombobox.setModel(new DefaultComboBoxModel(new String[] {"", "gain muscles", "muscle definition", "hold weight", "lose weight"}));
				}
				
				if(dataCombobox.getSelectedItem().toString().equals("activity")) {
					valueCombobox.setVisible(true);
					newValueTxt.setVisible(false);
					valueCombobox.setModel(new DefaultComboBoxModel(new String[] {"", "Exclusively seated/lying activities",
							"Very often sedentary activities",
							"Predominantly sedentary activities",
							"Predominantly walking / standing activity", "Vigorous physical activity"}));
				}
				
			}
		});
		
		
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
	
	public static void reloadAllFrames() {
		frame.dispose();
		StartFrame.disposeFrame();;
		StartFrame reloadedMainFrame = new StartFrame();
		reloadedMainFrame.displayFrame();
		
		MicronutrientsFrame.frame.dispose();
		MicronutrientsFrame reloadedMicronutrientsFrame = new MicronutrientsFrame();
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
