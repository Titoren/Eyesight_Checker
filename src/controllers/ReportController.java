package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by richard on 08.06.17.
 */
public class ReportController {
    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(Main.getMainController().getHomePageStage());
    }

    @FXML
    private Label lblReportText;



    public Label getLblReportText() {
        return lblReportText;
    }

    public void setLblReportText(Label lblReportText) {
        this.lblReportText = lblReportText;
    }
}
