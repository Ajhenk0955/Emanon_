package applicationV2;

import java.net.URL;
import java.util.ResourceBundle;

import backdoor_.Flags;
import javafx.fxml.FXML;

public class FlagController {

	private static Flags flag;
	@FXML
	void initialize() {
		setFlag(new Flags());
	}
	public static Flags getFlag() {
		return flag;
	}
	public static void setFlag(Flags flag) {
		FlagController.flag = flag;
	}


}
