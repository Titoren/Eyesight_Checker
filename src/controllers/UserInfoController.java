package controllers;

import eyesightChecker.Main;
import eyesightChecker.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Created by richard on 24.05.17.
 */
public class UserInfoController {

    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    @FXML
    private TextField tfAge;

    @FXML
    void goToInstruction() {
        try {
            Main.getCurrentUser().setName(tfName.getText());
            Main.getCurrentUser().setSurname(tfSurname.getText());
            Main.getCurrentUser().setAge(Integer.parseInt(tfAge.getText()));
            Main.getCurrentUser().setAnswerCount(0);
            Main.getCurrentUser().setRightAnswerCount(0);

            Main.getMainController().switchToStage(Main.getMainController().getInstructionStage());
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please, write correct information!");
            alert.showAndWait();
        }

        // TODO: 13.06.17 redo

        tfName.setText("");
        tfSurname.setText("");
        tfAge.setText("");
    }
}
