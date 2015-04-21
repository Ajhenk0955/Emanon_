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
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PatientProfileController implements Initializable{

	@FXML
	private Button mainMenuButton, DomoButton;
	
	@FXML
	private Label patientNameLabel;

	
	@FXML
	private void handleMainMenuButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == mainMenuButton) {
			// finding reference for button stage
			stage = (Stage) mainMenuButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/MainMenu.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}	

	@FXML
	private void handleDomo(ActionEvent e1) throws IOException {
		//Stage stage;
		Parent root;
		if (e1.getSource() == DomoButton) {
			// finding reference for button stage
			Stage stage = new Stage();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/InvisibleWindow.fxml"));
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Emanon File System - Domo PeopleEater");
			stage.show();
		}
	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
