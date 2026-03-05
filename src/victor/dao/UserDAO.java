package victor.dao;

import victor.model.User;
import java.util.List;

public interface UserDAO {
    void save(User user);
    User findById(Integer id);
    List<User> findAll();
    Integer update(User user);
    void deleteById(Integer id);
}
