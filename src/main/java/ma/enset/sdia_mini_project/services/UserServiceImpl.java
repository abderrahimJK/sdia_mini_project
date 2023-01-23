package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.UserDao;
import ma.enset.sdia_mini_project.dao.entities.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getALl() {
        return userDao.findAll();
    }

    @Override
    public User findById(long id) {
        return userDao.findByID(id);
    }

    @Override
    public User add(User u) {
        return userDao.save(u);
    }

    @Override
    public boolean delete(User a) {
        return false;
    }

    @Override
    public User update(User a) {
        return userDao.update(a);
    }

    @Override
    public User login(String email, String password) {
        return userDao.toLogin(email,password);
    }
}
