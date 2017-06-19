package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * Created by richard on 19.06.17.
 */
public class GameModeTwoController extends BasicController {
    @FXML
    private GridPane gpGameModeTwo;

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
        circle.setLayoutX(200);
        circle.setLayoutX(250);
//        circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
//        circle.setCenterY(circle.getTranslateY() + circle.getCenterY());
//        circle.setTranslateX(0);
//        circle.setTranslateY(0);
        circle.setCenterY(225);
        circle.setCenterX(115);
    }

    public Circle getCircle() {
        return circle;
    }

    public GridPane getGpGameModeTwo() {
        return gpGameModeTwo;
    }
}
