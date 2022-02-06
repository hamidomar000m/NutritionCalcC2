package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import backend.MongoDBConnector;

public class SidePanel extends JPanel {

	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;
	
	public SidePanel(String version) {
		JPanel sidePnl = new JPanel();
		sidePnl.setSize(new Dimension(250, 770));
		sidePnl.setBackground(Constants.MIDGREEN);

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

		if(version == "main") {
			JButton btnHome = new JButton("Home");
			btnHome.setHorizontalAlignment(SwingConstants.LEFT);
			btnHome.setForeground(Constants.LIGHTGRAY);
			btnHome.setFont(Constants.BUTTONTEXTBOLD);
			btnHome.setFocusPainted(false);
			btnHome.setBorderPainted(false);
			btnHome.setBorder(null);
			btnHome.setBackground(Constants.MIDGREEN);
			btnHome.setBounds(35, 175, 84, 26);
			btnHome.setEnabled(false);
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

				public void actionPerformed(ActionEvent e) {

					MasterFrame.frame.setVisible(false);
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
			supBtn.setBounds(35, 255, 138, 23);
			supBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MasterFrame.frame.setVisible(false);
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

					MasterFrame.frame.setVisible(false);
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
			btnTracking.setFont(Constants.BUTTONTEXT);
			btnTracking.setFocusPainted(false);
			btnTracking.setBorderPainted(false);
			btnTracking.setBorder(null);
			btnTracking.setBackground(Constants.MIDGREEN);
			btnTracking.setBounds(35, 335, 72, 23);
			btnTracking.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MasterFrame.frame.setVisible(false);
					TrackingFrame.displayFrame();
					btnSettings.setEnabled(true);
					btnSettings.setFont(Constants.BUTTONTEXT);
					passwordBtn.setVisible(false);
					bodydataBtn.setVisible(false);
					deleteAccBtn.setVisible(false);

				}

			});
			sidePnl.add(btnTracking);
			
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
			
			passwordBtn = new JButton("Change password");
			passwordBtn.setHorizontalAlignment(SwingConstants.LEFT);
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

					MasterFrame.frame.setVisible(false);
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
			bodydataBtn.setBounds(60, 664, 168, 21);
			bodydataBtn.setVisible(false);
			bodydataBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					MasterFrame.frame.setVisible(false);
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
			deleteAccBtn.setBounds(60, 696, 144, 21);
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
		} else if(version == "login") {
			JButton btnLogin = new JButton("Login");
			btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
			btnLogin.setForeground(Constants.LIGHTGRAY);
			btnLogin.setFont(Constants.BUTTONTEXTBOLD);
			btnLogin.setFocusPainted(false);
			btnLogin.setBorderPainted(false);
			btnLogin.setBorder(null);
			btnLogin.setBackground(Constants.MIDGREEN);
			btnLogin.setBounds(35, 175, 65, 26);
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					MasterFrame.frame.setVisible(false);
					LoginFrame.displayFrame();
					
				}
			});
			sidePnl.add(btnLogin);
			
			JButton btnRegister = new JButton("Register");
			btnRegister.setHorizontalAlignment(SwingConstants.LEFT);
			btnRegister.setForeground(Constants.LIGHTGRAY);
			btnRegister.setFont(Constants.BUTTONTEXTBOLD);
			btnRegister.setFocusPainted(false);
			btnRegister.setBorderPainted(false);
			btnRegister.setBorder(null);
			btnRegister.setBackground(Constants.MIDGREEN);
			btnRegister.setBounds(35, 215, 88, 26);
			btnRegister.setEnabled(false);
			sidePnl.add(btnRegister);
		} else {
			//irgendeine Fehlermeldung
		}
	}

}
