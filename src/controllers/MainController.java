package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    private Stage currentStage;


    private Stage homePageStage;
    private Parent homePageParent;

    private Stage userInfoStage;
    private Parent userInfoParent;

    private Stage instructionStage;
    private Parent instructionParent;

//    private Stage ...Stage;
//    private Parent ...Parent;

    public MainController(Stage primaryStage) throws Exception {

        userInfoParent = FXMLLoader.load((getClass().getResource("/view/userInfo.fxml")));
        userInfoStage = new Stage();
        userInfoStage.setScene(new Scene(userInfoParent));
        userInfoStage.setTitle("User Info");

        instructionParent = FXMLLoader.load((getClass().getResource("/view/instruction.fxml")));
        instructionStage = new Stage();
        instructionStage.setScene(new Scene(instructionParent));
        instructionStage.setTitle("Instruction");

//        registrationParent = FXMLLoader.load((getClass().getResource("/view/register.fxml")));
//        registrationStage = new Stage();
//        registrationStage.setScene(new Scene(registrationParent));
//        registrationStage.setTitle("SmartFridge Control Panel");



        homePageParent = FXMLLoader.load(getClass().getResource("/view/homePage.fxml"));
        primaryStage.setTitle("Eyesight checker");
        primaryStage.setScene(new Scene(homePageParent));
        homePageStage = primaryStage;
        currentStage = primaryStage;
        primaryStage.show();
    }

    public void switchToStage(Stage newStage) {
        currentStage.hide();
        currentStage = newStage;
        currentStage.show();
    }

    public Stage getHomePageStage() {
        return homePageStage;
    }

    public void setHomePageStage(Stage homePageStage) {
        this.homePageStage = homePageStage;
    }

    public Parent getHomePageParent() {
        return homePageParent;
    }

    public void setHomePageParent(Parent homePageParent) {
        this.homePageParent = homePageParent;
    }

    public Stage getUserInfoStage() {
        return userInfoStage;
    }

    public void setUserInfoStage(Stage userInfoStage) {
        this.userInfoStage = userInfoStage;
    }

    public Stage getInstructionStage() {
        return instructionStage;
    }

    public void setInstructionStage(Stage instructionStage) {
        this.instructionStage = instructionStage;
    }

    public Parent getInstructionParent() {
        return instructionParent;
    }
    public void setInstructionParent(Parent instructionParent) {
        this.instructionParent = instructionParent;
    }

    public Parent getUserInfoParent() {
        return userInfoParent;
    }

    public void setUserInfoParent(Parent userInfoParent) {
        this.userInfoParent = userInfoParent;
    }
}
