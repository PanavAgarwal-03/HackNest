package src.models;

import java.time.LocalDateTime;

public class Submission {
    private final int submissionId;
    private final User user;
    private final Problem problem;
    private final String SubmittedAnswer;
    private final boolean isCorrect;
    private final int scoreAwarded;
    private  final LocalDateTime submittedAt;

    public Submission(int submissionId, User user, Problem problem, String submittedAnswer){
        this.submissionId = submissionId;
        this.user = user;
        this.problem = problem;
        this.SubmittedAnswer = submittedAnswer;
        this.isCorrect = evaluate(submittedAnswer , problem.getExpectedAnswer());
        this.scoreAwarded = isCorrect ? problem.getScore() : 0;
        this.submittedAt = LocalDateTime.now();

        if (isCorrect) {
            user.addScore(scoreAwarded);
            user.addSolvedProblem(problem.getProblemId());
        }


    }
    public boolean evaluate(String submittedAnswer, String expectedAnswer){
        return submittedAnswer.trim().equalsIgnoreCase(expectedAnswer.trim());
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public int getScoreAwarded() {
        return scoreAwarded;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getSubmittedAnswer() {
        return SubmittedAnswer;
    }

    public Problem getProblem() {
        return problem;
    }

    public User getUser() {
        return user;
    }

    public int getSubmissionId() {
        return submissionId;
    }

    public void printSummary() {
        System.out.println("Submission ID: " + submissionId);
        System.out.println("User: " + user.getUsername());
        System.out.println("Problem: " + problem.getTitle());
        System.out.println("Correct: " + (isCorrect ? "Yes" : "No"));
        System.out.println("Score Awarded: " + scoreAwarded);
        System.out.println("Submitted At: " + submittedAt);
    }
}