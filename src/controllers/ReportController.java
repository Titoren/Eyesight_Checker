package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by richard on 08.06.17.
 */
public class ReportController extends BasicController{
    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(MainController.HOME_PAGE_CONTAINER);
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
