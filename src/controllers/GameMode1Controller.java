package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 02.06.17.
 */
public class GameMode1Controller {
    @FXML
    void goToResult() {
        Main.getMainController().switchToStage(Main.getMainController().getResultStage());
    }
}
