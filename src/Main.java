import backend.MongoDBConnector;
import gui.FoodRecommendationFrame;
import gui.MainFrame;
import gui.MicronutrientsFrame;
import gui.SettingsFrame;
import gui.SupplementsFrame;

public class Main {

	public static void main(String[] args) {
		
		FoodRecommendationFrame foodRecommendationFrame = new FoodRecommendationFrame();
		SupplementsFrame supplementsFrame = new SupplementsFrame();
		SettingsFrame settingsFrame = new SettingsFrame();
		MicronutrientsFrame microNutrientsFrame = new MicronutrientsFrame();
		MainFrame mainFrame = new MainFrame();
		
		//MongoDBConnector.getMacronutrientsAndCalories("MarcAndresen");		
	}

}
