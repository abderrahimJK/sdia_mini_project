package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.entities.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getALl();
    Project findById(long id);
    Project add(Project a);
    boolean delete(Project a);
    Project update(Project a);
}
