package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PasswordResetController implements Initializable {

	@FXML 
	private Button cancelButton, PasswordSubmitButton, okButton;
	
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
		
			SuccessPopup();//creates pop up "Success"
			}
		}
	
	/**
	 * 
	 * creates the pop up window when user successfully changes password
	 */
	@FXML
	private void SuccessPopup() throws IOException{
		Stage stage;
		Parent root;
		
		stage = (Stage) PasswordSubmitButton.getScene().getWindow();
		// now loading SearchResults as parent
		root = FXMLLoader.load(getClass().getResource(
				"/applicationV2/PasswordReset2.fxml"));

		Scene s = new Scene(root);
		stage.setScene(s);
		stage.setResizable(false);
		stage.setTitle("Emanon File System - Password Reset");
		stage.show();	

	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
