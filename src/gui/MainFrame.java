package gui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import backend.MongoDBConnector;

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class MainFrame {

	public static JFrame frame;
	private String userName;

	/**
	 * Create the application.
	 */
	public MainFrame(final String _id) {
		this.userName = _id;
		initialize();
	}


	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		String[] macroNutrientsAndCalories = MongoDBConnector.getMacronutrientsAndCalories(userName);
		
		JLabel line = new JLabel("");
		line.setOpaque(true);
		line.setBackground(Color.BLACK);
		line.setBounds(498, 156, 4, 400);
		frame.getContentPane().add(line);
		
		JLabel appNameLbl = new JLabel("NutritionCalc");
		appNameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		appNameLbl.setBackground(new Color(0, 0, 0));
		appNameLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 44));
		appNameLbl.setBounds(354, 23, 286, 52);
		frame.getContentPane().add(appNameLbl);
		
		JButton ernährungsempfehlungBtn = new JButton("Food Recommendation");
		ernährungsempfehlungBtn.setBounds(41, 611, 171, 23);
		
		ernährungsempfehlungBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				FoodRecommendationFrame.displayFrame();
			}
			
		});
		
		frame.getContentPane().add(ernährungsempfehlungBtn);
		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				frame.setEnabled(false);
				SettingsFrame.displayFrame();
				
			}
			
		});
		settingsBtn.setBounds(854, 611, 89, 23);
		frame.getContentPane().add(settingsBtn);
		
		//Creating the diagram
		DefaultPieDataset<String> pieDataSet = new DefaultPieDataset<String>();
		pieDataSet.setValue("proteins", Double.parseDouble(macroNutrientsAndCalories[1]));
		pieDataSet.setValue("carbohydrates", Double.parseDouble(macroNutrientsAndCalories[3]));
		pieDataSet.setValue("fats", Double.parseDouble(macroNutrientsAndCalories[2]));
		
		JFreeChart pieChart = ChartFactory.createPieChart("Nutrient distribution", pieDataSet,  true,  true,  true);
		//PiePlot<?> plotter = (PiePlot<?>) pieChart.getPlot();
		ChartPanel chartPnl = new ChartPanel(pieChart);
		chartPnl.setBackground(new Color(154, 205, 50));
		chartPnl.setBounds(51, 156, 392, 400);
		chartPnl.setLayout(null);
		frame.getContentPane().add(chartPnl);
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		Date today = new Date();
		calendar.setTime(today);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println(dayOfWeek);
		double caloriesLeftForWeek = Double.parseDouble(macroNutrientsAndCalories[0])*7 - Double.parseDouble(macroNutrientsAndCalories[0])*dayOfWeek;
		
		JLabel dayLbl = new JLabel(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
		dayLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
		dayLbl.setBounds(522, 156, 171, 33);
		frame.getContentPane().add(dayLbl);
		
		JLabel caloriesDayLbl = new JLabel("calories left for today: " + macroNutrientsAndCalories[0] + "kcal");
		caloriesDayLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		caloriesDayLbl.setBounds(522, 200, 342, 19);
		frame.getContentPane().add(caloriesDayLbl);
		
		JLabel caloriesWeekLbl = new JLabel("calories left for the week: " + caloriesLeftForWeek + "kcal");
		caloriesWeekLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		caloriesWeekLbl.setBounds(522, 230, 405, 19);
		frame.getContentPane().add(caloriesWeekLbl);
		
		JLabel makronährstoffeLbl = new JLabel("Macronutrients");
		makronährstoffeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		makronährstoffeLbl.setBounds(522, 289, 144, 21);
		frame.getContentPane().add(makronährstoffeLbl);
		
		JLabel carbohydratesLbl = new JLabel("carbohydrates: " + macroNutrientsAndCalories[3] + "g");
		carbohydratesLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		carbohydratesLbl.setBounds(522, 319, 306, 19);
		frame.getContentPane().add(carbohydratesLbl);
		
		JLabel proteinsLbl = new JLabel("proteins: " + macroNutrientsAndCalories[1] + "g");
		proteinsLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		proteinsLbl.setBounds(522, 349, 233, 19);
		frame.getContentPane().add(proteinsLbl);
		
		JLabel fatsLbl = new JLabel("fats: " + macroNutrientsAndCalories[2] + "g");
		fatsLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		fatsLbl.setBounds(522, 379, 171, 19);
		frame.getContentPane().add(fatsLbl);
		
		JLabel mikronährstoffeLbl = new JLabel("Micronutrients");
		mikronährstoffeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		mikronährstoffeLbl.setBounds(522, 422, 138, 21);
		frame.getContentPane().add(mikronährstoffeLbl);
		
		JButton btnSeeMore = new JButton("See more");
		btnSeeMore.setBounds(522, 454, 104, 23);
		
		btnSeeMore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setEnabled(false);
				MicronutrientsFrame.displayFrame();
				
			}
			
		});
		
		frame.getContentPane().add(btnSeeMore);
		frame.setVisible(false);
	}

	public static void enableFrame() {
		frame.setEnabled(true);
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
}
