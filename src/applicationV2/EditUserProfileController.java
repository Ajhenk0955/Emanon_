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
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EditUserProfileController implements Initializable {
	
	@FXML
	private Button closeButton, changePasswordButton;

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
	
	/**
	 * Method to open the change password window Author M
	 * 
	 */
	@FXML 
	private void handleChangePasswordButton(ActionEvent e) throws IOException{
	Stage stage;
	Parent root;
	
		if(e.getSource() == changePasswordButton){
		stage = new Stage();// makes a new stage
		// root is being linked to the pop up FXML
		root = FXMLLoader.load(getClass().getResource("PasswordReset.fxml"));
		stage.setScene(new Scene(root)); // making a new scene
		stage.setTitle("Emanon File System - Reset Password");

		// modality tells it to pop over another window
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(changePasswordButton.getScene().getWindow());
		stage.setResizable(false);
		stage.getIcons().add(
				new Image("file:resources/images/medical_record_logo.png"));
		stage.showAndWait();// forces program to focus on pop up window
	}
	}
	
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
