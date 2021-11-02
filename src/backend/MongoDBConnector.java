package backend;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import gui.FoodRecommendationFrame;
import gui.LogInFrm;
import gui.MainFrame;
import gui.MicronutrientsFrame;
import gui.SettingsFrame;
import gui.SignUpFrame;
import gui.SupplementsFrame;

import java.util.ArrayList;
import java.util.Iterator;
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

	static MongoClient mongoClient = null;

	public MongoDBConnector(String _id, String userPassword) {
		super();
		this._id = _id;
		this.userPassword = userPassword;
		connectDB();

	}

	public MongoDBConnector(String _id, String userPassword, String userGender, String userWeight, String userHeight,
			String userAge, String userGoal, String userActivity) { // , String userGoal, String userActivity)
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
				System.out.println("No user by that _id");
				try {

					Document document = new Document("_id", _id).append("userPassword", userPassword)
							.append("userGender", userGender).append("userWeight", userWeight)
							.append("userHeight", userHeight).append("userAge", userAge).append("userGoal", userGoal)
							.append("userActivity", userActivity);
					mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").insertOne(document);

					SignUpFrame.frmDataCollection.setVisible(false);

				} catch (Exception e) {
					System.out.println("Something went wrong : " + e);
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

					MainFrame mainFrame = new MainFrame(_id);
					mainFrame.frame.setVisible(true);
					
					FoodRecommendationFrame foodRecommendationFrame = new FoodRecommendationFrame();
					SupplementsFrame supplementsFrame = new SupplementsFrame(_id);
					SettingsFrame settingsFrame = new SettingsFrame();
					MicronutrientsFrame microNutrientsFrame = new MicronutrientsFrame(_id);

					LogInFrm.frmLogIn.setVisible(false);

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

//		for(int i = 0; i<7; i++) {
//			for (int j = 0; j<2; j++) {
//				System.out.println(supData[i][j]);
//			}
//			
//		}

		return supData;
	}

	public static String[] getMacronutrientsAndCalories(final String userName) {

		String[] data = new String[4];
		ArrayList<String> dataList = new ArrayList<String>();

		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("_id", userName); // Hier muss dann der Nutzername stehen

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

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("users").find(searchQuery_id).iterator();
			
			while (cursor.hasNext()) {
				goal = (String) cursor.next().get("userGoal");
			}
			
		} catch (Exception e) {
		}
		return goal;
	}

}