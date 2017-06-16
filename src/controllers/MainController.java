package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController {

    private Stage currentStage;

    private Stage homePageStage;
    private Parent homePageParent;

    private Stage userInfoStage = new Stage();
    private Parent userInfoParent;

    private Stage instructionStage = new Stage();
    private Parent instructionParent;

    private Stage testStage = new Stage();
    private Parent testParent;

    private Stage chooseModeStage = new Stage();
    private Parent chooseModeParent;

    private Stage gameMode1Stage = new Stage();
    private Parent gameMode1Parent;

    private Stage resultStage = new Stage();
    private Parent resultParent;

    private Stage reportStage = new Stage();
    private Parent reportParent;

    public MainController(Stage primaryStage) throws Exception {

//        initStage("User Info", "/view/userInfo.fxml", userInfoParent, userInfoStage);
//
//        initStage("Report", "/view/report.fxml", reportParent, reportStage);
//
//        initStage("Result", "/view/result.fxml", resultParent, resultStage);


//        initReportStage();

        initInfoStage();

        initInstructionStage();

        initChooseModeStage();

        initGameMode1();

        initResultStage();

        initTestStage();

        homePageParent = FXMLLoader.load(getClass().getResource("/view/homePage.fxml"));
        primaryStage.setTitle("Eyesight checker");
        primaryStage.setScene(new Scene(homePageParent));
        homePageStage = primaryStage;
        currentStage = primaryStage;
        primaryStage.show();
    }

    public void initReportStage() throws java.io.IOException {
        FXMLLoader reportStageLoader = new FXMLLoader(getClass().getResource("/view/report.fxml"));
        reportParent = reportStageLoader.load();

        ReportController reportController = reportStageLoader.getController();
        reportController.getLblReportText().setText("Name: " + Main.getCurrentUser().getName() + "\n" +
                "Surname: " + Main.getCurrentUser().getSurname() + "\n" +
                "Age: " + Main.getCurrentUser().getAge() + "\n" +
                "\n--------------------------------------------------------------------------------" +
                "\n\n\t\t\t\t     " +
                "Result: " + Main.getCurrentUser().getRightAnswerCount() + "/" +
                Main.getCurrentUser().getAnswerCount()
        );

        reportStage = new Stage();
        reportStage.setScene(new Scene(reportParent));
        reportStage.setTitle("Report");
    }

    public void initResultStage() throws java.io.IOException {
        FXMLLoader resultStageLoader = new FXMLLoader(getClass().getResource("/view/result.fxml"));
        resultParent = resultStageLoader.load();
        resultStage = new Stage();
        resultStage.setScene(new Scene(resultParent));
        resultStage.setTitle("Result");
    }

    public void initGameMode1() throws java.io.IOException {
        gameMode1Parent = FXMLLoader.load((getClass().getResource("/view/gameMode1.fxml")));
        gameMode1Stage = new Stage();
        gameMode1Stage.setScene(new Scene(gameMode1Parent));
        gameMode1Stage.setTitle("Game mode 1");
    }

    public void initChooseModeStage() throws java.io.IOException {
        chooseModeParent = FXMLLoader.load((getClass().getResource("/view/chooseMode.fxml")));
        chooseModeStage = new Stage();
        chooseModeStage.setScene(new Scene(chooseModeParent));
        chooseModeStage.setTitle("Choose mode");
    }

    public void initInstructionStage() throws java.io.IOException {
        instructionParent = FXMLLoader.load((getClass().getResource("/view/instruction.fxml")));
        instructionStage = new Stage();
        instructionStage.setScene(new Scene(instructionParent));
        instructionStage.setTitle("Instruction");
    }

    public void initTestStage() throws java.io.IOException {
        FXMLLoader testStageLoader = new FXMLLoader(getClass().getResource("/view/test.fxml"));
        testParent = testStageLoader.load();

        TestController testController = testStageLoader.getController();
        testController.getPositionLabel().setText("Write letter from " + testController.getvPosition() +
                " row and " + testController.gethPosition() + " column");

        testStage = new Stage();
        testStage.setScene(new Scene(testParent));
        testStage.setTitle("Test");
    }


    // TODO: 14.06.17 Optimize methods
    public void initStage(String title, String path, Parent parent, Stage stage) throws java.io.IOException {
        FXMLLoader stageLoader = new FXMLLoader(getClass().getResource(path));
        parent = stageLoader.load();

        stage.setScene(new Scene(parent));
        stage.setTitle(title);
    }

    public void initInfoStage() throws java.io.IOException {
        userInfoParent = FXMLLoader.load((getClass().getResource("/view/userInfo.fxml")));
        userInfoStage = new Stage();
        userInfoStage.setScene(new Scene(userInfoParent));
        userInfoStage.setTitle("User Info");
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
