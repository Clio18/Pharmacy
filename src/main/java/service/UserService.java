package service;
import dao.UserDAO;
import model.User;
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

    public User findUserByLoginAndPassword(String login, String password) {
       return userDAO.findUserByLoginAndPassword(login,password);
    }
}
