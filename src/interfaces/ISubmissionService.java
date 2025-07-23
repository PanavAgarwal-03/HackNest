package src.interfaces;

import src.models.Problem;
import src.models.Submission;
import src.models.User;

import java.util.List;

public interface ISubmissionService {
    Submission submitSolution(User user , Problem problem , String answer);
    List<Submission> getAllSubmissions();
    List<Submission> getSubmissionsByUser(User user);
    List<Submission> getSubmissionsByProblem(Problem problem);

}
