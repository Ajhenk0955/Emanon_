package applicationV2;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;

public class Main extends Application {
	
	@Override
	// needs a throw
	public void start(Stage primaryStage) throws IOException {
		
		// loads the login FXML
		Parent root = FXMLLoader.load(getClass().getResource(
				"/applicationV2/Login.fxml"));

		Scene scene = new Scene(root); // creates scene
		primaryStage.setScene(scene); // sets scene
		primaryStage.setTitle("Welcome! Please Login");

		// only need to insert picture here
		primaryStage.getIcons().add(
				new Image("file:resources/images/medical_record_logo.png"));
		primaryStage.show(); // show end product
	}

	public static void main(String[] args) {
		launch(args);
	}
}
