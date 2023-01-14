package ma.enset.sdia_mini_project.dao;


import ma.enset.sdia_mini_project.dao.entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectsDaoImpl implements ProjectsDao {
    @Override
    public List<Project> findAll() {
        Connection connection=SingletonConnexionDB.getConnection();
        List<Project>projects=new ArrayList<>();
        try{
            PreparedStatement stm=connection.prepareStatement("select * from PROJECT");
            ResultSet rs=stm.executeQuery();
            while(rs.next()){
                Project p=new Project();
                p.setId(rs.getLong("ID"));
                p.setName(rs.getString("NAME"));
                p.setStart_Date(rs.getDate("START_DATE"));
                p.setEnd_Date(rs.getDate("END_DATE"));
                p.setState(rs.getString("STATE"));
                projects.add(p);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return projects;
    }

    @Override
    public Project findByID(long id){
        Connection connection=SingletonConnexionDB.getConnection();
        Project p=new Project();
        try{
        PreparedStatement stm=connection.prepareStatement("select * from PROJECT where ID=?");
        stm.setLong(1,id);
        ResultSet rs=stm.executeQuery();
        if(rs.next()){
            p.setId(rs.getInt("ID"));
            p.setName(rs.getString("NAME"));
            p.setStart_Date(rs.getDate("START_DATE"));
            p.setEnd_Date(rs.getDate("END_DATE"));
            p.setState(rs.getString("STATE"));
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public Project save(Project o){
                Connection connection=SingletonConnexionDB.getConnection();
        try{
                PreparedStatement pstm=connection.prepareStatement("insert into PROJECT(NAME,START_DATE,END_DATE,STATE)"+" values(?,?,?,?)");
                pstm.setString(1,o.getName());
                pstm.setDate(2,o.getStart_Date());
                pstm.setDate(3,o.getEnd_Date());
                pstm.setString(4,o.getState());
                pstm.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
                return o;

        }

    @Override
    public boolean delete(Project o){
            Connection connection=SingletonConnexionDB.getConnection();
        try{
            PreparedStatement pstm=connection.prepareStatement("delete from PROJECT where ID=?");
            pstm.setLong(1,o.getId());
            pstm.executeUpdate();
        }catch (SQLException e){
            return false;
        }
        return true;
    }
/*
    @Override
    public Project update(Project o){
                Connection connection=SingletonConnexionDB.getConnection();
        try{
                PreparedStatement pstm=connection.prepareStatement("update PROJECT set NAME=?,START_DATE=?,END_DATE=?,STATE=? where ID=?");
                pstm.setString(1,o.getNom());
                pstm.setString(2,o.getDescription());
                pstm.setFloat(3,o.getPrix());
                pstm.setInt(4,o.getQuantite());
                pstm.setInt(5,o.getId());
                pstm.executeUpdate();
            }catch(SQLException e){
                e.printStackTrace();
            }
                return o;

        }

    @Override
    public List<Produit> findProduitByMc(String mc){
                Connection connection=SingletonConnexionDB.getConnaction();
                List<Produit>produits=new ArrayList<>();
                try{
                PreparedStatement pstm=connection.prepareStatement("select * from PRODUITS where NOM like ?");
                pstm.setString(1,"%"+mc+"%");
                ResultSet rs=pstm.executeQuery();
                while(rs.next()){
                    Produit p=new Produit();
                    p.setId(rs.getInt("ID"));
                    p.setNom(rs.getString("NOM"));
                    p.setDescription(rs.getString("DESCRIPTION"));
                    p.setPrix(rs.getFloat("PRIX"));
                    p.setQuantite(rs.getInt("QUANTITE"));
                    produits.add(p);
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
                return produits;
*/
        }
}
