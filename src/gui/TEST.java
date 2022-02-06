package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class TEST {
	
	private static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("Home");
		frame.setBounds(100, 100, 1250, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.add(new SidePanel("login"), BorderLayout.WEST);
		
		frame.setVisible(true);
	}

}
