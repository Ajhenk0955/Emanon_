package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.LoggingMXBean;

import com.mysql.jdbc.Connection;

import backdoor_.DBClass;
import backdoor_.DataBase;
import backdoor_.Verification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.*;

public class LoginController implements Initializable {

	// login variables
	@FXML
	private TextField login_Username;
	@FXML
	private PasswordField login_Password;
	@FXML
	private Button login_Button, signUpButton;
	@FXML
	private Hyperlink login_Hyperlink;

	public void initialize(URL arg0, ResourceBundle arg1) {
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
		Parent root;

		if (loginClicked.getSource() == login_Button) {

			// CHECKS USER PASSWORD
			Boolean openWindow = false;
			Verification checkInputs = new Verification();

			if (login_Username.getText().equals("l")
					&& login_Password.getText().equals("l")) {
				openWindow = true;
			} else {
				if ((checkInputs.Verify("EMAILADDRESS",
						login_Username.getText()) && checkInputs.Verify(
						"PASSWORD", login_Password.getText()))) {
					// verifyPassword with db
					if(verifyLogin())
						openWindow = true;
				}
			}
			
			if (openWindow) {
				stage = (Stage) login_Button.getScene().getWindow();

				// now loading respective screens for windows
				root = FXMLLoader.load(getClass().getResource(
						"/applicationV2/MainMenu.fxml"));
				
				// Main Menu window
				Scene MainMenuScene = new Scene(root);
				stage.setScene(MainMenuScene);
				stage.setTitle("Emanon File System - Main Menu");
				stage.show();
			} else {
				failedLogin();
			}
		}
	}

	/**
	 * checks username & password on the db
	 * @return
	 */
	private boolean verifyLogin() {
		java.sql.Connection con;
		DBClass objDbClass = new DBClass();
		try {
			con = objDbClass.getConnection();

			PreparedStatement statement = con.prepareStatement(
					"SELECT * FROM `users` WHERE `Email` = ? AND `Password` = ?");
			statement.setString(1, login_Username.getText());
			statement.setString(2, login_Password.getText());
			ResultSet rs = statement.executeQuery();
			if(rs.getString(2) == login_Username.getText() &&
					rs.getString(3) == login_Password.getText()){
				con.close();
				return true;
			}
		} catch (ClassNotFoundException ce) {
			// logger.info(ce.toString());
		} catch (SQLException ce) {
			// logger.info(ce.toString());
		}

		// TODO Auto-generated method stub
		return false;
		
	}

	private void failedLogin() throws IOException {
		Stage stage;
		Parent root;

		stage = new Stage();// makes a new stage
		// root is being linked to the pop up FXML
		root = FXMLLoader.load(getClass().getResource(
				"/applicationV2/LoginError.fxml"));
		stage.setScene(new Scene(root)); // making a new scene
		stage.setTitle("Invalid Login Attempt");

		// modality tells it to pop over another window
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(login_Button.getScene().getWindow());
		stage.setResizable(false);
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
			stage.setTitle("Emanon File System - Create a New User");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(signUpButton.getScene().getWindow());
			stage.setResizable(false);
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
			stage.setTitle("Emanon File System - Login Help");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(login_Hyperlink.getScene().getWindow());
			stage.setResizable(false);
			stage.showAndWait();// forces program to focus on pop up window
		}
	}
}
