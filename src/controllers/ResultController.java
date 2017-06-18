package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by richard on 02.06.17.
 */

public class ResultController extends BasicController {
    @FXML
    private Label lblResult;

    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(MainController.HOME_PAGE_CONTAINER);
    }

    // TODO: 11.06.17  Add link to mode 2 & 3
    @FXML
    void goToGameMode1() {
        Main.getMainController().switchToStage(MainController.GAME_MODE_ONE_CONTAINER);
    }

    @FXML
    void goToChooseModeStage() {
        Main.getMainController().switchToStage(MainController.CHOOSE_MODE_CONTAINER);
    }

    public Label getLblResult() {
        return lblResult;
    }
}
