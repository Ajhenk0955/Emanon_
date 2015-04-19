package backdoor_;

import java.util.Arrays;
import java.util.List;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
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
	private Boolean wasCreated;

	/**
	 * sets up connection and collection TODO make close connection on end.
	 * 
	 * @param userName
	 * @param databaseName
	 * @param password
	 */
	public DataBase() {
		wasCreated = true;
	}

	/**
	 * login and initialize database
	 * 
	 * @param userName
	 * @param databaseName
	 * @param password
	 */
	public void login(String userName, String databaseName, char[] password) {
		if(!wasCreated)
			return;
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
	 * adds a user account, requires admin credentials
	 * 
	 * @param userName
	 * @param databaseName
	 * @param password
	 * @param userUsername
	 * @param userPassword
	 */
	public void addAccount(String userName, String databaseName,
			char[] password, String userUsername, char[] userPassword) {

		if(!wasCreated)
			return;
		MongoCredential credential = MongoCredential.createCredential(userName,
				databaseName, password);
		MongoClient mcAdmin = new MongoClient(new ServerAddress("localHost"),
				Arrays.asList(credential));
		try {
			mcAdmin.setWriteConcern(WriteConcern.JOURNALED);
			MongoDatabase userBase = mongoClient.getDatabase("Emanon");

			BasicDBObject commandArguments = new BasicDBObject();
			commandArguments.put("user", userUsername);
			commandArguments.put("pwd", userPassword);
			String[] roles = { "readWrite" };
			commandArguments.put("roles", roles);
			BasicDBObject command = new BasicDBObject("createUser",
					commandArguments);
			userBase.runCommand(command);
		} finally {
			mcAdmin.close();
		}
	}

	/**
	 * Uploads data from Patient objects
	 */
	private void UpdateData(Patient[] Patients) {
		if(!wasCreated)
			return;
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
		if(!wasCreated)
			return null;
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
		if(!wasCreated)
			return null;
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
		if(!wasCreated)
			return null;
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
		if(!wasCreated)
			return null;
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
		if(!wasCreated)
			return null;
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
		if(!wasCreated)
			return null;
		// return collection.find().into(new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		return ds.find(Patient.class).asList();
	}

	private void RemovePatient() {
		if(!wasCreated)
			return;
		// TODO
	}

	public void addPatient(Patient newPatient) {
		if(!wasCreated)
			return;
		// TODO Auto-generated method stub

	}

}
