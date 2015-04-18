package backdoor_;

import java.util.Date;

import javax.naming.Name;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;
import org.bson.types.ObjectId;

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

	// Part
	@Embedded
	private Part part;

	// Name TODO potential issue
	private Name name;

	// DOB
	private Date birthDate;

	// Insurance type
	@Embedded
	private Insurance insurance;

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

	public Insurance getInsurance() {
		return insurance;
	}

	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}

	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
