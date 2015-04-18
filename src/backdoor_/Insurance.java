package backdoor_;

import org.mongodb.morphia.annotations.Embedded;

import com.mongodb.ReflectionDBObject;

@Embedded
public class Insurance {
	private String primary;
	private String secondary;

	public String getPrimary() {
		return primary;
	}

	public void setPrimary(String primary) {
		this.primary = primary;
	}

	public String getSecondary() {
		return secondary;
	}

	public void setSecondary(String secondary) {
		this.secondary = secondary;
	}

}
