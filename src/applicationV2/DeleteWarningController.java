package applicationV2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class DeleteWarningController {

	@FXML
	private Button cancelButton, deleteButton;
	

	
	@FXML
	private void handleDeleteButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == deleteButton) {
			// finding reference for button stage
			stage = (Stage) deleteButton.getScene().getWindow();
			stage.close();
		}
		else{
			 stage=(Stage) cancelButton.getScene().getWindow();
			   stage.close();
		}
		
		
	}	
}
/*
@FXML
	private Button deleteFileButton;
	
	@FXML
	private void handleDeleteFileButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == deleteFileButton) {
			// finding reference for button stage
			stage = (Stage) deleteFileButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/AdminClearance.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.showAndWait();// forces program to focus on pop up window
		}
	}	


*/