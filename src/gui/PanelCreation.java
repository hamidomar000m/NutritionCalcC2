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

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backend.MongoDBConnector;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.ScrollPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.Icon;
import javax.swing.JTextArea;

public class PanelCreation {

	private static JFrame frame;
	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;

	public PanelCreation() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Workout");
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
		headingLbl.setBounds(35, 50, 192, 36);
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
		bodydataBtn.setBounds(60, 664, 167, 21);
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
		deleteAccBtn.setBounds(60, 696, 138, 21);
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
		btnHome.setBounds(35, 175, 60, 23);
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
		foodRecBtn.setBounds(35, 215, 60, 23);
		foodRecBtn.addActionListener(new ActionListener() {
			
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
		supBtn.setBounds(35, 255, 126, 23);
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
		btnWorkout.setFont(Constants.BUTTONTEXTBOLD);
		btnWorkout.setFocusPainted(false);
		btnWorkout.setBorderPainted(false);
		btnWorkout.setBorder(null);
		btnWorkout.setBackground(Constants.MIDGREEN);
		btnWorkout.setBounds(35, 295, 94, 26);
		btnWorkout.setEnabled(false);
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
				btnSettings.setEnabled(true);
				btnSettings.setFont(Constants.BUTTONTEXT);
				passwordBtn.setVisible(false);
				bodydataBtn.setVisible(false);
				deleteAccBtn.setVisible(false);
				
			}
			
		});
		sidePnl.add(btnTracking);
		
		JPanel absPnl = new JPanel();
		parentPnl.add(absPnl, BorderLayout.CENTER);
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
				frame.repaint();
				frame.revalidate();
				
			}
		});
		absPnl.add(returnBtn);
		
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
		
		JLabel currentWindowLbl = new JLabel(this.frame.getTitle());
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
}
