package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import backdoor_.Billing;
import backdoor_.DataBase;
import backdoor_.Insurance;
import backdoor_.Name;
import backdoor_.Patient;
import backdoor_.Verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreatePatientController implements Initializable {

	private Verification checker;

	@FXML
	private Button saveButton, backButton;

	// form variables
	@FXML
	private TextField lastName, zipCode, mInitial, homePhone, dayOfBirth, ssn,
			firstName, cellPhone, yearOfBirth, address, city;

	private ChoiceBox<String> gender, monthOfBirth, state;

	/**
	 * 
	 * Method for when user clicks the save button in CreatePatient
	 * 
	 * @Author M
	 */

	@FXML
	private void handleSaveButton(ActionEvent click) throws IOException {
		Stage stage;
		Parent root;

		// User clicks save button
		if (click.getSource() == saveButton) {

			// if (!makeNewPatient()) {
			// ERROR HERE (INVALID INPUT)
			// } else {
			// finding reference for button's stage
			stage = (Stage) saveButton.getScene().getWindow();
			// now loading PatientProfile as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/PatientProfile.fxml"));

			// makes PatientProfile scene and show it on the stage
			Scene patientProfile = new Scene(root);
			stage.setScene(patientProfile);
			stage.setTitle("Patient Profile");
			stage.show();
			// }
		}
	}

	/**
	 * AHenk Verifies user inputs Puts new data into a Patient POJO Requests
	 * database to put data
	 * 
	 * @return
	 */
	private boolean makeNewPatient() {
		Patient newPatient = new Patient();
		checker = new Verification();

		// Name TODO VERIFY NAME
		Name newName = null;
		if (!newName(newName))
			return false;
		newPatient.setName(newName);

		// BirthDate (month/day/year)
		String toDate = null;
		if (!toDate(toDate))
			return false;
		newPatient.setBirthDate(toDate);

		// Billing & insurance
		Billing newBilling = null;
		if (newBilling(newBilling))
			return false;
		newPatient.setBilling(newBilling);

		// Gender
		if (gender.getValue() == null)
			return false;
		newPatient.setGender(gender.getValue());

		// SSN
		if (!checker.Verify("SSN", ssn.getText()))
			return false;
		newPatient.setSSN(ssn.getText());

		char[] Password = null;
		DataBase PatientLoader = new DataBase("Username", "DataBaseName",
				Password);
		PatientLoader.addPatient(newPatient);

		return true;
	}

	/**
	 * Verifies and sets billing and insurance
	 * 
	 * @param newBilling
	 * @return
	 */
	private boolean newBilling(Billing newBilling) {

		if (!checker.Verify("ZIP", zipCode.getText()))
			return false;

		newBilling.setZipCode(zipCode.getText());

		// if no phone entered return false
		if (homePhone.getText() == null && cellPhone.getText() == null)
			return false;

		String tempPhone;
		if (cellPhone.getText() != null) {
			tempPhone = cellPhone.getText();
			if (!checker.Verify("PHONE", tempPhone))
				return false;
			newBilling.setCellPhone(tempPhone);
		}
		if (homePhone.getText() != null) {
			tempPhone = homePhone.getText();
			if (!checker.Verify("PHONE", tempPhone))
				return false;
			newBilling.setHomePhone(tempPhone);
		}

		if (!checker.Verify("CITY", city.getText()))
			return false;
		newBilling.setCity(city.getText());

		newBilling.setState(state.getValue());

		// When insurance is added just link TODO
		Insurance newInsurance = new Insurance();
		newBilling.setInsurance(newInsurance);

		return true;
	}

	/**
	 * Validates the Date MONTH/DAY/YEAR
	 * 
	 * @param toDate
	 * @return
	 */
	private boolean toDate(String toDate) {
		toDate = String.format("%s/%s/%s", monthOfBirth.getValue(),
				dayOfBirth.getText(), yearOfBirth.getText());
		if (!checker.Verify("DATE", toDate))
			return false;
		return true;
	}

	/**
	 * validates and returns a Name
	 * 
	 * @return
	 */
	private Boolean newName(Name newName) {
		if (!checker.Verify("FIRSTNAME", firstName.getText()))
			return false;
		newName.setFirstName(firstName.getText());

		if (!checker.Verify("MINITIAL", mInitial.getText()))
			return false;
		newName.setmInitial(mInitial.getText());

		if (!checker.Verify("LASTNAME", lastName.getText()))
			return false;
		newName.setLastName(lastName.getText());

		return true;
	}

	@FXML
	private void handleBackButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == backButton) {
			// finding reference for button's stage
			stage = (Stage) backButton.getScene().getWindow();
			// now loading SearchResults as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/MainMenu.fxml"));
			// makes SearchResults scene and show it on the stage
			Scene MainMenu = new Scene(root);
			stage.setScene(MainMenu);
			stage.setTitle("Emanon File System - Main Menu");
			stage.show();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
