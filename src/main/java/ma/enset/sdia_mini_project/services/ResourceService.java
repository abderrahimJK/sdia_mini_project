package ma.enset.sdia_mini_project.services;

import ma.enset.sdia_mini_project.dao.entities.Resource;

import java.util.List;

public interface ResourceService {
    List<Resource> getALl();
    Resource findById(long id);
    Resource add(Resource a);
    boolean delete(Resource a);
    Resource update(Resource a);
}
