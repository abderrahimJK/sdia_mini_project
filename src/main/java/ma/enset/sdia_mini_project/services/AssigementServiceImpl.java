package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.AssigementDao;
import ma.enset.sdia_mini_project.dao.entities.Assigenment;

import java.util.List;

public class AssigementServiceImpl implements AssigementService{
    AssigementDao aDao;

    public AssigementServiceImpl(AssigementDao aDao) {
        this.aDao = aDao;
    }

    @Override
    public List<Assigenment> getALl() {
        return aDao.findAll();
    }

    @Override
    public Assigenment findById(long id) {
        return aDao.findByID(id);
    }

    @Override
    public Assigenment add(Assigenment a) {
        return aDao.save(a);
    }

    @Override
    public boolean delete(Assigenment a) {
        return aDao.delete(a);
    }

    @Override
    public Assigenment update(Assigenment a) {
        return aDao.update(a);
    }
}
