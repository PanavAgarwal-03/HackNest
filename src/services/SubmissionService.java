package src.services;

import src.interfaces.ISubmissionService;
import src.models.Problem;
import src.models.Submission;
import src.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class SubmissionService implements ISubmissionService {
    private final List<Submission> submissions;
    private final AtomicInteger submissionCounter;

    public SubmissionService() {
        submissionCounter = new AtomicInteger(1);
        submissions = new ArrayList<>();
    }

    @Override
    public Submission submitSolution(User user , Problem problem , String answer){
        int submissionId = submissionCounter.getAndIncrement();
        Submission submission = new Submission(submissionId, user, problem, answer);
        submissions.add(submission);
        return submission;
    }

    @Override
    public List<Submission> getAllSubmissions(){
        return new ArrayList<>(submissions);
    }

    @Override
    public List<Submission> getSubmissionsByUser(User user){
        return submissions.stream()
                .filter(sub -> sub.getUser().getUsername().equals(user.getUsername()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Submission> getSubmissionsByProblem(Problem problem){
        return submissions.stream()
                .filter(sub -> sub.getProblem().getProblemId()==problem.getProblemId())
                .collect(Collectors.toList());
    }
}
