package application;

import java.io.ObjectInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

	// The security header
	public final Object clone() throws java.lang.CloneNotSupportedException {
		throw new java.lang.CloneNotSupportedException();
	}

	private final void readObject(ObjectInputStream in)
		throws java.io.IOException {
		throw new java.io.IOException("Class cannot be deserialized");
	}

	private boolean initiallized;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource(
				"/application/Login.fxml"));
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Welcome! Please Login");
		primaryStage.getIcons().add(new Image("file:resources/images/medical_record_logo.png"));
		primaryStage.show();
		//setInitiallized(true);
	}

	public static void main(String[] args) {
		launch(args);
	}

	public boolean isInitiallized() {
		return initiallized;
	}

	public void setInitiallized(boolean initiallized) {
	this.initiallized = initiallized;
	}
}
