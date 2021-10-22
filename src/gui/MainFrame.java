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

import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Component;

public class MainFrame {

	private static JFrame frame;

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JLabel line = new JLabel("");
		line.setOpaque(true);
		line.setBackground(Color.BLACK);
		line.setBounds(498, 156, 4, 400);
		frame.getContentPane().add(line);
		
		JLabel appNameLbl = new JLabel("NutritionCalc");
		appNameLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
		appNameLbl.setBackground(new Color(0, 0, 0));
		appNameLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 44));
		appNameLbl.setBounds(361, 23, 284, 52);
		frame.getContentPane().add(appNameLbl);
		
		JButton ernährungsempfehlungBtn = new JButton("Food Recommendation");
		ernährungsempfehlungBtn.setBounds(41, 611, 171, 23);
		
		ernährungsempfehlungBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("food recommendation");
				
			}
			
		});
		
		frame.getContentPane().add(ernährungsempfehlungBtn);
		
		JButton settingsBtn = new JButton("Settings");
		settingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Settings clicked");
			}
		});
		settingsBtn.setBounds(854, 611, 89, 23);
		frame.getContentPane().add(settingsBtn);
		
		//Creating the diagram
		DefaultPieDataset<String> pieDataSet = new DefaultPieDataset<String>();
		pieDataSet.setValue("proteins", 110.0);
		pieDataSet.setValue("carbohydrates", 245.0);
		pieDataSet.setValue("fats", 75.0);
		
		JFreeChart pieChart = ChartFactory.createPieChart("Nutrient distribution", pieDataSet,  true,  true,  true);
		//PiePlot<?> plotter = (PiePlot<?>) pieChart.getPlot();
		ChartPanel chartPnl = new ChartPanel(pieChart);
		chartPnl.setBackground(new Color(154, 205, 50));
		chartPnl.setBounds(51, 156, 392, 400);
		chartPnl.setLayout(null);
		frame.getContentPane().add(chartPnl);
		
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		
		JLabel dayLbl = new JLabel(new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime()));
		dayLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 28));
		dayLbl.setBounds(522, 156, 171, 33);
		frame.getContentPane().add(dayLbl);
		
		JLabel caloriesDayLbl = new JLabel("calories left for today: 2184 kcal");
		caloriesDayLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		caloriesDayLbl.setBounds(522, 200, 244, 19);
		frame.getContentPane().add(caloriesDayLbl);
		
		JLabel caloriesWeekLbl = new JLabel("calories left for the week: 15291");
		caloriesWeekLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		caloriesWeekLbl.setBounds(522, 230, 269, 19);
		frame.getContentPane().add(caloriesWeekLbl);
		
		JLabel makronährstoffeLbl = new JLabel("Macronutrients");
		makronährstoffeLbl.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		makronährstoffeLbl.setBounds(522, 289, 144, 21);
		frame.getContentPane().add(makronährstoffeLbl);
		
		JLabel carbohydratesLbl = new JLabel("carbohydrates: 245g");
		carbohydratesLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		carbohydratesLbl.setBounds(522, 319, 149, 19);
		frame.getContentPane().add(carbohydratesLbl);
		
		JLabel proteinsLbl = new JLabel("proteins: 110g");
		proteinsLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		proteinsLbl.setBounds(522, 349, 104, 19);
		frame.getContentPane().add(proteinsLbl);
		
		JLabel fatsLbl = new JLabel("fats: 75g");
		fatsLbl.setFont(new Font("Arial", Font.PLAIN, 16));
		fatsLbl.setBounds(522, 379, 73, 19);
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
				
				System.out.println("See more");
				MicronutrientsFrame microFrame = new MicronutrientsFrame();
				frame.setEnabled(false);
				
			}
			
		});
		
		frame.getContentPane().add(btnSeeMore);
		frame.setVisible(true);
	}

	public static void enableFrame() {
		frame.setEnabled(true);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
