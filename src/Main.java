import gui.FoodRecommendationFrame;
import gui.MainFrame;
import gui.SupplementsFrame;

public class Main {

	public static void main(String[] args) {

//		MongoDBConnector.getSupplements(MongoDBConnector.getAim());
//		connector.getFoodRecommendation();
		// LoginFrame loginFrame = new LoginFrame("Test", 450, 800);

		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { MainFrame
		 * window = new MainFrame(); window.getFrame().setVisible(true); } catch
		 * (Exception e) { e.printStackTrace(); } } });
		 */

		MainFrame mainFrame = new MainFrame();
		// SettingsFrame settingsFrame = new SettingsFrame();
		// MicronutrientsFrame microFrame = new MicronutrientsFrame();

		// Test, Test, Test
		FoodRecommendationFrame foodFrame = new FoodRecommendationFrame();
		SupplementsFrame supFrame = new SupplementsFrame();
	}

}
