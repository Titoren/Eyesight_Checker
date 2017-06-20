package controllers;

import javafx.fxml.FXML;
import eyesightChecker.Main;

import java.io.IOException;

/**
 * Created by richard on 21.05.17.
 */
public class HomePageController extends BasicController{
    @FXML
    void goToUserInfoStage() {
        Main.getMainController().switchToStage(MainController.INFO_CONTAINER);
    }

    // TODO: 20.06.17 return action
    @FXML
    void goToTestOne() throws IOException {
        // TODO: 18.06.17 Call external init
//        Main.getMainController().externalInitTestStage();
        Main.getMainController().switchToStage(MainController.TEST_ONE_CONTAINER);
    }

    @FXML
    void goToChooseModeStage() {
        Main.getMainController().switchToStage(MainController.CHOOSE_MODE_CONTAINER);
    }
}
