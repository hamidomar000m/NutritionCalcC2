package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class SettingsFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private boolean isVisible = false;

	public SettingsFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 400, 700);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.getContentPane().setLayout(null);
		
		JLabel lblHeading = new JLabel("Settings");
		lblHeading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		lblHeading.setBounds(125, 36, 146, 43);
		frame.getContentPane().add(lblHeading);
		
		JLabel lblNewLabel = new JLabel("user data");
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(156, 109, 84, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("enter new password");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 248, 114, 14);
		lblNewLabel_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(38, 273, 212, 31);
		textField.setVisible(false);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("confirm new password");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(38, 320, 126, 14);
		lblNewLabel_1_1.setVisible(false);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(38, 343, 212, 31);
		textField_1.setVisible(false);
		frame.getContentPane().add(textField_1);
		
		JButton btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.setBounds(38, 385, 89, 23);
		btnNewButton_1.setVisible(false);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("change password");
		btnNewButton.setBounds(117, 141, 162, 31);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(!isVisible) {
					
					lblNewLabel_1.setVisible(true);
					textField.setVisible(true);
					lblNewLabel_1_1.setVisible(true);
					textField_1.setVisible(true);
					btnNewButton_1.setVisible(true);
					
					isVisible = true;
					
				} else {
					
					lblNewLabel_1.setVisible(false);
					textField.setVisible(false);
					lblNewLabel_1_1.setVisible(false);
					textField_1.setVisible(false);
					btnNewButton_1.setVisible(false);
					
					isVisible = false;
					
				}
				
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		JButton btnKrperdatenAktualisieren = new JButton("refresh body data");
		btnKrperdatenAktualisieren.setBounds(117, 183, 162, 31);
		frame.getContentPane().add(btnKrperdatenAktualisieren);
		
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
