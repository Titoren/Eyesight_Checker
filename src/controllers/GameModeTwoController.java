package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * Created by richard on 19.06.17.
 */
public class GameModeTwoController extends BasicController {
    @FXML
    private Circle circle;

    @FXML
    void goToResult() throws IOException {
        Main.getMainController().switchToStage(MainController.RESULT_CONTAINER);
//        Main.getMainController().externalInitGameModeOneStage();
//        ((ResultController) Main.getMainController().getControlContainers().
//                get(MainController.RESULT_CONTAINER).getController()).getLblResult().
//                setText("     Game mode one\ncomplete  successfully!");

    }

    @FXML
    void moveCircle() {
        circle.setRadius(circle.getRadius() - 0.2);
        circle.setLayoutX(77);
        circle.setLayoutY(200);
        circle.relocate(77,88);
    }

    public Circle getCircle() {
        return circle;
    }
}
