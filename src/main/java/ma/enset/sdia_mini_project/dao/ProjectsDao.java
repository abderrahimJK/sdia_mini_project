package ma.enset.sdia_mini_project.dao;


import ma.enset.sdia_mini_project.dao.entities.Project;

import java.util.List;

public interface ProjectsDao extends Dao<Project>{
    List<Project> findProjectByMc(String mc) ;

}
