package backend;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.bson.Document;

public class MongoDBConnector {

	public static ArrayList<String> getFoodRecommendation(final String column) {
		
		MongoClient mongoClient = null;
		ArrayList<String> data = new ArrayList<String>();
		
		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);

			System.out.println("Connection created");

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}

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
		MongoClient mongoClient = null;
		ArrayList<String> supDataList = new ArrayList<String>();
		ArrayList<String> desDataList = new ArrayList<String>();
		String[][] supData = new String[8][2];
		try {
			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
			mongoClient = MongoClients.create(url);

			System.out.println("Connection created");

		} catch (Exception e) {
			System.out.println("Error : " + e);
		}
		
		try {
			BasicDBObject searchQuery_id = new BasicDBObject();
			
			searchQuery_id.put("aim", aim);

			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("supplements").find(searchQuery_id).iterator();
			MongoCursor<Document> cursor2 = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("supplements").find(searchQuery_id).iterator();
			
			MongoCursor<Document> cur = mongoClient.getDatabase("ernaehrungstracker-app-db")
					.getCollection("nutrients").find().iterator();
				
			while (cursor.hasNext()) {
				supDataList.add((String) cursor.next().get("supplement"));
			}
			while (cursor2.hasNext()) {
				desDataList.add((String) cursor2.next().get("description"));
			}
			int counter = 0;
			for(int i = 0; i<supDataList.size(); i++) {
				supData[counter][0] = supDataList.get(i);
				supData[counter][1] = desDataList.get(i);
				counter++;
			}

		} catch (Exception e) {
		}
		

		
		return supData;
	}

	public static String getAim() {
//		MongoClient mongoClient = null;
//		try {
//			String url = "mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority";
//			mongoClient = MongoClients.create(url);
//
//			System.out.println("Connection created");
//
//		} catch (Exception e) {
//			System.out.println("Error : " + e);
//		}
//		
//		try {
//			BasicDBObject searchQuery_id = new BasicDBObject();
//			
//			searchQuery_id.put("userGoal", userGoal);
//
//			MongoCursor<Document> cursor = mongoClient.getDatabase("ernaehrungstracker-app-db")
//					.getCollection("users").find(searchQuery_id).iterator();
//			
//			while (cursor.hasNext()) {
//				supDataList.add((String) cursor.next().get("supplement"));
//			}
//			
//
//		} catch (Exception e) {
//		}
		return "gain muscles";
	}

}