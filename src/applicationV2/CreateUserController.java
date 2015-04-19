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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateUserController implements Initializable {
	@FXML
	private Button cancelButton, submitButton;
	
	@FXML
	private TextField eMail, eMail_, firstName, lastName;
	
	@FXML
	private PasswordField password, password_;

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Method to handle the buttons in the createUser screen
	 * @Author M
	 */
	@FXML
	private void handleCancelButton(ActionEvent e0) throws IOException {
		Stage stage;
		Parent root;
		
		if (e0.getSource() == submitButton) {
			// finding reference for button stage
			stage = (Stage) submitButton.getScene().getWindow();
			stage.close();
			// now loading CreatePatientScreen as parent
			root = FXMLLoader.load(getClass().getResource(
					"/applicationV2/Warning.fxml")); //ha ha
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} else {
			stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
		}

	}
}
