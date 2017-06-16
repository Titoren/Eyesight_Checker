package controllers;

import eyesightChecker.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by richard on 02.06.17.
 */

public class ResultController {
    @FXML
    private GridPane gpResult;

    @FXML
    private Rectangle rect = new Rectangle(20,20,200,200);

    @FXML
    void goToHomePage() {
        Main.getMainController().switchToStage(Main.getMainController().getHomePageStage());
    }

    // TODO: 11.06.17  Add link to mode 2 & 3
    @FXML
    void goToGameMode1() {
        Main.getMainController().switchToStage(Main.getMainController().getGameMode1Stage());
    }

    @FXML
    void goToChooseModeStage() {

        rect.setOnMousePressed(event -> System.out.println("mouse click detected! "+event.getSource()));

        rect.setFill(Color.AQUA);

        rect.setStroke(Color.BLACK);
        gpResult.getChildren().add(rect);
//        Main.getMainController().switchToStage(Main.getMainController().getChooseModeStage());
    }

    public GridPane getGpResult() {
        return gpResult;
    }

    public Rectangle getRect() {
        return rect;
    }
}
