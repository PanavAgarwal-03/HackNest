package src.models;

import java.util.ArrayList;
import java.util.List;

public class User{
    private final int UserId;
    private final  String username;
    private final String password;
    private int score;
    private final List<Integer> solvedProblems;

    public User(int userId , String username,String password){
        this.UserId = userId;
        this.username = username;
        this.password = password;
        this.score = 0;
        this.solvedProblems = new ArrayList<>();
    }

    //Getters
    public List<Integer> getSolvedProblems() {
        return solvedProblems;
    }

    public int getScore() {
        return score;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public int getUserId() {
        return UserId;
    }

    //Updaters
    public void addScore(int newscore){
        this.score += newscore;
    }

    public void addSolvedProblem(int newsolved){
        if(!solvedProblems.contains(newsolved)) {
            this.solvedProblems.add(newsolved);
        }
    }
}