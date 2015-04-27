package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * This controller takes care of LoginPopup.fxml, LoginPopUpP2.fxml,
 * LoginPopUp3.fxml, LoginPopup4.fxml
 * 
 * 
 * @author M
 *
 */

public class LoginPopupController implements Initializable {
	@FXML
	private Button nextButton, nextButton2, submitButton3, okButton;

	/**
	 * LoginPopup Handles the next button where e-mail recovery is asked for
	 */
	@FXML
	private void handleNextButton(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;// TODO verifies that user entered a proper email
		if (e.getSource() == nextButton) {

			stage = (Stage) nextButton.getScene().getWindow();
			// now loading SearchResults as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/LoginPopupP2.fxml"));

			Scene s = new Scene(root);
			stage.setScene(s);
			stage.setResizable(false);
			stage.setTitle("Emanon File System - Login Help");
			stage.show();
		}
	}

	/**
	 * LoginPopup2 Handles the next button where security question is prompted
	 *
	 */
	@FXML
	private void handleNextButton2(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;// TODO verifies that question was answered
		if (e.getSource() == nextButton2) {

			stage = (Stage) nextButton2.getScene().getWindow();
			// now loading SearchResults as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/LoginPopupP3.fxml"));

			Scene s = new Scene(root);
			stage.setScene(s);
			stage.setResizable(false);
			stage.setTitle("Emanon File System - Login Help");
			stage.show();
		}
	}

	/**
	 * LoginPopup3 Handles the submit button that successfully changes the
	 * password
	 * 
	 * @throws IOException
	 *
	 */
	@FXML
	private void handleSubmitButton3(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;// TODO changes the password
		if (e.getSource() == submitButton3) {

			stage = (Stage) submitButton3.getScene().getWindow();
			// now loading SearchResults as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/LoginPopupP4.fxml"));

			Scene s = new Scene(root);
			stage.setScene(s);
			stage.setResizable(false);
			stage.show();
		}
	}

	/**
	 * LoginPopup4 lets user know that password change was successful password
	 * 
	 * @throws IOException
	 *
	 */
	@FXML
	private void handleOkButton(ActionEvent e) throws IOException {
		Stage stage;
		if (e.getSource() == okButton) { // TODO make sure user can log back in
											// with new password

			stage = (Stage) okButton.getScene().getWindow();
			stage.setResizable(false);
			stage.close();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
	

	}

}
