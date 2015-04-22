package applicationV2;

import backdoor_.Flags;
import javafx.fxml.FXML;

public class FlagController {

	private static Flags flag;
	@FXML
	void initialize() {
	}
	public static Flags getFlag() {
		return flag;
	}
	public static void setFlag(Flags flag) {
		FlagController.flag = flag;
	}


}
