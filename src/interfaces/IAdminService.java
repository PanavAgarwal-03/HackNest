package src.interfaces;


import src.models.Problem;
import src.models.User;

import java.util.List;

public interface IAdminService {
    void addProblem(Problem problem);
    List<User> getUsers();
    void viewLeaderboard();

}
