package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Logout_PopupController implements Initializable {

	@FXML
	private Button logout_Cancel, logout_Yes;


	/**TODO
	 * Method to exit out of the program with Logout pop up
	 * Author M
	 * 
	 */	
	@FXML
	private void handleLogoutPopup(ActionEvent e) throws IOException {
		Stage stage;
		Parent root;
		if (e.getSource() == logout_Yes) {
			// finding reference for button stage
			stage = (Stage) logout_Yes.getScene().getWindow();
			stage.close();
			/*root = FXMLLoader.load(getClass().getResource(
			"/applicationV2/Login.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);*/
			
			stage.show();
			Platform.exit();
		}
		else{
			 stage=(Stage)logout_Cancel.getScene().getWindow();
			   stage.close();
		}
		

	}

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

}
