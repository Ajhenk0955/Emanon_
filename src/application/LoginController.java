package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;


public class LoginController implements Initializable{

	@FXML
	private TextField login_Username;
	@FXML
	private PasswordField login_Password;
	@FXML
	private Label login_Label;
	/**
	 * logs the user into the system
	 * TODO -> must set up database methods and call
	 * @param button_Click
	 */
	@FXML
	private void login_Button_Action(ActionEvent button_Click){
		if(login_Username.getText().equals("test") && login_Password.getText().equals("test")){
			login_Label.setText("Yay");
		} else{
			login_Label.setText("Nay");
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
