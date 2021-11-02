package gui;

import javax.swing.JFrame;

public class utils {

	public static JFrame update(JFrame frame) {
		
		frame.repaint();
		frame.revalidate();
		
		return frame;
		
	}
	
}
