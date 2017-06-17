package controllers;

import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 * Created by richard on 16.06.17.
 */
public class ControlContainer {
    private Parent parent;
    private Stage stage;
    private BasicController controller;

    public ControlContainer() {
    }

    public ControlContainer(Parent parent, Stage stage, BasicController controller) {
        this.parent = parent;
        this.stage = stage;
        this.controller = controller;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public BasicController getController() {
        return controller;
    }

    public void setController(BasicController controller) {
        this.controller = controller;
    }
}
