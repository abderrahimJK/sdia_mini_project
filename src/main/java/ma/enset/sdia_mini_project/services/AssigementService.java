package ma.enset.sdia_mini_project.services;


import ma.enset.sdia_mini_project.dao.entities.Assigenment;

import java.util.List;

public interface AssigementService {
    List<Assigenment> getALl();
    Assigenment findById(long id);
    Assigenment add(Assigenment a);
    boolean delete(Assigenment a);
    Assigenment update(Assigenment a);
}
