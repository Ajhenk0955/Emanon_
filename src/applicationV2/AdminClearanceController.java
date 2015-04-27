package applicationV2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import backdoor_.Billing;
import backdoor_.DBClass;

import backdoor_.DataBase;
import backdoor_.Flags;
import backdoor_.Patient;
import backdoor_.TableResults;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * appropriately responds to flags
 * 
 * @author Andrew
 *
 */
/**
 * @Author Sam
 * Handle buttons 
 */
public class AdminClearanceController {

	@FXML
	private PasswordField password;

	@FXML
	private TextField userName;

	@FXML
	private Button confirmButton, cancelButton;

	private Flags flags;
	private Connection con;
	private String SQL = "";

	public Flags getFlags() {
		return flags;
	}

	public void setFlags(Flags flags) {
		this.flags = flags;
	}

	/**
	 * should probably be a switch Checks flags, and resets flags
	 * 
	 * @param event
	 *            TODO report errors
	 */
	@FXML
	private void adminVerifyAction(ActionEvent event) {
		Stage stage = null;
		if (event.getSource() == confirmButton) {

			DBClass objDbClass = new DBClass();
			try {
				con = objDbClass.getConnection();
				/*
				 * 
				 * // create user account if (flags.isCreateUser()) {
				 * database.addAccount(flags.getTempUser());
				 * flags.setTempUser(null); flags.setCreateUser(false); }
				 */
				// add patient
				if (flags.isAddPatient()) {
					Patient patient = flags.getPatient();

					SQL = String.format("INSERT INTO `emanon`.`patient`"
							+ " (`SSN`, `firstName`, `lastName`) "
							+ "VALUES ('%d', '%s', '%s')", patient.getSSN(),
							patient.getName().getFirstName(), patient.getName()
									.getLastName());
					pushToDatabase();

					SQL = String
							.format("INSERT INTO `emanon`.`patientinformation`"
									+ " (`SSN`, `Gender`, `Service`, `Birthdate`)"
									+ " VALUES ('%d', '%s', '%s', '%s')",
									patient.getSSN(), patient.getGender(),
									patient.getPart(), patient.getBirthDate());
					pushToDatabase();

					Billing bill = patient.getBilling();
					SQL = String
							.format("INSERT INTO `emanon`.`patientbilling`"
									+ " (`SSN`, `HomePhone`, `CellPhone`, `State`, `City`, `Zip`, `Address`) "
									+ "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s')",
									patient.getSSN(), bill.getHomePhone(),
									bill.getCellPhone(), bill.getState(),
									bill.getCity(), bill.getZipCode(),
									bill.getAddress());
					pushToDatabase();
					flags.setAddPatient(false);
					flags.setPatient(null);

				}
				/*
				 * // delete patient if (flags.isDeletePatient()) {
				 * database.deletePatient(flags.getId());
				 * flags.setDeletePatient(false); flags.setId(null); } // edit
				 * patient if (flags.isEditPatient()) {
				 * database.UpdateData(flags.getPatient());
				 * flags.setEditPatient(false); flags.setId(null); } // edit
				 * user account if (flags.isEditUser()) {
				 * database.UpdateUser(flags.getTempUser());
				 * flags.setDeletePatient(false); flags.setId(null); }
				 */
			} catch (ClassNotFoundException ce) {
				// logger.info(ce.toString());
			} catch (SQLException ce) {
				// logger.info(ce.toString());
			}
			stage = (Stage) confirmButton.getScene().getWindow();

			stage.close();
			// add file
			// delete file
			// edit file
		}

	}

	private boolean pushToDatabase() {
		// return false;
		try {
			con.createStatement().executeUpdate(SQL);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error on Building Data");
		}
		return false;

	}
	
	
	
}
