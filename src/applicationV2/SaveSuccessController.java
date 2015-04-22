package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SaveSuccessController implements Initializable {

	
	private void handleSaveSuccess() throws IOException {
		Stage stage;
		Parent root;

		stage = new Stage();// makes a new stage
		// root is being linked to the pop up FXML
		root = FXMLLoader.load(getClass().getResource(
				"/applicationV2/SaveSuccess.fxml"));
		stage.setScene(new Scene(root)); // making a new scene
		stage.setTitle("Emanon File System");

		// modality tells it to pop over another window
		stage.initModality(Modality.APPLICATION_MODAL);
		//stage.initOwner(login_Button.getScene().getWindow());
		stage.showAndWait();// forces program to focus on pop up window
	}
	
	
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
