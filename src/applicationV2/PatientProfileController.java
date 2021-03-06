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
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class PatientProfileController implements Initializable{

	@FXML
	private Button mainMenuButton,mainMenuButton3, DomoButton, DomoButton2, addFileButton, addFileButton2, patientHxButton, pictureButton, saveButton;
	
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
			stage.setTitle("Emanon File System - Main Menu");
			stage.setScene(scene);
			stage.show();
		}
	}	
	//method to view [DOMO]
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
			stage.setTitle("Emanon File System");
			stage.show();
		}
	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	//method to add a file in patient profile
	@FXML
	private void handleAddFileButton(ActionEvent e1) throws IOException {
		//Stage stage;
		Parent root;
		if (e1.getSource() == addFileButton || e1.getSource() == addFileButton2) {
			
			// finding reference for button stage
			Stage stage = new Stage();
			
			//file chooser
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Open Resource File");
			fileChooser.showOpenDialog(stage);
			// now loading CreatePatientScreen as parent
					
		}
	}
	
	//method to view patient HX
	@FXML
	private void handlePatientHxButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == patientHxButton) {
			// finding reference for button stage
			stage = (Stage) patientHxButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Copy of PatientProfile(2) - Copy.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Emanon File System - Gingerbread Man");
			stage.show();
		}
	}
	
	//method to view pictures
	@FXML
	private void handlePictureButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == pictureButton) {
			// finding reference for button stage
			stage = (Stage) pictureButton.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Copy of PatientProfile(3) - Copy.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Emanon File System - Pictures");
			stage.show();
		}
	}
	
	/////////////////////

	/**
	 * 
	 * @Author Sam
	 * Method to handle the delete files button 
	 */
	@FXML
	private Button deleteFileButton;
	
	@FXML
	private void handleDeleteFileButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == deleteFileButton) {
			// finding reference for button stage
			stage = new Stage() ;
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/DeleteFWarning.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Administrator Confirmation");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(deleteFileButton.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window

		}
	}	


	//////
	
	/**
	 * 
	 * @Author Sam
	 * Method to handle the delete profiles button 
	 */
	@FXML
	private Button deleteProfileButton;
	@FXML
	private void handleDeleteProfileButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == deleteProfileButton) {
			// finding reference for button stage
			stage = new Stage() ;
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/DeleteWarning.fxml"));
			stage.setScene(new Scene(root)); // making a new scene
			stage.setTitle("Administrator Confirmation");
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initOwner(deleteProfileButton.getScene().getWindow());
			stage.showAndWait();// forces program to focus on pop up window

		}
	}	

	////////////////////
	
}
