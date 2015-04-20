package backdoor_;

import org.bson.types.ObjectId;

/**
 * this class contains status flags
 *TODO there IS a vulnerability here
 *we pass a temp UserAccount through here
 * @author Andrew
 *
 */
public class Flags {
	private boolean createUser;
	private boolean addPatient;
	private boolean deleteFile;
	private boolean addFile;
	private boolean deletePatient;
	private boolean editPatient;
	private boolean editUser;
	private String searchTerms;
	private UserAccount tempUser;
	private Patient patient;
	private ObjectId id;
	private boolean wasCreated;
	
	public Flags(){
		createUser = deleteFile = addFile = false;
		searchTerms = null;
		tempUser = null;
		wasCreated = true;
	}

	public boolean isCreateUser() {
		if(!wasCreated)
			System.exit(0);
		return createUser;
	}

	public void setCreateUser(boolean createUser) {
		if(!wasCreated)
			System.exit(0);
		this.createUser = createUser;
	}

	public boolean isDeleteFile() {
		if(!wasCreated)
			System.exit(0);
		return deleteFile;
	}

	public void setDeleteFile(boolean deleteFile) {
		if(!wasCreated)
			System.exit(0);
		this.deleteFile = deleteFile;
	}

	public boolean isAddFile() {
		if(!wasCreated)
			System.exit(0);
		return addFile;
	}

	public void setAddFile(boolean addFile) {
		if(!wasCreated)
			System.exit(0);
		this.addFile = addFile;
	}

	public UserAccount getTempUser() {
		if(!wasCreated)
			System.exit(0);
		return tempUser;
	}

	public void setTempUser(UserAccount tempUser) {
		if(!wasCreated)
			System.exit(0);
		this.tempUser = tempUser;
	}

	public String getSearchTerms() {
		if(!wasCreated)
			System.exit(0);
		return searchTerms;
	}

	public void setSearchTerms(String searchTerms) {
		if(!wasCreated)
			System.exit(0);
		this.searchTerms = searchTerms;
	}

	public boolean isAddPatient() {
		if(!wasCreated)
			System.exit(0);
		return addPatient;
	}

	public void setAddPatient(boolean addPatient) {
		if(!wasCreated)
			System.exit(0);
		this.addPatient = addPatient;
	}

	public Patient getPatient() {
		if(!wasCreated)
			System.exit(0);
		return patient;
	}

	public void setPatient(Patient patient) {
		if(!wasCreated)
			System.exit(0);
		this.patient = patient;
	}

	public boolean isDeletePatient() {
		return deletePatient;
	}

	public void setDeletePatient(boolean deletePatient) {
		this.deletePatient = deletePatient;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public boolean isEditPatient() {
		return editPatient;
	}

	public void setEditPatient(boolean editPatient) {
		this.editPatient = editPatient;
	}

	public boolean isEditUser() {
		return editUser;
	}

	public void setEditUser(boolean editUser) {
		this.editUser = editUser;
	}
}
