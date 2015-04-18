package backdoor_;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class Name {
	private String firstName;
	private String mInitial;
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getmInitial() {
		return mInitial;
	}

	public void setmInitial(String mInitial) {
		this.mInitial = mInitial;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
