package backend;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoDBConnector {

	public static void main(String[] args) {


		MongoClient client = MongoClients.create("mongodb+srv://HamidO:123Hamid123@cluster0.f2htr.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
		
		MongoDatabase db = client.getDatabase("ernaehrungstracker-app-db");
		MongoCollection col= db.getCollection("users");
		
		Document sample = new Document("_id", "3").append("name", "Robert");
		col.insertOne(sample);
		
		
	}


}
