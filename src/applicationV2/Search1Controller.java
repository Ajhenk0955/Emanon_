package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backdoor_.Flags;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Search1Controller implements Initializable {

	@FXML
	private Button Search1_goButton, backButton;
	@FXML
	private TextField searchTerm;
	@FXML
	private TableColumn<?, ?> resultName, resultService, resultInsurance;
	
	private Flags flags;

	/**
	 * Method to handle Search1_goButton event
	 * 
	 * @Author M
	 * 
	 */
	@FXML
	private void search1_buttons(ActionEvent ButtonClick) throws IOException {
		Stage stage;
		Parent root;

		// User clicks Go! Button
		if (ButtonClick.getSource() == Search1_goButton) {

			// finding reference for button's stage
			stage = (Stage) Search1_goButton.getScene().getWindow();
			// now loading SearchResults as parent
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(
					"/applicationV2/SearchResults.fxml"));     

			root = (Parent)fxmlLoader.load(); 
			
			//Sets variables for search page
			SearchResultsController controller = fxmlLoader.<SearchResultsController>getController();
			updateFlags();
			controller.setFlags(flags);
			
			// makes SearchResults scene and show it on the stage
			Scene searchResults = new Scene(root);
			stage.setScene(searchResults);
			stage.setTitle("Emanon File System - Search Results");
			stage.show();
		}
	}

	/**
	 * Method to go back to the previous screen
	 * 
	 * @Author M
	 * 
	 */
	@FXML
	private void handleBackButton(ActionEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (e1.getSource() == backButton) {
			// finding reference for button's stage
			stage = (Stage) backButton.getScene().getWindow();
			// now loading SearchResults as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/MainMenu.fxml"));
			// makes SearchResults scene and show it on the stage
			Scene MainMenu = new Scene(root);
			stage.setScene(MainMenu);
			stage.setTitle("Emanon File System - Main Menu");
			stage.show();
		}
	}
	

	/*
	 * should update a flags variable with checkboxes and searchTerms
	 * @author Henk
	 */
	private void updateFlags() {
		// TODO Auto-generated method stub
		
	}

	public void initialize(URL location, ResourceBundle resources) {
	}

}
