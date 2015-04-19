package backdoor_;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * stores user account information TODO ENCRYPT
 * 
 * @author Andrew
 *
 */
@Entity
public class UserAccount {
	// ID
	@Id
	private ObjectId id;

	private char[] password;

	private String firstName;

	private String lastName;

	private String email;

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ObjectId getId() {
		return id;
	}

}
