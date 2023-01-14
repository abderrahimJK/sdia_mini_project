package ma.enset.sdia_mini_project.dao;

import ma.enset.sdia_mini_project.dao.entities.Task;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TasksDaoImpl implements TaskDao {
    @Override
    public List<Task> findAll() {
        Connection connection=SingletonConnexionDB.getConnection();
        List<Task>tasks=new ArrayList<>();
        try{
            PreparedStatement pstm2=connection.prepareStatement("SELECT * FROM TASK");
            ResultSet rs= pstm2.executeQuery();
            while(rs.next()){
                Task t=new Task();
                t.setId(rs.getLong("ID"));
                t.setName(rs.getString("NAME"));
                t.setStart_Date(rs.getDate("START_DATE"));
                t.setEnd_Date(rs.getDate("END_DATE"));
                t.setAssegned_Resource(rs.getLong("ASSEGNED_RESOURCE"));
                t.setId_Project(rs.getLong("ID_PROJECT"));
                t.setState(rs.getString("STATE"));
                tasks.add(t);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    public Task findByID(long id) {
        Connection connection=SingletonConnexionDB.getConnection();
        Task t=new Task();
        try{
            PreparedStatement stm=connection.prepareStatement("SELECT * FROM TASK WHERE ID=?");
            stm.setLong(1,id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                t.setId(rs.getLong("ID"));
                t.setName(rs.getString("NAME"));
                t.setStart_Date(rs.getDate("START_DATE"));
                t.setEnd_Date(rs.getDate("END_DATE"));
                t.setAssegned_Resource(rs.getLong("ASSEGNED_RESOURCE"));
                t.setId_Project(rs.getLong("ID_PROJECT"));
                t.setState(rs.getString("STATE"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return t;
    }

    @Override
    public Task save(Task o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm3=connection.prepareStatement("INSERT INTO TASK(NAME,START_DATE,END_DATE,ASSIGNED_RESOURCE,ID_PROJT,STATE)"+"values(?,?,?,?,?))");
            pstm3.setString(1,o.getName());
            pstm3.setDate(2,o.getStart_Date());
            pstm3.setDate(3,o.getEnd_Date());
            pstm3.setLong(4,o.getAssegned_Resource());
            pstm3.setLong(5,o.getId_Project());
            pstm3.setString(6,o.getState());
            pstm3.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Task o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("DELETE FROM TASK WHERE ID=?");
            pstm.setLong(1,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Task update(Task o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("UPDATE TASK SET NAME=?,START_DATE=?,END_DATE=?,ASSEGNED_RESOURCE=?,ID_PROJECT=?,STATE=? where ID=?");
            pstm.setString(1,o.getName());
            pstm.setDate(2,o.getStart_Date());
            pstm.setDate(3,o.getEnd_Date());
            pstm.setLong(4,o.getAssegned_Resource());
            pstm.setLong(5,o.getId_Project());
            pstm.setString(6,o.getState());
            pstm.setLong(7,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }
}
