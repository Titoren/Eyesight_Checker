package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainController {

    private Stage homePageStage;

    private Parent homePageParent;

    public Parent getHomePageParent() {
        return homePageParent;
    }

    public void setHomePageParent(Parent homePageParent) {
        this.homePageParent = homePageParent;
    }
    //    private Stage registrationStage;
//
//    private Parent registrationParent;

    private Stage fridgeControlStage;

    private Parent fridgeControlParent;//todo

    public MainController(Stage primaryStage) throws Exception {
//        fridgeControlParent = FXMLLoader.load((getClass().getResource("/view/control.fxml")));
//        fridgeControlStage = new Stage();
//        fridgeControlStage.setScene(new Scene(fridgeControlParent));
//        fridgeControlStage.setTitle("SmartFridge Control Panel");


//        registrationParent = FXMLLoader.load((getClass().getResource("/view/register.fxml")));
//        registrationStage = new Stage();
//        registrationStage.setScene(new Scene(registrationParent));
//        registrationStage.setTitle("SmartFridge Control Panel");

        homePageParent = FXMLLoader.load(getClass().getResource("/view/sample.fxml"));
        primaryStage.setTitle("Eyesight checker");
        primaryStage.setScene(new Scene(homePageParent));
        homePageStage = primaryStage;
        primaryStage.show();
    }

    public Stage getHomePageStage() {
        return homePageStage;
    }

    public void setHomePageStage(Stage homePageStage) {
        this.homePageStage = homePageStage;
    }
}
