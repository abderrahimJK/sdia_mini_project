package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.ProjectsDao;
import ma.enset.sdia_mini_project.dao.entities.Project;

import java.util.List;

public class ProjectServiceImpl implements ProjectService{
    ProjectsDao pDao;

    public ProjectServiceImpl(ProjectsDao pDao) {
        this.pDao = pDao;
    }

    @Override
    public List<Project> getALl() {
        return pDao.findAll();
    }

    @Override
    public Project findById(long id) {
        return pDao.findByID(id);
    }

    @Override
    public Project add(Project a) {
        return pDao.save(a);
    }

    @Override
    public boolean delete(Project a) {
        return pDao.delete(a);
    }

    @Override
    public Project update(Project a) {
        return pDao.update(a);
    }
}
