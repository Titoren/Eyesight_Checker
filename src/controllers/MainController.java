package controllers;

import eyesightChecker.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private List<ControlContainer> controlContainers;

    private Stage currentStage;

    public static final int REPORT_CONTAINER = 0;
    public static final int INFO_CONTAINER = 1;
    public static final int INSTRUCTION_CONTAINER = 2;
    public static final int CHOOSE_MODE_CONTAINER = 3;
    public static final int GAME_MODE_ONE_CONTAINER = 4;
    public static final int RESULT_CONTAINER = 5;
    public static final int TEST_CONTAINER = 6;
    public static final int HOME_PAGE_CONTAINER = 7;
    public static final int CHOOSE_TEST_CONTAINER = 8;
    public static final int TEST_ONE_CONTAINER = 9;
    public static final int GAME_MODE_TWO_CONTAINER = 10;


    public MainController(Stage primaryStage) throws Exception {
        controlContainers = new ArrayList<>(12);

        controlContainers.add(REPORT_CONTAINER, initInfoStage());
        controlContainers.add(INFO_CONTAINER, initInfoStage());
        controlContainers.add(INSTRUCTION_CONTAINER, initInstructionStage());
        controlContainers.add(CHOOSE_MODE_CONTAINER, initChooseModeStage());
        controlContainers.add(GAME_MODE_ONE_CONTAINER, initGameMode1());
        controlContainers.add(RESULT_CONTAINER, initResultStage());
        controlContainers.add(TEST_CONTAINER, initTestStage());
        controlContainers.add(HOME_PAGE_CONTAINER, initHomeStage(primaryStage));
        controlContainers.add(CHOOSE_TEST_CONTAINER, initChooseTestStage());
        controlContainers.add(TEST_ONE_CONTAINER, initTestOneStage());
        controlContainers.add(GAME_MODE_TWO_CONTAINER, initGameModeTwo());

    }

    private ControlContainer initHomeStage(Stage primaryStage) throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/homePage.fxml"));
        Parent parent = fxmlLoader.load();

        primaryStage.setTitle("Eyesight checker");
        primaryStage.setScene(new Scene(parent));

        HomePageController controller = fxmlLoader.getController();

        currentStage = primaryStage;
        primaryStage.show();
        return new ControlContainer(parent, primaryStage, controller);
    }

    private ControlContainer initReportStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/report.fxml"));
        Parent parent = fxmlLoader.load();

        ReportController controller = fxmlLoader.getController();
        controller.getLblReportText().setText("Name: " + Main.getCurrentUser().getName() + "\n" +
                "Surname: " + Main.getCurrentUser().getSurname() + "\n" +
                "Age: " + Main.getCurrentUser().getAge() + "\n" +
                "\n--------------------------------------------------------------------------------" +
                "\n\n\t\t\t   " +
                "Result: " + Main.getCurrentUser().getRightAnswerCount() + "/" +
                Main.getCurrentUser().getAnswerCount() + " right answer.\n\n" +
                ((Main.getCurrentUser().getProblemTableRow() < 7 ) ?
                        ("You have problem in " + (Main.getCurrentUser().getProblemTableRow()) +
                                " row, please visit your doctor.") : ("You have good eyesight." +
                        ((Main.getCurrentUser().getProblemTableRow() < 10 ) ?
                                "\nBut do not forget to do regular exercises" +
                                        " for your eyes\nand from time to time check your eyesight." : ""))
        ));

        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Report");
        return new ControlContainer(parent, stage, controller);
    }

    public void externalInitTestStage() throws IOException {
        controlContainers.remove(TEST_CONTAINER);
        controlContainers.add(TEST_CONTAINER, initTestStage());
    }

    public void externalInitReportStage() throws IOException {
        controlContainers.remove(REPORT_CONTAINER);
        controlContainers.add(REPORT_CONTAINER, initReportStage());
    }

    public void externalInitGameModeOneStage() throws IOException {
        controlContainers.remove(GAME_MODE_ONE_CONTAINER);
        controlContainers.add(GAME_MODE_ONE_CONTAINER, initGameMode1());
    }
    // TODO: 19.06.17 Add external init for game mode two.

    private ControlContainer initResultStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/result.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Result");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initGameMode1() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/gameMode1.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Game mode 1");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initGameModeTwo() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/gameModeTwo.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Game mode 2");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initChooseTestStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chooseTest.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Choose test");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initTestOneStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/test1.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Test mode 1");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initChooseModeStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/chooseMode.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Choose mode");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initInstructionStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/instruction.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Instruction");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initTestStage() throws java.io.IOException {
        FXMLLoader testStageLoader = new FXMLLoader(getClass().getResource("/view/test.fxml"));
        Parent parent = testStageLoader.load();

        TestController controller = testStageLoader.getController();
        controller.getPositionLabel().setText("Write letter from " + (controller.getVPosition() + 1) +
                " row and " + (controller.getHPosition() + 1) + " column");

        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("Test");
        return new ControlContainer(parent, stage, controller);
    }

    private ControlContainer initInfoStage() throws java.io.IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/userInfo.fxml"));
        Parent parent = fxmlLoader.load();
        BasicController controller = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(parent));
        stage.setTitle("User Info");
        return new ControlContainer(parent, stage, controller);
    }

    public void switchToStage(int newStage) {
        currentStage.hide();
        currentStage = controlContainers.get(newStage).getStage();
        currentStage.show();
    }

    public List<ControlContainer> getControlContainers() {
        return controlContainers;
    }

    public Stage getCurrentStage() {
        return currentStage;
    }


}
