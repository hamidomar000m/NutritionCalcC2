package backend;

import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import com.mongodb.*;

import gui.InputDataFrame;
import gui.LoginFrame;
import gui.MainFrame;
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
	
	public MongoDBConnector(String _id, String userPassword) {
		super();
		this._id = _id;
		this.userPassword = userPassword;  
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
		
	}

	public MongoDBConnector(String _id, String userPassword, String userGender, String userWeight, String userHeight, String userAge) {
		super();
		this._id = _id;
		this.userPassword = userPassword;
		this.userGender = userGender;
		this.userWeight = userWeight;
		this.userHeight = userHeight;
		this.userAge = userAge;
	}
	
	public static void signUpUser() {
		
		MongoClient mongoClient = null;
		
		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);
			
			System.out.println("Connectionn created");
			
		} catch (Exception e) {
			System.out.println("Error : "+e);
		}
		
		try {
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("_id", _id);
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").find(searchQuery).iterator();
			if(( _id.length() == 0 || userPassword.length() <= 5 || userAge.length() == 0 || userGender.length() == 0 || userHeight.length() == 0 || userHeight.equals("in kg") || userWeight.length() == 0) == true) {
				
				System.out.println(cursor.next());
				JOptionPane.showMessageDialog(InputDataFrame.frame, "Invalid data!\r\nNo field should be empty!\r\nPassword should be at least 6 characters.");
			
			} else {
				System.out.println("No user by that _id");
				try {
					
					Document document = new Document("_id", _id).append("userPassword", userPassword).append("userGender", userGender).append("userWeight", userWeight).append("userHeight", userHeight).append("userAge", userAge);
					mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").insertOne(document);
					MainFrame mainFrame = new MainFrame();
					mainFrame.frame.setVisible(true);
					LoginFrame loginFrame = new LoginFrame();
					loginFrame.frame.setVisible(false);
					InputDataFrame inputDataFrame = new InputDataFrame();
					inputDataFrame.frame.setVisible(false);
					System.out.println("Document inserted");
					
				} catch (Exception e) {
					System.out.println("Something went wrong : " +e);
					JOptionPane.showMessageDialog(InputDataFrame.frame, "User already exists!");
					
					
				} 
				
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(InputDataFrame.frame, "Invalid data or user already exists!");
		} 
		
		
	}
	
	public static void logInUser() {
		
		MongoClient mongoClient = null;
		
		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);
			
			System.out.println("Connectionn created");
			
		} catch (Exception e) {
			System.out.println("Error : "+e);
		}
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			BasicDBObject searchQueryUserPassword = new BasicDBObject();
			searchQuery_id.put("_id", _id);
			//System.out.println("didnt work1");
			//searchQueryUserPassword.put("userPassword", userPassword);
			
			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").find(searchQuery_id).iterator();
			//MongoCursor<Document> cursorPassword = mongoClient.getDatabase("ernaehrungstracker-app-db").getCollection("users").find(searchQueryUserPassword).iterator();
			
			

			if(cursor.hasNext()) {
				if(cursor.next().get("userPassword").equals(userPassword)) {
					MainFrame mainFrame = new MainFrame();
					mainFrame.frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(InputDataFrame.frame, "Invalid data!");
				}
				/*if(cursorPassword.toString().contentEquals(userPassword)) {

				}*/
				
				//System.out.println(cursorPassword.toString().contentEquals(userPassword));
					
				
				
				//System.out.println(cursorPassword.next());
				//JOptionPane.showMessageDialog(InputDataFrame.frame, "Invalid data or the user already exists");
				
			} else {
				System.out.println("No user by that _id");
			
				JOptionPane.showMessageDialog(InputDataFrame.frame, "User does not exist! Please, register!");
				InputDataFrame inputDataFrame = new InputDataFrame("he", 600, 600);
				inputDataFrame.frame.setVisible(true);
				
			}
		} catch (Exception e) {
			System.out.println("didnt work");
			
		} 
		
		
	}

	/*public static void main(String[] args) {


		MongoClient client = MongoClients.create("mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		
		MongoDatabase db = client.getDatabase("ernaehrungstracker-app-db");
		MongoCollection col= db.getCollection("users");
		
		Document sample = new Document("_id", "227").append("name", "xxx").append("age", 12);
		col.insertOne(sample);
		
		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("_id", "225");
		MongoCursor<Document> cursor = col.find(searchQuery).iterator();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	
		
	}*/
}
