package eyesightChecker;

import javafx.application.Application;
import javafx.stage.Stage;
import controllers.MainController;

public class Main extends Application {

    private static MainController mainController;
    private static User currentUser = new User(); // TODO: 13.06.17 redo

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainController = new MainController(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static MainController getMainController() {
        return mainController;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        Main.currentUser = currentUser;
    }
}
