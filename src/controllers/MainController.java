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

    private Stage testStage;
    private Parent testParent;

    private Stage chooseModeStage;
    private Parent chooseModeParent;

    private Stage gameMode1Stage;
    private Parent gameMode1Parent;

    private Stage resultStage;
    private Parent resultParent;

    private Stage reportStage;
    private Parent reportParent;

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

        testParent = FXMLLoader.load((getClass().getResource("/view/test.fxml")));
        testStage = new Stage();
        testStage.setScene(new Scene(testParent));
        testStage.setTitle("Test");

        chooseModeParent = FXMLLoader.load((getClass().getResource("/view/chooseMode.fxml")));
        chooseModeStage = new Stage();
        chooseModeStage.setScene(new Scene(chooseModeParent));
        chooseModeStage.setTitle("Choose mode");

        gameMode1Parent = FXMLLoader.load((getClass().getResource("/view/gameMode1.fxml")));
        gameMode1Stage = new Stage();
        gameMode1Stage.setScene(new Scene(gameMode1Parent));
        gameMode1Stage.setTitle("Game mode 1");

        resultParent = FXMLLoader.load((getClass().getResource("/view/result.fxml")));
        resultStage = new Stage();
        resultStage.setScene(new Scene(resultParent));
        resultStage.setTitle("Result");

        reportParent = FXMLLoader.load((getClass().getResource("/view/report.fxml")));
        reportStage = new Stage();
        reportStage.setScene(new Scene(reportParent));
        reportStage.setTitle("Report");

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

//    public void switchToPrimaryStage(Stage primaryStage) {
//        currentStage.hide();
//        currentStage = primaryStage;
//        currentStage.show();
//    }

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

    public Stage getTestStage() {
        return testStage;
    }

    public void setTestStage(Stage testStage) {
        this.testStage = testStage;
    }

    public Parent getTestParent() {
        return testParent;
    }

    public void setTestParent(Parent testParent) {
        this.testParent = testParent;
    }

    public Stage getChooseModeStage() {
        return chooseModeStage;
    }

    public void setChooseModeStage(Stage chooseModeStage) {
        this.chooseModeStage = chooseModeStage;
    }

    public Parent getChooseModeParent() {
        return chooseModeParent;
    }

    public void setChooseModeParent(Parent chooseModeParent) {
        this.chooseModeParent = chooseModeParent;
    }

    public Stage getGameMode1Stage() {
        return gameMode1Stage;
    }

    public void setGameMode1Stage(Stage gameMode1Stage) {
        this.gameMode1Stage = gameMode1Stage;
    }

    public Parent getGameMode1Parent() {
        return gameMode1Parent;
    }

    public void setGameMode1Parent(Parent gameMode1Parent) {
        this.gameMode1Parent = gameMode1Parent;
    }

    public Stage getResultStage() {
        return resultStage;
    }

    public void setResultStage(Stage resultStage) {
        this.resultStage = resultStage;
    }

    public Parent getResultParent() {
        return resultParent;
    }

    public void setResultParent(Parent resultParent) {
        this.resultParent = resultParent;
    }

    public Stage getReportStage() {
        return reportStage;
    }

    public void setReportStage(Stage reportStage) {
        this.reportStage = reportStage;
    }

    public Parent getReportParent() {
        return reportParent;
    }

    public void setReportParent(Parent reportParent) {
        this.reportParent = reportParent;
    }
}
