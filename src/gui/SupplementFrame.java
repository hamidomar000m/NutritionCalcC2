package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.table.AbstractTableModel;

import backend.MongoDBConnector;
import gui.SupplementsFrame.MyTableModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

public class SupplementFrame implements MouseListener {

	private static JFrame frame;
	private static JTable supTable;
	private JScrollPane scrollPane;
	public JButton passwordBtn;
	public JButton btnSettings;
	public JButton bodydataBtn;
	public JButton deleteAccBtn;

	public SupplementFrame() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame("Supplements");
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
		btnHome.setBounds(35, 175, 73, 23);
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
		foodRecBtn.setBounds(35, 215, 55, 23);
		foodRecBtn.addActionListener(new ActionListener() {

			@Override
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
		supBtn.setFont(Constants.BUTTONTEXTBOLD);
		supBtn.setFocusPainted(false);
		supBtn.setBorderPainted(false);
		supBtn.setBorder(null);
		supBtn.setBackground(Constants.MIDGREEN);
		supBtn.setBounds(35, 255, 138, 26);
		supBtn.setEnabled(false);
		sidePnl.add(supBtn);
		
		JButton btnWorkout = new JButton("Workout");
		btnWorkout.setHorizontalAlignment(SwingConstants.LEFT);
		btnWorkout.setForeground(Constants.LIGHTGRAY);
		btnWorkout.setFont(Constants.BUTTONTEXT);
		btnWorkout.setFocusPainted(false);
		btnWorkout.setBorderPainted(false);
		btnWorkout.setBorder(null);
		btnWorkout.setBackground(Constants.MIDGREEN);
		btnWorkout.setBounds(35, 295, 84, 23);
		btnWorkout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
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
		
		JPanel mainPnl = new JPanel();
		parentPnl.add(mainPnl, BorderLayout.CENTER);
		mainPnl.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 227, 831, 316);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainPnl.add(scrollPane);
		
		String[][] tableData = MongoDBConnector.getSupplements(MongoDBConnector.getAim(MongoDBConnector._id));
		String[] columnNames = {
				"Supplement", "Description"
		};
		
		supTable = new JTable(new MyTableModel()) {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			//get table cell tool tips
			public String getToolTipText(MouseEvent e) {
                String tip = null;
                java.awt.Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);
                int realColumnIndex = convertColumnIndexToModel(colIndex);

                if (realColumnIndex == 1) {
                    tip = (String) getValueAt(rowIndex, colIndex);
                }
                
                return tip;
            }
			
		};
		
		supTable.setEnabled(false);
		supTable.setRowMargin(3);
		supTable.setRowHeight(25);
		supTable.setFont(Constants.PLAINTEXT);
		supTable.addMouseListener(this);
		scrollPane.setViewportView(supTable);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(Constants.HEADING1);
		nameLabel.setBounds(267, 194, 67, 26);
		mainPnl.add(nameLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(Constants.HEADING1);
		descriptionLabel.setBounds(640, 190, 125, 26);
		mainPnl.add(descriptionLabel);
		
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
	
	class MyTableModel extends AbstractTableModel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames = {"Supplement",
                                        "Description"};
        
        private String[][] tableData = MongoDBConnector.getSupplements(MongoDBConnector.getAim(MongoDBConnector._id));
        
		public int getRowCount() {
			return tableData.length;
		}
		
		public int getColumnCount() {
			return columnNames.length;
		}
		
		public Object getValueAt(int row, int col) {
			return tableData[row][col];
		}
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		String tip = supTable.getToolTipText(e);
		
        java.awt.Point p = e.getPoint();
        int rowIndex = supTable.rowAtPoint(p);
        int colIndex = supTable.columnAtPoint(p);
        int realColumnIndex = supTable.convertColumnIndexToModel(colIndex);

        if (realColumnIndex == 1) {
        	JOptionPane.showMessageDialog(null, tip, "Description", JOptionPane.INFORMATION_MESSAGE);
        }
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
