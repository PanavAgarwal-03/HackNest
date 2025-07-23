package src.interfaces;
import src.models.User;

public interface IUserService {
    User registerUser(String username , String password);
    User loginUser(String username , String password);
    User findUserByUsername(String username);
}
