package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.TaskDao;
import ma.enset.sdia_mini_project.dao.entities.Task;

import java.util.List;

public class TaskServiceImpl implements TaskService{
    TaskDao tDao;

    public TaskServiceImpl(TaskDao tDao) {
        this.tDao = tDao;
    }

    @Override
    public List<Task> getALl() {
        return tDao.findAll();
    }

    @Override
    public Task findById(long id) {
        return tDao.findByID(id);
    }

    @Override
    public Task add(Task a) {
        return tDao.save(a);
    }

    @Override
    public boolean delete(Task a) {
        return tDao.delete(a);
    }

    @Override
    public Task update(Task a) {
        return tDao.update(a);
    }
}
