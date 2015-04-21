package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import backdoor_.Flags;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class SearchResultsController implements Initializable {
	@FXML
	private Button backButton, mainMenuButton;

	@FXML
	private TableColumn<?, ?> resultService;

	@FXML
	private TableColumn<?, ?> resultInsrance;

	@FXML
	private TableColumn<?, ?> resultNames;
	//private ObservableList observableList = FXCollections.observableArrayList();

	/**
	 * Method to go back to the search screen
	 * Author M
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
					"/applicationV2/Search1.fxml"));
			// makes SearchResults scene and show it on the stage
			Scene search1 = new Scene(root);
			stage.setScene(search1);
			stage.setTitle("Emanon File System - Search");
			stage.show();
		}
	}
	
	/**Method to go back to the main menu screen
	 * @Author M
	 */
	@FXML
	private void handleMainMenuButton(ActionEvent e2) throws IOException{
		Stage stage;
		Parent root;
		
		if(e2.getSource() == mainMenuButton){
			stage = (Stage) mainMenuButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource("/applicationV2/MainMenu.fxml"));
			Scene MainMenu = new Scene(root);
			stage.setScene(MainMenu);
			stage.setTitle("Emanon File System - Main Menu");
			stage.show();			
		}
	}
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		//Flags flag = Main.getFlags();
		//String search = flag.getSearchTerms();

	}

}
