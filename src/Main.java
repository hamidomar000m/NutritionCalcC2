import java.awt.EventQueue;

import backend.MongoDBConnector;
import gui.FoodRecommendationFrame;
import gui.LoginFrame;
import gui.MainFrame;
import gui.MicronutrientsFrame;

public class Main {

	public static void main(String[] args) {
		
//		MongoDBConnector connector = new MongoDBConnector("fats");
//		connector.getFoodRecommendation();
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
		
		MainFrame mainFrame = new MainFrame();
		//MicronutrientsFrame microFrame = new MicronutrientsFrame();
		//Test, Test, Test
		FoodRecommendationFrame frame = new FoodRecommendationFrame();
//		SupplementsFrame frame = new SupplementsFrame();
	}

}
