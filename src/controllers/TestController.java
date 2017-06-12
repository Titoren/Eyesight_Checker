package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Created by richard on 31.05.17.
 */
public class TestController {
    // TODO: 02.06.17  Replace this method
    @FXML
    void goToReportStage() {
        Main.getMainController().switchToStage(Main.getMainController().getReportStage());
    }

    @FXML
    private Label positionLabel ;

    public void setText(String text) {
        positionLabel.setText(text);
    }
}
