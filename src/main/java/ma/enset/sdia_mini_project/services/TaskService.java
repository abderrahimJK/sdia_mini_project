package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.entities.Task;

import java.util.List;

public interface TaskService {
    List<Task> getALl();
    Task findById(long id);
    Task add(Task a);
    boolean delete(Task a);
    Task update(Task a);
}
