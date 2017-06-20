package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
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

    @FXML
    void initialize() {
        labels = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            gpTest.addRow(i);
            for (int j = 0; j < 4; j++) {
                gpTest.addColumn(j);
                addLabel(new Label("R"), j, i);
            }
        }

        for (Node n : gpTest.getChildren()) {
            if (n instanceof Control) {
                Control control = (Control) n;
                control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                control.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;");
            }
            if (n instanceof Pane) {
                Pane pane = (Pane) n;
                pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                pane.setStyle("-fx-background-color: cornsilk; -fx-alignment: center;");
            }
        }

        gpTest.setStyle("-fx-background-color: #605baf; -fx-padding: 2; -fx-hgap: 2; -fx-vgap: 2;");
        // turn layout pixel snapping off on the grid so that grid lines will be an even width.
        gpTest.setSnapToPixel(false);


        ColumnConstraints oneThird = new ColumnConstraints();
        oneThird.setPercentWidth(100 / 4.0);
        oneThird.setHalignment(HPos.CENTER);
        gpTest.getColumnConstraints().addAll(oneThird, oneThird, oneThird);
        RowConstraints oneHalf = new RowConstraints();
        oneHalf.setPercentHeight(100 / 3.0);
        oneHalf.setValignment(VPos.CENTER);
        gpTest.getRowConstraints().addAll(oneHalf, oneHalf);
    }

    private void addLabel(Label label, int colIndex, int rowIndex) {
        gpTest.setHalignment(label, HPos.CENTER);
        gpTest.setValignment(label, VPos.CENTER);
        gpTest.add(label, colIndex, rowIndex);
    }

    private void addButton(Button button, int colIndex, int rowIndex) {
        gpTest.setHalignment(button, HPos.CENTER);
        gpTest.setValignment(button, VPos.CENTER);
        gpTest.add(button, colIndex, rowIndex);
    }
}
