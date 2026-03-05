package victor.service;

import victor.dao.UserDAO;
import victor.model.User;

import java.util.List;

public class UserService{
    private final UserDAO userRepository;

    public UserService(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public void updateInfo(User user) {
        userRepository.update(user);
    }

    public void remove(Integer id) {
        userRepository.deleteById(id);
    }
}
