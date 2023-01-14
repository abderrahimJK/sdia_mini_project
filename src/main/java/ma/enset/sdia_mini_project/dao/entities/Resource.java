package ma.enset.sdia_mini_project.dao.entities;

import java.io.Serializable;
import java.sql.Time;

//classe persistante ou entité
public class Resource implements Serializable {
    private int id;
    private String name;
    private boolean availability;
    private float cost;

    public Resource() {
    }


    public Resource(int id, String name, boolean availability, float cost) {
        this.id = id;
        this.name = name;
        this.availability = availability;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
