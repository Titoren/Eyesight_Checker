package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by richard on 02.06.17.
 */
public class GameMode1Controller extends BasicController{
    @FXML
    private GridPane gpGameMode1;

    private List<Rectangle> rectangles;

    private List<Color> colors;

    private Integer totalTargetRects;

    private Integer totalCorrectAnswers;

    @FXML
    void refresh() throws IOException {
        Main.getMainController().externalInitGameModeOneStage();
    }

    @FXML
    void goToResult() throws IOException {
        if (totalTargetRects.equals(totalCorrectAnswers)) {
            Main.getMainController().switchToStage(MainController.RESULT_CONTAINER);
            Main.getMainController().externalInitGameModeOneStage();
            ((ResultController)Main.getMainController().getControlContainers().
                    get(MainController.RESULT_CONTAINER).getController()).getLblResult().
                    setText("     Game mode one\ncomplete  successfully!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Look for the other red squares, please!");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        totalCorrectAnswers = 0;
        totalTargetRects = 0;
        rectangles = new ArrayList<>();
        colors = new ArrayList<>();
        addColors();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                Rectangle rect = new Rectangle(0, 0, 72, 72);
                rect.setFill(getRandomColor(colors));
                if ((Color) rect.getFill() == Color.RED) {
                    totalTargetRects++;
                }

                rect.setStroke(Color.BLACK);
                rectangles.add(rect);
                addRect(rect, i, j);
                rect.setOnMousePressed(event -> {
                    System.out.println("mouse click detected! " + event.getSource());
                    Rectangle rectangle = (Rectangle) event.getSource();
                    Color color = (Color) rectangle.getFill();
                    if(rect.getStroke() != Color.AZURE) {
                        if (color == Color.RED)
                            totalCorrectAnswers++;
                        rectangle.setStroke(Color.AZURE);
                    } else {
                        if (color == Color.RED)
                            totalCorrectAnswers--;
                        rectangle.setStroke(Color.BLACK);
                    }
                });
            }
        }
    }

    private Paint getRandomColor(List<Color> colors) {
        return colors.get(new Random().nextInt(3));
    }

    private void addColors() {
        colors.add(Color.BLUE);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
    }

    private void addRect(Rectangle rect, int colIndex, int rowIndex) {
        gpGameMode1.add(rect, colIndex, rowIndex);
        gpGameMode1.setHalignment(rect, HPos.CENTER);
    }

    public GridPane getGpGameMode1() {
        return gpGameMode1;
    }

    public List<Rectangle> getRectangles() {
        return rectangles;
    }
}
