package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 01.06.17.
 */
public class ChooseModeController {
    @FXML
    void goToGameMode1() {
        Main.getMainController().switchToStage(Main.getMainController().getGameMode1Stage());
    }
}
