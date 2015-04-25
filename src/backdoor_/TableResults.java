package backdoor_;

import javafx.beans.property.SimpleStringProperty;

public class TableResults {
	public SimpleStringProperty patientName = new SimpleStringProperty();
	public SimpleStringProperty insurance = new SimpleStringProperty();
	public SimpleStringProperty service = new SimpleStringProperty();

	public SimpleStringProperty getPatientName() {
		return patientName;
	}

	public void setPatientName(SimpleStringProperty patientName) {
		this.patientName = patientName;
	}

	public SimpleStringProperty getInsurance() {
		return insurance;
	}

	public void setInsurance(SimpleStringProperty insurance) {
		this.insurance = insurance;
	}

	public SimpleStringProperty getService() {
		return service;
	}

	public void setService(SimpleStringProperty service) {
		this.service = service;
	}

}
