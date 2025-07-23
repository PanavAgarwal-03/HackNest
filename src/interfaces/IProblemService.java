package src.interfaces;

import src.models.Problem;

import java.util.List;

public interface IProblemService {
    void addProblem(Problem problem);
    Problem getProblem(int problemId);
    List<Problem> getProblems();
}
