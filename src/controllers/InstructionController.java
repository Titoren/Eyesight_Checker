package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by richard on 31.05.17.
 */
public class InstructionController {
    @FXML
    void goToTest() {
        try {
            Main.getMainController().initTestStage(); // TODO: 13.06.17 Question to Valentine
        } catch (IOException e) {
            e.printStackTrace();
        }
        Main.getMainController().switchToStage(Main.getMainController().getTestStage());
    }
}
