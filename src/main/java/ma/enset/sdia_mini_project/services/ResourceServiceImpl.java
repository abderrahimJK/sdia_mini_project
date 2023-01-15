package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.ResourceDao;
import ma.enset.sdia_mini_project.dao.entities.Resource;

import java.util.List;

public class ResourceServiceImpl implements ResourceService{
    ResourceDao rDao;

    public ResourceServiceImpl(ResourceDao rDao) {
        this.rDao = rDao;
    }

    @Override
    public List<Resource> getALl() {
        return rDao.findAll();
    }

    @Override
    public Resource findById(long id) {
        return rDao.findByID(id);
    }

    @Override
    public Resource add(Resource a) {
        return rDao.save(a);
    }

    @Override
    public boolean delete(Resource a) {
        return rDao.delete(a);
    }

    @Override
    public Resource update(Resource a) {
        return rDao.update(a);
    }
}
