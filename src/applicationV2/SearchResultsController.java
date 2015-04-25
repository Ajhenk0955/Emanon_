package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import backdoor_.Flags;
import backdoor_.Patient;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SearchResultsController implements Initializable {
	@FXML
	private Button backButton, mainMenuButton;

	@FXML
	private TableView<Patient> resultTable;
	@FXML
	private TableColumn<Patient, String> resultName;
	@FXML
	private TableColumn<Patient, String> resultService;
	@FXML
	private TableColumn<Patient, String> resultInsurance;

	private ObservableList<Patient> data;
	private Flags flags;

	/**
	 * Method to go back to the search screen Author M
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

	/**
	 * Method to go back to the main menu screen
	 * 
	 * @Author M
	 */
	@FXML
	private void handleMainMenuButton(ActionEvent e2) throws IOException {
		Stage stage;
		Parent root;

		if (e2.getSource() == mainMenuButton) {

			stage = (Stage) mainMenuButton.getScene().getWindow();
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/MainMenu.fxml"));
			Scene MainMenu = new Scene(root);
			stage.setScene(MainMenu);
			stage.setTitle("Emanon File System - Main Menu");
			stage.show();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		resultName
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"resultName"));
		resultService
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"resultService"));
		resultInsurance
				.setCellValueFactory(new PropertyValueFactory<Patient, String>(
						"resultInsurance"));

		buildData();

	}

	/**
	 * puts search results to the set
	 */
	private void buildData() {
		List<Patient> results = getResults();
		for (Patient patient : results) {
			data.add(patient);
		}
		resultTable.setItems(data);
	}

	/**
	 * controller for retrieving search results calls DataBase
	 * 
	 * @return
	 */
	private List<Patient> getResults() {
		int settings = flags.toFinalString();
		
		// eye, ear, nose, va, insurance, medicare, search
		switch (settings) {
        case 1:  settings = 11; // eye
                 break;
        case 2:  settings = 101; // ear
                 break;
        case 3:  settings = 1001; // nose
                 break;
        case 4:  settings = 10001; // va
                 break;
        case 5:  settings = 100001; // other insurance
                 break;
        case 6:  settings = 1000001; // medicare
                 break;
        case 7:  settings = 10000001; // search term
                 break;

    }
		
		
			
		return null;
	}

	public Flags getFlags() {
		return flags;
	}

	public void setFlags(Flags flags) {
		this.flags = flags;
	}

}
