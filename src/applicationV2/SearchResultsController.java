package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import backdoor_.DBClass;
import backdoor_.Flags;
import backdoor_.TableResults;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchResultsController implements Initializable {
	@FXML
	private Button backButton, mainMenuButton;

	@FXML
	private Label gingerLabel;

	@FXML
	private TableView<TableResults> resultTable;
	@FXML
	private TableColumn<TableResults, String> resultName;
	@FXML
	private TableColumn<TableResults, String> resultService;
	@FXML
	private TableColumn<TableResults, String> resultInsurance;

	private Connection con;

	private ObservableList<TableResults> data;
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

	@FXML
	private void handleClickProfile(MouseEvent e1) throws IOException {
		Stage stage;
		Parent root;
		if (MouseEvent.MOUSE_CLICKED != null) {
			// finding reference for button stage
			stage = (Stage) gingerLabel.getScene().getWindow();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Copy of PatientProfile(1) - Copy.fxml"));

			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Emanon File System - Gingerbread Man");
			stage.show();
		}
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		assert resultTable != null : "fx:id=\"tableview\" was not injected: check your FXML file 'SearchResults.fxml'.";
		resultName
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"patientName"));
		resultService
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"service"));
		resultInsurance
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"insurance"));
		DBClass objDbClass = new DBClass();
		try {
			con = objDbClass.getConnection();
			buildData();
		} catch (ClassNotFoundException ce) {
			// logger.info(ce.toString());
		} catch (SQLException ce) {
			// logger.info(ce.toString());
		}
	}

	/**
	 * puts search results to the set
	 */
	private void buildData() {
	    data = FXCollections.observableArrayList();

		try {
			String SQL = getResults();
			ResultSet rs = con.createStatement().executeQuery(SQL);
			while (rs.next()) {
				TableResults cm = new TableResults();
				cm.patientName.set(rs.getString("firstName")
						+ rs.getString("lastName"));
				cm.service.set(rs.getString("Service"));
				cm.insurance.set(rs.getString("insurance"));
				data.add(cm);
			}
			resultTable.setItems(data);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}
	}

	/**
	 * controller for retrieving search results calls DataBase
	 * 
	 * @return
	 */
	private String getResults() {
		// int settings = flags.toFinalString();
		int settings = 11;
		// eye, ear, nose, va, insurance, medicare, search
		switch (settings) {
		case 1:
			settings = 11; // eye
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE Service = 'eye'";

		case 2:
			settings = 101; // ear
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE Service = 'ear'";

		case 3:
			settings = 1001; // nose
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE Service = 'nose'";

		case 4:
			settings = 10001; // va
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE Insurance = 'va'";

		case 5:
			// TODO finish this db method
			settings = 100001; // other insurance
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE Insurance != 'va' AND Insurance != 'medicare'";

		case 6:
			settings = 1000001; // medicare
			return "SELECT Service, firstName, Insurance"
					+ "FROM patientinformation"
					+ "INNER JOIN patientinsurance ON patientinformation.patientID=patientinsurance.PatientID"
					+ "INNER JOIN patients ON patientinformation.patientID=patients.PatientID"
					+ "WHERE Insurance = 'medicare';";

		case 7:
			settings = 10000001; // search term
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patients`"
					+ "INNER JOIN patientinformation ON patients.PatientID=patientinformation.patientID"
					+ " INNER JOIN patientinsurance ON patients.PatientID=patientinsurance.patientID"
					+ " WHERE firstName LIKE '%"
					+ flags.getSearchTerms()
					+ "%' OR"
					+ " lastName LIKE '%"
					+ flags.getSearchTerms()
					+ "%'";

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
