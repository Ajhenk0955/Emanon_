package applicationV2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class EditUserProfileController implements Initializable {
	
	@FXML
	private Button closeButton;

	/**
	 * Method to close the EditUserProfile window
	 * Author M
	 * 
	 */
	@FXML
	private void handleCloseButton(ActionEvent e){
		if(e.getSource() == closeButton){
			Stage stage = (Stage)closeButton.getScene().getWindow();
			   stage.close();
		}
	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
