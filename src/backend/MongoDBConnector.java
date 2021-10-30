package backend;

import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;


import gui.InputDataFrame;
import gui.LogInFrm;
import gui.LoginFrame;
import gui.MainFrame;
import gui.SignUpFrame;
import sun.security.pkcs11.Secmod.DbMode;

import java.awt.Cursor;

import javax.swing.JOptionPane;

import org.bson.Document;
import org.jfree.data.json.impl.JSONArray;
import org.jfree.data.json.impl.JSONObject;
import org.jfree.data.json.impl.JSONValue;

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


		
	}

	public MongoDBConnector(String _id, String userPassword, String userGender, String userWeight, String userHeight, String userAge, String userGoal, String userActivity) {  //, String userGoal, String userActivity)
		super();
		this._id = _id;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
		this.userGoal = userGoal;
		this.userActivity = userActivity;
	}
	
	private static void connectDB() {
		
		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);
			
			System.out.println("Connectionn created");
			
		} catch (Exception e) {
			System.out.println("Error : "+e);
		}
		
	}
	
	
	
	public static void signUpUser() {
		
		connectDB();
		
		try {
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", _id);
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").find(searchQuery).iterator();
			if(( _id.length() == 0 || userPassword.length() <= 5 || userAge.length() == 0 || userGender.length() == 0 || userHeight.length() == 0  || userWeight.length() == 0 || userHeight.equalsIgnoreCase("in cm")) || userWeight.equalsIgnoreCase("in kg")== true) {
				

				JOptionPane.showMessageDialog(null, "Invalid data!\r\nNo field should be empty!\r\nPassword should be at least 6 characters.", "ERROR", JOptionPane.ERROR_MESSAGE);
			
			} else {
				System.out.println("No user by that _id");
				try {
					
					Document document = new Document("_id", _id).append("userPassword", userPassword).append("userGender", userGender).append("userWeight", userWeight).append("userHeight", userHeight).append("userAge", userAge).append("userGoal", userGoal).append("userActivity", userActivity);
					mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").insertOne(document);
					MainFrame mainFrame = new MainFrame();
					mainFrame.frame.setVisible(true);

					SignUpFrame.frmDataCollection.setVisible(false);


					System.out.println("hey");
					
					System.out.println("Document inserted");
					
				} catch (Exception e) {
					System.out.println("Something went wrong : " +e);
					JOptionPane.showMessageDialog(null, "User already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);

					
					
				} 
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid data or user already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
		} 
		
		
	}
	
	public static void logInUser() {
		
		connectDB();
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();

			searchQuery_id.put("_id", _id);

			
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").find(searchQuery_id).iterator();
	
			if(cursor.hasNext()) {

				if(cursor.next().get("userPassword").equals(userPassword)) {

					MainFrame mainFrame = new MainFrame();
					mainFrame.frame.setVisible(true);

					LogInFrm.frmLogIn.setVisible(false);
					
				} else {

					JOptionPane.showMessageDialog(null, "Invalid Password!", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

				
			} else {
				System.out.println("No user by that _id");
			
				JOptionPane.showMessageDialog(null, "User does not exist! Please, register!", "ERROR", JOptionPane.ERROR_MESSAGE);

				
			}
		} catch (Exception e) {
			System.out.println("log in didnt work");
	
		} 
		
		
	}
	
	
	public static void insertNutrients(String _id, double[] nutritionalValues, String[] names, String[] nutrients) {
		MongoClient client;
		String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
		client = MongoClients.create(url);
		
		MongoCollection collection = client.getDatabase("ernaehrungstracker-app-db").getCollection("nutrients");
		
		try {
			Document document = new Document("_id", _id).append("Kalorienbedarf", nutritionalValues[0]).append("Proteine", nutritionalValues[1]).
											append("Fette", nutritionalValues[2]).append("Kohlenhydrate", nutritionalValues[3]);
			for(int i = 0; i < names.length; i++) {
				document.append(names[i], nutrients[i]);
			}
			collection.insertOne(document);
		} catch(Exception e) {}
		
		System.out.println("Nutrients saved");
	}



}
