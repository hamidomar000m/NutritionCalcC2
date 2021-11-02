package gui;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import backend.MongoDBConnector;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.MouseInputListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class SupplementsFrame {

	
	private static JFrame frame;
	
	public SupplementsFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Supplements");
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel heading = new JLabel("Supplements");
		heading.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 36));
		heading.setBounds(376, 28, 231, 45);
		frame.getContentPane().add(heading);
		
		JTable supTable = new JTable(new MyTableModel()) {
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
		supTable.setRowMargin(3);
		supTable.setRowHeight(25);
		supTable.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(92, 250, 800, 215);
		frame.getContentPane().add(scrollPane1);
		
		scrollPane1.setViewportView(supTable);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		nameLabel.setBounds(267, 194, 52, 30);
		frame.getContentPane().add(nameLabel);
		
		JLabel descriptionLabel = new JLabel("Description");
		descriptionLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		descriptionLabel.setBounds(638, 194, 102, 30);
		frame.getContentPane().add(descriptionLabel);
		
		JButton homeButton = new JButton("Home");
		homeButton.setFont(new Font("Arial", Font.PLAIN, 16));
		homeButton.setBounds(33, 560, 210, 30);
		frame.getContentPane().add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("food recommendation clicked");
				frame.setVisible(false);
				MainFrame.displayFrame();
			}
		});
		
		JButton foodButton = new JButton("Food Recommendation");
		foodButton.setFont(new Font("Arial", Font.PLAIN, 16));
		foodButton.setBounds(738, 560, 210, 30);
		frame.getContentPane().add(foodButton);
		foodButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("food recommendation clicked");
				frame.setVisible(false);
				FoodRecommendationFrame.displayFrame();
			}
		});
		
		
		frame.setVisible(true);
		frame = utils.update(frame);
	}
	
	class MyTableModel extends AbstractTableModel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private String[] columnNames = {"",
                                        ""};
        
        private String[][] tableData = MongoDBConnector.getSupplements(MongoDBConnector.getAim());
        
		@Override
		public int getRowCount() {
			return tableData.length;
		}
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}
		@Override
		public Object getValueAt(int row, int col) {
			return tableData[row][col];
		}
	}
	
	public static void displayFrame() {
		frame.setVisible(true);
	}

	
}
