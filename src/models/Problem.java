package src.models;

public class Problem {
    private final int problemId;
    private final String title;
    private final String description;
    private final String difficulty;
    private final int score;
    private final String expectedAnswer;

    Problem(int problemId, String title, String description, String difficulty, int score, String expectedAnswer) {
        this.problemId = problemId;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.score = score;
        this.expectedAnswer = expectedAnswer;
    }

    //Getters


    public String getExpectedAnswer() {
        return expectedAnswer;
    }

    public int getScore() {
        return score;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public int getProblemId() {
        return problemId;
    }

    public void displayProblem() {
        System.out.println("Problem ID: " + problemId);
        System.out.println("Title: " + title);
        System.out.println("Difficulty: " + difficulty);
        System.out.println("Score: " + score);
        System.out.println("Description:\n" + description);
    }
}