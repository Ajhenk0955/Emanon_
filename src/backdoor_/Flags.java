package backdoor_;

import org.bson.types.ObjectId;

/**
 * this class contains status flags TODO there IS a vulnerability here we pass a
 * temp UserAccount through here
 * 
 * @author Andrew
 *
 */
public class Flags {
	private boolean createUser, addPatient, deleteFile, addFile, deletePatient,
			editPatient, editUser, wasCreated, eye, ear, nose, va, insurance,
			medicare;
	private String searchTerms;
	private UserAccount tempUser;
	private Patient patient;
	private ObjectId id;
	private int[] searchSettings = new int[8];

	public boolean isEye() {
		return eye;
	}

	// array[1]
	public void setEye(boolean eye) {
		searchSettings[1] = 1;

		this.eye = eye;
	}

	public boolean isEar() {
		return ear;
	}

	// array[2]
	public void setEar(boolean ear) {
		searchSettings[2] = 1;

		this.ear = ear;
	}

	public boolean isNose() {
		return nose;
	}

	// array[3]
	public void setNose(boolean nose) {
		searchSettings[3] = 1;

		this.nose = nose;
	}

	public boolean isVa() {
		return va;
	}

	// array[4]
	public void setVa(boolean va) {
		searchSettings[4] = 1;

		this.va = va;
	}

	public boolean isInsurance() {
		return insurance;
	}

	// array[5]
	public void setInsurance(boolean insurance) {
		searchSettings[5] = 1;

		this.insurance = insurance;
	}

	public boolean isMedicare() {
		return medicare;
	}

	// array[6]
	public void setMedicare(boolean medicare) {
		searchSettings[6] = 1;

		this.medicare = medicare;
	}

	public Flags() {
		createUser = deleteFile = addFile = false;
		searchTerms = null;
		tempUser = null;
		wasCreated = true;
	}

	public boolean isCreateUser() {
		if (!wasCreated)
			System.exit(0);
		return createUser;
	}

	public void setCreateUser(boolean createUser) {
		if (!wasCreated)
			System.exit(0);
		this.createUser = createUser;
	}

	public boolean isDeleteFile() {
		if (!wasCreated)
			System.exit(0);
		return deleteFile;
	}

	public void setDeleteFile(boolean deleteFile) {
		if (!wasCreated)
			System.exit(0);
		this.deleteFile = deleteFile;
	}

	public boolean isAddFile() {
		if (!wasCreated)
			System.exit(0);
		return addFile;
	}

	public void setAddFile(boolean addFile) {
		if (!wasCreated)
			System.exit(0);
		this.addFile = addFile;
	}

	public UserAccount getTempUser() {
		if (!wasCreated)
			System.exit(0);
		return tempUser;
	}

	public void setTempUser(UserAccount tempUser) {
		if (!wasCreated)
			System.exit(0);
		this.tempUser = tempUser;
	}

	public String getSearchTerms() {
		if (!wasCreated)
			System.exit(0);
		return searchTerms;
	}

	// array[7]
	public void setSearchTerms(String searchTerms) {
		if (searchTerms != null)
			searchSettings[7] = 1;

		if (!wasCreated)
			System.exit(0);
		this.searchTerms = searchTerms;
	}

	public boolean isAddPatient() {
		if (!wasCreated)
			System.exit(0);
		return addPatient;
	}

	public void setAddPatient(boolean addPatient) {
		if (!wasCreated)
			System.exit(0);
		this.addPatient = addPatient;
	}

	public Patient getPatient() {
		if (!wasCreated)
			System.exit(0);
		return patient;
	}

	public void setPatient(Patient patient) {
		if (!wasCreated)
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

	public int toFinalString() {
		String temp = "";
		for (int i : searchSettings) {
			temp += i;
		}
		return (Integer.parseInt(temp));

	}
}
