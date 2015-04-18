package backdoor_;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.BulkWriteResult;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
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
	private DB database;
	private DBCollection collection;

	/**
	 * sets up connection and collection TODO make close connection on end.
	 * TODO FIX TO NON-DEPRICATED METHOD
	 * @param userName
	 * @param databaseName
	 * @param password
	 */
	public DataBase(String userName, String databaseName, char[] password) {
		MongoCredential credential = MongoCredential.createCredential(userName,
				databaseName, password);
		MongoClient mongoClient = new MongoClient(
				new ServerAddress("localHost"), Arrays.asList(credential));
		database = mongoClient.getDB(databaseName);

		collection = database.getCollection("users");

	}

	/**
	 * Uploads data from Patient objects
	 */
	private void UpdateData(DBObject[] Patients) {
		// TODO test to make sure this works!
		collection.insert(Patients);
	}

	/**
	 * Fetches Patient Info from database
	 * 
	 * @param UID
	 * @return 
	 * @return Patient Files
	 */
	private  DBObject PullPatientProfile(int UID) {
		BasicDBObject temp = new BasicDBObject("_ID", UID);
		// TODO
		DBCursor cursor = collection.find(temp);
		DBObject temp1 = cursor.next();
		cursor.close();
		return temp1;

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

	private void GetAllPatients() {
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
