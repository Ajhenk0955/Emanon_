package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backdoor_.Flags;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {
	@FXML
	private Button searchButton, createPatientButton, logoutButton,
			quickSearch, edit_UserProfile;
	@FXML
	private TextField searchTerm;

	/**
	 * Method to handle the log out button in the Main Menu
	 * 
	 * @Author M
	 * 
	 */
	@FXML
	private void handleMMLogoutButton(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;

		// TODO -- reference from one controller to another?
		if (e.getSource() == logoutButton) {
			stage = new Stage();// makes a new stage
			// root is being linked to the pop up FXML
			root = FXMLLoader.load(getClass().getResource("Logout_Popup.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Log out?");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(logoutButton.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window
			
		}
		/*
		 * TODO if below commented out, logout pop up X button works. but
		 * disconnects other buttons in the process. Maybe go with dialog boxes?
		 */

		// creates a new scene depending on which branch was clicked
		// Scene scene = new Scene(root);
		// stage.setScene(scene);
		// stage.show();

	}

	/**
	 * Method to take care of the search buttons
	 * 
	 * @Author M
	 * 
	 */

	@FXML
	private void handleSearchButton(ActionEvent e0) throws IOException {
		Stage stage;
		Parent root;

		if (e0.getSource() == searchButton) {
			// finding reference for button stage
			stage = (Stage) searchButton.getScene().getWindow();
			// now loading SearchingScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Search1.fxml"));
			stage.setTitle("Emanon File System - Search");
			
		} else {
		/*
			// setting flags search term
			Flags flags = Main.getFlags();
			if(searchTerm.getText() != null)
				flags.setSearchTerms(searchTerm.getText());
			*/
			stage = (Stage) quickSearch.getScene().getWindow();
			// now loading SearchingScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/SearchResults.fxml"));
			stage.setTitle("Emanon File System - Search Results");
		}
		// after either branch was selected
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Method to take care of the add patient button
	 * 
	 * @Author M
	 * 
	 */
	@FXML
	private void handleAddPatientButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == createPatientButton) {
			// finding reference for button stage
			stage = (Stage) createPatientButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/CreatePatient.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Emanon File System - Add Patient");
			stage.show();
		}
	}

	/**
	 * Method to handle menu bar for EditUserProfile
	 * 
	 * @Author M
	 * 
	 */
	@FXML
	private void handleUserProfile(ActionEvent e3) throws IOException {
		Stage stage;
		Parent root;

		if (e3.getSource() == edit_UserProfile) {
			stage = new Stage();// makes a new stage
			// root is being linked to the pop up FXML
			root = FXMLLoader.load(getClass().getResource(
					"EditUserProfile.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Emanon File System - User Profile");

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			// stage.initOwner(edit_UserProfile.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}