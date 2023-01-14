package ma.enset.sdia_mini_project.dao.entities;

import java.io.Serializable;

//classe persistante ou entité
public class User implements Serializable {
    private long id;
    private String f_Name;
    private String l_Name;
    private String password;
    private String role;
    private String email;

    public User() {
    }

    public User(long id, String f_Name, String l_Name, String password, String role,String email) {
        this.id = id;
        this.f_Name = f_Name;
        this.l_Name = l_Name;
        this.password = password;
        this.role = role;
        this.email=email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_Name() {
        return f_Name;
    }

    public void setF_Name(String f_Name) {
        this.f_Name = f_Name;
    }

    public String getL_Name() {
        return l_Name;
    }

    public void setL_Name(String l_Name) {
        this.l_Name = l_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
