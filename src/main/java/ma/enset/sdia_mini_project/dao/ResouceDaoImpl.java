package ma.enset.sdia_mini_project.dao;

import ma.enset.sdia_mini_project.dao.entities.Resource;
import ma.enset.sdia_mini_project.dao.entities.Task;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResouceDaoImpl implements ResourceDao {
    @Override
    public List<Resource> findAll() {
        Connection connection=SingletonConnexionDB.getConnection();
        List<Resource>resources=new ArrayList<>();
        try{
            PreparedStatement pstm2=connection.prepareStatement("SELECT * FROM RESOURCE");
            ResultSet rs= pstm2.executeQuery();
            while(rs.next()){
                Resource r=new Resource();
                r.setId(rs.getLong("ID"));
                r.setName(rs.getString("NAME"));
                r.setAvailability(rs.getBoolean("AVAILABILITY"));
                r.setCost(rs.getFloat("COST"));
                resources.add(r);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resources;
    }

    @Override
    public Resource findByID(long id) {
        Connection connection=SingletonConnexionDB.getConnection();
        Resource r=new Resource();
        try{
            PreparedStatement stm=connection.prepareStatement("SELECT * FROM RESOURCE WHERE ID=?");
            stm.setLong(1,id);
            ResultSet rs=stm.executeQuery();
            if(rs.next()){
                r.setId(rs.getLong("ID"));
                r.setName(rs.getString("NAME"));
                r.setAvailability(rs.getBoolean("AVAILABILITY"));
                r.setCost(rs.getFloat("COST"));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public Resource save(Resource o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm3=connection.prepareStatement("INSERT INTO RESOURCE(NAME,AVAILABILITY,COST)"+"values(?,?,?))");
            pstm3.setString(1,o.getName());
            pstm3.setBoolean(2,o.isAvailability());
            pstm3.setFloat(5,o.getCost());
            pstm3.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }

    @Override
    public boolean delete(Resource o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("DELETE FROM RESOURCE WHERE ID=?");
            pstm.setLong(1,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            return false;
        }
        return true;
    }

    @Override
    public Resource update(Resource o) {
        Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("UPDATE RESOURCE SET NAME=?,AVAILABILITY=?,COST=? WHERE ID=?");
            pstm.setString(1,o.getName());
            pstm.setBoolean(2,o.isAvailability());
            pstm.setFloat(3,o.getCost());
            pstm.setLong(4,o.getId());
            pstm.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return o;
    }
}
