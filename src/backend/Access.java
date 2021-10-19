package backend;

import java.util.HashMap;
import java.util.Map;

import gui.InputDataFrame;

public class Access{
	
	public static String userName;
	public static String userPassword;
	public static String userGender;
	public static String userWeight;
	public static String userHeight;
	public static String userAge;
	

	
	public Access() {
		super();
		this.userName = userName;
		this.userPassword = userPassword;  
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
		
	}

	public Access(String userName, String userPassword, String userGender, String userWeight, String userHeight, String userAge) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
	}
	
	@Override
	public String toString() {
		return "Access [userName=" + userName + ", userPassword=" + userPassword + "userGender=" + userGender + ", userWeight=" + userWeight + ", userHeight=" + userHeight +", userAge=" + userAge + "]";
	}
	
	public static Map<String, Object> toMap(){
		Map<String, Object>map = new HashMap<String, Object>();
		map.put("userName", userName);
		map.put("userPassword", userPassword);
		map.put("userGender", userGender);
		map.put("userWeight", userWeight);
		map.put("userHeight", userHeight);
		map.put("userAge", userAge);
		System.out.println("User has been saved to Hashmap");
		
		return map;
	
	}
	
	
	
	

}
