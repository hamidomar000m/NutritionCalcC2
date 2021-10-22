import java.awt.EventQueue;

import backend.MongoDBConnector;
import gui.LoginFrame;
import gui.MainFrame;
import gui.MicronutrientsFrame;
import gui.SettingsFrame;

public class Main {

	public static void main(String[] args) {
		
		//MongoDBConnector connector = new MongoDBConnector();
		//LoginFrame loginFrame = new LoginFrame("Test", 450, 800);
		
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
		
		//MainFrame mainFrame = new MainFrame();
		SettingsFrame settingsFrame = new SettingsFrame();
		//MicronutrientsFrame microFrame = new MicronutrientsFrame();
		
	}

}
