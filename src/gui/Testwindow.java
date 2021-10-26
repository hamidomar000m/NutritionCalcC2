package gui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Testwindow{
	public static void main( String[] args ){
		// Die Daten für das Table
		String[][] data = new String[][]{
				{"a", "b", "c", "d"},
				{"e", "f", "g", "h"},
				{"i", "j", "kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk\n kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk", "l"}
		};
		
		// Die Column-Titles
		String[] title = new String[]{
				"A", "B", "C", "D"
		};
		
		// Das JTable initialisieren
		JTable table = new JTable( data, title );
		
		JFrame frame = new JFrame( "Demo" );
		frame.getContentPane().add( new JScrollPane( table ) );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.pack();
		frame.setVisible( true );
	}
}
