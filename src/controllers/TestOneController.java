package controllers;

import eyesightChecker.Main;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * Created by richard on 18.06.17.
 */
public class TestOneController extends BasicController {
    private List<Label> labels;
    private int rowQuantity = 3;
    private int colQuantity = 4;
    private int index;

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
        int randomNum;

        for (int i = 0; i < rowQuantity; i++) {
            gpTest.addRow(i);
            for (int j = 0; j < colQuantity; j++) {
                randomNum = ThreadLocalRandom.current().nextInt(65, 90 + 1);

                gpTest.addColumn(i);
                index = ((j + 1) + i * (colQuantity) - 1);
                labels.add(new Label("" + (char) (randomNum)));//(index + 1)));
//                labels.get(index).setStyle("-fx-text-fill: blueviolet;");

                labels.get(index).setTextFill(Color.BLACK);
                labels.get(index).setFont(Font.font("Arial", 15));

                gpTest.add(labels.get(index), j, i);
            }
        }

        for (Node n : gpTest.getChildren()) {
            if (n instanceof Control) {
                Control control = (Control) n;
                control.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                control.setStyle("-fx-background-color: white; -fx-alignment: center;");
            }
            if (n instanceof Pane) {
                Pane pane = (Pane) n;
                pane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                pane.setStyle("-fx-background-color: white; -fx-alignment: center;");
            }
        }

        gpTest.setStyle("-fx-background-color: black; -fx-padding: 2; -fx-hgap: 1; -fx-vgap: 1;");
        // turn layout pixel snapping off on the grid so that grid lines will be an even width.
        gpTest.setSnapToPixel(false);

        // TODO: 20.06.17 Add leveling
        ColumnConstraints oneThird = new ColumnConstraints();
        oneThird.setPercentWidth(100 / (0.0 + colQuantity));
        oneThird.setHalignment(HPos.CENTER);
        for (int i = 0; i < colQuantity - 1; i++)
            gpTest.getColumnConstraints().addAll(oneThird);

        RowConstraints oneHalf = new RowConstraints();
        oneHalf.setPercentHeight(100 / (0.0 + rowQuantity));
        oneHalf.setValignment(VPos.CENTER);
        for (int i = 0; i < rowQuantity - 1; i++)
            gpTest.getRowConstraints().addAll(oneHalf);

//        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
//        ses.scheduleWithFixedDelay(() -> Platform.runLater(this::update),
//                0, 1000, TimeUnit.MILLISECONDS);
    }

    @FXML
    void update() {
        // TODO: 20.06.17 fix not linked labels
        int randomNum;
        for (int i = 0; i < rowQuantity; i++) {
            for (int j = 0; j < colQuantity; j++) {
                randomNum = ThreadLocalRandom.current().nextInt(65, 90 + 1);
                index = ((j + 1) + i * (colQuantity) - 1);
                labels.get(index).setText("" + (char) (ThreadLocalRandom.current().nextInt(65, 90 + 1)));
//                labels.get(index).setStyle("-fx-text-fill: blueviolet;");
//                gpTest.add(labels.get(index), j, i);
            }
        }
        for (Node n : gpTest.getChildren()) {
            if (n instanceof Label) {
                Label label = (Label) n;
                ((Label) n).setText("" + (char)ThreadLocalRandom.current().nextInt(65, 90 + 1));
            }
        }
    }
}
