package backend;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import gui.BodyDataFrame;
import gui.FoodRecommendationFrame;
import gui.FoodsFrame;
import gui.LogInFrm;
import gui.LoginFrame;
import gui.MainFrame;
import gui.MicronutrientsFrame;
import gui.PasswordFrame;
import gui.RegisterFrame;
import gui.SettingFrame;
import gui.SettingsFrame;
import gui.SignUpFrame;
import gui.StartFrame;
import gui.SupplementFrame;
import gui.SupplementsFrame;
import gui.TrackingFrame;
import gui.WorkoutFrame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import org.bson.Document;

public class MongoDBConnector {

	public static String _id;
	public static String userPassword;
	public static String userGender;
	public static String userWeight;
	public static String userHeight;
	public static String userAge;
	public static String userGoal;
	public static String userActivity;
	public static boolean notAlreadyRegistered;
	
	//tracked data
	public static double trackedCalorie = 0;
	public static double trackedCarbo = 0;
	public static double trackedProtein = 0;
	public static double trackedFat = 0;
	

	static MongoClient mongoClient = null;

	public MongoDBConnector(String _id, String userPassword) {
		super();
		this._id = _id;
		this.userPassword = userPassword;
		connectDB();

	}

	public MongoDBConnector(String _id, String userPassword, String userGender, String userAge, String userHeight,
			String userWeight, String userGoal, String userActivity) { // , String userGoal, String userActivity)
		super();
		this._id = _id;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
		this.userGoal = userGoal;
		this.userActivity = userActivity;
		connectDB();
	}

	private static void connectDB() {

		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);

			System.out.println("Connectionn created");

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

	}

	public static void signUpUser() {

		try {
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", _id);
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users")
					.find(searchQuery).iterator();
			if ((_id.length() == 0 || userPassword.length() <= 5 || userAge.length() == 0 || userGender.length() == 0
					|| userHeight.length() == 0 || userWeight.length() == 0 || userHeight.equalsIgnoreCase("in cm"))
					|| userWeight.equalsIgnoreCase("in kg") == true) {

				JOptionPane.showMessageDialog(null,
						"Invalid data!\r\nNo field should be empty!\r\nPassword should be at least 6 characters.",
						"ERROR", JOptionPane.ERROR_MESSAGE);

			} else {
				try {

					Document document = new Document("_id", _id).append("userPassword", userPassword)
							.append("userGender", userGender).append("userWeight", userWeight)
							.append("userHeight", userHeight).append("userAge", userAge).append("userGoal", userGoal)
							.append("userActivity", userActivity);
					mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").insertOne(document);
					notAlreadyRegistered = true;
					RegisterFrame.hideFrame();
					LoginFrame.hideFrame();

				} catch (Exception e) {
					System.out.println("Something went wrong : " + e);
					notAlreadyRegistered = false;
					JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);

				}

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid data or user already exists!", "ERROR",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	public static void logInUser() {

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("_id", _id);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users")
					.find(searchQuery_id).iterator();

			if (cursor.hasNext()) {

				if (cursor.next().get("userPassword").equals(userPassword)) {

					StartFrame mainFrame = new StartFrame();
					StartFrame.displayFrame();

					FoodsFrame foodRecommendationFrame = new FoodsFrame();
					SupplementFrame supplementsFrame = new SupplementFrame();
					MicronutrientsFrame microNutrientsFrame = new MicronutrientsFrame();
					WorkoutFrame workoutFrame = new WorkoutFrame();
					TrackingFrame trackingFrame = new TrackingFrame();
					PasswordFrame passwordFrame = new PasswordFrame();
					BodyDataFrame bodyDataFrame = new BodyDataFrame();

					LoginFrame.hideFrame();
					RegisterFrame.hideFrame();

				} else {

					JOptionPane.showMessageDialog(null, "Invalid Password!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			} else {
				System.out.println("No user by that _id");

				JOptionPane.showMessageDialog(null, "User does not exist! Please, register!", "ERROR",
						JOptionPane.ERROR_MESSAGE);

			}
		} catch (Exception e) {
			System.out.println("log in didnt work");

		}

	}

	public static boolean isUserRegistered(final String userName) {

		boolean isRegistered = false;
		try {
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", userName);
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users")
					.find(searchQuery).iterator();
			isRegistered = true;
			
			while (cursor.hasNext()) {
				if(((String)cursor.next().get("_id")).equals(userName)) {
					System.out.println((String)cursor.next().get("_id"));
					isRegistered = true;
				}
			}
			
		} catch (Exception e) {
			isRegistered = false;
		}

		System.out.println(isRegistered);
		return isRegistered;

	}

	public static void insertNutrients(String _id, double[] nutritionalValues, String[] names, String[] nutrients) {

		MongoCollection collection = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("nutrients");

		try {
			Document document = new Document("_id", _id).append("Kalorienbedarf", nutritionalValues[0])
					.append("Proteine", nutritionalValues[1]).append("Fette", nutritionalValues[2])
					.append("Kohlenhydrate", nutritionalValues[3]);
			for (int i = 0; i < names.length; i++) {
				document.append(names[i], nutrients[i]);
			}
			collection.insertOne(document);

		} catch (Exception e) {
		}

		System.out.println("Nutrients saved");

	}

	public static ArrayList<String> getFoodRecommendation(final String column) {

		ArrayList<String> data = new ArrayList<String>();

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("column", column);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("food-recommendation").find(searchQuery_id).iterator();

			while (cursor.hasNext()) {
				data.add((String) cursor.next().get("product"));
			}

		} catch (Exception e) {
		}
		return data;
	}

	public static String[][] getSupplements(final String aim) {

		ArrayList<String> supDataList = new ArrayList<String>();
		ArrayList<String> desDataList = new ArrayList<String>();
		String[][] supData = new String[8][2];

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("aim", aim);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("supplements").find(searchQuery_id).iterator();
			MongoCursor<Document> cursor2 = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("supplements").find(searchQuery_id).iterator();

			MongoCursor<Document> cur = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("nutrients")
					.find().iterator();

			while (cursor.hasNext()) {
				supDataList.add((String) cursor.next().get("supplement"));
			}
			while (cursor2.hasNext()) {
				desDataList.add((String) cursor2.next().get("description"));
			}
			int counter = 0;
			for (int i = 0; i < supDataList.size(); i++) {
				supData[counter][0] = supDataList.get(i);
				supData[counter][1] = desDataList.get(i);
				counter++;
			}

		} catch (Exception e) {
		}

		return supData;
	}

	public static String[] getMacronutrientsAndCalories(final String userName) {

		String[] data = new String[4];
		ArrayList<String> dataList = new ArrayList<String>();

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("_id", userName);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("nutrients").find(searchQuery_id).iterator();

			while (cursor.hasNext()) {

				Document document = cursor.next();
				Set<String> keys = document.keySet();
				Iterator iterator = keys.iterator();
				while (iterator.hasNext()) {

					String key = (String) iterator.next();
					String value = (String) document.get(key).toString();
					dataList.add(value);

				}

				for (int i = 1; i < keys.size() - 34; i++) {
					data[i - 1] = dataList.get(i);
				}

			}

		} catch (Exception e) {
			System.out.println("error");
		}
		System.out.println( Arrays.toString(data) + "mongodbcon - getMacronutrientsAndCalories");
		return data;
		

	}

	public static String[][] getMicronutrients(final String userName) {

		String[][] nutrientData = new String[34][2];
		ArrayList<String> nutrientList = new ArrayList<String>();
		ArrayList<String> amountList = new ArrayList<String>();

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("_id", userName);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("nutrients").find(searchQuery_id).iterator();

			while (cursor.hasNext()) {

				Document document = cursor.next();
				Set<String> keys = document.keySet();
				Iterator iterator = keys.iterator();
				while (iterator.hasNext()) {

					String key = (String) iterator.next();
					String value = (String) document.get(key).toString();
					nutrientList.add(key);
					amountList.add(value);

				}

				int counter = 0;

				for (int i = 5; i < keys.size(); i++) {

					nutrientData[counter][0] = nutrientList.get(i);
					nutrientData[counter][1] = amountList.get(i);

					counter++;

				}

			}

		} catch (Exception e) {

		}

		return nutrientData;

	}

	public static String getAim(final String userName) {

		String goal = "";

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users")
					.find(searchQuery_id).iterator();

			while (cursor.hasNext()) {
				goal = (String) cursor.next().get("userGoal");
				System.out.println(goal);
			}

		} catch (Exception e) {
			
		}
		return goal;
	}
	
	public static void changePassword(final String userName, final String userPassword) {
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put("userPassword", userPassword);
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newDocument);
			
			mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").updateOne(searchQuery_id, updateObject);

		} catch (Exception e) {
			
		}
		
	}
	
	public static void changeValue(final String userName, final String property, final String value) {
		
		try {
			
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);
			
			BasicDBObject newDocument = new BasicDBObject();
			newDocument.put(property, value);
			
			BasicDBObject updateObject = new BasicDBObject();
			updateObject.put("$set", newDocument);
			
			mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").updateOne(searchQuery_id, updateObject);
			
		} catch (Exception e) {
			
		}
		
	}
	
	public static void deleteAccount(final String userName) {
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);
			
			mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").deleteOne(searchQuery_id);

		} catch (Exception e) {
			
		}
		
	}
	
	public static void deleteNutrients(final String userName) {
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);
			
			mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("nutrients").deleteOne(searchQuery_id);

		} catch (Exception e) {
			
		}
		
	}
	
	public static String getUserValue(final String userName, final String property) {
		
		String value = "";
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			searchQuery_id.put("_id", userName);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users")
					.find(searchQuery_id).iterator();

			while (cursor.hasNext()) {
				value = (String) cursor.next().get("user" + property);
			}
			
		} catch (Exception e) {
			
		}
		
		return value;
		
	}
	
	public static void reloadNutritionCalculation(final String userName) {
		
		try {

			NutritionCalculator n = new NutritionCalculator(getUserValue(userName, "Gender"), Integer.parseInt(getUserValue(userName, "Age")),
															Double.parseDouble(getUserValue(userName, "Height")), Double.parseDouble(getUserValue(userName, "Weight")),
															getUserValue(userName, "Goal"), getUserValue(userName, "Activity"));
			n.calculate();
			double[] nutritionalValues = n.getNutritionalValues();
			String[] names = n.getNames();
			String[] nutrients = n.getNutrients();
			deleteNutrients(userName);
			insertNutrients(userName, nutritionalValues, names, nutrients);

		} catch (Exception e) {
			
		}
		
	}
	

	public static String[] getTrackedData(String date) {

		String[] trackedData = new String[7];
		ArrayList<String> trackedDataList = new ArrayList<String>();
		// trackedDataList = [_id, username, calorie_amout, carbo_amount, date, fat_amount, protein_amount]
		try {
			
			BasicDBObject searchQuery_id = new BasicDBObject();
			List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
			obj.add(new BasicDBObject("username", _id));
		    obj.add(new BasicDBObject("date", date));
			searchQuery_id.put("$and", obj); //this find find documents matching multiple fields

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("tracked-nutrients").find(searchQuery_id).iterator();
			
			if (!cursor.hasNext()) {
				JOptionPane.showMessageDialog(null, "No data for this date!", "INFO", JOptionPane.ERROR_MESSAGE);
			}
			
			while (cursor.hasNext()) {

				Document document = cursor.next();
				Set<String> keys = document.keySet();
				Iterator iterator = keys.iterator();

				while (iterator.hasNext()) {

					String key = (String) iterator.next();
					String value = (String) document.get(key).toString();
					trackedDataList.add(value);

				}
				
				for (int i = 0; i < keys.size(); i++) {

					trackedData[i] = trackedDataList.get(i);
				}	
			}

			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Something went wrong!", "INFO", JOptionPane.ERROR_MESSAGE);

		}

		return trackedData; // trackedDataList = [_id, username, calorie_amout, carbo_amount, date, fat_amount, protein_amount]

	}
	
}