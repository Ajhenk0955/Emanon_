package backdoor_;

import javafx.beans.property.SimpleStringProperty;

public class TableResults {
	public SimpleStringProperty patientName = new SimpleStringProperty();
	public SimpleStringProperty insurance = new SimpleStringProperty();
	public SimpleStringProperty service = new SimpleStringProperty();

	public SimpleStringProperty getPatientName() {
		return patientName;
	}

	public SimpleStringProperty getInsurance() {
		return insurance;
	}

	public SimpleStringProperty getService() {
		return service;
	}

}
