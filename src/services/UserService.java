package src.services;

import src.interfaces.IUserService;
import src.models.User;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.List;

public class  UserService implements IUserService {

    private final List<User> users;
    private int userCount ;

    public UserService(){
        users = new ArrayList<>();
        userCount = 1;
    }

    @Override
    public User registerUser(String username , String password){
        User newuser = new User(userCount++,username,password);
        users.add(newuser);
        return  newuser;
    }

    @Override
    public User loginUser(String username , String password){
        for(User user : users){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return user;
            }
        }

        throw new NoSuchElementException("User not found");
    }

    @Override
    public User findUserByUsername(String username){
        for(User user : users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        throw new NoSuchElementException("User not found");
    }

}