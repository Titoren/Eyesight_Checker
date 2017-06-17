package controllers;

import javafx.fxml.FXML;
import eyesightChecker.Main;

/**
 * Created by richard on 21.05.17.
 */
public class HomePageController extends BasicController{
    @FXML
    void goToUserInfoStage() {
        Main.getMainController().switchToStage(MainController.INFO_CONTAINER);
    }

    @FXML
    void goToChooseModeStage() {
        Main.getMainController().switchToStage(MainController.CHOOSE_MODE_CONTAINER);
    }
}
