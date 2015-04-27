package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Statement;

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
	private Button backButton, mainMenuButton, loadResults;

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
	
	@FXML
	private void refreshButton(ActionEvent refresh){
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
		resultName
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"patientName"));
		resultService
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"service"));
		resultInsurance
				.setCellValueFactory(new PropertyValueFactory<TableResults, String>(
						"insurance"));
	}

	/**
	 * puts search results to the set
	 */
	private void buildData() {
		data = FXCollections.observableArrayList();
		try {
			PreparedStatement statement = con.prepareStatement(getResults());
			ResultSet rs = statement.executeQuery();

			
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
	private String getResults() throws SQLException {
		int settings = flags.toFinalString();
		// eye, ear, nose, va, insurance, medicare, search

		switch (settings) {

		case 11: //eye
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE Service = 'Test'";

		case 101: // ear
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE Service = 'ear'";

		case 1001: // nose
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE Service = 'nose'";

		case 10001: // va
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE Insurance = 'va'";

		case 100001: // other insurance
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE Insurance != 'va' AND Insurance != 'medicare'";

		case 1000001: // medicare
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ "WHERE Insurance = 'medicare';";

		case 10000001: // search term
			return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
					+ " FROM `patient`"
					+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
					+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
					+ " WHERE firstName LIKE '%"
					+ flags.getSearchTerms()
					+ "%' OR"
					+ " lastName LIKE '%"
					+ flags.getSearchTerms()
					+ "%'";

		}

		return "SELECT `firstName`,`lastName`,patientinformation.Service, patientinsurance.Insurance"
				+ " FROM `patient`"
				+ "INNER JOIN patientinformation ON patient.SSN=patientinformation.SSN"
				+ " INNER JOIN patientinsurance ON patient.SSN=patientinsurance.SSN"
				+ " WHERE Service = 'Test'";
	}

	public Flags getFlags() {
		return flags;
	}

	public void setFlags(Flags flags) {
		this.flags = flags;
	}

}
