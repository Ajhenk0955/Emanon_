package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.LoggingMXBean;

import backdoor_.DataBase;
import backdoor_.Verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class LoginController implements Initializable {

	// login variables
	@FXML
	private TextField login_userName;
	@FXML
	private PasswordField login_Password;
	@FXML
	private Button login_Button, signUpButton;
	@FXML
	private Hyperlink login_Hyperlink;

	// pop up window variables
	private Button submitLoginRecovery;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	}

	/**
	 * method when login button is clicked
	 * 
	 * @param loginClicked
	 * @stage2 is invisible window
	 */
	@FXML
	private void handleLoginButton(ActionEvent loginClicked) throws IOException {
		Stage stage;
		Parent root, root2;

		if (loginClicked.getSource() == login_Button) {

			Boolean openWindow = false;
			Verification checkInputs = new Verification();

			/*
			 * if (login_userName.getText() != null
			 * 
			 * && login_Password.getText() != null) if
			 * ((checkInputs.Verify("EMAIL", login_userName.getText()) &&
			 * checkInputs .Verify("PASSWORD", login_Password.getText())) ||
			 * (login_userName.getText().equals("test") && login_Password
			 * .getText().equals("test"))) { try { DataBase logging = new
			 * DataBase( login_userName.getText(), login_Password
			 * .getText().toCharArray(), true); } catch (Exception e) { // ERROR
			 * HERE openWindow = false; // TODO failed login window // Test Case
			 * if (login_userName.getText().equals("test") &&
			 * login_Password.getText().equals("test")) { openWindow = true; } }
			 */// }
				// if (openWindow) {

			stage = (Stage) login_Button.getScene().getWindow();
			Stage stage2 = new Stage(); // will be invisible stage

			// now loading respective screens for windows
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/MainMenu.fxml"));
			root2 = FXMLLoader.load(getClass().getResource(
					"/applicationV2/InvisibleWindow.fxml"));

			// Invisible window that gets hidden
			Scene invisibleWindow = new Scene(root2);
			stage2.setScene(invisibleWindow);
			stage2.setTitle("Emanon File System - Invisible Window");
			stage2.hide();

			// Main Menu window 
			Scene MainMenuScene = new Scene(root);
			stage.setScene(MainMenuScene);
			stage.setTitle("Emanon File System - Main Menu");
			stage.show();
			// } else {
			// System.out.println("FAILLLLLLLL");
			// failedLogin();
			// }
		}

	}

	private void failedLogin() throws IOException {
		Stage stage;
		Parent root;

		stage = new Stage();// makes a new stage
		// root is being linked to the pop up FXML
		root = FXMLLoader.load(getClass().getResource(
				"/applicationV2/LoginError.fxml"));
		stage.setScene(new Scene(root)); // making a new scene
		stage.setTitle("Log out?");

		// modality tells it to pop over another window
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(login_Button.getScene().getWindow());
		stage.showAndWait();// forces program to focus on pop up window
	}

	// method when sign up button is clicked
	@FXML
	private void handleSignUpButton(ActionEvent signUpClicked)
			throws IOException {
		Stage stage;
		Parent root;

		if (signUpClicked.getSource() == signUpButton) {
			stage = new Stage();// makes a new stage
			// root is being linked to the pop up FXML
			root = FXMLLoader.load(getClass().getResource("CreateUser.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Create a New User");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(signUpButton.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window
		}
	}

	// method when "Forgot Username/Password" hyperlink is clicked
	@FXML
	private void handleLoginHyperlink(ActionEvent hyperlinkClicked)
			throws IOException {
		Stage stage;
		Parent root;

		if (hyperlinkClicked.getSource() == login_Hyperlink) {
			stage = new Stage();// makes a new stage
			// root is being linked to the pop up FXML
			root = FXMLLoader.load(getClass().getResource("LoginPopup.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Login Help");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(login_Hyperlink.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window
		}
	}

}
