package src.services;

import src.interfaces.IAdminService;
import src.models.Problem;
import src.models.User;

import java.util.ArrayList;
import java.util.List;

class  AdminService implements IAdminService {
    private final List<Problem> problemBank;
    private final List<User> registeredUsers;

    public AdminService(List<Problem> problemBank, List<User> registeredUsers) {
        this.problemBank = problemBank;
        this.registeredUsers = registeredUsers;
    }

    @Override
    public void addProblem(Problem problem){
        problemBank.add(problem);
        System.out.println("Problem added: " + problem.getTitle());
    }

    @Override
    public List<User> getUsers(){
            return new ArrayList<>(registeredUsers);
    }

    @Override
    public void viewLeaderboard(){
        registeredUsers.stream()
                .sorted((a, b) -> b.getScore() - a.getScore())
                .forEach(user -> System.out.println(
                        user.getUsername() + " - " + user.getScore() + " pts"
                ));

    }
}