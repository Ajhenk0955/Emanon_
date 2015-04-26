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
	/**
	 * 
	 * @Author Sam
	 * Method to handle buttons on deletWarningControllerthe delete files button 
	 */
	@FXML
	private Button cancelButton, deleteButton;
	

	
	@FXML
	private void handleDeleteButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == deleteButton) {
	
			// finding reference for button stage
			stage = (Stage) deleteButton.getScene().getWindow();
			// now loading AdminClearance Screen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/AdminClearance.fxml"));
			stage = (Stage) deleteButton.getScene().getWindow();

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			
		}
		else{
			
			 stage=(Stage) cancelButton.getScene().getWindow();
			   stage.close();
		}
		
		
	}
	
}