package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
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

    @FXML
    private Label lblTask;

    private List<Rectangle> rectangles;

    private List<Color> colors;

    private Integer totalTargetRects;

    private Integer totalCorrectAnswers;

    private Integer selectedRectsCount;

    private Integer colorId;

    private Color targetColor;

    String[] colorName = {"blue", "red", "green"};

    @FXML
    void refresh() throws IOException {
        Main.getMainController().externalInitGameModeOneStage();
        Main.getMainController().switchToStage(MainController.GAME_MODE_ONE_CONTAINER);
    }

    @FXML
    void goToResult() throws IOException {
        if (totalTargetRects.equals(totalCorrectAnswers) && totalTargetRects.equals(selectedRectsCount)) {
            Main.getMainController().switchToStage(MainController.RESULT_CONTAINER);
            Main.getMainController().externalInitGameModeOneStage();
            ((ResultController)Main.getMainController().getControlContainers().
                    get(MainController.RESULT_CONTAINER).getController()).getLblResult().
                    setText("Level complete!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("");
            alert.setHeaderText(null);
            alert.setContentText("Look for the other " + colorName[colorId] + " squares, please!");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize() {
        totalCorrectAnswers = 0;
        totalTargetRects = 0;
        selectedRectsCount = 0;
        rectangles = new ArrayList<>();
        colors = new ArrayList<>();
        addColors();
        targetColor = (Color) getRandomColor(colors);

        colorId = (targetColor == Color.BLUE) ? 0 : (targetColor == Color.RED) ? 1 : 2;

        lblTask.setText("Choose " + colorName[colorId] + " squares");

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                Rectangle rect = new Rectangle(0, 0, 72, 72);
                rect.setFill(getRandomColor(colors));
                if ((Color) rect.getFill() == targetColor) {
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
                        if (color == targetColor)
                            totalCorrectAnswers++;
                        rectangle.setStroke(Color.AZURE);
                        selectedRectsCount++;
                    } else {
                        if (color == targetColor)
                            totalCorrectAnswers--;
                        rectangle.setStroke(Color.BLACK);
                        selectedRectsCount--;
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

    public Label getLblTask() {
        return lblTask;
    }
}
