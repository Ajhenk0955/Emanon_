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
import javafx.scene.control.*;
import javafx.stage.Stage;

public class MainMenuController implements Initializable {
	@FXML
	private Button searchButton, createPatientButton;

	/**
	 * @AuthorActilaurel 
	 */
	@FXML
	private void handleMMButtons(ActionEvent ButtonClick) throws IOException {
		Stage stage;
		Parent root;

		if (ButtonClick.getSource() == searchButton) {
			// finding reference for button stage
			stage = (Stage) searchButton.getScene().getWindow();
			// now loading SearchingScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Search1.fxml"));

		} else {
			// finding reference for button stage
			stage = (Stage) createPatientButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/CreatePatient.fxml"));

		}
		// creates a new scene depending on which branch was clicked
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();

	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
