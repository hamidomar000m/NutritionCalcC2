package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.MongoDBConnector;

import java.awt.Font;
import java.awt.Frame;

public class MicronutrientsFrame {

	public static JFrame frame;

	public MicronutrientsFrame() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame("Micronutrients");
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(Constants.MAINBACKGROUND);
		frame.getContentPane().setLayout(null);
		frame.setBounds(100, 100, 400, 800);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		JLabel lblHeading = new JLabel("Micronutrients");
		lblHeading.setFont(Constants.HEADING);
		lblHeading.setBounds(98, 53, 204, 33);
		frame.getContentPane().add(lblHeading);
		
		JPanel topPnl = new JPanel();
		topPnl.setPreferredSize(new Dimension(10, 30));
		topPnl.setBackground(Constants.MIDGREEN);
		topPnl.setBounds(0, 0, frame.getWidth(), 30);
		topPnl.setLayout(new BorderLayout(0, 0));
		frame.getContentPane().add(topPnl);
		
		JPanel actionPnl = new JPanel();
		actionPnl.setPreferredSize(new Dimension(50, 10));
		actionPnl.setBackground(Constants.MIDGREEN);
		topPnl.add(actionPnl, BorderLayout.EAST);
		
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
		minimizeBtn.setBackground(Constants.MIDGREEN);
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
		closeBtn.setBackground(Constants.MIDGREEN);
		closeBtn.setFocusPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				StartFrame.enableFrame();
				
			}
		});
		actionPnl.add(closeBtn, BorderLayout.EAST);
		
		String[] tableHeading = {"Micronutrient", "Amount"};
		
		String[][] tableData = MongoDBConnector.getMicronutrients(MongoDBConnector._id);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 121, 277, 585);
		frame.getContentPane().add(scrollPane);
		
		JTable micronutrientTable = new JTable(tableData, tableHeading);
		micronutrientTable.setEnabled(false);
		micronutrientTable.setFont(Constants.PLAINTEXT);
		micronutrientTable.setRowMargin(3);
		micronutrientTable.setRowHeight(25);
		scrollPane.setViewportView(micronutrientTable);
		
		frame.setVisible(false);
		
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}
	
}
