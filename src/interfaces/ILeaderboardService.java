package src.interfaces;

import src.models.User;

import java.util.List;

public interface ILeaderboardService {
    List<User> getTopUsers();
    void displayLeaderboard();

}
