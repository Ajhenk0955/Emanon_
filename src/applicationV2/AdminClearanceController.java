package applicationV2;

import backdoor_.DataBase;
import backdoor_.Flags;
import backdoor_.Patient;
import backdoor_.UserAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * appropriately responds to flags
 * 
 * @author Andrew
 *
 */
public class AdminClearanceController {

	@FXML
	private PasswordField password;

	@FXML
	private TextField userName;

	@FXML
	private Button confirmButton;
	
	private Flags flags;

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
	 *TODO report errors
	 */
	@FXML
	void adminVerifyAction(ActionEvent event) {
		DataBase database = new DataBase(userName.getText(), password.getText()
				.toCharArray(), false);


		// create user account
		if (flags.isCreateUser()) {
			database.addAccount(flags.getTempUser());
			flags.setTempUser(null);
			flags.setCreateUser(false);
		}
		// add patient
		if (flags.isAddPatient()) {
			database.addPatient(flags.getPatient());
			flags.setAddPatient(false);
			flags.setPatient(null);
		}
		// delete patient
		if (flags.isDeletePatient()) {
			database.deletePatient(flags.getId());
			flags.setDeletePatient(false);
			flags.setId(null);
		}
		// edit patient
		if (flags.isEditPatient()) {
			database.UpdateData(flags.getPatient());
			flags.setEditPatient(false);
			flags.setId(null);
		}
		// edit user account
		if (flags.isEditUser()) {
			database.UpdateUser(flags.getTempUser());
			flags.setDeletePatient(false);
			flags.setId(null);
		}
		// add file
		// delete file
		// edit file
	}

}
