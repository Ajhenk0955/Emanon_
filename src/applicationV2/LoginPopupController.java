package applicationV2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LoginPopupController implements Initializable{
@FXML
private Button nextButton;
	

@FXML
private void handleNextButton(ActionEvent e) throws IOException{
	if(e.getSource() == nextButton){//TODO verifies that user entered an actual email
		//TODO goes to another window with the security questions
		
	}
}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
