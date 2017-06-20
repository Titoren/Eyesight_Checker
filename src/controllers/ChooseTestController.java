package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;

import java.io.IOException;

/**
 * Created by richard on 18.06.17.
 */
public class ChooseTestController extends BasicController{
    @FXML
    void goToTest() throws IOException {
        Main.getMainController().externalInitTestStage();
        Main.getMainController().switchToStage(MainController.TEST_CONTAINER);
    }

    @FXML
    void goToTestOne() throws IOException {
        // TODO: 18.06.17 Call external init is duplicated (Check)
//        Main.getMainController().externalInitGameModeTwoStage();
        Main.getMainController().switchToStage(MainController.TEST_ONE_CONTAINER);
    }
}
