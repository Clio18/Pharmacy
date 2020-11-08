package dao;
import exception.UserNotFoundException;
import userInterface.User;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserDAO implements Dao<User> {
    private List<User> userList = new ArrayList<>();
    private static int counter = 0;

    public UserDAO() {
    }

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException();
        }
        counter++;
        user.setId(counter);
        userList.add(user);
        try {
            return (User) user.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User findById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                try {
                    return (User) user.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        for (User user : userList) {
            try {
                users.add((User) user.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        return users;
    }


    @Override
    public void update(User user) {
        User userForUpdate = null;
        for (User u : userList) {
            if (u.getId() == user.getId()) {
                userForUpdate = u;
            }
        }

        if (userForUpdate == null) {
            throw new UserNotFoundException();
        }
        userForUpdate.setName(user.getName());
        userForUpdate.setFamilyName(user.getFamilyName());
        userForUpdate.setLogin(user.getLogin());
        userForUpdate.setEmail(user.getEmail());
        userForUpdate.setAddress(user.getAddress());
        userForUpdate.setPhoneNumber(user.getPhoneNumber());
        userForUpdate.setPassword(user.getPassword());
    }

    @Override
    public boolean delete(int id) {
        boolean flag = false;
        Iterator<User> iterator = userList.iterator();
        while (iterator.hasNext()) {
            int idForRemove = iterator.next().getId();
            if (idForRemove == id) {
                iterator.remove();
                flag = true;
            }
        }
        return flag;
    }


    public User findByName(String name) {
         for (User user : userList) {
            if (user.getName().equals(name)) {
                try {
                    return  (User) user.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;

    }

    public User findUserByLoginAndPassword(String login, String password) {
        for (User user:userList){
            if (user.getLogin().equals(login)&&user.getPassword().equals(password)){
                try {
                    return (User) user.clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
