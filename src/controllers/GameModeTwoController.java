package controllers;

import eyesightChecker.Main;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Random;

/**
 * Created by richard on 19.06.17.
 */
public class GameModeTwoController extends BasicController {
    private static Duration TRANSLATE_DURATION = Duration.seconds(0.3);

    @FXML
    private GridPane gpGameModeTwo;

    @FXML
    private Circle circle;

    @FXML
    void goToResult() throws IOException {
        Main.getMainController().switchToStage(MainController.RESULT_CONTAINER);
        // TODO: 19.06.17 Add extInit
//        Main.getMainController().externalInitGameModeOneStage();
//        ((ResultController) Main.getMainController().getControlContainers().
//                get(MainController.RESULT_CONTAINER).getController()).getLblResult().
//                setText("     Game mode one\ncomplete  successfully!");

    }

    @FXML
    void initialize() {
        moveCircleOnMousePress(circle, createTranslateTransition(circle));
    }

    private TranslateTransition createTranslateTransition(Circle circle) {
        TranslateTransition transition = new TranslateTransition(TRANSLATE_DURATION, circle);
        transition.setOnFinished(t -> {
            circle.setCenterX(circle.getTranslateX() + circle.getCenterX());
            circle.setCenterY(circle.getTranslateY() + circle.getCenterY());

        });
        return transition;
    }

    private void moveCircleOnMousePress(Circle circle, TranslateTransition transition) {
        circle.setOnMouseMoved(event -> {
            circle.setRadius(circle.getRadius() - 0.05);
            transition.setToX(new Random().nextInt(150) - circle.getCenterX());
            transition.setToY(new Random().nextInt(150) - circle.getCenterY());
            transition.playFromStart();
            if (circle.getRadius() < 5) {
                try {
                    goToResult();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Circle getCircle() {
        return circle;
    }

    public GridPane getGpGameModeTwo() {
        return gpGameModeTwo;
    }
}
