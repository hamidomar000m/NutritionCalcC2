package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class LoginFrame {
	
	JFrame frame;
	
	public LoginFrame(final String title, final int width, final int height) {
		
		//Grundeinstellungen für das Frame zum Login
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(width, height);
		frame.getContentPane().setBackground(new Color(50, 72, 81));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//Der Name der App als Überschrift
		JLabel appName = new JLabel("Clean Eat", SwingConstants.CENTER);
		appName.setForeground(Color.white);
		appName.setFont(new Font("Verdana", Font.BOLD, 60));
		
		//Alles, was zum Login gehört auf einem Panel
		JPanel loginPanel = new JPanel();
		JLabel loginLabel = new JLabel("Anmelden");
		loginLabel.setForeground(Color.white);
		loginLabel.setFont(new Font("Verdana", Font.PLAIN, 24));
		JLabel userName = new JLabel("Benutzername:");
		userName.setForeground(Color.white);
		JTextField userNameInput = new JTextField(30);
		loginPanel.setBackground(new Color(50, 72, 81));
		loginPanel.add(loginLabel);
		loginPanel.add(userName);
		loginPanel.add(userNameInput);
		
		frame.getContentPane().add(BorderLayout.PAGE_START, appName);
		frame.getContentPane().add(BorderLayout.CENTER, loginPanel);
		
		update();
		
	}
	
	public void update() {
		
		frame.repaint();
		frame.revalidate();
		
	}
	
}
