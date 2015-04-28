package backdoor_;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification {
	HashMap<String, String> REGEX = new HashMap<String, String>();

	public Verification() {
		REGEX.put("SSN",
				"^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$");
		REGEX.put("US-ZIP", "^[0-9]{5}(?:-[0-9]{4})?$");
		REGEX.put("PHONE",
				"^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
		REGEX.put("PHONE-FORMAT",
				"^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$");
		REGEX.put("DATE", "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
		REGEX.put("LASTNAME", "[a-zA-z]+([ '-][a-zA-Z]+)*");
		REGEX.put("FIRSTNAME", "[A-Z][a-zA-Z]*");
		REGEX.put("MINITIAL", "[A-Z][a-zA-Z]*");
		REGEX.put("CITY", "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
		REGEX.put("STATE", "([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
		REGEX.put("ADDRESS", "\\d+\\s+([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)");
		REGEX.put("EMAILADDRESS", "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		REGEX.put("PASSWORD",
				"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{5,20})");
	}

	/**
	 * Verifies any value
	 * Also returns formatted phone numbers
	 * 
	 * @return
	 */
	public boolean Verify(String type, String value) {
		if(value == null){
			return false;
		}
		Pattern pattern = Pattern.compile(REGEX.get(type));

		Matcher matcher = pattern.matcher(value);
		if (!matcher.matches())
			return false;
		if (type == "PHONE")
			value = matcher.replaceFirst("($1) $2-$3");
		return true;
	}
}
