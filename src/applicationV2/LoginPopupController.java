package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginPopupController implements Initializable{
@FXML
private Button nextButton;

Stage prevStage;
	

public void setPrevStage(Stage stage){
	this.prevStage = stage;
}


public void handleNextButton(ActionEvent e) throws IOException{
	Stage stage = new Stage();
	Pane myPane = null;
	FXMLLoader myLoader = new FXMLLoader(getClass().getResource("Annotations.fxml"));
	Scene scene = new Scene(myPane);
	stage.setScene(scene);
	
	
	if(e.getSource() == nextButton){//TODO verifies that user entered an actual email
		//TODO goes to another window with the security questions
		
	}
	
}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
