package ma.enset.sdia_mini_project.dao;

import ma.enset.sdia_mini_project.dao.UserDao;
import ma.enset.sdia_mini_project.dao.entities.Project;
import ma.enset.sdia_mini_project.dao.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findByID(long id) {
        Connection connection=SingletonConnexionDB.getConnection();
        User user = new User();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from USER where ID=?");
            stm.setLong(1,id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                user.setId(rs.getLong("ID"));
                user.setF_Name(rs.getString("F_NAME"));
                user.setF_Name(rs.getString("L_NAME"));
                user.setF_Name(rs.getString("EMAIL"));
                user.setF_Name(rs.getString("PASSWORD"));
                user.setF_Name(rs.getString("ROLE"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User save(User u) {
        try{
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO USER(F_NAME, L_NAME, EMAIL,PASSWORD, PHONE_NUMBER, ROLE) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1,u.getF_Name());
            preparedStatement.setString(2,u.getL_Name());
            preparedStatement.setString(3,u.getEmail());
            preparedStatement.setString(4,u.getPassword());
            preparedStatement.setString(5,u.getPhone());
            preparedStatement.setString(6,u.getRole());
            preparedStatement.executeUpdate();
            return u;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(User o) {
        return false;
    }

    @Override
    public User update(User o) {
        return null;
    }

    @Override
    public User toLogin(String email, String password) {
        Connection connection=SingletonConnexionDB.getConnection();
        User user = new User();
        try{
            PreparedStatement stm=connection.prepareStatement("SELECT * FROM USER where EMAIL=? AND PASSWORD=?");
            stm.setString(1,email);
            stm.setString(2,password);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                user.setId(rs.getLong("ID"));
                user.setF_Name(rs.getString("F_NAME"));
                user.setL_Name(rs.getString("L_NAME"));
                user.setEmail(rs.getString("EMAIL"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setRole(rs.getString("ROLE"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}
