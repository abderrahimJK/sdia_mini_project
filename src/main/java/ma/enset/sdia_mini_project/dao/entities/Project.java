package ma.enset.sdia_mini_project.dao.entities;

import java.io.Serializable;
import java.sql.Date;

//classe persistante ou entité
public class Project implements Serializable {
    private long id;
    private String name;
    private Date start_Date;
    private Date end_Date;
    private String state;

    public Project() {
    }

    public Project(long id, String nom, Date start_Date, Date end_Date, String state) {
        this.id = id;
        this.name = nom;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = this.state;
    }
}
