package src.services;

import src.interfaces.IProblemService;
import src.models.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ProblemService implements IProblemService {
    private List<Problem> problems;

    @Override
    public void addProblem(Problem problem){
        problems.add(problem);
    }
    public Problem getProblem(int problemId){
        for(Problem problem : getProblems()){
            if(problem.getProblemId() == problemId){
                return problem;
            }
        }
        throw new NoSuchElementException("Problem with ID " + problemId + " not found.");

    }
    public List<Problem> getProblems(){
        return new ArrayList<>(problems);
    }
}