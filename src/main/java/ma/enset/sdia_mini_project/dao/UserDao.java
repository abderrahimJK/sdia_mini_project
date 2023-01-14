package ma.enset.sdia_mini_project.dao;

import ma.enset.sdia_mini_project.dao.entities.User;

public interface UserDao extends Dao<User>{
    User toLogin(String email, String password);
}
