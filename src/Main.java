import gui.BodyDataFrame;
import gui.FoodsFrame;
import gui.LogInFrm;
import gui.LoginFrame;
import gui.PasswordFrame;
import gui.RegisterFrame;
import gui.SettingFrame;
import gui.StartFrame;
import gui.SupplementFrame;
import gui.TrackingFrame;
import gui.WorkoutFrame;

public class Main {

	public static void main(String[] args) {
	
		//LogInFrm loginFrame = new LogInFrm();
		StartFrame devFrame = new StartFrame("robertwitzke");
		FoodsFrame devFoodFrame = new FoodsFrame();
		SupplementFrame devSupFrame = new SupplementFrame("robertwitzke");
		WorkoutFrame devWorkFrame = new WorkoutFrame();
		TrackingFrame trackDevFrame = new TrackingFrame();
		SettingFrame settingDevFrame = new SettingFrame();
		PasswordFrame passwordDevFrame = new PasswordFrame();
		BodyDataFrame bodydataDevFrame = new BodyDataFrame();
		//LoginFrame loginDevFrame = new LoginFrame();
		//RegisterFrame registerDevFrame = new RegisterFrame();
		
	}

}
