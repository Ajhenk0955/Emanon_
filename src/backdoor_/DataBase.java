package backdoor_;

import java.util.Arrays;
import java.util.List;
import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
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
	private Datastore ds;

	/**
	 * sets up connection and collection TODO make close connection on end. TODO
	 * FIX TO NON-DEPRICATED METHOD
	 * 
	 * @param userName
	 * @param databaseName
	 * @param password
	 */
	public DataBase(String userName, String databaseName, char[] password) {
		MongoCredential credential = MongoCredential.createCredential(userName,
				databaseName, password);
		mongoClient = new MongoClient(new ServerAddress("localHost"),
				Arrays.asList(credential));
		database = mongoClient.getDatabase("Emanon");

		collection = database.getCollection("users");

		// initiallizing morphia
		Morphia morphia = new Morphia();
		morphia.map(Patient.class).map(Insurance.class).map(Part.class);
		ds = morphia.createDatastore(mongoClient, "users");
	}

	/**
	 * Uploads data from Patient objects
	 */
	private void UpdateData(Patient[] Patients) {
		// upload patients via morphia
		ds.save(Patients);

	}

	/**
	 * Fetches Patient Info from database THe correct function to use should be
	 * collection.findOne(); not working/found
	 * 
	 * @param UID
	 * @return
	 * @return Patient Files as Document
	 */
	private Patient PullPatientProfile(int PatientID) {
		// BasicDBObject temp = new BasicDBObject("_ID", UID);
		// collection.findOneAndUpdate(temp, temp);
		// MongoIterable<Document> cursor = collection.find(temp);
		// return cursor.first();

		// TODO insert try catches/throws

		return ds.get(Patient.class, PatientID);

	}

	/**
	 * Returns list of most Recent Patients
	 */
	private List<Patient> GetMostRecent() {
		// return collection.find().sort(new BasicDBObject("lastUpdated", -1))
		// .into(new ArrayList<Document>());
		// TODO try/catch/throw
		return ds.find(Patient.class).order("-lastUpdated").asList();
	}

	/**
	 * Returns list of Patients covered by insurer
	 * 
	 * @return
	 */
	private List<Patient> GetInsurer(String Insurer) {
		// return collection.find(new BasicDBObject("insurance", Insurer)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		return ds.find(Patient.class).filter("insurance =", Insurer).asList();
	}

	/**
	 * returns list of patients with selected part replacement
	 * 
	 * @param Part
	 * @return
	 */
	private List<Patient> GetPart(String Part) {
		// return collection.find(new BasicDBObject("part", Part)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with part =
		return ds.find(Patient.class).filter("part =", Part).asList();
	}

	/**
	 * returns list of patients with given term in the name
	 * 
	 * @param SearchTerm
	 * @return
	 */
	private List<Patient> GetName(String SearchTerm) {
		// return collection.find(new BasicDBObject("name", SearchTerm)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		return ds.find(Patient.class).filter("Name $in", SearchTerm).asList();
	}

	/**
	 * Returns a list of all patients
	 * 
	 * @return TODO make return list ordered by date
	 */
	private List<Patient> GetAllPatients() {
		// return collection.find().into(new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		return ds.find(Patient.class).asList();
	}

	private void RemovePatient() {
		// TODO
	}

}
