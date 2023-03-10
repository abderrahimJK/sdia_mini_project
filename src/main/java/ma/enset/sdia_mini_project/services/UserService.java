package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.entities.User;

import java.util.List;

public interface UserService {

    List<User> getALl();
    User findById(long id);
    User add(User a);
    boolean delete(User a);
    User update(User a);
    User login(String email, String password);
}
