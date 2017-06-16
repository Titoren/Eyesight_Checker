package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



/**
 * Created by richard on 02.06.17.
 */
public class GameMode1Controller {
    @FXML
    private Rectangle r1;

    @FXML
    void goToResult() {
//        r1.setFill(Color.AZURE);
        // TODO: 16.06.17 return
        Main.getMainController().switchToStage(Main.getMainController().getResultStage());
    }

    public Rectangle getR1() {
        return r1;
    }
}
