package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.*;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


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
	private void login_Button_Action(ActionEvent button_Click) throws Exception{
		if(login_Username.getText().equals("test") && login_Password.getText().equals("test")){
			((Node) (button_Click.getSource())).getScene().getWindow().hide();
			Parent parent = FXMLLoader.load(getClass().getResource("/application/MainMenu.fxml"));
			Stage stage = new Stage();
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.setTitle("MainMenu");
			stage.getIcons().add(new Image("file:resources/images/medical_record_logo.png"));
			stage.show();
		} else{
			login_Label.setText("Nay");
		}
	}
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub potentially add security initialization here
		
	}

}
