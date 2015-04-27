package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import backdoor_.Billing;
import backdoor_.DataBase;
import backdoor_.Flags;
import backdoor_.Insurance;
import backdoor_.Name;
import backdoor_.Patient;
import backdoor_.TableResults;
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
			state, Gender;
	private Patient newPatient;
	private Flags flags = new Flags();

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
				// TODO bad input popup
			} else {
				// TODO pass information to PATIENT PROFILE SCREEN
				// finding reference for button's stage
				stage = (Stage) saveButton.getScene().getWindow();
				// now loading PatientProfile as parent
				root = FXMLLoader.load(getClass().getResource(
						"/applicationV2/PatientProfile.fxml")); // change
																// this
																// to
																// PatientProfile

				// makes PatientProfile scene and show it on the stage
				Scene patientProfile = new Scene(root);
				stage.setScene(patientProfile);
				stage.setTitle("Patient Profile");
				stage.show();
			}
		}
	}

	/**
	 * authenticates admin permission. Puts data to database via
	 * adminclearancecontroller
	 * 
	 * @throws IOException
	 */
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
		if (!newName(newName)){
			System.out.println("Problem");
			return false;
		}
		newPatient.setName(newName);
		System.out.println("Name passed");

		// BirthDate (month/day/year)
		String toDate = "";
		if (!toDate(toDate))
			return false;
		newPatient.setBirthDate(toDate);
		System.out.println("Birthday passed");

		// Billing & insurance
		Billing newBilling = new Billing();
		newBilling = newBilling();
		if (newBilling == null)
			return false;
		newPatient.setBilling(newBilling);
		System.out.println("billing passed");

		// Gender
		if (Gender.getText() == null)
			return false;
		newPatient.setGender(Gender.getText());
		System.out.println("Gender passed");

		// SSN
		if (!checker.Verify("SSN", ssn.getText()))
			return false;
		newPatient.setSSN(parseSSN(ssn.getText()));
		System.out.println("SSN passed");

		// put data to flags
		flags.setPatient(newPatient);
		flags.setAddPatient(true);

		try {
			popupAuth();
		} catch (IOException e) {
			return false;
		}

		return true;
	}

	/**
	 * removes '-' from the SSN
	 * @param text
	 * @return
	 */
	private int parseSSN(String text) {
		String result = text.replace("-","");
		return Integer.parseInt(result);
	}

	/**
	 * Verifies and sets billing and insurance
	 * 
	 * @param newBilling
	 * @return
	 */
	private Billing newBilling() {
		Billing newBilling = new Billing();
		if (!checker.Verify("US-ZIP", zipCode.getText()))
			return null;

		newBilling.setZipCode(zipCode.getText());
		System.out.println("ZIP passed");

		// if no phone entered return false
		if (homePhone.getText() == null && cellPhone.getText() == null)
			return null;

		String tempPhone;
		if (cellPhone.getText() != null) {
			tempPhone = cellPhone.getText();
			if (!checker.Verify("PHONE", tempPhone))
				return null;
			newBilling.setCellPhone(tempPhone);
		}
		// TODO problem with homephone
		if (homePhone.getText() != null) {
			tempPhone = homePhone.getText();
			if (!checker.Verify("PHONE", tempPhone))
				return null;
			newBilling.setHomePhone(tempPhone);
		}
		System.out.println("Phone passed");

		if (!checker.Verify("CITY", city.getText()))
			return null;
		newBilling.setCity(city.getText());
		System.out.println("City passed");

		if (!checker.Verify("STATE", state.getText()))
			return null;
		newBilling.setState(state.getText());
		System.out.println("state passed");

		newBilling.setAddress(address.getText());
		return newBilling;
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
