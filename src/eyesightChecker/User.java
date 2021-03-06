package eyesightChecker;

/**
 * Created by richard on 13.06.17.
 */
public class User {
    private String name;
    private String surname;
    private int age;

    private int answerCount;
    private int rightAnswerCount;
    private int problemTableRow;

    public User(String name, String surname, int age, int answerCount,
                int rightAnswerCount, int problemTableRow) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.answerCount = answerCount;
        this.rightAnswerCount = rightAnswerCount;
        this.problemTableRow = problemTableRow;
    }

    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getRightAnswerCount() {
        return rightAnswerCount;
    }

    public void setRightAnswerCount(int rightAnswerCount) {
        this.rightAnswerCount = rightAnswerCount;
    }

    public int getProblemTableRow() {
        return problemTableRow;
    }

    public void setProblemTableRow(int problemTableRow) {
        this.problemTableRow = problemTableRow;
    }
}
