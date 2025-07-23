package src;

import src.models.*;
import src.services.*;
import src.interfaces.*;

import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Shared data stores
        List<User> users = new ArrayList<>();
        List<Problem> problems = new ArrayList<>();

        // Initialize services
        IUserService userService = new UserService();
        IAdminService adminService = new AdminService(problems, users);
        IProblemService problemService = new ProblemService();
        ISubmissionService submissionService = new SubmissionService();
        ILeaderboardService leaderboardService = new LeaderboardService(users);


    }
}