package controllers;

import eyesightChecker.Main;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.util.Random;

/**
 * Created by richard on 31.05.17.
 */
public class TestController extends BasicController {
    private String[] letters = {
            "fp",
            "toz",
            "lped",
            "pecfd",
            "edfczp",
            "felopzd",
            "defpotec",
            "lefodpct",
            "fdpltceo",
            "pezolcftd"
    };

    private String[] lettersRu = {
            "шб",
            "мнк",
            "ымбш",
            "бынкм",
            "иншмк",
            "ншыикб",
            "шинбкы",
            "кншмыби",
            "бкшмиын",
            "нкибмшыб"
    };

    private int vPosition = 0;
    private int hPosition = new Random().nextInt(2);

    @FXML
    void goToReportStage() {
        try {
            Main.getMainController().externalInitReportStage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ((ReportController)Main.getMainController().getControlContainers().
                get(MainController.REPORT_CONTAINER).getController()).getLblAdvise().setText(
                        ("You stopped test on " + (vPosition + 1) +
                " row, the result may not be accurate.")
        );

        Main.getMainController().switchToStage(MainController.REPORT_CONTAINER);
    }

    @FXML
    void checkCharOnEnter() {
        Scene scene = Main.getMainController().getControlContainers().
                get(MainController.TEST_CONTAINER).getStage().getScene();
        scene.setOnKeyPressed(keyEvent -> {
            if (keyEvent.getCode() == KeyCode.ENTER)  {
                checkLetter();
            }
        });
    }

    @FXML
    private TextField tfCompare;

    @FXML
    private Label positionLabel;

    @FXML
    private Label lblDebug;

//    @FXML
//    public void initialize() {
//        positionLabel.setText(Main.getCurrentUser().getName());
//    }

    @FXML
    public void checkLetter() {
        boolean answer = letters[vPosition].substring(hPosition, hPosition + 1).equalsIgnoreCase(getTfCompare().getText());
        lblDebug.setText("" + answer);
        lblDebug.textFillProperty().set((answer) ? Color.LIMEGREEN : Color.RED);

        Main.getCurrentUser().setAnswerCount(Main.getCurrentUser().getAnswerCount() + 1);
        Main.getCurrentUser().setRightAnswerCount(Main.getCurrentUser().getRightAnswerCount() + (answer ? 1 : 0));

        if ((Main.getCurrentUser().getAnswerCount() -
                Main.getCurrentUser().getRightAnswerCount()) >= 5) {
            Main.getCurrentUser().setProblemTableRow(vPosition + 1);
            goToReportStage();
        }

        if ((Main.getCurrentUser().getRightAnswerCount() == 2 || vPosition >= 1) &&
                ((Main.getCurrentUser().getRightAnswerCount() - 2) % 3 == 0) && answer) {
            vPosition++;

        }

        if (!(vPosition >= 10)) {
            hPosition = new Random().nextInt(letters[vPosition].length()); //update coordinates for next letter
            positionLabel.setText("Write letter from " + (vPosition + 1) +
                    " row and " + (hPosition + 1) + " column ");
        } else {
            goToReportStage();
        }

        tfCompare.setText("");
    }

    public Label getPositionLabel() {
        return positionLabel;
    }

    public Label getLblDebug() {
        return lblDebug;
    }

    public TextField getTfCompare() {
        return tfCompare;
    }

    public int getVPosition() {
        return vPosition;
    }

    public void setVPosition(int vPosition) {
        this.vPosition = vPosition;
    }

    public int getHPosition() {
        return hPosition;
    }

    public void setHPosition(int hPosition) {
        this.hPosition = hPosition;
    }
}
