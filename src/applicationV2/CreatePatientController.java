package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import backdoor_.Billing;
import backdoor_.Flags;
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
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Checks user inputs, pushes to database via database class TO DO: address,
 * insurance, and database pushing
 * 
 * @author Andrew
 *
 */
public class CreatePatientController implements Initializable {

	private Verification checker;

	@FXML
	private Button saveButton, backButton, DomoButton;

	// form variables
	@FXML
	private TextField lastName, zipCode, MInitial, homePhone, dayOfBirth, ssn,
			firstName, cellPhone, yearOfBirth, address, city, monthOfBirth,
			state, gender;
	private Patient newPatient;
	private Flags flags;

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

			if (makeNewPatient()) {
				// ERROR HERE (INVALID INPUT)
				// TODO bad input popup
			} else {
				// TODO pass information to PATIENT PROFILE SCREEN
				// finding reference for button's stage
				stage = (Stage) saveButton.getScene().getWindow();
				// now loading PatientProfile as parent
				root = FXMLLoader
						.load(getClass()
								.getResource(
										"/applicationV2/PatientProfile.fxml")); 

				// makes PatientProfile scene and show it on the stage
				Scene patientProfile = new Scene(root);
				stage.setScene(patientProfile);
				stage.setTitle("Patient Profile");
				stage.show();
			}
		}
	}

	private void popupAuth() throws IOException {
		Stage stage = new Stage();// makes a new stage
		Parent root;

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
				"/applicationV2/AdminClearance.fxml"));
		root = (Parent) fxmlLoader.load();
		stage.setScene(new Scene(root)); // making a new scene
		stage.setTitle("Authorize");

		AdminClearanceController controller = fxmlLoader
				.<AdminClearanceController> getController();
		controller.setFlags(flags);

		// modality tells it to pop over another window
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(saveButton.getScene().getWindow());
		stage.showAndWait();// forces program to focus on pop up window
	}

	/**
	 * AHenk Verifies user inputs Puts new data into a Patient POJO Requests
	 * database to put data
	 * 
	 * @return
	 */
	private boolean makeNewPatient() {
		newPatient = new Patient();
		checker = new Verification();

		// Name
		Name newName = new Name();
		if (!newName(newName))
			return false;
		newPatient.setName(newName);

		// BirthDate (month/day/year)
		String toDate = "";
		if (!toDate(toDate))
			return false;
		newPatient.setBirthDate(toDate);

		// Billing & insurance
		Billing newBilling = new Billing();
		if (newBilling(newBilling))
			return false;
		newPatient.setBilling(newBilling);

		// Gender
		if (gender.getText() == null)
			return false;
		newPatient.setGender(gender.getText());

		// SSN
		if (!checker.Verify("SSN", ssn.getText()))
			return false;
		newPatient.setSSN(ssn.getText());

		try {
			popupAuth();
		} catch (IOException e) {
			return false;
		}
		// put data to flags
		flags.setPatient(newPatient);
		flags.setAddPatient(true);
		return true;
	}

	/**
	 * Verifies and sets billing and insurance
	 * 
	 * @param newBilling
	 * @return
	 */
	private boolean newBilling(Billing newBilling) {

		if (!checker.Verify("US-ZIP", zipCode.getText()))
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

		if (!checker.Verify("STATE", state.getText()))
			return false;
		newBilling.setState(state.getText());

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
		toDate = String.format("%s/%s/%s", monthOfBirth.getText(),
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

		if (!checker.Verify("MINITIAL", MInitial.getText()))
			return false;
		newName.setmInitial(MInitial.getText());

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

	}

}
