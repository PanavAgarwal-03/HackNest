package src.services;

import src.interfaces.ILeaderboardService;
import src.models.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class LeaderboardService implements ILeaderboardService {
    private final List<User> users;

    public LeaderboardService(List<User> users) {
        this.users = users;
    }


    @Override
    public List<User> getTopUsers(){
        List<User> sorted = new ArrayList<>(users);
        sorted.sort(Comparator.comparingInt(User::getScore).reversed());
        return sorted;

    }
    @Override
    public void displayLeaderboard(){
        System.out.println("===== 🏆 Leaderboard 🏆 =====");
        List<User> sorted = getTopUsers();
        int rank = 1;
        for (User user : sorted) {
            System.out.println(rank++ + ". " + user.getUsername() + " - " + user.getScore() + " pts");
        }
        System.out.println("=============================");
    }

}
