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

        System.out.println("===== Welcome to HackNest Console Platform =====");

        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                try {
                    User newUser = userService.registerUser(username, password);
                    users.add(newUser); // Shared reference
                    System.out.println("User registered successfully.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                }

            } else if (choice == 2) {
                System.out.print("Username: ");
                String username = scanner.nextLine();
                System.out.print("Password: ");
                String password = scanner.nextLine();
                try {
                    User user = userService.loginUser(username, password);
                    if (user.getUsername().equals("admin")) {
                        handleAdminMenu(scanner, adminService, leaderboardService, problemService);
                    } else {
                        handleUserMenu(scanner, user, problemService, submissionService, leaderboardService);
                    }
                } catch (Exception e) {
                    System.out.println("Login failed: " + e.getMessage());
                }

            } else if (choice == 3) {
                System.out.println("Thanks for using HackNest. Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

    }
    private static void handleAdminMenu(Scanner scanner, IAdminService adminService, ILeaderboardService leaderboardService, IProblemService problemService) {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. Add Problem");
            System.out.println("2. View All Users");
            System.out.println("3. View Leaderboard");
            System.out.println("4. Back");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Description: ");
                String desc = scanner.nextLine();
                System.out.print("Difficulty (Easy/Medium/Hard): ");
                String difficulty = scanner.nextLine();
                System.out.print("Score: ");
                int score = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Expected Answer: ");
                String expectedAnswer = scanner.nextLine();

                Problem problem = new Problem(problemService.getProblems().size() + 1, title, desc, difficulty, score, expectedAnswer);
                adminService.addProblem(problem);
            } else if (choice == 2) {
                List<User> users = adminService.getUsers();
                users.forEach(u -> System.out.println(u.getUsername()));
            } else if (choice == 3) {
                leaderboardService.displayLeaderboard();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    private static void handleUserMenu(Scanner scanner,User user,IProblemService problemService,ISubmissionService submissionService,ILeaderboardService leaderboardService){
        while (true) {
            System.out.println("\n===== User Menu =====");
            System.out.println("1. View Problems");
            System.out.println("2. Submit Solution");
            System.out.println("3. View My Submissions");
            System.out.println("4. View Leaderboard");
            System.out.println("5. Back");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                for (Problem p : problemService.getProblems()) {
                    p.displayProblem();
                    System.out.println("------------------");
                }
            } else if (choice == 2) {
                System.out.print("Enter Problem ID: ");
                int pid = scanner.nextInt();
                scanner.nextLine();
                Problem p;
                try {
                    p = problemService.getProblem(pid);
                } catch (Exception e) {
                    System.out.println("Problem not found.");
                    continue;
                }

                if (user.hasSolvedProblem(pid)) {
                    System.out.println("You've already solved this problem.");
                    continue;
                }

                System.out.println("Enter your answer (simulate solution): ");
                String answer = scanner.nextLine();

                Submission s = submissionService.submitSolution(user, p, answer);
                s.printSummary();

            } else if (choice == 3) {
                List<Submission> submissions = submissionService.getSubmissionsByUser(user);
                submissions.forEach(Submission::printSummary);
            } else if (choice == 4) {
                leaderboardService.displayLeaderboard();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}