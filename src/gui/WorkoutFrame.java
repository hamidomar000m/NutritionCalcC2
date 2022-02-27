package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
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
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import backend.MongoDBConnector;
import java.awt.Color;
import java.awt.SystemColor;

public class WorkoutFrame {

	private static JFrame frame;
	public static JPanel parentPnl;
	public static JPanel mainPnl;
	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;
	private WorkoutPanels workoutPanel;

	public WorkoutFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("Workout");
		frame.setUndecorated(true);
		frame.setBounds(100, 100, 1250, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		workoutPanel = new WorkoutPanels();
		
		parentPnl = new JPanel();
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
		
		mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		URL chestIconPath = this.getClass().getResource("/resources/Brust.png");
		BufferedImage chestIcon = null;
		try {
			chestIcon = ImageIO.read(chestIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnChest = new JButton(new ImageIcon(((new ImageIcon(chestIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnChest.setHorizontalAlignment(SwingConstants.LEFT);
		btnChest.setForeground(Color.BLACK);
		btnChest.setFont(Constants.BUTTONMUSCLETEXT);
		btnChest.setFocusPainted(false);
		btnChest.setBorderPainted(false);
		btnChest.setContentAreaFilled(false);
		btnChest.setBorder(null);
		btnChest.setBackground(Constants.MAINBACKGROUND);
		btnChest.setBounds(93, 58, Constants.imageWidth, Constants.imageHeight);
		btnChest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getChestPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		
		mainPnl.add(btnChest);
		
		URL backIconPath = this.getClass().getResource("/resources/Rucken.png");
		BufferedImage backIcon = null;
		try {
			backIcon = ImageIO.read(backIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnBack = new JButton(new ImageIcon(((new ImageIcon(backIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(Constants.BUTTONMUSCLETEXT);
		btnBack.setFocusPainted(false);
		btnBack.setBorderPainted(false);
		btnBack.setBorder(null);
		btnBack.setBackground(Constants.MAINBACKGROUND);
		btnBack.setContentAreaFilled(false);
		btnBack.setBounds(412, 58, Constants.imageWidth, Constants.imageHeight);
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getBackPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		mainPnl.add(btnBack);
		
		URL legIconPath = this.getClass().getResource("/resources/Beine.png");
		BufferedImage legIcon = null;
		try {
			legIcon = ImageIO.read(legIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnLegs = new JButton(new ImageIcon(((new ImageIcon(legIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnLegs.setHorizontalAlignment(SwingConstants.LEFT);
		btnLegs.setForeground(Color.BLACK);
		btnLegs.setFont(Constants.BUTTONMUSCLETEXT);
		btnLegs.setFocusPainted(false);
		btnLegs.setBorderPainted(false);
		btnLegs.setBorder(null);
		btnLegs.setBackground(Constants.MAINBACKGROUND);
		btnLegs.setBounds(751, 58, Constants.imageWidth, Constants.imageHeight);
		btnLegs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getLegsPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		mainPnl.add(btnLegs);
		
		URL absIconPath = this.getClass().getResource("/resources/Bauch.png");
		BufferedImage absIcon = null;
		try {
			absIcon = ImageIO.read(absIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnAbs = new JButton(new ImageIcon(((new ImageIcon(absIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnAbs.setHorizontalAlignment(SwingConstants.LEFT);
		btnAbs.setForeground(Color.BLACK);
		btnAbs.setFont(Constants.BUTTONMUSCLETEXT);
		btnAbs.setFocusPainted(false);
		btnAbs.setBorderPainted(false);
		btnAbs.setBorder(null);
		btnAbs.setBackground(Constants.MAINBACKGROUND);
		btnAbs.setBounds(93, 437, Constants.imageWidth, Constants.imageHeight);
		btnAbs.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getAbsPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		mainPnl.add(btnAbs);
		
		URL bicepsIconPath = this.getClass().getResource("/resources/Bizeps.png");
		BufferedImage bicepsIcon = null;
		try {
			bicepsIcon = ImageIO.read(bicepsIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnBiceps = new JButton(new ImageIcon(((new ImageIcon(bicepsIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnBiceps.setHorizontalAlignment(SwingConstants.LEFT);
		btnBiceps.setForeground(Color.BLACK);
		btnBiceps.setFont(Constants.BUTTONMUSCLETEXT);
		btnBiceps.setFocusPainted(false);
		btnBiceps.setBorderPainted(false);
		btnBiceps.setBorder(null);
		btnBiceps.setBackground(Constants.MAINBACKGROUND);
		btnBiceps.setBounds(412, 437, Constants.imageWidth, Constants.imageHeight);
		btnBiceps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getBicepsPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		mainPnl.add(btnBiceps);
		
		URL tricepsIconPath = this.getClass().getResource("/resources/Trizeps.png");
		BufferedImage tricepsIcon = null;
		try {
			tricepsIcon = ImageIO.read(tricepsIconPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		JButton btnTriceps = new JButton(new ImageIcon(((new ImageIcon(tricepsIcon)).getImage()).getScaledInstance(Constants.imageWidth, Constants.imageHeight, java.awt.Image.SCALE_SMOOTH)));
		btnTriceps.setHorizontalAlignment(SwingConstants.LEFT);
		btnTriceps.setForeground(Color.BLACK);
		btnTriceps.setFont(Constants.BUTTONMUSCLETEXT);
		btnTriceps.setFocusPainted(false);
		btnTriceps.setBorderPainted(false);
		btnTriceps.setBorder(null);
		btnTriceps.setBackground(Constants.MAINBACKGROUND);
		btnTriceps.setBounds(751, 437, Constants.imageWidth, Constants.imageHeight);
		btnTriceps.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				parentPnl.remove(mainPnl);
				parentPnl.add(workoutPanel.getTricepsPanel(), BorderLayout.CENTER);
				parentPnl.revalidate();
				parentPnl.repaint();
				
			}
		});
		mainPnl.add(btnTriceps);
		
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

	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		WorkoutFrame.frame = frame;
	}
}
