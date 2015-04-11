package backdoor_;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

/**
 * contains methods for pulling and pushing from database
 * 
 * @author Andrew
 * 
 */
public class DataBase {
	
	private MongoClient mongoClient;
	private MongoDatabase database;
	private MongoCollection<Document> collection;
	
	public DataBase(){
		//TODO finish implementing mongo
		mongoClient = new MongoClient( "localhost" );
		database = mongoClient.getDatabase("patientDataBase");
		collection = database.getCollection("test");
	}

	/**
	 * Uploads data from Patient objects
	 */
	private void UpdateData(Patient[] Patients) {
		// TODO
	}

	/**
	 * Fetches Patient Info from database
	 * 
	 * @param UID
	 * @return Patient Files
	 */
	private Patient PullPatientProfile(int UID) {
		return null;
		// TODO
		Document myDoc = collection.find(eq("i", 71)).first();
		System.out.println(myDoc.toJson());
	}

	/**
	 * Returns list of most Recent Patients
	 */
	private void GetMostRecent() {
		// TODO
	}

	/**
	 * Returns list of Patients covered by insurer
	 */
	private void GetInsurer(String Insurer) {
		// TODO
	}

	/**
	 * returns list of patients with selected part replacement
	 * 
	 * @param Part
	 */
	private void GetPart(String Part) {
		// TODO
	}

	/**
	 * returns list of patients with given term in the name
	 * 
	 * @param SearchTerm
	 */
	private void GetName(String SearchTerm) {
		// TODO
	}
	
	private void GetAllPatients(){
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}
	}

	public MongoClient getMongoClient() {
		return mongoClient;
	}

	public void setMongoClient(MongoClient mongoClient) {
		this.mongoClient = mongoClient;
	}

	public MongoDatabase getDatabase() {
		return database;
	}

	public void setDatabase(MongoDatabase database) {
		this.database = database;
	}
}
