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
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {

	@FXML
	private Button searchButton, createPatientButton, logoutButton,
			quickSearch, edit_UserProfile;
	@FXML
	private TextField searchTerm;

	private Flags flags;

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

		if (e.getSource() == logoutButton) {
			stage = new Stage();// makes a new stage
			// root is being linked to the pop up FXML
			root = FXMLLoader.load(getClass().getResource("Logout_Popup.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setResizable(false);

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(logoutButton.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window

		}

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

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} else {

			if (searchTerm.getText() != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
						"/applicationV2/SearchResults.fxml"));

				root = (Parent) fxmlLoader.load();

				// sets the flag variable
				SearchResultsController controller = fxmlLoader
						.<SearchResultsController> getController();
				updateFlags();
				controller.setFlags(flags);

				stage = (Stage) quickSearch.getScene().getWindow();
				// now loading SearchingScreen as parent
				stage.setTitle("Emanon File System - Search Results");
			}
		}
	}

	private void updateFlags() {
		flags = new Flags();
		flags.setSearchTerms(searchTerm.getText());
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
	 * Method to handle userProfile screen popup
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
			stage.setResizable(false);
			stage.getIcons().add(
					new Image("file:resources/images/medical_record_logo.png"));

			// modality tells it to pop over another window
			stage.initModality(Modality.APPLICATION_MODAL);
			// stage.initOwner(edit_UserProfile.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
	}

}