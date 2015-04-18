package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;

import backdoor_.Billing;
import backdoor_.Insurance;
import backdoor_.Name;
import backdoor_.Patient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreatePatientController implements Initializable {

	@FXML
	private Button saveButton, backButton;

	// form variables
	@FXML
	private TextField lastName, zipCode, mInitial, homePhone, dayOfBirth,
			ssn, firstName, cellPhone, yearOfBirth, address, city;
	
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

			if (!makeNewPatient()) {
				// ERROR HERE (INVALID INPUT)
			} else {
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
			}
		}
	}

	/**
	 * AHenk Verifies user inputs Puts new data into a Patient POJO Requests
	 * database to put data
	 * 
	 * @return
	 */
	private boolean makeNewPatient() {
		// TODO VERIFY INPUTS
		Patient newPatient = new Patient();

		// Name
		Name newName = new Name();
		newName.setFirstName(firstName.getText());
		newName.setmInitial(mInitial.getText());
		newName.setLastName(lastName.getText());
		newPatient.setName(newName);

		// BirthDate (month/day/year)
		String tempDate = String.format("%s %d, %s", monthOfBirth.getValue(),
				dayOfBirth.getText(), yearOfBirth.getText());
		Date strToDate = null;

		try {
			strToDate = DateFormat.getDateInstance().parse(tempDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Problem with the Date");
			e.printStackTrace();
		}

		newPatient.setBirthDate(strToDate);

		// Billing
		Billing newBilling = new Billing();

		newBilling.setZipCode(zipCode.getText());
		newBilling.setState(state.getValue());

		newBilling.setHomePhone(homePhone.getText());
		newBilling.setCity(city.getText());
		newBilling.setCellPhone(cellPhone.getText());

		// When insurance is added just link TODO
		Insurance newInsurance = new Insurance();
		newBilling.setInsurance(newInsurance);

		newPatient.setBilling(newBilling);

		newPatient.setGender(gender.getValue());

		// SSN
		newPatient.setSSN(ssn.getText());

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
