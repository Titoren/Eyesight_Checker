package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 31.05.17.
 */
public class InstructionController {
    @FXML
    void goToTest() {
        Main.getMainController().switchToStage(Main.getMainController().getTestStage());
    }
}
