package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import controllers.MainController;

public class Main extends Application {

//    @Override
//    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("Eyesight Checker");
//        primaryStage.setScene(new Scene(root));
//        primaryStage.show();
//    }
    private static MainController mainController;

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
}
