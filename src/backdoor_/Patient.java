package backdoor_;

/**
 * Container for each patient's information
 * If a patient's info has changed serverside the current object should be deleted and reloaded
 * If a patient's info has been changed locally the current object should update the DataBase
 * 
 * @author Andrew
 * 
 *         TODO potentially encrypt all info here?
 */
public class Patient {
	// ID
	private String UID;

	// Name
	private String FName;
	private String MName;
	private String LName;

	// DOB
	private int Day;
	private int Month;
	private int Year;

	// Insurance type
	private String PrimaryInsurance;
	private String SecondaryInsurance;

	// Social security
	private String SSN;

	public String getFName() {
		return FName;
	}

	public void setFName(String fName) {
		FName = fName;
	}

	public String getMName() {
		return MName;
	}

	public void setMName(String mName) {
		MName = mName;
	}

	public String getLName() {
		return LName;
	}

	public void setLName(String lName) {
		LName = lName;
	}

	public int getDay() {
		return Day;
	}

	public void setDay(int day) {
		Day = day;
	}

	public int getMonth() {
		return Month;
	}

	public void setMonth(int month) {
		Month = month;
	}

	public int getYear() {
		return Year;
	}

	public void setYear(int year) {
		Year = year;
	}

	public String getPrimaryInsurance() {
		return PrimaryInsurance;
	}

	public void setPrimaryInsurance(String primaryInsurance) {
		PrimaryInsurance = primaryInsurance;
	}

	public String getSecondaryInsurance() {
		return SecondaryInsurance;
	}

	public void setSecondaryInsurance(String secondaryInsurance) {
		SecondaryInsurance = secondaryInsurance;
	}

	public String getSSN() {
		return SSN;
	}

	public void setSSN(String sSN) {
		SSN = sSN;
	}

}
