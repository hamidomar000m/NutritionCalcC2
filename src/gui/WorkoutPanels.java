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
		
		JLabel benchpressSets = new JLabel("sets: 5, repetition: 8-12");
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
		
		URL pushUpIconPath = this.getClass().getResource("/resources/Liegestutze2.png");
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
		
		JLabel pushupsSets = new JLabel("sets: 4, repetition: max");
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
		
		JLabel butterflySets = new JLabel("sets: 4, repetition: 8-12");
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

}
