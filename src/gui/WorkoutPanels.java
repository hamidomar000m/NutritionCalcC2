package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import backend.Main;

public class WorkoutPanels {

	public WorkoutPanels() {

	}

	public JPanel getChestPanel() {

		JPanel chestPnl = new JPanel();
		WorkoutFrame.parentPnl.add(chestPnl, BorderLayout.CENTER);
		chestPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		chestPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/Bankdrucken.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgBenchpress = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgBenchpress.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel.add(imgBenchpress);
		
		JLabel lblChestpress = new JLabel("Benchpress");
		lblChestpress.setFont(Constants.HEADING1);
		lblChestpress.setBounds(350, 11, 112, 26);
		panel.add(lblChestpress);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel benchpressSets = new JLabel("sets: 5, repetitions: 8-12");
		benchpressSets.setFont(Constants.PLAINTEXT);
		benchpressSets.setBounds(360, 40, 214, 19);
		panel.add(benchpressSets);
		
		JTextArea benchpressTxtArea = new JTextArea();
		benchpressTxtArea.setText("Lie on the bench and shape your body like a bridge, with your buttocks firmly on the\nbench and your feet firmly planted on the floor. Grip the bar wide enough so that\nyou're constantly working perpendicular to the floor as you press the bar. The elbows\nshould always be 45\u00B0 away from the body and the bar should be at chest height.\nGo down slowly and in a controlled manner and push up explosively.");
		benchpressTxtArea.setFont(Constants.PLAINTEXT);
		benchpressTxtArea.setBackground(Constants.MAINBACKGROUND);
		benchpressTxtArea.setBounds(350, 62, 595, 134);
		panel.add(benchpressTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		chestPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblPushups = new JLabel("Push Ups");
		lblPushups.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPushups.setBounds(350, 11, 85, 26);
		panel_1.add(lblPushups);
		
		URL pushUpIconPath = Main.class.getResource("/resources/Liegestutze2.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgPushups = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgPushups.setText("");
		imgPushups.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgPushups);
		
		JLabel pushupsSets = new JLabel("sets: 4, repetitions: max");
		pushupsSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pushupsSets.setBounds(360, 40, 244, 19);
		panel_1.add(pushupsSets);
		
		JTextArea pushupsTextArea = new JTextArea();
		pushupsTextArea.setText("Get into the push-up position. Make sure that your hands are on the floor at about\nchest height. To hit the chest perfectly, rotate your hands slightly outwards and reach\na little wider than shoulder-width. Now you go with your chest to the floor, hold\nbriefly and push yourself up explosively.");
		pushupsTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pushupsTextArea.setBackground(SystemColor.menu);
		pushupsTextArea.setBounds(350, 62, 595, 134);
		panel_1.add(pushupsTextArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		chestPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblButterfly = new JLabel("Butterfly");
		lblButterfly.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblButterfly.setBounds(350, 11, 130, 34);
		panel_1_1.add(lblButterfly);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/Butterfly.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgButterfly = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgButterfly.setText("");
		imgButterfly.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgButterfly);
		
		JLabel butterflySets = new JLabel("sets: 4, repetitions: 8-12");
		butterflySets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		butterflySets.setBounds(360, 40, 244, 19);
		panel_1_1.add(butterflySets);
		
		JTextArea butterflyTextArea = new JTextArea();
		butterflyTextArea.setText("Stand in the middle of two pulleys so that you have a grip in each hand. The cables\nshould be at about chest height. Now push the two cable pulls forward and walk\nbackwards in a controlled manner with a slight stretch in your chest.");
		butterflyTextArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		butterflyTextArea.setBackground(SystemColor.menu);
		butterflyTextArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(butterflyTextArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				WorkoutFrame.parentPnl.remove(chestPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl, BorderLayout.CENTER);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
			}
		});
		chestPnl.add(returnBtn);

		return chestPnl;

	}
	
	public JPanel getBackPanel() {
		
		JPanel backPnl = new JPanel();
		WorkoutFrame.parentPnl.add(backPnl, BorderLayout.CENTER);
		backPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		backPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/Klimmzuge2.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgPullups = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth - 40, Constants.imageExerciseHeight + 25, java.awt.Image.SCALE_SMOOTH)));
		imgPullups.setBounds(42, 11, Constants.imageExerciseWidth - 40, Constants.imageExerciseHeight + 25);
		panel.add(imgPullups);
		
		JLabel lblPressup = new JLabel("Pull Ups");
		lblPressup.setFont(Constants.HEADING1);
		lblPressup.setBounds(350, 11, 112, 26);
		panel.add(lblPressup);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel pullUpsSets = new JLabel("sets: 3-4, repetitions: max");
		pullUpsSets.setFont(Constants.PLAINTEXT);
		pullUpsSets.setBounds(360, 40, 172, 19);
		panel.add(pullUpsSets);
		
		JTextArea pullUpsTxtArea = new JTextArea();
		pullUpsTxtArea.setText("Grab the bar with an overhand grip slightly wider than shoulder-width and hang\nfully stretched."
				+ " Now you raise your shoulders to activate the lats and pull yourself\nexplosively against the bar with your chin. Hold this position briefly and relax"
				+ " controls\ndown to take advantage of the negatives.");
		pullUpsTxtArea.setFont(Constants.PLAINTEXT);
		pullUpsTxtArea.setBackground(Constants.MAINBACKGROUND);
		pullUpsTxtArea.setBounds(350, 62, 595, 134);
		panel.add(pullUpsTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		backPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblBarbell = new JLabel("Rowing with barbell bar");
		lblBarbell.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBarbell.setBounds(350, 11, 254, 26);
		panel_1.add(lblBarbell);
		
		URL pushUpIconPath = this.getClass().getResource("/resources/RudernLanghantel2.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgBarbell = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgBarbell.setText("");
		imgBarbell.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgBarbell);
		
		JLabel barbellSets = new JLabel("sets: 3-4, repetitions: 8-12");
		barbellSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		barbellSets.setBounds(360, 40, 244, 19);
		panel_1.add(barbellSets);
		
		JTextArea barbellTxtArea = new JTextArea();
		barbellTxtArea.setText("Take a barbell and a weight that is appropriate for you. Grab the bar lying on the\n"
				+ "floor about shoulder-width apart and stand up with it like deadlifting.\n"
				+ "Now squat down slightly and almost lean your back parallel to the floor\n"
				+ "to perfectly hit the trapezius muscles. Lead the pole controlled up and down so as\nnot to put too much strain on your lower back.");
		barbellTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		barbellTxtArea.setBackground(SystemColor.menu);
		barbellTxtArea.setBounds(350, 62, 595, 134);
		panel_1.add(barbellTxtArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		backPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblDumbbell = new JLabel("Rowing with dumbbell");
		lblDumbbell.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDumbbell.setBounds(350, 11, 222, 26);
		panel_1_1.add(lblDumbbell);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/RudernKurzhantel2.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgDumbbell = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgDumbbell.setText("");
		imgDumbbell.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgDumbbell);
		
		JLabel dumbbellSets = new JLabel("sets: 3-4, repetitions: 8-12");
		dumbbellSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		dumbbellSets.setBounds(360, 40, 171, 19);
		panel_1_1.add(dumbbellSets);
		
		JTextArea dumbbellTxtArea = new JTextArea();
		dumbbellTxtArea.setText("Take two dumbbells and a weight bench. Support your one half of the body with\nthe respective knee and one hand on the weight bench and lean your back almost\n"
				+ "parallel to the weight bench. Hold the dumbbell in the other hand and pull it\ntowards you, close to your body.");
		dumbbellTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		dumbbellTxtArea.setBackground(SystemColor.menu);
		dumbbellTxtArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(dumbbellTxtArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WorkoutFrame.parentPnl.remove(backPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
				
			}
		});
		
		backPnl.add(returnBtn);
		
		return backPnl;
		
	}

	public JPanel getLegsPanel() {
		
		JPanel legsPnl = new JPanel();
		WorkoutFrame.parentPnl.add(legsPnl, BorderLayout.CENTER);
		legsPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		legsPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/Kniebeuge.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgSquads = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgSquads.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel.add(imgSquads);
		
		JLabel lblSquads = new JLabel("Squads");
		lblSquads.setFont(Constants.HEADING1);
		lblSquads.setBounds(350, 11, 112, 26);
		panel.add(lblSquads);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel squadsSets = new JLabel("sets: 5-6, repetitions: 8-12");
		squadsSets.setFont(Constants.PLAINTEXT);
		squadsSets.setBounds(360, 40, 172, 19);
		panel.add(squadsSets);
		
		JTextArea squadsTxtArea = new JTextArea();
		squadsTxtArea.setText("Stand under the barbell and place it on the back ones shoulder muscles. Grab the\nbar wider than shoulder-width and build up tension throughout your body while\nslightly arching your back. Now slowly bend your legs, with your upper body leaning\nslightly forward and your buttocks is pushed backwards. It is important that your\nknees rotate slightly outwards and are located behind the toes. Once the thighs are\nparallel to the floor, you can straighten your legs over your heels again.");
		squadsTxtArea.setFont(Constants.PLAINTEXT);
		squadsTxtArea.setBackground(Constants.MAINBACKGROUND);
		squadsTxtArea.setBounds(350, 62, 595, 134);
		panel.add(squadsTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		legsPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblDeadlift = new JLabel("Deadlift");
		lblDeadlift.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblDeadlift.setBounds(350, 11, 254, 26);
		panel_1.add(lblDeadlift);
		
		URL pushUpIconPath = this.getClass().getResource("/resources/Kreuzheben.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgDeadlift = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgDeadlift.setText("");
		imgDeadlift.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgDeadlift);
		
		JLabel deadliftSets = new JLabel("sets: 5-6, repetitions: 8-12");
		deadliftSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		deadliftSets.setBounds(360, 40, 244, 19);
		panel_1.add(deadliftSets);
		
		JTextArea deadliftTxtArea = new JTextArea();
		deadliftTxtArea.setText("Stand shoulder-width in front of a barbell bar with knees slightly bent. Grasp the bar\na little wider than shoulder width and grip the bar with the palms facing you. In the\nbent position, pull your shoulder blades back and bring your chest slightly forward.\nBring tension to your entire body and keep your back straight throughout the exercise.\nNow bring the barbell to hip height by pushing your pelvis forward and exhale. Now\nlower the bar by bringing your pelvis back to the starting position. Keep the barbell\nclose to your legs and slightly bent knees.");
		deadliftTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		deadliftTxtArea.setBackground(SystemColor.menu);
		deadliftTxtArea.setBounds(350, 62, 595, 134);
		panel_1.add(deadliftTxtArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		legsPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblCalfraises = new JLabel("Calf raises");
		lblCalfraises.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblCalfraises.setBounds(350, 11, 222, 26);
		panel_1_1.add(lblCalfraises);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/Wadenheben.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgCalfraises = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgCalfraises.setText("");
		imgCalfraises.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgCalfraises);
		
		JLabel calfraisesSets = new JLabel("sets: 3-4, repetitions: 12-15");
		calfraisesSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		calfraisesSets.setBounds(360, 40, 190, 19);
		panel_1_1.add(calfraisesSets);
		
		JTextArea calfraisesTxtArea = new JTextArea();
		calfraisesTxtArea.setText("Stand on a slight elevation and hold a moderate weight plate or dumbbell in both\nhands. Now slowly go down and then push up explosively with your toes to hit the\ncalf muscles.");
		calfraisesTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		calfraisesTxtArea.setBackground(SystemColor.menu);
		calfraisesTxtArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(calfraisesTxtArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WorkoutFrame.parentPnl.remove(legsPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
				
			}
		});
		legsPnl.add(returnBtn);
		
		return legsPnl;
		
	}
	
	public JPanel getBicepsPanel() {
		
		JPanel bicepsPnl = new JPanel();
		WorkoutFrame.parentPnl.add(bicepsPnl, BorderLayout.CENTER);
		bicepsPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		bicepsPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/BizepsCurls.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgBicepsCurls = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgBicepsCurls.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel.add(imgBicepsCurls);
		
		JLabel lblBicepsCurls = new JLabel("Biceps Curls");
		lblBicepsCurls.setFont(Constants.HEADING1);
		lblBicepsCurls.setBounds(350, 11, 125, 26);
		panel.add(lblBicepsCurls);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel curlsSets = new JLabel("sets: 4, repetitions: 8-12");
		curlsSets.setFont(Constants.PLAINTEXT);
		curlsSets.setBounds(360, 40, 172, 19);
		panel.add(curlsSets);
		
		JTextArea curlsTxtArea = new JTextArea();
		curlsTxtArea.setText("Take two dumbbells with moderate weight and hold them at the side of your body.\nNow lift your arms and slightly turn your wrists in. Keep your arms close to your body\nand don't gain any momentum, so focus on your biceps. The downward movement\nshould now be slow and controlled.");
		curlsTxtArea.setFont(Constants.PLAINTEXT);
		curlsTxtArea.setBackground(Constants.MAINBACKGROUND);
		curlsTxtArea.setBounds(350, 62, 595, 134);
		panel.add(curlsTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		bicepsPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblHammerCurls = new JLabel("Hammer Curls");
		lblHammerCurls.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblHammerCurls.setBounds(350, 11, 254, 26);
		panel_1.add(lblHammerCurls);
		
		URL pushUpIconPath = this.getClass().getResource("/resources/HammerCurls1.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgHammerCurls = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth- 190, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgHammerCurls.setText("");
		imgHammerCurls.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgHammerCurls);
		
		JLabel hammerCurlsSets = new JLabel("sets: 4, repetitions: 8-12");
		hammerCurlsSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		hammerCurlsSets.setBounds(360, 40, 244, 19);
		panel_1.add(hammerCurlsSets);
		
		JTextArea hammerCurlsTxtArea = new JTextArea();
		hammerCurlsTxtArea.setText("The execution is identical to the biceps curls, except that now you don't rotate your\nwrists during the upward movement to hit the outer biceps.");
		hammerCurlsTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		hammerCurlsTxtArea.setBackground(SystemColor.menu);
		hammerCurlsTxtArea.setBounds(350, 62, 595, 134);
		panel_1.add(hammerCurlsTxtArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		bicepsPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblBarbellCurls = new JLabel("Barbell Curls");
		lblBarbellCurls.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblBarbellCurls.setBounds(350, 11, 222, 26);
		panel_1_1.add(lblBarbellCurls);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/Langhantelcurls2.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgBarbellCurls = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth - 50, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgBarbellCurls.setText("");
		imgBarbellCurls.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgBarbellCurls);
		
		JLabel barbellCurlsSets = new JLabel("sets: 3, repetitions: 8-12");
		barbellCurlsSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		barbellCurlsSets.setBounds(360, 40, 190, 19);
		panel_1_1.add(barbellCurlsSets);
		
		JTextArea barbellCurlsTxtArea = new JTextArea();
		barbellCurlsTxtArea.setText("Stand with your back against a wall and grasp the barbell about slightly wider than\nshoulder width. Your buttocks, the back of your head and your shoulders should be\nagainst the wall so that you lift the weight only from your biceps. Make sure to\nperform this exercise in a controlled manner without swinging.");
		barbellCurlsTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		barbellCurlsTxtArea.setBackground(SystemColor.menu);
		barbellCurlsTxtArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(barbellCurlsTxtArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WorkoutFrame.parentPnl.remove(bicepsPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
				
			}
		});
		bicepsPnl.add(returnBtn);
		
		return bicepsPnl;
		
	}
	
	public JPanel getTricepsPanel() {
		
		JPanel tricepsPnl = new JPanel();
		WorkoutFrame.parentPnl.add(tricepsPnl, BorderLayout.CENTER);
		tricepsPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		tricepsPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/Dips2.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgDips = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth - 100, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgDips.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel.add(imgDips);
		
		JLabel lblDips = new JLabel("Dips");
		lblDips.setFont(Constants.HEADING1);
		lblDips.setBounds(350, 11, 116, 26);
		panel.add(lblDips);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel dipsSets = new JLabel("sets: 4, repetitions: 8-12");
		dipsSets.setFont(Constants.PLAINTEXT);
		dipsSets.setBounds(360, 40, 172, 19);
		panel.add(dipsSets);
		
		JTextArea dipsTxtArea = new JTextArea();
		dipsTxtArea.setText("Stand between two dip bars and get into the starting position. Now push up\nexplosively and go down in a controlled manner. Be careful not to go too far down\n(maximum elbow at 90\u00B0) so as not to put too much strain on your shoulder.");
		dipsTxtArea.setFont(Constants.PLAINTEXT);
		dipsTxtArea.setBackground(Constants.MAINBACKGROUND);
		dipsTxtArea.setBounds(350, 62, 595, 134);
		panel.add(dipsTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		tricepsPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblPushdown = new JLabel("Pushdown");
		lblPushdown.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblPushdown.setBounds(350, 11, 254, 26);
		panel_1.add(lblPushdown);
		
		URL pushUpIconPath = this.getClass().getResource("/resources/Trizepsdrucken.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgPushdown = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgPushdown.setText("");
		imgPushdown.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgPushdown);
		
		JLabel pushdownSets = new JLabel("sets: 4, repetitions: 8-12");
		pushdownSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pushdownSets.setBounds(360, 40, 244, 19);
		panel_1.add(pushdownSets);
		
		JTextArea pushdownTxtArea = new JTextArea();
		pushdownTxtArea.setText("Place the cable pulley on the top step and choose an inclined grip. Stand with your\nupper body upright and make your back straight. The elbows are close to the body,\nthe chest is slightly leaned forward and then you press the weight press the weight\ndown without using your shoulders or any momentum.");
		pushdownTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		pushdownTxtArea.setBackground(SystemColor.menu);
		pushdownTxtArea.setBounds(350, 62, 595, 134);
		panel_1.add(pushdownTxtArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		tricepsPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblFrenchPress = new JLabel("French Press");
		lblFrenchPress.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblFrenchPress.setBounds(350, 11, 222, 26);
		panel_1_1.add(lblFrenchPress);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/FrenchPress.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgFrenchPress = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgFrenchPress.setText("");
		imgFrenchPress.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgFrenchPress);
		
		JLabel frenchPressSets = new JLabel("sets: 3, repetitions: 8-12");
		frenchPressSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		frenchPressSets.setBounds(360, 40, 190, 19);
		panel_1_1.add(frenchPressSets);
		
		JTextArea frenchPressTxtArea = new JTextArea();
		frenchPressTxtArea.setText("Lie on your back on a weight bench and stabilize yourself with your feet on the floor.\nNow take an SZ-bar or a barbell bar with a moderate weight and hold it stretched\nout above your head. Now bend your elbows and bring the weight to your head,\nnot rotating the arms and elbows outward. The French Press is also known as\nthe front press.");
		frenchPressTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		frenchPressTxtArea.setBackground(SystemColor.menu);
		frenchPressTxtArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(frenchPressTxtArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WorkoutFrame.parentPnl.remove(tricepsPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
				
			}
		});
		tricepsPnl.add(returnBtn);
		
		return tricepsPnl;
		
	}
	
	public JPanel getAbsPanel() {
		
		JPanel absPnl = new JPanel();
		WorkoutFrame.parentPnl.add(absPnl, BorderLayout.CENTER);
		absPnl.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(35, 42, 955, 207);
		absPnl.add(panel);
		panel.setLayout(null);
		
		URL bankdruckenIconPath = this.getClass().getResource("/resources/RollIns.png");
		BufferedImage bankdruckenIcon = null;
		try {
			bankdruckenIcon = ImageIO.read(bankdruckenIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgRollIns = new JLabel(new ImageIcon(((new ImageIcon(bankdruckenIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgRollIns.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel.add(imgRollIns);
		
		JLabel lblRollIns = new JLabel("Roll Ins");
		lblRollIns.setFont(Constants.HEADING1);
		lblRollIns.setBounds(350, 11, 116, 26);
		panel.add(lblRollIns);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBackground(new Color(204, 204, 204));
		separator.setBounds(340, 11, 15, 185);
		panel.add(separator);
		
		JLabel rollInsSets = new JLabel("sets: 3, repetitions: 15-20");
		rollInsSets.setFont(Constants.PLAINTEXT);
		rollInsSets.setBounds(360, 40, 172, 19);
		panel.add(rollInsSets);
		
		JTextArea rollInsTxtArea = new JTextArea();
		rollInsTxtArea.setText("Hang from a chin-up bar with an overhand grip, shoulder-width apart, and bring\nyour knees up to your chest. Make sure to swing as little as possible and thus to reach\nthe top using only your abdominal muscles.");
		rollInsTxtArea.setFont(Constants.PLAINTEXT);
		rollInsTxtArea.setBackground(Constants.MAINBACKGROUND);
		rollInsTxtArea.setBounds(350, 62, 595, 134);
		panel.add(rollInsTxtArea);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(35, 282, 955, 207);
		absPnl.add(panel_1);
		panel_1.setLayout(null);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(new Color(204, 204, 204));
		separator_1.setBounds(340, 11, 15, 185);
		panel_1.add(separator_1);
		
		JLabel lblLegRaise = new JLabel("Leg Raise");
		lblLegRaise.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblLegRaise.setBounds(350, 11, 254, 26);
		panel_1.add(lblLegRaise);
		
		URL pushUpIconPath = this.getClass().getResource("/resources/LegRaise.png");
		BufferedImage pushUpIcon = null;
		try {
			pushUpIcon = ImageIO.read(pushUpIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgLegRaise = new JLabel(new ImageIcon(((new ImageIcon(pushUpIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgLegRaise.setText("");
		imgLegRaise.setBounds(10, 21, Constants.imageExerciseWidth, Constants.imageExerciseHeight);
		panel_1.add(imgLegRaise);
		
		JLabel legRaiseSets = new JLabel("sets: 3, repetitions: 15-20");
		legRaiseSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		legRaiseSets.setBounds(360, 40, 244, 19);
		panel_1.add(legRaiseSets);
		
		JTextArea legRaiseTxtArea = new JTextArea();
		legRaiseTxtArea.setText("Lie on the floor or mat with your back fully stretched. Place your arms or hands next\nto your body and do not lift them off the floor during the exercise. Now lift your head\nand start to move your stretched legs upwards until they are perpendicular to the\nfloor.");
		legRaiseTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		legRaiseTxtArea.setBackground(SystemColor.menu);
		legRaiseTxtArea.setBounds(350, 62, 595, 134);
		panel_1.add(legRaiseTxtArea);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBounds(35, 520, 955, 207);
		absPnl.add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBackground(new Color(204, 204, 204));
		separator_1_1.setBounds(340, 11, 15, 185);
		panel_1_1.add(separator_1_1);
		
		JLabel lblJackknife = new JLabel("Jackknife");
		lblJackknife.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblJackknife.setBounds(350, 11, 222, 26);
		panel_1_1.add(lblJackknife);
		
		URL butterflyIconPath = this.getClass().getResource("/resources/JackKnife2.png");
		BufferedImage butterflyIcon = null;
		try {
			butterflyIcon = ImageIO.read(butterflyIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JLabel imgJackKnife = new JLabel(new ImageIcon(((new ImageIcon(butterflyIcon)).getImage()).getScaledInstance(Constants.imageExerciseWidth - 125, Constants.imageExerciseHeight, java.awt.Image.SCALE_SMOOTH)));
		imgJackKnife.setText("");
		imgJackKnife.setBounds(10, 21, 300, 175);
		panel_1_1.add(imgJackKnife);
		
		JLabel jackknifeSets = new JLabel("sets: 3, repetitions: 15-20");
		jackknifeSets.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jackknifeSets.setBounds(360, 40, 190, 19);
		panel_1_1.add(jackknifeSets);
		
		JTextArea jackknifeTxtArea = new JTextArea();
		jackknifeTxtArea.setText("Lie with your back fully stretched on the floor or a mat. Now bring your legs up similar\nto the Leg Raises and try to touch the tips of your toes with your arms outstretched.");
		jackknifeTxtArea.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		jackknifeTxtArea.setBackground(SystemColor.menu);
		jackknifeTxtArea.setBounds(350, 62, 595, 134);
		panel_1_1.add(jackknifeTxtArea);
		
		URL returnIconPath = this.getClass().getResource("/resources/exit.png");
		BufferedImage returnIcon = null;
		try {
			returnIcon = ImageIO.read(returnIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton returnBtn = new JButton(new ImageIcon(((new ImageIcon(returnIcon)).getImage()).getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH)));
		returnBtn.setBounds(0, 0, 45, 45);
		returnBtn.setForeground(Constants.LIGHTGRAY);
		returnBtn.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		returnBtn.setFocusPainted(false);
		returnBtn.setBorderPainted(false);
		returnBtn.setBorder(null);
		returnBtn.setBackground(Constants.DARKGREEN);
		returnBtn.setFocusPainted(false);
		returnBtn.setContentAreaFilled(false);
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				WorkoutFrame.parentPnl.remove(absPnl);
				WorkoutFrame.parentPnl.add(WorkoutFrame.mainPnl);
				WorkoutFrame.getFrame().repaint();
				WorkoutFrame.getFrame().revalidate();
				
			}
		});
		absPnl.add(returnBtn);
		
		return absPnl;
		
	}
	
}
