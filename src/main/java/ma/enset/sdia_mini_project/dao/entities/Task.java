package ma.enset.sdia_mini_project.dao.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

//classe persistante ou entité
public class Task implements Serializable {
    private long id;
    private long id_Project;
    private String name;
    private Date start_Date;
    private Date end_Date;
    private long assegned_Resource;
    private String state;

    public Task() {
    }

    public Task(long id, String name, Date start_Date, Date end_Date, long assegned_Resource, String state, long id_Project) {
        this.id = id;
        this.id_Project = id_Project;
        this.name = name;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
        this.assegned_Resource = assegned_Resource;
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

    public long getAssegned_Resource() {
        return assegned_Resource;
    }

    public void setAssegned_Resource(long assegned_Resource) {
        this.assegned_Resource = assegned_Resource;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getId_Project() {
        return id_Project;
    }

    public void setId_Project(Long id_Project) {
        this.id_Project = id_Project;
    }

    public void setId_Project(long id_Project) {
        this.id_Project = id_Project;
    }
}
