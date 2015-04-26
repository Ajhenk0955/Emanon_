package backdoor_;

import javafx.beans.property.SimpleStringProperty;

public class TableResults {
	public SimpleStringProperty patientName = new SimpleStringProperty();
	public SimpleStringProperty insurance = new SimpleStringProperty();
	public SimpleStringProperty service = new SimpleStringProperty();

	public String getPatientName() {
		return patientName.getValue();
	}

	public String getInsurance() {
		return insurance.getValue();
	}

	public String getService() {
		return service.getValue();
	}

}
