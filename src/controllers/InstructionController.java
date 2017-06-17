package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by richard on 31.05.17.
 */
public class InstructionController extends BasicController{
    @FXML
    void goToTest() {
        Main.getMainController().switchToStage(MainController.TEST_CONTAINER);
    }
}
