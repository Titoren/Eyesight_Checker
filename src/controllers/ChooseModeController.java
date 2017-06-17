package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 01.06.17.
 */
public class ChooseModeController extends BasicController {
    @FXML
    void goToGameMode1() {
        Main.getMainController().switchToStage(MainController.GAME_MODE_ONE_CONTAINER);
    }
}
