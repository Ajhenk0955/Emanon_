package backdoor_;

import org.mongodb.morphia.annotations.Embedded;

import com.mongodb.ReflectionDBObject;

@Embedded
public class Part {
	private String part;

	private String part_;

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getPart_() {
		return part_;
	}

	public void setPart_(String part_) {
		this.part_ = part_;
	}

}
