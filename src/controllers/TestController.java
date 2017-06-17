package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Random;

/**
 * Created by richard on 31.05.17.
 */
public class TestController extends BasicController {
    private String[] letters = {
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
        Main.getMainController().switchToStage(MainController.REPORT_CONTAINER);
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

        Main.getCurrentUser().setAnswerCount(Main.getCurrentUser().getAnswerCount() + 1);
        Main.getCurrentUser().setRightAnswerCount(Main.getCurrentUser().getRightAnswerCount() + (answer ? 1 : 0));

        // TODO: 16.06.17 Check how it works
        if (Main.getCurrentUser().getRightAnswerCount() == 2 || vPosition >= 1 &&
                ((Main.getCurrentUser().getRightAnswerCount() - 2) % 3 == 0))
            vPosition++;

        hPosition = new Random().nextInt(letters[vPosition].length()); //update coordinates for next letter
        positionLabel.setText("Write letter from " + (vPosition + 1) +
                " row and " + (hPosition + 1) + " column ");

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
