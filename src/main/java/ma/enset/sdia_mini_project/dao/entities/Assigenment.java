package ma.enset.sdia_mini_project.dao.entities;

import java.io.Serializable;

//classe persistante ou entité
public class Assigenment implements Serializable {
    private long id;
    private long task_ID;
    private long user_ID;

    public Assigenment() {
    }

    public Assigenment(long idI, long task_ID, long user_ID) {
        this.id = idI;
        this.task_ID = task_ID;
        this.user_ID = user_ID;
    }

    public long getIdI() {
        return id;
    }

    public void setIdI(long idI) {
        this.id = idI;
    }

    public long getTask_ID() {
        return task_ID;
    }

    public void setTask_ID(long task_ID) {
        this.task_ID = task_ID;
    }

    public long getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(long user_ID) {
        this.user_ID = user_ID;
    }
}
