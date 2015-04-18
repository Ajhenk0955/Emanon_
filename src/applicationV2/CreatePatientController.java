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

public class CreatePatientController implements Initializable {

	@FXML
	private Button saveButton;
	
	/** 
	 * Method for when user clicks the save button in CreatePatient
	 * @Author M
	 */
	
	@FXML
	private void handleSaveButton(ActionEvent click) throws IOException {
		Stage stage;
		Parent root;

		// User clicks save button
		if (click.getSource() == saveButton) {

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
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
