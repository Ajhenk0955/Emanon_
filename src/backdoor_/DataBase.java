package backdoor_;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.bson.Document;
import org.bson.types.ObjectId;
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
	private Datastore ds;
	private Boolean wasCreated;
	private Morphia morphia;

	/**
	 * login and initialize database
	 * 
	 * @param userName
	 * @param password
	 * @param write
	 *            (read or write)
	 */
	public DataBase(String userName, char[] password, boolean read) {
		MongoCredential credential = MongoCredential.createCredential(userName,
				"Emanon", password);
		mongoClient = new MongoClient(new ServerAddress("localHost"),
				Arrays.asList(credential));
		if (read)
			initializeMorphiaPatients();
		else
			initializeMorphiaUser();
		wasCreated = true;
	}

	/**
	 * login and initialize database
	 * 
	 * @param userName
	 * @param password
	 * @param write
	 *            (read or write)
	 */
	public void login(String userName, char[] password) {
		if (!wasCreated)
			return;

		// initiallizing morphia

		// perform method calls here:

	}

	public void finalize() {
		mongoClient.close();
	}

	private void initializeMorphiaPatients() {
		morphia = new Morphia();
		morphia.map(Patient.class).map(Insurance.class).map(Part.class)
				.map(PatientFiles.class);
		ds = morphia.createDatastore(mongoClient, "users");
	}

	private void initializeMorphiaUser() {
		morphia = new Morphia();
		morphia.map(UserAccount.class);
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
	public boolean addAccount(UserAccount tempUser) {
		if (!wasCreated)
			System.exit(0);
		try {
			// Saving userData
			ds.save(tempUser);

			mongoClient.setWriteConcern(WriteConcern.JOURNALED);
			MongoDatabase userBase = mongoClient.getDatabase("Emanon");

			BasicDBObject commandArguments = new BasicDBObject();
			commandArguments.put("user", tempUser.getEmail());
			commandArguments.put("pwd", tempUser.getPassword());
			String[] roles = { "read" };
			commandArguments.put("roles", roles);
			BasicDBObject command = new BasicDBObject("createUser",
					commandArguments);

			userBase.runCommand(command);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * Uploads data from Patient object
	 */
	public boolean UpdateData(Patient patient) {
		if (!wasCreated)
			System.exit(0);
		// upload patients via morphia
		try {
			ds.save(patient);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

	/**
	 * Fetches Patient Info from database THe correct function to use should be
	 * collection.findOne(); not working/found
	 * 
	 * @param UID
	 * @return
	 * @return Patient Files as Document
	 */
	public Patient PullPatientProfile(int PatientID) {
		if (!wasCreated)
			return null;
		// BasicDBObject temp = new BasicDBObject("_ID", UID);
		// collection.findOneAndUpdate(temp, temp);
		// MongoIterable<Document> cursor = collection.find(temp);
		// return cursor.first();

		// TODO insert try catches/throws
		try {
			return ds.get(Patient.class, PatientID);
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns list of most Recent Patients
	 */
	public List<Patient> GetMostRecent() {
		if (!wasCreated)
			return null;
		// return collection.find().sort(new BasicDBObject("lastUpdated", -1))
		// .into(new ArrayList<Document>());
		// TODO try/catch/throw
		try {
			return ds.find(Patient.class).order("-lastUpdated").asList();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns list of Patients covered by insurer
	 * 
	 * @return
	 */
	public List<Patient> GetInsurer(String Insurer) {
		if (!wasCreated)
			return null;
		// return collection.find(new BasicDBObject("insurance", Insurer)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		try {
			return ds.find(Patient.class).filter("insurance =", Insurer)
					.asList();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * returns list of patients with selected part replacement
	 * 
	 * @param Part
	 * @return
	 */
	public List<Patient> GetPart(String Part) {
		if (!wasCreated)
			return null;
		// return collection.find(new BasicDBObject("part", Part)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with part =
		try {
			return ds.find(Patient.class).filter("part =", Part).asList();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * returns list of patients with given term in the name
	 * 
	 * @param SearchTerm
	 * @return
	 */
	public List<Patient> GetName(String SearchTerm) {
		if (!wasCreated)
			return null;
		// return collection.find(new BasicDBObject("name", SearchTerm)).into(
		// new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		try {
			return ds.find(Patient.class).filter("Name $in", SearchTerm)
					.asList();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Returns a list of all patients
	 * 
	 * @return TODO make return list ordered by date
	 */
	private List<Patient> GetAllPatients() {
		if (!wasCreated)
			return null;
		// return collection.find().into(new ArrayList<Document>());
		// TODO try/catch/throw/ and potential flaw with insurance =
		try {
			return ds.find(Patient.class).asList();
		} catch (Exception e) {
			return null;
		}
	}

	private void RemovePatient() {
		if (!wasCreated)
			return;
		// TODO
	}

	public boolean removeFile(String userUsername, char[] userPassword) {
		return wasCreated;
		// TODO
	}

	public void addPatient(Patient newPatient) {
		if (!wasCreated)
			return;
		// TODO Auto-generated method stub

	}

	public void deletePatient(ObjectId id) {
		// TODO Auto-generated method stub

	}

	public void UpdateUser(UserAccount tempUser) {
		// TODO Auto-generated method stub

	}

}
