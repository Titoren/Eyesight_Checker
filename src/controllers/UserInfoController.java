package controllers;

import eyesightChecker.Main;
import eyesightChecker.UserDataExeption;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import java.util.regex.Pattern;

/**
 * Created by richard on 24.05.17.
 */
public class UserInfoController extends BasicController {
    private Pattern pattern = Pattern.compile("^([A-Za-zЇ-ї])([A-Za-zЇ-ї'ʼ`])+([A-Za-zЇ-ї])$");
//    private Pattern pattern = Pattern.compile("^([A-ZЇ-Я])([a-zа-ї'ʼ`])+$");


    @FXML
    private TextField tfName;

    @FXML
    private TextField tfSurname;

    @FXML
    private TextField tfAge;

    @FXML
    void goToInstruction() throws UserDataExeption {
        String messageError = "information";

        try {
            if (pattern.matcher(tfName.getText()).matches()  &&
                    isSymbolsOccurrenceOnce(tfName.getText())) {
                Main.getCurrentUser().setName(toCorrectString(tfName.getText()));
            } else {
                messageError = "name";
                throw new UserDataExeption();
            }

            if (pattern.matcher(tfSurname.getText()).matches() &&
                    isSymbolsOccurrenceOnce(tfSurname.getText())) {
                Main.getCurrentUser().setSurname(toCorrectString(tfSurname.getText()));
            } else {
                messageError = "surname";
                throw new UserDataExeption();
            }

            if (Integer.parseInt(tfAge.getText()) >= 5 && Integer.parseInt(tfAge.getText()) <= 100) {
                Main.getCurrentUser().setAge(Integer.parseInt(tfAge.getText()));
            } else {
                messageError = "age";
                throw new UserDataExeption();
            }
            Main.getCurrentUser().setAnswerCount(0);
            Main.getCurrentUser().setRightAnswerCount(0);

            tfName.setText("");
            tfSurname.setText("");
            tfAge.setText("");

            Main.getMainController().switchToStage(MainController.INSTRUCTION_CONTAINER);
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please, write correct " + messageError + "!");
            alert.showAndWait();
        }
    }

    private String toCorrectString(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }

    private boolean isSymbolsOccurrenceOnce(String text) {
        String string = "";
        String symbols = "'ʼ`-";
        for (int i = 0; i < symbols.length(); i++) {
            string = text.replace(symbols.substring(i, i + 1), "");
        }
        return (text.length() - string.length()) <= 1;
    }
}
