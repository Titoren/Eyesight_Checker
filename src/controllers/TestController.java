package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

/**
 * Created by richard on 31.05.17.
 */
public class TestController {
    // TODO: 02.06.17  Replace this method
    @FXML
    void goReportPage() {
        Main.getMainController().switchToStage(Main.getMainController().getReportStage());
    }
}
