package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backdoor_.Flags;
import backdoor_.UserAccount;
import backdoor_.Verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateUserController implements Initializable {
	@FXML
	private Button cancelButton, submitButton;

	@FXML
	private TextField eMail, eMail_, firstName, lastName;

	@FXML
	private PasswordField password, password_;

	private Flags flags;

	public void initialize(URL arg0, ResourceBundle arg1) {
	}

	/**
	 * Method to handle the buttons in the createUser screen
	 * 
	 * @Author M
	 */
	@FXML
	private void handleCancelButton(ActionEvent e0) throws IOException {
		Stage stage;
		if (e0.getSource() == submitButton) {
			if (validate()) {
				// ERROR HERE TODO put failure popup
			} else {
				popupAuth();
			}
		} else {
			stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
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
		stage.initOwner(submitButton.getScene().getWindow());
		stage.showAndWait();// forces program to focus on pop up window
	}

	private boolean validate() {
		Verification checker = new Verification();
		// eMail, eMail_, firstName, lastName;
		if ((!checker.Verify("EMAILADDRESS", eMail.getText()))
				|| (!checker.Verify("EMAILADDRESS", eMail_.getText()))
				|| !(eMail.getText().equals(eMail_.getText())))
			return false;

		if (!checker.Verify("FIRSTNAME", firstName.getText()))
			return false;

		if (!checker.Verify("LASTNAME", lastName.getText()))
			return false;

		if (!checker.Verify("PASSWORD", password.getText())
				|| (!checker.Verify("PASSWORD", password_.getText()))
				|| !(password.getText().equals(password_.getText())))
			return false;

		UserAccount newUser = new UserAccount();
		newUser.setEmail(eMail.getText());
		newUser.setFirstName(firstName.getText());
		newUser.setLastName(lastName.getText());
		newUser.setPassword(password.getText().toCharArray());

		// setting flags
		flags.setCreateUser(true);
		flags.setTempUser(newUser);
		return true;
	}
}
