package backend;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import java.util.ArrayList;

import org.bson.Document;

public class MongoDBConnector {
	public static String column;
	public static ArrayList<String> data;

	public MongoDBConnector(String column) {
		this.column = column;
		this.data = new ArrayList<String>();
	}

	public static ArrayList<String> getFoodRecommendation() {
		MongoClient mongoClient = null;

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

}