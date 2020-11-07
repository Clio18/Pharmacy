package service;
import dao.UserDAO;
import userInterface.User;
import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> getAll() {
        return userDAO.getAll();
    }
    public User findDrugByName(String name){
        return userDAO.findByName(name);
    }
    public User findDrugById(int id) {
        return userDAO.findById(id);
    }

    public void save(User user) {
        userDAO.save(user);
    }
}
