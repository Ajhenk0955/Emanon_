package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PasswordResetController implements Initializable {

	@FXML 
	private Button cancelButton, PasswordSubmitButton;
	
	/**
	 * Method to take care of the passwordSubmitButton
	 * 
	 * @Author M
	 * 
	 */

	@FXML
	private void handlePasswordSubmitButton(ActionEvent e) throws IOException{
		if(e.getSource() == PasswordSubmitButton){
			//TODO the information gets sent back to database?
		}
		else{
			Stage stage = (Stage)PasswordSubmitButton.getScene().getWindow();
			   stage.close();
		}
	}
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
