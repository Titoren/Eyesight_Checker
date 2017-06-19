package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by richard on 18.06.17.
 */
public class TestOneController extends BasicController {
    private List<Rectangle> labels;

    @FXML
    private GridPane gpTest;

    @FXML
    void goToReportStage() throws IOException {
        Main.getMainController().externalInitReportStage();
        Main.getMainController().switchToStage(MainController.REPORT_CONTAINER);
    }


//    @FXML
//    void initialize() {
//        labels = new ArrayList<>();
//
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 3; j++) {
//                Label label = new Label("T");
////                rect.setFill(getRandomColor(colors));
////
////                rect.setStroke(Color.BLACK);
////                rectangles.add(rect);
//                addLabel(label, i, j);
////                rect.setOnMousePressed(event -> {
////                    System.out.println("mouse click detected! " + event.getSource());
////                    Rectangle rectangle = (Rectangle) event.getSource();
////
////                });
//            }
//        }
//
//    }

    private void addLabel(Label label, int colIndex, int rowIndex) {
        gpTest.add(label, colIndex, rowIndex);
//        gpTest.setHalignment(label, HPos.CENTER);
    }

    public GridPane getGpTest() {
        return gpTest;
    }
}
