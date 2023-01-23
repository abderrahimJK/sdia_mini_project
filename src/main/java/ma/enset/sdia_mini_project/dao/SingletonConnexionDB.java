package ma.enset.sdia_mini_project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingletonConnexionDB {

    private  static Connection connection;

    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection  = DriverManager.getConnection("jdbc:mysql://localhost:3308/gestion_projets", "root", "adroot");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
