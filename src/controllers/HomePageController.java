package controllers;

import javafx.fxml.FXML;
import eyesightChecker.Main;

/**
 * Created by richard on 21.05.17.
 */
public class HomePageController {
    @FXML
    void goToUserInfoStage() {
        Main.getMainController().switchToStage(Main.getMainController().getUserInfoStage());
    }
}
