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
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JProgressBar;

public class ExtraTracking {

	private static JFrame frame;
	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;
	private JTextField textField;
	private JDateChooser dateChooser_1;
	private String formattedDateChooser_1 = "01-01-2022";
	private double proteinCalPercent = 0.0;
	private double carboCalPercent = 0.0;
	private double fatCalPercent = 0.0;
	
	private int proteinGram = 0;
	private int carboGram = 0;
	private int fatGram = 0;
	private String[] trackedMacroData;
	private boolean isRunning;
	private JPanel mainPnl;
	private JDateChooser dateChooser;
	
	public ExtraTracking() {
		trackedMacroData = MongoDBConnector.getTrackedData(formattedDateChooser_1);
		System.out.println(Arrays.toString(trackedMacroData) + "frame");
		initialize();
	}

	private void initialize() {
		System.out.println("started");
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
		headingLbl.setBounds(35, 50, 176, 36);
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
		passwordBtn.setForeground(Constants.LIGHTGRAY);
		passwordBtn.setFont(Constants.BUTTONTEXT2);
		passwordBtn.setFocusPainted(false);
		passwordBtn.setBorderPainted(false);
		passwordBtn.setBorder(null);
		passwordBtn.setBackground(Constants.MIDGREEN);
		passwordBtn.setBounds(60, 632, 144, 21);
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
		bodydataBtn.setForeground(Constants.LIGHTGRAY);
		bodydataBtn.setFont(Constants.BUTTONTEXT2);
		bodydataBtn.setFocusPainted(false);
		bodydataBtn.setBorderPainted(false);
		bodydataBtn.setBorder(null);
		bodydataBtn.setBackground(Constants.MIDGREEN);
		bodydataBtn.setBounds(60, 664, 153, 21);
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
		deleteAccBtn.setForeground(Constants.LIGHTGRAY);
		deleteAccBtn.setFont(Constants.BUTTONTEXT2);
		deleteAccBtn.setFocusPainted(false);
		deleteAccBtn.setBorderPainted(false);
		deleteAccBtn.setBorder(null);
		deleteAccBtn.setBackground(Constants.MIDGREEN);
		deleteAccBtn.setBounds(60, 696, 126, 21);
		deleteAccBtn.setVisible(false);
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
		btnHome.setBounds(35, 175, 53, 23);
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
		foodRecBtn.setBounds(35, 215, 45, 23);
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
		supBtn.setBounds(35, 255, 113, 23);
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
		btnWorkout.setForeground(Constants.LIGHTGRAY);
		btnWorkout.setFont(Constants.BUTTONTEXT);
		btnWorkout.setFocusPainted(false);
		btnWorkout.setBorderPainted(false);
		btnWorkout.setBorder(null);
		btnWorkout.setBackground(Constants.MIDGREEN);
		btnWorkout.setBounds(35, 295, 73, 23);
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
		btnTracking.setForeground(Constants.LIGHTGRAY);
		btnTracking.setFont(Constants.BUTTONTEXTBOLD);
		btnTracking.setFocusPainted(false);
		btnTracking.setBorderPainted(false);
		btnTracking.setBorder(null);
		btnTracking.setBackground(Constants.MIDGREEN);
		btnTracking.setBounds(35, 335, 83, 26);
		btnTracking.setEnabled(false);
		sidePnl.add(btnTracking);
		
		mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(240, 172, 215, 35);
		mainPnl.add(dateChooser);

		
		JSeparator trackSeparator = new JSeparator();
		trackSeparator.setOrientation(SwingConstants.VERTICAL);
		trackSeparator.setBounds(495, 11, 10, 748);
		mainPnl.add(trackSeparator);
		
		JLabel trackEditHeading = new JLabel("Enter or edit your nutrition data");
		trackEditHeading.setFont(Constants.HEADING);
		trackEditHeading.setBounds(77, 40, 331, 55);
		mainPnl.add(trackEditHeading);
		
		JLabel trackEditDate = new JLabel("Select date:");
		trackEditDate.setBounds(30, 172, 78, 35);
		trackEditHeading.setFont(Constants.LOGINTEXT);
		mainPnl.add(trackEditDate);
		
		JLabel lblSelectFood = new JLabel("Select food:");
		lblSelectFood.setBounds(30, 243, 78, 35);
		mainPnl.add(lblSelectFood);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(240, 243, 215, 35);
		mainPnl.add(comboBox);
		
		JLabel lblGiveTheCalorie = new JLabel("give the calorie: ");
		lblGiveTheCalorie.setBounds(30, 402, 113, 35);
		mainPnl.add(lblGiveTheCalorie);
		
		textField = new JTextField();
		textField.setBounds(240, 402, 215, 35);
		mainPnl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("if not found in the list, give manuel");
		lblNewLabel_1.setBounds(100, 318, 269, 44);
		mainPnl.add(lblNewLabel_1);
		
		JLabel lblSelectTheMacronutrition = new JLabel("select the macronutrition:");
		lblSelectTheMacronutrition.setBounds(30, 472, 142, 35);
		mainPnl.add(lblSelectTheMacronutrition);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(240, 472, 215, 35);
		mainPnl.add(comboBox_1);
		
		JLabel trackEditDate_1 = new JLabel("Select date:");
		trackEditDate_1.setBounds(515, 172, 78, 35);
		mainPnl.add(trackEditDate_1);
		
		
		URL logoIconPath = this.getClass().getResource("/resources/logo.png");
		
		
		
		
		
		//here begins the right side of tracking frame's main panel
		
		
		
		JLabel lblSeeYourProgress = new JLabel("See your progress");
		lblSeeYourProgress.setFont(new Font("Century Gothic", Font.BOLD, 28));
		lblSeeYourProgress.setBounds(623, 37, 248, 55);
		mainPnl.add(lblSeeYourProgress);
		
		
		
		
		   
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(668, 172, 254, 35);
		
		{/*String date = "2022-01-01";
		try {
			java.util.Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
			dateChooser_1.setDate(date2);
			System.out.println(dateChooser_1.getDate() + "hi");
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			System.out.println("date problem");
			e1.printStackTrace();
		}*/}
		
		//((JTextField)dateChooser_1.getDateEditor().getUiComponent()).setText("Jan 1, 2022");
		mainPnl.add(dateChooser_1);
		
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(926, 172, 52, 35);
		btnNewButton.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Constants.LIGHTGRAY);
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {


				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				
				String myFormattedDateString = dateFormat.format(dateChooser.getDate());       
				//lblNewLabel.setText(myFormattedDateString);
				//double[] da = MongoDBConnector.getTrackedData(myFormattedDateString);
				//System.out.println("Hi button"+ da.toString());
				trackedMacroData = MongoDBConnector.getTrackedData(myFormattedDateString);
				System.out.println(Arrays.toString(trackedMacroData) + "button");
				
				//SimpleDateFormat dateFormat_1 = new SimpleDateFormat("dd-MM-yyyy");
				//String formattedDateChooser_1 = dateFormat_1.format(dateChooser_1.getDate());
				//System.out.println(formattedDateChooser_1);
				//if (formattedDateChooser_1 != null && !formattedDateChooser_1.isEmpty()) {
					//System.out.println("hi");
					//MongoDBConnector.getTrackedData(formattedDateChooser_1);
				//}
				//searchTrackDate();
				//showCharts();

			}

		});
		mainPnl.add(btnNewButton);
		

		showCharts();

		//here ends the right side of tracking frame's main panel

		

		
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
	
	
	//Thread to automatically run when a date is chosen from right side of main panel 
	
	public void searchTrackDate() {

		try {
			SimpleDateFormat dateFormat_1 = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("ho");
			formattedDateChooser_1 = dateFormat_1.format(dateChooser_1.getDate());
			System.out.println("hi");

		} catch (Exception e) {
			System.out.println("date catch didnt work");
		}
		trackedMacroData = MongoDBConnector.getTrackedData(formattedDateChooser_1);
		System.out.println(formattedDateChooser_1);
		
	}
	
	public void showCharts() {
		System.out.println("charts start");
		

		// Creating the diagram
		String[] macroNutrientsAndCalories = MongoDBConnector.getMacronutrientsAndCalories(MongoDBConnector._id);
		
		DefaultPieDataset<String> pieDataSet = new DefaultPieDataset<String>();
		
		proteinCalPercent = Double.parseDouble(trackedMacroData[6])*4;
		carboCalPercent = Double.parseDouble(trackedMacroData[3])*4;
		fatCalPercent = Double.parseDouble(trackedMacroData[5])*9;

		double caloriesToEat = Double.parseDouble(macroNutrientsAndCalories[0])-proteinCalPercent-carboCalPercent-fatCalPercent;
		
		proteinGram = (int)Double.parseDouble(trackedMacroData[6]);
		carboGram = (int)Double.parseDouble(trackedMacroData[3]);
		fatGram = (int)Double.parseDouble(trackedMacroData[5]);
		
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
		
		
		JLabel trackEditDate_1_1 = new JLabel("Carbohydrate:");
		trackEditDate_1_1.setBounds(515, 259, 119, 35);
		mainPnl.add(trackEditDate_1_1);
		
		JProgressBar progressBar = new JProgressBar(0,(int) Double.parseDouble(macroNutrientsAndCalories[3]));
		progressBar.setStringPainted(true);
		progressBar.setValue(carboGram);
		//progressBar.setMaximum((int) Double.parseDouble(macroNutrientsAndCalories[3]));
		progressBar.setBounds(668, 259, 310, 23);
		progressBar.setString(carboGram+" g / "+macroNutrientsAndCalories[3]+ " g");
		mainPnl.add(progressBar);
		
		

		JLabel trackEditDate_1_1_2 = new JLabel("Protein:");
		trackEditDate_1_1_2.setBounds(515, 308, 119, 35);
		mainPnl.add(trackEditDate_1_1_2);

		
		JProgressBar progressBar_1 = new JProgressBar(0,(int) Double.parseDouble(macroNutrientsAndCalories[1]));
		progressBar_1.setStringPainted(true);
		progressBar_1.setValue(proteinGram);
		progressBar_1.setBounds(668, 308, 310, 23);
		progressBar_1.setString(proteinGram+" g / "+macroNutrientsAndCalories[1]+ " g");
		mainPnl.add(progressBar_1);
		
		
		JLabel trackEditDate_1_1_3 = new JLabel("Fat:");
		trackEditDate_1_1_3.setBounds(515, 360, 119, 35);
		mainPnl.add(trackEditDate_1_1_3);
		
		JProgressBar progressBar_2 = new JProgressBar(0, (int) Double.parseDouble(macroNutrientsAndCalories[2]));
		progressBar_2.setStringPainted(true);
		progressBar_2.setForeground(Color.DARK_GRAY);
		progressBar_2.setValue(fatGram);
		progressBar_2.setBounds(668, 360, 310, 23);
		mainPnl.add(progressBar_2);
		System.out.println("charts end");
	}
	
	public void run1() {
		while (isRunning) {
			System.out.println("running");

			try {
				System.out.println("running1");
				//SimpleDateFormat dateFormat_1 = new SimpleDateFormat("dd-MM-yyyy");
				String formattedDateString = "";
				System.out.println("ho");
				//dateChooser_1.getDate() != null && dateChooser_1.getDate().toString().isEmpty() &&
				if ( formattedDateString != formattedDateChooser_1) {
					//System.out.println(dateChooser_1.getDate());
					System.out.println("inside try in thread");
					try {
						//formattedDateString = dateFormat_1.format(dateChooser_1.getDate());
					} catch (Exception e) {
						System.out.println("date catch didnt work");
					}
					
					System.out.println(dateChooser_1.getDate());

					formattedDateChooser_1 = formattedDateString;
					trackedMacroData = MongoDBConnector.getTrackedData(formattedDateChooser_1);
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


