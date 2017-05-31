package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 24.05.17.
 */
public class UserInfoController {
    @FXML
    void goToInstruction() {
        Main.getMainController().switchToStage(Main.getMainController().getInstructionStage());
    }
}
