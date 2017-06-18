package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by richard on 18.06.17.
 */
public class TestOneController extends BasicController {
    @FXML
    void goToReportStage() throws IOException {
        Main.getMainController().externalInitReportStage();
        Main.getMainController().switchToStage(MainController.REPORT_CONTAINER);
    }
}
