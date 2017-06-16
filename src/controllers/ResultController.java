package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 02.06.17.
 */

public class ResultController {
    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(Main.getMainController().getHomePageStage());
    }

    // TODO: 11.06.17  Add link to mode 2 & 3
    @FXML
    void goToGameMode1() {
        Main.getMainController().switchToStage(Main.getMainController().getGameMode1Stage());
    }

    @FXML
    void goToChooseModeStage() {
        Main.getMainController().switchToStage(Main.getMainController().getChooseModeStage());
    }
}
