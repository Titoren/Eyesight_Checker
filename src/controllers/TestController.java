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
public class TestController {
    private String[] letters = {
            "шб" ,
            "мнк" ,
            "ымбш" ,
            "бынкм" ,
            "иншмк" ,
            "ншыикб" ,
            "шинбкы" ,
            "кншмыби" ,
            "бкшмиын" ,
            "нкибмшыб"
    };

    private int vPosition = 0;
    private int hPosition = new Random().nextInt(2);

    @FXML
    void goToReportStage() {
        try {
            Main.getMainController().initReportStage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Main.getMainController().switchToStage(Main.getMainController().getReportStage());

        tfCompare.setText("");
    }

    @FXML
    private TextField tfCompare;

    @FXML
    private Label positionLabel;

    @FXML
    private Label lblDebug;

//    @FXML
//    public void setText() {
//        positionLabel.setText("text");
//    }

//    @FXML
//    public void initialize() {
//        positionLabel.setText(Main.getCurrentUser().getName());
//    }

    @FXML
    public void checkLetter() {
        boolean answer = letters[hPosition].substring(vPosition, 1).equalsIgnoreCase(getTfCompare().getText());
        lblDebug.setText("" + answer);

        Main.getCurrentUser().setAnswerCount(Main.getCurrentUser().getAnswerCount() + 1);
        Main.getCurrentUser().setRightAnswerCount(Main.getCurrentUser().getRightAnswerCount() + (answer ? 1 : 0));
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

    public int getvPosition() {
        return vPosition;
    }

    public void setvPosition(int vPosition) {
        this.vPosition = vPosition;
    }

    public int gethPosition() {
        return hPosition;
    }

    public void sethPosition(int hPosition) {
        this.hPosition = hPosition;
    }
}
