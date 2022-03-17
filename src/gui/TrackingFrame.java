package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import backend.MongoDBConnector;

import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JProgressBar;
import javax.swing.JCheckBox;

public class TrackingFrame extends Thread {

	private static JFrame frame;
	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;
	private JTextField foodNameField;
	private JTextField gramsField_1;
	private JTextField gramsField_2;
	private JTextField fatField;
	private JTextField carbsField;
	private JTextField proteinsField;
	private JCheckBox chckbxFoodNotFound;
	private JDateChooser dateChooserLeft;
	private JComboBox comboBoxFood;
	private JTextField textField;
	private JDateChooser progressDateChooser;
	private String formattedprogressDateChooser;
	private double proteinCalPercent = 0.0;
	private double carboCalPercent = 0.0;
	private double fatCalPercent = 0.0;
	private String date;
	private String foodname;
	private String amount;
	private String calories;
	private String fats;
	private String carbs;
	private String proteins;
	private String fats1;
	private String carbs1;
	private String proteins1;

	private double proteinGram = 0.0;
	private double carboGram = 0.0;
	private double fatGram = 0.0;
	private static String[] trackedMacroData;
	private boolean isRunning;
	private JPanel mainPnl;
	private JDateChooser dateChooser;

	public TrackingFrame() {
		initialize();
	}

	private void initialize() {
		// System.out.println("trackframe initilize started 78");
		frame = new JFrame("Tracking");
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
		headingLbl.setBounds(35, 50, 189, 36);
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

		passwordBtn = new JButton("Change password");
		passwordBtn.setHorizontalAlignment(SwingConstants.LEFT);
		passwordBtn.setForeground(Constants.LIGHTGRAY);
		passwordBtn.setFont(Constants.BUTTONTEXT2);
		passwordBtn.setFocusPainted(false);
		passwordBtn.setBorderPainted(false);
		passwordBtn.setBorder(null);
		passwordBtn.setBackground(Constants.MIDGREEN);
		passwordBtn.setBounds(60, 632, 153, 21);
		passwordBtn.setVisible(false);
		passwordBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				PasswordFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

			}
		});
		sidePnl.add(passwordBtn);

		bodydataBtn = new JButton("Change body data");
		bodydataBtn.setHorizontalAlignment(SwingConstants.LEFT);
		bodydataBtn.setForeground(Constants.LIGHTGRAY);
		bodydataBtn.setFont(Constants.BUTTONTEXT2);
		bodydataBtn.setFocusPainted(false);
		bodydataBtn.setBorderPainted(false);
		bodydataBtn.setBorder(null);
		bodydataBtn.setBackground(Constants.MIDGREEN);
		bodydataBtn.setBounds(60, 664, 164, 21);
		bodydataBtn.setVisible(false);
		bodydataBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				BodyDataFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

			}

		});
		sidePnl.add(bodydataBtn);

		deleteAccBtn = new JButton("Delete account");
		deleteAccBtn.setHorizontalAlignment(SwingConstants.LEFT);
		deleteAccBtn.setForeground(Constants.LIGHTGRAY);
		deleteAccBtn.setFont(Constants.BUTTONTEXT2);
		deleteAccBtn.setFocusPainted(false);
		deleteAccBtn.setBorderPainted(false);
		deleteAccBtn.setBorder(null);
		deleteAccBtn.setBackground(Constants.MIDGREEN);
		deleteAccBtn.setBounds(60, 696, 132, 21);
		deleteAccBtn.setVisible(false);
		deleteAccBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?",
						"Delete Account", JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					MongoDBConnector.deleteAccount(MongoDBConnector._id);
					MongoDBConnector.deleteNutrients(MongoDBConnector._id);
					System.exit(0);
				}

			}
		});
		sidePnl.add(deleteAccBtn);

		btnSettings = new JButton("Settings");
		btnSettings.setHorizontalAlignment(SwingConstants.LEFT);
		btnSettings.setForeground(Constants.LIGHTGRAY);
		btnSettings.setFont(Constants.BUTTONTEXT);
		btnSettings.setFocusPainted(false);
		btnSettings.setBorderPainted(false);
		btnSettings.setBorder(null);
		btnSettings.setBackground(Constants.MIDGREEN);
		btnSettings.setBounds(35, 600, 84, 23);
		btnSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				btnSettings.setFont(Constants.BUTTONTEXTBOLD);
				btnSettings.setEnabled(false);
				passwordBtn.setVisible(true);
				bodydataBtn.setVisible(true);
				deleteAccBtn.setVisible(true);

			}

		});
		sidePnl.add(btnSettings);

		JButton btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		btnHome.setForeground(Constants.LIGHTGRAY);
		btnHome.setFont(Constants.BUTTONTEXT);
		btnHome.setFocusPainted(false);
		btnHome.setBorderPainted(false);
		btnHome.setBorder(null);
		btnHome.setBackground(Constants.MIDGREEN);
		btnHome.setBounds(35, 175, 59, 23);
		btnHome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				StartFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

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
		foodRecBtn.setBounds(35, 215, 59, 23);
		foodRecBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				FoodsFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

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
		supBtn.setBounds(35, 255, 120, 23);
		supBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				SupplementFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

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
		btnWorkout.setBounds(35, 295, 84, 23);
		btnWorkout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				WorkoutFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

			}

		});
		sidePnl.add(btnWorkout);

		JButton btnTracking = new JButton("Tracking");
		btnTracking.setHorizontalAlignment(SwingConstants.LEFT);
		btnTracking.setForeground(Constants.LIGHTGRAY);
		btnTracking.setFont(Constants.BUTTONTEXTBOLD);
		btnTracking.setFocusPainted(false);
		btnTracking.setBorderPainted(false);
		btnTracking.setBorder(null);
		btnTracking.setBackground(Constants.MIDGREEN);
		btnTracking.setBounds(35, 335, 95, 26);
		btnTracking.setEnabled(false);
		sidePnl.add(btnTracking);

		JButton btnImprint = new JButton("Imprint");
		btnImprint.setHorizontalAlignment(SwingConstants.LEFT);
		btnImprint.setForeground(Constants.LIGHTGRAY);
		btnImprint.setFont(Constants.BUTTONTEXT);
		btnImprint.setFocusPainted(false);
		btnImprint.setBorderPainted(false);
		btnImprint.setBorder(null);
		btnImprint.setBackground(Constants.MIDGREEN);
		btnImprint.setBounds(35, 558, 78, 23);
		btnImprint.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				ImprintFrame.displayFrame();
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);

			}

		});
		sidePnl.add(btnImprint);

		mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);

		dateChooserLeft = new JDateChooser();
		dateChooserLeft.setBounds(224, 123, 231, 26);
		mainPnl.add(dateChooserLeft);

		JButton submitButton = new JButton("Submit");
		submitButton.setBounds(351, 684, 104, 23);
		submitButton.setFont(Constants.BUTTONTEXT);
		submitButton.setFocusPainted(false);
		submitButton.setBorderPainted(false);
		submitButton.setBorder(null);
		submitButton.setBackground(Constants.LIGHTGRAY);
		submitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (validTrackingData()) {
					if (chckbxFoodNotFound.isSelected()) {
						MongoDBConnector.saveNewFoodData(MongoDBConnector._id, getTrackingNames(),
								getTrackingDataSaveFood());
						MongoDBConnector.saveTrackingData(MongoDBConnector._id, getTrackingNames(), getTrackingData());
					} else {
						MongoDBConnector.saveTrackingData(MongoDBConnector._id, getTrackingNames(), getTrackingData());
					}
				}
				reloadTrackingFrame();

			}

		});
		mainPnl.add(submitButton);

		JSeparator trackSeparator = new JSeparator();
		trackSeparator.setOrientation(SwingConstants.VERTICAL);
		trackSeparator.setBounds(495, 11, 10, 748);
		mainPnl.add(trackSeparator);

		JLabel trackEditHeading = new JLabel("Track your nutrition data");
		trackEditHeading.setBounds(10, 40, 475, 55);
		trackEditHeading.setFont(Constants.HEADING);
		trackEditHeading.setHorizontalAlignment(SwingConstants.CENTER);
		mainPnl.add(trackEditHeading);

		JLabel dateLabelLeft = new JLabel("Select date:");
		dateLabelLeft.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		dateLabelLeft.setBounds(30, 123, 142, 26);
		dateLabelLeft.setFont(Constants.LOGINTEXT);
		mainPnl.add(dateLabelLeft);

		JLabel foodComboboxLabel = new JLabel("Select food from list:");
		foodComboboxLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		foodComboboxLabel.setBounds(30, 203, 186, 26);
		mainPnl.add(foodComboboxLabel);

		Object[] foodsObjects = MongoDBConnector.getSavedFoods();
        comboBoxFood = new JComboBox(foodsObjects);
		comboBoxFood.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		comboBoxFood.setBounds(224, 203, 231, 26);
		mainPnl.add(comboBoxFood);
		
		JLabel foodNameLabel = new JLabel("food name:");
		foodNameLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		foodNameLabel.setBounds(30, 442, 186, 26);
		mainPnl.add(foodNameLabel);

		foodNameField = new JTextField();
		foodNameField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		foodNameField.setBounds(224, 442, 231, 26);
		mainPnl.add(foodNameField);
		foodNameField.setColumns(10);

		URL logoIconPath = this.getClass().getResource("/resources/logo.png");

		// here begins the right side of tracking frame's main panel

		JLabel lblSeeYourProgress = new JLabel("See your progress");
		lblSeeYourProgress.setBounds(506, 40, 484, 55);
		lblSeeYourProgress.setFont(Constants.HEADING);
		lblSeeYourProgress.setHorizontalAlignment(SwingConstants.CENTER);
		mainPnl.add(lblSeeYourProgress);

		JLabel progessDateLbl = new JLabel("Date:");
		progessDateLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		progessDateLbl.setBounds(515, 119, 78, 35);
		mainPnl.add(progessDateLbl);

		JDateChooser progressDateChooser = new JDateChooser();
		progressDateChooser.setBounds(668, 123, 231, 26);
		// ((JTextField)progressDateChooser.getDateEditor().getUiComponent()).setText("Jan
		// 1, 2022"); this sets a default text for the dateChooser
		mainPnl.add(progressDateChooser);

		JButton searchBtn = new JButton("Search");
		searchBtn.setBounds(926, 123, 52, 26);
		searchBtn.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		searchBtn.setFocusPainted(false);
		searchBtn.setBorderPainted(false);
		searchBtn.setBorder(null);
		searchBtn.setBackground(Constants.LIGHTGRAY);
		searchBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
					String myFormattedDateString = dateFormat.format(progressDateChooser.getDate());
					trackedMacroData = MongoDBConnector.getTrackedData(myFormattedDateString);
					// System.out.println(Arrays.toString(trackedMacroData));

					if (trackedMacroData[0] != null) {
						reloadTrackingFrame();
					}

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "No date chosen!", "INFO", JOptionPane.ERROR_MESSAGE);
				}
			}

		});
		mainPnl.add(searchBtn);

		try {
			showCharts();
		} catch (Exception e) {

			JLabel noDataMessageLabel = new JLabel("Select a valid date to see the your progress");
			noDataMessageLabel.setFont(new Font("Century Gothic", Font.BOLD, 16));
			noDataMessageLabel.setBounds(504, 341, 486, 50);
			noDataMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
			mainPnl.add(noDataMessageLabel);

		}

		// here ends the right side of tracking frame's main panel

		JLabel gramsLabel_1 = new JLabel("amount in grams:");
		gramsLabel_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		gramsLabel_1.setBounds(30, 248, 186, 26);
		mainPnl.add(gramsLabel_1);

		gramsField_1 = new JTextField();
		gramsField_1.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		gramsField_1.setColumns(10);
		gramsField_1.setBounds(224, 248, 231, 26);
		mainPnl.add(gramsField_1);

		JLabel fatLabel = new JLabel("fat per 100g:");
		fatLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		fatLabel.setBounds(30, 479, 186, 26);
		mainPnl.add(fatLabel);

		fatField = new JTextField();
		fatField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		fatField.setColumns(10);
		fatField.setBounds(224, 479, 231, 26);
		mainPnl.add(fatField);

		JLabel carbsLabel = new JLabel("carbs per 100g:");
		carbsLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		carbsLabel.setBounds(30, 524, 186, 26);
		mainPnl.add(carbsLabel);

		carbsField = new JTextField();
		carbsField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		carbsField.setColumns(10);
		carbsField.setBounds(224, 524, 231, 26);
		mainPnl.add(carbsField);

		JLabel proteinsLabel = new JLabel("proteins per 100g:");
		proteinsLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		proteinsLabel.setBounds(30, 569, 186, 26);
		mainPnl.add(proteinsLabel);

		proteinsField = new JTextField();
		proteinsField.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		proteinsField.setColumns(10);
		proteinsField.setBounds(224, 569, 231, 26);
		mainPnl.add(proteinsField);

		chckbxFoodNotFound = new JCheckBox("Didn't find your food in the list? Enter manually:");
		chckbxFoodNotFound.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		chckbxFoodNotFound.setBounds(30, 328, 425, 26);
		mainPnl.add(chckbxFoodNotFound);

		JLabel gramsLabel_2 = new JLabel("amount in grams:");
		gramsLabel_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		gramsLabel_2.setBounds(30, 614, 186, 26);
		mainPnl.add(gramsLabel_2);

		gramsField_2 = new JTextField();
		gramsField_2.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		gramsField_2.setColumns(10);
		gramsField_2.setBounds(224, 614, 231, 26);
		mainPnl.add(gramsField_2);

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

	/*
	 * check wheter the input in the tracking frame is valid
	 */
	public boolean validTrackingData() {
		try {
			SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy");
			date = dateFormat1.format(dateChooserLeft.getDate());
			double amountDouble = Double.parseDouble(gramsField_2.getText());

			if (!chckbxFoodNotFound.isSelected()) {
				foodname = comboBoxFood.getSelectedItem().toString();
				amount = gramsField_2.getText();

			} else {

				foodname = foodNameField.getText();
				fats = Double.toString(Double.parseDouble(fatField.getText()) * amountDouble / 100);
				carbs = Double.toString(Double.parseDouble(carbsField.getText()) * amountDouble / 100);
				proteins = Double.toString(Double.parseDouble(proteinsField.getText()) * amountDouble / 100);
				// variables without multiplication with amountDouble so that it can be save in
				// saved-food collection
				fats1 = Double.toString(Double.parseDouble(fatField.getText()));
				carbs1 = Double.toString(Double.parseDouble(carbsField.getText()));
				proteins1 = Double.toString(Double.parseDouble(proteinsField.getText()));

			}
			return true;
		} catch (Exception e) {

			return false;
		}
	}

	/*
	 * returns a String-Array that contains the names of the tracked data
	 */
	public String[] getTrackingNames() {
		if (!chckbxFoodNotFound.isSelected()) {
			String[] trackingData = { "food name", "amount" };
			return trackingData;
		} else {
			String[] trackingData = { "fat_amount", "carbo_amount", "protein_amount", "date", "food_name", };

			return trackingData;
		}
	}

	/*
	 * returns an Object-Array that contains the values of the user input
	 */
	public String[] getTrackingData() {
		if (!chckbxFoodNotFound.isSelected()) {
			String[] trackingData = { foodname, amount };
			return trackingData;
		} else {
			String[] trackingData = { fats, carbs, proteins, date, foodname };

			return trackingData;
		}
	}

	// variables without multiplication with amountDouble so that it can be save in
	// saved-food collection
	public String[] getTrackingDataSaveFood() {
		if (!chckbxFoodNotFound.isSelected()) {
			String[] trackingData = { foodname, amount };
			return trackingData;
		} else {
			String[] trackingData = { fats1, carbs1, proteins1, date, foodname };

			return trackingData;
		}
	}

	public static void displayFrame() {
		frame.setVisible(true);
	}

	public static void enableFrame() {
		frame.setEnabled(true);
	}

	public static void disposeFrame() {
		frame.dispose();
	}

	public void showCharts() {

		String[] macroNutrientsAndCalories = MongoDBConnector.getMacronutrientsAndCalories(MongoDBConnector._id);

		DefaultPieDataset<String> pieDataSet = new DefaultPieDataset<String>();

		// double amount1 = Double.parseDouble(trackedMacroData[6])/100;
		proteinCalPercent = Double.parseDouble(trackedMacroData[2]) * 4.1;
		carboCalPercent = Double.parseDouble(trackedMacroData[0]) * 4.1;
		fatCalPercent = Double.parseDouble(trackedMacroData[1]) * 9.3;
		double calorieSum = proteinCalPercent + carboCalPercent + fatCalPercent;

		double caloriesToEat = Double.parseDouble(macroNutrientsAndCalories[0]) - proteinCalPercent - carboCalPercent
				- fatCalPercent;

		// System.out.println(caloriesToEat + " trackframe calorie to eat 598");
		proteinGram = Double.parseDouble(trackedMacroData[2]);
		carboGram = Double.parseDouble(trackedMacroData[0]);
		fatGram = Double.parseDouble(trackedMacroData[1]);

		pieDataSet.setValue("proteins (kcal)", proteinCalPercent);
		pieDataSet.setValue("carbohydrates (kcal)", carboCalPercent);
		pieDataSet.setValue("fats (kcal)", fatCalPercent);
		pieDataSet.setValue("calories to eat", caloriesToEat);

		JFreeChart pieChart = ChartFactory.createPieChart("Calorie Distribution", pieDataSet, true, true, true);
		ChartPanel chartPnl = new ChartPanel(pieChart);
		chartPnl.setBackground(new Color(154, 205, 50));
		chartPnl.setBounds(552, 420, 394, 295);
		chartPnl.setLayout(null);
		mainPnl.add(chartPnl);

		JLabel CalorieProgLbl = new JLabel("Calorie:");
		CalorieProgLbl.setBounds(515, 199, 119, 35);
		CalorieProgLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mainPnl.add(CalorieProgLbl);

		JProgressBar CalorieProgBar = new JProgressBar(0, (int) Double.parseDouble(macroNutrientsAndCalories[0]));
		CalorieProgBar.setStringPainted(true);
		CalorieProgBar.setValue((int) calorieSum);
		// CalorieProgBar.setMaximum((int)
		// Double.parseDouble(macroNutrientsAndCalories[3]));
		CalorieProgBar.setBounds(668, 203, 310, 23);
		CalorieProgBar.setString(calorieSum + " kcal / " + macroNutrientsAndCalories[0] + " kcal");
		mainPnl.add(CalorieProgBar);

		JLabel CarboProgLbl = new JLabel("Carbohydrate:");
		CarboProgLbl.setBounds(515, 243, 119, 35);
		CarboProgLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mainPnl.add(CarboProgLbl);

		JProgressBar CarboProgBar = new JProgressBar(0, (int) Double.parseDouble(macroNutrientsAndCalories[3]));
		CarboProgBar.setStringPainted(true);
		CarboProgBar.setValue((int) carboGram);
		// CarboProgBar.setMaximum((int)
		// Double.parseDouble(macroNutrientsAndCalories[3]));
		CarboProgBar.setBounds(668, 250, 310, 23);
		CarboProgBar.setString(carboGram + " g / " + macroNutrientsAndCalories[3] + " g");
		mainPnl.add(CarboProgBar);

		JLabel proteinProgLbl = new JLabel("Protein:");
		proteinProgLbl.setBounds(515, 289, 119, 35);
		proteinProgLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mainPnl.add(proteinProgLbl);

		JProgressBar proteinProgBar = new JProgressBar(0, (int) Double.parseDouble(macroNutrientsAndCalories[1]));
		proteinProgBar.setStringPainted(true);
		proteinProgBar.setValue((int) proteinGram);
		proteinProgBar.setBounds(668, 299, 310, 23);
		proteinProgBar.setString(proteinGram + " g / " + macroNutrientsAndCalories[1] + " g");
		mainPnl.add(proteinProgBar);

		JLabel fatProgLbl = new JLabel("Fat:");
		fatProgLbl.setBounds(515, 335, 119, 35);
		fatProgLbl.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		mainPnl.add(fatProgLbl);

		JProgressBar fatProgBar = new JProgressBar(0, (int) Double.parseDouble(macroNutrientsAndCalories[2]));
		fatProgBar.setStringPainted(true);
		fatProgBar.setValue((int) fatGram);
		fatProgBar.setString(fatGram + " g / " + macroNutrientsAndCalories[2] + " g");
		fatProgBar.setBounds(668, 345, 310, 23);
		mainPnl.add(fatProgBar);
		// System.out.println("1");

		// System.out.println(caloriesToEat + "Hi");

		if (caloriesToEat <= 0) {

			// System.out.println(caloriesToEat + "Ho");

			JLabel negativeCalAlertLabel = new JLabel("The calorie limit for " + trackedMacroData[3]
					+ " was exceeded by " + Math.abs(caloriesToEat) + " kcal !!!");
			negativeCalAlertLabel.setBounds(506, 726, 484, 33);
			negativeCalAlertLabel.setHorizontalAlignment(SwingConstants.CENTER);
			negativeCalAlertLabel.setFont(new Font("Century Gothic", Font.PLAIN, 12));
			mainPnl.add(negativeCalAlertLabel);

		}

	}

	public static void reloadTrackingFrame() {
		frame.dispose();
		TrackingFrame reloadedTrackingFrame = new TrackingFrame();
		reloadedTrackingFrame.displayFrame();
	}

	// Thread to automatically run when a date is chosen from right side of main
	// panel

	public void run() {
		while (isRunning) {
			System.out.println("running");

			try {
				System.out.println("running1");
				// SimpleDateFormat dateFormat_1 = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDateString = "";
				System.out.println("ho");
				// progressDateChooser.getDate() != null &&
				// progressDateChooser.getDate().toString().isEmpty() &&
				if (formattedDateString != formattedprogressDateChooser) {
					// System.out.println(progressDateChooser.getDate());
					System.out.println("inside try in thread");
					try {
						// formattedDateString = dateFormat_1.format(progressDateChooser.getDate());
					} catch (Exception e) {
						System.out.println("date catch didnt work");
					}

					System.out.println(progressDateChooser.getDate());

					formattedprogressDateChooser = formattedDateString;
					trackedMacroData = MongoDBConnector.getTrackedData(formattedprogressDateChooser);
					isRunning = false;
				}

				System.out.println("hi");
			} catch (Exception e) {
				System.out.println("error in thread");
				isRunning = false;
			}

		}
	}
}
