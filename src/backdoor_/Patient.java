package backdoor_;

import java.util.Date;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Container for each patient's information If a patient's info has changed
 * serverside the current object should be deleted and reloaded If a patient's
 * info has been changed locally the current object should update the DataBase
 * 
 * @author Andrew
 * 
 *         TODO potentially encrypt all info here?
 */
@Entity
public class Patient {
	// ID
	@Id
	private ObjectId id;
	private String lastUpdated;

	// Gender
	private String gender;

	// Part
	@Embedded
	private Part part;

	// Name TODO potential issue
	private Name name;

	// DOB
	private String birthDate;

	// Billing
	@Embedded
	private Billing billing;

	// Social security
	private String SSN;

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String toDate) {
		this.birthDate = toDate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Billing getBilling() {
		return billing;
	}

	public void setBilling(Billing billing) {
		this.billing = billing;
	}

}
