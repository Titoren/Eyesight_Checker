package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 08.06.17.
 */
public class ReportController {
    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(Main.getMainController().getHomePageStage());
    }
}
